package com.lnu.bean.view;

/**
 * User: igor
 * Date: 12/11/13
 */
public class InsertionResult extends Result {

    public static final InsertionResult OK = new InsertionResult("ok");
    public static final InsertionResult FAIL = new InsertionResult("fail");

    private Long id;

    protected InsertionResult(String result) {
        super(result);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
