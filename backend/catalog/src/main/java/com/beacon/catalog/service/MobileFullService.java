package com.beacon.catalog.service;

import com.beacon.model.MobileFull;
import org.springframework.lang.NonNull;

import java.util.Optional;

/**
 * The service layout is to use one transaction for several connection to a database if it is needed.
 * Work with {@link MobileFull} model.
 */
public interface MobileFullService {

    /**
     * Find a mobile with full information by mobile id in a database.
     *
     * @param mobileId - id string of a mobile model.
     * @return optional with {@link MobileFull} model.
     */
    Optional<MobileFull> findMobileFullById(String mobileId);

    /**
     * Save or update MobileFull
     *
     * @param MobileFull entity that will be saved or updated.
     * @return new saved mobile dto full model.
     */
    MobileFull saveMobileFull(MobileFull MobileFull);

    /**
     * Generate a complex id for the incoming {@code MobileFull}
     *
     * @param m incoming {@code MobileFull}
     */
    default void generateMobileId(@NonNull MobileFull m) {
        m.setMobileId(
                String.format("%s%s%d%d%s", m.getBrand(), m.getModel(), m.getRam(), m.getStorageCapacity(), m.getColor())
                        .strip()
                        .replaceAll("[+]", "plus")
                        .replaceAll("[-\\s\\p{Punct}]", "")
                        .toLowerCase()
        );
    }
}
