package com.example.mini_cms_clone_backend.service;

import com.example.mini_cms_clone_backend.constant.Status;
import com.example.mini_cms_clone_backend.entity.Content;
import com.example.mini_cms_clone_backend.entity.License;
import com.example.mini_cms_clone_backend.pojo.ContentP;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ContentService {
    Content getById(int id);
    List<Content> getAll(String title, Status[] status, String[] sortParam);
    Page<Content> getAllPageable(Integer page, Integer itemCount, String title, Status[] status, String[] sortParam);
    ContentP createContent(ContentP contentP);
    void deleteContent(int id);
    void delete(Content content);
    void addLicenseToContent(Content content, License license);
    void deleteLicenseToContent(int contentId, int licenseId);
    Content edit(ContentP contentP);
}
