package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import soccer.Goalie;

public class GoalieClass {

	String firstName;
	String lastName;
	int number;
	Goalie g1;

	@Before
	public void main() {
		firstName = "Ricky";
		lastName = "Bobby";
		number = 7;
		g1 = new Goalie(firstName, lastName, number);
	}

	@Test
	public void goalieTestConstructor1() {
	    assertEquals("test constructor: fullName", firstName + " " + lastName, g1.getFullName());
	}
	
	@Test
	public void goalieTestConstructor2() {
	    assertEquals("test constructor: firstName", firstName, g1.getFirstName());
	}

	@Test
	public void goalieTestConstructor3() {
	    assertEquals("test constructor: lastName", lastName, g1.getLastName());
	}

	@Test
	public void goalieTestConstructor4() {
	    assertEquals("test constructor: number", number, g1.getNumber());
	}

	@Test
	public void goalieTestConstructor5() {
	    assertEquals("test constructor: gamesPlayed", 0, g1.getGamesPlayed());
	}

	@Test
	public void goalieTestConstructor6() {
	    assertEquals("test constructor: shots", 0, g1.getShots());
	}

	@Test
	public void goalieTestConstructor7() {
	    assertEquals("test constructor: goals", 0, g1.getGoals());
	}

	@Test
	public void goalieTestConstructor8() {
	    assertEquals("test constructor: redCards", 0, g1.getRedCards());
	}

	@Test
	public void goalieTestConstructor9() {
	    assertEquals("test constructor: yellowCards", 0, g1.getYellowCards());
	}

	@Test
	public void goalieTestConstructor10() {
	    assertEquals("test constructor: penaltyKicks", 0, g1.getPenaltyKicks());
	}

	@Test
	public void goalieTestConstructor11() {
	    assertEquals("test constructor: gamesPlayed", 0, g1.getGamesPlayed());
	}
	
	@Test
	public void goalieTestConstructor12() {
		assertEquals("test constructor: saves", 0, g1.getSaves());
	}
	
	@Test
	public void goalieTestConstructor13() {
		assertEquals("test constructor: goalsAllowed", 0, g1.getGoalsAllowed());
	}

}

