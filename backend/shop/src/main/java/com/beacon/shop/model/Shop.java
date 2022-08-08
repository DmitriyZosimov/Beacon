package com.beacon.shop.model;

import lombok.Data;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.Map;
import java.util.Set;

/**
 * A main model of shop.
 */
@Table(name = "shop")
@Data
@Entity
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id", unique = true, nullable = false, updatable = false)
    private Long shopId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "shop_working_hours_mapping",
            joinColumns = {@JoinColumn(name = "shop_id", referencedColumnName = "shop_id")},
            inverseJoinColumns = {@JoinColumn(name = "working_hours_id", referencedColumnName = "id")})
    @MapKeyEnumerated(value = EnumType.STRING)
    private Map<DayOfWeek, WorkingHours> workingHoursMap;

    @ElementCollection(targetClass = PaymentMethod.class)
    @JoinTable(name = "shops_payment_methods",
            joinColumns = @JoinColumn(name = "shop_id"))
    @Column(name = "payment_method")
    @Enumerated(EnumType.STRING)
    private Set<PaymentMethod> paymentMethods;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "logo_id", referencedColumnName = "logo_id")
    private Logo logo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shop shop = (Shop) o;

        if (shopId != null ? !shopId.equals(shop.shopId) : shop.shopId != null) return false;
        if (!name.equals(shop.name)) return false;
        if (description != null ? !description.equals(shop.description) : shop.description != null) return false;
        if (workingHoursMap != null ? !workingHoursMap.equals(shop.workingHoursMap) : shop.workingHoursMap != null)
            return false;
        if (paymentMethods != null ? !paymentMethods.equals(shop.paymentMethods) : shop.paymentMethods != null)
            return false;
        return logo != null ? logo.equals(shop.logo) : shop.logo == null;
    }

    @Override
    public int hashCode() {
        int result = shopId != null ? shopId.hashCode() : 0;
        result = 31 * result + name.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (workingHoursMap != null ? workingHoursMap.hashCode() : 0);
        result = 31 * result + (paymentMethods != null ? paymentMethods.hashCode() : 0);
        result = 31 * result + (logo != null ? logo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shopId=" + shopId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", workingHoursMap=" + workingHoursMap +
                ", paymentMethods=" + paymentMethods +
                ", logo=" + logo +
                '}';
    }
}


