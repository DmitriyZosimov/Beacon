package com.beacon.model.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
@Table(name = "computer_image")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "main", discriminatorType = DiscriminatorType.INTEGER, length = 1)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class ComputerImage {

    @Id
    @Column(name = "image_id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hilopooled")
    @GenericGenerator(name = "hilopooled",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "hilo_computer_image_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "5"),
                    @Parameter(name = "optimizer", value = "pooled")
            })
    private Long imageId;

    @Lob
    @Column(name = "image", nullable = false)
    private byte[] image;

    // Item 68. Spring Boot persistence best practices.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComputerImage that = (ComputerImage) o;

        return imageId != null && imageId.equals(that.imageId);
    }

    @Override
    public int hashCode() {
        return 4042;
    }

    @Override
    public String toString() {
        return "ComputerImage{" +
                "imageId=" + imageId +
                ", image=" + image +
                '}';
    }
}
