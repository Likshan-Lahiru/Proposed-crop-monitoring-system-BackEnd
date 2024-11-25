package Final.springBoot.backend.entity.impl;

import Final.springBoot.backend.entity.Gender;
import Final.springBoot.backend.entity.JobRole;
import Final.springBoot.backend.entity.SuperEntity;

import Final.springBoot.backend.entity.composite.Address;
import Final.springBoot.backend.entity.composite.Name;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "staffTable")
public class StaffEntity implements SuperEntity {
    @Id
    private String staffId;
    @Embedded
    private Name name;
    @Enumerated(EnumType.STRING)
    private JobRole staffDesignation;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Date joinedDate;
    private Date DOB;
    @Embedded
    private Address address;

    private String contact;
    private String email;

    @Enumerated(EnumType.STRING)
    private JobRole jobRole;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "staffField",
            joinColumns = @JoinColumn(name = "staffId"),
            inverseJoinColumns = @JoinColumn(name = "staffHave")
    )
    private List<FieldEntity> fieldEntity;

    @OneToMany(mappedBy = "staffEntity")
    private List<VehicleEntity> vehicleEntity;

    @OneToMany(mappedBy = "staffEquipment")
    private List<EquipmentEntity> staffEquipment;

    @Column(columnDefinition = "LONGTEXT")
    private String image;

    @ManyToOne
    @JoinColumn(name = "logCode",nullable = false)
    private LogEntity log;
  /*  @ManyToOne
    @JoinColumn(name = "fieldCode",nullable = false)
    private FieldEntity staff;*/
}
