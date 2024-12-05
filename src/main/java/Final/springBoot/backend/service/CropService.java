package Final.springBoot.backend.service;

import Final.springBoot.backend.dto.impl.CropDto;
import Final.springBoot.backend.dto.status.Status;

import java.util.List;

public interface CropService {
    void saveCrop(CropDto cropDto);
    List<CropDto> getCropList();
    Status getCropById(String cropId);
    void updateCrop(String cropId, CropDto cropDto);
    void deleteCrop(String cropId);
    String generateCropID();
    List<CropDto> getCropsByCategory(String category);

}
