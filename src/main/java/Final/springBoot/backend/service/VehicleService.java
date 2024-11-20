package Final.springBoot.backend.service;

import Final.springBoot.backend.dto.impl.StaffDto;
import Final.springBoot.backend.dto.impl.UserDto;
import Final.springBoot.backend.dto.impl.VehicleDto;
import Final.springBoot.backend.dto.status.CropStatus;

import java.util.List;

public interface VehicleService {
    void saveVehicle(VehicleDto vehicleDto);
    List<VehicleDto> getVehicleList();
    CropStatus getVehicleById(String vehicleId);
    void updateVehicle(String vehicleId, VehicleDto vehicleDto);
    void deleteVehicle(String vehicleId);
}
