package com.example.mini_cms_clone_backend.pojo;

import com.example.mini_cms_clone_backend.constant.LicenseStatus;
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
    private LicenseStatus status;
}
