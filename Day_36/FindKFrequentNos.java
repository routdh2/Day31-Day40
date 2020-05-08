package com.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class FindKFrequentNos {
	
	public static List<Integer> findKFrequentNos(List<Integer> arr, int k) {
		List<Integer> result = new ArrayList<>();
		if(arr==null || arr.size()==0)
			return result;
		PriorityQueue<Map.Entry<Integer,Integer>> maxHeap = new PriorityQueue<>((e1,e2)->e2.getValue()-e1.getValue());
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<arr.size();i++) {
			map.put(arr.get(i),map.getOrDefault(arr.get(i), 0)+1);
		}
		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			maxHeap.add(entry);
		}
		for(int i=0;i<k;i++) {
			Map.Entry<Integer, Integer> entry=maxHeap.poll();
			result.add(entry.getKey());
		}
		return result;
		
		
	}
	
	public static List<Integer> findKFrequentNosUsingMinHeap(List<Integer> arr,int k) {
		List<Integer> result = new ArrayList<>();
		if(arr==null || arr.size()==0)
			return result;
		HashMap<Integer,Integer> map=new HashMap<>();
		for(Integer i : arr) {
			map.put(i,map.getOrDefault(i, 0)+1);
		}
		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(k+1,(e1,e2)->e1.getValue()-e2.getValue());
		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			minHeap.add(entry);
			if(minHeap.size()>k) {
				minHeap.poll();
			}
		}
		for(int i=0;i<k;i++) {
			Map.Entry<Integer, Integer> entry=minHeap.poll();
			result.add(entry.getKey());
		}
		return result;
	}
	
	public static void main(String args[]) {
		List<Integer> arr = new ArrayList<>(Arrays.asList(8,2,4,9,3,4,3,6));
		System.out.println(findKFrequentNosUsingMinHeap(arr, 3));
		arr = new ArrayList<>(Arrays.asList(1,3,5,12,11,12,11));
		System.out.println(findKFrequentNosUsingMinHeap(arr, 2));
		arr = new ArrayList<>(Arrays.asList(5,12,11,3,11));
		System.out.println(findKFrequentNosUsingMinHeap(arr, 2));
	}

}
