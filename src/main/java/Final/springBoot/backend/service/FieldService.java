package Final.springBoot.backend.service;

import Final.springBoot.backend.dto.impl.CropDto;
import Final.springBoot.backend.dto.impl.FieldDto;
import Final.springBoot.backend.dto.status.CropStatus;

import java.util.List;

public interface FieldService {
    void saveField(FieldDto fieldDto);
    List<FieldDto> getFieldList();
    CropStatus getFieldById(String cropId);
    void updateField(String cropId,FieldDto FieldDto);
    void deleteField(String fieldId);
}
