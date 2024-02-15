package dsa.contest.contest_384;

import java.util.Arrays;

public class MaximumPalindromsAfterOperations_3035 {

	public static void main(String[] args) {
		String[] words = new String[] { "abbb", "ba", "aa" };
		System.out.println(maxPalindromesAfterOperations(words));
	}

	public static int maxPalindromesAfterOperations(String[] words) {

		int n = words.length;
		int[] char_cnt = new int[26];
		int[] len = new int[words.length];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				char_cnt[words[i].charAt(j) - 'a']++;
			}

			len[i] = words[i].length();
		}

		int even = 0;
		int odd = 0;

		for (int i = 0; i < 26; i++) {
			even += char_cnt[i] / 2;
			odd += char_cnt[i] % 2;
		}
		Arrays.sort(len);
		int result = 0;
		for (int i = 0; i < n; i++) {

			int requiredEven = len[i] / 2;

			int requiredOdd = len[i] % 2;

			if (even < requiredEven) {
				break;
			}

			even -= requiredEven;

			if (odd < requiredOdd) {

				even--;
				odd += 2;
			}

			odd -= requiredOdd;
			result++;
		}

		return result;

	}

}
