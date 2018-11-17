package com.example.lib;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Creator :Wen
 * DataTime: 2018/11/17
 * Description:LRU缓存回收算法
 */
public class LruCache {

    private Node head;
    private Node end;
    //缓存存储上限
    private int limit;
    private HashMap<String,Node> hashMap;

    public LruCache(int limit) {
        this.limit = limit;
        hashMap =new LinkedHashMap<>();
    }

    public String get(String key){
        Node node=hashMap.get(key);
        if(node==null){
            return null;
        }

        return node.value;
    }

    public void put(String key,String value){
         Node node = hashMap.get(key);
         if(node==null){
            //如果key不存在 则插入key value
             if (hashMap.size()>=limit){
                    String oldkey= removeNode(head);
                    hashMap.remove(oldkey);
             }
             node= new Node(key,value);
             addNode(node);
             hashMap.put(key,node);
         }else {
             //如果key存在 刷新key-value
             node.value =value;
             refreshNode(node);
         }
    }

    public void remove(String key){
        Node node = hashMap.get(key);
        removeNode(node);
        hashMap.remove(key);
    }

    private void refreshNode(Node node){
        //如果访问的是尾结点,无需移动结点
        if (node==end){
            return;
        }
        //移除节点
        removeNode(node);
        //重新插入节点
        addNode(node);
    }

    /**
     * 删除结点
     */
    private String removeNode(Node node){
        if (node==null){
            //移除尾结点
            end = end.pre;
        }else if(node == head){
            //移除头结点
            head = head.next;
        }else {
            //移除中间结点
            node.pre.next= node.next;
            node.next.pre = node.pre;
        }
        return node.key;
    }

    /**
     * 尾部插入结点
     */
    public void addNode(Node node){
        if(end!=null){
            end.next = node;
            node.pre = end;
            node.next = null;
        }
        end=node;
        if (head==null) {
            head=node;
        }
    }

    class Node{
        public Node(String key,String value) {
            this.key=key;
            this.value=value;
        }
        private Node next;
        private Node pre;
        private String key;
        private String value;
    }

    public static void main(String[] args){
         LruCache lruCache=new LruCache(5);
         lruCache.put("001","001的信息");
         lruCache.put("002","002的信息");
         lruCache.put("003","003的信息");
         lruCache.put("004","004的信息");
         lruCache.put("005","005的信息");
         lruCache.get("002");
         lruCache.put("004", "用户2信息更新");
         lruCache.put("006", "用户6信息");
        System.out.println(lruCache.get("001"));
        System.out.println(lruCache.get("006"));
    }
}
