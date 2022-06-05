package com.example.mini_cms_clone_backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "licenses")
public class LicenseEntity {

    @Id
    @SequenceGenerator(name = "seq_licenses", allocationSize = 1)
    @GeneratedValue(generator = "seq_licenses",strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", length = 250,nullable = false)
    private String name;

    @Column(name = "start_time", length = 55)
    private String startTime;

    @Column(name = "end_time", length = 55)
    private String endTime;

    public LicenseEntity() {
    }

    public LicenseEntity(int id) {
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() { return endTime; }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
