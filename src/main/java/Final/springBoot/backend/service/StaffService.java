package Final.springBoot.backend.service;

import Final.springBoot.backend.dto.impl.StaffDto;
import Final.springBoot.backend.dto.status.CropStatus;

import java.util.List;

public interface StaffService {
    void saveStaff(StaffDto staffDto);
    List<StaffDto> getStaffList();
    CropStatus getStaffById(String staffId);
    void updateStaff(String staffId, StaffDto staffDto);
    void deleteStaff(String staffId);
}
