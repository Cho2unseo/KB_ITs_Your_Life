package ch18.practice0513.practice01;

public class DatingCharacter {
    private String name;
    private String personality;
    private String hobby;
    private String favoriteFood;
    private String talkStyle;

    public static class Builder {
        private String name;
        private String personality;
        private String hobby;
        private String favoriteFood;
        private String talkStyle;

//        private DatingCharacter(Builder builder) {
//            this.name = builder.name;
//        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder personality(String personality) {
            this.personality = personality;
            return this;
        }

        public Builder hobby(String hobby) {
            this.hobby = hobby;
            return this;
        }

        public Builder favoriteFood(String favoriteFood) {
            this.favoriteFood = favoriteFood;
            return this;
        }

        public Builder talkStyle(String talkStyle) {
            this.talkStyle = talkStyle;
            return this;
        }

        public DatingCharacter build() {
            return new DatingCharacter();
        }

    }
    public int compareTo(DatingCharacter o) {
        return this.name.compareTo(o.name);
    }
}
