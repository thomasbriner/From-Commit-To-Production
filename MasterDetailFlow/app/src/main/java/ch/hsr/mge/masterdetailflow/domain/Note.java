package ch.hsr.mge.masterdetailflow.domain;

import java.util.Observable;

public class Note extends Observable {

    private String title;
    private String content;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        setChanged();
        notifyObservers();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        setChanged();
        notifyObservers();
    }
}
