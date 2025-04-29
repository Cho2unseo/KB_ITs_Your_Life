package ch15.practice.practice02.quiz;

public class Content {
    private String question;

    public Content(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public boolean equals(Object obj) {
        return question == obj;
    }
}
