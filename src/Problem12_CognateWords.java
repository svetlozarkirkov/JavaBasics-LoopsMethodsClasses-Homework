import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Problem12_CognateWords {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();  // keeping the whole input line into a string
		String[] split = line.split("[^a-zA-Z]");  // split the input string using regex that leaves only words
		ArrayList<String> collection = new ArrayList<String>(Arrays.asList(split)); // converts the string array into arraylist
		ArrayList<String> kept = new ArrayList<String>(); // found results will be kept here so that they won't be used more than once
		boolean found = false;  // if we find a valid result this will turn true
		for (int i = 0; i < collection.size(); i++){  // iterating through every word
			if (collection.get(i).length()!=0){ // if it is not empty
				for(int j = i+1; j < collection.size();j++){  // iterating through the remaining words
					if (collection.get(j).length()!=0){ // if it is not empty
						if (collection.contains(collection.get(i)+collection.get(j)) &&  // checks if the word that is made using the word at index "i" plus the word at index "j" is contained within the collection
								!kept.contains(collection.get(i)+collection.get(j))){    // and if this made word is not yet used (is not in "kept")
							System.out.println(collection.get(i)+"|"+collection.get(j)+"="+
									collection.get(i)+collection.get(j));  // prints the three words using the needed format
							kept.add(collection.get(i)+collection.get(j));  // adding the word in "kept"
							collection.remove(collection.indexOf(collection.get(i)+collection.get(j)));  // removing the made word from "collection" so that it won't be used again
							found = true; // result is found so this becomes "true"
						}
						else if (collection.contains(collection.get(j)+collection.get(i)) &&   // everything same as above
								!kept.contains(collection.get(j)+collection.get(i))){		// difference: checks the words in reverse
							System.out.println(collection.get(j)+"|"+collection.get(i)+"="+
									collection.get(j)+collection.get(i));
							kept.add(collection.get(j)+collection.get(i));
							collection.remove(collection.indexOf(collection.get(j)+collection.get(i)));
							found=true;
						}
					}
				}
			}
		}
		if (!found){
			System.out.println("No"); // this prints if no results are found
		}
		input.close(); // :))
	}
}
