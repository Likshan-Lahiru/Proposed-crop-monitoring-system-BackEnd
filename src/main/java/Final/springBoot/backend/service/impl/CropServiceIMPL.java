package Final.springBoot.backend.service.impl;

import Final.springBoot.backend.dao.CropDao;
import Final.springBoot.backend.dto.impl.CropDto;
import Final.springBoot.backend.entity.impl.CropEntity;
import Final.springBoot.backend.exception.DataPersistException;
import Final.springBoot.backend.service.CropService;
import Final.springBoot.backend.util.Mapping;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class CropServiceIMPL implements CropService {

    @Autowired
    private CropDao cropDao;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveCrop(CropDto cropDto) {
        cropDto.setFieldCode("F001");
        cropDto.setLogCode("L001");
        System.out.println(cropDto);
        CropEntity save = cropDao.save(mapping.toCropEntity(cropDto));
        System.out.println(save);
        if ( save == null) {
            throw new DataPersistException();
        }

    }

    @Override
    public List<CropDto> getCropList() {
        return List.of();
    }

    @Override
    public CropDto getCropById(int cropId) {
        return null;
    }

    @Override
    public void updateCrop(String cropId, CropDto cropDto) {

    }

    @Override
    public void deleteCrop(int cropId) {

    }
}
