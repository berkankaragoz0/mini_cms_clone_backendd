package com.example.mini_cms_clone_backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "contents")
public class ContentEntity {

    @Id
    @SequenceGenerator(name = "seq_contents", allocationSize = 1)
    @GeneratedValue(generator = "seq_contents",strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", length = 250,nullable = false)
    private String name;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "postertrl", length = 255)
    private String posterurl;

    @Column(name = "videourl", length = 255)
    private String videourl;

    public ContentEntity() {
    }

    public ContentEntity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPosterurl() {
        return posterurl;
    }

    public void setPosterurl(String posterUrl) {
        this.posterurl = posterurl;
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

}
