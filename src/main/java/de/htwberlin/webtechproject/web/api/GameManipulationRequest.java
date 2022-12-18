package de.htwberlin.webtechproject.web.api;

public class GameManipulationRequest {

    private String title;
    private String lastName;

    private String genre;
    private boolean finished;

    public GameManipulationRequest(String title, String lastName, String genre, boolean finished) {
        this.title = title;
        this.lastName = lastName;
        this.genre = genre;
        this.finished = finished;
    }


    public GameManipulationRequest() {}
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
