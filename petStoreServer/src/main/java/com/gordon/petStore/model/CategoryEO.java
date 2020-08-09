package com.gordon.petStore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.*;

/**
 * @author
 * @Description TODO
 * @date
 */
@Entity
@Table(name = "tb_category")
public class CategoryEO {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id")
    private CategoryEO parent;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "parent")
    private Set<CategoryEO> subCategoryEO = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "category")
    private List<PetEO> pets = new ArrayList<>();

    public CategoryEO(String name) {
        this.name = name;
    }

    public CategoryEO() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryEO that = (CategoryEO) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName());

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

    public void setName(String name) {
        this.name = name;
    }

    public CategoryEO getParent() {
        return parent;
    }

    public void setParent(CategoryEO parent) {
        this.parent = parent;
    }

    public Set<CategoryEO> getSubCategoryEO() {
        return subCategoryEO;
    }

    public void setSubCategoryEO(Set<CategoryEO> subCategoryEO) {
        this.subCategoryEO = subCategoryEO;
    }

    public List<PetEO> getPets() {
        return pets;
    }

    public void setPets(List<PetEO> pets) {
        this.pets = pets;
    }
}
