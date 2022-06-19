package com.example.mini_cms_clone_backend.service;

import com.example.mini_cms_clone_backend.entity.Content;
import com.example.mini_cms_clone_backend.pojo.ContentP;

import java.util.List;

public interface ContentService {
    List<ContentP> getAllContents();
    ContentP addContent(ContentP contentP);
    void deleteContent(int id);
    Content addLicenseToContent(int contentId, int licenseId);
}
