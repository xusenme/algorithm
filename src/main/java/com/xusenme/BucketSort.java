package com.xusenme;

/**
 * 桶排序，思想比较简单，用于排序[0,1)范围内的数，时间复杂度为n
 * 将[0,0.1)的数放在 新数组的0号位的链表
 * 将[0.1,0.2)的数放在 新数组的1号位的链表
 * ···
 * 保证各个链表内的数据是有序的
 * 然后串起来就是最后排序的结果
 */
public class BucketSort {

    public static void main(String[] args) {
        double[] arr = {0.78, 0.17, 0.39, 0.26, 0.72, 0.94, 0.21, 0.12, 0.23, 0.68};
        new BucketSort().bucketSort(arr);
        for (double i : arr) {
            System.out.println(i);
        }
    }

    public void bucketSort(double[] arr) {
        int n = arr.length;
        Node[] b = new Node[10];

        for (int i = 0; i < b.length; i++) {
            b[i] = new Node(-1.0);
        }

        for (int i = 0; i < n; i++) {
            int index = (int)arr[i]*10;
            Node node = b[index];
            while (node.next != null && node.next.value < arr[i]) {
                node = node.next;
            }
            Node temp = node.next;
            node.next = new Node(arr[i]);
            node = node.next;
            node.next = temp;
        }
        int index = 0;
        for (int i = 0; i < 10; i++) {
            Node node = b[i];
            while ((node = node.next) != null) {
                arr[index++] = node.value;
            }
        }
    }



    class Node {
        double value;
        Node next;

        public Node(double value) {
            this.value = value;
        }
    }
}
