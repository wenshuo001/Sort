package com.example.lib;

import java.util.Arrays;

/**
 * Creator :Wen
 * DataTime: 2018/11/4
 * Description:斐波那契数列，这个数列从第三项开始，每一项都等于前俩项之和
 */
public class index {

    public static void main(String[] args){
     int b= new index().f(5);
        System.out.println(b);
    }

    int f(int n){
        if (n==1) return 1;
        if (n==2) return 2;
        int ret = 0;
        int pre = 2;
        int prepre = 1;
        for (int i =3 ;i <= n; ++i){
            ret=pre + prepre;
            prepre=pre;
            pre=ret;
        }
        return ret;
    }
}
