package may_13;

import java.util.Arrays;
import java.util.Comparator;

public class ConflictingAppointments {
	
	private static boolean canAttendAllAppointments(int[][] arr) {
		if(arr==null || arr.length==0)
			return true;
		//sort array based on start time
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] ob1,int[] ob2) {
				return ob1[0]-ob2[0];
			}
		});
		int start=arr[0][0];
		int end=arr[0][1];
		for(int i=1;i<arr.length;i++) {
			int nextStart=arr[i][0];
			int nextEnd=arr[i][1];
			//check if they overlap
			if(end>=nextStart) {
				return false;
			}
			else {
				start=nextStart;
				end=nextEnd;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] arr = new int[][] {{6,7},{2,4},{8,12}};
		System.out.println(canAttendAllAppointments(arr));

	}

}
