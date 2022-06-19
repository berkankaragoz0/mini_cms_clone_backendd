package com.example.mini_cms_clone_backend.entity;

import com.example.mini_cms_clone_backend.constant.LicenseStatus;
import com.example.mini_cms_clone_backend.constant.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "licenses")
@EqualsAndHashCode(of = {"id"})
@ToString
public class License {

    @Id
    @SequenceGenerator(name = "seq_licenses", allocationSize = 1)
    @GeneratedValue(generator = "seq_licenses",strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", length = 250,nullable = false)
    private String name;

    private Long startTime;

    private Long endTime;

    @Enumerated(EnumType.STRING)
    private LicenseStatus status;

    @JsonIgnore
    @ManyToMany(mappedBy="licenseEntities")
    private List<Content> contentEntities;

}
