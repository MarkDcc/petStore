package com.gordon.petStore.model;

import javax.persistence.*;

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
    private String login;

    @Column
    private String password;



}
