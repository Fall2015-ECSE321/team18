package test;

import static org.junit.Assert.*;

import org.junit.*;

import soccer.*;

public class LeagueClass {

	
    League lea1;
    String leagueName;

    @Before
	public void main() {
		Team t1 = new Team("Habs1");
    	Team t2 = new Team("Habs2");
		Team t3 = new Team("Habs3");
    	Team t4 = new Team("Habs4");
    	leagueName = "BigLeagues";
    	lea1 = new League(leagueName);
    	lea1.addTeam(t1);
    	lea1.addTeam(t2);
    	lea1.addTeam(t3);
    	lea1.addTeam(t4);
	}

	@Test
	public void leagueTestConstructor1() {
	    assertEquals("test constructor: name", leagueName, lea1.getName());
	}

	@Test
	public void leagueTestConstructor2() {
	    assertEquals("test constructor: teams", 4, lea1.getTeams().size());
	}

}
