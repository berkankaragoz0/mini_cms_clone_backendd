package com.example.mini_cms_clone_backend.service.implementation;

import com.example.mini_cms_clone_backend.entity.License;
import com.example.mini_cms_clone_backend.pojo.LicenseP;
import com.example.mini_cms_clone_backend.repository.LicenseRepository;
import com.example.mini_cms_clone_backend.service.LicenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LicenseServiceImp implements LicenseService {

    @Autowired
    LicenseRepository licenseRepository;

    @Override
    public List<LicenseP> getAllLicense() {
        List<License> licenseEntities = (List<License>) licenseRepository.findAll();
        List<LicenseP> licensePS = new ArrayList<>();
        licenseEntities.forEach(it -> {
            LicenseP licenseDto =new LicenseP();
            licenseDto.setId(it.getId());
            licenseDto.setName(it.getName());
            licenseDto.setStart_time(it.getStart_time());
            licenseDto.setEnd_time(it.getEnd_time());
            licensePS.add(licenseDto);
        });
        return licensePS;
    }

    @Override
    public LicenseP addLicense(LicenseP licenseP) {
        License license = new License();
        license.setName(licenseP.getName());
        license.setStart_time(licenseP.getStart_time());
        license.setEnd_time(licenseP.getEnd_time());
        License licenseDb = licenseRepository.save(license);
        licenseP.setId(licenseDb.getId());
        return licenseP;
    }

    @Override
    public void deleteLicense(int id) {
        licenseRepository.deleteById(id);
    }
}
