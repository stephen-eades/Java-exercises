package mypackage;
/**
*
* @author eadess
*/
public class CtoFTableDisplay {

    /**
     * @param args the command line arguments
     */
	public static void main(String[] args) {
			
			// loop to make table
			int i = 0;                       
	        System.out.println("Celsius | Fahrenheit");
	        System.out.println("--------+-----------");
	        for ( i = -100; i <= 100; i+= 1)
	        {            
	            for (int c = 1; c <= 1; c++)
	            {                
	                System.out.print("    " + i + "  |");
	                System.out.printf("%.2f", CtoF(i));
	            }
	            System.out.println();
	        }
		
		
		
	}
	
    /**
     * @param celsius the temperature provided
     */
	public static double CtoF(double Celsius)
	{
		// Variables
		double fahrenheit = 0.00;
		
		// Conversion process: (0°C × 9/5) + 32 = 32°F
		fahrenheit = (Celsius * (1.8)) + 32;
		
		return fahrenheit;
		
	}

}
