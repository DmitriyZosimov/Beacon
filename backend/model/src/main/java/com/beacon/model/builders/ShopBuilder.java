package com.beacon.model.builders;

import com.beacon.model.shop.Logo;
import com.beacon.model.shop.PaymentMethod;
import com.beacon.model.shop.Shop;
import com.beacon.model.shop.WorkingHours;

import java.time.DayOfWeek;
import java.util.Map;
import java.util.Set;

/**
 * A plain shop builder.
 */
public class ShopBuilder {

    private static ShopBuilder INSTANCE;

    private Long shopId;
    private String name;
    private String description;
    private Map<DayOfWeek, WorkingHours> workingHoursMap;
    private Set<PaymentMethod> paymentMethods;
    private Logo logo;

    public static ShopBuilder create() {
        INSTANCE = new ShopBuilder();
        return INSTANCE;
    }

    public ShopBuilder shopId(Long id) {
        this.shopId = id;
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
        shop.setShopId(shopId);
        shop.setName(name);
        shop.setDescription(description);
        shop.setWorkingHoursMap(workingHoursMap);
        shop.setPaymentMethods(paymentMethods);
        shop.setLogo(logo);
        return shop;
    }
}
