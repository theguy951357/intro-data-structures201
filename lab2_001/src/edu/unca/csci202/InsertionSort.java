package edu.unca.csci202;

public class InsertionSort extends SortAlgorithm {

	public InsertionSort() {
		this.number_of_comparisons=0;
		this.number_of_swaps=0;
	}

	@Override
	public void sort(int[] data, boolean debug) {
		// algorithm taken from java foundations
		for(int i = 1; i < data.length; i++) {
			this.number_of_comparisons++;
			if(debug) {
				this.print_array(data);
			}
			int key = data[i];
			int position = i;
			while(position > 0 && data[position-1]>key) {
				data[position] = data[position-1];
				position--;
			}
			data[position] = key;
			this.number_of_swaps++;
			if(debug) {
				System.out.println("inserted " + key + " at position " + position);
			}
		}
		
	}

	@Override
	public void sort(String[] data, boolean debug) {
		// taken from java foundations
		for(int i = 1; i < data.length; i++) {
			this.number_of_comparisons++;
			if(debug) {
				this.print_array(data);
			}
			String key = data[i];
			int position = i;
			while(position > 0 && data[position-1].compareTo(key)>0) {
				data[position] = data[position-1];
				position--;
			}
			data[position] = key;
			this.number_of_swaps++;
			if(debug) {
				System.out.println("inserted " + key + " at position " + position);
			}
		}

		
	}

	
}
