package edu.unca.csci202;

public class Widget implements InventoryItem {

    private int sku;
    private String description;
    private double price;
    private int quantity;
	    
	/**
	*   Constructor.
	*   @param sku an int representing the stock keeping unit number for the item
	*   @param description a String describing the inventory item
	*   @param price a double representing the price of the item
	*   @param quantity an int representing the quantity of the item on hand
	*/
    public Widget(int sku, String description, double price, int quantity) {
        this.sku = sku;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

	/**
	*   A getter for the sku number.
	*   @return the sku number for the item
	*/
    public int getSKU() {
        return sku;
    }
	    
	/**
	*   A getter for the description.
	*   @return the description for the item
	*/
    public String getDescription() {
        return description;
    }
	    
	/**
	*   A getter for the price.
	*   @return the price of the item
	*/
    public double getPrice() {
        return price;
    }
	    
	/**
	*   A setter for the price.
	*   @param price a double representing the price of the item
	*/
    public void setPrice(double price) {
        this.price = price;
    }
	    
	/**
	*   A getter for the quantity.
	*   @return the quantity on hand of the item
	*/
    public int getQuantity() {
        return quantity;
    }
	    
	/**
	*   A setter for the quantity.
	*   @param quantity an int representing the quantity of the item on hand
	*/
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

	@Override
    public String toString() {
        return String.format("Widget[Desc: %s SKU: %d Price: $%4.2f Quantity: %d]", 
                               description, sku, price, quantity); 
    }

	/**
	* Test the InventoryItem class. (Note the explicit calls to each of the methods.)
	* 
	*/
    public static void main(String [] args) {
        InventoryItem item1 = new Widget(123, "apple", 0.32, 100);
        System.out.println(item1);
        System.out.println("Item1 Description: " + item1.getDescription());
        System.out.println("Item1 SKU: " + item1.getSKU());
        System.out.println("Item1 Price: " + item1.getPrice());
        System.out.println("Item1 Quantity: " + item1.getQuantity());
        item1.setPrice(0.48);
        item1.setQuantity(10);
        System.out.println(item1);        
    }


}
