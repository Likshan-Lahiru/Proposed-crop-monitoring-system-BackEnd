package Final.springBoot.backend.dto.impl;

import Final.springBoot.backend.dto.status.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class EquipmentDto implements Status {
    private String equipmentId;
    private String equipmentName;
    private String equipmentType;
    private String equipmentStatus;
    private String staffId;
    private String fieldCode;
}
