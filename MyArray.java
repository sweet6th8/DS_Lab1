package BaiTapLop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyArray {
	private int[] array;

	public MyArray(int[] array) {
		this.array = array;
	}

	public int[] mirror() {
		int n = array.length;
		int[] result = new int[n * 2];

		for (int i = 0; i < n; i++) {
			result[i] = array[i];
			result[n * 2 - 1 - i] = array[i];
		}
		return result;
	}

	public int[] removeDuplicates() {
		int n = array.length;
		int count = 0;

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (array[i] == array[j]) {
					array[j] = (char) 'a';
					count++;
				}

			}

		}

		int[] result = new int[n - (count - 1)];
		int index = 0;
		for (int i = 0; i < n; i++) {
			if (array[i] != 'a') {
				result[index++] = array[i];
			}
		}

		return result;

	}

	public int[] getMissingValues() {
		int n = array.length;
		Arrays.sort(array);
		int[] result = new int[(array[n - 1] - array[0] + 1) - n];
		int index = 0;
		int start = array[0];

		for (int i = 0; i < n; i++) {
			if (array[i] != start) {
				result[index++] = start;

				i--;
			}
			start++;

		}

		return result;
	}

	// Input: 10 11 12 -1 14 10 17 19 20
	// Output(k=3): 10 11 12 12 14 10 17 19 20
	public int[] fillMissingValues(int k) {
		int n = array.length;
		List<Integer> missingValues = new ArrayList<>();

		if (k == 0) {
			return array;
		}
		
		for (int i = 0; i < n; i++) {

			if (array[i] == -1) {

				missingValues.add(i);
			}
		}

		for (Integer missingValue : missingValues) {
			int sum = 0;
			int count = 0;
			int left;
			int right;
			if (missingValue + k > n - 1) {
				right = n - 1;
				left = right - k;
			} else if (missingValue - k < 0) {
				left = 0;
				right = left + k;
			} else {
				left = missingValue - k;
				right = missingValue + k;
			}
			for (int j = left; j <= right; j++) {
				if (array[j] != -1) {
					sum += array[j];

				}
			}

			if (k == 1) {
				array[missingValue] = Math.min(array[left], array[right]);
			}

			if (k > 1) {
				array[missingValue] = sum / k;

			}

		}
		return array;
	}

	public static void main(String[] args) {
		MyArray myArray1 = new MyArray(new int[] { 1, 2, 3 });
		MyArray myArray2 = new MyArray(new int[] { 1, 3, 5, 1, 3, 7, 9, 8 });
		MyArray myArray3 = new MyArray(new int[] { 10, 11, 12, 13, 14, 17, 19, 20 });
		MyArray myArray4 = new MyArray(new int[] { 10, 11, 12, -1, 14, 10, 17, 19, 20 });
		System.out.println(Arrays.toString(myArray1.mirror()));
		System.out.println(Arrays.toString(myArray2.removeDuplicates()));
		System.out.println(Arrays.toString(myArray3.getMissingValues()));
		System.out.println(Arrays.toString(myArray4.fillMissingValues(3)));

	}
}
