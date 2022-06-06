package com.example.mini_cms_clone_backend.controller;

import com.example.mini_cms_clone_backend.entity.ContentEntity;
import com.example.mini_cms_clone_backend.entity.LicenseEntity;
import com.example.mini_cms_clone_backend.pojo.ContentPojo;
import com.example.mini_cms_clone_backend.repository.ContentRepository;
import com.example.mini_cms_clone_backend.repository.LicenseRepository;
import com.example.mini_cms_clone_backend.service.implementation.ContentServices;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/content")
@AllArgsConstructor
public class ContentController{

    private final ContentServices contentServices;
    @Autowired
    ContentRepository contentRepository;
    @Autowired
    LicenseRepository licenseRepository;

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<ContentPojo>> allContentList() {
        return ResponseEntity.ok(contentServices.getAllContents());
    }

    @PostMapping
    public ResponseEntity<ContentPojo> addContents(@RequestBody ContentPojo contentPojo) {
        return ResponseEntity.ok(contentServices.addContent(contentPojo));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteContent(@PathVariable int id){
        contentServices.deleteContent(id);
    }

    @PutMapping("/{contentId}/{licenseId}")
    ContentEntity addLicenseToContent(
            @PathVariable int contentId,
            @PathVariable int licenseId
    ) {
        ContentEntity contentEntity = contentRepository.findById(contentId).get();
        LicenseEntity licenseEntity = licenseRepository.findById(licenseId).get();
        contentEntity.getLicenseEntities().add(licenseEntity);
        return contentRepository.save(contentEntity);
        //contentServices.addLicenseToContent(contentId,licenseId);
    }
}
