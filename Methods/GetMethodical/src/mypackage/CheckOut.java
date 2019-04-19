package mypackage;
import java.util.Scanner;

/**
 *
 * @author eadess
 */
public class CheckOut 
{
	
    /**
     * @param args the command line arguments
     */
	public static void main(String[] args) 
	{
			// Variables
			Scanner in = new Scanner(System.in);
			double itemPrice = 0.00;
			double totalPrice = 0.00;
			boolean continueYN = true;
       
				do 
				{
					// Enter item price
					itemPrice = SafeInput.getRangedDouble(in, "\nEnter the price of your item", 0.50, 9.99); // call method with params
					System.out.println("\nYour items price is: " + itemPrice); // echo
					totalPrice = totalPrice + itemPrice; // add new item to total price
					System.out.printf("\nYour total price is: " + "%.2f", totalPrice);
					in.nextLine(); // clears the newline from the buffer
					continueYN = SafeInput.getYNConfirm(in, "\nDo you have another item? (Y/N)");
				}	
				while (continueYN == true);	
				
			System.out.printf("Your total price is: " + "%.2f", totalPrice);

	}

}
