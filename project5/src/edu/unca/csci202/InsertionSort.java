package edu.unca.csci202;


public class InsertionSort<T extends Comparable<T>> extends SortingAlgorithm<T>{	
		
	/**
	 * constructor without debug
	 */
	public InsertionSort() {
		super();
	}
	/**
	 * constructor with debug option
	 * @param debug
	 */
	public InsertionSort(boolean debug) {
		super(debug);
	}
	

	
	/*public void sort(String[] arr) {
		int n = arr.length;
		for(int i=1; i<n; i++) {
			String key = arr[i];
			int j = i-1;
			this.numberOfComparisons++;
			while(j>=0 && arr[j].compareTo(key) > 0) {
				this.numberOfComparisons++;
				this.numberOfSwaps++;
				arr[j+1]=arr[j];
				j=j-1;
			}
			this.numberOfSwaps++;
			arr[j+1]=key;
		}				
	} 
	*/
	/**
	 *An insertion sort algorithm
	 */
	public void sort() {
		for(Node<T> i=this.head.next; i != null; i=i.next) {
			T key = i.data;
			Node<T> j = i.prev;
			this.numberOfComparisons++;
			while(j!=null && j.data.compareTo(key) > 0) {
				this.numberOfComparisons++;
				this.numberOfSwaps++;
				j.next.data = j.data;
				j = j.prev;
			}
			this.numberOfSwaps++;
			if(j == null) { // if j was -1 in array version
				this.head.data = key;
			}else {
				j.next.data = key;
			}
		}		
	}

	
}
