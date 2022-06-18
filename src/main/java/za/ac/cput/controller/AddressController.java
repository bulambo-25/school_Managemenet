package za.ac.cput.controller;

/*Martinez Safari 219325332
	  ADP3 - June Assessment 2022
	  School Management System
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Address;
import za.ac.cput.service.interf.AddressService;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("school_Management/employeeAddress/")
@Slf4j
public class AddressController {

    private final AddressService AddressService;

    @Autowired
    public AddressController(AddressService AddressService) {
        this.AddressService = AddressService;
    }

    @PostMapping("save_Address")
    public ResponseEntity<Address> save(@Valid @RequestBody Address saveAddress){
        log.info("Save request: {}",saveAddress);

        try{
            Address Address = AddressService.save(saveAddress);
            return ResponseEntity.ok(Address);

        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @GetMapping("readAddress/{empID}")
    public ResponseEntity<Optional<Address>> read(@PathVariable String adID){
        log.info("Read request: {}",adID);

        try{
            Optional<Address> readAddress = AddressService.read(adID);
            return ResponseEntity.ok(readAddress);

        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @DeleteMapping("deleteAddress/{edID}")
    public ResponseEntity<Address> delete(@PathVariable Address adID){
        log.info("Delete request: {}",adID);

        this.AddressService.delete(adID);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("getAllAddresses")
    public ResponseEntity<List<Address>> getAll(){
        List<Address> listAddress = this.AddressService.findAll();
        return ResponseEntity.ok(listAddress);
    }
}

