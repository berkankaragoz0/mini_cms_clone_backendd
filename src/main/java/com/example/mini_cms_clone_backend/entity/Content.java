package com.example.mini_cms_clone_backend.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "contents")
public class Content {

    @Id
    @SequenceGenerator(name = "seq_contents", allocationSize = 1)
    @GeneratedValue(generator = "seq_contents",strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", length = 250,nullable = false)
    private String name;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "posterurl", length = 255)
    private String posterurl;

    @Column(name = "videourl", length = 255)
    private String videourl;

    @ManyToMany(targetEntity = License.class, cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(
            name = "content_license",
            joinColumns = {@JoinColumn(name = "content_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "license_id", nullable = false, updatable = false) })
    private List<License> licenseEntities;

    public Content() {
    }

    public Content(int id) {
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

    public void setPosterurl(String posterurl) {
        this.posterurl = posterurl;
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    public List<License> getLicenseEntities() {
        return licenseEntities;
    }

    public void setLicenseEntities(List<License> licenseEntities) {
        this.licenseEntities = licenseEntities;
    }

}
