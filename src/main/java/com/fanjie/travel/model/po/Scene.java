package com.fanjie.travel.model.po;

public class Scene {
    private Integer id;

    private String name;

    private String scenedate;

    private String author;

    private String description;

    private Integer scenelike;

    private String cover;

    private String video;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScenedate() {
        return scenedate;
    }

    public void setScenedate(String scenedate) {
        this.scenedate = scenedate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getScenelike() {
        return scenelike;
    }

    public void setScenelike(Integer scenelike) {
        this.scenelike = scenelike;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}