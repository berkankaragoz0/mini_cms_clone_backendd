package com.example.mini_cms_clone_backend.service;

import com.example.mini_cms_clone_backend.pojo.ContentPojo;

import java.util.List;

public interface IContentService {
    List<ContentPojo> getAllContents();
    ContentPojo addContent(ContentPojo contentPojo);
    void deleteContent(int id);
}
