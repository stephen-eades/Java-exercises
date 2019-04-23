package mypackage;
import java.util.Scanner;

public class typeTeller {

	public static void main(String[] args) {

		// Variables
		Scanner in = new Scanner(System.in);
		String userString = "string"; // string or trash
		int userInt = 0;
		double userDouble = 0.00;
		
			// Get "stuff"
			System.out.println("Please enter stuff: ");
			
				// Process "stuff"
				if (in.hasNextInt()) // check as int
				{
					userInt = in.nextInt();
					System.out.println("You entered and int of: " + userInt);
				}
				else if (in.hasNextDouble()) // check as Double
				{
					userDouble = in.nextDouble();
					System.out.println("You entered a double of: " + userDouble);
				}
				else // process as String
				{
					userString = in.nextLine();
					System.out.println("You entered a string of: " + userString);
				}
		
		in.close(); // Closing scanner resource
	}

}
