package com.gordon.petStore.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
}
