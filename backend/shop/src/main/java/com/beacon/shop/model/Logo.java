package com.beacon.shop.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Arrays;

/**
 * A shop logo image.
 */
@Entity
@Table(name = "shop_logo")
@Data
public class Logo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "logo_id", updatable = false, nullable = false, unique = true)
    private Long logoId;

    @Lob
    @Column(name = "logo")
    private byte[] logo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Logo logo1 = (Logo) o;

        if (logoId != null ? !logoId.equals(logo1.logoId) : logo1.logoId != null) return false;
        return Arrays.equals(logo, logo1.logo);
    }

    @Override
    public int hashCode() {
        int result = logoId != null ? logoId.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(logo);
        return result;
    }

    @Override
    public String toString() {
        return "Logo{" +
                "logoId=" + logoId +
                ", logo=" + Arrays.toString(logo) +
                '}';
    }
}
