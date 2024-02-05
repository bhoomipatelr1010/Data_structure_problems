package leetcode.hard;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LongestSubSringWithtwoDistinctChar_159 {

	public static void main(String[] args) {
		LongestSubSringWithtwoDistinctChar_159 obj = new LongestSubSringWithtwoDistinctChar_159();

		obj.lengthOfLongestSubstringTwoDistinct("a");
	}

	public int lengthOfLongestSubstringTwoDistinct(String s) {

		Map<Character, Integer> freMap = new HashMap<>();
		int maxLength = 0;
		int left = 0;
		
		for (int right = 0; right < s.length(); right++) {
			char c = s.charAt(right);
			freMap.put(c, freMap.getOrDefault(c, 0) + 1);
			while (freMap.size() > 2) {
				if (freMap.get(s.charAt(left)) == 1) {
					freMap.remove(s.charAt(left));
				} else {
					freMap.put(s.charAt(left), freMap.get(s.charAt(left)) - 1);
				}
				left++;
			}

			maxLength = Math.max(maxLength, right - left + 1);
		}
		System.out.println(maxLength);
		return maxLength;

	}
}
