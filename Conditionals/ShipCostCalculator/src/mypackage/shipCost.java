package mypackage;
// An application program where the user enters the price of an item and the program computes shipping costs.  If the item price 
// is $100 or more, then shipping is free otherwise it is 2% of the price. The program should output the shipping cost and the 
// total price.  Bullet proof the input so they user cannot break the program.

import java.util.Scanner;

public class shipCost {

	public static void main(String[] args) {
		
		// Declare variables
		Scanner in = new Scanner(System.in);
		double curItemPrice = 0;
		double totalPrice = 0;
		double shippingCost = 0;
		String continueYN = "";
		String trash = ""; // use for bad input which will read as a String

		
			// Prompt for item prices
			do {
				System.out.println("Enter the price of them item in USD: ");
				if(in.hasNextDouble()) // OK safe to read in a double
				{
				    // Get item cost from user
				    curItemPrice = in.nextDouble(); 
					System.out.println("The price of them item you entered in USD is: $" + curItemPrice); // echo
				    in.nextLine(); // clears the newline from the buffer
				    
					// Calculate total cost and ask for additional items
					totalPrice = totalPrice + curItemPrice; // calculate total price of all items
					System.out.println("Have another item to add? [Y/N] ");
					continueYN = in.nextLine(); // determines if Do/While loop is executed
				}
				else
				{ 
				   // Not a double can’t use nextDouble() read as String with nextLine() instead
				   trash = in.nextLine();
				   System.out.println("\nYou said your price was: " + trash);
				   System.out.println("Run the program again and enter a valid amount!");
				   System.exit(0);  // terminate the program
				}
				
			} while (continueYN.equalsIgnoreCase("Y"));

						
				// Calculate shipping cost
				System.out.println("No more items to add. Calculating shipping costs... ");
				if (totalPrice >= 100.00) {
					shippingCost = 0;
					System.out.println("Congratulations, your shipping is free!");
					System.out.println("Your total price is: " + totalPrice);
				}
				else {
					shippingCost = totalPrice * 0.02;
					System.out.println("Your shipping cost is 2% of your total price equaling: " + shippingCost);
					totalPrice = totalPrice + shippingCost;
					System.out.println("Your new total price plus shipping is: " + totalPrice);
				}	
				
		in.close(); // Closing scanner resource		
	}

}





