package com.example.mini_cms_clone_backend.pojo;

import com.example.mini_cms_clone_backend.constant.Status;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
public class ContentP {
    private int id;
    private String name;
    private Status status;
    private String posterUrl;
    private String videoUrl;
    private List<LicenseP> licenses;
}
