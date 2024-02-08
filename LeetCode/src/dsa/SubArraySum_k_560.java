package dsa;
import java.util.HashMap;

public class SubArraySum_k_560 {

	public static void main(String[] args) {
		int arr[] = { 1, 1, 1 };

		System.out.println(subarraySum(arr, 2));

	}

	public static int subarraySum(int[] nums, int k) {

		HashMap<Integer, Integer> map = new HashMap();
		map.put(0, 1);
		int sum = 0;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k))
				count += map.get(sum - k);
			map.put(sum, map.getOrDefault(sum, 0) + 1);

		}

		return count;

	}

}
