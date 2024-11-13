package Final.springBoot.backend.service;

import Final.springBoot.backend.dto.impl.CropDto;
import Final.springBoot.backend.dto.status.CropStatus;

import java.util.List;

public interface CropService {
    void saveCrop(CropDto cropDto);
    List<CropDto> getCropList();
    CropStatus getCropById(String cropId);
    void updateCrop(String cropId,CropDto cropDto);
    void deleteCrop(int cropId);
}
