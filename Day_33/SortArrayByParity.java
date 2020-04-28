//Problem Statement: https://leetcode.com/explore/featured/card/fun-with-arrays/511/in-place-operations/3260/
class Solution {
    //TC: O(n) SC:O(1)
    public int[] sortArrayByParity(int[] A) {
        
        int left=0,right=A.length-1;
        while(left<right) {
            while(left<A.length && A[left]%2==0)
                left++;
            while(right>=0 && A[right]%2==1)
                right--;
            if(left!=right && left<right) {
                swap(A,left,right);
                left++;
                right--;
            }
        }
        return A;
        
    }
    
    private void swap(int[] A,int i,int j) {
        int temp=A[i];
        A[i]=A[j];
        A[j]=temp;
    }
}
