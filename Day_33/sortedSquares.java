
//Problem Statement: https://leetcode.com/explore/featured/card/fun-with-arrays/511/in-place-operations/3261/
class Solution {
    //TC: O(n) SC:O(n)
    public int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];
        int index=A.length-1;
        for(int i=0,j=A.length-1;i<=j;) {
            int leftSq=A[i]*A[i];
            int rightSq=A[j]*A[j];
            if(leftSq>rightSq) {
                result[index]=leftSq;
                i++;
            }
            else {
                result[index]=rightSq;
                j--;
            }
            index--;
        }
        return result;
    }
}
