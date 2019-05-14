package mypackage;
 
import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
 
/**
* @author Stephen Eades
*/
public class GradeBook 
{
	
   	public static void main(String[] args) 
   	{
		
	   	// Variables
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
		
		  	// Build the menu
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
				// Display menu and get choice
				menuChoice = SafeInput.getRangedInt(console, menu, low, high);
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
   
	
   	/**
	* Allows the user to create a class set and add student names
	*/
	private static void createClassSet() 
   	{
		
		// Variables
		File classFile;
       		PrintWriter out;
       		String classFileName = "";
       		String studentName = "";
       		boolean doneNameInput = false;
       		Scanner in = new Scanner (System.in);
       		ArrayList<String> names = new ArrayList<>();
       
			// Name the class set
			System.out.print("Enter the name of the class file [1st grade math]: ");
			classFileName = in.nextLine();
       
		       	try
		       	{
			   	do 
			   	{
					// Loop and get the student names, then prompt to add another student
				   	System.out.print("Enter the student name [First Last]: ");
				   	studentName = in.nextLine();
				   	names.add(studentName);
					
				   	if (!SafeInput.getYNConfirm(in, "Enter another student"))
				   	{
					   	doneNameInput = true;
				   	}

			   	} while (!doneNameInput);

				// Create the file in directory
				classFile = new File(classFileName + ".txt");
				out = new PrintWriter(classFile);

				// Write the header and student names, then close the file
				out.println(classFileName);
				for (String nm : names)
				{
				   	out.println(nm);
				}
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
   

	/**   
	* Allows the user to display their class set
	*/	
   	private static void displayClassSet() 
   	{
		
		// Variables
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
					// User chooses file to display
				   	classFile = chooser.getSelectedFile();
				   	inFile = new Scanner(classFile);
				   	fileHeader = inFile.nextLine();
    		   
    		   			// Loop through file and get each student name, format and display before closing file
    		   			System.out.println(fileHeader);
    		   			System.out.println("============================================");
    		   			while(inFile.hasNextLine())
    		   			{
    			   			studentRecord = inFile.nextLine();
    			   			studentRecordCount++;
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
   
	
   	/**   
	* Formats the display of student records, used in displayClassSet() method
	* @param studentRecordCount the number of students
	* @param studentRecord the student associated with that record
	*/	
   	private static String formatRecordDisplay(int studentRecordCount, String studentRecord) 
   	{
		
		// Provide format and split on comma in String Array
	   	String ret = "" + studentRecordCount + " " + studentRecord;
	   	String [] recordSplit = studentRecord.split(",");
	   
	   	if (recordSplit.length > 1)
	   	{
		   	// Find minimum and add to studentRecord var
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
		   
			
		   	// Find maximum and add to studentRecord var
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
		   
			
		   	// Find average and add to studentRecord var
		   	int sum = 0;
		   	for (int i=1; i < recordSplit.length; i++)
		   	{
			   	sum += Integer.parseInt(recordSplit[i].trim());
		   	}
		   	// Subtract one so we don't take the name in, only the grades
		   	double ave = sum / (recordSplit.length - 1);
		   	studentRecord += "\tAverage Grade: " + ave;
		   
	   	}
	   
	    return studentRecord;
	
   	}

///////////////////////////////////////	
///////////////BOOKMARK////////////////
///////////////////////////////////////	
	
   	/**   
	* Adds grades to a class set
	*/	
   	private static void addGradesToSet() 
   	{
		// Variables
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
