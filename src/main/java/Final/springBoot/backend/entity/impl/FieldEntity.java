package Final.springBoot.backend.entity.impl;

import Final.springBoot.backend.entity.SuperEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.Set;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "filedTable")
public class FieldEntity implements SuperEntity {
    @Id
    private String fieldCode;
    private String fieldName;
    private int fieldLocation;
    private Double fieldSize;
    @OneToMany(mappedBy = "field")
    private List<CropEntity> cropId;
    @Column(columnDefinition = "LONGTEXT")
    private String image1;
    @Column(columnDefinition = "LONGTEXT")
    private String image2;
    @ManyToOne
    @JoinColumn(name = "logCodeField")
    private LogEntity logField;
/*    @ManyToMany(mappedBy = "fieldEntity", cascade = CascadeType.PERSIST)
    private List<StaffEntity> staffHave = new ArrayList<>();*/

    @ManyToMany(mappedBy = "fieldsAssigned", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<StaffEntity> staffAssigned = new ArrayList<>();
    @OneToMany(mappedBy = "fieldEquipment")
    private List<EquipmentEntity> equipmentEntities;

}
