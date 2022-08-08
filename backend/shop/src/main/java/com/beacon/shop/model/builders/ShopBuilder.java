package com.beacon.shop.model.builders;

import com.beacon.shop.model.Logo;
import com.beacon.shop.model.PaymentMethod;
import com.beacon.shop.model.Shop;
import com.beacon.shop.model.WorkingHours;

import java.time.DayOfWeek;
import java.util.Map;
import java.util.Set;

/**
 * A plain shop builder.
 */
public class ShopBuilder {

    private static ShopBuilder INSTANCE = new ShopBuilder();

    private String name;
    private String description;
    private Map<DayOfWeek, WorkingHours> workingHoursMap;
    private Set<PaymentMethod> paymentMethods;
    private Logo logo;

    public static ShopBuilder create() {
        return INSTANCE;
    }

    public ShopBuilder name(String name) {
        this.name = name;
        return INSTANCE;
    }

    public ShopBuilder description(String description) {
        this.description = description;
        return INSTANCE;
    }

    public ShopBuilder workingHoursMap(Map<DayOfWeek, WorkingHours> workingHoursMap) {
        this.workingHoursMap = workingHoursMap;
        return INSTANCE;
    }

    public ShopBuilder paymentMethods(Set<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
        return INSTANCE;
    }

    public ShopBuilder setLogo(Logo logo) {
        this.logo = logo;
        return INSTANCE;
    }

    public Shop build() {
        Shop shop = new Shop();
        shop.setName(name);
        shop.setDescription(description);
        shop.setWorkingHoursMap(workingHoursMap);
        shop.setPaymentMethods(paymentMethods);
        shop.setLogo(logo);
        return shop;
    }
}
