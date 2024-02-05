package leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfWaysToPartitionAnArray_2025 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int waysToPartition(int[] nums, int k) {
		int n = nums.length;
		int[] pre = new int[n];
		pre[0] = nums[0];
		for (int i = 1; i < n; i++)
			pre[i] = pre[i - 1] + nums[i];
		
		
		int[] suf = new int[n];
		suf[n - 1] = nums[n - 1];
		for (int i = n - 2; i >= 0; i--)
			suf[i] = suf[i + 1] + nums[i];
		
		
		int total = pre[n - 1], res = 0;
		if ((total & 1) == 0) {
			for (int i = 0; i < n - 1; i++)
				if (pre[i] == total / 2)
					res++;
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		int[] cnts = new int[n];
		for (int i = 0; i < n; i++) {
			int newTotal = total - nums[i] + k;
			if ((newTotal & 1) == 0)
				cnts[i] += map.getOrDefault(newTotal / 2, 0);
			map.put(pre[i], map.getOrDefault(pre[i], 0) + 1);
		}
		
		
		map = new HashMap<>();
		for (int i = n - 1; i >= 0; i--) {
			int newTotal = total - nums[i] + k;
			if ((newTotal & 1) == 0)
				cnts[i] += map.getOrDefault(newTotal / 2, 0);
			map.put(suf[i], map.getOrDefault(suf[i], 0) + 1);
		}
		
		for (int cnt : cnts)
			res = Math.max(res, cnt);
		return res;
	}
}
