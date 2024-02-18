import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/*
The number of words read from the dictionary file
The first word alphabetically
The last word alphabetically
The longest word
The word with the most vowels
The word that ends with the most vowels
The longest word that ends with "zz"
The longest word that ends with "ff"
*/
public class wordsMain {   
    public static void main(String args[]) throws FileNotFoundException, IOException 
    {
    	ArrayList<String> words = new ArrayList<String>();  
    	try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ivanl\\eclipse-workspace\\10000wordsMain\\src\\google-10000-english.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
            //add to Array List
                words.add(line);
            }
    	}    
    	//now sort List
        Collections.sort(words);
        
        //size of the list
    	int numWords = words.size();
    	System.out.println("The number of words in the file is " + numWords);
    	
    	//now for first and last
    	String firstword = words.get(0);
    	String lastword = words.get(words.size() - 1);
    	
    	System.out.println("The first word of the list is " + firstword);
    	System.out.println("The last word of the list is " + lastword);
    	
    	//now for the longest word get().length and iterate through list
    	//set the first word in the list as longest then iterate from there
    	String longestword = words.get(0);
    	for (int i = 1; i < words.size(); i++) {
    		if (words.get(i).length() > longestword.length()) {
    			longestword = words.get(i);
    		}
    	}
    	System.out.println("The longest word of the list is " + longestword);
    	
    	//vowels and consonants will be fairly similar just set count to 0 and 
    	//iterate over list and set new vowel count as we iterate save highest word
    	String vowelword = ("");
    	int vowelcount = 0;
    	//itterate over the list and count vowels
    	for (int i = 0; i < words.size(); i++) {
    		int count = words.get(i).split("[aeiou]", -1).length;
    		if (count > vowelcount) {
    			vowelword = words.get(i);
    			vowelcount = count;
    		}
    	}
    	
    	System.out.println("The word with the most vowels is " + vowelword);
    	
    	//for consonants its basically the same thing just checking non vowels
    	String consonantword = ("");
    	int consonantscount = 0;
    	//itterate over the list and count non vowels
    	for (int i = 0; i < words.size(); i++) {
    		int count = words.get(i).split("[bcdfghjklmnpqrstvwxyz]", -1).length;
    		if (count > consonantscount) {
    			consonantword = words.get(i);
    			consonantscount = count;
    		}
    	}
    	
    	System.out.println("The word with the most consonants is " + consonantword);
    	
    	//for word with most vowels at the end we word iterate through list
    	//then start at the end of every word and work backwards using words.get.length
    	String consecvowels = ("");
    	final String VOWELS = "aeiou";
    	int vowels = 0;
    	for (int i = 0; i < words.size(); i++) {
    		int curVowels = 0;
    		//dont forget index starts at 0 so minus 1 is necessary you dunce
    		for (int j = words.get(i).length() - 1; j > 0; j--) {
    			if (VOWELS.indexOf(words.get(i).charAt(j)) >= 0) {
    				curVowels++; 
    				break;
    			}
    		}
    		if (curVowels > vowels) {
    			consecvowels = words.get(i);
    			vowels = curVowels;
    		}
    	}
    	
    	System.out.println("The word with the most vowels at the end is " + consecvowels);
    	
    	//for checking zz and ff basically the same concept as above
    	
    	String ffword = ("");
    	final String theletterf = "f";
    	// the only difference is if two words both have the same endings 
    	// then just compare length and make the larger of the two the main word
    	for (int i = 0; i < words.size(); i++) {
    		String currentWord = words.get(i);
    		for ( int j = words.get(i).length() - 1; j > 0; j--) {
    			if ( j < words.get(i).length() - 1) {
    				break;
    			}
    			if (theletterf.indexOf(words.get(i).charAt(j))>= 0) {
    				if (theletterf.indexOf(words.get(i).charAt(j - 1))>= 0)
    					if ( currentWord.length() > ffword.length()) {
    						ffword = currentWord;
    					}
    					else {
    						break;
    				}

    			}
    		}
    	}
    	
    	System.out.println("The longest word with ff at the end is " + ffword);
    	
    	String zzword = ("");
    	final String theletterz = "z";
    	// the only difference is if two words both have the same endings 
    	// then just compare length and make the larger of the two the main word
    	for (int i = 0; i < words.size(); i++) {
    		String currentWord = words.get(i);
    		for ( int j = words.get(i).length() - 1; j > 0; j--) {
    			if ( j < words.get(i).length() - 1) {
    				break;
    			}
    			if (theletterz.indexOf(words.get(i).charAt(j))>= 0) {
    				if (theletterz.indexOf(words.get(i).charAt(j - 1))>= 0)
    					if ( currentWord.length() > zzword.length()) {
    						zzword = currentWord;
    					}
    					else {
    						break;
    				}

    			}
    		}
    	}
    	
    	System.out.println("The longest word with zz at the end is " + zzword);
    }
}



    




