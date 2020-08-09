package com.gordon.petStore.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;
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

    @Column
    private Boolean payed;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private CartEO cart;

    public Boolean getPayed() {
        return payed;
    }

    public void setPayed(Boolean payed) {
        this.payed = payed;
    }

    public CartEO getCart() {
        return cart;
    }

    public void setCart(CartEO cart) {
        this.cart = cart;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public CartItemEO(String petName, String petCategoryName, Integer count, double price, Boolean payed, Date date, CartEO cart) {
        this.petName = petName;
        this.petCategoryName = petCategoryName;
        this.count = count;
        this.price = price;
        this.payed = payed;
        this.date = date;
        this.cart = cart;
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
                Objects.equals(getCount(), that.getCount()) &&
                Objects.equals(getPayed(), that.getPayed()) &&
                Objects.equals(getDate(), that.getDate()) &&
                Objects.equals(getCart(), that.getCart());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPetName(), getPetCategoryName(), getCount(), getPrice(), getPayed(), getDate(), getCart());
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
