package com.beacon.shop.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalTime;

/**
 * Every {@code Shop} have yourself working hours.
 * It is a plain class including only time of open and close.
 */
@Data
@Entity
@Table(name = "working_hours")
public class WorkingHours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
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

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (!open.equals(that.open)) return false;
        return close.equals(that.close);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + open.hashCode();
        result = 31 * result + close.hashCode();
        return result;
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
