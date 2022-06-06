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

    @Column(name = "starttime", length = 55)
    private String starttime;

    @Column(name = "endtime", length = 55)
    private String endtime;

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

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() { return endtime; }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }
}
