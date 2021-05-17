package edu.unca.csci202;

import java.util.ArrayList;
import java.util.Iterator;

public interface InventorySystem<T extends InventoryItem> {
	/**
	 * Find the InventoryItem with the given sku.
	 * @param sku
	 * @return the index in the inventory list of the found item, -1 if not found.
	 */
	//protected abstract int findHelper(int sku);	
	
	/**
	 * Get all items that are greater than or equal to lowPrice and less than
	 * or equal to highPrice, and return an iterator to them in sorted order 
	 * (ascending) by price.
	 * @param lowPrice
	 * @param highPrice
	 * @return Iterator<InventoryItem> object to retrieve all items found
	 */
	public abstract Iterator<InventoryItem> priceRangeSearch(double lowPrice, 
			double highPrice);
	

	/**
	*   Adds an InventoryItem to the inventory.
	*   @param item an InventoryItem to add to the inventory
	*/   
	public void addItem(InventoryItem item);

	/**
	*   Finds an InventoryItem with a particular sku.
	*   @param sku the sku of an InventoryItem to find.
	*   @return the InventoryItem with the given sku, null if no such item exists.
	*/
    public InventoryItem findItem(int sku);
	  
	/**
	*   Removes the InventoryItem with the given sku.
	*   @param sku the sku of the InventoryItem to remove from the inventory.
	*/  
    public void removeItem(int sku);
	    
	/**
	*   Updates the quantity of the InventoryItem with the given sku.
	*   @param sku an InventoryItem to update
	*   @param quantity the new quantity for the given InventoryItem
	*/
    public void updateItemQuantity(int sku, int quantity);
	    
	/**
	*   Updates the price of the InventoryItem with the given sku.
	*   @param sku an InventoryItem to update
	*   @param price the new price for the given InventoryItem
	*/
    public void updateItemPrice(int sku, double price);

    /**
    *   @return a printable representation of the inventory.
    */
    public String toString();
}
