package mypackage;

import java.util.Scanner;

public class compareInput 
{

	public static void main(String[] args) 
        {
		
		// Variables
		Scanner in = new Scanner(System.in);
		String trash = "";
		double userNumberA = 0;
		double userNumberB = 0;
		
			// Get number A using hasNextDouble
			System.out.println("Enter the first number: ");
				if(in.hasNextDouble())
				{
				    	// Get width from user and clear the newline from the buffer
				   	userNumberA = in.nextDouble(); 
					System.out.println("The first number you entered was: " + userNumberA);
				    	in.nextLine();
				}
				else
				{ 
				   	// Not a double, so can’t use nextDouble(). Instead read as String with nextLine()
				   	trash = in.nextLine();
				   	System.out.println("\nYou said your number was: " + trash);
				   	System.out.println("Run the program again and enter a valid number!");
				   	System.exit(0);
				}
		
			// Get number B using hasNextDouble
			System.out.println("Enter the second number: ");
				if(in.hasNextDouble())
				{
				    	// Get height from user and clear the newline from the buffer
				    	userNumberB = in.nextDouble(); 
					System.out.println("The second number you entered was: " + userNumberB); // echo
				}
				else
				{ 
				   	// Not a double, so can’t use nextDouble(). Instead read as String with nextLine()
				   	trash = in.nextLine();
				   	System.out.println("\nYou said your number was: " + trash);
				   	System.out.println("Run the program again and enter a valid number!");
				   	System.exit(0);  // terminate the program
				}
		
				// Process numbers
				if (userNumberA == userNumberB)
				{
					System.out.println(userNumberA + " is equal to " + userNumberB);
				}
				else if (userNumberA > userNumberB)
				{
					System.out.println(userNumberB + " is less than " + userNumberA);
				}
				else if (userNumberA < userNumberB)
				{
					System.out.println(userNumberA + " is less than " + userNumberB);
				}
				else
				{
					System.out.println("Error, please enter valid numbers and try again.");
				}
				
		in.close(); // Closing scanner resource
	}

}
