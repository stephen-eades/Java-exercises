package mypackage;

import java.util.Random;
import java.util.Scanner;

public class ArrayStuff 
{

	public static void main(String[] args) 
	{
		
		// Variables
		Random rnd = new Random();
		Scanner pipe = new Scanner(System.in);
		int dataPoints[]; // instantiate array reference
		dataPoints = new int [100]; // allocate memory to array
		int userInt = 0;
		int userIntCounter = 0;
		int indexValue = 0;
		int maxUserInt = 0;
		int minUserInt = 100;
		double sumDataPoints = 0;
		double avgDataPoints = 0;
		boolean matchFound = false;
		
		
		
			// Loop through array and assign random int (1-100) with each iteration
			for (int i = 0; i < dataPoints.length; i++)
			{
				dataPoints[i] = rnd.nextInt(100) + 1;
			}
			
		
		
			// Loop through array and print each value
			for (int i = 0; i < dataPoints.length; i++)
			{
				System.out.print(dataPoints[i] + " | ");
			}
				
			
		
			// Calculate sum of array values adding each iteration to sumDataPoints var
			for (int i = 0; i < dataPoints.length; i++)
			{
				sumDataPoints = sumDataPoints + dataPoints[i];
			}
			System.out.print("\nThe sum of all random values in the dataPoints array is: " + sumDataPoints);
		
			// Calculate average of array values using sumDataPoints var
			avgDataPoints = sumDataPoints / 100;
			System.out.print("\nThe average of all random values in the dataPoints array is: " + avgDataPoints);
		
			// Calculate sum and average using helper methods for comparison
			System.out.print("\nCOMPARE: The sum of dataPoints is: " + sum(dataPoints));
			System.out.print("\nCOMPARE: The average of dataPoints is: " + getAverage(dataPoints));
			
		
			
			// Get user input as integer
			userInt = SafeInput.getRangedInt(pipe, "Please enter a integer between 1-100", 1, 100);

			// Loop through array and check for userInt within array
			for (int i = 0; i < dataPoints.length; i++)
			{
				if (userInt == dataPoints[i]) 
				{
					userIntCounter++;
				}
			}
			System.out.print("Your integer appeared " + userIntCounter + " times within the array.");
					
			// Search array using helper method for comparison
			System.out.print("\nCOMPARE: Your integer appears in the array: " + occuranceScan(dataPoints, userInt) + " times.");


		
			// Loop through array and checl for userInt within array
			for (int i = 0; i < dataPoints.length; i++)
			{
				if (userInt == dataPoints[i])
				{
					// Display the index where userInt is found
					System.out.print("\nYour integer: " + userInt + " was found at index: " + indexValue);
					matchFound = true;
					break;
				}
				else
				{
					// add 1 to index counter and continue loop
					indexValue++;
					matchFound = false;
				}
			}
			// show if no match was found
			if (matchFound == false)
			{
				System.out.print("\nNo match was found within the array.");
			}
						
			// Search for array index using helper method for comparison
			System.out.print("\nCOMPARE: Your integer was found in the array: " + contains(dataPoints, userInt));

		
		
			// Loop through array checking for the max and min integer
			for (int i = 0; i < dataPoints.length; i++)
			{
				if (dataPoints[i] > maxUserInt)
				{
					maxUserInt = dataPoints[i];
				}
				else if (dataPoints[i] < minUserInt)
				{
					minUserInt = dataPoints[i];
				}
			}
			System.out.print("\nThe max integer in the array is: " + maxUserInt);
			System.out.print("\nThe minimum integer in the array is: " + minUserInt);

			// Search for max and min using helper method for comparison
			System.out.print("\nCOMPARE: The max integer is: " + max(dataPoints));
			System.out.print("\nCOMPARE: The min integer is " + min(dataPoints));
				
		
		
	} // end of main method
	
	
	
	// Helper Methods
	
	/** Returns the avg value found
	    * @param values is an array provided 
	    * @return a double value of the average of the array
	    */ 
	public static double getAverage(int values[])
	{
		// Variables
		double sumValues = 0.00;
		double avgValues = 0.00;
		
			// Loop through array, adding each value to sum and calculating the average
			for (int i = 0; i < values.length; i++) 
			{
				sumValues = sumValues + values[i]; 
			}
			avgValues = sumValues / 100;
		
		return avgValues;
	}
	
	
	
	/** Returns the min value found
	    * @param values is an array provided 
	    * @return an int value of the min
	    */ 
	public static int min(int values[])
	{
		// Variables
		int minValuesInt = 100;
		
			// Loop through array checking for min
			for (int i = 0; i < values.length; i++)
			{
				if (values[i] < minValuesInt) 
				{
					minValuesInt = values[i];
				}
			}

		return minValuesInt;
	}
	
	
	
	/** Returns the max value found
	    * @param values is an array provided 
	    * @return an int value of the max
	    */ 
	public static int max(int values[])
	{
		// Variables
		int maxValuesInt = 0;

			// Loop through array checking for max
			for (int i = 0; i < values.length; i++)
			{
				if (values[i] > maxValuesInt)
				{
					maxValuesInt = values[i];
				}
			}

		return maxValuesInt;
	}
	
	
	
	/** Returns the number of times target is found in the array
	    * @param values is an array provided 
	    * @param target is an int provided
	    * @return an int value of the number of times target is found
	    */ 
	public static int occuranceScan(int values[], int target) 
	{
		// Variables
		int occuranceValues = 0;
		
			// Loop through array checking for target within array
			for (int i = 0; i < values.length; i++)
			{
				if (target == values[i])
				{
					occuranceValues++;
				}
			}
		
		return occuranceValues;
	}
	         
	
	
	/** Returns the sum of the array values
 	    * @param values is an array provided 
 	    * @return an int sum of the values
 	    */ 
	public static int sum(int values[]) 
	{
		// Variables
		int sumValues = 0;
		
			// Loop through array and add each value to sumValues var
			for (int i = 0; i < values.length; i++)
			{
				sumValues = sumValues + values[i];
			}
		
		return sumValues;
	}
	
	
	
	/** Returns true if the values array contains target
	    * @param values is an array provided
	    * @param target is an int provided
	    * @return a boolean if value is within array
	    */ 
	public static boolean contains(int values[], int target)
	{
		// Variables
		boolean containsValue = false;
		int indexValue = 0;
		
			// Loop through array checking for target
			for (int i = 0; i < values.length; i++)
			{
				if (target == values[i])
				{
					containsValue = true;
					break;
				}
				else
				{
					// add 1 to index counter and continue loop
					indexValue++;
					containsValue = false;
				}
			}
			// show if no match was found
			if (containsValue == false)
			{
				System.out.print("\nNo match was found within the array.");
			}
		
		return containsValue;
	}

}

