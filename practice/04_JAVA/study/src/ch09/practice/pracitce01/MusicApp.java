package ch09.practice.pracitce01;

public class MusicApp {
    String title;
    String artist;
    String genre;

    MusicApp(String title, String artist, String genre) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
    }

    class MusicPlayer {
        void play() {
            String a = getEffect(genre);
            System.out.println(a + " " + title + " - " + artist + " 을(를) 재생합니다. " + a);
        }
        String getEffect(String genre) {
            if (genre.equals("HIPHOP")) return "💥";
            else if (genre.equals("BALLAD")) return "🎵";
            else return "🎧";
        }

    }
}
