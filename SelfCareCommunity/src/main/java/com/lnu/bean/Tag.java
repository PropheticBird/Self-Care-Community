package com.lnu.bean;

import javax.persistence.*;

/**
 * User: igor
 * Date: 12/13/13
 */
@Entity
@Table(name = "TAGS")
public class Tag {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Tag_Name")
    private String tagName;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
