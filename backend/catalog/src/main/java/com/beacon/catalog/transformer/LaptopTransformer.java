package com.beacon.catalog.transformer;

import com.beacon.model.dtos.ImageDto;
import com.beacon.model.dtos.LaptopDto;
import com.beacon.model.product.LaptopType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.persistence.Tuple;
import java.time.LocalTime;
import java.util.*;

@Component
public class LaptopTransformer {

    private static final Logger LOGGER = LoggerFactory.getLogger(LaptopTransformer.class);

    public List<LaptopDto> transformList(List<Object[]> rs) {
        final Map<String, LaptopDto> laptopDtoMap = new HashMap<>();
        for (Object[] o : rs) {
            String laptopId = (String) o[0];
            LaptopDto laptopDto = laptopDtoMap.getOrDefault(laptopId, createDefaultLaptopDto(o));
            laptopDto.addNotMainImage(getNotMainImages(o));
            laptopDtoMap.putIfAbsent(laptopDto.getComputerId(), laptopDto);
        }
        return new ArrayList<>(laptopDtoMap.values());
    }

    public List<LaptopDto> transformTupleList(List<Tuple> rs) {
        final Map<String, LaptopDto> laptopDtoMap = new HashMap<>();
        for (Tuple tuple : rs) {
            String laptopId = tuple.get("computerId", String.class);
            LaptopDto laptopDto = laptopDtoMap.getOrDefault(laptopId, createDefaultLaptopDto(tuple));
            laptopDto.addNotMainImage(getNotMainImages(tuple));
            laptopDtoMap.putIfAbsent(laptopDto.getComputerId(), laptopDto);
        }
        return new ArrayList<>(laptopDtoMap.values());
    }

    public Optional<LaptopDto> transform(List<Object[]> rs) {
        LaptopDto laptopDto = null;
        for (Object[] o : rs) {
            if (laptopDto == null) {
                laptopDto = createDefaultLaptopDto(o);
            }
            if (!Objects.equals(laptopDto.getComputerId(), o[0])) {
                LOGGER.error("There are more than one laptops found. Ids are not match: id={}, second id={}", laptopDto.getComputerId(), o[0]);
                return Optional.empty();
            }
            laptopDto.addNotMainImage(getNotMainImages(o));
        }
        return Optional.ofNullable(laptopDto);
    }

    public Optional<LaptopDto> transformFromTuple(List<Tuple> rs) {
        LaptopDto laptopDto = null;
        for (Tuple tuple : rs) {
            if (laptopDto == null) {
                laptopDto = createDefaultLaptopDto(tuple);
            }
            if (!Objects.equals(laptopDto.getComputerId(), tuple.get("computerId"))) {
                LOGGER.error("There are more than one laptops found. Ids are not match: id={}, second id={}", laptopDto.getComputerId(), tuple.get("computerId"));
                return Optional.empty();
            }
            laptopDto.addNotMainImage(getNotMainImages(tuple));
        }
        return Optional.ofNullable(laptopDto);
    }
    
    private LaptopDto createDefaultLaptopDto(Object[] o) {
        return LaptopDto.builder()
                .computerId((String) o[0])
                .brand((String) o[1])
                .model((String) o[2])
                .subModel((String) o[3])
                .serialId((String) o[4])
                .releaseYear((String) o[5])
                .type((LaptopType) o[6])

                // Processor
                .processorPlatform((String) o[7])
                .processor((String) o[8])
                .processorModel((String) o[9])
                .processorNumber((Integer) o[10])
                .processorThreadNumber((Integer) o[11])
                .processorClockFrequency((Integer) o[12])
                .processorMaxClockFrequency((Integer) o[13])
                .processorTDP((Integer) o[14])

                // Construction
                .caseMaterial((String) o[15])
                .caseColor((String) o[16])
                .lidMaterial((String) o[17])
                .lidColor((String) o[18])
                .caseLighting((Boolean) o[19])

                // Size
                .width((Double) o[20])
                .length((Double) o[21])
                .height((Double) o[22])
                .weight((Double) o[23])

                // Screen
                .screenSize((Double) o[24])
                .screenResolution((String) o[25])
                .refreshRate((Integer) o[26])
                .displayTechnology((String) o[27])
                .displayBrightness((Integer) o[28])
                .screenCover((String) o[29])
                .sensorDisplay((Boolean) o[30])
                .displayCharacteristics((String) o[31])

                // RAM
                .ramType((String) o[32])
                .ramClockFrequency((Integer) o[33])
                .ram((Integer) o[34])
                .ramMax((Integer) o[35])
                .ramMaxSlots((Integer) o[36])
                .ramFreeSlots((Integer) o[37])

                // Hard Disk
                .storageType((String) o[38])
                .storageCapacity((Integer) o[39])
                .storageSlots((Integer) o[40])
                .storageInterfaceType((String) o[41])
                .odd((Boolean) o[42])

                // Graphics
                .discreteCoprocessor((Boolean) o[43])
                .graphicsModel((String) o[44])
                .graphicsCapacity((Integer) o[45])
                .graphicsCharacteristics((String) o[46])

                // Camera and Sound
                .camera((Boolean) o[47])
                .cameraResolution((Integer) o[48])
                .microphone((Boolean) o[49])
                .microphoneNumber((Integer) o[50])
                .dynamicNumber((Integer) o[51])

                // Keyboard
                .numpad((Boolean) o[52])
                .keyboardLighting((Boolean) o[53])
                .keyboardLightingColor((String) o[54])
                .touchpad((Boolean) o[55])

                // Interfaces
                .nfc((Boolean) o[56])
                .bluetooth((Boolean) o[57])
                .bluetoothVersion((String) o[58])
                .lan((Boolean) o[59])
                .lanVersion((String) o[60])
                .wifi((Boolean) o[61])
                .wifiVersion((String) o[62])
                .usb((Boolean) o[63])
                .usbNumber((Integer) o[64])
                .typeC((Boolean) o[65])
                .typeCNumber((Integer) o[66])
                .vga((Boolean) o[67])
                .vgaVersion((String) o[68])
                .hdmi((Boolean) o[69])
                .hdmiVersion((String) o[70])
                .jack((Boolean) o[71])
                .jackNumber((Integer) o[72])

                // Battery
                .energyCapacity((Integer) o[73])
                .workTime((LocalTime) o[74])
                .typeCCharge((Boolean) o[75])

                // OS
                .os((Boolean) o[76])
                .osType((String) o[77])
                //Image
                .computerMainImage(ImageDto.builder().imageId((Long) o[78]).image((byte[]) o[79]).build())
                .build();
    }

    private LaptopDto createDefaultLaptopDto(Tuple tuple) {
        return LaptopDto.builder()
                .computerId((String) tuple.get("computerId"))
                .brand((String) tuple.get("computerId"))
                .model((String) tuple.get("computerId"))
                .subModel((String) tuple.get("computerId"))
                .serialId((String) tuple.get("computerId"))
                .releaseYear((String) tuple.get("releaseYear"))
                .type((LaptopType) tuple.get("type"))

                // Processor
                .processorPlatform((String) tuple.get("processorPlatform"))
                .processor((String) tuple.get("processor"))
                .processorModel((String) tuple.get("processorModel"))
                .processorNumber((Integer) tuple.get("processorNumber"))
                .processorThreadNumber((Integer) tuple.get("processorThreadNumber"))
                .processorClockFrequency((Integer) tuple.get("processorClockFrequency"))
                .processorMaxClockFrequency((Integer) tuple.get("processorMaxClockFrequency"))
                .processorTDP((Integer) tuple.get("processorTDP"))

                // Construction
                .caseMaterial((String) tuple.get("caseMaterial"))
                .caseColor((String) tuple.get("caseColor"))
                .lidMaterial((String) tuple.get("lidMaterial"))
                .lidColor((String) tuple.get("lidColor"))
                .caseLighting((Boolean) tuple.get("caseLighting"))

                // Size
                .width((Double) tuple.get("width"))
                .length((Double) tuple.get("length"))
                .height((Double) tuple.get("height"))
                .weight((Double) tuple.get("weight"))

                // Screen
                .screenSize((Double) tuple.get("screenSize"))
                .screenResolution((String) tuple.get("screenResolution"))
                .refreshRate((Integer) tuple.get("refreshRate"))
                .displayTechnology((String) tuple.get("displayTechnology"))
                .displayBrightness((Integer) tuple.get("displayBrightness"))
                .screenCover((String) tuple.get("screenCover"))
                .sensorDisplay((Boolean) tuple.get("sensorDisplay"))
                .displayCharacteristics((String) tuple.get("displayCharacteristics"))

                // RAM
                .ramType((String) tuple.get("ramType"))
                .ramClockFrequency((Integer) tuple.get("ramClockFrequency"))
                .ram((Integer) tuple.get("ram"))
                .ramMax((Integer) tuple.get("ramMax"))
                .ramMaxSlots((Integer) tuple.get("ramMaxSlots"))
                .ramFreeSlots((Integer) tuple.get("ramFreeSlots"))

                // Hard Disk
                .storageType((String) tuple.get("storageType"))
                .storageCapacity((Integer) tuple.get("storageCapacity"))
                .storageSlots((Integer) tuple.get("storageSlots"))
                .storageInterfaceType((String) tuple.get("storageInterfaceType"))
                .odd((Boolean) tuple.get("odd"))

                // Graphics
                .discreteCoprocessor((Boolean) tuple.get("discreteCoprocessor"))
                .graphicsModel((String) tuple.get("graphicsModel"))
                .graphicsCapacity((Integer) tuple.get("graphicsCapacity"))
                .graphicsCharacteristics((String) tuple.get("graphicsCharacteristics"))

                // Camera and Sound
                .camera((Boolean) tuple.get("camera"))
                .cameraResolution((Integer) tuple.get("cameraResolution"))
                .microphone((Boolean) tuple.get("microphone"))
                .microphoneNumber((Integer) tuple.get("microphoneNumber"))
                .dynamicNumber((Integer) tuple.get("dynamicNumber"))

                // Keyboard
                .numpad((Boolean) tuple.get("numpad"))
                .keyboardLighting((Boolean) tuple.get("keyboardLighting"))
                .keyboardLightingColor((String) tuple.get("keyboardLightingColor"))
                .touchpad((Boolean) tuple.get("touchpad"))

                // Interfaces
                .nfc((Boolean) tuple.get("nfc"))
                .bluetooth((Boolean) tuple.get("bluetooth"))
                .bluetoothVersion((String) tuple.get("bluetoothVersion"))
                .lan((Boolean) tuple.get("lan"))
                .lanVersion((String) tuple.get("lanVersion"))
                .wifi((Boolean) tuple.get("wifi"))
                .wifiVersion((String) tuple.get("wifiVersion"))
                .usb((Boolean) tuple.get("usb"))
                .usbNumber((Integer) tuple.get("usbNumber"))
                .typeC((Boolean) tuple.get("typeC"))
                .typeCNumber((Integer) tuple.get("typeCNumber"))
                .vga((Boolean) tuple.get("vga"))
                .vgaVersion((String) tuple.get("vgaVersion"))
                .hdmi((Boolean) tuple.get("hdmi"))
                .hdmiVersion((String) tuple.get("hdmiVersion"))
                .jack((Boolean) tuple.get("jack"))
                .jackNumber((Integer) tuple.get("jackNumber"))

                // Battery
                .energyCapacity((Integer) tuple.get("energyCapacity"))
                .workTime((LocalTime) tuple.get("workTime"))
                .typeCCharge((Boolean) tuple.get("typeCCharge"))

                // OS
                .os((Boolean) tuple.get("os"))
                .osType((String) tuple.get("osType"))
                //Image
                .computerMainImage(ImageDto.builder().imageId((Long) tuple.get("imageId")).image((byte[]) tuple.get("image")).build())
                .build();
    }

    private ImageDto getNotMainImages(Object[] o) {
        return new ImageDto((Long) o[80], (byte[]) o[81]);
    }

    private ImageDto getNotMainImages(Tuple tuple) {
        return new ImageDto((Long) tuple.get("notImageId"), (byte[]) tuple.get("notImage"));
    }
}
