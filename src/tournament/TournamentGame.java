package tournament;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Chapter 6: Using Ordered List: Tournament Maker
 * 
 * java Software Structures : Designing and Using Data Structures
 * 		LEWIS | CHASE
 * 
 * @author Jigar Gosalia
 *
 */
public class TournamentGame {

	public static void main(String[] args) {
		Deque<Team> teams = new LinkedList<Team>();
		teams.addLast(new Team("Scorecards", 10));
		teams.addLast(new Team("Gutterballs", 9));
		teams.addLast(new Team("KingPins", 8));
		teams.addLast(new Team("PinDoctors", 7));
		teams.addLast(new Team("Spares", 5));
		teams.addLast(new Team("Splits", 4));
		teams.addLast(new Team("Tenpins", 3));
		teams.addLast(new Team("Woodsplitters", 2));
		game(teams);
	}

	public static void game(Deque<Team> teams) {
		int games = teams.size()/2;
		for (int game=1; game<=games; game++) {
			String team1 = teams.removeFirst().name;
			String team2 = teams.removeLast().name;
			System.out.printf("Game %-2d : %-14s v/s %-14s winner to play winner of Game %-2d\n", 
					game, team1, team2, (games+1) - game);
		}
	}
}

class Team implements Comparable<Team> {

	public String name;
	public int wins;
	
	public Team(String name, int wins) {
		this.name = name;
		this.wins = wins;
	}
	
	@Override
	public int compareTo(Team o) { return this.wins - o.wins; }

	@Override
	public String toString() { return name; }
}