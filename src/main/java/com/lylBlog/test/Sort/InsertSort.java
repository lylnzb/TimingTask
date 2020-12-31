package com.lylBlog.test.Sort;

/**
 * @Author: lyl
 * @Date: 2020/12/19 11:32
 */
public class InsertSort {
    public static void main(String[] args){
        /* 插入排序算法功能实现1  start */
//        int[] arr = {32,43,12,39,54,13,42,56,77,41,76,45};
//        for(int i = 1;i<arr.length;i++){
//            int temp = arr[i];
//            int j = i;
//            while(j > 0 && temp < arr[j - 1]){
//                arr[j] = arr[j - 1];
//                j--;
//            }
//            arr[j] = temp;
//        }
//        for(int i = 0;i < arr.length;i++){
//            System.out.print(arr[i] + ",");
//        }
        /* 插入排序算法功能实现1  end */

        /* 插入排序算法功能实现2  start */
        int[] arr1 = {32,43,12,39,54,13,42,56,77,41,76,45,99};
        for(int i = 1;i<arr1.length;i++){
            int temp = arr1[i];
            int j = i - 1;
            while(j >= 0 && arr1[j] > temp){
                arr1[j + 1] = arr1[j];
                j = j - 1;
            }
            arr1[j + 1] = temp;
        }
        for(int i = 0;i < arr1.length;i++){
            System.out.print(arr1[i] + ",");
        }
        /* 插入排序算法功能实现2  end */
    }
}
