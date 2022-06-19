package com.example.mini_cms_clone_backend.controller;

import com.example.mini_cms_clone_backend.pojo.LicenseP;
import com.example.mini_cms_clone_backend.service.LicenseService;
import com.example.mini_cms_clone_backend.service.implementation.LicenseServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/license")
@AllArgsConstructor
public class LicenseController {
    private final LicenseService licenseService;

    @GetMapping
    public ResponseEntity<List<LicenseP>> allLicenseList() {
        return ResponseEntity.ok(licenseService.getAllLicense());
    }

    @PostMapping
    public ResponseEntity<LicenseP> addLicense(@RequestBody LicenseP licenseP) {
        return ResponseEntity.ok(licenseService.addLicense(licenseP));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteLicense(@PathVariable int id){
        licenseService.deleteLicense(id);
    }

}
