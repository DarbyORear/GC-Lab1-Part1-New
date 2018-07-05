package lab1part1;
//This program accepts user input of two numbers and determines whether corresponding digits sum to the same number. Prints true or false.

//First, import scanner object to take user input.
import java.util.Scanner;

public class GC_Lab1_Part1 {
	public static void main(String[] args) {
	
	// Define and initialize variables.
	int userNumOne	 = 0;
	int userNumTwo	 = 0;
	int modOne	     = 0;
	int modTwo	     = 0;
	int numOneLength = 0;
	int numTwoLength = 0;
	int sumMods      = 0;
	int sumModsAgain = 0;
	boolean digitsAddToSameNum = true;

	// Set up scanner.
	Scanner scnr = new Scanner(System.in);

	// Prompt user to enter a number and accept input.
	System.out.println("Please enter a number: ");
	userNumOne = scnr.nextInt();

	// Prompt user to enter second number of the same length.
	System.out.println("Please enter a second number. It must be the same length as the first number: ");
	userNumTwo = scnr.nextInt();

	// Check that the second number is the same length as the first.
	numOneLength = String.valueOf(userNumOne).length();
	numTwoLength = String.valueOf(userNumTwo).length();

	
	 /* If the second number is not the same length as the first, ask user to input another number. Repeat this 
	  * step until second number is the same length as the first.*/
	while ((numOneLength != numTwoLength)) {
		System.out.println("Second number must be same number of digits as the first number. Please enter a new number: ");
		userNumTwo = scnr.nextInt();
		numOneLength = String.valueOf(userNumOne).length();
		numTwoLength = String.valueOf(userNumTwo).length();
	}
	scnr.close();
	
	// Once user has entered two numbers of the same length, start separating out digits.
	if (numTwoLength == numOneLength) {
		
		// To separate out digits, first get % 10 (mod 10) of each number. 
		// This will separate out the last digit of each number.
		modOne = userNumOne % 10;
		modTwo = userNumTwo % 10;
		
		// Add together the two remainders (in other words, add together the last two digits). 
		// Each subsequent sum will be compared to this one.								
		sumMods = modTwo + modOne;
		
		/* Divide each number by 10. userNumOne and userNumTwo will take the decimal (not floating) value of each dividend.
		 * This will basically have the effect of removing the last digit of the number.*/
		userNumOne = userNumOne / 10;
		userNumTwo = userNumTwo / 10;
		System.out.println();
	}

	/* When the loop iterates again, the second to last digit of each number will be separated out and evaluated. This 
	 * pattern continues with each iteration.*/																		
	while ((userNumOne > 0) && (userNumTwo > 0)) {
		modOne = userNumOne % 10;
		modTwo = userNumTwo % 10;
		sumModsAgain = modTwo + modOne;
		
		// If the sum of each corresponding digit is the same as the sum of the last two digits, then the program prints "true."
		if (sumModsAgain == sumMods) {
			digitsAddToSameNum = true;
		} else {
			digitsAddToSameNum = false;
		  }
		userNumOne = userNumOne / 10;
		userNumTwo = userNumTwo / 10;
		System.out.println();		
	}

	System.out.println("Is it true that the corresponding digits of these two numbers all add up to the same number? "
					+ digitsAddToSameNum);
	System.out.println();
	}
}
