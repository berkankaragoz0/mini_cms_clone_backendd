package com.example.mini_cms_clone_backend.controller;

import com.example.mini_cms_clone_backend.pojo.ContentPojo;
import com.example.mini_cms_clone_backend.service.implementation.ContentServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<ContentPojo> addContents(@RequestBody ContentPojo contentPojo) {
        return ResponseEntity.ok(contentServices.addContent(contentPojo));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteContent(@PathVariable int id){
        contentServices.deleteContent(id);
    }

}
