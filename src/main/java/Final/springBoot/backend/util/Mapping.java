package Final.springBoot.backend.util;

import Final.springBoot.backend.dto.impl.CropDto;
import Final.springBoot.backend.entity.impl.CropEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapping {

    @Autowired
    private ModelMapper modelMapper;


    public CropEntity toCropEntity(CropDto cropDto) {
       return modelMapper.map(cropDto, CropEntity.class);
    }
}
