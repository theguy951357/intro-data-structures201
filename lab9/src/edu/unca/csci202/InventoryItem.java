package edu.unca.csci202;

public interface InventoryItem {

	/**
	*   A getter for the sku number.
	*   @return the sku number for the item
	*/
    public int getSKU();
	    
	/**
	*   A getter for the description.
	*   @return the description for the item
	*/
    public String getDescription();
    
	/**
	*   A getter for the price.
	*   @return the price of the item
	*/
    public double getPrice();
	    
	/**
	*   A setter for the price.
	*   @param price a double representing the price of the item
	*/
    public void setPrice(double price);
	    
	/**
	*   A getter for the quantity.
	*   @return the quantity on hand of the item
	*/
    public int getQuantity();
	    
	/**
	*   A setter for the quantity.
	*   @param quantity an int representing the quantity of the item on hand
	*/
    public void setQuantity(int quantity);

}
