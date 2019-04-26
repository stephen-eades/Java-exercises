package mypackage;

import java.util.Random;
import java.util.Scanner;

public class ArrayStuff 
{

	public static void main(String[] args) 
	{
		
		// Variables (1.a)
		Random rnd = new Random();
		int dataPoints[]; // instantiate array reference
		dataPoints = new int [100]; // allocate memory to array
		double sumDataPoints = 0;
		double avgDataPoints = 0;
		Scanner pipe = new Scanner(System.in);
		String intPrompt = "";
		int userInt = 0;
		int userIntCounter = 0;
		boolean matchFound = false;
		int indexValue = 0;
		int maxUserInt = 0;
		int minUserInt = 100;
		
		
			// For loop (1.b)
			for (int i = 0; i < dataPoints.length; i++) // loop through entire array
			{
				dataPoints[i] = rnd.nextInt(100) + 1; // assign random int 1-100 with each iteration
			}
			
			
			// For loop (1.c)
			for (int i = 0; i < dataPoints.length; i++) // loop through entire array
			{
				System.out.print(dataPoints[i] + " | "); // print each value in array 
			}
				
			
			// For loop (1.d)
			for (int i = 0; i < dataPoints.length; i++) // loop through entire array
			{
				sumDataPoints = sumDataPoints + dataPoints[i]; // add each array value to total sum
			}
			avgDataPoints = sumDataPoints / 100; // calculate average
			// used doubles to calculate more accurate average
			System.out.print("\nThe sum of all random values in the dataPoints array is: " + sumDataPoints);
			System.out.print("\nThe average of all random values in the dataPoints array is: " + avgDataPoints);
			
			// Call Method (2.e and compare)
			System.out.print("\nCOMPARE: The sum of dataPoints is: " + sum(dataPoints));
			System.out.print("\nCOMPARE: The average of dataPoints is: " + getAverage(dataPoints));
			
			
				// Prompt input (2.a)
				intPrompt = "Please enter a integer between 1-100"; // set prompt to pipe into method
				userInt = SafeInput.getRangedInt(pipe, intPrompt, 1, 100);
				
				
				// For loop (2.b)
				for (int i = 0; i < dataPoints.length; i++) // loop through entire array
				{
					if (userInt == dataPoints[i]) // check for userInt within array
					{
						userIntCounter = userIntCounter + 1;
					}
					else
					{
						userIntCounter = userIntCounter + 0;
					}
				}
				System.out.print("Your integer appeared " + userIntCounter + " times within the array.");
					
					// test comparison method for (2.b)
					System.out.print("\nCOMPARE: Your integer appears in the array: " + occuranceScan(dataPoints, userInt) + " times.");
				
				
				// For loop (2.c)
				for (int i = 0; i < dataPoints.length; i++) // loop through entire array
				{
					if (userInt == dataPoints[i]) // check for userInt within array
					{
						System.out.print("\nYour integer: " + userInt + " was found at index: " + indexValue);
						matchFound = true;
						break;
					}
					else
					{
						indexValue++; // add 1 to index counter and continue loop
						matchFound = false;
					}
				}
				
						if (matchFound == false) // only shows that match was not found
						{
							System.out.print("\nNo match was found within the array.");
						}
						else 
						{
							// do nothing
						}
						
							// test comparison method for (2.c)
							System.out.print("\nCOMPARE: Your integer was found in the array: " + contains(dataPoints, userInt));
						
		
				// For loop (2.d)
				for (int i = 0; i < dataPoints.length; i++) // loop through entire array
				{
					if (dataPoints[i] > maxUserInt) // check for max int in array
					{
						maxUserInt = dataPoints[i];
					}
					else if (dataPoints[i] < minUserInt) // check for min int in array
					{
						minUserInt = dataPoints[i];
					}
					else 
					{
						// do nothing
					}
				}
				System.out.print("\nThe max integer in the array is: " + maxUserInt);
				System.out.print("\nThe minimum integer in the array is: " + minUserInt);
				
					// test comparison method for (2.d)
					System.out.print("\nCOMPARE: The max integer is: " + max(dataPoints));
					System.out.print("\nCOMPARE: The min integer is " + min(dataPoints));
				
	} // end of main method
	
	
	/** Returns the avg value found
	    * @param values is an array provided 
	    * @return a double value of the average of the array
	    */ 
	public static double getAverage(int values[])
	{
		// variables
		double sumValues = 0.00;
		double avgValues = 0.00;
		
			// process array parameter
			for (int i = 0; i < values.length; i++) // loop through entire array
			{
				sumValues = sumValues + values[i]; // add each array value to total sum
			}
			avgValues = sumValues / 100; // calculate average
		
		return avgValues;
	}
	
	
	/** Returns the min value found
	    * @param values is an array provided 
	    * @return a double value of the min
	    */ 
	public static int min(int values[])
	{
		// Variables
		int minValuesInt = 100;
		
			for (int i = 0; i < values.length; i++) // loop through entire array
			{
				if (values[i] < minValuesInt) // check for min int in array
				{
					minValuesInt = values[i];
				}
				else 
				{
					// do nothing
				}
			}

		return minValuesInt;
	}
	
	
	/** Returns the max value found
	    * @param values is an array provided 
	    * @return a double value of the max
	    */ 
		public static int max(int values[])
		{
			// Variables
			int maxValuesInt = 0;
			
				for (int i = 0; i < values.length; i++) // loop through entire array
				{
					if (values[i] > maxValuesInt) // check for min int in array
					{
						maxValuesInt = values[i];
					}
					else 
					{
						// do nothing
					}
				}
	
			return maxValuesInt;
		}
	
	
	/** Returns the number of times target is found in the values array
	    * @param values is an array provided 
	    * @return a double value of the number of times target is found
	    */ 
	public static int occuranceScan(int values[], int target) 
	{
		// variables
		int occuranceValues = 0;
		
			for (int i = 0; i < values.length; i++) // loop through entire array
			{
				if (target == values[i]) // check for target within array
				{
					occuranceValues = occuranceValues + 1;
				}
				else
				{
					occuranceValues = occuranceValues + 0;
				}
			}
		
		return occuranceValues;
	}
	         
	
	/** Returns the sum of the values array elements
 	    * @param values is an array provided 
 	    * @return a double sum of the values
 	    */ 
	public static int sum(int values[]) 
	{
		// variables
		int sumValues = 0;
		
			// process array parameter
			for (int i = 0; i < values.length; i++) // loop through entire array
			{
				sumValues = sumValues + values[i]; // add each array value to total sum
			}
		
		return sumValues;
	}
	
	
	/** Returns true if the values array contains target
	    * @param values is an array provided 
	    * @return a boolean if value is within array
	    */ 
	public static boolean contains(int values[], int target)
	{
		// variables
		boolean containsValue = false;
		int indexValue = 0;
		

			for (int i = 0; i < values.length; i++) // loop through entire array
			{
				if (target == values[i]) // check for userInt within array
				{
					containsValue = true;
					break;
				}
				else
				{
					indexValue++; // add 1 to index counter and continue loop
					containsValue = false;
				}
			}
			
					if (containsValue == false) // only shows that match was not found
					{
						System.out.print("\nNo match was found within the array.");
					}
					else 
					{
						// do nothing
					}
		
		// body of method
		return containsValue;
	}

	
}

