package edu.unca.csci202;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		
		LinkedBinaryTree<String> t1 = makeTree1();
		System.out.println(t1);
		treeIterationTests(t1);
		System.out.println("Find D: "+t1.find("D") + " contains: "+t1.contains("D"));
		System.out.println("Find Z: "+t1.find("Z")+ " contains: "+t1.contains("Z"));
		System.out.println();
		
		
		LinkedBinaryTree<String> t2 = makeTree2();
		System.out.println(t2);
		treeIterationTests(t2);
		System.out.println("Find 9: "+t1.find("9") + " contains: "+t2.contains("9"));
		System.out.println("Find -1: "+t1.find("-1")+ " contains: "+t2.contains("-1"));
		System.out.println();
		
		
	}
	
	private static LinkedBinaryTree<String> makeTree1() {
		// Make the leaves
		LinkedBinaryTree<String> D = new LinkedBinaryTree<String>("D");
		LinkedBinaryTree<String> E = new LinkedBinaryTree<String>("E");
		LinkedBinaryTree<String> C = new LinkedBinaryTree<String>("C");

		// make sub-tree
		LinkedBinaryTree<String> B = new LinkedBinaryTree<String>("B", D, E);

		// make the root tree
		LinkedBinaryTree<String> A = new LinkedBinaryTree<String>("A", B, C);

		return A;		
	}
	
	private static LinkedBinaryTree<String> makeTree2() {
		return new LinkedBinaryTree<String>("13",
			new LinkedBinaryTree<String>("7",
				new LinkedBinaryTree<String>("4",
					new LinkedBinaryTree<String>("2"),
					null),
				new LinkedBinaryTree<String>("10",
					new LinkedBinaryTree<String>("9"),
					new LinkedBinaryTree<String>("12")
				)
			),
			new LinkedBinaryTree<String>("24",
				new LinkedBinaryTree<String>("18",
					null,
					new LinkedBinaryTree<String>("21",
						null,
						new LinkedBinaryTree<String>("22") 
					)
				),
				new LinkedBinaryTree<String>("37")
			)
		);

	}
	
	
	private static void treeIterationTests(LinkedBinaryTree<String> t) {
		try {
			System.out.print("PreOrder: ");
			Iterator<String> itr = t.iteratorPreOrder();
			while(itr.hasNext()) {
				System.out.print(itr.next() + " ");
			}
			System.out.println();
		}catch(Exception e) {
			System.out.println("Need to implement preorder iterator.");
		}

		try {
			System.out.print("InOrder: ");
			Iterator<String> itr = t.iteratorInOrder();
			while(itr.hasNext()) {
				System.out.print(itr.next() + " ");
			}
			System.out.println();
		}catch(Exception e) {
			System.out.println("Need to implement inorder iterator.");
		}

		try {
			System.out.print("PostOrder: ");
			Iterator<String> itr = t.iteratorPostOrder();
			while(itr.hasNext()) {
				System.out.print(itr.next() + " ");
			}
			System.out.println();
		}catch(Exception e) {
			System.out.println("Need to implement postorder iterator.");
		}
		try {
			System.out.print("Level-Order: ");
			Iterator<String> itr = t.iteratorLevelOrder();
			while(itr.hasNext()) {
				System.out.print(itr.next() + " ");
			}
			System.out.println();
		}catch(Exception e) {
			System.out.println("Need to implement levelorder iterator.");
		}
		
		if( ! t.contains( t.getRootElement() ) ) {
			System.out.println("Need to implement contains.");
		}
		
		if( t.find( t.getRootElement() ) != t.getRootElement() ) {
			System.out.println("Need to implement find.");
		}	}

}
