package edu.unca.csci202;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Warehouse<T extends InventoryItem> implements InventorySystem<T> {

	
	/**
	 * a helper method to find a sku number in a list
	 * @param sku
	 * @return returns the index of the sku number being searched
	 */
	protected abstract int findHelper(int sku);
	
	
	/**
	 *An iterator that will iterate over the given list
	 */
	@Override
	public abstract Iterator<InventoryItem> priceRangeSearch(double lowPrice, double highPrice);
	
	/**
	 * the initial arryList that will be searched
	 */
	protected ArrayList<InventoryItem> inventory;

	
	
	/**
	 * Constructor sets inventory to a new ArrayList
	 * @param inventory
	 */
	public Warehouse() {
		this.inventory = new ArrayList<InventoryItem>();
	}

	/**
	 *An add item method
	 */
	@Override
	public void addItem(InventoryItem item) {
		// TODO Auto-generated method stub
		this.inventory.add(item);
	}

	/**
	 *A find item method that will use the appropriate findhelper method for each class
	 */
	@Override
	public InventoryItem findItem(int sku) {
		int index = this.findHelper(sku);
		if(index != -1) {
			return this.inventory.get(index);
		}else {
			return null;
		}
	}

	/**
	 *A remove item method
	 */
	@Override
	public void removeItem(int sku) {
		int index = this.findHelper(sku);
		if(index != -1) {
			this.inventory.remove(index);
		}

	}

	/**
	 *This method will update the quantitity of the inventory
	 */
	@Override
	public void updateItemQuantity(int sku, int quantity) {
		int index = this.findHelper(sku);
		if(index!=-1) {
			this.inventory.get(index).setQuantity(quantity);
		}

	}

	/**
	 *This method will update the price of a given sku
	 */
	@Override
	public void updateItemPrice(int sku, double price) {
		int index = this.findHelper(sku);
		if(index!=-1) {
			this.inventory.get(index).setPrice(price);
		}

	}

}
