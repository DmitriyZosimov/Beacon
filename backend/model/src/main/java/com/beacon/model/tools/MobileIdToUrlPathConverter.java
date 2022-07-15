package com.beacon.model.tools;

import com.beacon.model.MobileDto;

import java.util.function.Function;

/**
 * Converter is used to convert a complex mobile id to a part of url that can be used to get this mobile model.
 */
public interface MobileIdToUrlPathConverter {

    static String convert(MobileDto mobileDto) {
        Function<MobileDto, String> function = (mobile) -> {
            String brand = mobile.getBrand()
                    .toLowerCase()
                    .trim()
                    .replaceAll("[+]", "plus")
                    .replaceAll("[-\\s\\p{Punct}]", "");
            return mobile.getMobileId().replaceAll(brand, brand + "/");
        };
        return function.apply(mobileDto);
    }
}
