package shradhdhadidi.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrangeNumberToFormBiggestNumber {

	public static void main(String[] args) {
		List<String> arr = new ArrayList<>();
		arr.add("54");
		arr.add("546");
		arr.add("548");
		arr.add("60");
		ArrangeNumberToFormBiggestNumber obj = new ArrangeNumberToFormBiggestNumber();
		obj.formBiggestNumber(arr);
	}

	void formBiggestNumber(List<String> nums) {

		Collections.sort(nums, new Comparator<String>() {

			@Override
			public int compare(String x, String y) {

				String xy = x + y;
				String yx = y + x;
				return -xy.compareTo(yx);
			}

		});

		for (String ele : nums) {
			System.out.print(ele);
		}
	}

}
