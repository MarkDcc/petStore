package com.gordon.petStore.exception;

/**
 * @author dongchen
 * @Data 2020/8/1
 * @Time 12:38
 */
public class ResourceCanNotDelete extends Exception{

    private String resource;
    private String reason;

    public ResourceCanNotDelete(String resource,String reason){
        super(String.format("%s can't be delete, because of %s have %s",resource,resource,reason));
    }
}
