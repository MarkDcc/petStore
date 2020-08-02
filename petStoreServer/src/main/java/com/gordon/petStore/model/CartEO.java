package com.gordon.petStore.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author dongchen
 * @Data 2020/7/31
 * @Time 10:15
 */
@Entity
@Table(name = "tb_cart")
public class CartEO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEO userEO;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "cart")
    private List<CartItemEO> cartItemEOList = new ArrayList<>();

    public CartEO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CartEO cartEO = (CartEO) o;
        return Objects.equals(getId(), cartEO.getId()) &&
                Objects.equals(getName(), cartEO.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    public CartEO(String name, Date date, Boolean payed) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CartItemEO> getCartItemEOList() {
        return cartItemEOList;
    }

    public void setCartItemEOList(List<CartItemEO> cartItemEOList) {
        this.cartItemEOList = cartItemEOList;
    }
}
