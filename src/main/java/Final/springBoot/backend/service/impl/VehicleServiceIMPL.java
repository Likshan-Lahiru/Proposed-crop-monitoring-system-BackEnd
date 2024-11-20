package Final.springBoot.backend.service.impl;

import Final.springBoot.backend.dto.impl.VehicleDto;
import Final.springBoot.backend.dto.status.CropStatus;
import Final.springBoot.backend.service.VehicleService;

import java.util.List;

public class VehicleServiceIMPL implements VehicleService {
    @Override
    public void saveVehicle(VehicleDto vehicleDto) {

    }

    @Override
    public List<VehicleDto> getVehicleList() {
        return List.of();
    }

    @Override
    public CropStatus getVehicleById(String vehicleId) {
        return null;
    }

    @Override
    public void updateVehicle(String vehicleId, VehicleDto vehicleDto) {

    }

    @Override
    public void deleteVehicle(String vehicleId) {

    }
}
