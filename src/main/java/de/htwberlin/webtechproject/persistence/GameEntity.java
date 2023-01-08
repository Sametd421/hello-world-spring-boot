package de.htwberlin.webtechproject.persistence;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

@Entity(name = "games")
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "console")
    private Console console;
    @Column(name = "releaseYear")
    private int releaseYear;

    @Column(name = "startDate")
    private String startDate;
    @Column(name = "finished")
    private boolean finished;
    @Column(name = "favorised")
    private boolean favorised;
    @Column(name = "comment")
    private String comment;
    @Column(name = "genre")
    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    public GameEntity(String title, Console console, int releaseYear, String startDate, Boolean finished, boolean favorised, String comment, Genre genre) {
        this.title = title;
        this.console = console;
        this.releaseYear = releaseYear;
        this.startDate = startDate;
        this.finished = finished;
        this.favorised = favorised;
        this.comment = comment;
        this.genre = genre;
    }

    protected GameEntity() {}

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String firstName) {
        this.title = firstName;
    }

    public Console getConsole() {
        return console;
    }

    public void setConsole(Console console) {
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
    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
