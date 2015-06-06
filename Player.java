import java.util.concurrent.atomic.AtomicInteger;

public class Player 
{	
	// keep track of player number
	static AtomicInteger nextPlayerNumber = new AtomicInteger();
	public final int playerNumber;
	
	// keep track of total players
	private static int totalPlayers = 0;

	// keep track of player's matches
	private int matchCount;
	
	// get total player count
	static public int getTotalPlayers() {
		return totalPlayers;
	}
	
	// Double queue for tracking changes
	public Queue<Double> totalChangeQueue = new Queue<Double>();
	private double totalChange;
	
	// constructor
	public Player() {
		// playerNumber will start from 1
		playerNumber = nextPlayerNumber.incrementAndGet();
		
		// increment totalPlayers
		totalPlayers = totalPlayers + 1;
	}
	
	// add matches to player
	public void addMatch(int N) {
		matchCount += N;
	}
	
	// remove matches from player
	public void removeMatch(int N) {
		matchCount -= N;
	}
	
	// return match count
	public int getMatchCount() {
		return matchCount;
	}
	
	public void appendChanges(double N) {
		totalChange += N;
		totalChangeQueue.enqueue(totalChange);
	}
	
	public static void main(String[] args) 
	{
		Player player = new Player();
		System.out.print(player.matchCount);
		System.out.print("\n");
		player.addMatch(1);
		System.out.print(player.matchCount);
		System.out.print("\n");
		player.addMatch(5);
		System.out.println(player.matchCount);
	}
}
