package com.example.mini_cms_clone_backend.controller;

import com.example.mini_cms_clone_backend.constant.Status;
import com.example.mini_cms_clone_backend.entity.Content;
import com.example.mini_cms_clone_backend.entity.License;
import com.example.mini_cms_clone_backend.pojo.ContentP;
import com.example.mini_cms_clone_backend.repository.ContentRepository;
import com.example.mini_cms_clone_backend.repository.LicenseRepository;
import com.example.mini_cms_clone_backend.service.ContentService;
import com.example.mini_cms_clone_backend.service.LicenseService;
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

    private final ContentService contentService;
    private final LicenseService licenseService;
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
    public ResponseEntity addLicenseToContent(@PathVariable int contentId, @PathVariable int licenseId) {
        Content content = contentService.getById(contentId);
        License license = licenseService.getById(licenseId);
        contentService.addLicenseToContent(content, license);
        return ResponseEntity.ok("Content ID : "+contentId+" | License ID : "+licenseId);
    }
    @DeleteMapping("/deletelicense/{contentId}/{licenseId}")
    public void deleteLicenseToContent(@PathVariable int contentId, @PathVariable int licenseId) {
        contentService.deleteLicenseToContent(contentId, licenseId);
    }
}
