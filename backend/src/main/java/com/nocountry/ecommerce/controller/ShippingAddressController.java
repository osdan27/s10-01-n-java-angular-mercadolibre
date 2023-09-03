package com.nocountry.ecommerce.controller;

import com.nocountry.ecommerce.model.ShippingAddress;
import com.nocountry.ecommerce.service.ShippingAddressIMPL;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ShippingAddress")
public class ShippingAddressController {

    @Autowired
    private ShippingAddressIMPL saimpl;

    @GetMapping
    @RequestMapping(value = "shippingAddressList", method = RequestMethod.GET)
    public ResponseEntity<?> shippingAddressList() {

        List<ShippingAddress> list = this.saimpl.shippingAddressList();

        return ResponseEntity.ok(list);

    }
    
    @PostMapping
    @RequestMapping(value = "createShippingAddress", method = RequestMethod.POST)
    public ResponseEntity<?> createShippingAddress(@RequestBody ShippingAddress shippingAddress){
        
        if(shippingAddress.getCity() == null ||
           shippingAddress.getCity().isEmpty() ||
           shippingAddress.getCity().isBlank())
           return new ResponseEntity<>("City can't be empty",HttpStatus.BAD_REQUEST);
        
        if(!shippingAddress.getCity().matches("^[a-zA-Z]+$"))
            return new ResponseEntity<>("City must contain only letters", HttpStatus.BAD_REQUEST);
        
        if(shippingAddress.getCountry() == null ||
           shippingAddress.getCountry().isEmpty() ||
           shippingAddress.getCountry().isBlank())
           return new ResponseEntity<>("Country can't be empty", HttpStatus.BAD_REQUEST);
        
        if(!shippingAddress.getCountry().matches("^[a-zA-Z]+$"))
            return new ResponseEntity<>("Country must contain only letters", HttpStatus.BAD_REQUEST);
        
        if(!shippingAddress.getPhone().matches("\\d+"))
            return new ResponseEntity<>("Phone number must contain only digits", HttpStatus.BAD_REQUEST);
        
        if(shippingAddress.getPhone().length()<7 ||
           shippingAddress.getPhone().length()>12)
           return new ResponseEntity<>("Phone number must contain minimum 7 digits", HttpStatus.NOT_ACCEPTABLE);
        
        if(!shippingAddress.getPostalCode().matches("^[a-zA-Z0-9]+$"))
            return new ResponseEntity<>("Postal code must contain only digits or letters", HttpStatus.BAD_REQUEST);
        
        if(shippingAddress.getPostalCode().length()<3 ||
           shippingAddress.getPostalCode().length()>10)
           return new ResponseEntity<>("Postal code must contain minimum 3 digits", HttpStatus.NOT_ACCEPTABLE);
        
        ShippingAddress address = this.saimpl.createShippingAddress(shippingAddress);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(address);
        
    }
    
    @PutMapping
    @RequestMapping( value = "modifyShippingAddress", method = RequestMethod.PUT)
    public ResponseEntity<?> modifyShippingAddress(@RequestBody ShippingAddress shippingAddress){
        
         if(shippingAddress.getCity() == null ||
           shippingAddress.getCity().isEmpty() ||
           shippingAddress.getCity().isBlank())
           return new ResponseEntity<>("City can't be empty",HttpStatus.BAD_REQUEST);
        
        if(!shippingAddress.getCity().matches("^[a-zA-Z]+$"))
            return new ResponseEntity<>("City must contain only letters", HttpStatus.BAD_REQUEST);
        
        if(shippingAddress.getCountry() == null ||
           shippingAddress.getCountry().isEmpty() ||
           shippingAddress.getCountry().isBlank())
           return new ResponseEntity<>("Country can't be empty", HttpStatus.BAD_REQUEST);
        
        if(!shippingAddress.getCountry().matches("^[a-zA-Z]+$"))
            return new ResponseEntity<>("Country must contain only letters", HttpStatus.BAD_REQUEST);
        
        if(!shippingAddress.getPhone().matches("\\d+"))
            return new ResponseEntity<>("Phone number must contain only digits", HttpStatus.BAD_REQUEST);
        
        if(shippingAddress.getPhone().length()<7 ||
           shippingAddress.getPhone().length()>12)
           return new ResponseEntity<>("Phone number must contain minimum 7 digits", HttpStatus.NOT_ACCEPTABLE);
        
        if(!shippingAddress.getPostalCode().matches("^[a-zA-Z0-9]+$"))
            return new ResponseEntity<>("Postal code must contain only digits or letters", HttpStatus.BAD_REQUEST);
        
        if(shippingAddress.getPostalCode().length()<3 ||
           shippingAddress.getPostalCode().length()>10)
           return new ResponseEntity<>("Postal code must contain minimum 3 digits", HttpStatus.NOT_ACCEPTABLE);
        
        ShippingAddress address = this.saimpl.modifyShippingAddress(shippingAddress);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(address);
        
    }
    
    @GetMapping
    @RequestMapping(value = "consultShippingAddress/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> consultShippingAddress(@PathVariable int id){
        
        ShippingAddress address = null;
                
        address = this.saimpl.consultShippingAddress(id);
        try{
            if(address != null ) return new ResponseEntity<>(address, HttpStatus.OK);
            
            else return new ResponseEntity<>("The given address doesn't exists", HttpStatus.NOT_FOUND);
            
        } catch (NoSuchElementException e) {
            e.printStackTrace(System.out);
            return new ResponseEntity<>("An error occurred while fetching the address", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping
    @RequestMapping(value = "deleteShippingAddress/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteShippingAddress(@PathVariable int id){

        ShippingAddress address = null;

        try {
            address = this.saimpl.consultShippingAddress(id);

            if (address != null) this.saimpl.deleteShippingAddress(id);

        } catch (NoSuchElementException e) {
            e.printStackTrace(System.out);
            return new ResponseEntity<>("The given address doesn't exists", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(address, HttpStatus.OK);
    }
}