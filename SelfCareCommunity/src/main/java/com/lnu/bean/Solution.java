package com.lnu.bean;

import com.lnu.bean.view.Author;
import com.lnu.controller.json.converter.JsonDateDeserealizer;
import com.lnu.controller.json.converter.JsonDateSerializer;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * User: igor
 * Date: 12/13/13
 */
@Entity
@Table(name = "SOLUTIONS")
public class Solution {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "Author_ID")
    private Person person;

    private String description;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "Problem_ID")
    private Problem problem;

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserealizer.class)
    @Column(name = "Posted_Date")
    private Date postedDate;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "SOLUTION_TO_TAGS",
            joinColumns = {@JoinColumn(name = "Solution_ID",referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "Tag_ID",referencedColumnName = "ID")})
    private Set<Tag> tags;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
