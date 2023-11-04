package com.example.pharmapal.Entities;

import com.example.pharmapal.Entities.Enumerations.StaffStates;
import com.example.pharmapal.Entities.Enumerations.UserTypes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Table(schema = "PharmaPal", name ="Staff" )
@Data
@Entity
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Staff {
    @Id
    private Long id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private StaffStates state;
    @Enumerated(EnumType.STRING)
    private UserTypes type;


    @OneToOne( cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "staff")
    private Set<WorkHours> workHoursSet;

    @ManyToMany( cascade = CascadeType.ALL)
    @JoinTable(
            name = "StaffShifts",
            joinColumns = @JoinColumn(name = "staffId"),
            inverseJoinColumns = @JoinColumn(name = "shiftId"))
    private Set<Shifts> shifts;


    @ManyToMany(  cascade = CascadeType.ALL)
    @JoinTable(
            name = "StaffPermissions",
            joinColumns = @JoinColumn(name = "staffid"),
            inverseJoinColumns = @JoinColumn(name = "permissionId"))
private Set<Permissions> permissions;


}
