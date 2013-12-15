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
@Table(name = "POSTS")
public class Post{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "Author_ID")
    private Person person;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "Thread_ID")
    private Thread thread;

    @Column(name = "Content")
    private String content;

    @Column(name = "Likes")
    private Integer likes;

    @Transient
    private Boolean canLike;

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserealizer.class)
    @Column(name = "Posted_Date")
    private Date postedDate;

    @Transient
    private Author author;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Boolean getCanLike() {
        return canLike;
    }

    public void setCanLike(Boolean canLike) {
        this.canLike = canLike;
    }
}
