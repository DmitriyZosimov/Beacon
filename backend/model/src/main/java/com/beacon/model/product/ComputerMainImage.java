package com.beacon.model.product;

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
public class ComputerMainImage extends ComputerImage {

    @OneToOne(fetch = FetchType.LAZY, targetEntity = Laptop.class)
    @JoinColumn(name = "computer_id", referencedColumnName = "computer_id")
    @JsonBackReference
    private Computer computer;

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
        return "ComputerMainImage{ " + super.toString() + " }";
    }
}
