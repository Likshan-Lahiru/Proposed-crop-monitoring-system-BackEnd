package Final.springBoot.backend.service.impl;

import Final.springBoot.backend.customStatusCode.SelectedCropErrorStatus;
import Final.springBoot.backend.dao.CropDao;
import Final.springBoot.backend.dto.impl.CropDto;
import Final.springBoot.backend.dto.status.CropStatus;
import Final.springBoot.backend.entity.impl.CropEntity;
import Final.springBoot.backend.exception.DataPersistException;
import Final.springBoot.backend.service.CropService;
import Final.springBoot.backend.util.Mapping;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class CropServiceIMPL implements CropService {

    @Autowired
    private CropDao cropDao;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveCrop(CropDto cropDto) {


        CropEntity save = cropDao.save(mapping.toCropEntity(cropDto));

        if ( save == null) {
            throw new DataPersistException();
        }

    }

    @Override
    public List<CropDto> getCropList() {
        return mapping.asCropDtoList(cropDao.findAll());
    }

    @Override
    public CropStatus getCropById(String cropId) {
        if (cropDao.existsById(cropId)) {
            CropEntity cropEntity = cropDao.getReferenceById(cropId);
            return mapping.toCropDto(cropEntity);
        }else {
            return new SelectedCropErrorStatus(2,"Crop not found");
        }
    }

    @Override
    public void updateCrop(String cropId, CropDto cropDto) {
        Optional<CropEntity> byId = cropDao.findById(cropId);
        if (byId.isPresent()) {
            byId.get().setCropCategory(cropDto.getCropCategory());
            byId.get().setCropCommonName(cropDto.getCropCommonName());
            byId.get().setCropImage(cropDto.getCropImage());
            byId.get().setCropScientificName(cropDto.getCropScientificName());
            byId.get().setCropSeason(cropDto.getCropSeason());
        }
    }

    @Override
    public void deleteCrop(int cropId) {

    }
}
