package com.lnu.bean;

import javax.persistence.*;

/**
 * User: igor
 * Date: 12/4/13
 */
@Entity
@Table(name = "POSTS")
public class Post{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
