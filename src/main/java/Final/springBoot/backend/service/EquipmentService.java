package Final.springBoot.backend.service;

import Final.springBoot.backend.dto.impl.EquipmentDto;
import Final.springBoot.backend.dto.status.Status;

import java.util.List;

public interface EquipmentService {
    void saveField(EquipmentDto equipmentDto);
    List<EquipmentDto> getEquipmentList();
    Status getEquipmentById(String cropId);
    void updateEquipment(String cropId, EquipmentDto equipmentDto);
    void deleteEquipment(String equipmentId);
}
