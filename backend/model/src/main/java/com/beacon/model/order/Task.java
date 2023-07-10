package com.beacon.model.order;

import com.beacon.model.builders.TaskBuilder;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "task")
@NamedEntityGraph(name = "task-all", includeAllAttributes = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task implements Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hilopooled")
    @GenericGenerator(name = "hilopooled",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "hilo_task_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "5"),
                    @Parameter(name = "optimizer", value = "pooled")
            })
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

    // orphanRemoval = true is best practice by "Spring Boot Persistence Best Practices (Anghel Leonard)"
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
        if (!firstName.equals(task.firstName)) return false;
        if (!lastName.equals(task.lastName)) return false;
        if (!email.equals(task.email)) return false;
        if (!phoneNumber.equals(task.phoneNumber)) return false;
        return city.equals(task.city);
    }

    @Override
    public int hashCode() {
        int result = 2021;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        result = 31 * result + city.hashCode();
        return result;
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
