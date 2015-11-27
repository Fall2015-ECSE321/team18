package test;

import static org.junit.Assert.*;

import org.junit.*;

import soccer.*;

public class TeamClass {

	
    Team t1;
    String teamName;

    @Before
	public void main() {
		Player p1 = new Player("Ricky1", "Bobby1", 1);
    	Player p2 = new Player("Ricky2", "Bobby2", 2);
    	Player p3 = new Player("Ricky3", "Bobby3", 3);
    	Player p4 = new Player("Ricky4", "Bobby4", 4);
    	teamName = "Habs";
    	t1 = new Team(teamName);
    	t1.addPlayer(p1);
    	t1.addPlayer(p2);
    	t1.addPlayer(p3);
    	t1.addPlayer(p4);
	}

	@Test
	public void teamTestConstructor1() {
	    assertEquals("test constructor: name", teamName, t1.getName());
	}

	@Test
	public void teamTestConstructor2() {
	    assertEquals("test constructor: gamesPlayed", 0, t1.getGamesPlayed());
	}

	@Test
	public void teamTestConstructor3() {
	    assertEquals("test constructor: points", 0, t1.getPoints());
	}

	@Test
	public void teamTestConstructor4() {
	    assertEquals("test constructor: wins", 0, t1.getWins());
	}

	@Test
	public void teamTestConstructor5() {
	    assertEquals("test constructor: losses", 0, t1.getLosses());
	}

	@Test
	public void teamTestConstructor6() {
	    assertEquals("test constructor: draws", 0, t1.getDraws());
	}

	@Test
	public void teamTestConstructor7() {
	    assertEquals("test constructor: draws", 0, t1.getDraws());
	}

	@Test
	public void teamTestConstructor8() {
	    assertEquals("test constructor: shots", 0, t1.getShots());
	}

	@Test
	public void teamTestConstructor9() {
	    assertEquals("test constructor: goalsFor", 0, t1.getGoalsFor());
	}

	@Test
	public void teamTestConstructor10() {
	    assertEquals("test constructor: goalsAgainst", 0, t1.getGoalsAgainst());
	}

	@Test
	public void teamTestConstructor11() {
	    assertEquals("test constructor: redCards", 0, t1.getRedCards());
	}

	@Test
	public void teamTestConstructor12() {
	    assertEquals("test constructor: yellowCards", 0, t1.getYellowCards());
	}

	@Test
	public void teamTestConstructor13() {
	    assertEquals("test constructor: penaltyKicks", 0, t1.getPenaltyKicks());
	}

	@Test
	public void teamTestConstructor14() {
	    assertEquals("test constructor: matchResultsAPplied", 0, t1.getMatchResultsApplied().size());
	}

	@Test
	public void teamTestConstructor15() {
	    assertEquals("test constructor: players", 4, t1.getPlayers().size());
	}

}
