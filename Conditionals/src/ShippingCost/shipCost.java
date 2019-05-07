package mypackage;

import java.util.Scanner;

public class shipCost 
{

	public static void main(String[] args) 
	{

		// Variables
		Scanner in = new Scanner(System.in);
		double curItemPrice = 0;
		double totalPrice = 0;
		double shippingCost = 0;
		String continueYN = "";
		String trash = "";
	
		
			do 
			{
				// Prompt for item prices using nextDouble()
				System.out.println("Enter the price of them item in USD: ");
				if(in.hasNextDouble())
				{
				    	// Get item cost from user and clear new line
				    	curItemPrice = in.nextDouble(); 
					System.out.println("The price of them item you entered in USD is: $" + curItemPrice);
				    	in.nextLine(); 
				    
					// Calculate total cost and ask for additional items
					totalPrice = totalPrice + curItemPrice;
					System.out.println("Have another item to add? [Y/N] ");
					continueYN = in.nextLine();
				}
				else
				{ 
				   	// Not a double, so can’t use nextDouble(). Instead read as String with nextLine()
				   	trash = in.nextLine();
				   	System.out.println("\nYou said your price was: " + trash);
				   	System.out.println("Run the program again and enter a valid amount!");
				   	System.exit(0);
				}
				
			} while (continueYN.equalsIgnoreCase("Y"));

		
			// Calculate shipping cost and apply free shipping if total is greater or equal than $100.00
			System.out.println("No more items to add. Calculating shipping costs... ");
			if (totalPrice >= 100.00) 
			{
				shippingCost = 0;
				System.out.println("Congratulations, your shipping is free!");
				System.out.println("Your total price is: " + totalPrice);
			}
			else 
			{
				shippingCost = totalPrice * 0.02;
				System.out.println("Your shipping cost is 2% of your total price equaling: " + shippingCost);
				totalPrice = totalPrice + shippingCost;
				System.out.println("Your new total price plus shipping is: " + totalPrice);
			}	
				
		in.close(); // Closing scanner resource		
	}

}





