/**
 * 
 */
package edu.unca.csci202;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;



/**
 * @author cblah
 *
 */
public class LinkedBST<T extends Comparable<T>> implements BinarySearchTreeADT<T> {

	
	//private node class
	private class BSTNode<T>{
		private T data;
		private BSTNode<T> left;
		private BSTNode<T> right;
		private BSTNode<T> parent;
	}
	
	private int size;
	private BSTNode<T> root;
	
	
	
	/**
	 * default constructor sets size to 0 and root to null
	 * @param size
	 * @param root
	 */
	public LinkedBST() {
		this.size = 0;
		this.root = null;
	}

	/**
	 *method gets the root element
	 */
	@Override
	public T getRootElement() {
		// TODO Auto-generated method stub
		if(this.root == null) {
		return null;
		
		}
		return this.root.data;
	}

	/**
	 *boolean to check if list is empty
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (this.root == null);
	}

	/**
	 *default iterator calls inOrder
	 */
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return this.iteratorInOrder();
	}

	/**
	 *iterates in order
	 */
	@Override
	public Iterator<T> iteratorInOrder() {
		LinkedList<T> list = new LinkedList<T>();
		traverseInOrder(this.root, list);
		return list.iterator();
	}
	
	/**
	 * traverses in order
	 * @param node
	 * @param list
	 */
	private void traverseInOrder(BSTNode<T> node, LinkedList<T> list) {
		if(node!= null) {
			//recurse left
			traverseInOrder(node.left,list);
			//visit node
			list.add(node.data);
			//recurse right
			traverseInOrder(node.right, list);
		}
	}

	/**
	 *iterator in preorder
	 */
	@Override
	public Iterator<T> iteratorPreOrder() {
		LinkedList<T> list = new LinkedList<T>();
		this.traversePreOrder(this.root, list);
		return list.iterator();
	}
	
	/**
	 * traverses in preorder
	 * @param node
	 * @param list
	 */
	private void traversePreOrder(BSTNode<T> node, LinkedList<T> list) {
		// TODO Auto-generated method stub
		if(node!=null) {
			//visit node
			list.add(node.data);
			//left
			this.traversePreOrder(node.left, list);
			//right
			this.traversePreOrder(node.right, list);
		}
		
	}

	/**
	 *iterates in post order
	 */
	@Override
	public Iterator<T> iteratorPostOrder() {
		LinkedList<T> list = new LinkedList<T>();
		this.traversePostOrder(this.root, list);
		return list.iterator();
	}
	
	/**
	 * traverses in post order
	 * @param node
	 * @param list
	 */
	private void traversePostOrder(BSTNode<T> node, LinkedList<T> list) {
		// TODO Auto-generated method stub
		if(node!= null) {
			//left
			this.traversePostOrder(node.left, list);
			//right
			this.traversePostOrder(node.right, list);
			//visit node
			list.add(node.data);
		}
	}

	/**
	 *iterates in level order
	 */
	@Override
	public Iterator<T> iteratorLevelOrder() {
		LinkedList<T> list = new LinkedList<T>();
		Queue<BSTNode<T>> work = new ArrayDeque<BSTNode<T>>();
		work.add(this.root);//start at the root

		while(!work.isEmpty()) {
			BSTNode<T> node = work.remove();//pop the first
			list.add(node.data);
			
			if(node.left!= null) {
				work.add(node.left);
			}
			if(node.right!= null) {
				work.add(node.right);
			}
		}
		return list.iterator();
	}

	/**
	 *inserts a new element into the list
	 */
	@Override
	public int insert(T element) {
		// TODO Auto-generated method stub
		this.size++;
		BSTNode<T> z = new BSTNode();
		z.data = element;
		z.parent = null;
		z.left = null;
		z.right = null;
		
		
		BSTNode<T> x = this.root;
		BSTNode<T> y = null;//trailing
		
		int traversals = 0;
		while(x!= null) {
			traversals++;
			y=x;
			if(z.data.compareTo(x.data)<0) {
				x = x.left;
			}else {
				x = x.right;
			}
		}
		z.parent = y;
		if(y==null) {
			this.root=z;
		}else if(z.data.compareTo(y.data)<0) {
			y.left=z;
		}else {
			y.right=z;
		}
		
		return traversals;
	}

	/**
	 *finds the height of the tree
	 */
	@Override
	public int height() {
		if (this.root == null) {
			return 0;
		}
		// TODO Auto-generated method stub
		return height_sub(this.root);
	}
	
	/**
	 * sub method to recurse through and find the height
	 * @param node
	 * @return
	 */
	private int height_sub(BSTNode<T> node) {
		int heightLeft = 0;
		int heightRight = 0;
		if(node.left!= null) {
			heightLeft = height_sub(node.left);
		}
		if(node.right!= null) {
			heightRight = height_sub(node.right);
		}
		return 1+ Math.max(heightLeft, heightRight);
	}

	/**
	 *gets the max node
	 */
	@Override
	public T maximum() {
		// TODO Auto-generated method stub
		if(this.root == null) {
			return null;
		}
		BSTNode<T> node = maximum(this.root);
		if(node != null) {
			return node.data;
		}
		return null;
	}
	/**
	 * helper method for max node
	 * @param node
	 * @return
	 */
	private BSTNode<T> maximum(BSTNode node){
		while(node.right != null) {
			node = node.right;
		}
		return node;
	}

	/**
	 *finds the min node
	 */
	@Override
	public T minimum() {
		// TODO Auto-generated method stub
		if(this.root == null) {
			return null;
		}
		BSTNode<T> node = minimum(this.root);
		if(node != null) {
			return node.data;
		}
		return null;
	}
	/**
	 * helper method for minimum
	 * @param node
	 * @return
	 */
	private BSTNode<T> minimum(BSTNode node){
		while(node.left != null) {
			node = node.left;
		}
		return node;
	}

	@Override
	public void delete(T element) {
		// TODO Auto-generated method stub

	}

	@Override
	public T find(T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}
	
	/**
	 *toString method calls print
	 */
	public String toString() {
		return print(this.root,0);
	}
	
	/**
	 * recurses through the list to make a string representation of the tree
	 * @param node
	 * @param level
	 * @return
	 */
	private String print(BSTNode<T> node, int level) {
		String ret = "";
		if(node!= null) {
			for(int i = 0; i< level; i++) {
				ret += "\t";
			}
			ret+= node.data;
			ret +="\n";
			ret += print(node.left, level +1);
			ret += print(node.right, level+1);
		}
		return ret;
	}

}
