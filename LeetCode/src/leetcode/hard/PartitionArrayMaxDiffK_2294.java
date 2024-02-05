package leetcode.hard;

import java.util.Arrays;

public class PartitionArrayMaxDiffK_2294 {

	public static void main(String[] args) {
		PartitionArrayMaxDiffK_2294 obj = new PartitionArrayMaxDiffK_2294();
		int[] nums = new int[] { 2, 2, 4, 5 };
		obj.partitionArray(nums, 0);

	}

	public int partitionArray(int[] A, int k) {
		Arrays.sort(A);
		int res = 1, mn = A[0], mx = A[0];
		for (int a : A) {
			mn = Math.min(mn, a);
			mx = Math.max(mx, a);
			if (mx - mn > k) {
				res++;
				mn = mx = a;
			}
		}
		System.out.println(res);
		return res;
	}

}
