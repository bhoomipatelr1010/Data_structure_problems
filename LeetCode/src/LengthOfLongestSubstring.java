import java.util.ArrayList;
import java.util.List;

public class LengthOfLongestSubstring {

	public static void main(String[] args) {
		LengthOfLongestSubstring substring = new LengthOfLongestSubstring();
		System.out.println(substring.solution("abcabdef"));
	}

	public int solution(String s) {
		List<Character> strLst = new ArrayList<>();
		int max = 0;
		int currentMax = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (strLst.contains(c)) {
				if (max < currentMax) {
					max = currentMax;
				}
				strLst.clear();
				currentMax = 0;
			}
			currentMax++;
			strLst.add(c);
		}
		return max;
	}
}
