package args;

public class MacroArgs {

    private Integer allDelayTime = 60; // 첫번째 두번째 동작 후 재 반복까지의 딜레이 시간

    private Integer firstMouseX = 0; // 첫번째 마우스 좌표 x
    private Integer firstMouseY = 0; // 첫번째 마우스 좌표 y
    private Integer firstDelayTime = 0; // 첫번째 마우스 클릭 딜레이 시간
    private Integer firstClickCnt = 0; // 첫번째 마우스 클릭 횟수

    private Integer secondMouseX = 0; // 두번째 마우스 좌표 x
    private Integer secondMouseY = 0; // 두번째 마우스 좌표 y
    private Integer secondDelayTime = 0; // 두번째 마우스 클릭 딜레이 시간
    private Integer secondClickCnt = 0; // 두번째 마우스 클릭 횟수

    private boolean running = false; // 실행상태

    public MacroArgs() {
    }

    public Integer getAllDelayTime() {
        return allDelayTime;
    }

    public void setAllDelayTime(Integer allDelayTime) {
        this.allDelayTime = allDelayTime;
    }

    public Integer getFirstMouseX() {
        return firstMouseX;
    }

    public void setFirstMouseX(Integer firstMouseX) {
        this.firstMouseX = firstMouseX;
    }

    public Integer getFirstMouseY() {
        return firstMouseY;
    }

    public void setFirstMouseY(Integer firstMouseY) {
        this.firstMouseY = firstMouseY;
    }

    public Integer getFirstDelayTime() {
        return firstDelayTime;
    }

    public void setFirstDelayTime(Integer firstDelayTime) {
        this.firstDelayTime = firstDelayTime;
    }

    public Integer getFirstClickCnt() {
        return firstClickCnt;
    }

    public void setFirstClickCnt(Integer firstClickCnt) {
        this.firstClickCnt = firstClickCnt;
    }

    public Integer getSecondMouseX() {
        return secondMouseX;
    }

    public void setSecondMouseX(Integer secondMouseX) {
        this.secondMouseX = secondMouseX;
    }

    public Integer getSecondMouseY() {
        return secondMouseY;
    }

    public void setSecondMouseY(Integer secondMouseY) {
        this.secondMouseY = secondMouseY;
    }

    public Integer getSecondDelayTime() {
        return secondDelayTime;
    }

    public void setSecondDelayTime(Integer secondDelayTime) {
        this.secondDelayTime = secondDelayTime;
    }

    public Integer getSecondClickCnt() {
        return secondClickCnt;
    }

    public void setSecondClickCnt(Integer secondClickCnt) {
        this.secondClickCnt = secondClickCnt;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean getRunning() {
        return running;
    }

    @Override
    public String toString() {
        return "MacroArgs{" +
                "allDelayTime=" + allDelayTime +
                ", firstMouseX=" + firstMouseX +
                ", firstMouseY=" + firstMouseY +
                ", firstDelayTime=" + firstDelayTime +
                ", firstClickCnt=" + firstClickCnt +
                ", secondMouseX=" + secondMouseX +
                ", secondMouseY=" + secondMouseY +
                ", secondDelayTime=" + secondDelayTime +
                ", secondClickCnt=" + secondClickCnt +
                '}';
    }
}
