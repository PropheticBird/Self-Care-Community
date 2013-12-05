package com.lnu.bean.view;

import java.util.List;

/**
 * User: igor
 * Date: 12/5/13
 */
public class Page<E> {

    private Boolean isLast;
    private List<E> data;

    public Page(Boolean last, List<E> data) {
        isLast = last;
        this.data = data;
    }

    public Boolean getLast() {
        return isLast;
    }

    public void setLast(Boolean last) {
        isLast = last;
    }

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }
}
