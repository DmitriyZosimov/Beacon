package com.beacon.catalog.dao;

import com.beacon.model.MobileFull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Dao class is to manipulate with mobile data of {@link MobileFull} entity in database.
 */
@Repository
public interface MobileFullDao extends JpaRepository<MobileFull, String> {

    Optional<MobileFull> findByMobileId(String mobileId);

    int deleteByMobileId(String mobileId);

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query("DELETE FROM MobileFull mf WHERE mf.mobileId IN ?1")
    int deleteBulkMobileFullByIdentifiers(Iterable<String> ids);

    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(value = "DELETE FROM offers of WHERE of.mobile_id IN :ids", nativeQuery = true)
    int deleteBulkOffersByMobileIdentifiers(@Param("ids") Iterable<String> ids);
}
