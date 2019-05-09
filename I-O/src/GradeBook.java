package mypackage;
 
import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
 
/**
*
* @author Stephen Eades
*/
public class GradeBook 
{

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) 
   {
       boolean finished = false;
       Scanner console = new Scanner(System.in);
       String menu = "";
       int low = 1;
       int high = 6;
       int menuChoice = 0;
       final int CREATE = 1;  
       final int ADD_GRADES = 2;      
       final int DISPLAY = 3;
       final int DELETE_GRADE = 4;
       final int QUIT = 5;
 
           // build the menu
           menu = "\n\n\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++";
           menu += String.format("\n+++\t1) - %-35s", "Create a Class Set.") + "\t+++";
           menu += String.format("\n+++\t2) - %-35s", "Add Grades to a Set.") + "\t+++";    
           menu += String.format("\n+++\t3) - %-35s", "Display a Class Report.") + "\t+++";    
           menu += String.format("\n+++\t4) - %-35s", "Delete a Grade.") + "\t+++";     
           menu += String.format("\n+++\t5) - %-35s", "Quit the Program.") + "\t+++";    
           menu += "\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++";
           menu += "\nGet choice";        
       
       
       do
       {

           // display menu
           // get the choice
           menuChoice = SafeInput.getRangedInt(console, menu, low, high);
           // execute the choice
           switch (menuChoice)
           {
               case CREATE:
                   System.out.println("Create option chosen.");
                   createClassSet();
                   break;
                   
               case ADD_GRADES:
                   System.out.println("Add Grades option chosen.");
                   addGradesToSet();
                   break;
                   
               case DISPLAY:
                   displayClassSet();
                   break;
                   
               case DELETE_GRADE:
                   System.out.println("Delete grade option chosen.");
                   deleteGradeCol();
                   break;
                   
               case QUIT:
                   System.out.println("Thanks for using the Grade Book.");
                   System.exit(0);
                   
               default:
                   System.out.println("Error unknown menu choice!");
                   System.exit(0);
           }
           
       } while(!finished);
   }
   
   
   
   private static void createClassSet() 
   {
       String classFileName = "";
       String studentName = "";
       boolean doneNameInput = false;
       File classFile;
       PrintWriter out;
       Scanner in = new Scanner (System.in);
       ArrayList<String> names = new ArrayList<>();
       
       System.out.print("Enter the name of the class file [1st grade math]: ");
       classFileName = in.nextLine();
       
       try
       {
    	   // loop and get the student names into an ArrayList
    	   do 
    	   {
    		   System.out.print("Enter the student name [First Last]: ");
    		   studentName = in.nextLine();
    		   names.add(studentName);
    		   
    		   // prompt the user to continue
    		   if (!SafeInput.getYNConfirm(in, "Enter another student"))
    		   {
    			   doneNameInput = true;
    		   }
    		   
    	   } while (!doneNameInput);
    	 
    	   classFile = new File(classFileName + ".txt");
    	   out = new PrintWriter(classFile);
    	   
    	   // write the header (this header is read into the addGrades method)
    	   out.println(classFileName);
    	   // write student name to file
    	   for (String nm : names)
    	   {
    		   out.println(nm);
    	   }
    	   
    	   // close the file
    	   out.close();
    	   
       } 
       catch (FileNotFoundException ex) 
       {
    	   System.out.println("Error, could not create output file!");
    	   System.exit(0);
       } 
       catch (IOException ex) 
       {
    	   ex.getStackTrace();
    	   System.exit(0);
       } 
       
   }
   
   
   private static void displayClassSet() 
   {
	   String studentRecord = "";
	   String fileHeader = "";
       File classFile;
       Scanner inFile;
       JFileChooser chooser = new JFileChooser();
       int studentRecordCount = 0;
       File workingDirectory = new File(System.getProperty("user.dir"));
       chooser.setCurrentDirectory(workingDirectory);
       
       try
       {
    	   if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
    	   {
    		   classFile = chooser.getSelectedFile();
    		   inFile = new Scanner(classFile);
    		   fileHeader = inFile.nextLine();
    		   
    		   // loop and get names into ArrayList
    		   System.out.println(fileHeader);
    		   System.out.println("============================================");
    		   while(inFile.hasNextLine())
    		   {
    			   studentRecord = inFile.nextLine();
    			   studentRecordCount++;
    			   //System.out.println(studentRecordCount + " " + studentRecord);
    			   System.out.println(formatRecordDisplay(studentRecordCount, studentRecord));
    		   }
    		   System.out.println("============================================");

    		   inFile.close();
    	   }
    	   else
    	   {
    		   System.out.println("You must choose a file. \nReturning to menu...");
    		   return;
    	   }

    	   
       } 
       catch (FileNotFoundException ex) 
       {
    	   System.out.println("Error, could not create output file!");
    	   System.exit(0);
       } 
       catch (IOException ex) 
       {
    	   ex.getStackTrace();
    	   System.exit(0);
       } 
	   
   }
   
   
   private static String formatRecordDisplay(int studentRecordCount, String studentRecord) 
   {
	   String ret = "" + studentRecordCount + " " + studentRecord;
	   String [] recordSplit = studentRecord.split(",");
	   
	   if (recordSplit.length > 1)
	   {
		   // find min
		   int min = 100;
		   for (int m = 1; m < recordSplit.length; m++)
		   {
			   int tempMinInt = Integer.parseInt(recordSplit[m].trim());
			   if ( tempMinInt <= min )
			   {
				   min = tempMinInt;
			   }

		   } 
		   studentRecord += "\tMin: " + min;
		   
		   // find max
		   int max = 0;
		   for (int mx = 1; mx < recordSplit.length; mx++)
		   {
			   int tempMaxInt = Integer.parseInt(recordSplit[mx].trim());
			   if ( tempMaxInt >= max )
			   {
				   max = tempMaxInt;
			   }
		   } 
		   studentRecord += "\tMax: " + max;
		   
		   // find average
		   int sum = 0;
		   for (int i=1; i < recordSplit.length; i++)
		   {
			   sum += Integer.parseInt(recordSplit[i].trim()); // parse and add grades to get the sum
		   }
		   // find stats
		   double ave = sum / (recordSplit.length - 1); // subtract one so we don't take the name in, only the grades
		   studentRecord += "\tAverage Grade: " + ave;
		   
	   }
	   
	return studentRecord;
	
   }



   private static void addGradesToSet() 
   {
	   String studentRecord = "";
	   String fileHeader = "";
	   String colHeader = "";
	   boolean confirmReport = false;
       File classFile;
       Scanner inFile;
       Scanner in = new Scanner (System.in);
       JFileChooser chooser = new JFileChooser();
       PrintWriter outFile;
       int studentRecordCount = 0;
       int curGrade = 0;
       ArrayList<String> names = new ArrayList<>();
       FileNameExtensionFilter filter = new FileNameExtensionFilter("Class Set File", "txt", "text", "csv");
       chooser.addChoosableFileFilter(filter);
       File workingDirectory = new File(System.getProperty("user.dir"));
       chooser.setCurrentDirectory(workingDirectory);
       
       try
       {
    	   if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
    	   {
    		   classFile = chooser.getSelectedFile();
    		   inFile = new Scanner(classFile);
    		   fileHeader = inFile.nextLine(); 
    		   
    		   // loop and get names into ArrayList
    		   System.out.println(fileHeader);
    		   // write new col for grade and add it to existing fileHeader
    		   colHeader = SafeInput.getNonZeroLenString(in, "Enter header for grade column: [Lab01, Test03, Quiz06, etc.]");
    		   fileHeader = fileHeader + ", " + colHeader;
    		   
    		   System.out.println("============================================");
    		   while(inFile.hasNextLine())
    		   {
    			   studentRecord = inFile.nextLine();
    			   studentRecordCount++;
    			   names.add(studentRecord);
    			   // System.out.println(studentRecordCount + " " + studentRecord);
    			   System.out.println(formatRecordDisplay(studentRecordCount, studentRecord));
    		   }
    		   System.out.println("============================================");

    		   inFile.close();
    		   
    		   // confirm the teacher selected to correct class
    		   confirmReport = SafeInput.getYNConfirm(in, "Is this the class you'd like to enter grades for");
    		   if (confirmReport == true)
    		   {
	    		   for (int nm = 0; nm < names.size(); nm++)
	    		   {
	    			   // prompt with name of student to add grade for (0-100)
	    			   curGrade = SafeInput.getRangedInt(in, "Enter grade for: " + names.get(nm), 0, 100);
	    			   names.set(nm, names.get(nm) + ", " + curGrade);
	    		   }
    		   
	    		   // now write grades records to file
	    		   outFile = new PrintWriter(classFile);
	    		   outFile.println(fileHeader); // write the file header
    		   
	    		   for (String name : names)
	    		   {
	    			   outFile.println(name);
	    		   }
    		       outFile.close();
    		   }
    		   else
    		   {
    			   System.out.println("Returning to menu...");
    			   return;
    		   }
    		   
    	   }
    	   else
    	   {
    		   System.out.println("You must choose a file. \nReturning to menu...");
    		   in.close();
    		   return;
    	   }
    	   
       } 
       catch (FileNotFoundException ex) 
       {
    	   System.out.println("Error, could not create output file! Terminating the system.");
    	   System.exit(0);
       } 
       catch (IOException ex) 
       {
    	   ex.getStackTrace();
    	   System.exit(0);
       } 
	   
   } 


   private static void deleteGradeCol() 
   {
	   String studentRecord = "";
	   String fileHeader = "";
	   String colHeader = "";
	   boolean confirmReport = false;
       File classFile;
       Scanner inFile;
       Scanner in = new Scanner (System.in);
       JFileChooser chooser = new JFileChooser();
       PrintWriter outFile;
       ArrayList<String> lines = new ArrayList<>();
       FileNameExtensionFilter filter = new FileNameExtensionFilter("Class Set File", "txt", "text", "csv");
       chooser.addChoosableFileFilter(filter);
       File workingDirectory = new File(System.getProperty("user.dir"));
       chooser.setCurrentDirectory(workingDirectory);
       
       int studentRecordCount = 0;
       int curGrade = 0;
       int lowGrade = 0;
       int highGrade = 100;
       
       try
       {
    	   if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
    	   {
    		   classFile = chooser.getSelectedFile();
    		   inFile = new Scanner(classFile);
    		   fileHeader = inFile.nextLine(); 
    		   
    		   // loop and get names into ArrayList
    		   System.out.println(fileHeader);
    		   
    		   System.out.println("============================================");
    		   while(inFile.hasNextLine())
    		   {
    			   studentRecord = inFile.nextLine();
    			   studentRecordCount++;
    			   lines.add(studentRecord);
    			   // System.out.println(studentRecordCount + " " + studentRecord);
    			   System.out.println(formatRecordDisplay(studentRecordCount, studentRecord));
    		   }
    		   System.out.println("============================================");

    		   inFile.close();
    		   
    		   // confirm the teacher selected to correct class
    		   confirmReport = SafeInput.getYNConfirm(in, "Is this the class you'd like to delete a grade from");
    		   if (confirmReport == true)
    		   {
    			   // get delete choice
    			   String cols [] = fileHeader.split(",");
    			   int colToDelete = SafeInput.getRangedInt(in, "Which grade do you want to delete?" + "[1-" + (cols.length-1) + "]", 1, cols.length-1);
    			   
    			   // confirm delete choice
    			   if (!SafeInput.getYNConfirmB(in, "Are you sure you want to delete" + cols[colToDelete]))
    			   {
    				   System.out.println("Returning to menu...");
    				   return;
    			   }
    			   
    			   lines.add(0, fileHeader);
    			   
    			   // loop and add each line into its own ArrayList
	    		   outFile = new PrintWriter(classFile);
	    		   ArrayList<String> curLine = new ArrayList<>();
	    		   String formedLine = "";
	    		   
	    		   for (String li : lines)
	    		   {
	    			   curLine.clear();
	    			   cols = li.split(",");
	    			   for (int col = 0; col < cols.length; col++)
	    			   {
	    				   if (col != colToDelete)
	    				   {
	    					   curLine.add(cols[col]);
	    				   }
	    			   }
	    			   
	    			   formedLine = ""; // clear out formed line for each iteration
	    			   
	    			   for (int col = 0; col < curLine.size(); col++)
	    			   {
	    				   formedLine += curLine.get(col);
	    				   if (col != curLine.size() - 1)
	    				   {
	    					   formedLine += ", ";
	    				   }
	    			   }
	    			   outFile.println(formedLine);

	    		   }
    		       outFile.close();
    		       
        		   inFile = new Scanner(classFile);
        		   fileHeader = inFile.nextLine(); 
        		   
        		   // loop and get names into ArrayList
        		   System.out.println(fileHeader);
        		   
        		   System.out.println("============================================");
        		   while(inFile.hasNextLine())
        		   {
        			   studentRecord = inFile.nextLine();
        			   studentRecordCount++;
        			   lines.add(studentRecord);
        			   // System.out.println(studentRecordCount + " " + studentRecord);
        			   System.out.println(formatRecordDisplay(studentRecordCount, studentRecord));
        		   }
        		   System.out.println("============================================");

        		   inFile.close();
    		       
    		   }
    		   else
    		   {
    			   System.out.println("Returning to menu...");
    			   return;
    		   }
    		   
    	   }
    	   else
    	   {
    		   System.out.println("You must choose a file. \nReturning to menu...");
    		   in.close();
    		   return;
    	   }
    	   
       } 
       catch (FileNotFoundException ex) 
       {
    	   System.out.println("Error, could not create output file! Terminating the system.");
    	   System.exit(0);
       } 
       catch (IOException ex) 
       {
    	   ex.getStackTrace();
    	   System.exit(0);
       } 
      
   }

}
