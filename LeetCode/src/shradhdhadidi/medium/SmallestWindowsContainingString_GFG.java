package shradhdhadidi.medium;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowsContainingString_GFG {

	public static void main(String[] args) {
		SmallestWindowsContainingString_GFG obj = new SmallestWindowsContainingString_GFG();
		System.out.println(obj.rightSolution("zoomlazapzo", "oza"));
	}

	public String mySolution(String s, String p) {
		int count = p.length();
		Map<Character, Integer> pMap = new HashMap();
		for (char cp : p.toCharArray()) {
			pMap.put(cp, pMap.getOrDefault(cp, 0) + 1);
		}

		int shortestLength = Integer.MAX_VALUE;

		int start = 0;
		int i = 0;
		int j = 0;
		while (j < s.length()) {

			if (pMap.containsKey(s.charAt(j))) {
				pMap.put(s.charAt(j), pMap.get(s.charAt(j)) - 1);
				if (pMap.get(s.charAt(j)) >= 0)
					count--;
			}
			if (count == 0) {

				while (count == 0) {

					int currentLength = j - i + 1;
					if (shortestLength > currentLength) {
						shortestLength = currentLength;
						start = i;
					}

					if (pMap.containsKey(s.charAt(i))) {
						pMap.put(s.charAt(i), pMap.get(s.charAt(i)) + 1);
						if (pMap.get(s.charAt(i)) > 0)
							count++;
					}

					i++;
				}
			}
			j++;
		}

		if (shortestLength != Integer.MAX_VALUE)
			return String.valueOf(s).substring(start, shortestLength + start);
		else
			return "-1";
	}

	public String rightSolution(String str, String p) {

		char[] s = str.toCharArray();
		char[] t = p.toCharArray();
		int m[] = new int[26];

		// Answer
		int ans = Integer.MAX_VALUE; // length of ans
		int start = 0; // starting index of ans
		int count = 0;
		// creating map
		for (int i = 0; i < t.length; i++) {
			if (m[t[i] - 'a'] == 0)
				count++;
			m[t[i] - 'a']++;
		}

		// References of Window
		int i = 0;
		int j = 0;

		// Traversing the window
		while (j < s.length) {

			// Calculations
			m[s[j] - 'a']--;

			if (m[s[j] - 'a'] == 0)
				count--;

			// Condition matching
			if (count == 0) {
				while (count == 0) {

					// Sorting ans
					if (ans > j - i + 1) {
						ans = Math.min(ans, j - i + 1);
						start = i;
					}

					// Sliding I
					// Calculation for removing I
					m[s[i] - 'a']++;
					if (m[s[i] - 'a'] > 0)
						count++;

					i++;
				}
			}
			j++;
		}

		if (ans != Integer.MAX_VALUE)
			return String.valueOf(s).substring(start, ans + start);
		else
			return "-1";

	}
}
