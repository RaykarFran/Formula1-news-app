package me.dio.formula1news.domain;

public class News {
    private String title;
    private String descripion;

    public News(String title, String descripion) {
        this.title = title;
        this.descripion = descripion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescripion() {
        return descripion;
    }

    public void setDescripion(String descripion) {
        this.descripion = descripion;
    }
}
