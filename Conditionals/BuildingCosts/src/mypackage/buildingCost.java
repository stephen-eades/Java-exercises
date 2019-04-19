package mypackage;
import java.util.Scanner;

public class buildingCost {

	public static void main(String[] args) {
		
		// Variables
		Scanner in = new Scanner(System.in);
		String trash = ""; // trash input
		double height = 0;
		double width = 0;
		double costPerSqFt = 0;
		double area = 0;
		double totalCost = 0;

			// Prompt for width
			System.out.println("Enter the width: ");
				if(in.hasNextDouble()) // OK safe to read in a double
				{
				    // Get width from user
				    width = in.nextDouble(); 
					System.out.println("The width you entered was: " + width); // echo
				}
				else
				{ 
				   // Not a double can’t use nextDouble() read as String with nextLine() instead
				   trash = in.nextLine();
				   System.out.println("\nYou said your width was: " + trash);
				   System.out.println("Run the program again and enter a valid width number!");
				   System.exit(0);  // terminate the program
				}
		
			// Prompt for height
			System.out.println("Enter the height: ");
				if(in.hasNextDouble()) // OK safe to read in a double
				{
				    // Get height from user
				    height = in.nextDouble(); 
					System.out.println("The height you entered was: " + height); // echo
				}
				else
				{ 
				   // Not a double can’t use nextDouble() read as String with nextLine() instead
				   trash = in.nextLine();
				   System.out.println("\nYou said your height was: " + trash);
				   System.out.println("Run the program again and enter a valid height number!");
				   System.exit(0);  // terminate the program
				}
		
			// Prompt for cost per SqFt
			System.out.println("Enter the cost per square foot: ");
				if(in.hasNextDouble()) // OK safe to read in a double
				{
				    // Get cost per SqFt from user
					costPerSqFt = in.nextDouble(); 
					System.out.println("The cost per SqFt you entered was: " + costPerSqFt); // echo
				}
				else
				{ 
				   // Not a double can’t use nextDouble() read as String with nextLine() instead
				   trash = in.nextLine();
				   System.out.println("\nYou said your cost per SqFt was: " + trash);
				   System.out.println("Run the program again and enter a valid cost per SqFt number!");
				   System.exit(0);  // terminate the program
				}
	
					// Calculate Area and display cost
					area = width * height;
					System.out.println("The area is: " + area);
					totalCost = area * costPerSqFt;
					System.out.println("With the cost per square feet you entered, the total cost of materials is: " + totalCost);
				
		in.close();
	}

}
