package mypackage;
import java.util.Scanner;

/**
 *
 * @author wulft
 */
public class GetUserName 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       Scanner in = new Scanner(System.in);
       String firstName = "";
       String lastName = "";
       
       firstName = SafeInput.getNonZeroLenString(in, "Enter your first name");
       lastName = SafeInput.getNonZeroLenString(in, "Enter your last name");
       
        System.out.println("\nYour full name is: " + firstName + " " + lastName);
        
    }
    
}
        
//        // TEST getRangedInt
//        userInt = SafeInput.getRangedInt(in, "Enter your integer", 0, 100);
//        System.out.println("\nYour integer is: " + userInt);
//        
//        // TEST getRangeddouble
//        userDouble = SafeInput.getRangedDouble(in, "Enter your double", 0, 100);
//        System.out.println("\nYour double is: " + userDouble);
        
          // TEST getYNconfirm
//        userBool = SafeInput.getYNConfirm(in, "Would you like to play again?");
//        System.out.println("\nYour answer is: " + userBool);