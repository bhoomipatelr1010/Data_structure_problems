package leetcode.hard;

public class TotalAppealofAString_2262 {
	public static void main(String[] args) {
		TotalAppealofAString_2262 obj = new TotalAppealofAString_2262();
		System.out.println(obj.appealSum("abbca"));
	}

	public long appealSum(String s) {

		long res = 0;
		for (int i = 0; i < 26; i++) {
			int lastIndex = -1;
			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);

				if (c - 'a' == i) {
					res += j + 1;
					lastIndex = j;
				} else if (lastIndex != -1) {
					res += lastIndex + 1;
				}

			}
		}
		return res;

	}
}
