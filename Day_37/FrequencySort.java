package com.sample;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {
	
	public static String frequencySort(String str) {
		if(str==null || str.length()==0)
			return str;
		HashMap<Character,Integer> map = new HashMap<>();
		for(int i=0;i<str.length();i++) {
			char key=str.charAt(i);
			map.put(key, map.getOrDefault(key, 0)+1);
		}
		PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((e1,e2)->e2.getValue()-e1.getValue());
		//build the heap
//		for(Map.Entry<Character, Integer> entry:map.entrySet()) {
//			maxHeap.add(entry);
//		}
		maxHeap.addAll(map.entrySet());
		StringBuffer sb = new StringBuffer();
		while(!maxHeap.isEmpty()) {
			Map.Entry<Character, Integer> entry = maxHeap.poll();
			for(int i=0;i<entry.getValue();i++) {
				sb.append(entry.getKey());
			}
		}
		return sb.toString();
		
	}

	public static void main(String[] args) {
		System.out.println(frequencySort("dhananjay"));
		System.out.println(frequencySort("Programming"));
		System.out.println(frequencySort("abcbab"));

	}

}
