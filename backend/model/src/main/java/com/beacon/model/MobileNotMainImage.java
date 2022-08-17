package com.beacon.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "2")
@Data
@NoArgsConstructor
public class MobileNotMainImage extends MobileImage {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mobile_id", nullable = false)
    @JsonBackReference
    private MobileFull mobileFull;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MobileNotMainImage that = (MobileNotMainImage) o;

        return mobileFull.equals(that.mobileFull);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + mobileFull.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "MobileNotMainImage{} " + super.toString();
    }
}
