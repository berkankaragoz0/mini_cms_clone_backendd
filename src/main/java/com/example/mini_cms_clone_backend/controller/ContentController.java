package com.example.mini_cms_clone_backend.controller;

import com.example.mini_cms_clone_backend.entity.Content;
import com.example.mini_cms_clone_backend.entity.License;
import com.example.mini_cms_clone_backend.pojo.ContentP;
import com.example.mini_cms_clone_backend.repository.ContentRepository;
import com.example.mini_cms_clone_backend.repository.LicenseRepository;
import com.example.mini_cms_clone_backend.service.ContentService;
import com.example.mini_cms_clone_backend.service.implementation.ContentServicesImp;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/content")
@AllArgsConstructor
public class ContentController{

    private final ContentServicesImp contentServicesImp;
    private final ContentService contentService;
    @Autowired
    ContentRepository contentRepository;
    @Autowired
    LicenseRepository licenseRepository;

    @GetMapping
    public ResponseEntity<List<ContentP>> allContentList() {
        return ResponseEntity.ok(contentService.getAllContents());
    }

    @PostMapping
    public ResponseEntity<ContentP> addContents(@RequestBody ContentP contentP) {
        return ResponseEntity.ok(contentService.addContent(contentP));
    }

    @DeleteMapping("/{id}/delete")
    public void deleteContent(@PathVariable int id){
        contentService.deleteContent(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable int id){
        Content content = contentService.getById(id);
        contentService.delete(content);
        return ResponseEntity.ok(id);
    }

    @PutMapping("/{contentId}/{licenseId}")
    Content addLicenseToContent(
            @PathVariable int contentId,
            @PathVariable int licenseId
    ) {
        Content content = contentRepository.findById(contentId).get();
        License license = licenseRepository.findById(licenseId).get();
        content.getLicenseEntities().add(license);
        return contentRepository.save(content);
        //contentServices.addLicenseToContent(contentId,licenseId);
    }
}
