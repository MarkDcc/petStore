package com.gordon.petStore.response;

/**
 * @author dongchen
 * @Data 2020/8/2
 * @Time 13:14
 */
public class PetResponse {
    private String name;
    private String price;
    private String category;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

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
}
