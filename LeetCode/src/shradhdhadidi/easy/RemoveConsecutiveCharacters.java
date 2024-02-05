package shradhdhadidi.easy;

import java.util.Arrays;

public class RemoveConsecutiveCharacters {

	public static void main(String[] args) {
		RemoveConsecutiveCharacters obj = new RemoveConsecutiveCharacters();
		System.out.println(obj.removeConsecutiveCharacter("aab"));

	}

	public String removeConsecutiveCharacter(String S) {

		if (S.length() < 2) {
			return S;
		}
		char[] charStr = S.toCharArray();
		char[] newStrChar = new char[S.length()];
		int k = 0;
		for (int i = 0; i < charStr.length; i++) {
			if (k == 0 || newStrChar[k - 1] != charStr[i]) {
				newStrChar[k++] = charStr[i];
			}
		}
		return new String(newStrChar).trim();

	}
}
