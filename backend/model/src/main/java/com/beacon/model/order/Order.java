package com.beacon.model.order;

import com.beacon.model.Mobile;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", unique = true, nullable = false, updatable = false)
    private Long orderId;

    @ManyToOne(optional = false, targetEntity = Mobile.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "mobile_id", insertable = false, updatable = false)
    @JsonSerialize(typing = JsonSerialize.Typing.STATIC)
    private Mobile mobile;

    @Column(name = "mobile_id", nullable = false, updatable = false)
    private String mobileId;

    @Column(name = "shop_id")
    private Long shopId;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "count", nullable = false)
    private Integer count = 1;

    @Column(name = "registered_date", updatable = false)
    private LocalDate registeredDate;

    @ManyToOne
    @JoinColumn(name = "task_id", updatable = false, nullable = false)
    @JsonBackReference
    private Task task;

    @PrePersist
    void onRegisteredDate() {
        this.registeredDate = LocalDate.now();
    }

    public void setMobile(Mobile mobile) {
        this.mobile = mobile;
        if (mobile != null) {
            this.mobileId = mobile.getMobileId();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (orderId != null ? !orderId.equals(order.orderId) : order.orderId != null) return false;
        if (mobile != null ? !mobile.equals(order.mobile) : order.mobile != null) return false;
        if (!mobileId.equals(order.mobileId)) return false;
        if (!shopId.equals(order.shopId)) return false;
        if (!price.equals(order.price)) return false;
        if (!count.equals(order.count)) return false;
        if (registeredDate != null ? !registeredDate.equals(order.registeredDate) : order.registeredDate != null)
            return false;
        return task.equals(order.task);
    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + mobileId.hashCode();
        result = 31 * result + shopId.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + count.hashCode();
        result = 31 * result + (registeredDate != null ? registeredDate.hashCode() : 0);
        result = 31 * result + task.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", mobile=" +
                ", mobileId='" + mobileId + '\'' +
                ", shopId=" + shopId +
                ", price=" + price +
                ", count=" + count +
                ", registeredDate=" + registeredDate +
                ", task=" + task +
                '}';
    }
}
