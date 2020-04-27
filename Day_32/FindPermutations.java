package coding_interview2;

import java.util.*;
public class AllPermutations {
	
	public static List<List<Integer>> allPermutations(int[] arr) {
		List<List<Integer>> result = new ArrayList<>();
		if(arr==null || arr.length==0)
			return result;
		Queue<List<Integer>> queue = new LinkedList<>();
		queue.add(new ArrayList<Integer>());
		for(int i=0;i<arr.length;i++) {
			int size = queue.size();
			for(int j=0;j<size;j++) {
				List<Integer> oldPerm = queue.poll();
				for(int k=0;k<=oldPerm.size();k++) {
					ArrayList<Integer> newPerm = new ArrayList<>(oldPerm);
					newPerm.add(k,arr[i]);
					if(newPerm.size()==arr.length)
						result.add(newPerm);
					else
						queue.add(newPerm);
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		List<List<Integer>> result = allPermutations(new int[] {1,3,5});
		System.out.println(result);

	}

}
