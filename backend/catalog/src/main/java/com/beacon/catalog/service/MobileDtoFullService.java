package com.beacon.catalog.service;

import com.beacon.model.MobileDtoFull;
import org.springframework.lang.NonNull;

import java.util.Optional;

/**
 * The service layout is to use one transaction for several connection to a database if it is needed.
 * Work with {@link MobileDtoFull} model.
 */
public interface MobileDtoFullService {

    /**
     * Find a mobile dto with full information by mobile id in a database.
     *
     * @param mobileId - id string of a mobile model.
     * @return optional with {@link MobileDtoFull} model.
     */
    Optional<MobileDtoFull> findMobileDtoFullById(String mobileId);

    /**
     * Save or update mobileDtoFull
     *
     * @param mobileDtoFull entity that will be saved or updated.
     * @return new saved mobile dto full model.
     */
    MobileDtoFull saveMobileDtoFull(MobileDtoFull mobileDtoFull);

    /**
     * Generate a complex id for the incoming {@code MobileDtoFull}
     *
     * @param m incoming {@code MobileDtoFull}
     */
    default void generateMobileId(@NonNull MobileDtoFull m) {
        m.setMobileId(
                String.format("%s%s%d%d%s", m.getBrand(), m.getModel(), m.getRam(), m.getStorageCapacity(), m.getColor())
                        .strip()
                        .replaceAll("[+]", "plus")
                        .replaceAll("[-\\s\\p{Punct}]", "")
                        .toLowerCase()
        );
    }
}
