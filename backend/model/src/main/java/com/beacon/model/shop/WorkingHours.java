package com.beacon.model.shop;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.time.LocalTime;

/**
 * Every {@code Shop} have yourself working hours.
 * It is a plain class including only time of open and close.
 */
@Getter
@Setter
@Entity
@Table(name = "working_hours")
public class WorkingHours {

    @Id
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hilopooled")
    @GenericGenerator(name = "hilopooled",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "hilo_working_hours_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "7"),
                    @Parameter(name = "optimizer", value = "pooled")
            })
    private Long id;

    @Column(name = "open")
    private LocalTime open;

    @Column(name = "close")
    private LocalTime close;

    public WorkingHours() {
    }

    public WorkingHours(LocalTime open, LocalTime close) {
        this.open = open;
        this.close = close;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkingHours that = (WorkingHours) o;

        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 2035;
    }

    @Override
    public String toString() {
        return "WorkingHours{" +
                "id=" + id +
                ", open=" + open +
                ", close=" + close +
                '}';
    }
}
