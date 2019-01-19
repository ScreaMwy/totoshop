package org.totoshop.service.impl;

//enum（枚舉類）默認的構造函數是私有的
public enum Status {
    /**
     * 返回成功
     */
    OK(1, "成功"),

    /**
     * 返回失敗
     */
    ERROR(-1, "失敗");

    private int value;

    private String description;

    Status(int value, String description) {
        this.value = value;
        this.description = description;
    }
}
