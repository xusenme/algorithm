package com.xusenme;

/**
 * 计数排序，适用于大小在一定范围的正整数排序，并且参加排序的数中最大值不是特别大，时间为线性的即n
 * 思路：用临时数组的下标记录该数值在数组中排在多少位
 * 排序的时候就能直接定位该数在哪个位置。
 */
public class CountSort {

    public static void main(String[] args) {
        int[] arr = {0, 2,7, 17, 3, 16, 13, 10, 1, 5, 7, 12, 4, 8, 9, 2};
        int[] result = new CountSort().countSort(arr, 20);
        for (int i : result) {
            System.out.println(i);
        }
    }

    int[] countSort(int[] arr,int k) {
        int[] b = new int[arr.length];//用于临时存放排序结果的数组
        int[] c = new int[k + 1];//计数的数组
        for (int i = 0; i < arr.length; i++) {
            c[arr[i]]++;
        }
        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }
        for (int i = 0; i < arr.length; i++) {
            b[c[arr[i]]-1] = arr[i];
            c[arr[i]]--;
        }
        return b;
    }
}
