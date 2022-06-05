package com.example.mini_cms_clone_backend.controller;

import com.example.mini_cms_clone_backend.pojo.LicensePojo;
import com.example.mini_cms_clone_backend.service.implementation.LicenseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/licences")
@AllArgsConstructor
public class LicenseController {
    private final LicenseService licenseService;

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<LicensePojo>> allLicenseList() {
        return ResponseEntity.ok(licenseService.getAllLicense());
    }
}
