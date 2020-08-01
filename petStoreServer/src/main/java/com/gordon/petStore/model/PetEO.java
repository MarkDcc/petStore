package com.gordon.petStore.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author
 * @Description TODO
 * @date
 */
@Entity
@Table(name = "tb_pet")
public class PetEO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private double price;

    @ManyToOne(fetch =FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private CategoryEO category;


    public PetEO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetEO petEO = (PetEO) o;
        return Double.compare(petEO.getPrice(), getPrice()) == 0 &&
                Objects.equals(getId(), petEO.getId()) &&
                Objects.equals(getName(), petEO.getName()) &&
                Objects.equals(getCategory(), petEO.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPrice());
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CategoryEO getCategory() {
        return category;
    }

    public void setCategory(CategoryEO category) {
        this.category = category;
    }
}
