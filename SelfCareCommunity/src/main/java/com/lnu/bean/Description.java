package com.lnu.bean;

import javax.persistence.*;

/**
 * User: igor
 * Date: 12/13/13
 */
@Entity
@Table(name = "DESCRIPTIONS")
public class Description {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "When_")
    private String when;

    @Column(name = "Where_")
    private String where;

    @Column(name = "How")
    private String how;

    @Column(name = "Who")
    private String who;

    @Column(name = "Why")
    private String why;

    @Column(name = "Consequences")
    private String consequences;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getHow() {
        return how;
    }

    public void setHow(String how) {
        this.how = how;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getWhy() {
        return why;
    }

    public void setWhy(String why) {
        this.why = why;
    }

    public String getConsequences() {
        return consequences;
    }

    public void setConsequences(String consequences) {
        this.consequences = consequences;
    }
}
