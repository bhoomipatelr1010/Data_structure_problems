package leetcode.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ReArrangeStringKDistanceApart_358 {

	public static void main(String[] args) {
		ReArrangeStringKDistanceApart_358 obj = new ReArrangeStringKDistanceApart_358();
		System.out.println("bhoomi " + obj.rearrangeString("aaaabbccdegh", 3));
	}

	public String rearrangeString1(String s, int k) {
		Map<Character, Integer> freqs = new HashMap<>();
		int maxFreq = 0;
		// Store the frequency, and find the highest frequency.
		for (char c : s.toCharArray()) {
			freqs.put(c, freqs.getOrDefault(c, 0) + 1);
			maxFreq = Math.max(maxFreq, freqs.get(c));
		}

		Set<Character> mostChars = new HashSet<>();
		Set<Character> secondChars = new HashSet<>();
		// Store all the characters with the highest and second-highest frequency - 1.
		for (char c : freqs.keySet()) {
			if (freqs.get(c) == maxFreq) {
				mostChars.add(c);
			} else if (freqs.get(c) == maxFreq - 1) {
				secondChars.add(c);
			}
		}

		// Create maxFreq number of different strings.
		StringBuilder[] segments = new StringBuilder[maxFreq];
		// Insert one instance of characters with frequency maxFreq & maxFreq - 1 in
		// each segment.
		for (int i = 0; i < maxFreq; i++) {
			segments[i] = new StringBuilder();

			for (char c : mostChars) {
				segments[i].append(c);
			}

			// Skip the last segment as the frequency is only maxFreq - 1.
			if (i < maxFreq - 1) {
				for (char c : secondChars) {
					segments[i].append(c);
				}
			}
		}

		int segmentId = 0;
		// Iterate over the remaining characters, and for each, distribute the instances
		// over the segments.
		for (char c : freqs.keySet()) {
			// Skip characters with maxFreq or maxFreq - 1
			// frequency as they have already been inserted.
			if (mostChars.contains(c) || secondChars.contains(c)) {
				continue;
			}

			// Distribute the instances of these characters over the segments in a
			// round-robin manner.
			for (int freq = freqs.get(c); freq > 0; freq--) {
				segments[segmentId].append(c);
				segmentId = (segmentId + 1) % (maxFreq - 1);
			}
		}

		// Each segment except the last should have exactly K elements; else, return "".
		for (int i = 0; i < maxFreq - 1; i++) {
			if (segments[i].length() < k) {
				return "";
			}
		}

		// Join all the segments and return them.
		return String.join("", segments);
	}

	public String rearrangeString(String s, int k) {
		if (k == 0)
			return s;

		int n = s.length(), fre[][] = new int[26][2];
		for (int i = 0; i < 26; i++)
			fre[i][1] = i;
		for (int i = 0; i < n; i++)
			fre[s.charAt(i) - 'a'][0]++;
		Arrays.sort(fre, (a, b) -> b[0] - a[0]);
		int maxFre = fre[0][0], maxCnt = 0;

		for (int i = 0; i < 26; i++) {
			if (fre[i][0] == maxFre)
				maxCnt++;
			else
				break;
		}

		if ((maxFre - 1) * k + maxCnt > n)
			return ""; // n too small

		char[] res = new char[n];
		int idx = (n - 1) % k, p = 0;
		for (int i = 0; i < 26; i++) {
			char c = (char) (fre[i][1] + 'a');

			for (int j = 0; j < fre[i][0]; j++) {
				res[idx] = c;
				idx += k;

				if (idx >= n)
					idx = (idx - 1) % k;
			}
		}
		return new String(res);
	}

}
