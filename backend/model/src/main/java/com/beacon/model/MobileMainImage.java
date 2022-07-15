package com.beacon.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "1")
@Data
@NoArgsConstructor
public class MobileMainImage extends MobileImage {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mobile_id", nullable = false)
    @JsonBackReference
    private MobileDto mobileDto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MobileMainImage that = (MobileMainImage) o;

        return mobileDto.equals(that.mobileDto);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + mobileDto.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "MobileMainImage{} " + super.toString();
    }
}
