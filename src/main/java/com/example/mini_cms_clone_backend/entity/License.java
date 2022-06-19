package com.example.mini_cms_clone_backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "licenses")
public class License {

    @Id
    @SequenceGenerator(name = "seq_licenses", allocationSize = 1)
    @GeneratedValue(generator = "seq_licenses",strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", length = 250,nullable = false)
    private String name;

    @Column(name = "start_time", length = 55)
    private String start_time;

    @Column(name = "end_time", length = 55)
    private String end_time;

    @JsonIgnore
    @ManyToMany(mappedBy="licenseEntities")
    private List<Content> contentEntities;

    public License() {
    }

    public License(int id) {
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

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() { return end_time; }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public List<Content> getContentEntities() {
        return contentEntities;
    }

    public void setContentEntities(List<Content> contentEntities) {
        this.contentEntities = contentEntities;
    }

}
