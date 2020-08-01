package com.gordon.petStore.request;

import javax.validation.constraints.NotNull;

/**
 * @author dongchen
 * @Data 2020/7/31
 * @Time 10:58
 */
public class CategoryRequest {

    @NotNull
    private String name;

    @NotNull
    private String parent;

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
