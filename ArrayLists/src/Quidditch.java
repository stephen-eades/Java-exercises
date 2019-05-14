import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Quidditch 
{

	// Variables	
	static int teamA = 0;
	static int teamB = 1;
	static int teamAScore = 0;
	static int teamBScore = 0;
	static int teamATotal = 0;
	static int teamBTotal= 0;
	static int quarterScore[] = new int[2];
	static int overtimeScore[] = new int[2];
	static ArrayList<String> teams = new ArrayList<String>();
	static boolean snitchCaught = false;
	static boolean playAgainYN = false;
	static Random rand = new Random();
	static Scanner pipe = new Scanner(System.in);

		public static void main(String[] args) 
		{	
			
			do  
			{ // playAgain loop
			
				// Add teams to ArrayList index
				teams.add("Wizards"); // 1
				teams.add("Dragons"); // 2
				teams.add("Witches"); // 3
				teams.add("Elves"); // 4
				teams.add("Dwarfs"); // 5
				teams.add("Owls"); // 6
				teams.add("Snakes"); // 7
				teams.add("Goblins"); // 8
				
					// Introduction message - Explain rules and display teams
					System.out.println("Welcome to the Quidditch tournament!");
					System.out.println("They're a total of 8 teams in the tournament," 
							+ " with 0-40 points a quarter. The last team remaining"
							+ " is the crowned champion.\n");
				
						
						// First round loop - this will reduce ArrayList to 4 teams
						System.out.println("Round #1\r\n" 
							+ "======================================" + "");
						for (int j = 0; j < 4; j++)
						{
							// Cycle teams by adding 1 to index value each iteration
							playGame(teamA, teamB, teams);
							teamA = teamA + 1;
							teamB = teamB + 1;
						}
							
						// Output results and reset variables
						System.out.println("   " + "Remaining teams after round 1: ");
						for (int m = 0; m < 4; m++)
						{
							System.out.println("   " + teams.get(m));
						}
						teamA = 0;
						teamB = 1;
						System.out.println("");
						
				
						// Second round loop - this will reduce ArrayList to 2 teams
						System.out.println("Round #2\r\n" 
							+ "======================================" + "");	
						for (int j = 0; j < 2; j++)
						{
							// Cycle teams by adding 1 to index value each iteration
							playGame(teamA, teamB, teams);
							teamA = teamA + 1;
							teamB = teamB + 1;
						}
							
						// output results and reset variables
						System.out.println("   " + "Remaining teams after round 2: ");
						for (int m = 0; m < 2; m++)
						{
							System.out.println("   " + teams.get(m));
						}
						teamA = 0;
						teamB = 1;
						System.out.println("");
	
				
						// Championship round - one team remaining in ArrayList
						System.out.println("Championship Round\r\n" 
							+ "======================================" + "");	
						playGame(teamA, teamB, teams);
				
						// Show champion and clear arrayList for next round
						System.out.println("The champion of the tournament is " + teams.get(0));
						teams.remove(0);
						String prompt = ("Would you like to play again?: [Y/N] ");
						playAgainYN = SafeInput.getYNConfirm(pipe, prompt);
				
			} while (playAgainYN == true);
			
		}



	/** 
	* @param int teamA = the index for the first team 
    	* @param int teamB = the index for the second team
    	* @param ArrayList teams = array containing each team
    	*/ 
	public static void playGame (int teamA, int teamB, ArrayList<String> teams) 
	{
		
		// variables
		int i = 0;
		int quarterCount = 0;
		int overtimeCount = 0;
			
			// Game statement
			System.out.println("   " + teams.get(teamA) + " vs " + teams.get(teamB));
			System.out.println("   " + "-------------------------");

			// Play 4 quarters
			for (i = 0; i < 4; i++)
			{
				// Store quarter points in var
				quarterScore = playQuarter();
				quarterCount++;

				// Check for snitch
				if (snitchCaught == true)
				{
					// Randomely determine the winner
					System.out.println("   " + "The game is over. The winner is...");
					int generate = rand.nextInt(2);		

						if (generate == 0)
						{
							System.out.println("   " + "The " + teams.get(teamA) + "! " + teams.get(teamB) + " are eliminated");
							teams.remove(teamB);
							break;
						}
						else if (generate == 1)
						{
							System.out.println("   " + "The " + teams.get(teamB) + "! " + teams.get(teamA) + " are eliminated");
							teams.remove(teamA);
							break;
						}

				}

				// Display each teams score for the quarter
				teamAScore = quarterScore[0];
				teamBScore = quarterScore[1];
				System.out.println("   " + "Qtr " + quarterCount + ": " + teamAScore + "   " + teamBScore);

				// Total each teams points for final score
				teamATotal = teamATotal + teamAScore;
				teamBTotal = teamBTotal + teamBScore;

			} // End of 4 quarters
			quarterCount = 0;


			// Check for overtime
			if (snitchCaught == false && teamATotal == teamBTotal)
			{
				do
				{
					// Play overtime
					overtimeScore = playQuarter();
					overtimeCount++;
					teamATotal = teamATotal + overtimeScore[0];
					teamBTotal = teamBTotal + overtimeScore[1];
					System.out.println("   " + "OT " + overtimeCount + ": " + teamATotal + "   " + teamBTotal);
				} 
				while (teamATotal == teamBTotal);
			}


			// Determine winner
			if (snitchCaught == false)
			{
				// Determine winning and losing team
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

			 // Padding for end of each game
			System.out.println("   " + "-------------------------");

		// reset variables for next game		
		teamAScore = 0;
		teamBScore = 0;
		teamATotal = 0;
		teamBTotal = 0;
		
	} // end game 
		

	
	/** 
	* @return quarterScore = array with each teams score that quarter
	*/ 
	public static int[] playQuarter () 
	{
		
		// Variables
		int quarterPoints[] = new int[2];

			// Generate each teams score
			quarterPoints[0] = rand.nextInt(40);
			quarterPoints[1] = rand.nextInt(40);

			// Catch snitch method
			snitchCaught = catchSnitch();

			if (snitchCaught == true)
			{
				System.out.println("   " + "The snitch has been caught!");
			}
		
		return quarterPoints; // returns an array with two values, the score of teamA and teamB in the quarter
	}
		
		
	/** 
	* @return snitchValue = if the snitch was caught or not
	*/ 
	public static boolean catchSnitch () 
	{

		// Variables
		boolean snitchValue = false;
		int snitchChance = 0;

			// Generate number 1-100
			snitchChance = rand.nextInt(100);

			// If number is in [0-15] range, we return that it was caught
			if (snitchChance > 0 && snitchChance <= 15)
			{
				snitchValue = true;
			}

		return snitchValue;
	}

}
