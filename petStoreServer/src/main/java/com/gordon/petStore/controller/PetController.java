package com.gordon.petStore.controller;

import com.gordon.petStore.model.PetEO;
import com.gordon.petStore.request.PetRequest;
import com.gordon.petStore.response.ApiResponse;
import com.gordon.petStore.response.PetResponse;
import com.gordon.petStore.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/list/{category}")
    public List<PetResponse> listPet(@PathVariable String category){
        System.out.println(category);
        ArrayList<PetEO> petEOList = (ArrayList<PetEO>) petService.listPet(category);
        ArrayList<PetResponse> petResponseList = new ArrayList<>();

        petEOList.stream().forEach(petEO -> {
            PetResponse petResponse = new PetResponse();
            petResponse.setName(petEO.getName());
            petResponse.setPrice(String.valueOf(petEO.getPrice()));
            petResponse.setCategory(petEO.getCategory().getName());
            petResponseList.add(petResponse);
        });
        System.out.println(petEOList.size());
        return petResponseList;

    }
}
