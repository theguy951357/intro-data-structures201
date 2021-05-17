package edu.unca.csci202;

import java.util.Comparator;
import java.util.Iterator;



public class BinarySearchWarehouse<T extends InventoryItem> extends Warehouse<Widget> {

	/**
	 *FindHelper method will use recursion to do a binary search through the inventory
	 */
	@Override
	protected int findHelper(int sku) {
		// TODO Auto-generated method stub
		return this.binSearch(sku, 0, this.inventory.size()-1);
	}

	/**
	 * binSearch will use recursively check the middle of the list
	 * @param sku
	 * @param start
	 * @param end
	 * @return returns the index of the given sku
	 */
	private int binSearch(int sku, int start, int end) {
		if(start <= end) {
			int mid = (start+end)/2;
			if(this.inventory.get(mid).getSKU()==sku) {
				//if the middle is the sku we are looking for, return it
				return mid;
			}else if(this.inventory.get(mid).getSKU() > sku) {
				//check the lower half of the list if the middle is greater than the sku
				return this.binSearch(sku, start, mid-1);
			}else {
				//check the upper half of the list
				return this.binSearch(sku, mid+1, end);
			}
		}
		return -1;
	}
	/**
	 * binSearch will use recursively check the middle of the list
	 * @param price
	 * @param start
	 * @param end
	 * @return returns the index of the given price
	 */	
	private int binSearch(double price, int start, int end) {
		if(start <= end) {
			int mid = (start+end)/2;
			//System.out.println("mid = " + this.inventory.get(mid).getPrice() + " price = " + price + " compare = "+ Double.compare( this.inventory.get(mid).getPrice() , price ));
			if( this.inventory.get(mid).getPrice() - price  >=0 && this.inventory.get(mid).getPrice() - price <=5) {
				//if the middle is the sku we are looking for, return it
				return mid;
			}else if( Double.compare( this.inventory.get(mid).getPrice() , price )>0 ) {
				//check the lower half of the list if the middle is greater than the sku
				return this.binSearch(price, start, mid-1);
			}else {
				//check the upper half of the list
				return this.binSearch(price, mid+1, end);
			}
		}
		return -1;
	
	}
	
	/**
	 *iterator will sort the list, perform a binary search for the low and high end of the price range, then return a sublist of the given price range
	 *@return returns a sublist of the given price range.
	 */
	@Override
	public Iterator<InventoryItem> priceRangeSearch(double lowPrice, double highPrice) {
		// sort by price
		this.inventory.sort(new SortByPrice());
		//find the index of the item that is greater than or equal to the lowPrice.
		int start = this.binSearch(lowPrice, 0, this.inventory.size()-1);
		//find the index of the largest item that is less than or equal to the highPrice
		int end = this.binSearch(highPrice, start, this.inventory.size()-1);
		// create and return a custom iterator to iterate over the range from lowPrice to HighPrice
		return this.inventory.subList(start, end).iterator();
	}
	
	/**
	 * @author cblah
	 *A sort by price class
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
