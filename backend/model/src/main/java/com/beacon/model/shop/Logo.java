package com.beacon.model.shop;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Arrays;

/**
 * A shop logo image.
 */
@Entity
@Table(name = "shop_logo")
@Getter
@Setter
public class Logo {

    @Id
    private Long logoId;

    @Lob
    @Column(name = "logo")
    private byte[] logo;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id", referencedColumnName = "shop_id")
    @JsonBackReference
    private Shop shop;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Logo logo1 = (Logo) o;

        return logoId != null && logoId.equals(logo1.logoId);
    }

    @Override
    public int hashCode() {
        return 3013;
    }

    @Override
    public String toString() {
        return "Logo{" +
                "logoId=" + logoId +
                ", logo=" + Arrays.toString(logo) +
                '}';
    }
}
