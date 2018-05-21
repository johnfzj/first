package com.lanou.binarysearch;

public class MyMain {
	public static void main(String[] args) {
		int[] iArr = { 3, 23, 30, 35, 37, 42, 55, 62, 70, 75, 77, 90 };
		//int loc = binarySearch(iArr, 36);
		int low = 0;
		int hi = iArr.length - 1;   //int hi = iArr.length
		int loc = bSearch(iArr, 1,low,hi);
		// int loc = rank(iArr, 77);
		System.out.println(loc);
	}

	public static int rank(int nums[], int key) {
		// 查找范围的上下界
		int low = 0;
		int high = nums.length - 1;
		// 未查找到的返回值
		int notFind = -1;
		while (low <= high) {
			// 二分中点=数组左边界+(右边界-左边界)/2
			// 整数类型默认取下整
			int mid = low + (high - low) / 2;
			// 中间值是如果大于key
			if (nums[mid] > key) {
				// 证明key在[low,mid-1]这个区间
				// 因为num[mid]已经判断过了所以下界要减一
				high = mid - 1;
			} else if (nums[mid] < key) {
				// 证明key在[mid+1,high]这个区间
				// 同样判断过mid对应的值要从mid+1往后判断
				low = mid + 1;
			} else {
				// 查找成功
				return mid;
			}
		}
		// 未成功
		return notFind;
	}

	// //循环二分查找
	// private static int binarySearch(int[] iArray, int key) {
	// int start = 0;
	// int end = iArray.length - 1;
	// int mid;
	// while (end >= start) {
	// mid = (start + end) / 2;
	// if (iArray[mid] == key) {
	// return mid;
	// } else if (iArray[mid] < key) {
	// start = mid + 1;
	// } else {
	// end = mid - 1;
	// }
	// System.out.println(start + " " + end + " " + mid);
	// }
	// return -1;
	// }
	//
	// //递归二分查找
	// public static int bSearch(int[] array, int key, int lo, int hi) {
	// if (lo <= hi) {
	// int mid = (lo + hi) / 2;
	// if (key == array[mid]) {
	// return mid;
	// } else if (key > array[mid]) {
	// return bSearch(array, key, mid + 1, hi);
	// } else {
	// return bSearch(array, key, lo, mid - 1);
	// }
	// }
	// return -1;
	// }

	private static int binarySearch(int[] iArr, int key) {
		int loc = -1;
		int low = 0;
		int hi = iArr.length - 1;   //int hi = iArr.length
		int mid;
		while(low <= hi) {
			// 处理第一次 存在一个问题，奇数和偶数的第一次
			mid = (low + hi) / 2;
			if (iArr[mid] == key) {
				return mid;
				// 中间值比key大，key只可能在左边
			} else if (iArr[mid] > key) {
				hi = mid - 1;
			} else {
				low = mid + 1;
			}
			System.out.println(low + "  " + hi + "  " + mid);
		}
		return loc;
	}

	private static int bSearch(int[] iArr, int key,int low, int hi) {
//		int loc = -1;
		int mid;
		if(low <= hi) {
			mid = (low + hi) / 2;
			if (iArr[mid] == key) {
				return mid;
				// 中间值比key大，key只可能在左边
			} else if (iArr[mid] > key) {
				//hi = mid - 1;
				return bSearch(iArr,key,low,mid - 1);
			} else {
				//low = mid + 1;
				return bSearch(iArr,key,mid+1,hi);
			}
			//System.out.println(low + "  " + hi + "  " + mid);
		}
		return -1;
	}

	
}