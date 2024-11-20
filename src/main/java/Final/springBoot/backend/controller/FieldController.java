package Final.springBoot.backend.controller;

import Final.springBoot.backend.dto.impl.CropDto;
import Final.springBoot.backend.dto.impl.FieldDto;
import Final.springBoot.backend.exception.DataPersistException;
import Final.springBoot.backend.service.FieldService;
import Final.springBoot.backend.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/field")
public class FieldController {
    @Autowired
    private FieldService fieldService;


    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveCrop(
            @RequestPart("fieldCode") String fieldCode,
            @RequestPart ("fieldName") String fieldName,
            @RequestPart ("fieldLocation") String fieldLocation,
            @RequestPart ("fieldSize") String fieldSize,
            @RequestPart ("image1") MultipartFile image1,
            @RequestPart ("image2") MultipartFile image2,
            @RequestPart ("logCode") String logCode
    ){
        System.out.println("cropCode"+fieldCode);
        try {
            FieldDto fieldDto = new FieldDto();
            fieldDto.setFieldCode(fieldCode);
            fieldDto.setFieldName(fieldName);
            fieldDto.setFieldLocation(Integer.parseInt(fieldLocation));
            fieldDto.setFieldSize(Double.valueOf(fieldSize));
            fieldDto.setImage1(AppUtil.convertImage(image1));
            fieldDto.setImage2(AppUtil.convertImage(image2));
            fieldDto.setLogCode(logCode);


            fieldService.saveField(fieldDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }



    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "/{fieldCode}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> updateField(
            @RequestPart("fieldCode") String fieldCode,
            @RequestPart ("fieldName") String fieldName,
            @RequestPart ("fieldLocation") String fieldLocation,
            @RequestPart ("fieldSize") String fieldSize,
            @RequestPart ("image1") MultipartFile image1,
            @RequestPart ("image2") MultipartFile image2,
            @RequestPart ("logCode") String logCode
    ){
        System.out.println("updateField"+fieldCode);
        try {
            FieldDto fieldDto = new FieldDto();
            fieldDto.setFieldCode(fieldCode);
            fieldDto.setFieldName(fieldName);
            fieldDto.setFieldLocation(Integer.parseInt(fieldLocation));
            fieldDto.setFieldSize(Double.valueOf(fieldSize));
            fieldDto.setImage1(AppUtil.convertImage(image1));
            fieldDto.setImage2(AppUtil.convertImage(image2));
            fieldDto.setLogCode(logCode);


            fieldService.updateField(fieldCode,fieldDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FieldDto> getFieldList(){
        return fieldService.getFieldList();
    }



}
