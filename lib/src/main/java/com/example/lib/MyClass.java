package com.example.lib;

public class MyClass {
    private  DataNode head;

    public MyClass(int size) {
        DataNode head = new DataNode(0);
        DataNode cur = head;
        for (int i = 1; i < size; i++) {
            DataNode tmp = new DataNode(i);
            cur.setNext(tmp);
            cur = tmp;
        }
        this.head = head;
    }

    public DataNode getHead() {
        return head;
    }

    public void setHead(DataNode head) {
        this.head = head;
    }
    //打印
    public void printChain(DataNode head) {
        StringBuilder sb = new StringBuilder();
        DataNode cur = head;
        sb.append(cur.getData());
        while (null != cur.getNext()) {
            sb.append(" -> ");
            sb.append(cur.getNext().getData());
            cur = cur.getNext();
        }
        System.out.println(sb.toString());
    }

    //递归实现单链表反转
    public  DataNode reverse1(DataNode head){
        if(null==head || null== head.getNext()){
            return head;
        }
        DataNode revhead=this.reverse1(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return revhead;
    }

//    public DataNode reverse2(){
//
//    }

    public static void main(String[] strings) {
        MyClass chain = new MyClass(10);

        chain.printChain(chain.getHead());
        DataNode dataNode=chain.reverse1(chain.getHead());
        chain.printChain(dataNode);

    }

}
