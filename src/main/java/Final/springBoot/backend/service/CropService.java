package Final.springBoot.backend.service;

import Final.springBoot.backend.dto.impl.CropDto;

import java.util.List;

public interface CropService {
    void saveCrop(CropDto cropDto);
    List<CropDto> getCropList();
    CropDto getCropById(int cropId);
    void updateCrop(String cropId,CropDto cropDto);
    void deleteCrop(int cropId);
}
