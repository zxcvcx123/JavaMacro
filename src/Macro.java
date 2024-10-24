import args.MacroArgs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Macro {

    private static ExecutorService executor = Executors.newSingleThreadExecutor(); // 백그라운드 스레드 풀
    private static volatile boolean running = false; // 매크로 실행 상태 플래그
    private static Color bgColor = Color.PINK;  // 프레임 배경 색
    private static Color ftColor = Color.BLACK; // 폰트 색상

    public static void main(String[] args) throws Exception {

        JFrame frame = new JFrame("매크로 v2"); // 프레임
        MacroArgs mArgs = new MacroArgs();  // 설정 값 객체

        frame.setSize(350, 450);    // 프레임 사이즈

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // 창 종료시 프로그램 종료
        frame.setLocationRelativeTo(null);  // 화면 모니터 가운데에 노출
        frame.getContentPane().setLayout(null); // 레이아웃 설정
        frame.setResizable(false);  // 창 사이즈 조절 고정
        frame.getContentPane().setBackground(bgColor);   // 프레임 색상

        /* ==================== 첫번째 마우스 영역 ==================== */

        /* 첫번째 좌표 라벨 1-1 */
        JLabel accessLbl11 = new JLabel("첫번째 마우스 좌표 설정 (F6)");
        accessLbl11.setBounds(10, 20, 200, 30);
        accessLbl11.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        accessLbl11.setForeground(ftColor);
        frame.getContentPane().add(accessLbl11);

        /* 첫번째 좌표 값 노출*/
        JLabel firstMouseXY = new JLabel();
        firstMouseXY.setBounds(210, 20, 60, 30);
        firstMouseXY.setText(mArgs.getFirstMouseX() + "," + mArgs.getFirstMouseY());
        firstMouseXY.setHorizontalAlignment(SwingConstants.RIGHT); // 우측정렬
        firstMouseXY.setForeground(ftColor);
        frame.getContentPane().add(firstMouseXY);

        /* 첫번째 클릭 횟수 라벨 1-2 */
        JLabel accessLbl12 = new JLabel("첫번째 마우스 클릭 횟수 입력");
        accessLbl12.setBounds(10, 45, 200, 30);
        accessLbl12.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        accessLbl12.setForeground(ftColor);
        frame.getContentPane().add(accessLbl12);

        /* 마우스 클릭 횟수 입력 */
        JTextField accessInput11 = new JTextField();
        accessInput11.setBounds(210, 51, 60, 20);
        accessInput11.setFocusable(true); // 인풋 포커스
        accessInput11.setHorizontalAlignment(SwingConstants.RIGHT); // 글자 우측 정렬
        accessInput11.setForeground(ftColor);
        frame.getContentPane().add(accessInput11);

        /* 초 1-2-1 */
        JLabel accessLbl121 = new JLabel("번");
        accessLbl121.setBounds(270, 49, 15, 30);
        accessLbl121.setFont(new Font("맑은 고딕", Font.BOLD, 10));
        accessLbl121.setForeground(ftColor);
        frame.getContentPane().add(accessLbl121);

        /* 첫번째 설정 적용 버튼 */
       /* JButton accessBtn11 = new JButton("적용");
        accessBtn11.setBounds(290, 50, 60, 20);
        accessBtn11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mArgs.setFirstClickCnt(Integer.parseInt(accessInput11.getText()));

            }
        });
        frame.getContentPane().add(accessBtn11);*/

        /* 첫번째 클릭 간격 라벨 1-3 */
        JLabel accessLbl13 = new JLabel("첫번째 마우스 클릭 간격 입력");
        accessLbl13.setBounds(10, 70, 200, 30);
        accessLbl13.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        accessLbl13.setForeground(ftColor);
        frame.getContentPane().add(accessLbl13);

        /* 마우스 클릭 횟수 입력 */
        JTextField accessInput13 = new JTextField();
        accessInput13.setBounds(210, 76, 60, 20);
        accessInput13.setFocusable(true); // 인풋 포커스
        accessInput13.setHorizontalAlignment(SwingConstants.RIGHT); // 글자 우측 정렬
        accessInput13.setForeground(ftColor);
        frame.getContentPane().add(accessInput13);

        /* 초 1-2-2 */
        JLabel accessLbl122 = new JLabel("초");
        accessLbl122.setBounds(270, 75, 15, 30);
        accessLbl122.setFont(new Font("맑은 고딕", Font.BOLD, 10));
        accessLbl122.setForeground(ftColor);
        frame.getContentPane().add(accessLbl122);

        /* 첫번째 설정 적용 버튼 */
/*        JButton accessBtn12 = new JButton("적용");
        accessBtn12.setBounds(290, 76, 60, 20);
        accessBtn12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mArgs.setFirstDelayTime(Integer.parseInt(accessInput13.getText()));

            }
        });
        frame.getContentPane().add(accessBtn12);*/

        /* 첫번째 좌표 값 저장 */
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_F6) {
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
        accessLbl21.setForeground(ftColor);
        frame.getContentPane().add(accessLbl21);

        /* 두번째 좌표 값 노출*/
        JLabel SecondMouseXY = new JLabel();
        SecondMouseXY.setBounds(210, 150, 60, 30);
        SecondMouseXY.setText(mArgs.getFirstMouseX() + "," + mArgs.getFirstMouseY());
        SecondMouseXY.setHorizontalAlignment(SwingConstants.RIGHT); // 우측정렬
        SecondMouseXY.setForeground(ftColor);
        frame.getContentPane().add(SecondMouseXY);

        /* 두번째 클릭 횟수 라벨 2-2 */
        JLabel accessLbl22 = new JLabel("두번째 마우스 클릭 횟수 입력");
        accessLbl22.setBounds(10, 175, 200, 30);
        accessLbl22.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        accessLbl22.setForeground(ftColor);
        frame.getContentPane().add(accessLbl22);

        /* 마우스 클릭 횟수 입력 */
        JTextField accessInput21 = new JTextField();
        accessInput21.setBounds(210, 182, 60, 20);
        accessInput21.setFocusable(true); // 인풋 포커스
        accessInput21.setHorizontalAlignment(SwingConstants.RIGHT); // 글자 우측 정렬
        accessInput21.setForeground(ftColor);
        frame.getContentPane().add(accessInput21);

        /* 초 2-2-1 */
        JLabel accessLbl221 = new JLabel("번");
        accessLbl221.setBounds(270, 182, 15, 30);
        accessLbl221.setFont(new Font("맑은 고딕", Font.BOLD, 10));
        accessLbl221.setForeground(ftColor);
        frame.getContentPane().add(accessLbl221);

        /* 두번째 설정 적용 버튼 */
        /*JButton accessBtn21 = new JButton("적용");
        accessBtn21.setBounds(290, 182, 60, 20);
        accessBtn21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mArgs.setSecondClickCnt(Integer.parseInt(accessInput21.getText()));

            }
        });
        frame.getContentPane().add(accessBtn21);*/

        /* 두번째 클릭 간격 라벨 2-3 */
        JLabel accessLbl23 = new JLabel("두번째 마우스 클릭 간격 입력");
        accessLbl23.setBounds(10, 203, 200, 30);
        accessLbl23.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        accessLbl23.setForeground(ftColor);
        frame.getContentPane().add(accessLbl23);

        /* 마우스 클릭 횟수 입력 */
        JTextField accessInput23 = new JTextField();
        accessInput23.setBounds(210, 208, 60, 20);
        accessInput23.setFocusable(true); // 인풋 포커스
        accessInput23.setHorizontalAlignment(SwingConstants.RIGHT); // 글자 우측 정렬
        accessInput23.setForeground(ftColor);
        frame.getContentPane().add(accessInput23);

        /* 초 2-2-2 */
        JLabel accessLbl222 = new JLabel("초");
        accessLbl222.setBounds(270, 208, 15, 30);
        accessLbl222.setFont(new Font("맑은 고딕", Font.BOLD, 10));
        accessLbl222.setForeground(ftColor);
        frame.getContentPane().add(accessLbl222);

        /* 두번째 설정 적용 버튼 */
        /*JButton accessBtn22 = new JButton("적용");
        accessBtn22.setBounds(290, 208, 60, 20);
        accessBtn22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mArgs.setSecondDelayTime(Integer.parseInt(accessInput23.getText()));

            }
        });
        frame.getContentPane().add(accessBtn22);*/

        /* 두번째 좌표 값 저장 */
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_F7) {
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

        /* 1,2번째 동작 사이 딜레이 시간 3-1 */
        JLabel accessLbl31 = new JLabel("1,2번째 동작 사이 딜레이 시간");
        accessLbl31.setBounds(10, 270, 200, 30);
        accessLbl31.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        accessLbl31.setForeground(ftColor);
        frame.getContentPane().add(accessLbl31);

        /* 동작 사이 딜레이 시간 입력 */
        JTextField accessInput32 = new JTextField();
        accessInput32.setBounds(210, 276, 60, 20);
        accessInput32.setFocusable(true); // 인풋 포커스
        accessInput32.setHorizontalAlignment(SwingConstants.RIGHT); // 글자 우측 정렬
        accessInput32.setForeground(ftColor);
        frame.getContentPane().add(accessInput32);

        /* 초 3-2-1 */
        JLabel accessLbl321 = new JLabel("초");
        accessLbl321.setBounds(270, 276, 15, 30);
        accessLbl321.setFont(new Font("맑은 고딕", Font.BOLD, 10));
        accessLbl321.setForeground(ftColor);
        frame.getContentPane().add(accessLbl321);

        /* 실행 라벨 4-1 */
        JLabel accessLbl41 = new JLabel("실행 (F8)");
        accessLbl41.setBounds(10, 320, 200, 30);
        accessLbl41.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        accessLbl41.setForeground(ftColor);
        frame.getContentPane().add(accessLbl41);

        /* 중지 라벨 4-1 */
        JLabel accessLbl51 = new JLabel("중지 (F9)");
        accessLbl51.setBounds(10, 350, 200, 30);
        accessLbl51.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        accessLbl51.setForeground(ftColor);
        frame.getContentPane().add(accessLbl51);

        /* 실행 단축키 F8 눌렀을 때 */
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_F8) {

                    System.out.println("단축키 버튼 눌림\n");

                    mArgs.setFirstClickCnt(Integer.parseInt(accessInput11.getText()));
                    mArgs.setFirstDelayTime(Integer.parseInt(accessInput11.getText()));
                    mArgs.setSecondClickCnt(Integer.parseInt(accessInput21.getText()));
                    mArgs.setSecondDelayTime(Integer.parseInt(accessInput23.getText()));
                    mArgs.setAllDelayTime(Integer.parseInt(accessInput32.getText()));

                    // 종료 후 재시작시
                    if(executor.isShutdown() || executor.isTerminated()) {
                        // 백그라운드 스레드 풀은 종료시키면 아예 사라지기 때문에 재생성 해줘야함
                        executor = Executors.newSingleThreadExecutor(); 
                    }
                    
                    // 백그라운드로 매크로 시작 (백그라운드로 안하면 프로그램 동작 후 단축키 버튼 안먹힘)
                    executor.submit(() -> {
                        try {
                            running = true;
                            activeMacro(mArgs);
                            System.out.println("매크로 시작 \n");
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    });

                }
                return false;
            }
        });

        /* 멈춤버튼 단축키 F9 눌렀을 때 */
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_F9) {

                    // 매크로 중지
                    running = false;
                    executor.shutdownNow();
                    System.out.println("매크로 동작 멈춤 \n");

                }
                return false;
            }
        });
        frame.setVisible(true);

    }

    /* 매크로 동작 */
    private static void activeMacro(MacroArgs mArgs) throws Exception {

        Robot robot = new Robot();  // 매크로 기능

        while (running) {
            System.out.println("첫번째 동작 시작 \n");

            if (!running) break; // 중지 상태 확인
            // 첫번째 좌표로 움직이기
            robot.mouseMove(mArgs.getFirstMouseX(), mArgs.getFirstMouseY());
            if (!running) break; // 중지 상태 확인

            // 첫번째 클릭 횟수 만큼 클릭
            for (int i = 0; i < mArgs.getFirstClickCnt(); i++) {
                if (running) {
                    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK); // 클릭
                    Thread.sleep(100); // 0.1 초 딜레이
                    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // 클릭 해제
                    if (!running) break; // 중지 상태 확인
                    Thread.sleep(mArgs.getFirstDelayTime() * 1000); // 초를 밀리초로 변환
                    if (!running) break; // 중지 상태 확인
                }
                break;
            }
            long starTime = System.currentTimeMillis();

            System.out.println("첫번째 동작 종료 \n");

            if (!running) break; // 중지 상태 확인
            // 첫번째와 두번째 사이의 시간 간격 설정
            Thread.sleep(mArgs.getAllDelayTime() * 1000);

            long endTime = System.currentTimeMillis();
            System.out.println("딜레이 시간: " + (endTime - starTime) + "ms");

            if (!running) break; // 중지 상태 확인
            // 두번째 좌표로 움직이기
            robot.mouseMove(mArgs.getSecondMouseX(), mArgs.getSecondMouseY());
            if (!running) break; // 중지 상태 확인

            System.out.println("두번째로 움직임: " + mArgs.getSecondMouseX() + "," + mArgs.getSecondMouseY());
            System.out.println("두번째 동작 시작 \n");

            // 두번째 클릭 회수 만큼 동작
            for (int i = 0; i < mArgs.getSecondClickCnt(); i++) {
                if (running) {
                    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    Thread.sleep(100);
                    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                    if (!running) break; // 중지 상태 확인
                    Thread.sleep(mArgs.getSecondDelayTime() * 1000);
                    if (!running) break; // 중지 상태 확인
                }
                break;
            }
            starTime = System.currentTimeMillis();

            System.out.println("두번째 동작 종료 \n");

            if (!running) break; // 중지 상태 확인
            Thread.sleep(mArgs.getAllDelayTime() * 1000);
            if (!running) break; // 중지 상태 확인
            endTime = System.currentTimeMillis();
            System.out.println("딜레이 시간: " + (endTime - starTime) + "ms");

        }
    }

}
