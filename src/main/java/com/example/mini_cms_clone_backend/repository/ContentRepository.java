package com.example.mini_cms_clone_backend.repository;

import com.example.mini_cms_clone_backend.entity.ContentEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ContentRepository  extends CrudRepository<ContentEntity, Integer>, JpaSpecificationExecutor<ContentEntity> {

    ContentEntity findOneById(Integer id);

    @Transactional
    @Query(value = "select * from contents order by id desc", nativeQuery = true)
    List<ContentEntity> getAllContents();

    /*@Transactional
    @Modifying
    @Query(value = "insert into content_licence values(:contentid, :licenseid)", nativeQuery = true)
    Integer addLicenseToContent(@Param("licenseid") Integer licenseId, @Param("contentid") Integer contentId);*/

}
