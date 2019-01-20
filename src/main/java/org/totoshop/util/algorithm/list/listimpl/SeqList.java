package org.totoshop.util.algorithm.list.listimpl;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import org.totoshop.service.impl.Status;
import org.totoshop.util.algorithm.list.List;

/**
 * @param
 */
public class SeqList implements List {
    private static SeqList SEQ_LIST_INSTANCE;

    /**
     * 順序表的初始化增量
     */
    private final int LIST_INIT_SIZE = 9;

    /**
     * 順序表的分配增量
     */
    private final int LIST_INCREMENT = 10;

    private Object[] seqList;

    /**
     * 順序表的元素個數 <=> 順序表的實際長度
     */
    private int length;

    /**
     * 順序表的分配長度大小
     */
    private int listSize;

    private SeqList() {}

    public static SeqList getInstance() {
        if (null == SEQ_LIST_INSTANCE) {
            SEQ_LIST_INSTANCE = new SeqList();
        }

        return SEQ_LIST_INSTANCE;
    }

    /**
     * 初始化順序表
     * @return Status
     */
    public Status init() {
        seqList = new Object[LIST_INIT_SIZE];
        if (null == seqList) {
            return Status.ERROR;
        }

        this.length = 0;
        this.listSize = LIST_INIT_SIZE;
        return Status.OK;
    }

    /**
     * 插入元素到順序表
     * @param location 插入元素的位置
     * @param data 插入元素的值
     * @return Status
     */
    public Status insert(int location, Object data) {
        if (location < 0 || location > listSize + 1) {
            return Status.ERROR;
        }

        if (this.length >= this.listSize) {
            this.seqList = realloc();
        }

        int index = location - 1;
        for (int i = this.length - 1; i >= index; i--) {
            this.seqList[i + 1] = this.seqList[i];
        }

        this.seqList[index] = data;
        this.length++;
        return Status.OK;
    }

    /**
     * 刪除元素
     * @return Status
     */
    public Status delete(int location, Object data) {
        return null;
    }


    /**
     * 銷毀順序表
     * @return Status
     */
    public Status destroy() {
        if (null != this.seqList) {
            this.seqList = null;
        }

        this.length = 0;
        this.listSize = LIST_INIT_SIZE;
        return Status.OK;
    }

    /**
     * @return newSeqList
     */
    private Object[] realloc() {
        int newListSize = this.listSize + LIST_INCREMENT;
        Object[] newSeqList = new Object[newListSize];

        for (int i = 0; i < this.listSize; i++) {
            newSeqList[i] = this.seqList[i];
        }

        this.listSize = newListSize;
        return newSeqList;
    }

    @Override
    public String toString() {
        if (null == this.seqList) {
            return null;
        }

        int MaxSize = this.length - 1;
        if (-1 == MaxSize) {
            return "{}";
        }

        StringBuilder string = new StringBuilder();
        string.append("{");
        for (int i = 0; ; i++) {
            string.append(seqList[i]);
            if (i == MaxSize) {
                return string.append("}").toString();
            }

            string.append(", ");
        }
    }

    @Override
    public void display() {
        String s = toString();
        System.out.printf("順序表：%s\n", s);
        System.out.printf("順序表的元素個數：%d\n", this.length);
        System.out.printf("順序表長度：%d\n", this.listSize);
    }
}