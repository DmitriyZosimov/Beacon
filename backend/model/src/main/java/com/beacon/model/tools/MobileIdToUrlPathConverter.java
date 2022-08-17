package com.beacon.model.tools;

import com.beacon.model.Mobile;

import java.util.function.Function;

/**
 * Converter is used to convert a complex mobile id to a part of url that can be used to get this mobile model.
 */
public interface MobileIdToUrlPathConverter {

    static String convert(Mobile mobile) {
        Function<Mobile, String> function = (param) -> {
            String brand = param.getBrand()
                    .toLowerCase()
                    .trim()
                    .replaceAll("[+]", "plus")
                    .replaceAll("[-\\s\\p{Punct}]", "");
            return param.getMobileId().replaceAll(brand, brand + "/");
        };
        return function.apply(mobile);
    }
}
