package Final.springBoot.backend.service.impl;

import Final.springBoot.backend.dao.StaffDao;
import Final.springBoot.backend.dto.impl.StaffDto;
import Final.springBoot.backend.dto.status.Status;
import Final.springBoot.backend.entity.impl.CropEntity;
import Final.springBoot.backend.entity.impl.StaffEntity;
import Final.springBoot.backend.exception.DataPersistException;
import Final.springBoot.backend.service.StaffService;
import Final.springBoot.backend.util.Mapping;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StaffServiceIMPL implements StaffService {

    @Autowired
    private StaffDao staffDao;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveStaff(StaffDto staffDto) {
        StaffEntity save = staffDao.save(mapping.toStaffEntity(staffDto));

        if ( save == null) {
            throw new DataPersistException();
        }
    }

    @Override
    public List<StaffDto> getStaffList() {
        return List.of();
    }

    @Override
    public Status getStaffById(String staffId) {
        return null;
    }

    @Override
    public void updateStaff(String staffId, StaffDto staffDto) {

    }

    @Override
    public void deleteStaff(String staffId) {

    }
}
