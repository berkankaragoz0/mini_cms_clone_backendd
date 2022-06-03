package com.example.mini_cms_clone_backend.Service;

import com.example.mini_cms_clone_backend.Entity.ContentEntity;
import com.example.mini_cms_clone_backend.Pojo.ContentPojo;
import com.example.mini_cms_clone_backend.Repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContentServices implements IContentService{
    @Autowired
    ContentRepository contentRepository;

    @Override
    public List<ContentPojo> getAllContents() {
        List<ContentEntity> contentEntities = (List<ContentEntity>) contentRepository.findAll();
        List<ContentPojo> contentPojos = new ArrayList<>();

        contentEntities.forEach(it -> {
            ContentPojo contentDto =new ContentPojo();
            contentDto.setId(it.getId());
            contentDto.setName(it.getName());
            contentDto.setStatus(it.getStatus());
            contentDto.setPosterUrl(it.getPosterUrl());
            contentDto.setVideoUrl(it.getVideoUrl());

            contentPojos.add(contentDto);
        });
        return contentPojos;
    }
}
