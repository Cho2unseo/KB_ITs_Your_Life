package ch06.sec14;

public class Car {
    private int speed;
    private boolean stop;

    // Getter: 값 읽는 용도(값 가져오기)
    public int getSpeed() {
        return speed;
    }

    // Setter: 값을 설정하는 용도
    public void setSpeed(int speed) {
        if (speed < 0) { // 0 이하의 값은 들어오지 못하도록 처리
            this.speed = 0;
            return;
        }
        else {
            this.speed = speed;
        }
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
        if (stop == true) this.speed = 0;
    }
}
