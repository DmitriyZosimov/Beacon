package com.beacon.model.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "computer_image")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "main", discriminatorType = DiscriminatorType.INTEGER, length = 1)
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class ComputerImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id", nullable = false, unique = true)
    private Long imageId;

    @Lob
    @Column(name = "image", nullable = false)
    private byte[] image;
}
