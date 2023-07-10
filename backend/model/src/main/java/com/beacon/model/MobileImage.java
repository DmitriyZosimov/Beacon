package com.beacon.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

/**
 * Superclass of all mobile images. This class contains common values, including the image itself.
 * Images is saved in a single table ({@link InheritanceType#SINGLE_TABLE}). Name of discriminator column is "main" and
 * type is integer. If a image is a main image, the image will have 1 as a discriminator value in "main" column,
 * otherwise it will have 2.
 * The main image has {@link OneToOne} association to {@link MobileDto}. The not main image has {@link ManyToOne}
 * association to {@link MobileDtoFull}.
 * MobileDto or MobileDtoFull is a parent in association to image, and includes all cascade operations.
 *
 */

@Entity
@Table(name = "mobile_image")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "main", discriminatorType = DiscriminatorType.INTEGER, length = 1)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class MobileImage {

    @Id
    @Column(name = "image_id", nullable = false, updatable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hilopooled")
    @GenericGenerator(name = "hilopooled",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                @Parameter(name = "sequence_name", value = "hilo_mobile_image_seq"),
                @Parameter(name = "initial_value", value = "1"),
                @Parameter(name = "increment_size", value = "5"),
                @Parameter(name = "optimizer", value = "pooled")
            })
    private Long imageId;

    @Lob
    @Column(name = "image", nullable = false)
    private byte[] image;

    // Item 68. Spring Boot persistence best practices.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MobileImage that = (MobileImage) o;

        return imageId != null && imageId.equals(that.imageId);
    }

    @Override
    public int hashCode() {
        return 4041;
    }

    @Override
    public String toString() {
        return "MobileImage{" +
                "imageId=" + imageId +
                ", image=" + image +
                '}';
    }
}
