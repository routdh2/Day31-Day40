package com.sample;

import java.util.ArrayList;
import java.util.List;

import com.sample.PathWithGivenSeq.TreeNode;

public class CountPathsForASum {
	
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
	private static int count=0;
	public static int countPathsforASum(TreeNode root, int sum) {
		findPaths(root,sum, new ArrayList<Integer>());
		return count;
	}
	
	private static void findPaths(TreeNode root, int sum, List<Integer> currPath) {
		if(root==null)
			return;
		currPath.add(root.val);
		//search for any path which results in sum
		//if it's a leaf
		if(root.left==null && root.right==null) {
			int pathSum=0;
			for(int i=currPath.size()-1;i>=0;i--) {
				pathSum+=currPath.get(i);
				if(pathSum==sum)
					count++;
			}
		}
		
		findPaths(root.left,sum,currPath);
		findPaths(root.right,sum,currPath);
		currPath.remove(currPath.size()-1);
	}

	public static void main(String[] args) {
		TreeNode root = createTree();
		System.out.println(countPathsforASum(root, 10));

	}

}
