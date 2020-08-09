package com.gordon.petStore.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author
 * @Description TODO
 * @date
 */
@Entity
@Table(name = "tb_user")
public class UserEO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CartEO> cartEOList = new ArrayList<>();

    public UserEO() {
    }

    public UserEO(String login, String password) {
        this.name = login;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEO userEO = (UserEO) o;
        return Objects.equals(getId(), userEO.getId()) &&
                Objects.equals(getName(), userEO.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
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

    public void setName(String login) {
        this.name = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<CartEO> getCartEOList() {
        return cartEOList;
    }

    public void setCartEOList(List<CartEO> cartEOList) {
        this.cartEOList = cartEOList;
    }

}