package mypackage;

import java.util.Scanner;

public class partyAffil 
{

	public static void main(String[] args) 
	{
		
		// Variables
		Scanner in = new Scanner(System.in);
		String userParty = "";
		
			// Display menu of options and get user political party
			System.out.println("Using the menu below, please enter your political affiliation:");
			System.out.println("D = Democratic");
			System.out.println("R = Republican");
			System.out.println("I = Independent");
			userParty = in.nextLine();
		
				// Process party response and display output
				if (userParty.equalsIgnoreCase("D")) 
				{
					System.out.println("You entered: " + userParty + ". You get a democratic donkey!");
				}
				else if (userParty.equalsIgnoreCase("R"))
				{
					System.out.println("You entered: " + userParty + ". You get a republican elephant!");
				}
				else if (userParty.equalsIgnoreCase("I"))
				{
					System.out.println("You entered: " + userParty + ". You get an independent person!");
				}
				else
				{
					// terminate the program upon invalid user input
					System.out.println("You entered an incorrect value. Please restart and try again using the menu options.");
					System.exit(0); 
				}
			
		in.close(); // Closing scanner resource
	}

}
