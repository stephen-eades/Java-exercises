package mypackage;

import java.util.Scanner;

public class SafeInput 
{
	
	  /** Confirms the provided String is more than 0 length
	    * @param pipe a Scanner opened to read from System.in
	    * @param prompt prompt for the user
	    * @return a String response that is not zero length
	    */ 
	   public static String getNonZeroLenString(Scanner pipe, String prompt)
	   {
		   // Variables
		   String retString = "";
		   
	           do
	           {
			   // We continue looping until we get a String more than zero length
			   System.out.print("\n" +prompt + ": ");
			   retString = pipe.nextLine();
			   
		   } while (retString.length() == 0);
	       
	       return retString;
	   }
	   
	   
	   
	  /** Confirms the provided integer is within the range provided
	    * @param pipe is a Scanner opened to read from System.in
	    * @param prompt is the prompt for the user
	    * @param low is the lowest int available in provided range
	    * @param high is the highest int available in provided range 
	    * @return an int within the ranged specified from low and high
	    */ 
	   public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
	   {
		   // Variables
		   int rangedInt = 0;
		   String trash = "";
	           boolean loopAgain = false;
	       
	    	   do
	    	   {
		    	   // Check for valid input type with hasNextInt
		    	   System.out.print("\n" +prompt + ": ");
		    	   if (pipe.hasNextInt()) 
			   {
				   // If we have an integer, we assign input to variable and test the range
		    		   rangedInt = pipe.nextInt();
		    		   if (rangedInt >= low && rangedInt <= high) 
		    		   {
					   // if within range, stop loop and return message
		    			   System.out.println("You entered and int of: " + rangedInt);
		    			   loopAgain = false;
		    		   }
		    		   else
		    		   {
					   // if outside range, provide an error message and loop again
		    			   System.out.println("You entered and int of: " + rangedInt);
		    			   System.out.println("This int is outside range. Try again.");
		    			   loopAgain = true;
		    		   }
		    	   }
		    	   else
		    	   {
				   // if we don't get an integer, process trash as String and loop again
		    		   trash = pipe.nextLine();
		    		   System.out.println(trash + " is invalid. Please try again with valid input.");
		    		   loopAgain = true;
		    	   }
	       
	    	   } while (loopAgain == true);
	    	   
	       return rangedInt;
	   }

	   
	   
	  /** Confirms the provided double is within the range provided
	    * @param pipe is a Scanner opened to read from System.in
	    * @param prompt is the prompt for the user
	    * @param low is the lowest double available in provided range
	    * @param high is the highest double available in provided range 
	    * @return a double within the ranged specified from low and high
	    */ 
	   public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
	   {
		   // Variables
	           double rangedDouble = 0.00;
		   String trash = "";
	           boolean loopAgain = false;
	       
	    	   do
	    	   {
		    	   // Check for valid input type with hasNextDouble
		    	   System.out.print("\n" +prompt + ": ");
		    	   if (pipe.hasNextDouble())
		    	   {
				   // If we have a double, we assign input to variable and test the range
		    		   rangedDouble = pipe.nextDouble();
		    		   if (rangedDouble >= low && rangedDouble <= high) 
		    		   {
				           // If within range, stop loop and return message
		    			   System.out.println("You entered a double of: " + rangedDouble);
		    			   loopAgain = false;
		    		   }
		    		   else
		    		   {
				           // If outside range, provide an error message and loop again
		    			   System.out.println("You entered a double of: " + rangedDouble);
		    			   System.out.println("This double is outside range. Try again.");
		    			   loopAgain = true;
		    		   }
		    	   }
		    	   else
		    	   {
				   // If we don't get a double, process trash as String and loop again
		    		   trash = pipe.nextLine();
		    		   System.out.println(trash + " is invalid. Please try again with valid input.");
		    		   loopAgain = true;
		    	   }
				   
	    	   } while (loopAgain == true);
	    	   
	       return rangedDouble; 
	   }	   
	   
	   
	   
	  /** Gathers provided answer to Y/N prompt
	    * @param pipe is the Scanner opened to read from System.in
	    * @param prompt is the prompt for the user
	    * @return true or false value specified for the boolean variable
	    */ 
	   public static boolean getYNConfirm(Scanner pipe, String prompt)
	   {
		   // Variables
		   String userInput = "";
	           boolean YNconfirmed = false;
	           boolean loopAgain = true;
	       
	       	   do 
	       	   {
	       		   // Assign input to variable, then test for a match to "Y" or "N"
	       		   System.out.print("\n" +prompt + ": ");
	       		   userInput = pipe.nextLine();
			   if (userInput.equalsIgnoreCase("Y")) 
			   {
				   // If yes, set YNconfirmed to true and end the loop
				   System.out.println("You entered: " + userInput);
				   YNconfirmed = true;
				   loopAgain = false;
			   }
			   else if (userInput.equalsIgnoreCase("N"))
			   {
				   // If no, set YNconfirmed to false and end the loop
				   System.out.println("You entered: " + userInput);
				   YNconfirmed = false;
				   loopAgain = false;
			   }
			   else
			   {
				   // If invalid input, loop again for new input
				   System.out.println("You entered: " + userInput + " which is invalid. Try again.");
				   YNconfirmed = false;
				   loopAgain = true;
			   }
				   
	       	   } while (loopAgain == true);
			   
	       return YNconfirmed;
	   }
	   
	   
	   
          /** Prints a styled header with the provided String message centered
	    * @param pipe is a Scanner opened to read from System.in
	    * @param prompt is the prompt for the user
	    * @return the styled header 
	    */ 
	   public static void prettyHeader(String msg)
	   {
		   // Variables
		   int whiteSpace = (54 - msg.length())/2;
		   	
			if(msg.length() < 54)
			{
				for (int x = 0; x <= 60; x++)
				{
					System.out.print("*");
				}
				System.out.print("\n***");

					for (int x = 0; x <= whiteSpace; x++)
					{
						System.out.print(" ");
					}
					System.out.print(msg);

					for (int x = 0; x <= whiteSpace; x++)
					{
						System.out.print(" ");
					}
					System.out.print("***");
					System.out.println("");

				for (int x = 0; x <= 60; x++)
				{
					System.out.print("*");
				}
				System.out.println("");
			}

		return;
	   } 
	  
}
