package com.xusenme;

/**
 * 用数组构建最大堆，然后将堆顶的值（最大值）和堆尾部元素互换，并将堆末尾坐标-1，即排除已找到最大的值;再次构建最大堆···重复操作直到堆只有一个元素
 */
public class HeapSort {

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] arr = {0, 7, 17, 3, 16, 13, 10, 1, 5, 7, 12, 4, 8, 9, 2};
        heapSort.heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    void heapSort(int[] a) {
        buildMaxHeap(a);
        int heapSize = a.length - 1;
        for (int i = a.length - 1; i >= 2; i--) {
            int temp = a[1];
            a[1] = a[i];
            a[i] = temp;
            heapSize--;
            maxHeapify(a, 1, heapSize);
        }
    }

    void buildMaxHeap(int[] a) {
        int heapSize = a.length - 1;
        for (int i = a.length / 2; i >= 1; i--) {
            maxHeapify(a, i,heapSize);
        }
    }

    void maxHeapify(int[] a,int i,int heapSize) {
        int l = left(i);
        int r = right(i);
        int largest = 0;
        if (l <= heapSize && a[l] > a[i]) {
            largest = l;
        } else {
            largest = i;
        }
        if (r <= heapSize && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            maxHeapify(a, largest,heapSize);
        }
    }


    int parent(int i) {
        return i / 2;
    }

    int left(int i) {
        return 2 * i;
    }

    int right(int i) {
        return 2 * i + 1;
    }
}
