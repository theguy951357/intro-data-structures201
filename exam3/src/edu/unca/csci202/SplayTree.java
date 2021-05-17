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
public class SplayTree<T extends Comparable<T>> implements BinarySearchTreeADT<T> {

	
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
		public SplayTree() {
			this.size = 0;
			this.root = null;
		}
	
	
	/**
	 *gets the root element of the tree
	 *@return the data at the root element
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
	 *checks to see if the tree is empty
	 *@return true if empty false if not
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
		BSTNode<T> z = new BSTNode<T>();
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
		this.splay(z);
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
		this.splay(node);
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
		this.splay(node);
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


	/**
	 *deletes an element from the tree
	 */
	@Override
	public void delete(T element) {
		// TODO Auto-generated method stub
		BSTNode<T> node = findSub(this.root, element);
		if(node == null) {
			System.out.println("Element is not in the tree");
			
		}else {
			this.size--;
			deleteSub(node);
		}
		
	}
	
	/**
	 * a private sub method for the delete method
	 * @param z
	 */
	private void deleteSub(BSTNode<T> z) {
		// TODO Auto-generated method stub
		BSTNode<T> lowest = null;
		if(z.left == null) {//case 1
			lowest = z.parent;
			transplant(z, z.right);
			
		}else if(z.right == null) {//case2
			lowest = z.parent;
			transplant(z, z.left);
		}else {//case 3
			BSTNode<T> y = minimum(z.right);
			if(y.parent != z) {//case 3b
				transplant(y, y.right);
				y.right = z.right;
				y.right.parent = y;
				lowest = y;
			}
			transplant(z, y);//case 3a
			if(lowest != y) {
			lowest = y.parent;
			}
			y.left = z.left;
			y.left.parent = y;
		}
		
		
	}

	/**
	 * method transplants one node for the other
	 * @param node
	 * @param other
	 */
	private void transplant(BSTNode<T> node, BSTNode<T> other) {
		if(node.parent == null) {
			this.root = other;
		}else if(node == node.parent.left) {
			node.parent.left= other;
		}else {
			node.parent.right = other;
		}
		if(other != null) {
			other.parent = node.parent;
		}
	}


	/**
	 *finds the element in the tree
	 *@return either the element found or null
	 */
	@Override
	public T find(T element) {
		// TODO Auto-generated method stub
		BSTNode<T> node = findSub(this.root,element);
		if(node != null) {
			
			return node.data;
		}else {
			return null;
		}
	}

	/**
	 *A boolean to check if the tree contains the element
	 *@return true if the element is found in the tree and false if not
	 */
	@Override
	public boolean contains(T element) {
		// TODO Auto-generated method stub
		BSTNode<T> node = findSub(this.root,element);
		if(node != null) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * private sub method for find and contains
	 * @param node
	 * @param element
	 * @return returns either the node, or null if not found
	 */
	private BSTNode<T> findSub(BSTNode<T> node, T element){
		if(node == null) {
			return null;
		}
		if(node.data.compareTo(element)==0) {
			this.splay(node);
			return node;
		}
		if(node.data.compareTo(element)>0) {
			return findSub(node.left, element);
		}else {
			return findSub(node.right, element);
		}
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
	
	/**
	 * rotates nodes to the left to balance the tree
	 * 
	 * @param x
	 */
	private void leftRotate(BSTNode<T> x) {
		//step 1
		BSTNode<T> y = x.right;
		x.right = y.left;
		if(y.left != null) {
			y.left.parent = x;
		}
		//step 2
		y.parent = x.parent;
		if(x.parent == null) {
			this.root = y;
		}else if(x == x.parent.left) {
			x.parent.left = y;
		}else {
			x.parent.right = y;
		}
		//step 3
		y.left = x;
		x.parent = y;
	}
	
	/**
	 * rotates right to balance the tree
	 * 
	 * @param x
	 */
	private void rightRotate(BSTNode<T> x) {
		//step 1
		BSTNode<T> y = x.left;
		x.left = y.right;
		if(y.right != null) {
			y.right.parent = x;
		}
		//step 2
		y.parent = x.parent;
		if(x.parent == null) {
			this.root = y;
		}else if(x == x.parent.right) {
			x.parent.right = y;
		}else {
			x.parent.left = y;
		}
		//step 3
		y.right = x;
		x.parent = y;

	}
	
	/**
	 * balances the tree by moving selected element to the root.
	 * @param node
	 */
	private void splay(BSTNode<T> node) {
		while(node != this.root) {
			//check for near the root
			if(node.parent.left != null && node.parent.left == node) {
				this.rightRotate(node.parent);
				continue;
			}
			if(node.parent.right != null && node.parent.right == node) {
				this.leftRotate(node.parent);
				continue;
			}
			//left left case
			if(node.parent.left == node && node.parent.parent.left == node.parent) {
				this.rightRotate(node.parent.parent);
				this.rightRotate(node.parent);
				continue;
			}
			//right right case
			if(node.parent.right == node && node.parent.parent.right == node.parent) {
				this.leftRotate(node.parent.parent);
				this.leftRotate(node.parent);
				continue;
			}
			//left right case
			if(node.parent.right == node && node.parent.parent.left == node.parent) {
				this.leftRotate(node.parent);
				this.rightRotate(node.parent);
				continue;
			}
			//right left case
			if(node.parent.left == node && node.parent.parent.right == node.parent) {
				this.rightRotate(node.parent);
				this.leftRotate(node.parent);
				continue;
			}
		}
	}


}
