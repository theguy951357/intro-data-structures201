package edu.unca.csci202;

/**
 * Bubble sort for lab2
 * @author cblah
 *
 */
public class BubbleSort extends SortAlgorithm {

	
	public BubbleSort() {
		this.number_of_comparisons=0;
		this.number_of_swaps=0;
	}
	
	@Override
	public void sort(int[] data, boolean debug) {
		// Taken from java foundations
				int position, scan;
				int temp;
				if(debug) {
					this.print_array(data);
				}
				for(position = data.length -1; position >= 0; position--) {
					this.number_of_comparisons++;
					
				
					for(scan = 0; scan <= position-1; scan++) {
						
						if(data[scan]>data[scan+1]) {
							temp = data[scan];
							data[scan] = data[scan+1];
							data[scan+1]=temp;
							this.number_of_swaps++;
							if(debug) {
								System.out.println("swapped " + data[scan] + " with " + data[scan+1]);
								this.print_array(data);
								
							}
						}
						}
					}
		
	}
	
	
	

	@Override
	public void sort(String[] data, boolean debug) {
		// Taken from java foundations
		int position, scan;
		String temp;
		if(debug) {
			this.print_array(data);
		}
		for(position = data.length -1; position >= 0; position--) {
			this.number_of_comparisons++;
			
		
			for(scan = 0; scan <= position-1; scan++) {
				
				if(data[scan].compareTo(data[scan+1])>0) {
					temp = data[scan];
					data[scan] = data[scan+1];
					data[scan+1]=temp;
					this.number_of_swaps++;
					if(debug) {
						System.out.println("swapped " + data[scan] + " with " + data[scan+1]);
						this.print_array(data);
						
					}
				}
				}
			}
		
	}
	
}
