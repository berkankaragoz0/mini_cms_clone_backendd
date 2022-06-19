package com.example.mini_cms_clone_backend.service.implementation;

import com.example.mini_cms_clone_backend.constant.LicenseStatus;
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
    public License getById(int id) {
        return licenseRepository.findOneById(id);
    }

    @Override
    public List<LicenseP> getAllLicense() {
        List<License> licenseEntities = (List<License>) licenseRepository.findAll();
        List<LicenseP> licensePS = new ArrayList<>();
        licenseEntities.forEach(it -> {
            LicenseP licenseDto = new LicenseP();
            licenseDto.setId(it.getId());
            licenseDto.setName(it.getName());
            licenseDto.setStartTime(it.getStartTime());
            licenseDto.setEndTime(it.getEndTime());
            licenseDto.setStatus(it.getStatus());
            licensePS.add(licenseDto);
        });
        return licensePS;
    }

    @Override
    public LicenseP addLicense(LicenseP licenseP) {
        long now = System.currentTimeMillis();
        License license = new License();
        license.setName(licenseP.getName());
        license.setStartTime(licenseP.getStartTime());
        license.setEndTime(licenseP.getEndTime());
        System.out.println("start time : " + licenseP.getStartTime() + " | now : " + now + " | end time : " + licenseP.getEndTime());
        if (licenseP.getStartTime() <= now && now < licenseP.getEndTime()) {
            license.setStatus(LicenseStatus.ACTIVE);
        } else {
            license.setStatus(LicenseStatus.EXPIRED);
        }
        License licenseDb = licenseRepository.save(license);
        licenseP.setId(licenseDb.getId());
        return licenseP;
    }

    @Override
    public void deleteLicense(int id) {
        licenseRepository.deleteById(id);
    }
}
