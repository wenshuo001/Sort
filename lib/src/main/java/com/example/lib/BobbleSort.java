package com.example.lib;

import java.util.Arrays;

/**
 * Creator :Wen
 * DataTime: 2019/1/12
 * 冒泡排序只会操作相邻的俩个数据，每次操作都会对相邻的俩个元素进行比较，
 * 看是否满足大小关系要求，满足就交换位置，不满足就不交换。
 */
public class BobbleSort {
    private void BobbleSort(int array[]){
        int temp = 0 ;
        int lastChangeIndex=0;
        int sortBorder = array.length - 1;
        for( int i = 0 ; i < array.length ; i++ ){
            boolean isSorted=true;
            for( int j = 0 ; j < sortBorder ; j++){ // j开始等于0
                if(array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    isSorted = false;//由元素交换，所以不是有序
                    lastChangeIndex = j;// 记录最后一次交换位置
                }
            }
            sortBorder=lastChangeIndex; //为了减少不必要重复比较
            if(isSorted){
                // 没有数据交换，提前退出
                break;
            }
        }
    }

    public static void main(String[] args){
        int[] arr= new int[]{4,1,3};
        new BobbleSort().BobbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
