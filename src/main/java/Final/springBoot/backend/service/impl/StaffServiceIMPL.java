package Final.springBoot.backend.service.impl;

import Final.springBoot.backend.dao.StaffDao;
import Final.springBoot.backend.dto.impl.StaffDto;
import Final.springBoot.backend.dto.status.Status;
import Final.springBoot.backend.entity.composite.Address;
import Final.springBoot.backend.entity.composite.Name;
import Final.springBoot.backend.entity.impl.CropEntity;
import Final.springBoot.backend.entity.impl.StaffEntity;
import Final.springBoot.backend.exception.DataPersistException;
import Final.springBoot.backend.service.StaffService;
import Final.springBoot.backend.util.Mapping;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

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
        Optional<StaffEntity> byId = staffDao.findById(staffId);

        if (byId.isPresent()) {
            byId.get().setName(new Name(staffDto.getFirstName(), staffDto.getLastName()));
            byId.get().setStaffDesignation(staffDto.getStaffDesignation());
            byId.get().setGender(staffDto.getGender());
            byId.get().setJoinedDate(Date.valueOf(staffDto.getJoinedDate()));
            byId.get().setDOB(Date.valueOf(staffDto.getDOB()));
            byId.get().setAddress(new Address(staffDto.getAddressLine01(),staffDto.getAddressLine02(),staffDto.getAddressLine03(),staffDto.getAddressLine04(),staffDto.getAddressLine05()));
            byId.get().setContact(staffDto.getContact());
            byId.get().setEmail(staffDto.getEmail());
            byId.get().setJobRole(staffDto.getJobRole());
            byId.get().setImage(staffDto.getImage());
        }
    }

    @Override
    public void deleteStaff(String staffId) {

    }
}
