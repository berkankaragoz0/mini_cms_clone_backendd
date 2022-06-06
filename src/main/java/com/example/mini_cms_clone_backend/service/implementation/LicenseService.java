package com.example.mini_cms_clone_backend.service.implementation;

import com.example.mini_cms_clone_backend.entity.ContentEntity;
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
            licenseDto.setStart_time(it.getStart_time());
            licenseDto.setEnd_time(it.getEnd_time());
            licensePojos.add(licenseDto);
        });
        return licensePojos;
    }

    @Override
    public LicensePojo addLicense(LicensePojo licensePojo) {
        LicenseEntity licenseEntity = new LicenseEntity();
        licenseEntity.setName(licensePojo.getName());
        licenseEntity.setStart_time(licensePojo.getStart_time());
        licenseEntity.setEnd_time(licensePojo.getEnd_time());
        LicenseEntity licenseDb = licenseRepository.save(licenseEntity);
        licensePojo.setId(licenseDb.getId());
        return licensePojo;
    }

    @Override
    public void deleteLicense(int id) {
        licenseRepository.deleteById(id);
    }
}
