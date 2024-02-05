package shradhdhadidi.easy;

public class StringValidPalindrom_125 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isPalindrome(String s) {

		char[] charStr = s.toCharArray();

		int l = 0;
		int r = charStr.length - 1;

		while (l < r) {
			while (l < r && !Character.isLetterOrDigit(charStr[l])) {
				l++;
			}
			while (l < r && !Character.isLetterOrDigit(charStr[r])) {
				r--;
			}
			if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
				return false;
			} else {
				l++;
				r--;
			}
		}
		return true;
	}
}
