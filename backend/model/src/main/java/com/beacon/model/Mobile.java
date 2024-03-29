package com.beacon.model;

import com.beacon.model.dtos.MobileDto;
import com.beacon.model.tools.ToStringTool;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

/**
 * Mobile is a model with small information of mobile.
 */

@NamedNativeQueries(
        @NamedNativeQuery(name = "Mobile.findAllMobileDtos",
                query = "SELECT * FROM ( " +
                        "SELECT m.mobile_id, m.brand, m.model, m.os, m.screen_size, m.display_resolution, " +
                        "m.display_technology, m.ram, m.storage_capacity, m.chipset_model, m.camera_resolution, " +
                        "m.sim_card_slot, m.battery, m.color, m.release_year, m.relevant, " +
                        "im.image_id, lo_get(im.image) as image, " +
                        "COUNT(shop_id) AS count_of_offers, MIN(price) AS minimal_price " +
                        "FROM mobile m LEFT JOIN offers o ON m.mobile_id=o.mobile_id " +
                        "LEFT JOIN mobile_image im ON m.mobile_id=im.mobile_id AND im.main=1 " +
                        "GROUP BY m.mobile_id, m.brand, m.model, m.os, m.screen_size, m.display_resolution, " +
                        "m.display_technology, m.ram, m.storage_capacity, m.chipset_model, m.camera_resolution, " +
                        "m.sim_card_slot, m.battery, m.color, m.release_year, m.relevant, im.image_id, im.image " +
                        ") AS preresult " +
                        "ORDER BY minimal_price IS NULL, relevant DESC, release_year DESC;",
                resultSetMapping = "Mapping.MobileDto")
)
@SqlResultSetMappings(
        @SqlResultSetMapping(name = "Mapping.MobileDto",
                classes = @ConstructorResult(targetClass = MobileDto.class,
                        columns = {
                                @ColumnResult(name = "mobile_id"), @ColumnResult(name = "brand"),
                                @ColumnResult(name = "model"), @ColumnResult(name = "os"),
                                @ColumnResult(name = "screen_size"), @ColumnResult(name = "display_resolution"),
                                @ColumnResult(name = "display_technology"), @ColumnResult(name = "ram"),
                                @ColumnResult(name = "storage_capacity"), @ColumnResult(name = "chipset_model"),
                                @ColumnResult(name = "camera_resolution"), @ColumnResult(name = "sim_card_slot"),
                                @ColumnResult(name = "battery"), @ColumnResult(name = "color"),
                                @ColumnResult(name = "release_year"), @ColumnResult(name = "relevant"),
                                @ColumnResult(name = "image_id", type = Long.class),
                                @ColumnResult(name = "image", type = byte[].class),
                                @ColumnResult(name = "count_of_offers", type = Long.class), @ColumnResult(name = "minimal_price")
                        }))
)
@Entity
@Table(name = "mobile")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
public class Mobile extends Product {

    @Id
    @Column(name = "mobile_id", nullable = false, unique = true)
    private String mobileId;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "os")
    private String os;

    @Column(name = "screen_size")
    private String screenSize;

    @Column(name = "display_resolution")
    private String displayResolution;

    @Column(name = "display_technology")
    private String displayTechnology;

    @Column(name = "ram")
    private Integer ram;

    @Column(name = "storage_capacity")
    private Integer storageCapacity;

    @Column(name = "chipset_model")
    private String chipsetModel;

    @Column(name = "camera_resolution")
    private String cameraResolution;

    @Column(name = "sim_card_slot")
    private String simCardSlot;

    @Column(name = "battery")
    private Integer battery;

    @Column(name = "color")
    private String color;

    @Column(name = "release_year")
    private String releaseYear;

    // orphanRemoval = true is best practice by "Spring Boot Persistence Best Practices (Anghel Leonard)"
    @OneToOne(mappedBy = "mobile", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private MobileMainImage mainImage;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Mobile mobile = (Mobile) o;
        return Objects.equals(mobileId, mobile.getMobileId());
    }

    @Override
    public String toString() {
        return new ToStringTool<>(this).getString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(mobileId);
    }
}
