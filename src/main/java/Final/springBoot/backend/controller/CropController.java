package Final.springBoot.backend.controller;

import Final.springBoot.backend.dto.impl.CropDto;
import Final.springBoot.backend.exception.DataPersistException;
import Final.springBoot.backend.service.CropService;
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

@RestController
@RequestMapping("api/v1/crop")
public class CropController {
    @Autowired
    private CropService cropService;



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


        String base64ProPic = "";
        try {
           byte [] cropImageBytes = cropImage.getBytes();
            String base64CropImage = AppUtil.profilePicToBase64(cropImageBytes);
            CropDto cropDto = new CropDto();
            cropDto.setCropCode(cropCode);
            cropDto.setCropCommonName(cropCommonName);
            cropDto.setCropScientificName(cropScientificName);
            cropDto.setCropImage(base64CropImage);
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

}
