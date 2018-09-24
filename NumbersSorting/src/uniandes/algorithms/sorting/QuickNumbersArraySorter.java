package uniandes.algorithms.sorting;

/**
 * Implements the quick sort algorithm for number arrays
 */
public class QuickNumbersArraySorter implements NumbersArraySorter {

	@Override
	public void sort(double[] numbers) {
		sort(numbers, 0, numbers.length - 1);
	}
	
	 private static void sort(double[] a, int lo, int hi) { 
	        if (hi <= lo) return;
	        int j = partition(a, lo, hi);
	        sort(a, lo, j-1);
	        sort(a, j+1, hi);
	    }
	 
	 private static int partition(double[] a, int lo, int hi) {
	        int i = lo;
	        int j = hi + 1;
	        double v = a[lo];
	        while (true) { 

	            while (less(a[++i], v)) {
	                if (i == hi) break;
	            }

	            while (less(v, a[--j])) {
	                if (j == lo) break;  
	            }

	            if (i >= j) break;

	            exch(a, i, j);
	        }

	        exch(a, lo, j);

	        return j;
	    }
	 
	 
	    private static boolean less(double v, double w) {
	    	Double V = new Double(v);
	    	Double W = new Double(w);
	        if (v == w) return false;   
	        return V.compareTo(W) < 0;
	    }
	        
	    private static void exch(double[] a, int i, int j) {
	        double swap = a[i];
	        a[i] = a[j];
	        a[j] = swap;
	    }


}
