package may_11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinaryTreeLevelOrderTraversal {
	
	static class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
	
	private static TreeNode createTree() {
		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		root.left = two;
		root.right = three;
		TreeNode four = new TreeNode(5);
		TreeNode five = new TreeNode(5);
		two.left = four;
		two.right = five;
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);
		three.left = six;
		three.right = seven;
		six.left = new TreeNode(8);
		return root;
	}
	
	private static List<List<Integer>> binaryTreeLevelOrder(TreeNode root) {
		//level order is BFS
		//so we will use queue
		List<List<Integer>> result = new ArrayList<>();
		if(root==null)
			return result;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			int size=queue.size();
			ArrayList<Integer> currLevelItems=new ArrayList<>();
			for(int i=0;i<size;i++) {
				TreeNode temp=queue.poll();
				
				currLevelItems.add(temp.val);
				if(temp.left!=null)
					queue.offer(temp.left);
				if(temp.right!=null)
					queue.offer(temp.right);
			}
			result.add(new ArrayList<Integer>(currLevelItems));
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = createTree();
		System.out.println(binaryTreeLevelOrder(root));

	}

}
