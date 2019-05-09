import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// Class
public class Quidditch 
{

	// Class variables	
	static int teamA = 0;
	static int teamB = 1;
	static int teamAScore = 0;
	static int teamBScore = 0;
	static int teamATotal = 0;
	static int teamBTotal= 0;
	static boolean snitchCaught = false;
	static boolean playAgainYN = false;
	static ArrayList<String> teams = new ArrayList<String>();
	static int quarterScore[] = new int[2]; // initialize arrayList
	static int overtimeScore[] = new int[2]; // initialize arrayList
	static Random rand = new Random();
	static Scanner pipe = new Scanner(System.in);
	
		// Main Method
		public static void main(String[] args) 
		{
	
			
			do 
			{ // playAgain loop
			
				// Variables
				teams.add("Wizards"); // 1
				teams.add("Dragons"); // 2
				teams.add("Witches"); // 3
				teams.add("Elves"); // 4
				teams.add("Dwarfs"); // 5
				teams.add("Owls"); // 6
				teams.add("Snakes"); // 7
				teams.add("Goblins"); // 8
				
					// Introduction message, welcoming the user to the tournament. Explain rules of Quidditch.
					// display all team names with (print teams *use whatever method to print out all teams in array)
					System.out.println("Welcome to the Quidditch tournament!");
					System.out.println("They're a total of 8 teams in the tournament, with 0-40 points a quarter. The last team remaining "
							+ "is the crowned champion.\n");
					System.out.println("Round #1\r\n" + 
							"======================================" + 
							"");
					
				
						// loop for first round - run 4 times, this will reduce arrayList to only 4 teams
						for (int j = 0; j < 4; j++)
						{
							// playGame method and change teams playing by adding 2
							playGame(teamA, teamB, teams);
							teamA = teamA + 1;
							teamB = teamB + 1;
				
						} // end first round loop
							
							// output results and reset variables
							System.out.println("   " + "Remaining teams after round 1: ");
							for (int m = 0; m < 4; m++)
							{
								System.out.println("   " + teams.get(m));
							}
							teamA = 0;
							teamB = 1;
							System.out.println("");
						
						System.out.println("Round #2\r\n" + 
								"======================================" + 
								"");	
						// loop for second round  - run 2 times, this will reduce arrayList to only 2 teams
						for (int j = 0; j < 2; j++)
						{
							// playGame method and change teams playing by adding 2
							playGame(teamA, teamB, teams);
							teamA = teamA + 1;
							teamB = teamB + 1;
				
						} // end second round loop
							
							// output results and reset variables
							System.out.println("   " + "Remaining teams after round 2: ");
							for (int m = 0; m < 2; m++)
							{
								System.out.println("   " + teams.get(m));
							}
							teamA = 0;
							teamB = 1;
							System.out.println("");
	
						System.out.println("Championship Round\r\n" + 
								"======================================" + 
								"");
						// play championship round using playGame method
						playGame(teamA, teamB, teams);
				
						// Show champion and clear arrayList for next round
						System.out.println("The champion of the tournament is " + teams.get(0));
						teams.remove(0);
						
							// play again
							String prompt = ("Would you like to play again?: [Y/N] ");
							playAgainYN = SafeInput.getYNConfirm(pipe, prompt);
				
			} while (playAgainYN == true); // end playAgain loop
			
		} // end main



	/*
	 * Helper Methods
	 * 
	 * 
	    * 
	    * @param int teamA = the index for the first team 
	    * @param int teamB = the index for the second team
	    * @param ArrayList teams = array containing each team
	    */ 
		public static void playGame (int teamA, int teamB, ArrayList<String> teams) 
		{
			
			// variables for method
			int i = 0;
			int quarterCount = 0;
			int overtimeCount = 0;
			
				// game statement
				System.out.println("   " + teams.get(teamA) + " vs " + teams.get(teamB));
				System.out.println("   " + "-------------------------");
					// method for quarter (loop 4 times)
					for (i = 0; i < 4; i++)
					{
						// play the quarter and store to a var
						quarterScore = playQuarter();
						quarterCount++;
						
							// check if the snitch was caught each quarter
							if (snitchCaught == true)
							{
								// determine the winner
								System.out.println("   " + "The game is over. The winner is...");
								// Randomly choose
								int generate = rand.nextInt(2);		
								
									if (generate == 0)
									{
										System.out.println("   " + "The " + teams.get(teamA) + "! " + teams.get(teamB) + " are eliminated");
										teams.remove(teamB); // remove the losing team
										break;
									}
									else if (generate == 1)
									{
										System.out.println("   " + "The " + teams.get(teamB) + "! " + teams.get(teamA) + " are eliminated");
										teams.remove(teamA); // remove the losing team
										break; // end the game loop
									}
									
							} // end snitchCaught block
						
						// set returned array with scores to each team
						teamAScore = quarterScore[0];
						teamBScore = quarterScore[1];
						System.out.println("   " + "Qtr " + quarterCount + ": " + teamAScore + "   " + teamBScore);
						
						// add quarter score to total for each team
						teamATotal = teamATotal + teamAScore;
						teamBTotal = teamBTotal + teamBScore;
						
						
					}
					quarterCount = 0;
					
					// if statement to check for overtime (if teamATotal == teamBTotal)
					if (snitchCaught == false && teamATotal == teamBTotal)
					{
						do
						{
							overtimeScore = playQuarter();
							overtimeCount++;
							teamATotal = teamATotal + overtimeScore[0];
							teamBTotal = teamBTotal + overtimeScore[1];
							System.out.println("   " + "OT " + overtimeCount + ": " + teamATotal + "   " + teamBTotal);
						} 
						while (teamATotal == teamBTotal);
					}
					
					
					// determine our winner (after overtime)
					if (snitchCaught == false)
					{
						// determine winning and losing team if snitchCaught == false
						if (teamATotal > teamBTotal)
						{
							System.out.println("   " + teams.get(teamA) + " win " + teamATotal + " to " + teamBTotal + ". The " + teams.get(teamB) 
							+ " are eliminated.");
							teams.remove(teamB);
						}
						else if (teamATotal < teamBTotal)
						{
							System.out.println("   " + teams.get(teamB) + " win " + teamBTotal + " to " + teamATotal + ". The " + teams.get(teamA) 
							+ " are eliminated.");
							teams.remove(teamA);
						}
					}
				
								
					System.out.println("   " + "-------------------------"); // padding for end of each game
					
			// reset variables for next game		
			teamAScore = 0;
			teamBScore = 0;
			teamATotal = 0;
			teamBTotal = 0;
		} // end game 
		
		
	/*
	 * 
	    * @return quarterScore = array with two values for each teams score in the quarter
	    */ 
		public static int[] playQuarter () 
		{
			
			// Variables
			int quarterPoints[] = new int[2]; // initialize array
			
				// generate each teams score
				quarterPoints[0] = rand.nextInt(40); // generate random score for teamA
				quarterPoints[1] = rand.nextInt(40); // generate random score for teamB
			
				// method for catching golden Snitch
				snitchCaught = catchSnitch();
				
					// if statement that will determine if the snitch was caught above or not
					if (snitchCaught == true)
					{
						System.out.println("   " + "The snitch has been caught!");
					}
			
			return quarterPoints; // returns an array with two values, the score of teamA and teamB in the quarter
		}
		
		
	/*
	 * 
	    * @return snitchTrueFalse
	    */ 
		public static boolean catchSnitch () 
		{
			
			// Variables
			boolean snitchValue = false;
			int snitchChance = 0;
			
				// generate number 1-100
				snitchChance = rand.nextInt(100);
				
					// if statement - for if the snitch is caught or not
					if (snitchChance > 0 && snitchChance <= 15)
					{
						snitchValue = true; // the snitch was caught! return true
					}
			
			return snitchValue; // the snitch was not caught
		}
	

}