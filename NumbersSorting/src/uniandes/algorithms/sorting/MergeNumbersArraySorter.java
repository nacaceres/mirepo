package uniandes.algorithms.sorting;

/**
 * Implements the merge sort algorithm for number arrays
 */
public class MergeNumbersArraySorter implements NumbersArraySorter {

	@Override
	public void sort(double[] numbers) {
		// TODO Implement
		double[] aux = new double[numbers.length];
		ordenar(numbers, aux, 0, numbers.length-1);
	}

	private void ordenar(double[] numbers, double[] aux, int min, int max) {
		if (max <= min) return;
		int mid = min + (max - min) / 2;
		ordenar(numbers, aux, min, mid);
		ordenar(numbers, aux, mid + 1, max);
		merge(numbers, aux, min, mid, max);
	}

	private void merge(double[] numbers, double[] aux, int min, int mid, int max) {

		for (int k = min; k <= max; k++) {
			aux[k] = numbers[k]; 
		}

		int i = min, j = mid+1;
		for (int k = min; k <= max; k++) {
			if      (i > mid)  
				numbers[k] = aux[j++];
			else if (j > max)               
				numbers[k] = aux[i++];
			else if (aux[j] < aux[i]) 
				numbers[k] = aux[j++];
			else                           
				numbers[k] = aux[i++];
		}
	}
}
