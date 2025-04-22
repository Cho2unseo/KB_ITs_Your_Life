package ch09.practice.practice02;

public class PlayerSettings {
    static class Mode {
        static boolean shuffle = false;
        static boolean repeat = true;
        static int volumeLevel = 5;

        public static void printSettings() {
            System.out.println("🎛️ 현재 재생 설정 상태");
            System.out.println("- Shuffle: " + (shuffle ? "ON" : "OFF"));
            System.out.println("- Repeat: " + (repeat ? "ON" : "OFF"));
            System.out.println("- Volume: " + volumeLevel);
        }

        public static void setShuffle(boolean value) {
            shuffle = value;
            System.out.println("Shuffle 모드가 " + (shuffle ? "ON" : "OFF") + "으로 설정되었습니다.");
        }

        public static void setRepeat(boolean value) {
            repeat = value;
            System.out.println("Repeat 모드가 " + (repeat ? "ON" : "OFF") + "으로 설정되었습니다.");
        }

        public static void setVolumeLevel(int level) {
            if (level < 0 || level > 10) System.out.println("볼륨은 0~10 사이로 설정해야 합니다.");
            else {
                volumeLevel = level;
                System.out.println("볼륨이 " + volumeLevel + "로 설정되었습니다.");
            }
        }
    }
}
