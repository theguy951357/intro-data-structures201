package edu.unca.csci202;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.Random;

/**
 * Grocery store class will make an arraylist of queues and run a simulation of a groceryStore line.
 * @author cblah
 * @version 1.0
 *
 */
public class GroceryStore {

	private ArrayList<ArrayDeque<Customer>> queues;
	private Random rand;
	private int timeSteps, bag, maxItems,shortestLine, customersServed;
	private double prob, randProb;
	private int maxqueues[];
	private int shortestLineSize=100000000;
	/**
	 * constructor makes the number of lines at the grocery store for the customers to queue into
	 * 
	 * @param queues
	 */
	public GroceryStore(int numLines) {
		
		this.queues = new ArrayList<ArrayDeque<Customer>>();
		for(int i = 0; i < numLines; i++) {
			this.queues.add(new ArrayDeque<Customer>());
		}
		this.customersServed=0;
		this.maxqueues = new int[numLines];
	}
	
	/**
	 * This run method takes in the params and puts a customer in the shortest line.
	 *The method then iterates through each customer and decrements the time until the customer is served and removed from the queue. 
	 * 
	 * @param timeSteps
	 * @param prob
	 * @param bag
	 * @param maxItems
	 */
	public void run(int timeSteps, double prob, int bag, int maxItems) {
		
		this.rand = new Random();
		this.timeSteps= timeSteps;
		this.prob=prob;
		this.bag=bag;
		this.maxItems=maxItems;
		for(int time = 0; time<this.timeSteps; time++) {
			
			//search for the shortest line
			for(int i = 0; i < queues.size();i++) {
				
				if(this.queues.get(i).size()<this.shortestLineSize) {
					this.shortestLineSize=this.queues.get(i).size();
					this.shortestLine=i;
				}
			}
			//add a customer if the random double is within the probability set for the simulation
			this.randProb = this.rand.nextDouble();
			if(Double.compare(this.randProb,prob)<0) {
				this.queues.get(shortestLine).add(new Customer(this.rand.nextInt(this.maxItems)+1,this.bag));
			}
			
			//run through each line and if there is a customer, decrement that customers time. if that customer time is 0, remove the customer from the queue.
			for(int i = 0; i < this.queues.size();i++) {
				if(!(this.queues.get(i).isEmpty())){
					if(this.queues.get(i).element().getTransactionTime()!=0) {
						this.queues.get(i).element().decrementTime();
					}else {
						this.queues.get(i).remove();
						this.customersServed++;
					}
					
					//check for the max number of customers in the given queue.
					if(this.queues.get(i).size()> this.maxqueues[i]) {
						this.maxqueues[i]=this.queues.get(i).size();
					}
				}
			}
			
			this.shortestLineSize=1000000;
		}
		
		
		
		
	}
	
	
	/**
	 * This method prints out the stats of the finished grocery store simulation.
	 */
	public void printData() {
		System.out.println("stats for grocery store simulation");
		System.out.println("Number of time steps run: " + this.timeSteps);
		System.out.println("Number of lines: " + this.queues.size());
		System.out.println("probability of a customer:" + this.prob);
		System.out.println("Time per item:" + this.bag);
		System.out.println("Maximum number of items: " + this.maxItems);
		System.out.println("Maximum length of each queue: " + Arrays.toString(this.maxqueues));
		System.out.print("customers left in each queue: [");
		for(int i = 0; i<this.queues.size();i++) {
			System.out.print(this.queues.get(i).size());
			if(i!=this.queues.size()-1) {
				System.out.print(", ");
			}
		}
		System.out.println("]");
		System.out.println("total customers served: " + this.customersServed);
		
		System.out.println("\n\r\n\r");
		for(int i=0;i<this.queues.size();i++) {
			this.queues.get(i).clear();
		}
		
		
	}
	
	
	
}
