import args.MacroArgs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Macro {

    public static void main(String[] args) throws Exception {

        Macro macro = new Macro();

        JFrame frame = new JFrame("매크로 v1"); // 프레임
        MacroArgs mArgs = new MacroArgs();  // 설정 값 객체

        frame.setSize(400, 450);    // 프레임 사이즈

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // 창 종료시 프로그램 종료
        frame.setLocationRelativeTo(null);  // 화면 모니터 가운데에 노출
        frame.getContentPane().setLayout(null); // 레이아웃 설정
        frame.setResizable(false);  // 창 사이즈 조절 고정
        frame.getContentPane().setBackground(Color.BLACK);   // 프레임 색상

        /* ==================== 첫번째 마우스 영역 ==================== */

        /* 첫번째 좌표 라벨 1-1 */
        JLabel accessLbl11 = new JLabel("첫번째 마우스 좌표 설정 (F6)");
        accessLbl11.setBounds(10, 20, 200, 30);
        accessLbl11.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        accessLbl11.setForeground(Color.RED);
        frame.getContentPane().add(accessLbl11);

        /* 첫번째 좌표 값 노출*/
        JLabel firstMouseXY = new JLabel();
        firstMouseXY.setBounds(210, 20, 60, 30);
        firstMouseXY.setText(mArgs.getFirstMouseX() + "," + mArgs.getFirstMouseY());
        firstMouseXY.setHorizontalAlignment(SwingConstants.RIGHT); // 우측정렬
        firstMouseXY.setForeground(Color.RED);
        frame.getContentPane().add(firstMouseXY);

        /* 첫번째 클릭 횟수 라벨 1-2 */
        JLabel accessLbl12 = new JLabel("첫번째 마우스 클릭 횟수 입력");
        accessLbl12.setBounds(10, 45, 200, 30);
        accessLbl12.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        accessLbl12.setForeground(Color.RED);
        frame.getContentPane().add(accessLbl12);

        /* 마우스 클릭 횟수 입력 */
        JTextField accessInput11 = new JTextField();
        accessInput11.setBounds(210, 51, 60, 20);
        accessInput11.setFocusable(true); // 인풋 포커스
        accessInput11.setHorizontalAlignment(SwingConstants.RIGHT); // 글자 우측 정렬
        accessInput11.setForeground(Color.RED);
        frame.getContentPane().add(accessInput11);

        /* 초 1-2-1 */
        JLabel accessLbl121 = new JLabel("초");
        accessLbl121.setBounds(270, 49, 15, 30);
        accessLbl121.setFont(new Font("맑은 고딕", Font.BOLD, 10));
        accessLbl121.setForeground(Color.RED);
        frame.getContentPane().add(accessLbl121);

        /* 첫번째 설정 적용 버튼 */
        JButton accessBtn11 = new JButton("적용");
        accessBtn11.setBounds(290, 50, 60, 20);
        accessBtn11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mArgs.setFirstClickCnt(Integer.parseInt(accessInput11.getText()));

            }
        });
        frame.getContentPane().add(accessBtn11);

        /* 첫번째 클릭 간격 라벨 1-3 */
        JLabel accessLbl13 = new JLabel("첫번째 마우스 클릭 간격 입력");
        accessLbl13.setBounds(10, 70, 200, 30);
        accessLbl13.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        accessLbl13.setForeground(Color.RED);
        frame.getContentPane().add(accessLbl13);

        /* 마우스 클릭 횟수 입력 */
        JTextField accessInput13 = new JTextField();
        accessInput13.setBounds(210, 76, 60, 20);
        accessInput13.setFocusable(true); // 인풋 포커스
        accessInput13.setHorizontalAlignment(SwingConstants.RIGHT); // 글자 우측 정렬
        accessInput13.setForeground(Color.RED);
        frame.getContentPane().add(accessInput13);

        /* 초 1-2-2 */
        JLabel accessLbl122 = new JLabel("초");
        accessLbl122.setBounds(270, 75, 15, 30);
        accessLbl122.setFont(new Font("맑은 고딕", Font.BOLD, 10));
        accessLbl122.setForeground(Color.RED);
        frame.getContentPane().add(accessLbl122);

        /* 첫번째 설정 적용 버튼 */
        JButton accessBtn12 = new JButton("적용");
        accessBtn12.setBounds(290, 76, 60, 20);
        accessBtn12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mArgs.setFirstDelayTime(Integer.parseInt(accessInput13.getText()));

            }
        });
        frame.getContentPane().add(accessBtn12);

        /* 첫번째 좌표 값 저장 */
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if(e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_F6) {
                    Point mousePos = MouseInfo.getPointerInfo().getLocation();

                    int mouseX = mousePos.x;
                    int mouseY = mousePos.y;

                    mArgs.setFirstMouseX(mouseX);
                    mArgs.setFirstMouseY(mouseY);

                    firstMouseXY.setText(mArgs.getFirstMouseX() + "," + mArgs.getFirstMouseY());
                }
                return false;
            }
        });

        /* ==================== 두번째 마우스 영역 ==================== */

        /* 두번째 좌표 라벨 2-1 */
        JLabel accessLbl21 = new JLabel("두번째 마우스 좌표 설정 (F7)");
        accessLbl21.setBounds(10, 150, 200, 30);
        accessLbl21.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        accessLbl21.setForeground(Color.RED);
        frame.getContentPane().add(accessLbl21);

        /* 두번째 좌표 값 노출*/
        JLabel SecondMouseXY = new JLabel();
        SecondMouseXY.setBounds(210, 150, 60, 30);
        SecondMouseXY.setText(mArgs.getFirstMouseX() + "," + mArgs.getFirstMouseY());
        SecondMouseXY.setHorizontalAlignment(SwingConstants.RIGHT); // 우측정렬
        SecondMouseXY.setForeground(Color.RED);
        frame.getContentPane().add(SecondMouseXY);

        /* 두번째 클릭 횟수 라벨 2-2 */
        JLabel accessLbl22 = new JLabel("두번째 마우스 클릭 횟수 입력");
        accessLbl22.setBounds(10, 175, 200, 30);
        accessLbl22.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        accessLbl22.setForeground(Color.RED);
        frame.getContentPane().add(accessLbl22);

        /* 마우스 클릭 횟수 입력 */
        JTextField accessInput21 = new JTextField();
        accessInput21.setBounds(210, 182, 60, 20);
        accessInput21.setFocusable(true); // 인풋 포커스
        accessInput21.setHorizontalAlignment(SwingConstants.RIGHT); // 글자 우측 정렬
        accessInput21.setForeground(Color.RED);
        frame.getContentPane().add(accessInput21);

        /* 초 2-2-1 */
        JLabel accessLbl221 = new JLabel("초");
        accessLbl221.setBounds(270, 182, 15, 30);
        accessLbl221.setFont(new Font("맑은 고딕", Font.BOLD, 10));
        accessLbl221.setForeground(Color.RED);
        frame.getContentPane().add(accessLbl221);

        /* 두번째 설정 적용 버튼 */
        JButton accessBtn21 = new JButton("적용");
        accessBtn21.setBounds(290, 182, 60, 20);
        accessBtn21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mArgs.setSecondClickCnt(Integer.parseInt(accessInput21.getText()));

            }
        });
        frame.getContentPane().add(accessBtn21);

        /* 두번째 클릭 간격 라벨 2-3 */
        JLabel accessLbl23 = new JLabel("두번째 마우스 클릭 간격 입력");
        accessLbl23.setBounds(10, 203, 200, 30);
        accessLbl23.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        accessLbl23.setForeground(Color.RED);
        frame.getContentPane().add(accessLbl23);

        /* 마우스 클릭 횟수 입력 */
        JTextField accessInput23 = new JTextField();
        accessInput23.setBounds(210, 208, 60, 20);
        accessInput23.setFocusable(true); // 인풋 포커스
        accessInput23.setHorizontalAlignment(SwingConstants.RIGHT); // 글자 우측 정렬
        accessInput23.setForeground(Color.RED);
        frame.getContentPane().add(accessInput23);

        /* 초 2-2-2 */
        JLabel accessLbl222 = new JLabel("초");
        accessLbl222.setBounds(270, 208, 15, 30);
        accessLbl222.setFont(new Font("맑은 고딕", Font.BOLD, 10));
        accessLbl222.setForeground(Color.RED);
        frame.getContentPane().add(accessLbl222);

        /* 두번째 설정 적용 버튼 */
        JButton accessBtn22 = new JButton("적용");
        accessBtn22.setBounds(290, 208, 60, 20);
        accessBtn22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mArgs.setSecondDelayTime(Integer.parseInt(accessInput23.getText()));

            }
        });
        frame.getContentPane().add(accessBtn22);

        /* 두번째 좌표 값 저장 */
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if(e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_F7) {
                    Point mousePos = MouseInfo.getPointerInfo().getLocation();

                    int mouseX = mousePos.x;
                    int mouseY = mousePos.y;

                    mArgs.setSecondMouseX(mouseX);
                    mArgs.setSecondMouseY(mouseY);

                    SecondMouseXY.setText(mArgs.getSecondMouseX() + "," + mArgs.getSecondMouseY());
                }
                return false;
            }
        });

        /* 실행버튼 단축키 F8 눌렀을 때 */
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if(e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_F8) {
                    System.out.println("단축키 버튼 눌림\n");

                    System.out.println("첫번째 좌표: " + mArgs.getFirstMouseX() + "," + mArgs.getFirstMouseY());
                    System.out.println("첫번째 클릭 횟수 시간: " + mArgs.getFirstClickCnt());
                    System.out.println("첫번째 클릭 딜레이 시간: " + mArgs.getFirstDelayTime());
                    System.out.println("두번째 좌표: " + mArgs.getSecondMouseX() + "," + mArgs.getSecondMouseY());
                    System.out.println("두번째 클릭 횟수: " + mArgs.getSecondClickCnt());
                    System.out.println("두번째 클릭 딜레이 시간: " + mArgs.getSecondDelayTime());

                    // 매크로 시작
                    try {
                        if(!mArgs.getRunning()) {
                            mArgs.setRunning(true);
                            macro.activeMacro(mArgs);
                        } else {
                            mArgs.setRunning(false);
                        }
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
                return false;
            }
        });

        /* 멈춤버튼 단축키 F9 눌렀을 때 */
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if(e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_F9) {
                    System.out.println("멈춤 버튼 눌림\n");

                    // 매크로 멈춤
                    mArgs.setRunning(false);
                  
                }
                return false;
            }
        });
        frame.setVisible(true);
    }

    /* 매크로 동작 */
    private void activeMacro(MacroArgs mArgs) throws Exception {
    
        Robot robot = new Robot();  // 매크로 기능

        System.out.println("상태: " + mArgs.getRunning());

        while (mArgs.getRunning()) {
            System.out.println("첫번째 동작 시작");

            // 첫번째 좌표로 움직이기
            robot.mouseMove(mArgs.getFirstMouseX(), mArgs.getFirstMouseY());

            // 첫번째 클릭 횟수 만큼 클릭
            for (int i = 0; i < mArgs.getFirstClickCnt(); i++) {
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // 클릭
                Thread.sleep(100); // 0.1 초 딜레이
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // 클릭 해제
                Thread.sleep(mArgs.getFirstDelayTime() * 1000); // 초를 밀리초로 변환
            }
            System.out.println("첫번째 동작 종료");

            // 첫번째와 두번째 사이의 시간 간격 설정
            mArgs.setAllDelayTime(1);
            Thread.sleep(mArgs.getAllDelayTime() * 1000);

            // 두번째 좌표로 움직이기
            robot.mouseMove(mArgs.getSecondMouseX(), mArgs.getSecondMouseY());
            System.out.println("두번째로 움직임: " + mArgs.getSecondMouseX() + "," + mArgs.getSecondMouseY());

            System.out.println("두번째 동작 시작");
            // 두번째 클릭 회수 만큼 동작
            for (int i = 0; i < mArgs.getSecondClickCnt(); i++) {
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                Thread.sleep(100);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                Thread.sleep(mArgs.getSecondDelayTime() * 1000);
            }

            System.out.println("두번째 동작 종료");

            Thread.sleep(mArgs.getAllDelayTime() * 1000);
        }
    }

}
