package Final.springBoot.backend.service.impl;

import Final.springBoot.backend.dto.impl.StaffDto;
import Final.springBoot.backend.dto.status.CropStatus;
import Final.springBoot.backend.service.StaffService;

import java.util.List;

public class StaffServiceIMPL implements StaffService {
    @Override
    public void saveStaff(StaffDto staffDto) {

    }

    @Override
    public List<StaffDto> getStaffList() {
        return List.of();
    }

    @Override
    public CropStatus getStaffById(String staffId) {
        return null;
    }

    @Override
    public void updateStaff(String staffId, StaffDto staffDto) {

    }

    @Override
    public void deleteStaff(String staffId) {

    }
}
