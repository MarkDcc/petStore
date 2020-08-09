package com.gordon.petStore.response;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * @author dongchen
 * @Data 2020/7/31
 * @Time 10:58
 */
public class ApiResponse {

    //TODO 增加时间，路径参数，请求参数等信息

    private String message;

    private String status;


    public ApiResponse() {
    }

    public ApiResponse(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
