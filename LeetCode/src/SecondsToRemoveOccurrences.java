
public class SecondsToRemoveOccurrences {

	public static void main(String[] args) {

		SecondsToRemoveOccurrences obj = new SecondsToRemoveOccurrences();
		System.out.println(8^7);

	}

	public int solution(String s) {

		char[] sArr = s.toCharArray();
		for (int i = 0; i < sArr.length; i++) {

			boolean isSwapped = false;
			for (int j = 0; j < sArr.length - 1; j++) {

				if (sArr[j] < sArr[j + 1]) {
					isSwapped = true;

					char temp = sArr[j];
					sArr[j] = sArr[j + 1];
					sArr[j + 1] = temp;
					j++;
				}

			}

			if (!isSwapped) {
				return i;
			}
		}
		return 0;

	}
}
