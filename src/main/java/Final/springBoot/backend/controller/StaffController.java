package Final.springBoot.backend.controller;

import Final.springBoot.backend.dto.impl.StaffDto;
import Final.springBoot.backend.dto.status.Status;
import Final.springBoot.backend.entity.Gender;
import Final.springBoot.backend.entity.JobRole;
import Final.springBoot.backend.exception.DataPersistException;
import Final.springBoot.backend.service.StaffService;
import Final.springBoot.backend.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;


    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveStaff(
            @RequestPart("staffId") String staffId,
            @RequestPart("firstName") String firstName,
            @RequestPart("lastName") String lastName,
            @RequestPart("staffDesignation") String staffDesignation,
            @RequestPart("gender") String gender,
            @RequestPart("joinedDate") String joinedDate,
            @RequestPart("DOB") String DOB,
            @RequestPart("AddressLine01") String AddressLine01,
            @RequestPart("AddressLine02") String AddressLine02,
            @RequestPart("AddressLine03") String AddressLine03,
            @RequestPart("AddressLine04") String AddressLine04,
            @RequestPart("AddressLine05") String AddressLine05,
            @RequestPart("contact") String contact,
            @RequestPart("email") String email,
            @RequestPart("jobRole") String jobRole,
            @RequestPart("image") MultipartFile image,
            @RequestPart("logCode") String logCode
    ) {

        try {
            staffService.saveStaff(assignValue(
                    staffId,
                    firstName,
                    lastName,
                    staffDesignation,
                    gender,
                    joinedDate,
                    DOB,
                    AddressLine01,
                    AddressLine02,
                    AddressLine03,
                    AddressLine04,
                    AddressLine05,
                    contact,
                    email,
                    jobRole,
                    image,
                    logCode));
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "/{staffCode}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Status> updateStaff(
            @PathVariable("staffCode") String staffId,
            @RequestPart("firstName") String firstName,
            @RequestPart("lastName") String lastName,
            @RequestPart("staffDesignation") String staffDesignation,
            @RequestPart("gender") String gender,
            @RequestPart("joinedDate") String joinedDate,
            @RequestPart("DOB") String DOB,
            @RequestPart("AddressLine01") String AddressLine01,
            @RequestPart("AddressLine02") String AddressLine02,
            @RequestPart("AddressLine03") String AddressLine03,
            @RequestPart("AddressLine04") String AddressLine04,
            @RequestPart("AddressLine05") String AddressLine05,
            @RequestPart("contact") String contact,
            @RequestPart("email") String email,
            @RequestPart("jobRole") String jobRole,
            @RequestPart("image") MultipartFile image,
            @RequestPart("logCode") String logCode
    ){
        try {
            staffService.updateStaff(staffId,assignValue(
                    staffId,
                    firstName,
                    lastName,
                    staffDesignation,
                    gender,
                    joinedDate,
                    DOB,
                    AddressLine01,
                    AddressLine02,
                    AddressLine03,
                    AddressLine04,
                    AddressLine05,
                    contact,
                    email,
                    jobRole,
                    image,
                    logCode));
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StaffDto> getStaffList(){
        return staffService.getStaffList();
    }

    @GetMapping(value = "/{staffCode}")
    public Status getCropById(@PathVariable("staffCode") String staffCode){
        return staffService.getStaffById(staffCode);
    }

    private StaffDto assignValue(String staffId,
                                 String firstName,
                                 String lastName,
                                 String staffDesignation,
                                 String gender,
                                 String joinedDate,
                                 String dob,
                                 String addressLine01,
                                 String addressLine02,
                                 String addressLine03,
                                 String addressLine04,
                                 String addressLine05,
                                 String contact,
                                 String email, String jobRole, MultipartFile image, String logCode) throws IOException {
        StaffDto staffDto = new StaffDto();
        staffDto.setStaffId(staffId);
        staffDto.setFirstName(firstName);
        staffDto.setLastName(lastName);
        staffDto.setStaffDesignation(JobRole.valueOf(staffDesignation));
        staffDto.setGender(Gender.valueOf(gender));
        staffDto.setJoinedDate(joinedDate);
        staffDto.setDOB(dob);
        staffDto.setAddressLine01(addressLine01);
        staffDto.setAddressLine02(addressLine02);
        staffDto.setAddressLine03(addressLine03);
        staffDto.setAddressLine04(addressLine04);
        staffDto.setAddressLine05(addressLine05);
        staffDto.setContact(contact);
        staffDto.setEmail(email);
        staffDto.setJobRole(JobRole.valueOf(jobRole));
        staffDto.setImage(AppUtil.convertImage(image));
        staffDto.setLogCode(logCode);
        return staffDto;
    }


}