package may_13;

import java.util.Arrays;
import java.util.Comparator;

public class FindAllConflictingAppointments {
	
	private static void findAllConflictingAppointments(int[][] arr) {
		if(arr==null || arr.length==0) {
			System.out.println("No appointments provided.");
			return;
		}
		//sort the array based on start time
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] ob1,int[] ob2) {
				return ob1[0]-ob2[0];
			}
		});
		
		int start=arr[0][0];
		int end=arr[0][1];
		boolean hasConflict=false;
		for(int i=1;i<arr.length;i++) {
			int nextStart=arr[i][0];
			int nextEnd=arr[i][1];
			if(end>nextStart) {
				hasConflict=true;
				//overlapping condition
				System.out.println("["+start+","+end+"] and ["+nextStart+","+nextEnd+"] have conflicts.");
				end=Math.max(end, nextEnd);
			}
			else {
				start=nextStart;
				end=nextEnd;
			}
		}
		if(!hasConflict) {
			System.out.println("There are no conflicting appointments.");
		}
		
			
	}

	public static void main(String[] args) {
		int[][] arr=new int[][] {{4,5},{2,3},{3,6},{5,7},{7,8}};
		findAllConflictingAppointments(arr);

	}

}
