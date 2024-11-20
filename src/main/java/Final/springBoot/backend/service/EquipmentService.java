package Final.springBoot.backend.service;

import Final.springBoot.backend.dto.impl.EquipmentDto;
import Final.springBoot.backend.dto.impl.FieldDto;
import Final.springBoot.backend.dto.status.CropStatus;

import java.util.List;

public interface EquipmentService {
    void saveField(EquipmentDto equipmentDto);
    List<EquipmentDto> getEquipmentList();
    CropStatus getEquipmentById(String cropId);
    void updateEquipment(String cropId, EquipmentDto equipmentDto);
    void deleteEquipment(String equipmentId);
}
