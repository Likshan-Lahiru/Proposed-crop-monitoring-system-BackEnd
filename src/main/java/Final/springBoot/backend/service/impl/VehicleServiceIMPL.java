package Final.springBoot.backend.service.impl;

import Final.springBoot.backend.customStatusCode.SelectedErrorStatus;
import Final.springBoot.backend.dao.StaffDao;
import Final.springBoot.backend.dao.VehicleDao;
import Final.springBoot.backend.dto.impl.VehicleDto;
import Final.springBoot.backend.dto.status.Status;
import Final.springBoot.backend.entity.impl.VehicleEntity;
import Final.springBoot.backend.exception.DataPersistException;
import Final.springBoot.backend.exception.ItemNotFoundException;
import Final.springBoot.backend.service.VehicleService;
import Final.springBoot.backend.util.Mapping;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VehicleServiceIMPL implements VehicleService {

    @Autowired
    private VehicleDao vehicleDao;

    @Autowired
    private Mapping mapping;

    @Autowired
    private StaffDao staffDao;

    @Override
    public void saveVehicle(VehicleDto vehicleDto) {
        VehicleEntity vehicleEntity = mapping.toVehicleEntity(vehicleDto);
        vehicleEntity.setStaffEntity(staffDao.getReferenceById(vehicleDto.getStaId()));
        VehicleEntity save = vehicleDao.save(vehicleEntity);

        if ( save == null) {
            throw new DataPersistException();
        }
    }

    @Override
    public List<VehicleDto> getVehicleList() {
        return mapping.asVehicleDtoList(vehicleDao.findAll());
    }

    @Override
    public Status getVehicleById(String vehicleId) {
        if (vehicleDao.existsById(vehicleId)) {
            VehicleEntity vehicleEntity = vehicleDao.getReferenceById(vehicleId);
            return mapping.toVehicleDto(vehicleEntity);
        }else {
            return new SelectedErrorStatus(2,"Vehicle not found");
        }
    }

    @Override
    public void updateVehicle(String vehicleId, VehicleDto vehicleDto) {
        Optional<VehicleEntity> byId = vehicleDao.findById(vehicleId);
        if (byId.isPresent()) {
            byId.get().setPlateNumber(vehicleDto.getPlateNumber());
            byId.get().setVehicleCategory(vehicleDto.getVehicleCategory());
            byId.get().setFuelType(vehicleDto.getFuelType());
            byId.get().setVehicleStatus(vehicleDto.getVehicleStatus());
            byId.get().setStaffEntity(staffDao.getReferenceById(vehicleDto.getStaId()));
            byId.get().setRemarks(vehicleDto.getRemarks());
        }


    }

    @Override
    public void deleteVehicle(String vehicleId) {
        Optional<VehicleEntity> vehicleEntity = vehicleDao.findById(vehicleId);
        if(!vehicleEntity.isPresent()){
            throw new ItemNotFoundException("vehicle with id " + vehicleId + " not found");
        }else {

            vehicleDao.deleteById(vehicleId);


        }
    }
}
