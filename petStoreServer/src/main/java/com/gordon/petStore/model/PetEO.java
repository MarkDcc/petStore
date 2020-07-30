package com.gordon.petStore.model;

import javax.persistence.*;

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
    @Column
    private CategoryEO category;
}
