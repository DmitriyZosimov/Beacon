package com.beacon.shop.dao;

import com.beacon.model.builders.ShopBuilder;
import com.beacon.model.builders.WorkingHoursBuilder;
import com.beacon.model.shop.Logo;
import com.beacon.model.shop.PaymentMethod;
import com.beacon.model.shop.Shop;
import com.beacon.model.shop.WorkingHours;
import org.junit.jupiter.api.Assertions;

import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public interface TestShopBuilder {

    String NAME = "default store";
    String DESCRIPTION = "The default store can offer you many devices";

    default Shop build() {
        return ShopBuilder.create()
                .name(NAME)
                .description(DESCRIPTION)
                .workingHoursMap(getMapWithDefaultValues())
                .paymentMethods(getSetWithDefaultPaymentMethods())
                .setLogo(uploadLogo())
                .build();
    }

    default void checkDefaultValuesFromImportSql(Shop... shops) {
        Arrays.stream(shops).forEach(shop -> {
            Assertions.assertNotNull(shop.getName());
            Assertions.assertNotNull(shop.getDescription());
            Assertions.assertNotNull(shop.getLogo());
            Assertions.assertNotNull(shop.getShopId());
            Assertions.assertNotNull(shop.getPaymentMethods());
            if (shop.getShopId() == 1 || shop.getShopId() == 2 || shop.getShopId() == 7 || shop.getShopId() == 6) {
                Assertions.assertTrue(shop.getWorkingHoursMap().containsKey(DayOfWeek.SATURDAY));
                Assertions.assertTrue(shop.getWorkingHoursMap().containsKey(DayOfWeek.SUNDAY));
            } else if (shop.getShopId() == 3) {
                Assertions.assertFalse(shop.getWorkingHoursMap().containsKey(DayOfWeek.SATURDAY));
                Assertions.assertFalse(shop.getWorkingHoursMap().containsKey(DayOfWeek.SUNDAY));
            } else if (shop.getShopId() == 4 || shop.getShopId() == 5) {
                Assertions.assertTrue(shop.getWorkingHoursMap().containsKey(DayOfWeek.SATURDAY));
                Assertions.assertFalse(shop.getWorkingHoursMap().containsKey(DayOfWeek.SUNDAY));
            }
        });

    }

    private Map<DayOfWeek, WorkingHours> getMapWithDefaultValues() {
        return WorkingHoursBuilder.create()
                .setMonday(LocalTime.of(9, 0, 0), LocalTime.of(21, 0, 0))
                .setTuesday(LocalTime.of(9, 0, 0), LocalTime.of(21, 0, 0))
                .setWednesday(LocalTime.of(9, 0, 0), LocalTime.of(21, 0, 0))
                .setThursday(LocalTime.of(9, 0, 0), LocalTime.of(21, 0, 0))
                .setFriday(LocalTime.of(9, 0, 0), LocalTime.of(21, 0, 0))
                .setSaturday(LocalTime.of(9, 0, 0), LocalTime.of(15, 0, 0))
                .setSunday(LocalTime.of(9, 0, 0), LocalTime.of(15, 0, 0))
                .build();
    }

    private Set<PaymentMethod> getSetWithDefaultPaymentMethods() {
        return Set.of(PaymentMethod.CASH, PaymentMethod.CREDIT_CARD, PaymentMethod.DEBIT_CARD,
                PaymentMethod.ELECTRONIC_BANK_TRANSFER);
    }

    private Logo uploadLogo() {
        Logo logoObject = new Logo();
        File logo = new File("src/test/resources/img/beacon-small-logo.png");
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(logo))) {
            byte[] uploadedLogo = inputStream.readAllBytes();
            logoObject.setLogo(uploadedLogo);
        } catch (FileNotFoundException e) {
            System.err.println("The logo file is not found:\n");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logoObject;
    }
}
