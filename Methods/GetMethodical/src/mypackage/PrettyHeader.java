package mypackage;
import java.util.Scanner;

/**
*
* @author eadess
*/
public class PrettyHeader {

    /**
     * @param args the command line arguments
     */
	public static void main(String[] args) {

		// Variables
		Scanner in = new Scanner(System.in);
		String message = "";
		
			System.out.print("Please enter a message to be centered: ");
			message = in.nextLine();
			SafeInput.prettyHeader(message);
			
		in.close(); // Closing scanner resource
			
	}

}
