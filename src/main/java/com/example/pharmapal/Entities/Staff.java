package com.example.pharmapal.Entities;

import com.example.pharmapal.Entities.Enumerations.StaffStates;
import com.example.pharmapal.Entities.Enumerations.UserTypes;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.Set;

@Table(schema = "PharmaPal", name = "Staff")
@Data
@Entity
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Staff {
    @Id
    private Long id;
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

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "StaffShifts",
            joinColumns = @JoinColumn(name = "staffid",foreignKey = @ForeignKey(name = "fk_staff")),
            inverseJoinColumns = @JoinColumn(name = "shiftId"), foreignKey = @ForeignKey(name = "fk_shifts"))

    private Set<Shifts> shifts;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name = "StaffPermissions",
            joinColumns = @JoinColumn(name = "staffid" ),
            inverseJoinColumns = @JoinColumn(name = "permissionId"))
    private Set<Permissions> permissions;

    @OneToMany()
    private Set<Transactions> transactionsSet;


    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, state, type);
    }

}
