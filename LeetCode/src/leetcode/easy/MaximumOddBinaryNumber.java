package leetcode.easy;

public class MaximumOddBinaryNumber {

	public static void main(String[] args) {
		MaximumOddBinaryNumber obj = new MaximumOddBinaryNumber();
		System.out.println(obj.maximumOddBinaryNumber("010"));

	}

	public String maximumOddBinaryNumber(String s) {

		char[] charNums = s.toCharArray();

		int n = charNums.length;

		int oneCounts = 0;
		for (int i = 0; i < n; i++) {
			if (charNums[i] == '1') {
				oneCounts += 1;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			if (oneCounts > 1) {
				sb.append(1);
				oneCounts--;
			} else if (i == n - 1 && oneCounts == 1) {
				sb.append(1);
			} else {
				sb.append(0);
			}

		}
		return sb.toString();
	}
}
