package com.beacon.catalog.dao;

import com.beacon.model.MobileDtoFull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Dao class is to manipulate with mobile data of {@link MobileDtoFull} entity in database.
 */
@Repository
public interface MobileDtoFullDao extends JpaRepository<MobileDtoFull, String> {
}
