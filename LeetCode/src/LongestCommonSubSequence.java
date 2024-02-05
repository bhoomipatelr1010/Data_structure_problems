
public class LongestCommonSubSequence {

	public static void main(String[] args) {
		LongestCommonSubSequence obj = new LongestCommonSubSequence();

		System.out.println(obj.longestCommonSubsequence("bl", "yby"));
	}

	public int longestCommonSubsequence(String text1, String text2) {

		int n = text1.length();
		int m = text2.length();
		int max = 0;
		for (int i = 0; i < text1.length(); i++) {
			int k = i;
			int j = 0;
			int currentMax = 0;
			while (k < n && j < m) {
				if (text1.charAt(k) == text2.charAt(j)) {
					currentMax += 1;
					j++;
				}
				k++;
			}
			if (max < currentMax) {
				max = currentMax;
			}

		}

		return max;

	}
}
