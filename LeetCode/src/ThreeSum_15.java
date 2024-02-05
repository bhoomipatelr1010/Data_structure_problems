import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {

	public static void main(String[] args) {
		int arr[] = { -2, 0, 0, 2, 2 };

		System.out.println(threeSum(arr));

	}

	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length;

		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < n; i++) {

			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int j = i + 1;
			int k = n - 1;
			while (j < k) {

				int sum = nums[i] + nums[j] + nums[k];
				if (sum == 0) {
					List<Integer> newTriplets = new ArrayList<>();
					newTriplets.add(nums[i]);
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
				} else if (sum < 0) {

					j++;
				} else {

					k--;
				}

			}
		}

		return res;
	}

}
