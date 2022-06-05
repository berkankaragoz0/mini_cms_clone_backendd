package com.example.mini_cms_clone_backend.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LicensePojo {
    private int id;
    private String name;
    private String startTime;
    private String endTime;
}
