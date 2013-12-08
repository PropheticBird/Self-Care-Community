package com.lnu.bean;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.Set;

/**
 * User: igor
 * Date: 12/4/13
 */
@Entity
@Table(name = "CATEGORIES")
public class Category {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Display_Name")
    private String displayName;

    @Formula(value = "(select count(*) from threads where threads.category_id=id)")
    private Long threadCount;

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

    public Long getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(Long threadCount) {
        this.threadCount = threadCount;
    }
}
