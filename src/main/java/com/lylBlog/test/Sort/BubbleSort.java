package com.lylBlog.test.Sort;

/**
 * @Author: lyl
 * @Date: 2020/12/19 11:34
 */
public class BubbleSort {
    public static void main(String[] args){
        /* 冒泡排序算法功能实现1  start */
        /*
         * i =  0 arr2.length = 13;j = 13 -  0 - 1 = 12
         * i =  1 arr2.length = 13;j = 13 -  1 - 1 = 11
         * i =  2 arr2.length = 13;j = 13 -  2 - 1 = 10
         * ...
         * i = 12 arr2.length = 13;j = 13 - 12 - 1 = 0
         * */
        int[] arr2 = {32,43,12,39,54,13,42,56,77,41,76,45,99};
        for(int i = 0;i < arr2.length - 1;i++){
            for(int j = 0;j < arr2.length - i - 1;j++){
                if(arr2[j] > arr2[j + 1]){
                    int temp = arr2[j + 1];
                    arr2[j + 1] = arr2[j];
                    arr2[j] = temp;
                }
            }
            for(int y = 0;y < arr2.length;y++){
                System.out.print(arr2[y] + ",");
            }
            System.out.println("");
        }
        for(int i = 0;i < arr2.length;i++){
            System.out.print(arr2[i] + ",");
        }
        /* 冒泡排序算法功能实现1  end */
    }
}
