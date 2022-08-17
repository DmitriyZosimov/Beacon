package com.beacon.catalog.dao;

import com.beacon.model.MobileFull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Dao class is to manipulate with mobile data of {@link MobileFull} entity in database.
 */
@Repository
public interface MobileFullDao extends JpaRepository<MobileFull, String> {
}
