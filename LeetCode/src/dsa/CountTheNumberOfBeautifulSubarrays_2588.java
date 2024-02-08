package dsa;
import java.util.HashMap;

public class CountTheNumberOfBeautifulSubarrays_2588 {

	public static void main(String[] args) {
		int arr[] = { 4, 3, 1, 2, 4 };

		System.out.println(beautifulSubarrays(arr));
	}

	public static long beautifulSubarrays(int[] nums) {

		HashMap<Long, Long> map = new HashMap();
		map.put(0l, 1l);
		long sum = 0l;
		long count = 0l;
		for (int i = 0; i < nums.length; i++) {
			sum ^= nums[i];
			if (map.containsKey(sum))
				count += map.get(sum);
			map.put(sum, map.getOrDefault(sum, 0l) + 1);

		}

		return count;
	}
}
