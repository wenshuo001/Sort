package com.example.lib;

import java.util.Arrays;

/**
 * Creator :Wen
 * DataTime: 2018/10/14
 * Description:
 */
public class ArrayStack {
    private String[] items;//数组
    private int count;//栈中元素个数
    private int n; //栈的大小

    //构造方法，定义数组大小
    public ArrayStack(int capacity){
        this.items=new String[capacity];
        this.n=capacity;
        this.count=0;//因为还没开始存 所以是0
    }

    //根据索引找值
    public String find(int index){
        if(index<0 || index>=count) return "溢出";
        return items[index];
    }

    //根据索引删除
    public String[] delect(int index){
        if (index<0 || index >=count) return null;
        //从删除位置开始，将后面的元素向前移动一位
        for(int i=index+1;i<count;++i){
            items[i-1]=items[i];
        }
        --count;

        String[] arrNew = new String[items.length - 1];
         for (int a=0;a<items.length-1;a++){
             arrNew[a]=items[a];
         }
        return arrNew;
    }
    //根据索引插入
    public boolean insert(int index,String value){
        if (index<0 || index >=count) return false;//索引不能小于0 大于等于当前元素个数 那会越界
        //当实际存储的个数等于数组的最大长度就不让新增
        if (count == n) return false;
        for(int i=index-1;i>=index;--i){
            items[i+1]=items[i];
        }
        items[index] = value;
        ++count;
        return true;
    }



    public boolean insertToTail(int value) {

        //当实际存储的个数等于数组的最大长度就不让新增
        if (count == n) return false;

        items[count++] = value+"";
        return true;
    }
    public static void main(String[] strings) {
        ArrayStack stack=new ArrayStack(10);
        for (int i=0;i<10;i++){
            stack.insertToTail(i);
        }
        System.out.println(Arrays.toString(stack.items));
        System.out.println(Arrays.toString(stack.delect(2)));

    }
}
