package com.example.mini_cms_clone_backend.service.implementation;

import com.example.mini_cms_clone_backend.constant.Status;
import com.example.mini_cms_clone_backend.entity.Content;
import com.example.mini_cms_clone_backend.entity.License;
import com.example.mini_cms_clone_backend.log.LogGenerator;
import com.example.mini_cms_clone_backend.pojo.ContentP;
import com.example.mini_cms_clone_backend.repository.ContentRepository;
import com.example.mini_cms_clone_backend.repository.LicenseRepository;
import com.example.mini_cms_clone_backend.service.ContentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
@AllArgsConstructor
public class ContentServicesImp implements ContentService {
    @Autowired
    ContentRepository contentRepository;
    @Autowired
    LicenseRepository licenseRepository;

    @Override
    public Content getById(int id) {
        return contentRepository.findOneById(id);
    }

    @Override
    public List<ContentP> getAllContents() {
        List<Content> contentEntities = (List<Content>) contentRepository.findAll();
        List<ContentP> contentPS = new ArrayList<>();
        contentEntities.forEach(it -> {
            ContentP contentDto =new ContentP();
            contentDto.setId(it.getId());
            contentDto.setName(it.getName());
            contentDto.setStatus(it.getStatus());
            contentDto.setPosterUrl(it.getPosterUrl());
            contentDto.setVideoUrl(it.getVideoUrl());
            contentPS.add(contentDto);
        });
        return contentPS;
    }

    @Override
    public ContentP addContent(ContentP contentP) {
        Content content = new Content();
        content.setName(contentP.getName());
        content.setStatus(Status.NoActiveLicense);
        Content contentDb = contentRepository.save(content);
        contentP.setId(contentDb.getId());
        return contentP;
    }

    @Override
    public void deleteContent(int id) {
        contentRepository.deleteById(id);
    }

    @Override
    public void delete(Content content) {
        content.setStatus(Status.Deleted);
        contentRepository.save(content);
    }

    @Override
    public void addLicenseToContent(Content content, License license) {
        content.getLicenseEntities().add(license);
        if(content.getStatus().toString() == "NoActiveLicense"){
            if (license.getStatus().toString() == "ACTIVE"){
                content.setStatus(Status.InProgress);
            }
        }
        contentRepository.save(content);
    }

    @Override
    public void deleteLicenseToContent(int contentId, int licenseId) {
        contentRepository.deletedLicenseToContent(contentId,licenseId);
        Boolean result = contentRepository.existsActiveLicense(contentId);

        Content content = contentRepository.findOneById(contentId);

        if (content.getStatus().toString() != "NoActiveLicense" || content.getStatus().toString() != "Deleted"){
            if (result==false){
                content.setStatus(Status.NoActiveLicense);
                contentRepository.save(content);
            }
        }

    }
}
