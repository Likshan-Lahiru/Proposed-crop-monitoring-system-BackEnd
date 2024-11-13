package Final.springBoot.backend.dto.impl;

import Final.springBoot.backend.dto.SuperDto;
import Final.springBoot.backend.entity.Gender;
import Final.springBoot.backend.entity.JobRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffDto implements SuperDto {
    private String staffId;
    private String firstName;
    private String lastName;
    private JobRole staffDesignation;
    private Gender gender;
    private String joinedDate;
    private String DOB;
    private String AddressLine01;
    private String AddressLine02;
    private String AddressLine03;
    private String AddressLine04;
    private String AddressLine05;
    private String contact;
    private String email;
    private JobRole jobRole;
    private List<FieldDto> fields;
    private List<VehicleDto> vehicles;
    private String image;
    private String logCode;
}
