package com.gordon.petStore.controller;

import com.gordon.petStore.request.PetRequest;
import com.gordon.petStore.response.ApiResponse;
import com.gordon.petStore.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author dongchen
 * @Data 2020/8/1
 * @Time 13:33
 */
@RestController
@RequestMapping("/api/pet")
public class PetController {
    @Autowired
    PetService petService;

    @PostMapping("/add")
    public ResponseEntity addPet(@Valid @RequestBody PetRequest petRequest){
        petService.addPet(petRequest);

        return ResponseEntity.ok(new ApiResponse("Successful invoke", HttpStatus.CREATED.name()));
    }

    @PostMapping("/update")
    public ResponseEntity updatePet(@Valid @RequestBody PetRequest petRequest){
        petService.updatePet(petRequest);
        return ResponseEntity.ok(new ApiResponse("Successful invoke", HttpStatus.CREATED.name()));
    }

    @PostMapping("/delete")
    public ResponseEntity deletePet(@Valid @RequestBody PetRequest petRequest){
        petService.deletePet(petRequest);
        return ResponseEntity.ok(new ApiResponse("Successful invoke", HttpStatus.CREATED.name()));
    }
}
