package com.example.mini_cms_clone_backend.service;

import com.example.mini_cms_clone_backend.entity.License;
import com.example.mini_cms_clone_backend.pojo.LicenseP;

import java.util.List;

public interface LicenseService {
    License getById(int id);
    List<LicenseP> getAllLicense();
    LicenseP addLicense(LicenseP licenseP);
    void deleteLicense(int id);
}
