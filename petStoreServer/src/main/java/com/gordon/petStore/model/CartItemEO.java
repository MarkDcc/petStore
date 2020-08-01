package com.gordon.petStore.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Objects;

/**
 * @author dongchen
 * @Data 2020/7/31
 * @Time 10:15
 */
@Entity
@Table(name ="tb_cartItem")
public class CartItemEO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String petName;

    @Column
    private String petCategoryName;

    @Column
    private Integer count;

    @Column
    private double price;

    public CartItemEO(String petName, String petCategoryName, Integer count, double price) {
        this.petName = petName;
        this.petCategoryName = petCategoryName;
        this.count = count;
        this.price = price;
    }

    public CartItemEO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItemEO that = (CartItemEO) o;
        return Double.compare(that.getPrice(), getPrice()) == 0 &&
                Objects.equals(getId(), that.getId()) &&
                Objects.equals(getPetName(), that.getPetName()) &&
                Objects.equals(getPetCategoryName(), that.getPetCategoryName()) &&
                Objects.equals(getCount(), that.getCount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPetName(), getPetCategoryName(), getCount(), getPrice());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetCategoryName() {
        return petCategoryName;
    }

    public void setPetCategoryName(String petCategoryName) {
        this.petCategoryName = petCategoryName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
