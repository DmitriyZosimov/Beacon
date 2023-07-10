package com.beacon.model.order;

import com.beacon.model.Mobile;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @Column(name = "order_id", unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hilopooled")
    @GenericGenerator(name = "hilopooled",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "hilo_order_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "5"),
                    @Parameter(name = "optimizer", value = "pooled")
            })
    private Long orderId;

    @ManyToOne(optional = false, targetEntity = Mobile.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "mobile_id", insertable = false, updatable = false)
    @JsonSerialize(typing = JsonSerialize.Typing.STATIC)
    private Mobile mobile;

    @Column(name = "mobile_id", nullable = false, updatable = false)
    private String mobileId;

    @Column(name = "shop_id", nullable = false, updatable = false)
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
        if (!mobileId.equals(order.mobileId)) return false;
        return shopId.equals(order.shopId);
    }

    @Override
    public int hashCode() {
        int result = 2022;
        result = 31 * result + mobileId.hashCode();
        result = 31 * result + shopId.hashCode();
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
