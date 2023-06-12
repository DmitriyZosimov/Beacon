package com.beacon.model.product;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "2")
@Data
@NoArgsConstructor
public class ComputerNotMainImage extends ComputerImage {

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Laptop.class)
    @JoinColumn(name = "computer_id", nullable = false)
    private Computer computer;
}
