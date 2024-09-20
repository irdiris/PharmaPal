package com.example.pharmapal.entities;

import com.example.pharmapal.entities.enumerations.StaffStates;
import com.example.pharmapal.entities.enumerations.UserTypes;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Table(schema = "PharmaPal", name = "Staff")
@Data
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "@staffId"
)
@ToString(exclude = {"user", "workHoursSet", "shifts", "permissions", "transactionsSet"})
public class Staff {
    @Id
    private Long staffId;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private StaffStates state;
    @Enumerated(EnumType.STRING)
    private UserTypes type;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "staff")
    private Set<WorkHours> workHoursSet;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(
            schema = "PharmaPal",
            name = "StaffShifts",
            joinColumns = @JoinColumn(name = "staffid",foreignKey = @ForeignKey(name = "fk_staff")),
            inverseJoinColumns = @JoinColumn(name = "shiftId"), foreignKey = @ForeignKey(name = "fk_shifts"))
    private Set<Shifts> shifts;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            schema = "PharmaPal",
            name = "StaffPermissions",
            joinColumns = @JoinColumn(name = "staffid" ),
            inverseJoinColumns = @JoinColumn(name = "permissionId"))
    private Set<Permissions> permissions;

    @OneToMany()
    @JoinColumn(name = "staff")

    private Set<Transactions> transactionsSet;

 // Custom toString method to avoid circular references
//    @Override
//    public String toString() {
//        return "Staff{" +
//                "staffId=" + staffId +
//                ", username='" + username + '\'' +
//                ", state=" + state +
//                ", type=" + type +
//                ", userId=" + (user != null ? user.getUserId() : null) +
//                ", workHoursCount=" + (workHoursSet != null ? workHoursSet.size() : 0) +
//                ", shiftsCount=" + (shifts != null ? shifts.size() : 0) +
//                ", permissionsCount=" + (permissions != null ? permissions.size() : 0) +
//                ", transactionsCount=" + (transactionsSet != null ? transactionsSet.size() : 0) +
//                '}';
//    }
}