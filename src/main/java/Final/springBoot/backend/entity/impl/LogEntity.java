package Final.springBoot.backend.entity.impl;

import Final.springBoot.backend.entity.SuperEntity;
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
@Table(name = "logTable")
public class LogEntity implements SuperEntity {
    @Id
    private String logCode;
    private Date logdate;
    private String LogDetails;
    private Long ObservedImage;
    @OneToMany(mappedBy = "fieldCode")
    private List<FieldEntity> logCodeField;
    @OneToMany(mappedBy = "cropCode")
    private List<CropEntity> cropEntitiesCrop;
    @OneToMany(mappedBy = "staffId")
    private List<StaffEntity> staffEntitiesStaff;


}
