package Final.springBoot.backend.service;

import Final.springBoot.backend.dto.impl.EquipmentDto;
import Final.springBoot.backend.dto.status.Status;

import java.util.List;

public interface EquipmentService {
    void saveEquipment(EquipmentDto equipmentDto);
    List<EquipmentDto> getEquipmentList();
    Status getEquipmentById(String cropId);
    void updateEquipment(String equipmentId, EquipmentDto equipmentDto);
    void deleteEquipment(String equipmentId);
}
