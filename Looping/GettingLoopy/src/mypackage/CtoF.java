import java.util.Scanner;

public class CtoF {

	public static void main(String[] args) {
		
		// Variables
		Scanner in = new Scanner(System.in);
		int tempCelsius = 0;
		double tempFahrenheit = 0;
		boolean validInput = false;
		
			 do // loop until we get valid user input
		   	 {
		   		 System.out.println("Please enter your temperature in Celsius: ");
		            tempCelsius = in.nextInt();
		            	if (tempCelsius >= 0 && tempCelsius <= 100)
		               {
		            		 System.out.println("The temperature you entered was: " + tempCelsius); // echo valid input
		                     validInput = true;
		               }
		               else
		               {
				    		 // Temperature was outside of ranges
							 System.out.println("\nYou said the temperature was: " + tempCelsius);
							 System.out.println("Please enter a Celsius temperature between the freezing (0) and boiling point(100).");
		                     validInput = false;
		               }
		   	 }
		   	 while (validInput == false);

		// Process input
		System.out.println("Converting the temperature from Celsius to Fahrenheit...");
		// Conversion process: (0°C × 9/5) + 32 = 32°F
		tempFahrenheit = (tempCelsius * (1.8)) + 32;
		System.out.println("Your temperature of " + tempCelsius + " converted to Fahrenheit is: " + tempFahrenheit);
		
		//  Closer scanner
		in.close();
		
	}

}
