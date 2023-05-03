package com.beacon.catalog.dao;

import com.beacon.model.MobileImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface MobileImageDao extends JpaRepository<MobileImage, Long> {

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query("DELETE FROM MobileImage mi WHERE mi.mobile.mobileId = ?1")
    int deleteByMobileIdentifier(String id);
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query("DELETE FROM MobileImage mi WHERE mi.mobile.mobileId IN ?1")
    int deleteBulkByIdentifiers(Iterable<String> ids);
}
