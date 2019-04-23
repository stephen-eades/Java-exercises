package mypackage;
// imports
import java.util.Scanner;


public class SafeInput {
	
	
		
	/**
	    * 
	    * @param pipe a Scanner opened to read from System.in
	    * @param prompt prompt for the user
	    * @return a String response that is not zero length
	    */ 
	   public static String getNonZeroLenString(Scanner pipe, String prompt)
	   {
	       String retString = "";  // Set this to zero length. Loop runs until it isn’t
	       do
	       {
	           System.out.print("\n" +prompt + ": "); // show prompt add space
	           retString = pipe.nextLine();
	       } while (retString.length() == 0);
	       
	       return retString;
	   }
	   
	   
	   
	/**
	    * 
	    * @param pipe: a Scanner opened to read from System.in
	    * @param prompt: prompt for the user
	    * @param low: lowest int available in provided range
	    * @param high: highest int available in provided range 
	    * @return an int within the ranged specified from low and high
	    */ 
	   public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
	   {
		   // Variables
	       int rangedInt = 0; // instantiate at zero
	       String trash = ""; // for invalid input
	       boolean loopAgain = true; // loop value
	       
	       	   // Prompt
	    	   do // loop begins
	    	   {
		    	   // Check for valid input
		    	   System.out.print("\n" +prompt + ": "); // show prompt add space
		    	   if (pipe.hasNextInt()) // check as int
		    	   {
		    		   rangedInt = pipe.nextInt(); // assigned input to variable
		    		   // test for range
		    		   if (rangedInt >= low && rangedInt <= high) 
		    		   {
		    			   System.out.println("You entered and int of: " + rangedInt);
		    			   loopAgain = false;
		    		   }
		    		   else
		    		   {
		    			   System.out.println("You entered and int of: " + rangedInt);
		    			   System.out.println("This int is outside range. Try again.");
		    			   loopAgain = true;
		    		   }
		    	   }
		    	   else // process trash as String
		    	   {
		    		   trash = pipe.nextLine();
		    		   System.out.println(trash + " is invalid. Please try again with valid input.");
		    		   loopAgain = true;
		    	   }
	       
	    	   } while (loopAgain == true);
	    	   
	       return rangedInt;
	  
	   }

	   
	   
	/**
	    * 
	    * @param pipe: a Scanner opened to read from System.in
	    * @param prompt: prompt for the user
	    * @param low: lowest double available in provided range
	    * @param high: highest double available in provided range 
	    * @return a double within the ranged specified from low and high
	    */ 
	   public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
	   {
		   // Variables
	       double rangedDouble = 0.00; // instantiate at zero
	       String trash = ""; // for invalid input
	       boolean loopAgain = true; // loop value
	       
	       	   // Prompt
	    	   do // loop begins
	    	   {
		    	   // Check for valid input
		    	   System.out.print("\n" +prompt + ": "); // show prompt add space
		    	   if (pipe.hasNextDouble()) // check as double
		    	   {
		    		   rangedDouble = pipe.nextDouble(); // assigned input to variable
		    		   // test for range
		    		   if (rangedDouble >= low && rangedDouble <= high) 
		    		   {
		    			   System.out.println("You entered a double of: " + rangedDouble);
		    			   loopAgain = false;
		    		   }
		    		   else
		    		   {
		    			   System.out.println("You entered and int of: " + rangedDouble);
		    			   System.out.println("This int is outside range. Try again.");
		    			   loopAgain = true;
		    		   }
		    	   }
		    	   else // process trash as String
		    	   {
		    		   trash = pipe.nextLine();
		    		   System.out.println(trash + " is invalid. Please try again with valid input.");
		    		   loopAgain = true;
		    	   }
	       
	    	   } while (loopAgain == true);
	    	   
	       return rangedDouble;
	       
	   }	   
	   
	   
	   
	/**
	    * 
	    * @param pipe: a Scanner opened to read from System.in
	    * @param prompt: prompt for the user
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
	       		   
	       		   System.out.print("\n" +prompt + ": "); // show prompt add space
	       		   userInput = pipe.nextLine(); // assigned input to variable
				   if (userInput.equalsIgnoreCase("Y")) 
				   {
					   System.out.println("You entered: " + userInput);
					   YNconfirmed = true;
					   loopAgain = false;
				   }
				   else if (userInput.equalsIgnoreCase("N"))
				   {
					   System.out.println("You entered: " + userInput);
					   YNconfirmed = false;
					   loopAgain = false;
				   }
				   else
				   {
					   System.out.println("You entered: " + userInput + " which is invalid. Try again.");
					   YNconfirmed = false;
					   loopAgain = true;
				   }
				   
	       	   } while (loopAgain == true);
			   
	       return YNconfirmed;
	       
	   } // end getYNConfirmed method
	   
	   
	   
		/**
	    * 
	    * @param pipe: a Scanner opened to read from System.in
	    * @param prompt: prompt for the user
	    * @return true or false value specified for the boolean variable
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
	   
	   } // end prettyHeader method
	   
	   
} // end main class
