package com.sistem.pakar;

public class Condition {
    private String code;
    private String description;

    public Condition(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
