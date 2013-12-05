package com.lnu.bean;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * User: igor
 * Date: 12/4/13
 */
@Entity
@Table(name = "THREADS")
public class Thread{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Display_Name")
    private String displayName;

    @ManyToOne
    @JoinColumn(name = "Author_ID")
    private Author author;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "Category_ID")
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
