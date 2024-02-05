package shradhdhadidi.medium;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LongestRepeatingCharacter_424 {

	public static void main(String[] args) {
		LongestRepeatingCharacter_424 obj = new LongestRepeatingCharacter_424();
		System.out.println(obj.characterReplacement("AABAAAABBA", 2));

	}

	public int characterReplacement2(String s, int k) {
		Map<Character, Integer> freqMap = new HashMap<>();
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
			max = Math.max(max, freqMap.get(c));
		}

		if (max + k > s.length()) {
			return s.length();
		} else {
			return max + k;
		}
	}

	public int characterReplacement123(String s, int k) {

		int maxLength = 0;
		int left = 0;
		int right = 1;
		int decrement = k;

		while (left < right && right < s.length()) {

			if (s.charAt(left) == s.charAt(right)) {
				maxLength = Math.max(maxLength, right - left + 1);

				right++;
			} else if (decrement > 0) {
				maxLength = Math.max(maxLength, right - left + 1);

				decrement--;
				right++;
			} else {

				left = left + 1;
				right = left + 1;
				decrement = k;
			}

		}
		return maxLength;

	}

	public int characterReplacement(String s, int k) {
		// binary search over the length of substring
		// lo contains the valid value, and hi contains the
		// invalid value
		int lo = 1;
		int hi = s.length() + 1;

		while (lo + 1 < hi) {
			int mid = lo + (hi - lo) / 2;

			// can we make a valid substring of length `mid`?
			if (canMakeValidSubstring(s, mid, k)) {
				// explore the right half
				lo = mid;
			} else {
				// explore the left half
				hi = mid;
			}
		}

		// length of the longest substring that satisfies
		// the given condition
		return lo;
	}

	private Boolean canMakeValidSubstring(String s, int substringLength, int k) {
		// take a window of length `substringLength` on the given
		// string, and move it from left to right. If this window
		// satisfies the condition of a valid string, then we return
		// true

		int[] freqMap = new int[26];
		int maxFrequency = 0;
		int start = 0;
		for (int end = 0; end < s.length(); end += 1) {
			freqMap[s.charAt(end) - 'A'] += 1;

			// if the window [start, end] exceeds substringLength
			// then move the start pointer one step toward right
			if (end + 1 - start > substringLength) {
				// before moving the pointer toward right, decrease
				// the frequency of the corresponding character
				freqMap[s.charAt(start) - 'A'] -= 1;
				start += 1;
			}

			// record the maximum frequency seen so far
			maxFrequency = Math.max(maxFrequency, freqMap[s.charAt(end) - 'A']);
			if (substringLength - maxFrequency <= k) {
				return true;
			}
		}

		// we didn't a valid substring of the given size
		return false;
	}
}
