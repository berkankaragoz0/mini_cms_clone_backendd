package com.example.mini_cms_clone_backend.repository;

import com.example.mini_cms_clone_backend.entity.Content;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ContentRepository  extends CrudRepository<Content, Integer>, JpaSpecificationExecutor<Content> {

    Content findOneById(Integer id);

    @Transactional
    @Query(value = "select * from contents order by id desc", nativeQuery = true)
    List<Content> getAllContents();

    @Transactional
    @Modifying
    @Query(value = "delete from content_license where content_id=:contentid and license_id=:licenseid", nativeQuery = true)
    Integer deletedLicenseToContent(@Param("contentid") int contentId, @Param("licenseid") int licenseId);

    @Query("select count(l) > 0 from Content c join c.licenseEntities l where c.id = ?1 and l.status = 'ACTIVE'")
    Boolean existsActiveLicense(int contentId);
}
