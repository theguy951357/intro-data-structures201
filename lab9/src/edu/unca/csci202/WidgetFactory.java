package edu.unca.csci202;

import java.util.Iterator;
import java.util.Random;

public class WidgetFactory {
	
	private class FactoryIterator<T> implements Iterator<InventoryItem>{
		private int count;
		private int num;
		private Random rng;
		
		public FactoryIterator(int num) {
			this.count=0;
			this.num=num;
			this.rng = new Random();
		}

		@Override
		public boolean hasNext() {
			return this.count<this.num;
		}

		@Override
		public InventoryItem next() {
			int sku = this.count;
			this.count++;
			double price = 100.0 * rng.nextDouble();
			int quantity = 0;
			InventoryItem ret = new Widget(sku,
					"random item "+sku,
					price,
					quantity
					);
			return ret;
		}
		
	}

	/**
	 * Create a number of items from the factory
	 * @param number of items to create
	 * @return an Iterator to iterate through the created items
	 */
	Iterator<InventoryItem> createItems(int number){
		return new FactoryIterator<InventoryItem>(number);
	}
	
	
}
