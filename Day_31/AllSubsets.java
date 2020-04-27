package coding_interview2;
import java.util.*;
import java.util.ArrayList;

public class AllSubsets {
	//This is all contiguous subsets list. This runs in O(n2) time
	public static List<List<Integer>> allSubsets(int[] arr) {
		List<List<Integer>> result = new ArrayList<>();
		if(arr==null || arr.length==0)
			return result;
		result.add(new ArrayList<Integer>());
		for(int i=0;i<arr.length;i++) {
			ArrayList<Integer> temp = new ArrayList<>();
			for(int j=i;j<arr.length;j++) {
				temp.add(arr[j]);
				result.add(new ArrayList<Integer>(temp));
			}
		}
		System.out.println(result);
		return result;
	}
	//This lists all subsets of a set. This runs in O(2^n) time and space
	public static List<List<Integer>> allSubsetsUsing(int[] arr) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<Integer>());
		for(int i=0;i<arr.length;i++) {
			int size=result.size();
			for(int j=0;j<size;j++) {
				ArrayList<Integer> temp = new ArrayList<>(result.get(j));
				temp.add(arr[i]);
				result.add(temp);
			}
		}
		System.out.println(result);
		return result;
	}

	public static void main(String[] args) {
		List<List<Integer>> result = allSubsetsUsing(new int[] {1,5,3,8,9});

	}

}
