package com.project.e_commerce.controller;

import com.project.e_commerce.model.User;
import com.project.e_commerce.payload.AddressDTO;
import com.project.e_commerce.service.AddressService;
import com.project.e_commerce.util.AuthUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressController {

    @Autowired
    AuthUtil authUtil;

    @Autowired
    AddressService addressService;

    @PostMapping("/addresses")
    public ResponseEntity<AddressDTO> createAddress(@Valid @RequestBody AddressDTO addressDTO){
        User user = authUtil.loggedInUser();
        AddressDTO savedAddressDTO = addressService.createAddress(addressDTO,user);
        return new ResponseEntity<>(savedAddressDTO, HttpStatus.CREATED);
    }
    @GetMapping("/addresses")
    public ResponseEntity<List<AddressDTO>> getAddresses(){
        List<AddressDTO> savedAddressDTO = addressService.getAllAddresses();
        return new ResponseEntity<>(savedAddressDTO, HttpStatus.OK);
    }

    @GetMapping("/address/{addressId}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable Long addressId){
        AddressDTO address = addressService.getAddressById(addressId);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @GetMapping("/user/addresses")
    public ResponseEntity<List<AddressDTO>> getUserAddresses(){
        User user = authUtil.loggedInUser();
        List<AddressDTO> savedAddressDTO = addressService.getAUserddresses(user);
        return new ResponseEntity<>(savedAddressDTO, HttpStatus.OK);
    }

    @PutMapping("/address/{addressId}")
    public ResponseEntity<AddressDTO> updateAddressById(@PathVariable Long addressId,@RequestBody AddressDTO addressDTO){
        AddressDTO address = addressService.updateAddressById(addressId,addressDTO);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @DeleteMapping("/address/{addressId}")
    public ResponseEntity<String> deleteAddressById(@PathVariable Long addressId){
        String status = addressService.deleteAddressById(addressId);
        return new ResponseEntity<>(status,HttpStatus.OK);
    }
}
