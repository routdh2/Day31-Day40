package com.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosest {
	static class Point {
		int x,y;
		Point(int x,int y) {
			this.x=x;
			this.y=y;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
	}
	
	public static List<Point> findKClosest(List<Point> points, int k) {
		PriorityQueue<Point> maxHeap = new PriorityQueue<>(k,(p1,p2)->dist(p2)-dist(p1));
		//insert first k points
		for(int i=0;i<k;i++) {
			maxHeap.add(points.get(i));
		}
		//insert rest
		for(int i=k;i<points.size();i++) {
			if(dist(points.get(i))<dist(maxHeap.peek())) {
				maxHeap.poll();
				maxHeap.add(points.get(i));
			}
		}
		return new ArrayList<Point>(maxHeap);
	}
	
	private static int dist(Point ob) {
		return ob.x*ob.x+ob.y*ob.y;
	}

	public static void main(String[] args) {
		ArrayList<Point> points = new ArrayList<>();
		points.add(new Point(0,3));
		points.add(new Point(5,0));
		points.add(new Point(2,5));
		points.add(new Point(3,3));
		System.out.println(findKClosest(points, 2));

	}

}
