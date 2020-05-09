class Solution {
    public boolean isPerfectSquare(int num) {
        if(num==0 || num==1)
            return true;
        long left=1,right=num/2+1;
        //Important: take long type to avoid integer overflow
        while(left<=right) {
            long mid=left+(right-left)/2;
            long sqr=mid*mid;
            System.out.println("left: "+left +" right: "+right+" mid: "+mid +" sqr: "+sqr);
            if(sqr==num)
                return true;
            else if(sqr>num)
                right=mid-1;
            else
                left=mid+1;
        }
        return false;
        
    }
}
