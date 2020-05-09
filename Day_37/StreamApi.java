package com.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class StreamApi {
	private List<Integer> stream;
	private int k;
	private PriorityQueue<Integer> minHeap;
	public StreamApi(int[] arr,int k) {
		stream=new ArrayList<Integer>();
		for(int i=0;i<arr.length;i++) {
			stream.add(arr[i]);
		}
		this.k=k;
		minHeap=new PriorityQueue<Integer>(k+1,(n1,n2)->n1-n2);
		buildHeap(arr);
	}
	public int add(int num) {
		stream.add(num);
		insertToHeap(num);
		return getKthLargestNum();
	}
	
	private void buildHeap(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			insertToHeap(arr[i]);
		}
	}
	private void insertToHeap(int num) {
		minHeap.add(num);
		if(minHeap.size()>k)
			minHeap.poll();
	}
	private int getKthLargestNum() {
		return minHeap.peek();
	}
}

public class StreamApiTest {

	public static void main(String[] args) {
		StreamApi streamObj = new StreamApi(new int[] {3,1,5,12,2,11}, 4);
		System.out.println(streamObj.add(6));
		System.out.println(streamObj.add(13));
		System.out.println(streamObj.add(4));
	}

}
