package com.lanou.quicksort;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		//加了一些注释
		int[] arr = { 776, 2, 434, 54, 6, 65, 77, 767, 7,55,23 };
		System.out.println("Before:" + Arrays.toString(arr));
		sort(arr);
		System.out.println("After:" + Arrays.toString(arr));
	}

	// 思想： 取一个基准元素 ，大于基准元素的放在一个表
	// 小于基准元素放另外一个
	// 1. int flag=arr[0];
	// 2; 怎么划分
	/*
	 * arr 0,length-1 index= getIndex(); arr 0 index-1 index arr index+1,length-1
	 * arr,start ,end
	 */
	public static void sort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
		for (int i = 1; i < arr.length; i++) {
			int j;
			int target = arr[i];
			for (j = i; j > 0 && target < arr[j - 1]; j--) {
				arr[j] = arr[j - 1];
			}
			arr[j] = target;
		}
	}

	private static void quickSort(int[] arr, int start, int end) {
		if (end - start > 8) {
			int index = getIndex(arr, start, end);
			quickSort(arr, start, index - 1);
			quickSort(arr, index + 1, end);
		}
	}

	private static int getIndex(int[] arr, int start, int end) {
		int flag = arr[start];
		while (start < end) {
			while (start < end && arr[end] >= flag) {
				end--;
			}
			arr[start] = arr[end];
			// 空缺arr[end]:
			while (start < end && arr[start] <= flag) {
				start++;
			}
			arr[end] = arr[start];
		}
		arr[start] = flag;
		return start;
	}
}