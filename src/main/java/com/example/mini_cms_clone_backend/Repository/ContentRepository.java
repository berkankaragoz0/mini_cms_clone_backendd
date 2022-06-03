package com.example.mini_cms_clone_backend.Repository;

import com.example.mini_cms_clone_backend.Entity.ContentEntity;
import com.example.mini_cms_clone_backend.Pojo.ContentPojo;
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
