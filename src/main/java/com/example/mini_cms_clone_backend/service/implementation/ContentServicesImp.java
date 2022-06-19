package com.example.mini_cms_clone_backend.service.implementation;

import com.example.mini_cms_clone_backend.entity.Content;
import com.example.mini_cms_clone_backend.pojo.ContentP;
import com.example.mini_cms_clone_backend.repository.ContentRepository;
import com.example.mini_cms_clone_backend.repository.LicenseRepository;
import com.example.mini_cms_clone_backend.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContentServicesImp implements ContentService {
    @Autowired
    ContentRepository contentRepository;
    @Autowired
    LicenseRepository licenseRepository;

    @Override
    public List<ContentP> getAllContents() {
        List<Content> contentEntities = (List<Content>) contentRepository.findAll();
        List<ContentP> contentPS = new ArrayList<>();
        contentEntities.forEach(it -> {
            ContentP contentDto =new ContentP();
            contentDto.setId(it.getId());
            contentDto.setName(it.getName());
            contentDto.setStatus(it.getStatus());
            contentDto.setPosterurl(it.getPosterurl());
            contentDto.setVideourl(it.getVideourl());
            contentPS.add(contentDto);
        });
        return contentPS;
    }

    @Override
    public ContentP addContent(ContentP contentP) {
        Content content = new Content();
        content.setName(contentP.getName());
        content.setStatus(contentP.getStatus());
        content.setPosterurl(contentP.getPosterurl());
        content.setVideourl(contentP.getVideourl());
        Content contentDb = contentRepository.save(content);
        contentP.setId(contentDb.getId());
        return contentP;
    }

    @Override
    public void deleteContent(int id) {
        contentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Content addLicenseToContent(int contentId, int licenseId) {
        /*ContentEntity contentEntity = contentRepository.findById(contentId).get();
        LicenseEntity licenseEntity = licenseRepository.findById(licenseId).get();
        contentEntity.getLicenseEntities().add(licenseEntity);
        return contentRepository.save(contentEntity);*/
        return null;
    }
}
