package com.sample;

public class FindDiameter {
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
	
	public static int diameter=0;
	public static int findDiameter(TreeNode root) {
		findHeight(root);
		return diameter;
	}
	
	private static int findHeight(TreeNode root) {
		if(root==null)
			return 0;
		//find height of left subtree of current Node
		int leftHeight=findHeight(root.left);
		//find height of right subtree of current Node
		int rightHeight=findHeight(root.right);
		//find the diameter of current Node
		int currDiameter=1+leftHeight+rightHeight;
		//update the global diameter
		diameter=Math.max(diameter, currDiameter);
		//return the height of current Node
		return 1+Math.max(leftHeight, rightHeight);
		
	}

	public static void main(String[] args) {
		TreeNode root = createTree();
		System.out.println(findDiameter(root));

	}

}
