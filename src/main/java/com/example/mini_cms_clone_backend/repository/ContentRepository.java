package com.example.mini_cms_clone_backend.repository;

import com.example.mini_cms_clone_backend.entity.ContentEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface ContentRepository  extends CrudRepository<ContentEntity, Integer>, JpaSpecificationExecutor<ContentEntity> {

    ContentEntity findOneById(Integer id);

    @Transactional
    @Query(value = "select * from contents order by id desc", nativeQuery = true)
    List<ContentEntity> getAllContents();
}
