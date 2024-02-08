package dsa;
import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

	public static void main(String[] args) {

		RomanToInt romanToInt = new RomanToInt();
		System.out.println(romanToInt.romanToInt("MCMXCIV"));

	}

	public int romanToInt(String s) {
		int n = s.length();
		Map<Character, Integer> romanToIntMap = getRomanValue();
		if (n == 1) {
			return romanToIntMap.get(s.charAt(0));
		}
		int integerValue = 0;
		for (int i = 0; i <= n - 1; i++) {
			int current = romanToIntMap.get(s.charAt(i));
			int next = 0;
			if (i + 1 < n) {
				next = romanToIntMap.get(s.charAt(i + 1));
			}

			if (current < next) {
				integerValue += (next - current);
				i += 1;
			} else {
				integerValue += current;
			}
		}
		return integerValue;

	}

	private Map<Character, Integer> getRomanValue() {
		Map<Character, Integer> romanToIntMap = new HashMap<>();
		romanToIntMap.put('I', 1);
		romanToIntMap.put('V', 5);
		romanToIntMap.put('X', 10);
		romanToIntMap.put('L', 50);
		romanToIntMap.put('C', 100);
		romanToIntMap.put('D', 500);
		romanToIntMap.put('M', 1000);
		return romanToIntMap;
	}
}
