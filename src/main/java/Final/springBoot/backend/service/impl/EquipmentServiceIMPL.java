package Final.springBoot.backend.service.impl;

import Final.springBoot.backend.dto.impl.EquipmentDto;
import Final.springBoot.backend.dto.status.Status;
import Final.springBoot.backend.service.EquipmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class EquipmentServiceIMPL implements EquipmentService {
    @Override
    public void saveField(EquipmentDto equipmentDto) {

    }

    @Override
    public List<EquipmentDto> getEquipmentList() {
        return List.of();
    }

    @Override
    public Status getEquipmentById(String cropId) {
        return null;
    }

    @Override
    public void updateEquipment(String cropId, EquipmentDto equipmentDto) {

    }

    @Override
    public void deleteEquipment(String equipmentId) {

    }
}
