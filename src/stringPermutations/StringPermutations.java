/**
* <h1>String Permutations</h1>
* This program takes in a string for its input and then prints out
* all of its possible permutations.
* 
* @author  Justin Tumale
* @version 1.0
* @since   2016-06-01 
*/
package stringPermutations;
import java.util.*;

public class StringPermutations {
	//1. Create an output array of size n
	//2. Create an index variable to keep track of the recursion level
	//3. Create a hashmap to keep track of the occurences of each character in the string
	//4. Find the next character in the string whos count is greater than 0
	//5. Insert that character into output array at the index corresponding to current level
	//	 of recursion
	//6. Call the recursive function, passing in index+1 into its arguments
	//7. If index == string.length; print
	//8. After the recursion, restore the count of the current character
	//9. Go back to step 4, until there are no more available characters
	public static void findPermutations(String input){
		System.out.println("Finding permutations for the string \"" + input + "\":" );
		int[]results = new int[input.length()];
		TreeMap<Character, Integer> characterOccurences = new TreeMap<Character, Integer>();
		for (int i = 0; i < input.length(); i++){
			char characterOfInput = input.charAt(i);
			if (characterOccurences.containsKey(characterOfInput)){
				int occurences = characterOccurences.get(characterOfInput);
				occurences +=1;
				characterOccurences.put(characterOfInput, occurences);
			}else{
				characterOccurences.put(characterOfInput, 1);
			}
		}
		char[]charactersArray = new char[characterOccurences.size()];
		int[]characterOccurencesArray = new int[characterOccurences.size()];
		int index = 0;
		for (Map.Entry<Character, Integer> entry : characterOccurences.entrySet()){
			charactersArray[index] = entry.getKey();
			characterOccurencesArray[index] = entry.getValue();
			index++;
		}
	}
	
	public static void findPermutationsHelper(String input, char[]charactersArray, 
				int[]characterOccurencesArray, int level){
		//TODO Helper method for finding the permutations
	}
	
	public static void main(String[]args){
		System.out.println("Please enter a string");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		findPermutations(input);
	}
	
}
