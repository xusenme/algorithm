package com.xusenme;


/**
 * 随意找数组中一个值key，将比key大的放右边，比key小的放左边；分为两个数组，再将这两个数组执行同样的操作···递归到数组只有1个元素为止
 * 这也是分治法.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {22,0, 7, 17, 3, 16, 13, 10, 1, 5, 7, 12, 4, 8, 9, 2};
        new QuickSort().quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    void quickSort(int[] a, int left, int right) {

        int l = left;
        int r = right;
        int key = a[l];

        while (l < r) {
            while (l < r && r >= left) {
                if (a[r] < key) {
                    a[l] = a[r];
                    l++;
                    break;
                }
                r--;
            }
            while (l < r && l <= right) {
                if (a[l] > key) {
                    a[r] = a[l];
                    r--;
                    break;
                }
                l++;
            }
        }
        a[l] = key;
        if (l - 1 > left) {
            quickSort(a, left, l-1);
        }
        if (right > l + 1) {
            quickSort(a, l + 1, right);
        }
    }
}
