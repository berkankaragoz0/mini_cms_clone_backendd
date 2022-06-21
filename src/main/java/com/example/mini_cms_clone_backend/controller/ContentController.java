package com.example.mini_cms_clone_backend.controller;

import com.example.mini_cms_clone_backend.constant.Status;
import com.example.mini_cms_clone_backend.entity.Content;
import com.example.mini_cms_clone_backend.entity.License;
import com.example.mini_cms_clone_backend.log.LogGenerator;
import com.example.mini_cms_clone_backend.pojo.ContentP;
import com.example.mini_cms_clone_backend.repository.ContentRepository;
import com.example.mini_cms_clone_backend.repository.LicenseRepository;
import com.example.mini_cms_clone_backend.response.ErrorResponse;
import com.example.mini_cms_clone_backend.service.ContentService;
import com.example.mini_cms_clone_backend.service.LicenseService;
import com.example.mini_cms_clone_backend.service.implementation.ContentServicesImp;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.ws.rs.QueryParam;

import java.util.List;

@RestController
@RequestMapping("/content")
@Log4j2
@AllArgsConstructor
public class ContentController{

    private final ContentService contentService;
    private final LicenseService licenseService;
    @Autowired
    ContentRepository contentRepository;
    @Autowired
    LicenseRepository licenseRepository;

    @GetMapping
    public ResponseEntity allContentList(@QueryParam("pageable") Boolean pageable,
                                         @QueryParam("page") Integer page,
                                         @QueryParam("itemCount") Integer itemCount,
                                         @QueryParam("title") String title,
                                         @QueryParam("status") Status[] status,
                                         @QueryParam("sortParam") String[] sortParam) {
        pageable = pageable == null ? true : pageable;
        if (pageable) {
            return ResponseEntity.ok(contentService.getAllPageable(page, itemCount, title, status, sortParam));
        }
        return ResponseEntity.ok(contentService.getAll(title, status, sortParam));
    }

    @PostMapping
    public ResponseEntity addContents(@RequestBody ContentP contentP) {
        try {
            return ResponseEntity.ok(contentService.createContent(contentP));
        } catch (Exception e) {
            log.error(LogGenerator.error("Content create can not execute"));
            log.error(LogGenerator.exception(e), e);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            e.getMessage()));
        }
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

    @PutMapping
    public ResponseEntity editContent(@RequestBody ContentP contentP){
        Content tempContent = contentService.getById(contentP.getId());
        if (tempContent == null){
            return new ResponseEntity(
                    new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "There is no Content with id : "+ contentP.getId()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(contentService.edit(contentP));
    }
}
