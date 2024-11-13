package Final.springBoot.backend.util;

import Final.springBoot.backend.dto.impl.CropDto;
import Final.springBoot.backend.entity.impl.CropEntity;
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
}
