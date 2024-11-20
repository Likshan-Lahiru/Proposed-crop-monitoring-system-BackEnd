package Final.springBoot.backend.controller;

import Final.springBoot.backend.dto.impl.FieldDto;
import Final.springBoot.backend.exception.DataPersistException;
import Final.springBoot.backend.service.FieldService;
import Final.springBoot.backend.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;

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
            fieldDto.setImage1(convertImage(image1));
            fieldDto.setImage2(convertImage(image2));
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

    public static String convertImage(MultipartFile cropImage) throws IOException {
        byte [] cropImageBytes = cropImage.getBytes();
        String base64CropImage = AppUtil.profilePicToBase64(cropImageBytes);
        return base64CropImage;
    }


}
