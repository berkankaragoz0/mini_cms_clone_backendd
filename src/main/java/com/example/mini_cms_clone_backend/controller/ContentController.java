package com.example.mini_cms_clone_backend.controller;

import com.example.mini_cms_clone_backend.pojo.ContentPojo;
import com.example.mini_cms_clone_backend.service.implementation.ContentServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contents")
@AllArgsConstructor
public class ContentController{

    private final ContentServices contentServices;

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<ContentPojo>> allContentList() {
        return ResponseEntity.ok(contentServices.getAllContents());
    }
}
