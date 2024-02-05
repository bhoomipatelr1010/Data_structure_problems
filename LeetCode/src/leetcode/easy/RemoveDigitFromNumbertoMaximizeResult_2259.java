package leetcode.easy;

public class RemoveDigitFromNumbertoMaximizeResult_2259 {

	public static void main(String[] args) {
		RemoveDigitFromNumbertoMaximizeResult_2259 obj = new RemoveDigitFromNumbertoMaximizeResult_2259();
		System.out.println(obj.removeDigit(
				"2998589353917872714814599237991174513476623756395992135212546127959342974628712329595771672911914471",
				'3'));
	}

	public String removeDigit(String number, char digit) {

		int index = 0;
		int n = number.length();
		for (int i = 0; i < n; i++) {

			char c = number.charAt(i);
			if (c == digit) {
				index = i;
				if (i < n - 1 && digit < number.charAt(i + 1))
					break;
			}
		}
		number = number.substring(0, index) + number.substring(index + 1);

		return number;
	}
}
