package be.pxl.ja.streamingservice.model;

import java.time.LocalDate;

public class Movie extends Content implements be.pxl.ja.opdracht1.Playable {
    public static final int LONG_PLAYING_TIME = 2 * 60 + 15;

    private String director;
    private LocalDate releaseDate;
    private int duration;
    private Genre genre;

    public Movie(String title, Rating maturityRating) {
        super(title, maturityRating);

    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public void play() {
        System.out.println("Playing " + this);
    }

    @Override
    public void pause() {
        System.out.println("Pausing " + this);
    }

    public void setDuration(int duration) {
        this.duration = Math.abs(duration);
    }

    public boolean isLongPlayingTime() {
        return duration >= LONG_PLAYING_TIME;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getPlayingTime() {
        StringBuilder time = new StringBuilder();
        if (duration == 0) {
            time.append("?");
        } else {
            if (duration < 60) {
                time.append(duration).append(" min");
            } else if (duration % 60 == 0) {
                int hours = duration / 60;
                time.append(hours).append(" h");
            } else {
                int hours = duration / 60;
                int min = duration % 60;
                time.append(hours).append(" h ").append(min).append(" min");
            }
        }
        return time.toString();
    }

    @Override
    public String toString() {
        if (releaseDate != null) {
            return super.toString() + " (" + releaseDate.getYear() + ")";
        } else {
            return super.toString();
        }
    }
}

