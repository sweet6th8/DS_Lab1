package BaiTapLop;

import java.util.Arrays;

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
//		System.out.println(result.length);
		int index = 0;
		for (int i = 0; i < n; i++) {
			if (array[i] != 'a') {
				result[index++] = array[i];
			}
		}

		return result;

	}

	// Input: 10 11 12 -1 14 10 17 19 20
	// Output(k=3): 10 11 12 12 14 10 17 19 20
	public int[] fillMissingValues(int k) {

		int n = array.length;
		int[] result = new int[n];
		int index = 0;
		int value = 0;
		for (int i = 0; i < n; i++) {

			if (array[i] != -1) {
				result[index++] = array[i];
			}

			if (i == 0 && array[i] == -1) {
				while (i < k) {
					value += array[++i];

				}
				result[index++] = value / k;
				i = 0;
			}

			if (i == n - 1 && array[i] == -1) {
				while (i > n - 1 - k) {
					value += array[--i];

				}
				result[index] = value / k;
				i = n - 1;
			}

			if (i != 0 && i != n - 1 && array[i] == -1) {
				int end = i + k / 2;
				int start = i - k / 2;
				int num = array[i];
				int cur = i;

				if (k % 2 == 0) {
					for (int j = start; j <= end; j++) {
						if (cur < k / 2) {
							end++;
							cur++;
						} else if (cur > n - 1 - k / 2) {
							start--;
							end = n - 1;
							j -= 2;
							cur--;

						} else {
							value += array[j];
						}

					}
					result[index++] = (value - num) / k;
				} else {
					for (int j = start; j <= end; j++) {
						if (cur < k / 2) {
							end++;
							cur++;
						} else if (cur > n - 1 - k / 2) {
							start--;
							end = n - 1;
							j -= 2;
							cur--;

						} else {
							value += array[j];
						}

					}

					value = value - num;
					if (i - k / 2 - 1 < 0) {
						result[index++] = (value + array[i - k / 2 + 1]) / k;
					} else if (i - k / 2 + 1 > n - 1) {
						result[index++] = (value + array[i - k / 2 - 1]) / k;
					} else {
						value = Math.min(value + array[i - k / 2 - 1], value + array[i - k / 2 + 1]);
						result[index++] = value / k;
					}
				}
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

	public int[] fillMissingValues2(int k) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == -1) {
				int left = i - k / 2;
				int right = i + k / 2;
				if (k % 2 == 0) {
					if (left < 0) {
						left = 0;
						right = k;
					}
					if (right > array.length - 1) {
						left = array.length - k - 1;
						right = array.length - 1;
					}
					array[i] = (int) averageOfTotal(left, right, k);
				} else {
					int subLeft = left - 1;
					int incRight = right + 1;
					if (subLeft < 0) {
						subLeft = 0;
						right = k;
					}
					if (incRight > array.length - 1) {
						left = array.length - k - 1;
						incRight = array.length - 1;
					}
					if (i == 0) {
						array[i] = (int) averageOfTotal(1, right, k);
					} else if (i == array.length - 1) {
						array[i] = (int) averageOfTotal(array.length - 1 - k, array.length - 1, k);
					} else {
						array[i] = (int) Math.min(averageOfTotal(subLeft, right, k), averageOfTotal(left, incRight, k));
					}
				}
			}
		}
		return array;
	}
	 public float averageOfTotal(int start, int end, int k) {
	        int sum = 0;
	        for (int j = start; j <= end; j++) {
	            sum += array[j];
	        }
	        return (float) (sum + 1) / k;
	    }

	public static void main(String[] args) {
//		MyArray myArray1 = new MyArray(new int[] { 1, 2, 3 });
//		MyArray myArray2 = new MyArray(new int[] { 1, 3, 5, 1, 3, 7, 9, 8 });
//		MyArray myArray3 = new MyArray(new int[] { 10, 11, 12, 13, 14, 17, 19, 20 });
		MyArray myArray4 = new MyArray(new int[] { 1, 11, 1, 1, 14, 10, 1, -1, 1 });
//		System.out.println(Arrays.toString(myArray1.mirror()));
//		System.out.println(Arrays.toString(myArray2.removeDuplicates()));
//		System.out.println(Arrays.toString(myArray3.getMissingValues()));
		System.out.println(Arrays.toString(myArray4.fillMissingValues(5)));
//		System.out.println(Arrays.toString(myArray4.fillMissingValues2(5)));

	}
}
