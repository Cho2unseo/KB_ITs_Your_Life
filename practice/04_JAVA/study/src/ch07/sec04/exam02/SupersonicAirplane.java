package ch07.sec04.exam02;

public class SupersonicAirplane extends Airplane {
    public static final int NORMAL = 1;
    public static final int SUPERSONIC = 2;
    public int flyMode = NORMAL;

    @Override
    public void fly() {
        if (flyMode == SUPERSONIC) {
            System.out.println("초음속 비행합니다.");
        } else { // SUPERSONIC 모드가 아닌 경우 기존 부모 메소드 사용
            super.fly();
        }
    }
}
