package Final.springBoot.backend.dto.impl;


import Final.springBoot.backend.dto.status.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDto implements Status {
    private String vehicleCode;
    private String plateNumber;
    private String vehicleCategory;
    private String FuelType;
    private String vehicleStatus;
    private String staffId;
    private String remarks;
}
