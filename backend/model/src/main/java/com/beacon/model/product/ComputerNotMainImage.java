package com.beacon.model.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "2")
@Getter
@Setter
@NoArgsConstructor
public class ComputerNotMainImage extends ComputerImage {

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Laptop.class)
    @JoinColumn(name = "computer_id", nullable = false)
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
        return "ComputerNotMainImage{ " + super.toString() + " }";
    }
}
