
public class MyInitial {

	public static void main(String[] args) {

		// Variables
		int i = 0;
		int j = 0;
		
		// 9. Extra Credit/Grad: Capital initial of S (there are no blank lines)
		// **********
		// **********
		// *****
		// **********
		// **********
        //      *****
        // **********
        // **********
		// First nested for is top two rows
        for (i = 1; i <= 2; i++) // i <= [number of rows]
        {
            for (j = 1; j <= 10; j++) // j <= [number of columns/asterisks in that row]
            {
                System.out.print("*");
            }
            System.out.println(); // breaks each row
        }
        
		// Second nested for is 3rd row
        for (i = 1; i <= 1; i++) // i <= [number of rows]
        {
            for (j = 1; j <= 5; j++) // j <= [number of columns/asterisks in that row]
            {
                System.out.print("*");
            }
            System.out.println(); // breaks each row
        }
        
		// Third nested for is 4th and 5th rows - identical to two top rows
        for (i = 1; i <= 2; i++) // i <= [number of rows]
        {
            for (j = 1; j <= 10; j++) // j <= [number of columns/asterisks in that row]
            {
                System.out.print("*");
            }
            System.out.println(); // breaks each row
        }
        
		// Fourth nested for is for 6th and 7th rows - spaces first then asteriks
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
        
		// Final nested for is bottom two rows to complete our capital S
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
