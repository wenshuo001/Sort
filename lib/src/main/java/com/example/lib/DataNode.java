package com.example.lib;

/**
 * Creator :Wen
 * DataTime: 2018/10/13
 * Description:
 */
public class DataNode {
    private int data;
    public DataNode next;
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public DataNode getNext() {
        return next;
    }
    public void setNext(DataNode next) {
        this.next = next;
    }
    public DataNode(int data) {
        this.data = data;
    }
}
