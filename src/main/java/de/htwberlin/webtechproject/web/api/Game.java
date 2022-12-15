package de.htwberlin.webtechproject.web.api;

public class Game {

    private long id;
    private String title;
    private String lastName;
    private String genre;
    private boolean finished;

    public Game(long id, String title, String lastName, String genre, boolean finished) {
        this.id = id;
        this.title = title;
        this.lastName = lastName;
        this.finished = finished;
        this.genre = genre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
