package de.htwberlin.webtechproject.persistence;

import javax.persistence.*;

@Entity(name = "games")
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "is_finished")
    private Boolean finished;

    @Column(name = "genre")
    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    public GameEntity(String title, String lastName, Boolean finished, Genre genre) {
        this.title = title;
        this.lastName = lastName;
        this.finished = finished;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean vaccinated) {
        this.finished = vaccinated;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
