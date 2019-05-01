
public class Loopy {

	public static void main(String[] args) {

		// Variables
		int i = 0;
		int j = 0;
		
			// 1. A loop that counts (i.e. displays the count) up by 1 from 0 to 30 
			for (i = 0; i <= 30; i++) 
			{
				System.out.print(i + ", ");
			}
			System.out.println(); // break output for readability
			
			// 2. A loop that counts down by 1 from 30 to 0
			for (i = 30; i >= 0; i--) 
			{
				System.out.print(i + ", ");
			}
			System.out.println(); // break output for readability
				
			// 3. A loop that counts up by 3 from 0 to 18
			for (i = 0; i <= 18; i=i+3) 
			{
				System.out.print(i + ", ");
			}
			System.out.println(); // break output for readability
				
			// 4. A loop that counts down by 2 from 10 to 0
			for (i = 10; i >= 0; i=i-2) 
			{
				System.out.print(i + ", ");
			}
			System.out.println(); // break output for readability
				
			// 5. A nested loop that creates this figure (there are no blank lines)	
			// *
			// **
			// ***
			// ****
			// *****
			 for (i = 0; i < 5; i++) 
			 {
				 for (j = 0; j < 5; j++) 
				 {
					 if (j <= i) 
		             {
						 System.out.print("*");
		             }
		             else
		             {
		                 System.out.print("   ");
		             }
		         }
		         System.out.println(); // break output for readability
		     }
	         System.out.println(); // break output for readability

			 
			 // 6. A nested loop that creates this figure (there are no blank lines)
			 // *****
			 // ****
			 // ***
			 // **
			 // *
			 for (i = 4; i >= 0; i--) 
			 {
				 for (j = 0; j < 5; j++) 
				 {
					 if (j <= i) 
		             {
						 System.out.print("*");
		             }
		             else
		             {
		            	 System.out.print("   ");
		             }
		         }
		         System.out.println();
		     }
			 System.out.println(); // break output for readability
			 
			 // 7.	A nested loop that creates this figure (there are no blank lines)
			 // *****
			 // *****
			 // *****
			 // *****
			 // *****
             for (i = 1; i <= 5; i++)
             {
                 for (j = 1; j <= 5; j++)
                 {
                     System.out.print("*");
                 }
                 System.out.println();
             }
             
	}
}
