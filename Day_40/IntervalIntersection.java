package com.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalIntersection {
	
	private static List<List<Integer>> findIntersection(int[][] arr1,int[][] arr2) {
		List<List<Integer>> result = new ArrayList<>();
		if(arr1==null || arr2==null)
			return result;
		for(int i=0,j=0;i<arr1.length && j<arr2.length;) {
			int start1=arr1[i][0];
			int end1=arr1[i][1];
			int start2=arr2[j][0];
			int end2=arr2[j][1];
			//check if two intervals overlap
			if((end1>=start2 && start1<=start2) || (end2>=start1 && start2<=start1)) {
				result.add(new ArrayList<Integer>(Arrays.asList(Math.max(start1, start2), Math.min(end1, end2))));
			}
			if(end1>end2) {
				j++;
			}
			else
				i++;
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] arr1=new int[][] {{1,3},{5,6},{7,9}};
		int[][] arr2=new int[][] {{2,3},{5,7}};
		System.out.println(findIntersection(arr1, arr2));

	}

}
