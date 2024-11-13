package Final.springBoot.backend.controller;

import Final.springBoot.backend.dto.impl.CropDto;
import Final.springBoot.backend.exception.DataPersistException;
import Final.springBoot.backend.service.CropService;
import Final.springBoot.backend.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/crop")
public class CropController {
    @Autowired
    private CropService cropService;

    private CropDto cropDto;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveCrop(
            @RequestPart("cropCode") String cropCode,
            @RequestPart ("cropCommonName") String cropCommonName,
            @RequestPart ("cropScientificName") String cropScientificName,
            @RequestPart ("cropCategory") String cropCategory,
            @RequestPart ("cropImage") MultipartFile cropImage,
            @RequestPart ("cropSeason") String cropSeason,
            @RequestPart ("fieldCode") String fieldCode,
            @RequestPart ("logCode") String logCode
    ){
        System.out.println("cropCode"+cropCode);
        try {


            cropDto = new CropDto();
            cropDto.setCropCode(cropCode);
            cropDto.setCropCommonName(cropCommonName);
            cropDto.setCropScientificName(cropScientificName);
            cropDto.setCropImage(convertImage(cropImage));
            cropDto.setCropCategory(cropCategory);
            cropDto.setCropSeason(cropSeason);
            cropDto.setFieldCode(fieldCode);
            cropDto.setLogCode(logCode);
            cropService.saveCrop(cropDto);



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
    @PutMapping(value = "/{cropCode}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> updateCrop(
            @PathVariable("cropCode") String cropCode,
            @RequestPart ("cropCommonName") String cropCommonName,
            @RequestPart ("cropScientificName") String cropScientificName,
            @RequestPart ("cropCategory") String cropCategory,
            @RequestPart ("cropImage") MultipartFile cropImage,
            @RequestPart ("cropSeason") String cropSeason,
            @RequestPart ("fieldCode") String fieldCode,
            @RequestPart ("logCode") String logCode
    ){
        System.out.println("cropCode"+cropCode);
        try {

            cropDto = new CropDto();
            cropDto.setCropCode(cropCode);
            cropDto.setCropCommonName(cropCommonName);
            cropDto.setCropScientificName(cropScientificName);
            cropDto.setCropImage(convertImage(cropImage));
            cropDto.setCropCategory(cropCategory);
            cropDto.setCropSeason(cropSeason);
            cropDto.setFieldCode(fieldCode);
            cropDto.setLogCode(logCode);

            cropService.updateCrop(cropCode,cropDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

     String convertImage(MultipartFile cropImage) throws IOException {
         byte [] cropImageBytes = cropImage.getBytes();
         String base64CropImage = AppUtil.profilePicToBase64(cropImageBytes);
        return base64CropImage;
    }

}
