package com.tao.algorithm.sort;

public class Sort {


    /**
     * 冒泡排序，先排最大的
     * 从头开始，相邻的元素两两比较，如果前一个比后一个大，交换位置
     * "趟"指的是第二层循环
     * 第一趟排序后数组中最大的元素移到最后
     * 第二趟排序后数组中剩余最大的元素移动到倒数第二个位置
     * 依次类推
     *
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     * @param arr
     */
    public static void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                swap(arr, j);
            }
        }
    }

    private static void swap(int[] arr, int j){

        if (arr[j] > arr[j + 1]) {
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
        }
    }

    /**
     * 选择排序，先排最小的
     * 从第一个元素开始，找出整个数组中最小的元素，并跟已经排好序的最大元素交换位置
     * "趟"指的是第二层循环
     * 第一趟选出整个数组中最小的元素，放到索引为0的位置
     * 第二趟选出剩余数组中最小的元素，放到索引为1的位置
     * 依次类推
     *
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     * @param arr
     */
    public static void selectSort(int[] arr){

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    /**
     * 插入排序 认为在一组有序的数字中排序，类似打扑克，每摸到一张插到指定位置
     * 从第一个元素开始，认为该元素已经排好序
     * 取出下一个元素，以该元素为起点，依次从后向前扫描，取出每一个元素与当前元素比较
     * 如果该元素比当前取出的元素大，那么后移，直到找到比当前取出的元素小或者相等的元素，插入到该元素后面
     * 依次类推
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     * @param arr
     */
    public static void insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int preIndex = i - 1;
            int current = arr[i];
            while (preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
    }
    public static void main(String[] args) {
        int[] arr = {12,21,15,17,8,22,13};
        selectSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
