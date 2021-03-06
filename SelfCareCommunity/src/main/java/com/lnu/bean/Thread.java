package com.lnu.bean;

import com.lnu.bean.view.Author;
import com.lnu.controller.json.converter.JsonDateDeserealizer;
import com.lnu.controller.json.converter.JsonDateSerializer;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.Date;

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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "Author_ID")
    private Person person;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "Category_ID")
    private Category category;

    @Transient
    private Author author;

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserealizer.class)
    @Formula(value = "(select max(posts.posted_date) from posts where posts.thread_id=id)")
    private Date lastPostDate;

    @Formula(value = "(select count(*) from posts where posts.thread_id=id)")
    private Long postCount;

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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Long getPostCount() {
        return postCount;
    }

    public void setPostCount(Long postCount) {
        this.postCount = postCount;
    }
    public Date getLastPostDate() {
        return lastPostDate;
    }

    public void setLastPostDate(Date lastPostDate) {
        this.lastPostDate = lastPostDate;
    }
}
