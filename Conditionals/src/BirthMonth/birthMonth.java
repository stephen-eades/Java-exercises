package mypackage;

import java.util.Scanner;

public class birthMonth 
{

	public static void main(String[] args) 
	{
		// Variables
		Scanner in = new Scanner(System.in);
		int userBirthMonth = 0;
		String trash = "";
		
			// Prompt and check for an int
			System.out.println("Please enter your birth month (1-12)");
			if(in.hasNextInt())
			{
				// if int, assign to var
			    	userBirthMonth = in.nextInt(); 
				
					// test if number is in range 1-12
					if (userBirthMonth >= 1 && userBirthMonth <= 12)
					{
						System.out.println("Your birth month is: " + userBirthMonth);
						System.exit(0);
					}
					else
					{
					   	System.out.println("You entered an incorrect month value: " + userBirthMonth);
					    	System.out.println("Please restart and use a number between 1-12 inclusive");
						System.exit(0);
					}
			}
			else
			{ 
				// Not in, can’t use nextInt() so read as String with nextLine() instead
			  	 trash = in.nextLine();
			   	 System.out.println("\nYou said your birth month was: " + trash);
			  	 System.out.println("Run the program again and enter a valid month number (1-12)!");
			  	 System.exit(0);  // terminate the program
			}
		
		// Closing scanner resource
		in.close();
	}

}
