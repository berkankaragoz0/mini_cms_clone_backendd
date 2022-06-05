package com.example.mini_cms_clone_backend.service.implementation;

import com.example.mini_cms_clone_backend.entity.ContentEntity;
import com.example.mini_cms_clone_backend.pojo.ContentPojo;
import com.example.mini_cms_clone_backend.repository.ContentRepository;
import com.example.mini_cms_clone_backend.service.IContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContentServices implements IContentService {
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

    @Override
    public ContentPojo addContent(ContentPojo contentPojo) {
        ContentEntity contentEntity = new ContentEntity();
        contentEntity.setName(contentPojo.getName());
        contentEntity.setStatus(contentPojo.getStatus());
        contentEntity.setPosterUrl(contentPojo.getPosterUrl());
        contentEntity.setVideoUrl(contentPojo.getVideoUrl());
        final ContentEntity contentDb = contentRepository.save(contentEntity);
        contentPojo.setId(contentDb.getId());
        return contentPojo;
    }

    @Override
    public void deleteContent(int id) {
        contentRepository.deleteById(id);
    }
}
