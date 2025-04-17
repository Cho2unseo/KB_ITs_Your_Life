package ch06.sec08.exam03;

public class Car {
    int gas;

    // 가스값 받아와서 설정해주는 메소드
    void setGas(int gas) {
        this.gas = gas;
    }

    // gas가 남아있는지 boolean 값으로 리턴해주는 메소드
    boolean isLeftGas() {
        if (gas == 0) {
            System.out.println("gas가 없습니다.");
            return false;
        }
        // gas가 0인 경우 위쪽에서 리턴되기 때문에 else문 불필요
        System.out.println("gas가 있습니다.");
        return true;
    }
    void run() {
        while (true) {
            if (gas > 0) {
                // gas가 남아있는 경우 gas 잔량 출력 후 gas를 1 감소시킴
                System.out.println("달립니다.(gas 잔량: " + gas + ")");
                gas -= 1;
            }
            else {
                // gas가 없는 경우 잔량 출력 후 메소드 종료
                System.out.println("멈춥니다. (gas 잔량: " + gas + ")");
                return;
            }
        }
    }
}
