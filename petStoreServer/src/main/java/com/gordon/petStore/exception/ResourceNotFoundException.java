package com.gordon.petStore.exception;

/**
 * @author dongchen
 * @Data 2020/7/31
 * @Time 15:12
 */
public class ResourceNotFoundException extends Exception{
    private String resource;

    public ResourceNotFoundException(String resource){
        super(String.format("Resource not found: %s",resource));
        this.resource = resource;
    }
}
