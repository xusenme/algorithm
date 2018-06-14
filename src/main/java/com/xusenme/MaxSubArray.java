package com.xusenme;

/**
 * 分治法求最大子数组问题 时间复杂度为nlgn
 * 思路：将大数组用分为多个小数组，分别计算小数组的最大子数组
 * 将为题分解:找到中点左边最大子数组，跨过中点的最大子数组，中点右边最大子数组，再比较哪个更大，哪个就是结果。
 * 对左和右两边找最大子数组就相还是原来的问题，但是范围边小了，递归很容易办到。
 * 对跨过中点的最大子数组查找就是解决问题的关键，跨过中点，那么，只需要从中点向左边查找，只要有小于0的和到最小下标，就结束，那么这样就能找到跨过中点的最大子数组的左边部分，同理找右边部分，相加，就是结果。
 *
 *
 * 中间只需普通的遍历一次就能找出
 * 左右两边会不断递归，最后递归到长度为1的数组，为递归结束条件
 *
 *
 * 虽然这不是速度最快的解决问题的方法，看起来还有点绕，但是，这是一种解决此类算法问题的一种思想，
 * 快排也是同样的思想，解决问题思路清晰，将大问题分解为范围不断缩小的小问题。
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] a = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        int[] result = findMaxSubArray(a, 0, a.length - 1);
        System.out.println("最大子数组'开始'下标为：" + result[0]);
        System.out.println("最大子数组'结束'下标为：" + result[1]);
        System.out.println("最大子数组和为：" + result[2]);
    }


    /**
     * 求最大子数组
     * @param a 被求数组
     * @param low 最小下标
     * @param high 最大下标
     * @return
     * 返回值定义：int[0]为最大和子数组的“开始”坐标
     * 返回值定义：int[0]为最大和子数组的“结束”坐标
     * 返回值定义：int[0]为最大和子数组的和
     */
    public static int[] findMaxSubArray(int[] a, int low, int high) {
        int[] result = new int[3];
        if (high == low) {
            result[0] = low;
            result[1] = high;
            result[2] = a[low];
            return result;
        } else {
            int mid = (low + high)/2;
            int[] leftMax = findMaxSubArray(a, low, mid);
            int[] rightMax = findMaxSubArray(a, mid + 1, high);
            int[] crossMax = findMaxCrossingSubArray(a, low, mid, high);
            if (leftMax[2] >= rightMax[2] && leftMax[2] >= crossMax[2]) {
                return leftMax;
            } else if (rightMax[2] >= leftMax[2] && rightMax[2] >= crossMax[2]) {
                return rightMax;
            } else {
                return crossMax;
            }
        }


    }

    /**
     * 求跨越中点的最大子数组
     * @param a 需要寻找跨越中点最大子数组和数组
     * @param low 最小下标
     * @param mid  中点下标
     * @param high 最大下标
     * @return
     * 返回值定义：int[0]为跨越中点最大和子数组的“开始”坐标
     * 返回值定义：int[1]为跨越中点最大和子数组的“结束”坐标
     * 返回值定义：int[2]为跨越中点最大和子数组的和
     */

    public static int[] findMaxCrossingSubArray(int[] a, int low, int mid, int high) {
        int maxLeftIndex = mid;
        int maxRightIndex = mid;
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= low; i--) {
            sum += a[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeftIndex = i;
            }
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= high; i++) {
            sum += a[i];
            if (sum > rightSum) {
                rightSum = sum;
                maxRightIndex = i;
            }
        }
        int[] result = {maxLeftIndex, maxRightIndex, leftSum + rightSum};
        return result;
    }


}
