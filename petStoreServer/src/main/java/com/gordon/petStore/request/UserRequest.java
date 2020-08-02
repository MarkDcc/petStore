package com.gordon.petStore.request;

import javax.validation.constraints.NotNull;

/**
 * @author dongchen
 * @Data 2020/8/1
 * @Time 18:35
 */
public class UserRequest {

    @NotNull
    private String name;

    @NotNull
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
