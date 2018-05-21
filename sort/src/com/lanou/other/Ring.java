package com.lanou.other;

import java.util.Arrays;

public class Ring {
	static final int  KILL_COUNT = 3;  //每到第3个活人，自杀
	public static void main(String[] args) {
		int iArr[] = {1,1,1,1,1,1,1,1,1,1};
		System.out.println("之前：" + Arrays.toString(iArr));
		ring(iArr,3);
		System.out.println("之后：" + Arrays.toString(iArr));
	}

	private static void ring(int[] iArray,int live) {
		//计数器
		int liveCount = iArray.length;  //活着的人数
		int count = 0;
		for (int i = 0; i < iArray.length; ) {
			//没有死才计数
			if(iArray[i] == 1) {
				count++;
				//一旦为3，自杀
				if(count >=KILL_COUNT ) {
					iArray[i] = 0;
					count =0;
					//自杀之后，判断如果活着的人与要求一致，退出
//					if(liveCount(iArray) == live) {
//						break;
//					}
					liveCount--;
					if(liveCount == live) {
						break;
					}
				}
			}
			//碰到的问题，到了结尾又要回来
			i++;
			if(i == iArray.length) {
				i = 0;
			}
		}
	}

	private static int liveCount(int[] iA) {
		int count = 0;
		for (int i = 0; i < iA.length; i++) {
			if(iA[i] == 1) {
				count++;
			}
		}
		return count;
	}
}