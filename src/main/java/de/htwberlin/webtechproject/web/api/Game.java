package de.htwberlin.webtechproject.web.api;

import de.htwberlin.webtechproject.persistence.Console;
import de.htwberlin.webtechproject.persistence.Genre;

public class Game {

    private long id;
    private String title;
    private String console;
    private int releaseYear;
    private String startDate;
    private boolean finished;
    private boolean favorised;
    private String comment;
    private String genre;

    public Game(long id, String title, String console, int releaseYear, String startDate, Boolean finished, boolean favorised, String comment, String genre) {
        this.id = id;
        this.title = title;
        this.console = console;
        this.releaseYear = releaseYear;
        this.startDate = startDate;
        this.finished = finished;
        this.favorised = favorised;
        this.comment = comment;
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

    public void setTitle(String firstName) {
        this.title = firstName;
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public boolean getFavorised() {
        return favorised;
    }

    public void setFavorised(boolean favorised) {
        this.favorised = favorised;
    }
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
