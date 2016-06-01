/**
* <h1>Trie</h1>
* A simple implementation of a trie with
* insert and delete methods.
* 
* @author  Justin Tumale
* @version 1.0
* @since   2016-06-01 
*/
package trie;
import java.util.*;

public class Trie {

	public static class TrieNode{
		Map<Character, TrieNode> map;
		boolean endOfWord;
		public TrieNode(){
			this.map = new HashMap<Character, TrieNode>();
			this.endOfWord = false;
		}
	}
	/**
	 * Inserts a string into the trie.  The root argument is the root
	 * node of the trie that must be instantiated in the main method.
	 *
	 * @param  input  the string to be inserted into the trie
	 * @param  root   the root node of the trie
	 */
	public static void insert(String input, TrieNode root){
		Character currentChar = null;
		for (int i = 0; i < input.length(); i++){
			currentChar = input.charAt(i);
			if (root.map.containsKey(currentChar)){
				root = root.map.get(currentChar);
			}else{
				TrieNode newTrieNode = new TrieNode();
				root.map.put(currentChar, newTrieNode);
				root = root.map.get(currentChar);
			}
		}
		root.endOfWord = true;
	}
	/**
	 * Deletes a string from the trie.  The root of the trie must 
	 * be instantiated in the main method.
	 *
	 * @param  input  the string to be deleted from the trie
	 * @param  root   the root node of the trie
	 */
	public static boolean delete(String input, TrieNode root){
		return delete(input, root, 0);
	}
	/**
	 * Helper method for deleting a string from the trie.
	 *
	 * @param  input  the string to be deleted from the trie
	 * @param  root   the root node of the trie
	 * @param  index  the index of character from the string to delete
	 */
	private static boolean delete(String input, TrieNode root, int index){
		if (root == null){ return false; }
		if (index == input.length()){ return false; }
		Character currentChar = input.charAt(index);
		TrieNode nextNode = root.map.get(currentChar);
		if (delete(input, nextNode, index+1)){ 
			return true;
		}else{
			root.map.remove(currentChar);
			if (root.map.isEmpty()){
				return false;
			}else{
				return true;
			}
		}
	}

	/**
	 * Prints the entire trie along with the levels that each character is
	 * in.
	 *
	 * @param  root   the root node of the trie
	 * @param  level  the level that the character is in
	 */
	public static void printTrie(TrieNode root, int level){
		for (Map.Entry<Character, TrieNode> entry : root.map.entrySet()){
			System.out.println(" Level: " + level + " Character: " + entry.getKey() 
				 + " End of word: " + root.endOfWord );
			printTrie(entry.getValue(), level+1);
		}
		if (root.map.isEmpty()){
			System.out.println(" Level: " + (level+1) + " Character: " +"\'\'" 
			 + " End of word: " + root.endOfWord );
		}
	}
	
	public static void main(String[]args){
		TrieNode root = new TrieNode();
		/*Insert "hello"*/
		insert("hello", root);
		printTrie(root, 0);
		System.out.println();
		
		/*Insert "helicopter"*/
		insert("helicopter", root);
		printTrie(root, 0);
		System.out.println();
		
		/*Delete "helicopter"*/
		delete("helicopter", root);
		printTrie(root, 0);
		System.out.println();
	}
	
}
