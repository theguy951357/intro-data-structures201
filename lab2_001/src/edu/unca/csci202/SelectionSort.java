package edu.unca.csci202;

public class SelectionSort extends SortAlgorithm {

	
	public SelectionSort() {
		this.number_of_comparisons=0;
		this.number_of_swaps=0;
	}
	
	@Override
	public void sort(int[] data, boolean debug) {
		int temp = 0;
		if(debug) {
			for(int i = 0; i< data.length; i++) {
				for(int j = i; j<data.length; j++) {
					this.number_of_comparisons++;
					
					if(data[i] > data[j]) {
						temp = data[j];
						data[j] = data[i];
						data[i] = temp;
						temp = 0;
						this.number_of_swaps++;
						System.out.println("Swapped " + data[i] + " with " + data[j]);
						this.print_array(data);
					}
//					else {
//						System.out.println("No swaps");
//					}
				}
			}
		}else {
			for(int i = 0; i< data.length; i++) {
				for(int j = i; j<data.length; j++) {
					this.number_of_comparisons++;
					if(data[i] > data[j]) {
						temp = data[j];
						data[j] = data[i];
						data[i] = temp;
						temp = 0;
						this.number_of_swaps++;
					}
				}
			}
		}
		
	}

	@Override
	public void sort(String[] data, boolean debug) {
		String temp = null;
		
		if(debug) {
			for(int i = 0; i< data.length; i++) {
				
				for(int j = i; j<data.length; j++) {
					this.number_of_comparisons++;
					this.print_array(data);
					
					if(data[i].compareTo(data[j])> 0) {
						temp = data[i];
						data[i] = data[j];
						data[j] = temp;
						temp = null;
						this.number_of_swaps++;
						System.out.println("Swapped " + data[i] + " with " + data[j]);
					}else {
						System.out.println("No swaps");
					}
				}
			}
		}else {
			for(int i = 0; i< data.length; i++) {
				for(int j = i; j<data.length; j++) {
					this.number_of_comparisons++;
					if(data[i].compareTo(data[j])>0) {
						temp = data[i];
						data[i] = data[j];
						data[j] = temp;
						temp = null;
						this.number_of_swaps++;
					}
				}
			}
		}

		
	}


}
