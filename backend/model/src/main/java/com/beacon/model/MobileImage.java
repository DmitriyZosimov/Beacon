package com.beacon.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;

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
@Data
@NoArgsConstructor
@AllArgsConstructor
abstract class MobileImage {

    @Id
    @Column(name = "image_id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;

    @Lob
    @Column(name = "image", nullable = false)
    private byte[] image;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MobileImage that = (MobileImage) o;

        if (imageId != null ? !imageId.equals(that.imageId) : that.imageId != null) return false;
        return Arrays.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        int result = imageId != null ? imageId.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }

    @Override
    public String toString() {
        return "MobileImage{" +
                "imageId=" + imageId +
                ", image=" + image +
                '}';
    }
}
