package shradhdhadidi.medium;

public class LongestPalindrome_5 {

	public static void main(String[] args) {

		LongestPalindrome_5 obj = new LongestPalindrome_5();
		System.out.println(obj.longestPalindrome2("acbbck"));
	}

	public String test(String s) {

		int maxLength = 0;
		String longestPal = s.charAt(0) + "";

		for (int i = 0; i < s.length(); i++) {

			int start = i;
			int end = s.length() - 1;

			while (start < end) {
				if (check(start, end, s)) {
					int length = end - start + 1;
					if (length > maxLength) {
						maxLength = length;
						longestPal = s.substring(start, end + 1);
					}
					break;

				} else {
					end--;
				}
			}
		}
		return longestPal;

	}

	public void solution(String s) {
		if (s.isEmpty()) {
			return;
		}

		String maxPalindrom = "";

		for (int i = 0; i < s.length(); i++) {
			int k = 0;
			int first = i;
			int last = s.length() - 1;
			int lastConsidered = last;
			while (first < last) {
				++k;
				if (s.charAt(first) == s.charAt(last)) {
					++first;
					--last;
				} else {
					if (s.charAt(i) != s.charAt(last)) {
						--last;
					}
					lastConsidered = last;
					first = i;
				}
			}
			System.out.println("run for how long for one char >> " + k);
			String currentPalindrom = s.substring(i, lastConsidered + 1);
			if (maxPalindrom.length() < currentPalindrom.length()) {
				maxPalindrom = currentPalindrom;
			}
		}
		System.out.println("String >> " + maxPalindrom);

	}

	public String longestPalindrome(String s) {
		for (int length = s.length(); length > 0; length--) {
			for (int start = 0; start <= s.length() - length; start++) {
				if (check(start, start + length - 1, s)) {
					return s.substring(start, start + length);
				}
			}

			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>");
		}

		return "";
	}

	private boolean check(int left, int right, String s) {

		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}

			left++;
			right--;
		}

		return true;
	}

	public String longestPalindrome2(String s) {
		int[] ans = new int[] { 0, 0 };

		for (int i = 0; i < s.length(); i++) {
			int oddLength = expand(i, i, s);
			if (oddLength > ans[1] - ans[0] + 1) {
				int dist = oddLength / 2;
				ans[0] = i - dist;
				ans[1] = i + dist;
			}

			int evenLength = expand(i, i + 1, s);
			if (evenLength > ans[1] - ans[0] + 1) {
				int dist = (evenLength / 2) - 1;
				ans[0] = i - dist;
				ans[1] = i + 1 + dist;
			}
		}

		int i = ans[0];
		int j = ans[1];
		return s.substring(i, j + 1);
	}

	private int expand(int i, int j, String s) {
		int left = i;
		int right = j;

		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}

		return right - left - 1;
	}
}
