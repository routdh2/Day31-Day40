package may_13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Job {
	int start,end,cpuLoad;
	Job(int start,int end,int cpuLoad) {
		this.start=start;
		this.end=end;
		this.cpuLoad=cpuLoad;
	}
}
public class MaximumCPULoad {
	
	private static int findMaxCpuLoad(List<Job> jobs) {
		if(jobs==null ||jobs.size()==0)
			return 0;
		//sort the jobs based on start time
		Collections.sort(jobs, new Comparator<Job>() {
			@Override
			public int compare(Job ob1,Job ob2) {
				return ob1.start-ob2.start;
			}
		});
		PriorityQueue<Job> minHeap = new PriorityQueue<>((job1,job2)->job1.end-job2.end);
		int maxCpuLoad=Integer.MIN_VALUE;
		int cpuLoad=0;
		for(Job currentJob:jobs) {
			
			while(!minHeap.isEmpty() && currentJob.start>=minHeap.peek().end) {
				cpuLoad-=minHeap.peek().cpuLoad;
				minHeap.poll();
			}
			
			minHeap.add(currentJob);
			cpuLoad+=currentJob.cpuLoad;
			maxCpuLoad=Math.max(cpuLoad, maxCpuLoad);
		}
		return maxCpuLoad;
	}
	public static void main(String[] args) {
		List<Job> jobs = new ArrayList<>();
		jobs.add(new Job(1,4,2));
		jobs.add(new Job(2,4,1));
		jobs.add(new Job(3,6,5));
		System.out.println(findMaxCpuLoad(jobs));
		
	}

}
