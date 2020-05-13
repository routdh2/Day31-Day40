package may_13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Meeting {
	int start,end;
	Meeting(int start,int end) {
		this.start=start;
		this.end=end;
	}
}

public class MinimumMeetingRooms {
	
	private static int findMinimumMeetingRooms(List<Meeting> meetings) {
		if(meetings==null ||meetings.size()==0)
			return 0;
		//sort the meetings based on start time
		Collections.sort(meetings, new Comparator<Meeting>() {
			@Override
			public int compare(Meeting ob1,Meeting ob2) {
				return ob1.start-ob2.start;
			}
		});
		
		int count=0;
		PriorityQueue<Meeting> minHeap = new PriorityQueue<>(meetings.size(), (m1,m2)->m1.end-m2.end);
		for(Meeting meeting:meetings) {
			
			//remove meetings from minHeap which are ended
			while(!minHeap.isEmpty() && minHeap.peek().end<=meeting.start) {//if the current meeting doesn't overlap with minHeap peek element, then remove from minheap
				minHeap.poll();
			}
			//add current meeting to minHeap
			minHeap.add(meeting);
			//all active meetings will be on minHeap
			count=Math.max(count, minHeap.size());
		}
		return count;
	}
	
	public static void main(String args[]) {
		List<Meeting> meetings = new ArrayList<>();
		meetings.add(new Meeting(4,5));
		meetings.add(new Meeting(2,3));
		meetings.add(new Meeting(2,4));
		meetings.add(new Meeting(3,5));
		System.out.println(findMinimumMeetingRooms(meetings));
	}
}
