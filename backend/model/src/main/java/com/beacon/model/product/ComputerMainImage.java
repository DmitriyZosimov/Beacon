package com.beacon.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "1")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComputerMainImage extends ComputerImage {

    @OneToOne(fetch = FetchType.LAZY, targetEntity = Laptop.class)
    @JoinColumn(name = "computer_id", referencedColumnName = "computer_id")
    @JsonBackReference
    private Computer computer;
}
