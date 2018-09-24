package uniandes.algorithms.sorting;

/**
 * Implements the quick sort algorithm for number arrays
 */
public class QuickNumbersArraySorter implements NumbersArraySorter {

	@Override
	public void sort(double[] numbers) {
		ordenar(numbers, 0, numbers.length - 1);
	}
	
	 private void ordenar(double[] numbers, int min, int max) { 
	        if (max <= min) return;
	        int j = partir(numbers, min, max);
	        ordenar(numbers, min, j-1);
	        ordenar(numbers, j+1, max);
	    }
	 
	 private int partir(double[] numbers, int min, int max) {
	        int i = min;
	        int j = max + 1;
	        double v = numbers[min];
	        while (true) { 

	            while (numbers[++i] < v) {
	                if (i == max) break;
	            }

	            while (v < numbers[--j]) {
	                if (j == min) break;  
	            }

	            if (i >= j) break;

	            cambiar(numbers, i, j);
	        }

	        cambiar(numbers, min, j);

	        return j;
	    }
	        
	    private void cambiar(double[] numbers, int i, int j) {
	        double cambio = numbers[i];
	        numbers[i] = numbers[j];
	        numbers[j] = cambio;
	    }


}
