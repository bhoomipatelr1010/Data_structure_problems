package dsa.contest.contest_124_biweekly;

public class MaximumNumberOfOp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int maxOperations(int[] nums) {
        
	       
        int n=nums.length;
      
       
        int res=1;

        int i=3;
        while(i<n){
            if((nums[i]+nums[i-1])!=(nums[i-2]+nums[i-3])){
             break;   
            }
            res+=1;
            i=i+2;
        }
       
     return res;   
    }
}
