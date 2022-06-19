package com.example.mini_cms_clone_backend.repository;

import com.example.mini_cms_clone_backend.entity.Content;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface ContentRepository  extends CrudRepository<Content, Integer>, JpaSpecificationExecutor<Content> {

    Content findOneById(Integer id);

    @Transactional
    @Query(value = "select * from contents order by id desc", nativeQuery = true)
    List<Content> getAllContents();

    /*@Transactional
    @Modifying
    @Query(value = "insert into content_licence values(:contentid, :licenseid)", nativeQuery = true)
    Integer addLicenseToContent(@Param("licenseid") Integer licenseId, @Param("contentid") Integer contentId);*/

}
