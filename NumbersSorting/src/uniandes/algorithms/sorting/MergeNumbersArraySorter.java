package uniandes.algorithms.sorting;

/**
 * Implements the merge sort algorithm for number arrays
 */
public class MergeNumbersArraySorter implements NumbersArraySorter {

	@Override
	public void sort(double[] numbers) {
		// TODO Implement
		double[] aux = new double[numbers.length];
		sort(numbers, aux, 0, numbers.length-1);
	}

	private static void sort(double[] a, double[] aux, int lo, int hi) {
		if (hi <= lo) return;
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid + 1, hi);
		merge(a, aux, lo, mid, hi);
	}

	private static void merge(double[] a, double[] aux, int lo, int mid, int hi) {
		// precondition: a[lo .. mid] and a[mid+1 .. hi] are sorted subarrays

		// copy to aux[]
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k]; 
		}

		// merge back to a[]
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++) {
			if      (i > mid)              a[k] = aux[j++];
			else if (j > hi)               a[k] = aux[i++];
			else if (less(aux[j], aux[i])) a[k] = aux[j++];
			else                           a[k] = aux[i++];
		}
	}

	private static boolean less(double v, double w) {
		Double V = new Double(v);
		Double W = new Double(w);
		return V.compareTo(W) < 0;
	}

}
