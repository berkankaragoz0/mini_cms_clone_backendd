package com.example.mini_cms_clone_backend.logic;

import com.example.mini_cms_clone_backend.repository.ContentRepository;
import com.example.mini_cms_clone_backend.repository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ContentFlow {

    @Autowired
    ContentRepository contentRepository;

    @Autowired
    LicenseRepository licenseRepository;


}
