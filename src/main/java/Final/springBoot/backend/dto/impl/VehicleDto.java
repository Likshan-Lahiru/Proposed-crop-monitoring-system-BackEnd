package Final.springBoot.backend.dto.impl;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDto {
    private String vehicleCode;
    private String plateNumber;
    private String vehicleCategory;
    private String FuelType;
    private String vehicleStatus;
    private String staffId;
    private String remarks;
}
