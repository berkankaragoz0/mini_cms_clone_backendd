package com.example.mini_cms_clone_backend.repository;

import com.example.mini_cms_clone_backend.entity.License;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface LicenseRepository  extends CrudRepository<License, Integer>, JpaSpecificationExecutor<License> {

    License findOneById(Integer id);

    @Transactional
    @Query(value = "select * from licenses order by id desc", nativeQuery = true)
    List<License> getAllLicenses();
}
