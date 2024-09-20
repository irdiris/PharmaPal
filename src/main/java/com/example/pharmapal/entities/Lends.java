package com.example.pharmapal.entities;

import com.example.pharmapal.entities.enumerations.LendStates;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Table(schema = "PharmaPal", name = "Lends")
@Entity
@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(exclude = "lentItems")
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "@lendId"
)
public class Lends {
    @Id
    private Long lendId;

    @Enumerated(EnumType.STRING)
    private LendStates state;

    private String pharmacyName;
    private String pharmacyId;

    @Temporal(TemporalType.DATE)
    @Column
    private LocalDate date;

    private int quantity;

    @OneToMany(mappedBy = "lend", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)

    private Set<LentItems> lentItems = new HashSet<>();

    public void addLentItem(LentItems lentItem) {
        lentItems.add(lentItem);
        lentItem.setLend(this); // Maintain bidirectional relationship
    }

    public void removeLentItem(LentItems lentItem) {
        lentItems.remove(lentItem);
        lentItem.setLend(null); // Maintain bidirectional relationship
    }

    public void removeLentItems() {
        for (LentItems lentItem : lentItems) {
            lentItem.setLend(null);
        }
        lentItems.clear();
    }
}
