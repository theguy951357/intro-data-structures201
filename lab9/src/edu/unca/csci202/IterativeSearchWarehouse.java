package edu.unca.csci202;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class IterativeSearchWarehouse<T> extends Warehouse<Widget> {

	/**
	 *The findHelper method will help find the things
	 *@return returns the index of the given sku or -1 if the sku is not in the list
	 */
	@Override
	protected int findHelper(int sku) {
		int index = 0;
		while(index != this.inventory.size()) {
			if(this.inventory.get(index).getSKU()== sku) {
				//found it
				return index;
			}
			index++;
		}
		return -1;
	}

	/**
	 *The iterator will iterate over the sublist of the inventory in the given price range
	 *found with for loop instead of recursion
	 */
	@Override
	public Iterator<InventoryItem> priceRangeSearch(double lowPrice, double highPrice) {
		this.inventory.sort(new SortByPrice());
		ArrayList<InventoryItem> subList = new ArrayList<InventoryItem>();
		for(int i = 0; i < this.inventory.size(); i++) {
			if (this.inventory.get(i).getPrice() >= lowPrice && this.inventory.get(i).getPrice() <= highPrice) {
				subList.add(this.inventory.get(i));
			}
		}
		return subList.iterator();
	}
	
	/**
	 * @author cblah
	 *SortByPrice class to sort the inventory by price
	 */
	private class SortByPrice implements Comparator<InventoryItem>{

		/**
		 *A compare to method
		 */
		@Override
		public int compare(InventoryItem o1, InventoryItem o2) {
			
			return (int) (o1.getPrice()-o2.getPrice());
		}
		
	}

}
