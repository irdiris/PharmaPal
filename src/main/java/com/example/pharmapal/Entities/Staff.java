package com.example.pharmapal.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Table(schema = "PharmaPal", name ="Staff" )
@Data
@Entity
public class Staff {
    @Id
    private Long id;
    private String username;
    private String password;
    private String state;
    private String type;


    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "staff")
    private Set<WorkHours> workHoursSet;

    @ManyToMany
    @JoinTable(
            name = "StaffShifts",
            joinColumns = @JoinColumn(name = "staffId"),
            inverseJoinColumns = @JoinColumn(name = "shiftId"))
    private Set<Shifts> shifts;


    @ManyToMany
    @JoinTable(
            name = "StaffPermissions",
            joinColumns = @JoinColumn(name = "staffid"),
            inverseJoinColumns = @JoinColumn(name = "permissionId"))
private Set<Permissions> permissions;


}
