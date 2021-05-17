/**
 * 
 */
package edu.unca.csci202;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;







/**
 * A self balancing binary tree
 * 
 * @author cblah
 *
 */
public class AVLTree<T extends Comparable<T>> implements BinarySearchTreeADT<T> {

	
	/**
	 * a private node class for the tree
	 * 
	 * @author cblah
	 *
	 * @param <T>
	 */
	private class AVLNode<T>{
		private T data;
		private AVLNode<T> left;
		private AVLNode<T> right;
		private AVLNode<T> parent;
		private int height;
		
		
		/**
		 * A method that updates the height of the tree
		 */
		public void updateHeight() {
			int leftHeight = 0;
			int rightHeight = 0;
			if (this.left != null) {
				leftHeight = this.left.height;
			}
			if(this.right != null) {
				rightHeight = this.right.height;
			}
			this.height = 1 + Math.max(leftHeight, rightHeight);
		}
		
		/**
		 * a method that tells how off balance a tree would be
		 * 
		 * @return the difference between the right and left side of the tree
		 */
		public int balanceFactor() {
			int leftHeight = 0;
			int rightHeight = 0;
			if (this.left != null) {
				leftHeight = this.left.height;
			}
			if(this.right != null) {
				rightHeight = this.right.height;
			}
			
			
			return rightHeight - leftHeight;
		}
	}
	
	//instance vars
	private int size;
	private AVLNode<T> root;
	
	//constructor
	public AVLTree() {
		this.size = 0;
		this.root = null;
	}
	
	/**
	 *gets the root element
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
	 *checks for empty
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.root == null;
	}

	/**
	 *iterates in order by default
	 */
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return this.iteratorInOrder();
	}

	/**
	 *iterate in order
	 */
	@Override
	public Iterator<T> iteratorInOrder() {
		LinkedList<T> list = new LinkedList<T>();
		traverseInOrder(this.root, list);
		return list.iterator();
	}

	/**
	 * helper for iterate in order
	 * @param node
	 * @param list
	 */
	private void traverseInOrder(AVLNode<T> node, LinkedList<T> list) {
		// TODO Auto-generated method stub
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
	 *iterates in preorder
	 */
	@Override
	public Iterator<T> iteratorPreOrder() {
		// TODO Auto-generated method stub
		LinkedList<T> list = new LinkedList<T>();
		this.traversePreOrder(this.root, list);
		return list.iterator();
	}

	/**
	 * helper for pre order
	 * @param node
	 * @param list
	 */
	private void traversePreOrder(AVLNode<T> node, LinkedList<T> list) {
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
	 *iterate post order
	 */
	@Override
	public Iterator<T> iteratorPostOrder() {
		// TODO Auto-generated method stub
		LinkedList<T> list = new LinkedList<T>();
		this.traversePostOrder(this.root, list);
		return list.iterator();
	}

	/**
	 * helper for post order
	 * @param node
	 * @param list
	 */
	private void traversePostOrder(AVLNode<T> node, LinkedList<T> list) {
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
		// TODO Auto-generated method stub
		LinkedList<T> list = new LinkedList<T>();
		Queue<AVLNode<T>> work = new ArrayDeque<AVLNode<T>>();
		work.add(this.root);//start at the root

		while(!work.isEmpty()) {
			AVLNode<T> node = work.remove();//pop the first
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
	 *insert method
	 */
	@Override
	public int insert(T element) {
		// TODO Auto-generated method stub
		this.size++;
		AVLNode<T> z = new AVLNode<T>();
		z.data = element;
		z.parent = null;
		z.left = null;
		z.right = null;
		z.height = 0;
		
		AVLNode<T> x = this.root;
		AVLNode<T> y = null;
				
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
		
		// now inserted, rebalance the tree
		this.insertFix(z);
		
		return traversals;

	}
	
	/**
	 * rotates nodes to the left to balance the tree
	 * 
	 * @param x
	 */
	private void leftRotate(AVLNode<T> x) {
		//step 1
		AVLNode<T> y = x.right;
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
	private void rightRotate(AVLNode<T> x) {
		//step 1
		AVLNode<T> y = x.left;
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
	 * fixes the balance of the tree when insert is called
	 * @param x
	 */
	private void insertFix(AVLNode<T> x) {
		// TODO Auto-generated method stub
		x.updateHeight();
		while(x!= null) {
			x.updateHeight();
			int curval = x.balanceFactor();
			if(curval == -2) {
				int leftbal = x.left.balanceFactor();
				if(leftbal == -1 || leftbal == 0) {//right rotation
					this.rightRotate(x);
					x.updateHeight();
					x.parent.updateHeight();
					return; //done re-balancing
				}else if (leftbal==1) {//left-right double rotation
					this.leftRotate(x.left);
					this.rightRotate(x);
					x.updateHeight();
					x.parent.left.updateHeight();
					x.parent.updateHeight();
					return;//done re-balancing
				}
			}else if (curval == 2) {
				int rightval = x.right.balanceFactor();
				if(rightval == 1 || rightval == 0) {//left rotation
					this.leftRotate(x);
					x.updateHeight();
					x.parent.updateHeight();
					return;
				}else if(rightval == -1) {//right-left double rotation
					this.rightRotate(x.right);
					this.leftRotate(x);
					x.updateHeight();
					x.parent.right.updateHeight();
					x.parent.updateHeight();
					return;
				}
			}
			
			
			x = x.parent;
		}
		
	}

	/**
	 *gets the height of the tree
	 */
	@Override
	public int height() {
		// TODO Auto-generated method stub
		if(this.root == null) {
			return 0;
		}
		return this.root.height;
	}

	/**
	 *gets the max of the tree
	 */
	@Override
	public T maximum() {
		// TODO Auto-generated method stub
		if(this.root == null) {
			return null;
		}
		AVLNode<T> node = maximum(this.root);
		if(node != null) {
			return node.data;
		}
		return null;	
	}
	
	
	private AVLNode<T> maximum(AVLNode<T> node){
		while(node.right != null) {
			node = node.right;
		}
		return node;
	}

	/**
	 *gets the min of the tree
	 */
	@Override
	public T minimum() {
		if(this.root == null) {
			return null;
		}
		AVLNode<T> node = minimum(this.root);
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
	private AVLNode<T> minimum(AVLNode<T> node){
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
	private String print(AVLNode<T> node, int level) {
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
