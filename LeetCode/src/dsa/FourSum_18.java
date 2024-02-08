package dsa;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_18 {

	public static void main(String[] args) {
		int arr[] = { 1000000000, 1000000000, 1000000000, 1000000000 };

		System.out.println(fourSum(arr, -294967296));
	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {

		Arrays.sort(nums);
		int n = nums.length;
		List<List<Integer>> res = new ArrayList<>();

		for (int i = 0; i < n; i++) {

			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for (int m = i + 1; m < n; m++) {
				if (m - 1 > i && nums[m] == nums[m - 1]) {
					continue;
				}
				int j = m + 1;
				int k = n - 1;
				while (j < k) {

					long sum = nums[i] + nums[m] ;
					sum+=nums[j];
					sum+=nums[k];
					if (sum == target) {
						List<Integer> newTriplets = new ArrayList<>();
						newTriplets.add(nums[i]);

						newTriplets.add(nums[m]);
						newTriplets.add(nums[j]);
						newTriplets.add(nums[k]);
						res.add(newTriplets);

						j++;
						k--;

						while (j < k && nums[j] == nums[j - 1]) {
							j++;
						}

						while (k > j && nums[k] == nums[k + 1]) {
							k--;
						}
					} else if (sum < target) {

						j++;
					} else {

						k--;
					}

				}

			}
		}
		return res;
	}

}
