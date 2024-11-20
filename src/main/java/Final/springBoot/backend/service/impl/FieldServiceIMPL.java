package Final.springBoot.backend.service.impl;

import Final.springBoot.backend.dto.impl.FieldDto;
import Final.springBoot.backend.dto.status.CropStatus;
import Final.springBoot.backend.service.FieldService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class FieldServiceIMPL implements FieldService {
    @Override
    public void saveField(FieldDto fieldDto) {

    }

    @Override
    public List<FieldDto> getFieldList() {
        return List.of();
    }

    @Override
    public CropStatus getFieldById(String cropId) {
        return null;
    }

    @Override
    public void updateField(String cropId, FieldDto FieldDto) {

    }

    @Override
    public void deleteField(String fieldId) {

    }
}
