package test;

import static org.junit.Assert.*;

import org.junit.*;

import soccer.*;

public class PlayerClass {

	String firstName;
	String lastName;
	int number;
	Player p1;

	@Before
	public void main() {
		firstName = "Ricky";
		lastName = "Bobby";
		number = 7;
		p1 = new Player(firstName, lastName, number);
	}

	@Test
	public void playerTestConstructor1() {
	    assertEquals("test constructor: fullName", firstName + " " + lastName, p1.getFullName());
	}
	
	@Test
	public void playerTestConstructor2() {
	    assertEquals("test constructor: firstName", firstName, p1.getFirstName());
	}

	@Test
	public void playerTestConstructor3() {
	    assertEquals("test constructor: lastName", lastName, p1.getLastName());
	}

	@Test
	public void playerTestConstructor4() {
	    assertEquals("test constructor: number", number, p1.getNumber());
	}

	@Test
	public void playerTestConstructor5() {
	    assertEquals("test constructor: gamesPlayed", 0, p1.getGamesPlayed());
	}

	@Test
	public void playerTestConstructor6() {
	    assertEquals("test constructor: shots", 0, p1.getShots());
	}

	@Test
	public void playerTestConstructor7() {
	    assertEquals("test constructor: goals", 0, p1.getGoals());
	}

	@Test
	public void playerTestConstructor8() {
	    assertEquals("test constructor: redCards", 0, p1.getRedCards());
	}

	@Test
	public void playerTestConstructor9() {
	    assertEquals("test constructor: yellowCards", 0, p1.getYellowCards());
	}

	@Test
	public void playerTestConstructor10() {
	    assertEquals("test constructor: penaltyKicks", 0, p1.getPenaltyKicks());
	}

	@Test
	public void playerTestConstructor11() {
	    assertEquals("test constructor: gamesPlayed", 0, p1.getGamesPlayed());
	}

}
