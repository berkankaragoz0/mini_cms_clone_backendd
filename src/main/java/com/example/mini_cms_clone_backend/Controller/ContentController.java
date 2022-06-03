package com.example.mini_cms_clone_backend.Controller;

import com.example.mini_cms_clone_backend.Pojo.ContentPojo;
import com.example.mini_cms_clone_backend.Service.ContentServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contents")
public class ContentController{

    private final ContentServices contentServices;

    public ContentController(ContentServices contentServices) {
        this.contentServices = contentServices;
    }

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<ContentPojo>> allContentList() {
        return ResponseEntity.ok(contentServices.getAllContents());
    }


}
