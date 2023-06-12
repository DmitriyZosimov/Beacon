package com.beacon.catalog.dao;

import com.beacon.model.dtos.LaptopPreviewDto;
import com.beacon.model.product.Laptop;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface LaptopDao extends JpaRepository<Laptop, String> {

    String FIND_ALL_BY = "SELECT l.computerId AS computerId, l.brand AS brand, l.model AS model, l.subModel AS subModel, " +
            "l.serialId AS serialId, l.releaseYear AS releaseYear, l.type AS type, l.processorPlatform AS processorPlatform, " +
            "l.processor AS processor, l.processorModel AS processorModel, l.processorNumber AS processorNumber, " +
            "l.processorThreadNumber AS processorThreadNumber, l.processorClockFrequency AS processorClockFrequency, " +
            "l.processorMaxClockFrequency AS processorMaxClockFrequency, l.processorTDP AS processorTDP, " +
            "l.caseMaterial AS caseMaterial, l.caseColor AS caseColor, l.lidMaterial AS lidMaterial, l.lidColor AS lidColor, " +
            "l.caseLighting AS caseLighting, l.width AS width, l.length AS length, l.height AS height, l.weight AS weight, " +
            "l.screenSize AS screenSize, l.screenResolution AS screenResolution, l.refreshRate AS refreshRate, " +
            "l.displayTechnology AS displayTechnology, l.displayBrightness AS displayBrightness, l.screenCover AS screenCover, " +
            "l.sensorDisplay AS sensorDisplay, l.displayCharacteristics AS displayCharacteristics, l.ramType AS ramType, " +
            "l.ramClockFrequency AS ramClockFrequency, l.ram AS ram, l.ramMax AS ramMax, l.ramMaxSlots AS ramMaxSlots, " +
            "l.ramFreeSlots AS ramFreeSlots, l.storageType AS storageType, l.storageCapacity AS storageCapacity, " +
            "l.storageSlots AS storageSlots, l.storageInterfaceType AS storageInterfaceType, l.odd AS odd, " +
            "l.discreteCoprocessor AS discreteCoprocessor, l.graphicsModel AS graphicsModel, l.graphicsCapacity AS graphicsCapacity, " +
            "l.graphicsCharacteristics AS graphicsCharacteristics, l.camera AS camera, l.cameraResolution AS cameraResolution, " +
            "l.microphone AS microphone, l.microphoneNumber AS microphoneNumber, l.dynamicNumber AS dynamicNumber, " +
            "l.numpad AS numpad, l.keyboardLighting AS keyboardLighting, l.keyboardLightingColor AS keyboardLightingColor, " +
            "l.touchpad AS touchpad, l.nfc AS nfc, l.bluetooth AS bluetooth, l.bluetoothVersion AS bluetoothVersion, " +
            "l.lan AS lan, l.lanVersion AS lanVersion, l.wifi AS wifi, l.wifiVersion AS wifiVersion, l.usb AS usb, " +
            "l.usbNumber AS usbNumber, l.typeC AS typeC, l.typeCNumber AS typeCNumber, l.vga AS vga, l.vgaVersion AS vgaVersion, " +
            "l.hdmi AS hdmi, l.hdmiVersion AS hdmiVersion, l.jack AS jack, l.jackNumber AS jackNumber, l.energyCapacity " +
            "AS energyCapacity, l.workTime AS workTime, l.typeCCharge AS typeCCharge, l.os AS os, l.osType AS osType, " +
            "m.imageId AS imageId, m.image AS image, n.imageId AS notImageId, n.image AS notImage FROM Laptop l " +
            "LEFT JOIN l.computerMainImage m LEFT JOIN l.computerNotMainImages n";

    String FIND_BY_COMPUTER_ID = FIND_ALL_BY + " WHERE l.computerId = :computerId";

//    @EntityGraph(value = "laptop-test", type = EntityGraph.EntityGraphType.FETCH)
    @Query("SELECT l.computerId AS computerId, l.brand AS brand, l.model AS model, l.subModel AS subModel, " +
            "l.serialId AS serialId, l.type AS type, " +
            "cid.image AS image " +
            " FROM Laptop l LEFT JOIN l.computerMainImage cid")
    Set<LaptopPreviewDto> findAllPreviewBy();

    @Query(value = FIND_ALL_BY)
    List<Object[]> findAllBy();

    @Query(value = FIND_ALL_BY)
    List<Tuple> findAllByToTuple();

    @EntityGraph(value = "laptop-all", type = EntityGraph.EntityGraphType.FETCH)
    <T> Optional<T> findByComputerId(String id, Class<T> type);

    @Query(value = FIND_BY_COMPUTER_ID)
    List<Object[]> findByComputerId(@Param("computerId") String computerId);

    @Query(value = FIND_BY_COMPUTER_ID)
    List<Tuple> findByComputerIdToTuple(@Param("computerId") String computerId);

}
