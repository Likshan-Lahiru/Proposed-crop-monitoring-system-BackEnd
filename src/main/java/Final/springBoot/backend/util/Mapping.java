package Final.springBoot.backend.util;

import Final.springBoot.backend.dto.impl.CropDto;
import Final.springBoot.backend.dto.impl.EquipmentDto;
import Final.springBoot.backend.dto.impl.FieldDto;
import Final.springBoot.backend.dto.impl.StaffDto;
import Final.springBoot.backend.dto.status.Status;
import Final.springBoot.backend.entity.impl.CropEntity;
import Final.springBoot.backend.entity.impl.EquipmentEntity;
import Final.springBoot.backend.entity.impl.FieldEntity;
import Final.springBoot.backend.entity.impl.StaffEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {

    @Autowired
    private ModelMapper modelMapper;


    public CropEntity toCropEntity(CropDto cropDto) {
       return modelMapper.map(cropDto, CropEntity.class);
    }

    public List<CropDto> asCropDtoList(List<CropEntity> cropAll) {
        return modelMapper.map(cropAll, new TypeToken<List<CropDto>>() {}.getType());
    }

    public CropDto toCropDto(CropEntity cropEntity) {
        return modelMapper.map(cropEntity, CropDto.class);
    }

    public FieldEntity toFieldEntity(FieldDto fieldDto) {
        return modelMapper.map(fieldDto, FieldEntity.class);
    }

    public List<FieldDto> asFieldDtoList(List<FieldEntity> all) {
        return modelMapper.map(all, new TypeToken<List<FieldDto>>() {}.getType());
    }

    public FieldDto toFieldDto(FieldEntity fieldEntity) {
        return modelMapper.map(fieldEntity, FieldDto.class);
    }

    public StaffEntity toStaffEntity(StaffDto staffDto) {
        return modelMapper.map(staffDto, StaffEntity.class);
    }

    public List<StaffDto> adStaffDtoList(List<StaffEntity> all) {
        return modelMapper.map(all, new TypeToken<List<StaffDto>>() {}.getType());
    }

    public StaffDto toStaffDto(StaffEntity staffEntity) {
        return modelMapper.map(staffEntity, StaffDto.class);
    }


    public EquipmentEntity toEquipmentEntity(EquipmentDto equipmentDto) {
        return modelMapper.map(equipmentDto, EquipmentEntity.class);

    }

    public List<EquipmentDto> asEquipmentDtoList(List<EquipmentEntity> all) {
        return modelMapper.map(all, new TypeToken<List<EquipmentDto>>() {}.getType());
    }

    public EquipmentDto toEquipmentDto(EquipmentEntity equipmentEntity) {
        return modelMapper.map(equipmentEntity, EquipmentDto.class);
    }
}
