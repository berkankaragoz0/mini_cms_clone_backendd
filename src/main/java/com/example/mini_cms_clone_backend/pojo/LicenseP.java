package com.example.mini_cms_clone_backend.pojo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
public class LicenseP {
    private int id;
    private String name;
    private Long startTime;
    private Long endTime;
}
