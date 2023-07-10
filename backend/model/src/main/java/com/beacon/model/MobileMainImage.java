package com.beacon.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "1")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MobileMainImage extends MobileImage {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mobile_id", nullable = false)
    @JsonBackReference
    private Mobile mobile;

    public MobileMainImage(Long imageId, byte[] image) {
        super(imageId, image);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "MobileMainImage{} " + super.toString();
    }
}
