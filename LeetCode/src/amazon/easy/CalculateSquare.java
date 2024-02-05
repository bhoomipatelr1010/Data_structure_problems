package amazon.easy;

public class CalculateSquare {

	public static void main(String[] args) {
		/*
		 * System.out.println(5 << 0); int num = 5 >> 1; System.out.println(num);
		 * System.out.println(5 << 1); num = num >> 1; System.out.println(num);
		 * System.out.println(5 << 2); num = num >> 1; System.out.println(num);
		 */

		int power = 0, result = 0;
		int num = 5;
		int temp = num;

		while (temp > 0) {
			if ((temp & 1) > 0) {
				// result=result+(num*(2^power))
				result += (num << power);
			}
			power++;

			// temp=temp/2
			temp = temp >> 1;
		}

	}

}
