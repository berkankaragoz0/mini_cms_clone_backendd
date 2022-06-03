package com.example.mini_cms_clone_backend.Pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContentPojo {
    private int id;
    private String name;
    private String status;
    private String posterUrl;
    private String videoUrl;
}
