package com.example.mini_cms_clone_backend.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Column(name = "posterurl", length = 255)
    private String posterurl;

    @Column(name = "videourl", length = 255)
    private String videourl;

    @ManyToMany(targetEntity = LicenseEntity.class, cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(
            name = "content_license",
            joinColumns = {@JoinColumn(name = "content_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "license_id", nullable = false, updatable = false) })
    Set<LicenseEntity> licenseEntitySet = new HashSet<>();

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

    public void setPosterurl(String posterurl) {
        this.posterurl = posterurl;
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }

    public Set<LicenseEntity> getLicenseEntitySet(){
        return licenseEntitySet;
    }

    /*public List<LicenseEntity> getLicenses() {
        return licenses;
    }

    public void setLicenses(List<LicenseEntity> licenses) {
        this.licenses = licenses;
    }*/

}
