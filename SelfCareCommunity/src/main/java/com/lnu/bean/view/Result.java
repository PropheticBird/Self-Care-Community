package com.lnu.bean.view;

/**
 * User: igor
 * Date: 12/6/13
 */
public class Result {

    public static final Result OK = new Result("ok");
    public static final Result FAIL = new Result("fail");

    private String result;

    private Result(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
