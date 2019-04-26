package mypackage;
import java.util.Scanner;

public class birthMonth 
{

	public static void main(String[] args) 
	{
		
		// Variables
		Scanner in = new Scanner(System.in);
		int userBirthMonth = 0;
		String trash = ""; // use for bad input which will read as a String
		
			// Prompt and input
			System.out.println("Please enter your birth month (1-12)");
			if(in.hasNextInt()) // OK safe to read in an Int
			{
			    // Get birth month
			    userBirthMonth = in.nextInt(); 
				
					if (userBirthMonth >= 1 && userBirthMonth <= 12)// test if number is in range 1-12
					{
						System.out.println("Your birth month is: " + userBirthMonth); // echo
						System.exit(0);  // terminate the program
					}
					else
					{
					    System.out.println("You entered an incorrect month value: " + userBirthMonth); // echo
					    System.out.println("Please restart and use a number between 1-12 inclusive");
						System.exit(0);  // terminate the program
					}
			}
			else
			{ 
			   // Not an int can’t use nextInt() read as String with nextLine() instead
			   trash = in.nextLine();
			   System.out.println("\nYou said your birth month was: " + trash);
			   System.out.println("Run the program again and enter a valid month number (1-12)!");
			   System.exit(0);  // terminate the program
			}
			
		in.close();	// Closing scanner resource
	}

}
