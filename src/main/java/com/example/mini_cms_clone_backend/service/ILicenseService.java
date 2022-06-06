package com.example.mini_cms_clone_backend.service;

import com.example.mini_cms_clone_backend.pojo.ContentPojo;
import com.example.mini_cms_clone_backend.pojo.LicensePojo;

import java.util.List;

public interface ILicenseService {
    List<LicensePojo> getAllLicense();
    LicensePojo addLicense(LicensePojo licensePojo);
    void deleteLicense(int id);
}
