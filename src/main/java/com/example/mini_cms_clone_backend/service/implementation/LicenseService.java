package com.example.mini_cms_clone_backend.service.implementation;

import com.example.mini_cms_clone_backend.entity.LicenseEntity;
import com.example.mini_cms_clone_backend.pojo.LicensePojo;
import com.example.mini_cms_clone_backend.repository.LicenseRepository;
import com.example.mini_cms_clone_backend.service.ILicenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LicenseService implements ILicenseService {

    @Autowired
    LicenseRepository licenseRepository;

    @Override
    public List<LicensePojo> getAllLicense() {
        List<LicenseEntity> licenseEntities = (List<LicenseEntity>) licenseRepository.findAll();
        List<LicensePojo> licensePojos = new ArrayList<>();
        licenseEntities.forEach(it -> {
            LicensePojo licenseDto =new LicensePojo();
            licenseDto.setId(it.getId());
            licenseDto.setName(it.getName());
            licenseDto.setStartTime(it.getStartTime());
            licenseDto.setEndTime(it.getEndTime());
            licensePojos.add(licenseDto);
        });
        return licensePojos;
    }

    @Override
    public LicensePojo addLicense(LicensePojo licensePojo) {
        return null;
    }

    @Override
    public void deleteLicense(int id) {

    }
}
