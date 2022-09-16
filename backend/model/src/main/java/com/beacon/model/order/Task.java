package com.beacon.model.order;

import com.beacon.model.builders.TaskBuilder;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "task")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task implements Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, unique = true)
    private Long taskId;

    @Transient
    private Boolean isDeliveryToAddress = true;

    @Column(nullable = false, updatable = false)
    private String firstName;

    @Column(nullable = false, updatable = false)
    private String lastName;

    @Column(nullable = false, updatable = false)
    private String email;

    @Column(nullable = false, updatable = false)
    private String phoneNumber;

    @Column(nullable = false, updatable = false)
    private String city;

    @Column(updatable = false)
    private String street;

    @Column(updatable = false)
    private String building;

    @Column(updatable = false)
    private Integer flat;

    @Column(updatable = false)
    private Integer porch;

    @Column(updatable = false)
    private Integer floor;

    @Column(updatable = false)
    private String comment;

    @Column
    @Enumerated
    private TaskState state;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "task", fetch = FetchType.EAGER)
    @JsonManagedReference
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Order> orders;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (taskId != null ? !taskId.equals(task.taskId) : task.taskId != null) return false;
        if (!isDeliveryToAddress.equals(task.isDeliveryToAddress)) return false;
        if (!firstName.equals(task.firstName)) return false;
        if (!lastName.equals(task.lastName)) return false;
        if (!email.equals(task.email)) return false;
        if (!phoneNumber.equals(task.phoneNumber)) return false;
        if (!city.equals(task.city)) return false;
        if (street != null ? !street.equals(task.street) : task.street != null) return false;
        if (building != null ? !building.equals(task.building) : task.building != null) return false;
        if (flat != null ? !flat.equals(task.flat) : task.flat != null) return false;
        if (porch != null ? !porch.equals(task.porch) : task.porch != null) return false;
        if (floor != null ? !floor.equals(task.floor) : task.floor != null) return false;
        if (comment != null ? !comment.equals(task.comment) : task.comment != null) return false;
        if (orders != null ? !orders.equals(task.orders) : task.orders != null) return false;
        return state == task.state;
    }

    @Override
    public int hashCode() {
        int result = taskId != null ? taskId.hashCode() : 0;
        result = 31 * result + isDeliveryToAddress.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (building != null ? building.hashCode() : 0);
        result = 31 * result + (flat != null ? flat.hashCode() : 0);
        result = 31 * result + (porch != null ? porch.hashCode() : 0);
        result = 31 * result + (floor != null ? floor.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (orders != null ? orders.hashCode() : 0);
        return 31 * result + state.hashCode();
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", isDeliveryToAddress=" + isDeliveryToAddress +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", building='" + building + '\'' +
                ", flat=" + flat +
                ", porch=" + porch +
                ", floor=" + floor +
                ", comment='" + comment + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    @Override
    public Task clone() {
        return TaskBuilder.create().withTaskId(taskId)
                .withFirstName(firstName)
                .withLastName(lastName)
                .withEmail(email)
                .withPhoneNumber(phoneNumber)
                .withCity(city)
                .withStreet(street)
                .withBuilding(building)
                .withPorch(porch)
                .withFloor(floor)
                .withFlat(flat)
                .withComment(comment)
                .withOrders(new ArrayList<>(this.orders))
                .withState(state)
                .withDeliveryToAddress(isDeliveryToAddress)
                .build();
    }
}
