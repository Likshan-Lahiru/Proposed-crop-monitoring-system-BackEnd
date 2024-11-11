package Final.springBoot.backend.entity.impl;

import Final.springBoot.backend.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cropTable")
public class CropEntity implements SuperEntity {
    @Id
    private String cropCode;
    private String cropCommonName;
    private String cropScientificName;
    @Column(columnDefinition = "LONGTEXT")
    private String cropImage;
    private String cropCategory;
    private String cropSeason;
    @ManyToOne
    @JoinColumn(name = "cropId",nullable = false)
    private FieldEntity fieldEntity;
    @ManyToOne()
    @JoinColumn(name = "logCode",nullable = false)
    private LogEntity cropEntitiesCrop;

}
