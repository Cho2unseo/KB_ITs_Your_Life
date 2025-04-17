package ch06.sec11.exam02;

public class Earth {
    // 상수의 이름은 보통 대문자로 표기
    static final double EARTH_RADIUS = 6400;

    static final double EARTH_SURFACE_AREA; // 상수는 초기화 필요

    static {
        EARTH_SURFACE_AREA = 4 * Math.PI * EARTH_RADIUS * EARTH_RADIUS;
    }
}
