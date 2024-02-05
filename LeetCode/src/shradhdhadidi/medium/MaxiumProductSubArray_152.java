package shradhdhadidi.medium;

import amazon.easy.LeetCodeSolution;

public class MaxiumProductSubArray_152 implements LeetCodeSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public int[] solution(int[] nums) {
		int[] memo = new int[nums.length];

		memo[nums.length-1]=nums[nums.length-1];
		for (int i = nums.length - 2; i >= 0; i--) {

		}
		return memo;
	}

}
