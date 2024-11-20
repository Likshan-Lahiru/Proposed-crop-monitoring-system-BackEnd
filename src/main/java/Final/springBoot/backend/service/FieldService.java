package Final.springBoot.backend.service;

import Final.springBoot.backend.dto.impl.CropDto;
import Final.springBoot.backend.dto.impl.FieldDto;
import Final.springBoot.backend.dto.status.CropStatus;
import Final.springBoot.backend.dto.status.FieldStatus;

import java.util.List;

public interface FieldService {
    void saveField(FieldDto fieldDto);
    List<FieldDto> getFieldList();
    FieldStatus getFieldById(String fieldId);
    void updateField(String fieldId,FieldDto FieldDto);
    void deleteField(String fieldId);
}
