package com.example.mini_cms_clone_backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContentP {
    private int id;
    private String name;
    private String status;
    private String posterurl;
    private String videourl;
    private List<LicenseP> licenses;
}
