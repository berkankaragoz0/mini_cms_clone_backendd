package com.example.mini_cms_clone_backend.controller;

import com.example.mini_cms_clone_backend.pojo.LicenseP;
import com.example.mini_cms_clone_backend.service.implementation.LicenseServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/licence")
@AllArgsConstructor
public class LicenseController {
    private final LicenseServiceImp licenseServiceImp;

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<LicenseP>> allLicenseList() {
        return ResponseEntity.ok(licenseServiceImp.getAllLicense());
    }

    @PostMapping
    public ResponseEntity<LicenseP> addLicense(@RequestBody LicenseP licenseP) {
        return ResponseEntity.ok(licenseServiceImp.addLicense(licenseP));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteLicense(@PathVariable int id){
        licenseServiceImp.deleteLicense(id);
    }

}
