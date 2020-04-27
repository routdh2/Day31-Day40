package coding_interview2;
import java.util.*;
import java.util.Arrays;

public class SubsetsWIthDuplicates {
	
	public static List<List<Integer>> subsetsWithDups(int[] arr) {
		List<List<Integer>> result = new ArrayList<>();
		if(arr==null || arr.length==0)
			return result;
		Arrays.sort(arr);
		result.add(new ArrayList<Integer>());
		int size=0;
		for(int i=0;i<arr.length;i++) {
			int start=0;
			if(i>0 && arr[i]==arr[i-1])//tricky part
				start=size;
			size=result.size();
			for(int j=start;j<size;j++) {
				ArrayList<Integer> temp = new ArrayList<>(result.get(j));
				temp.add(arr[i]);
				result.add(temp);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		List<List<Integer>> result = subsetsWithDups(new int[] {1,5,3,3});
		System.out.println(result);

	}

}
