package shradhdhadidi.medium;

public class LongestPrefixSuffix_GFG {

	public static void main(String[] args) {
		String txt = "acccbaaacccbaac";

		int k = new LongestPrefixSuffix_GFG().mySolution(txt);
		System.out.println(k);

	}

	public int mySolution(String s) {

		int[] lps = new int[s.length()];
		/*
		 * lps[0] = 0; for (int i = 1; i < s.length(); i++) { int j = lps[i - 1]; if
		 * (s.charAt(j) == s.charAt(i)) { lps[i] = j + 1; } else { lps[i] = 0; } }
		 */

		int len = 0;
		int i = 1;
		lps[0] = 0;

		while (i < s.length()) {
			if (s.charAt(i) == s.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if (len != 0) {
					len = lps[len - 1];
				} else {
					lps[i] = len;
					i++;
				}
			}
		}

		return lps[s.length() - 1];

	}
}
