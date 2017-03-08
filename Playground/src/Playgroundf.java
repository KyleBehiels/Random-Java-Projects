import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Sorting demonstrates sorting and searching on an array of objects.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class Playgroundf {
	public static int comparisonTotal = 0;
	public static long startTimeMillis;
	public static long endTimeMillis;

	public static Integer[][] testArrays;

	static String seperatorOne = "==========================================================";
	static String seperatorTwo = "----------------------------------------------------------------------------------------------------";

	public static void main(String[] args) {
		

		// Begin Testing
		// Selection Sort
		generateArrays();
		System.out.println("Selection Sort");
		System.out.println(seperatorOne);
		for (int i = 0; i < 7; i++) {
			System.out.println("Testing List " + i);
			startTimeMillis = System.currentTimeMillis();
			selectionSort(testArrays[i]);
			endTimeMillis = System.currentTimeMillis();
			System.out.println("Sorted list " + i + " in " + (endTimeMillis - startTimeMillis) + " milliseconds with "
					+ comparisonTotal + " comparisons");
			comparisonTotal = 0;
			System.out.println(seperatorTwo);
		}
		// Insertion Sort
		generateArrays();
		System.out.println("Insertion Sort");
		System.out.println(seperatorOne);
		for (int i = 0; i < 7; i++) {
			System.out.println("Testing List " + i);
			startTimeMillis = System.currentTimeMillis();
			insertionSort(testArrays[i]);
			endTimeMillis = System.currentTimeMillis();
			System.out.println("Sorted list " + i + " in " + (endTimeMillis - startTimeMillis) + " milliseconds with "
					+ comparisonTotal + " comparisons");
			comparisonTotal = 0;
			System.out.println(seperatorTwo);
		}
		// Bubble Sort
		generateArrays();
		System.out.println("Bubble Sort");
		System.out.println(seperatorOne);
		for (int i = 0; i < 7; i++) {
			System.out.println("Testing List " + i);
			startTimeMillis = System.currentTimeMillis();
			bubbleSort(testArrays[i]);
			endTimeMillis = System.currentTimeMillis();
			System.out.println("Sorted list " + i + " in " + (endTimeMillis - startTimeMillis) + " milliseconds with "
					+ comparisonTotal + " comparisons");
			comparisonTotal = 0;
			System.out.println(seperatorTwo);
		}
		// Merge Sort
		generateArrays();
		System.out.println("Merge Sort");
		System.out.println(seperatorOne);
		for (int i = 0; i < 7; i++) {
			System.out.println("Testing List " + i);
			startTimeMillis = System.currentTimeMillis();
			mergeSort(testArrays[i]);
			endTimeMillis = System.currentTimeMillis();
			System.out.println("Sorted list " + i + " in " + (endTimeMillis - startTimeMillis) + " milliseconds with "
					+ comparisonTotal + " comparisons");
			comparisonTotal = 0;
			System.out.println(seperatorTwo);
		}
		// Quick Sort
		generateArrays();
		System.out.println("Quick Sort");
		System.out.println(seperatorOne);
		for (int i = 0; i < 7; i++) {
			System.out.println("Testing List " + i);
			startTimeMillis = System.currentTimeMillis();
			quickSort(testArrays[i]);
			endTimeMillis = System.currentTimeMillis();
			System.out.println("Sorted list " + i + " in " + (endTimeMillis - startTimeMillis) + " milliseconds with "
					+ comparisonTotal + " comparisons");
			comparisonTotal = 0;
			System.out.println(seperatorTwo);
		}
		
		
	}

	public static Integer[] createArray(int length) {
		Integer[] returnArray = new Integer[length];
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			returnArray[i] = random.nextInt(100);
		}
		return returnArray;
	}

	public static void generateArrays() {
		testArrays = new Integer[7][];
		testArrays[0] = createArray(10);
		testArrays[1] = createArray(100);
		testArrays[2] = createArray(1000);
		testArrays[3] = createArray(10000);
		testArrays[4] = createArray(100000);
		testArrays[5] = new Integer[1000];
		for (int i = 0; i < 1000; i++) {
			testArrays[5][i] = i;
		}
		testArrays[6] = new Integer[10000];
		for (int i = 0; i < 10000; i++) {
			testArrays[6][i] = i;
		}
	}

	/**
	 * Sorts the specified array of integers using the selection sort algorithm.
	 *
	 * @param data
	 *            the array to be sorted
	 */
	public static <T extends Comparable<T>> void selectionSort(T[] data) {
		int min;
		T temp;

		for (int index = 0; index < data.length - 1; index++) {
			min = index;

			for (int scan = index + 1; scan < data.length; scan++) {
				comparisonTotal++;
				if (data[scan].compareTo(data[min]) < 0) {
					min = scan;

				}
			}
			swap(data, min, index);
		}
	}

	/**
	 * Swaps to elements in an array. Used by various sorting algorithms.
	 * 
	 * @param data
	 *            the array in which the elements are swapped
	 * @param index1
	 *            the index of the first element to be swapped
	 * @param index2
	 *            the index of the second element to be swapped
	 */
	private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {
		T temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}

	/**
	 * Sorts the specified array of objects using an insertion sort algorithm.
	 *
	 * @param data
	 *            the array to be sorted
	 */
	public static <T extends Comparable<T>> void insertionSort(T[] data) {
		for (int index = 1; index < data.length; index++) {
			T key = data[index];
			int position = index;
			// shift larger values to the right
			while (position > 0 && data[position - 1].compareTo(key) > 0) {
				data[position] = data[position - 1];
				position--;
				comparisonTotal++;
			}

			data[position] = key;
		}
	}

	/**
	 * Sorts the specified array of objects using a bubble sort algorithm.
	 *
	 * @param data
	 *            the array to be sorted
	 */
	public static <T extends Comparable<T>> void bubbleSort(T[] data) {
		int position, scan;
		T temp;

		for (position = data.length - 1; position >= 0; position--) {
			for (scan = 0; scan <= position - 1; scan++) {
				comparisonTotal++;
				if (data[scan].compareTo(data[scan + 1]) > 0)
					swap(data, scan, scan + 1);
			}
		}
	}

	/**
	 * Sorts the specified array of objects using the merge sort algorithm.
	 *
	 * @param data
	 *            the array to be sorted
	 */
	public static <T extends Comparable<T>> void mergeSort(T[] data) {
		mergeSort(data, 0, data.length - 1);
	}

	/**
	 * Recursively sorts a range of objects in the specified array using the
	 * merge sort algorithm.
	 *
	 * @param data
	 *            the array to be sorted
	 * @param min
	 *            the index of the first element
	 * @param max
	 *            the index of the last element
	 */
	private static <T extends Comparable<T>> void mergeSort(T[] data, int min, int max) {
		comparisonTotal++;
		if (min < max) {
			int mid = (min + max) / 2;
			mergeSort(data, min, mid);
			mergeSort(data, mid + 1, max);
			merge(data, min, mid, max);
		}
	}

	/**
	 * Merges two sorted subarrays of the specified array.
	 *
	 * @param data
	 *            the array to be sorted
	 * @param first
	 *            the beginning index of the first subarray
	 * @param mid
	 *            the ending index fo the first subarray
	 * @param last
	 *            the ending index of the second subarray
	 */
	@SuppressWarnings("unchecked")
	private static <T extends Comparable<T>> void merge(T[] data, int first, int mid, int last) {
		T[] temp = (T[]) (new Comparable[data.length]);

		int first1 = first, last1 = mid; // endpoints of first subarray
		int first2 = mid + 1, last2 = last; // endpoints of second subarray
		int index = first1; // next index open in temp array

		// Copy smaller item from each subarray into temp until one
		// of the subarrays is exhausted
		while (first1 <= last1 && first2 <= last2) {
			if (data[first1].compareTo(data[first2]) < 0) {
				temp[index] = data[first1];
				first1++;
			} else {
				temp[index] = data[first2];
				first2++;
			}
			index++;
		}

		// Copy remaining elements from first subarray, if any
		while (first1 <= last1) {
			temp[index] = data[first1];
			first1++;
			index++;
		}

		// Copy remaining elements from second subarray, if any
		while (first2 <= last2) {
			temp[index] = data[first2];
			first2++;
			index++;
		}

		// Copy merged data into original array
		for (index = first; index <= last; index++)
			data[index] = temp[index];
	}

	/**
	 * Sorts the specified array of objects using the quick sort algorithm.
	 * 
	 * @param data
	 *            the array to be sorted
	 */
	public static <T extends Comparable<T>> void quickSort(T[] data) {
		quickSort(data, 0, data.length - 1);
	}

	/**
	 * Recursively sorts a range of objects in the specified array using the
	 * quick sort algorithm.
	 * 
	 * @param data
	 *            the array to be sorted
	 * @param min
	 *            the minimum index in the range to be sorted
	 * @param max
	 *            the maximum index in the range to be sorted
	 */
	private static <T extends Comparable<T>> void quickSort(T[] data, int min, int max) {
		comparisonTotal++;
		if (min < max) {
			// create partitions
			int indexofpartition = partition(data, min, max);

			// sort the left partition (lower values)
			quickSort(data, min, indexofpartition - 1);

			// sort the right partition (higher values)
			quickSort(data, indexofpartition + 1, max);
		}
	}

	/**
	 * Used by the quick sort algorithm to find the partition.
	 * 
	 * @param data
	 *            the array to be sorted
	 * @param min
	 *            the minimum index in the range to be sorted
	 * @param max
	 *            the maximum index in the range to be sorted
	 */
	private static <T extends Comparable<T>> int partition(T[] data, int min, int max) {
		T partitionelement;
		int left, right;
		int middle = (min + max) / 2;

		// use the middle data value as the partition element
		partitionelement = data[middle];
		// move it out of the way for now
		swap(data, middle, min);

		left = min;
		right = max;

		while (left < right) {
			// search for an element that is > the partition element
			while (left < right && data[left].compareTo(partitionelement) <= 0)
				left++;

			// search for an element that is < the partition element
			while (data[right].compareTo(partitionelement) > 0)
				right--;

			// swap the elements
			if (left < right)
				swap(data, left, right);
		}

		// move the partition element into place
		swap(data, min, right);

		return right;
	}
}
