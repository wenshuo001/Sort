package com.example.lib;

import java.util.Arrays;

/**
 * Created by  on 2018/10/29.
 */

public class InsertSort {

     public void insertionSort(int[] a,int n){
        if(n<=1) return;

        for (int i=1;i<n;++i){
            int value=a[i];
            int j=i - 1;
            //查找插入的位置
            for(;j>=0;--j){
                if(a[j]>value){
                    a[j+1] = a[j];
                }else {
                    break;
                }
            }
            a[j+1] =value; //插入数据
        }

     }
    public static void main(String[] args){
        int[] arr= new int[]{4,1,3};
        new InsertSort().insertionSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
