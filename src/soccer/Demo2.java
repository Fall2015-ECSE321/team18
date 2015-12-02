package soccer;

import java.util.ArrayList;
import java.util.List;

import persistence.PersistenceXStream;

public class Demo2 {

  public static void main(String argv[]) {


    System.out.println("This is the Soccer Stats Application Demo2");
    
    League L1 = new League("league");
    
    Season season = new Season("W_2015-2016", L1);
    
    // A few dummy Teams
    Team a = new Team("A");
    Team b = new Team("B");
    Team c = new Team("C");
    Team d = new Team("D");
    Team e = new Team("E");
    Team f = new Team("F");
    
    //Populating dummy Teams with Players
    addTeamPlayers(a,"A");
    addTeamPlayers(b,"B");
    addTeamPlayers(c,"C");
    addTeamPlayers(d,"D");
    addTeamPlayers(e,"E");
    addTeamPlayers(f,"F");
    
    // Creating dummy Matches
    Match match1 = new Match(season);
    Match match2 = new Match(season);
    Match match3 = new Match(season);
    
    //Set teams participating in match1
    
    match1.setSubscribedHomeTeam(a);
    match1.setSubscribedAwayTeam(b);
    
    // Players participating in match1
    List<Player> teamA;
    List<Player> teamB;
    
    teamA = a.getPlayers();
    teamB = b.getPlayers();
    
    Goalie gA = (Goalie) teamA.get(0);
    Goalie gB = (Goalie) teamB.get(0);
    
    Player pA1 = teamA.get(3);
    Player pB1 = teamB.get(3);
    
    Player pA2 = teamA.get(5);
    Player pB2 = teamB.get(5);
    
    Player pA3 = teamA.get(7);
    Player pB3 = teamB.get(7);
    
    Player pA4 = teamA.get(9);
    Player pB4 = teamB.get(9);
    
    Player pA5 = teamA.get(11);
    Player pB5 = teamB.get(11);
    
    // MatchEvents for match1
    ShotEvent m1s1 = new ShotEvent();
    m1s1.setSubscribedGoalie(gA);
    m1s1.setSubscribedPlayer(pB1);
    m1s1.setScored(false);
    
    ShotEvent m1s2 = new ShotEvent();
    m1s2.setSubscribedGoalie(gA);
    m1s2.setSubscribedPlayer(pB2);
    m1s2.setScored(true);
    
    ShotEvent m1s3 = new ShotEvent();
    m1s3.setSubscribedGoalie(gB);
    m1s3.setSubscribedPlayer(pA1);
    m1s3.setScored(true);
    
    ShotEvent m1s4 = new ShotEvent();
    m1s4.setSubscribedGoalie(gB);
    m1s4.setSubscribedPlayer(pA2);
    m1s4.setScored(false);
    
    InfractionEvent m1i1 = new InfractionEvent();
    m1i1.setSubscribedPlayer(pB3);
    m1i1.setPenaltyKick(true);
    
    InfractionEvent m1i2 = new InfractionEvent();
    m1i2.setSubscribedPlayer(pB4);
    m1i2.setYellowCard(true);
    
    InfractionEvent m1i3 = new InfractionEvent();
    m1i3.setSubscribedPlayer(pB5);
    m1i3.setRedCard(true);
    
    InfractionEvent m1i4 = new InfractionEvent();
    m1i4.setSubscribedPlayer(pA3);
    m1i4.setPenaltyKick(true);
    
    InfractionEvent m1i5 = new InfractionEvent();
    m1i5.setSubscribedPlayer(pA4);
    m1i5.setYellowCard(true);
    
    InfractionEvent m1i6 = new InfractionEvent();
    m1i6.setSubscribedPlayer(pA5);
    m1i6.setRedCard(true);
    
    // add MatchEvents to match1
    match1.addMatchEvent(m1s1);
    match1.addMatchEvent(m1s2);
    match1.addMatchEvent(m1s3);
    match1.addMatchEvent(m1s4);
    match1.addMatchEvent(m1i1);
    match1.addMatchEvent(m1i2);
    match1.addMatchEvent(m1i3);
    match1.addMatchEvent(m1i4);
    match1.addMatchEvent(m1i5);
    match1.addMatchEvent(m1i6);
    
    //end match1
    
    match1.endMatch();
    
    
    
    

    System.out.println("\n\n\n\nend of Demo");
    }
  
  	// adds 2 goalies and 10 players to specified team
  	private static void addTeamPlayers(Team teamX, String playerChar){
  		
  		Goalie goalie0 = new Goalie("f"+playerChar+"0","l"+playerChar+"0", 0);
  		Goalie goalie1 = new Goalie("f"+playerChar+"1","l"+playerChar+"1", 1);
  		
  		teamX.addPlayer(goalie0);
  		teamX.addPlayer(goalie1);
	  
  		for (Integer i=2; i<12; i++){
  			String firstName = "f"+ i.toString();
  			String lastName = "l"+ i.toString();
  			int playerNum = i;
  			Player playerX = new Player(firstName, lastName, playerNum);
  		
  			teamX.addPlayer(playerX);
  		}
    
    
  	}
}
