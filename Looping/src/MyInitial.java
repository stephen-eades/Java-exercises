package mypackage;

public class MyInitial 
{

	public static void main(String[] args) 
	{

		// Variables
		int i = 0;
		int j = 0;
		
		// Capital letter S of my first name, Stephen. As displayed below.
		// **********
		// **********
		// *****
		// **********
		// **********
        	//      *****
        	// **********
        	// **********
		
		// First nested loop is for top two rows
		for (i = 1; i <= 2; i++) // i <= [number of rows]
		{
		    	for (j = 1; j <= 10; j++) // j <= [number of columns/asterisks in that row]
		    	{
				System.out.print("*");
		    	}
		    	System.out.println(); // breaks each row
		}

		
		// Second nested loop is for 3rd row
		for (i = 1; i <= 1; i++) // i <= [number of rows]
		{
		    	for (j = 1; j <= 5; j++) // j <= [number of columns/asterisks in that row]
		    	{
				System.out.print("*");
		    	}
		    	System.out.println(); // breaks each row
		}

		
		// Third nested loop is for 4th and 5th rows
		for (i = 1; i <= 2; i++) // i <= [number of rows]
		{
		    	for (j = 1; j <= 10; j++) // j <= [number of columns/asterisks in that row]
		    	{
				System.out.print("*");
		    	}
		    	System.out.println(); // breaks each row
		}

		
		// Fourth nested loop is for 6th and 7th rows
		for (i = 1; i <= 1; i++) // i <= [number of rows]
		{
		    	for (j = 1; j <= 10; j++) // j <= [number of columns/asterisks in that row]
		    	{
				if (j <= 5) // if j, our column variable, is less than 5 we use a space, once we are 5 "columns" over we begin using asterisks
			     	{
					System.out.print(" ");
			     	}
			     	else
			     	{
					System.out.print("*");
			     	}
		    	}
		    	System.out.println(); // breaks each row
		}

		
		// Final nested loop is for bottom two rows to complete our initial
		for (i = 1; i <= 2; i++) // i <= [number of rows]
		{
		    	for (j = 1; j <= 10; j++) // j <= [number of columns/asterisks in that row]
		    	{
				System.out.print("*");
		    	}
		    	System.out.println(); // breaks each row
		}

	}
}
