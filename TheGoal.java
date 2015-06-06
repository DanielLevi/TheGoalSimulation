import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class TheGoal 
{
	public static void main(String[] args)
	{
		// open scanner for text input
		Scanner stdin = new Scanner(System.in);
		
		// prompt for number of players
		System.out.println("How many players will be playing?");
		int totalPlayers = stdin.nextInt();
		
		// prompt for number of rounds
		System.out.println("How many rounds do you want to play?");
		int totalRounds = stdin.nextInt();
		
		// close scanner
		stdin.close();
		
		// populate total players into Player array
		Player[] players = new Player[totalPlayers];
		for (int i = 0; i < totalPlayers; i++) 
		{
			players[i] = new Player();
		}
		
		// instantiate die
		Die die = new Die();

		// for comparison to player's matchCount and dieVal
		int availableMatches;
		int matchesMoved = 0;
		
		// play game
		for (int i = 0; i < totalRounds; i++)
		{
			for (int j = 0; j < totalPlayers; j++) 
			{
				die.roll(); // determine number of matches to move
				int dieVal = die.getValue();
				System.out.printf("%s, ", dieVal); // for troubleshooting
				
				// determine available matches
				if (j == 0) {
					availableMatches = 6; // unlimited matches available to player 1, therefore set max value
				}
				else {
					availableMatches = players[j].getMatchCount();
				}
				
				// remove matches from current player (either dieVal or all availableMatches depending on which is greater)
				if (j == 0) {
					matchesMoved = dieVal; // no matches removed if player is player 1
				}
				else if (j != 0) {
					if (availableMatches > dieVal) {
						players[j].removeMatch(dieVal);
						matchesMoved = dieVal;
					}
					else {
						players[j].removeMatch(availableMatches);
						matchesMoved = availableMatches;
					}
				}
				
				// add matches
				if (j != totalPlayers - 1) { 
					if (availableMatches > dieVal) {
						players[j+1].addMatch(dieVal);
					}
					else {
						players[j+1].addMatch(availableMatches);
					}
				}
				
				// append changes to throughput
				players[j].appendChanges(matchesMoved - 3.5);
			}
		}
		
		System.out.printf("\n");
		for (int i = 0; i < totalPlayers; i++) {
			for (Double change : players[i].totalChangeQueue) {
				System.out.printf("%4s, ",  change);
			}
			System.out.printf("\n");
		}
		
		try {
		FileWriter writer = new FileWriter("test1.csv");
		
		for (int i = 0; i < totalPlayers; i++) {
			for (Double change : players[i].totalChangeQueue) {
				writer.append(change.toString());
				writer.append(',');
			}
			writer.append('\n');
		}
		
		writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
