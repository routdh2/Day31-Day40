package com.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ConnectRopes {
	
	public static int findMinCost(List<Integer> ropes) {
		if(ropes==null || ropes.size()==0)
			return 0;
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(ropes.size(),(n1,n2)->n1-n2);
		for(int i=0;i<ropes.size();i++) {
			minHeap.add(ropes.get(i));
		}
		int minCost=0;
		
		while(minHeap.size()>1) {
			int cost=minHeap.poll()+minHeap.poll();
			minHeap.add(cost);
			minCost+=cost;
		}
//		while(!minHeap.isEmpty()) {
//			int cost=minHeap.poll();
//			if(!minHeap.isEmpty())
//				cost+=minHeap.poll();
//			if(!minHeap.isEmpty())
//				minHeap.add(cost);
//			minCost+=cost;
//		}
		return minCost;
	}

	public static void main(String[] args) {
		List<Integer> ropes = new ArrayList<>(Arrays.asList(1,3,11,5));
		System.out.println(findMinCost(ropes));
		ropes = new ArrayList<>(Arrays.asList(3,4,5,6));
		System.out.println(findMinCost(ropes));
		ropes = new ArrayList<>(Arrays.asList(1,3,11,5,2));
		System.out.println(findMinCost(ropes));

	}

}
