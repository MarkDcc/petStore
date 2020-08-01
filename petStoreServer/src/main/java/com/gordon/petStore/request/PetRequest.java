package com.gordon.petStore.request;

import javax.validation.constraints.NotNull;

/**
 * @author dongchen
 * @Data 2020/8/1
 * @Time 13:35
 */
public class PetRequest {

    @NotNull
    private String name;

    private @NotNull String price;

    @NotNull
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public @NotNull String getPrice() {
        return price;
    }

    public void setPrice(@NotNull String price) {
        this.price = price;
    }
}
