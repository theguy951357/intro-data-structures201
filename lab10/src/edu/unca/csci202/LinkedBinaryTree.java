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
public class LinkedBinaryTree<T> implements BinaryTreeADT<T> {

	/**
	 * A private node class for the tree
	 * @author cblah
	 *
	 * @param <T>
	 */
	private class BinaryTreeNode<T>{
		//instance vars
		private T data;
		private BinaryTreeNode<T> left;
		private BinaryTreeNode<T> right;
		
		/**
		 * Constructor that sets the left and right nodes with the data
		 * @param data
		 * @param left
		 * @param right
		 */
		public BinaryTreeNode(T data,BinaryTreeNode<T> left,BinaryTreeNode<T> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		/**
		 * Constructor that just sets the data
		 * @param data
		 */
		public BinaryTreeNode(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
		/**
		 * getter for the data
		 * @return the data
		 */
		public T getData() {
			return data;
		}
		/**
		 * setter for the data
		 * @param data the data to set
		 */
		public void setData(T data) {
			this.data = data;
		}
		/**
		 * getter for the left node
		 * @return the left
		 */
		public BinaryTreeNode<T> getLeft() {
			return left;
		}
		/**
		 * setter for the left node
		 * @param left the left to set
		 */
		public void setLeft(BinaryTreeNode<T> left) {
			this.left = left;
		}
		/**
		 * getter for the right node
		 * @return the right
		 */
		public BinaryTreeNode<T> getRight() {
			return right;
		}
		/**
		 * setter for the right node
		 * @param right the right to set
		 */
		public void setRight(BinaryTreeNode<T> right) {
			this.right = right;
		}
		
		//count method
		/**
		 * count method for the tree
		 * @return the total number of children in the tree
		 */
		public int numChildren() {
			int total = 0;
			//recurse left
			if(this.left != null) {
				total = 1 + left.numChildren();
			}
			//recurse right
			if(this.right != null) {
				total = total + 1 + right.numChildren();
			}
			return total;
		}
	}
	
	//instance vars
	BinaryTreeNode<T> root;
	//+++++++++++++++++++++++++++++++
	/**
	 * Contstructor that sets the left and right and the data
	 * @param data
	 * @param left
	 * @param right
	 */
	public LinkedBinaryTree(T data, LinkedBinaryTree<T> left, LinkedBinaryTree<T> right) {
		this.root = new BinaryTreeNode(data);
		if(left!= null) {
			this.root.setLeft(left.getRootNode());
		}
		if(right!= null) {
			this.root.setRight(right.getRootNode());
		}
	}
	
	/**
	 * constructor that just sets the data
	 * @param data
	 */
	public LinkedBinaryTree(T data ) {
		this.root = new BinaryTreeNode(data);
	}
	
	/**
	 * default constructor
	 */
	public LinkedBinaryTree() {
		this.root = null;
	}
	
	//++++++++++++++++++++++++++++++++++++++
	/**
	 *toString method calls the print method
	 */
	public String toString() {
		return print(this.root,0);
	}
	
	/**
	 * print recursively calls itself to print out the tree
	 * @param node
	 * @param level
	 * @return returns the string representtion of the tree
	 */
	private String print(BinaryTreeNode<T> node, int level) {
		String ret = "";
		if(node!=null) {
			for(int i = 0; i < level; i++) {
				ret += "\t";
			}
			ret += node.getData();
			ret += "\n";
			ret += this.print(node.getLeft(), level+1);
			ret += this.print(node.getRight(), level+1);
		}
		return ret;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++
	/**
	 * getter for the root node
	 * @return the root node
	 */
	public BinaryTreeNode<T> getRootNode(){
		return this.root;
	}
	
	
	
	/**
	 *getter for the element of the root node
	 *@return either the root node's element or null
	 */
	@Override
	public T getRootElement() {
		// TODO Auto-generated method stub
		if(this.root == null) {
			return null;
		}else {
			return this.root.getData();
		}
	}

	/**
	 *method to check if the tree is empty
	 *@return true if empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (this.root==null);
	}

	/**
	 *Method to get the size of the tree
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		if(this.isEmpty()) {
			return 0;
		}
		return this.root.numChildren()+1;
	}

	/**
	 *method to check if the tree contains the given element
	 */
	@Override
	public boolean contains(T targetElement) {
		// TODO Auto-generated method stub
		T temp = this.find(targetElement);
		return (temp != null);
	}

	/**
	 *find calls the find_sub method
	 */
	@Override
	public T find(T targetElement) {
		// TODO Auto-generated method stub
		
		return this.find_sub(this.root, targetElement);
	}
	
	/**
	 * method recursively searches through the tree to find the given element
	 * @param node
	 * @param targetElement
	 * @return the data of the node containing the given element, or null if not there
	 */
	private T find_sub(BinaryTreeNode<T> node, T targetElement) {
		if(node.getData().equals(targetElement)) {
			return node.getData();
		}
		T tmp;
		if(node.getLeft() != null) {
			tmp= this.find_sub(node.getLeft(), targetElement);
			if(tmp != null) {
				return tmp;
			}
		}
		if(node.getRight() != null) {
			tmp= this.find_sub(node.getRight(), targetElement);
			if(tmp != null) {
				return tmp;
			}
		}
		return null;
	}

	/**
	 *default iterator calls the preorder iterator
	 */
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		
		return this.iteratorPreOrder();
	}

	/**
	 *iteratorInOrder traverses through the tree in order
	 */
	@Override
	public Iterator<T> iteratorInOrder() {
		// TODO Auto-generated method stub
		LinkedList<T> list = new LinkedList<T>();
		this.traverseInOrder(this.root, list);
		return list.iterator();
	}
	
	/**
	 * traverses the tree in order
	 * @param node
	 * @param list
	 */
	private void traverseInOrder(BinaryTreeNode<T> node, LinkedList<T> list) {
			if(node != null) {
				//recurse left
				this.traverseInOrder(node.getLeft(), list);
				//visit node
				list.add(node.getData());
				//recurse right
				this.traverseInOrder(node.getRight(), list);
			}
	}
	
	

	/**
	 *preorder calls traversePreOrder
	 */
	@Override
	public Iterator<T> iteratorPreOrder() {
		LinkedList<T> list = new LinkedList<T>();
		this.traversePreOrder(this.root, list);
		return list.iterator();
	}

	/**
	 * traverses the tree in preorder
	 * @param node
	 * @param list
	 */
	private void traversePreOrder(BinaryTreeNode<T> node, LinkedList<T> list) {
		// TODO Auto-generated method stub
		if(node!=null) {
			//visit node
			list.add(node.getData());
			//left
			this.traversePreOrder(node.getLeft(), list);
			//right
			this.traversePreOrder(node.getRight(), list);
		}
		
	}

	/**
	 *iteratorpostorder calls traversepostorder
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
	private void traversePostOrder(BinaryTreeNode<T> node, LinkedList<T> list) {
		// TODO Auto-generated method stub
		if(node!= null) {
			//left
			this.traversePostOrder(node.getLeft(), list);
			//right
			this.traversePostOrder(node.getRight(), list);
			//visit node
			list.add(node.getData());
		}
	}

	/**
	 *method traverses breadth first through the tree
	 */
	@Override
	public Iterator<T> iteratorLevelOrder() {
		LinkedList<T> list = new LinkedList<T>();
		Queue<BinaryTreeNode<T>> work = new ArrayDeque<BinaryTreeNode<T>>();
		work.add(this.root);//start at the root

		while(!work.isEmpty()) {
			BinaryTreeNode<T> node = work.remove();//pop the first
			list.add(node.getData());
			
			if(node.getLeft()!= null) {
				work.add(node.getLeft());
			}
			if(node.getRight()!= null) {
				work.add(node.getRight());
			}
		}
		return list.iterator();
	}
	
	

}
