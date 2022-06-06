package com.example.mini_cms_clone_backend.controller;

import com.example.mini_cms_clone_backend.pojo.ContentPojo;
import com.example.mini_cms_clone_backend.pojo.LicensePojo;
import com.example.mini_cms_clone_backend.service.implementation.LicenseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<LicensePojo> addLicense(@RequestBody LicensePojo licensePojo) {
        return ResponseEntity.ok(licenseService.addLicense(licensePojo));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteLicense(@PathVariable int id){
        licenseService.deleteLicense(id);
    }

}
