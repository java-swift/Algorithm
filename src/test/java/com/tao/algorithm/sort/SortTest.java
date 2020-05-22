package com.tao.algorithm.sort;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SortTest {

    private int[] arr = new int[1000];

    private int[] sarr = new int[1000];

    @BeforeEach
    void init() {
        for(int i = 0; i < 1000; i++) {

            int v = (int)(0+Math.random()*(1001));
            arr[i] = v;
            sarr[i] = v;
        }
    }

    @AfterEach
    void after() {
        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != sarr[i]) {
                flag = false;
                break;
            }
        }

        System.out.println("排序结果=" + flag);
    }
    @Test
    void testBubbleSort() {

        Sort.bubbleSort(arr);
        Arrays.sort(sarr);
    }

    @Test
    void testSelectSort() {
        Sort.selectSort(arr);
        Arrays.sort(sarr);
    }

    @Test
    void testInsertSort() {
        Sort.insertSort(arr);
        Arrays.sort(sarr);
    }
}
