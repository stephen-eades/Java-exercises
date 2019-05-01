package mypackage;
import java.util.Scanner;

/**
 *
 * @author eadess
 */
public class BirthDateTime 
{

    /**
     * @param args the command line arguments
     */
	public static void main(String[] args) 
	{
			// Variables
			Scanner in = new Scanner(System.in);
			int year = 0;
			int month = 0;
			int day = 0;
			int hour = 0;
			int minute = 0;
       
				// Enter year
				year = SafeInput.getRangedInt(in, "Enter your year of birth", 1950, 2010);
				System.out.println("\nYour birth year is: " + year);
				
				// Enter month
				month = SafeInput.getRangedInt(in, "Enter your birth month", 1, 12);
				System.out.println("\nYour birth month is: " + month);
				
				// Enter day - switch to ensure valid day input
				switch (month) {
				  case 1: case 3: case 5: case 7: case 8: case 10: case 12: // months with 31 days
					day = SafeInput.getRangedInt(in, "Enter your day of birth", 1, 31);
				    break;
				  case 4: case 6: case 9: case 11: // months with 30 days
					day = SafeInput.getRangedInt(in, "Enter your day of birth", 1, 30);
				    break;
				  case 2: // months with 28 days
					day = SafeInput.getRangedInt(in, "Enter your day of birth", 1, 28);
				    break;
				}
				System.out.println("\nYour day of birth is: " + day);
				
				// Enter hour
				hour = SafeInput.getRangedInt(in, "Enter your birth hour", 1, 24);
				System.out.println("\nYour birth hour is: " + hour);
				
				// Enter minute
				minute = SafeInput.getRangedInt(in, "Enter your birth minute", 1, 59);
				System.out.println("\nYour birth minute is: " + minute);
	      	
	}

}
