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
		for (int i = 0; i < input.length(); i++){
			Character currentChar = input.charAt(i);
			if (root.map.containsKey(currentChar)){
				root = root.map.get(currentChar);
			}else{
				TrieNode newTrieNode = new TrieNode();
				root.map.put(currentChar, newTrieNode);
				root = root.map.get(currentChar);
			}
			root.endOfWord = true;
		}
		
	}
	public static void delete(String input, TrieNode root){
		
	}
	
	public static void printTrie(TrieNode root, int level){
		for (Map.Entry<Character, TrieNode> entry : root.map.entrySet()){
			System.out.println("Character: " + entry.getKey() + " Level: " + level );
			printTrie(entry.getValue(), level+1);
		}
	}
	
	public static void main(String[]args){
		TrieNode root = new TrieNode();
		insert("hello", root);
		printTrie(root, 0);
	}
	
}
