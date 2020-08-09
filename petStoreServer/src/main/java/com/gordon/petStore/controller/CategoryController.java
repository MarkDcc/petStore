package com.gordon.petStore.controller;

import com.gordon.petStore.exception.ResourceCanNotDelete;
import com.gordon.petStore.request.CategoryRequest;
import com.gordon.petStore.response.ApiResponse;
import com.gordon.petStore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author dongchen
 * @Data 2020/7/31
 * @Time 10:50
 */
@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("/hello")
    public String hello(){
        return "Hello";
    }


    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ResponseEntity createCategory( @Valid @RequestBody CategoryRequest category) throws Exception {
        categoryService.save(category);
        return ResponseEntity.ok(new ApiResponse("Successful invoke",HttpStatus.CREATED.toString()));
    }

    @PostMapping("/delete")
    public ResponseEntity deleteCategory(@Valid @RequestBody CategoryRequest category) throws ResourceCanNotDelete {
        categoryService.delete(category);
        return ResponseEntity.ok(new ApiResponse("Successful invoke",HttpStatus.OK.toString()));

    }


    }

