package Final.springBoot.backend.controller;

import Final.springBoot.backend.dto.impl.EquipmentDto;
import Final.springBoot.backend.dto.status.Status;
import Final.springBoot.backend.exception.DataPersistException;
import Final.springBoot.backend.exception.ItemNotFoundException;
import Final.springBoot.backend.exception.NotFoundException;
import Final.springBoot.backend.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveEquipment(@RequestBody EquipmentDto equipmentDto) {
        System.out.println(equipmentDto);
        try {
            equipmentService.saveEquipment(equipmentDto);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping(value = "/{equipmentId}")
    public ResponseEntity<Void> updateNote(@PathVariable ("equipmentId") String equipmentId,
                                           @RequestBody EquipmentDto equipmentDto){

        try {

            equipmentService.updateEquipment(equipmentId, equipmentDto);
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
    public List<EquipmentDto> getALlEquipment(){
        return equipmentService.getEquipmentList();
    }

    @GetMapping(value = "/{EquipmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Status getSelectedEquipment(@PathVariable ("EquipmentId") String equipmentId){
        return equipmentService.getEquipmentById(equipmentId);
    }

    @DeleteMapping(value = "/{equipmentCode}")
    public ResponseEntity<Object> deleteEquipment(@PathVariable("equipmentCode") String equipmentCode){
        try {
            equipmentService.deleteEquipment(equipmentCode);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (ItemNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }





}