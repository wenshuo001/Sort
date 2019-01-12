package com.example.lib;

import java.util.Arrays;

/**
 *  插入算法的核心是把数据分为已排序区间和未排序区间
 *  取未排序区间的元素，到已排序区间中找到合适的位置插入
 *  并保证已排序区间数据一直有序，重复这个过程，直到未排序区间中的元素为空。
 *  算法结束
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
