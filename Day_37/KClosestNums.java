package com.sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class KClosestNums {
	
	public static List<Integer> findKClosest(int[] arr,int k,int x) {
		List<Integer> result = new ArrayList<>();
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i:arr) {
			map.put(i,Math.abs(x-i));
		}
		PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>((e1,e2)->e1.getValue()-e2.getValue());
		minHeap.addAll(map.entrySet());
		for(int i=0;i<k;i++) {
			Map.Entry<Integer, Integer> entry = minHeap.poll();
			result.add(entry.getKey());
		}
		Collections.sort(result);
		return result;
	}

	public static void main(String[] args) {
		System.out.println(findKClosest(new int[] {2,3,3,4,4,4,6,7,8,9},2,5));
		System.out.println(findKClosest(new int[] {5,6,7,8,9},3,7));
		System.out.println(findKClosest(new int[] {2,4,5,6,9},3,6));
		System.out.println(findKClosest(new int[] {2,4,5,6,9},3,10));
	}

}
