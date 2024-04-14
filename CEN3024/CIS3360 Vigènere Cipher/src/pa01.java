/*=============================================================================
| Assignment: pa01 - Encrypting a plaintext file using the Vigenere cipher
|
| Author: Ivan Lewis
| Language: c, c++, Java, go, python
|
| To Compile: javac pa01.java
| gcc -o pa01 pa01.c
| g++ -o pa01 pa01.cpp
| go build pa01.go
| python pa01.py
|
| To Execute: java -> java pa01 kX.txt pX.txt
| or c++ -> ./pa01 kX.txt pX.txt
| or c -> ./pa01 kX.txt pX.txt
| or go -> ./pa01 kX.txt pX.txt
| or python -> python pa01.py kX.txt pX.txt
| where kX.txt is the keytext file
| and pX.txt is plaintext file
|
| Note: All input files are simple 8 bit ASCII input
|
| Class: CIS3360 - Security in Computing - Fall 2022
| Instructor: McAlpin
| Due Date: per assignment
|
+=============================================================================*/


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class pa01 {

	public static void main(String[] args) {
		
		String keyFile = args[0];
		String plainText = args[1];
		String keyInput = null;
		String plainInput = null;
		
		try {
			keyInput = readFile(keyFile);
		
			plainInput = readFile(plainText);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//remove all the spaces and quotes and stuff
		// holy fuck found it String newString = aString.replaceAll("[^a-z]","");
		keyInput = keyInput.toLowerCase().replaceAll("[^a-z]", "");
		plainInput = plainInput.toLowerCase().replaceAll("[^a-z]", "");
		
		String parsedKeyInput = keyInput.replaceAll("(.{100})", "$1\n");
		String parsedPlainInput = keyInput.replaceAll("(.{100})", "$1\n");
		
		
		System.out.println(parsedKeyInput);
		System.out.println(parsedPlainInput);
		
		//need lengths of the file after removing the bullshit
		int keyLength = keyInput.length();
		int plainLength = plainInput.length();
		int padWithX;
		
	/*if (a > b) {
    	result = x;
	} else {
    	result = y;
	}
	This can be rewritten as the following statement:

	result = a > b ? x : y;
	 */
		padWithX = plainLength < 512 ? keyLength - (plainLength % keyLength): 0;
		
	// make a function that adds the number of x dependant on this number
	// make a function that adds the number of x dependant on this number
	// make a function that adds the number of x dependant on this number
	// make a function that adds the number of x dependant on this number
	// make a function that adds the number of x dependant on this number
		
	//use char arrays to store the plaintext key and jumbled text 	
		
		char[] plainTextFinal = fillText(plainLength, plainInput, padWithX != 0, padWithX);
		char[] keyFinal = fillText(keyLength, keyInput, false, 0);
		char[] codedFinal = supersecret(plainTextFinal, keyFinal);
		
		
		//NOW PRINT ALL THE THINGS
		
		System.out.printf("\n\nPlaintext:\n\n%s\n", returnedString(plainTextFinal));

        System.out.printf("\n\nVigenere Key:\n\n%s\n", returnedString(keyFinal));
        
        System.out.printf("\n\nCiphertext:\n\n%s\n", returnedString(codedFinal));
	}

	
	
	private static String readFile(String File) throws IOException {
		
		return new String(Files.readAllBytes(Paths.get(File)));
	}
	
	private static char[] fillText(int length, String text, boolean padding, int howManyX) {
		
		char[] tempArr = new char [length > 512 || padding ? 512 : length];
		int paddingX = 0;
		for (int i = 0; i < (padding ? text.length() : tempArr.length); i++){
			tempArr[i] = text.charAt(i);
			paddingX++;
		}
		
		if (padding) {
			for (int i = paddingX, j = 1; i < tempArr.length; i++, j++){
				tempArr[i] = (j > howManyX ? ' ' : 'x');
			}
		}
		
		
		return tempArr;
	
	}
	
	// the main thing for encryption is making sure the askii value
	// is 97
	// used % 26 for alpha keys you shithead
	
	private static char[] supersecret(char[] text, char [] key) {
		
		char[] temp = new char[text.length];
		
		for(int i = 0; i < temp.length; i++) {
			if(text[i] == ' ') {
				break;
			}
			
			int textnum = (int) text[i] - 97;
			int keynum = (int)key[i % key.length] - 97;
			int j = (textnum + keynum) % 26;
			char newChar = (char) (j + 97);
			temp[i] = newChar;
			
		}
		return temp;
		
	}
	
	//how to format message so its only 80 chars a line
	
	//FINALLY
	
	private static String returnedString(char[] array) {
		StringBuilder finalText = new StringBuilder();
		for (int i = 0; i < array.length; i++) {
			if (array[i] == ' ' || array[i] == '\u0000') {
				break;
			}
			
			if (i > 0 && i % 80 == 0) {
				finalText.append("\n");
			}
			
			finalText.append(array[i]);
			
		}
		return finalText.toString().toLowerCase();
	}
}


/*=============================================================================
| I Ivan Lewis (IV660581) affirm that this program is
| entirely my own work and that I have neither developed my code together with
| any another person, nor copied any code from any other person, nor permitted
| my code to be copied or otherwise used by any other person, nor have I
| copied, modified, or otherwise used programs created by others. I acknowledge
| that any violation of the above terms will be treated as academic dishonesty.
+=============================================================================*/