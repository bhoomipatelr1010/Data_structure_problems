package shradhdhadidi.medium;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring_3 {

	public static void main(String[] args) {
		LengthOfLongestSubstring_3 obj = new LengthOfLongestSubstring_3();
		int k = obj.lengthOfLongestSubstring("abcakabc");
		System.out.println(k);
	}

	public int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> map = new HashMap();
		int maxLength = 0;
		int start = 0;

		for (int i = 0; i < s.length(); i++) {
			char current = s.charAt(i);
			if (map.containsKey(current)) {
				start = Math.max(start, map.get(current) + 1);
			}
			map.put(current, i);
			maxLength = Math.max(maxLength, i - start + 1);
		}
		return maxLength;
	}
}
