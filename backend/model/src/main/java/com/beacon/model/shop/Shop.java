package com.beacon.model.shop;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.Map;
import java.util.Set;

/**
 * A main model of shop.
 */
@Table(name = "shop")
@Getter
@Setter
@Entity
@NamedEntityGraph(name = "shop-all", includeAllAttributes = true)
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id", unique = true, nullable = false, updatable = false)
    private Long shopId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    // orphanRemoval = true is best practice by "Spring Boot Persistence Best Practices (Anghel Leonard)"
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
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

    // orphanRemoval = true is best practice by "Spring Boot Persistence Best Practices (Anghel Leonard)"
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "shop")
    @JsonManagedReference
    private Logo logo;

    //Item 68. Spring Boot Persistence Best Practices
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shop shop = (Shop) o;

        return shopId != null && shopId.equals(shop.shopId);
    }

    @Override
    public int hashCode() {
        return 2031;
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


