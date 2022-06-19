package com.example.mini_cms_clone_backend.controller;

import com.example.mini_cms_clone_backend.entity.Content;
import com.example.mini_cms_clone_backend.entity.License;
import com.example.mini_cms_clone_backend.pojo.ContentP;
import com.example.mini_cms_clone_backend.repository.ContentRepository;
import com.example.mini_cms_clone_backend.repository.LicenseRepository;
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
    @Autowired
    ContentRepository contentRepository;
    @Autowired
    LicenseRepository licenseRepository;

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<ContentP>> allContentList() {
        return ResponseEntity.ok(contentServicesImp.getAllContents());
    }

    @PostMapping
    public ResponseEntity<ContentP> addContents(@RequestBody ContentP contentP) {
        return ResponseEntity.ok(contentServicesImp.addContent(contentP));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteContent(@PathVariable int id){
        contentServicesImp.deleteContent(id);
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
