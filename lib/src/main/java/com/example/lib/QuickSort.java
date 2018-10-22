package com.example.lib;

import java.util.Arrays;

/**
 * Created 2018/10/16.
 */
/*快速排序*/
public class QuickSort {
    //递归结束条件：startIndex大于等于endIndex的时候
    public static void quickSort(int[] arr,int startIndex,int endIndex){
        if(startIndex>=endIndex){
            return;
        }
        int pivotIndex = partition(arr,startIndex,endIndex);
        quickSort(arr,startIndex,pivotIndex-1);
        quickSort(arr,pivotIndex+1,endIndex);
    }

    private static int partition(int[] arr,int startIndex,int endIndex){
        //取第一个位置的元素作为基准元素
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        //坑的位置，初始等于pivot的位置
        int index = startIndex;

        //大循环在左右指针重合或者交错时结束

        while(right >=left){
            //大循环在左右指针重合或者交错时结束
            while(right>=left){
                if(arr[right]<pivot){
                    arr[left]=arr[right];
                    index=right;
                    left++;
                    break;
                }
                right--;
            }
            while (right>=left){
                if(arr[left] >pivot){
                    arr[right]=arr[left];
                    index=left;
                    right--;
                    break;
                }
                left++;
            }
        }
        arr[index]=pivot;
        return index;
    }

    public static void main(String[] args){
        int[] arr= new int[]{4,7,6,5,3,2,8,1};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
