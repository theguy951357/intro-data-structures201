package edu.unca.csci202;

import java.util.Comparator;
import java.util.Iterator;


public class RecursiveSearchWarehouse<T extends InventoryItem> extends Warehouse<Widget> {

	/**
	 *This method will use the findHelper_sub method to find the given sku
	 *@return Returns the result of the findhelper_sub method
	 */
	@Override
	protected int findHelper(int sku) {
		// TODO Auto-generated method stub
		return this.findHelper_sub(sku, 0);
	}
	
	/**
	 * this method will recursively go through the list to find the given sku
	 * @param sku
	 * @param index
	 * @return returns the index of the given sku number
	 */
	private int findHelper_sub(int sku, int index) {
		//check stopping condition
		if(index >= this.inventory.size()) {
			return -1;//did not find sku
		}
		//check if the current index contains the sku
		if(this.inventory.get(index).getSKU() == sku) {
			return index;
		}
		
		return this.findHelper_sub(sku, index+1);
	}
	/**
	 * this method will recursively go through the list to find the given price
	 * @param price
	 * @param index
	 * @return returns the index of the given price number
	 */
	private int findHelper_sub(double price, int index) {
		//check stopping condition
		if(index >= this.inventory.size()) {
			return -1;//did not find price
		}
		//check if the current index contains the price
		if(Double.compare(this.inventory.get(index).getPrice() , price)>=0) {
			return index;
		}
		
		return this.findHelper_sub(price, index+1);
	}

	/**
	 *An iterator that will go through a sublist of the inventory within the given price range
	 */
	@Override
	public Iterator<InventoryItem> priceRangeSearch(double lowPrice, double highPrice) {
				// sort by price
		this.inventory.sort(new SortByPrice());
				//find the index of the item that is greater than or equal to the lowPrice.
		int startIndex = this.findHelper_sub(lowPrice,0);
		int endIndex = this.findHelper_sub(highPrice, startIndex);
				//find the index of the largest item that is less than or equal to the highPrice
				// create and return a custom iterator to iterate over the range from lowPrice to HighPrice
		return this.inventory.subList(startIndex, endIndex).iterator();
	}
	
	/**
	 * @author cblah
	 *A sortByPrice class that will sort the inventory by price
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
