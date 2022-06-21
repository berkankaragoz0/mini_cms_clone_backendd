package com.example.mini_cms_clone_backend.service.implementation;

import com.example.mini_cms_clone_backend.constant.Status;
import com.example.mini_cms_clone_backend.entity.Content;
import com.example.mini_cms_clone_backend.entity.License;
import com.example.mini_cms_clone_backend.log.LogGenerator;
import com.example.mini_cms_clone_backend.pojo.ContentP;
import com.example.mini_cms_clone_backend.repository.ContentRepository;
import com.example.mini_cms_clone_backend.repository.LicenseRepository;
import com.example.mini_cms_clone_backend.service.ContentService;
import com.example.mini_cms_clone_backend.specification.ContentSpecificationBuilder;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    public List<Content> getAll(String title, Status[] status, String[] sortParam) {
        log.info(LogGenerator.enter("title : " + title +
                "| status : " + status + "| sortParam : " + sortParam));

        ContentSpecificationBuilder builder = new ContentSpecificationBuilder();
        if (title != null) {
            builder.with("title",":", title);
        }
        if (status != null) {
            builder.with("status",":", status);
        }
        List<String> sortParams;
        if (sortParam != null) {
            sortParams = Arrays.asList(sortParam);
            builder.with("sort", "sort", sortParams);
        } else {
            sortParams = Collections.singletonList("id-desc");
        }
        builder.with("sort", "sort", sortParams);

        return contentRepository.findAll(builder.build());
    }

    @Override
    public Page<Content> getAllPageable(Integer page, Integer itemCount, String title, Status[] status, String[] sortParam) {
        log.info(LogGenerator.enter("page : " + page + "| itemCount : " + itemCount + "| title : " + title +
                "| status : " + status + "| sortParam : " + sortParam));
        if (page==null){
            page=0;
        }
        if (itemCount == null){
            itemCount=10;
        }
        Pageable pageable;
        pageable = PageRequest.of(page, itemCount);
        ContentSpecificationBuilder builder = new ContentSpecificationBuilder();
        if (title != null) {
            builder.with("title",":", title);
        }
        if (status != null) {
            builder.with("status",":", status);
        }
        List<String> sortParams;
        if (sortParam != null) {
            sortParams = Arrays.asList(sortParam);
            builder.with("sort", "sort", sortParams);
        } else {
            sortParams = Collections.singletonList("id-desc");
        }
        builder.with("sort", "sort", sortParams);

        return contentRepository.findAll(builder.build(), pageable);
    }

    @Override
    public ContentP createContent(ContentP contentP) {
        log.info(LogGenerator.enter("content : " + contentP));
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

    @Override
    public Content edit(ContentP contentP) {
        log.info(LogGenerator.enter("content : " + contentP));
        Content content = new Content();
        content.setId(contentP.getId());
        content.setName(contentP.getName());
        content.setPosterUrl(contentP.getPosterUrl());
        content.setVideoUrl(contentP.getVideoUrl());
        content.setStatus(contentP.getStatus());
        contentRepository.save(content);
        return content;
    }
}
