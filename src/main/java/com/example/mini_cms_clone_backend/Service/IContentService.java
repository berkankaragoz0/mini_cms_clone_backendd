package com.example.mini_cms_clone_backend.Service;

import com.example.mini_cms_clone_backend.Entity.ContentEntity;
import com.example.mini_cms_clone_backend.Pojo.ContentPojo;

import java.util.List;

public interface IContentService {
    List<ContentPojo> getAllContents();
}
