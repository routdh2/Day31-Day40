package com.sample;

public class PathWithMaximumSum {
	
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
	
	private static int maxSum;
	private static int pathWithMaximumSum(TreeNode root) {
		maxSum=Integer.MIN_VALUE;
		findPath(root);
		return maxSum;
	}
	
	private static int findPath(TreeNode root) {
		if(root==null)
			return 0;
		int leftSum=findPath(root.left);
		int rightSum=findPath(root.right);
		
		int currSum=leftSum+rightSum+root.val;
		maxSum=Math.max(currSum, maxSum);
		
		return Math.max(leftSum, rightSum)+root.val;
	}
	public static void main(String[] args) {
		TreeNode root = createTree();
		System.out.println(pathWithMaximumSum(root));

	}

}
