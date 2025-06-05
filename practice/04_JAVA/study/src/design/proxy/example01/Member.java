package design.proxy.example01;

public class Member implements BandComponent {
    String name;
    String mbti;
    String position;
    int energyLevel;
    public Member(String name, String mbti, String position, int energyLevel) {
        this.name = name;
        this.mbti = mbti;
        this.position = position;
        this.energyLevel = energyLevel;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void perform() {
        if (energyLevel < 30) {
            System.out.println("😵 [" + mbti + "] " + name + ": 너무 지쳐서 공연을 못 하겠어요...");
        }
        else {
            switch (mbti) {
                case "ENFP":
                    System.out.println("🔥 [" + mbti + "] " + name + ": 여러분 안녕!! 불태워볼까요?");
                    break;
                case "ISTJ":
                    System.out.println("🧊 [" + mbti + "] " + name + ": 공연 시작합니다.");
                    break;
                case "ISFP":
                    System.out.println("🌙 [" + mbti + "] " + name + ": 조용히 시작해볼게요.");
                    break;
                case "INTP":
                    System.out.println("🧠 [" + mbti + "] " + name + ": 이 곡은 구조적으로 매우 완벽합니다.");
                    break;
                case "ESFJ":
                    System.out.println("💕 [" + mbti + "] " + name + ": 다들 잘 지냈죠? 오늘도 힘내요!");
                    break;
                default:
                    System.out.println("🎶 [기타] " + name + ": 준비됐어요!");
            }
            if (mbti.equals("ENFP")) {

            }
            //은서야~ 사랑해~
            // 나의 음악 어땟니 너의 표정이 아까 막
            // 소금에 닿은 민달팽이 같았어
            //
        }
    }

    @Override
    public void printStructure(String prefix) {
        System.out.print(prefix);
        System.out.println("🎸 " +  position + " - " + name + " (" + mbti + ")");
    }
}
