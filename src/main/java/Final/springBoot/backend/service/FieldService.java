package Final.springBoot.backend.service;

import Final.springBoot.backend.dto.impl.FieldDto;
import Final.springBoot.backend.dto.status.Status;

import java.util.List;

public interface FieldService {
    void saveField(FieldDto fieldDto);
    List<FieldDto> getFieldList();
    Status getFieldById(String fieldId);
    void updateField(String fieldId,FieldDto FieldDto);
    void deleteField(String fieldId);
}
