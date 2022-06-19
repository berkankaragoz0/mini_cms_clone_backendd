package com.example.mini_cms_clone_backend.entity;

import com.example.mini_cms_clone_backend.constant.Status;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contents")
@EqualsAndHashCode(of = {"id"})
@ToString
public class Content {

    @Id
    @SequenceGenerator(name = "seq_contents", allocationSize = 1)
    @GeneratedValue(generator = "seq_contents",strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", length = 250,nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String posterUrl;

    private String videoUrl;

    @ManyToMany(targetEntity = License.class, cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(
            name = "content_license",
            joinColumns = {@JoinColumn(name = "content_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "license_id", nullable = false, updatable = false) })
    private List<License> licenseEntities;

}
