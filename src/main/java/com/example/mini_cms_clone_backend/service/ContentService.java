package com.example.mini_cms_clone_backend.service;

import com.example.mini_cms_clone_backend.entity.Content;
import com.example.mini_cms_clone_backend.entity.License;
import com.example.mini_cms_clone_backend.pojo.ContentP;

import java.util.List;

public interface ContentService {
    Content getById(int id);
    List<ContentP> getAllContents();
    ContentP addContent(ContentP contentP);
    void deleteContent(int id);
    void delete(Content content);
    void addLicenseToContent(Content content, License license);
    void deleteLicenseToContent(int contentId, int licenseId);
}
