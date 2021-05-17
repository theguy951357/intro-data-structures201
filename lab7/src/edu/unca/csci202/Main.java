package edu.unca.csci202;

import java.util.NoSuchElementException;
/**
 * @author Brian Drawert
 * @date Sep 23, 2020
 * Lab 7 main class
 */
public class Main {

	public static void main(String[] args) {
        testOrderedList();
        testUnorderedList();
	}
    
    private static void testOrderedList(){
        OrderedListADT<String> list = new LinkedOrderedList<String>();
        
        char[] alphabet = {
        'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n', 'm', 'l', 'k', 'j', 'i', 'h', 
        'g', 'f', 'e', 'd', 'c', 'b', 'a', 'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R', 'Q', 'P', 'O', 
        'N', 'M', 'L', 'K', 'J', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A'
        };
        
        for (int i=0; i < alphabet.length; i++){
            String l = Character.toString(alphabet[i]);
            System.out.print(l);
            list.add(l);
        }
        System.out.println();
        System.out.println(list);
        System.out.println(list.size());
        try {
            list.removeFirst();
            list.removeFirst();
            list.removeLast();
            list.removeLast();
            list.remove("a");
            list.remove("b");
            list.remove("A");
        }catch(NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(list);
        System.out.println(list.size());
    }
    
    private static void testUnorderedList(){
        UnorderedListADT<String> list = new LinkedUnorderedList<String>();

        char[] alphabet = {
        'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n', 'm', 'l', 'k', 'j', 'i', 'h', 
        'g', 'f', 'e', 'd', 'c', 'b', 'a', 'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R', 'Q', 'P', 'O', 
        'N', 'M', 'L', 'K', 'J', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A'
        };
        
        for (int i=0; i < alphabet.length; i++){
            String l = Character.toString(alphabet[i]);
            System.out.print(l);
            if(i%2==0) {
            	list.addToFront(l);
            }else {
            	list.addToRear(l);
            }
        }
        list.addAfter("*", "a");
        list.addAfter("!", "Z");
        System.out.println();
        System.out.println(list);
        System.out.println(list.size());
        try {
            list.removeFirst();
            list.removeFirst();
            list.removeLast();
            list.removeLast();
            list.remove("a");
            list.remove("b");
            list.remove("A");
        }catch(NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(list);
        System.out.println(list.size());
        
    }

}
