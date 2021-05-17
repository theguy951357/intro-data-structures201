package edu.unca.csci202;

public abstract class SortAlgorithm {
	abstract public void sort(int[] data, boolean debug);
	
	abstract public void sort(String[] data, boolean debug);

	protected int number_of_comparisons;
	protected int number_of_swaps;
	
	public void printStats() {
		System.out.println("***** STATS *****");
		System.out.println("Number of comparisons " + this.number_of_comparisons);
		System.out.println("Number of swaps " + this.number_of_swaps);
	
	}
	
	public void print_array(int[] test_data) {
		for(int i = 0; i < test_data.length; i++) {
			System.out.print(test_data[i] + " ");
		}
		System.out.println();
		
	}
	
	public void print_array(String[] test_data) {
		for(int i = 0; i < test_data.length; i++) {
			System.out.print(test_data[i] + " ");
		}
		System.out.println();
		
	}

}
