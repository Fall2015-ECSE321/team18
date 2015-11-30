package soccer;
public class Demo0 {

  public static void main(String argv[]) {


    System.out.println("This is the Soccer Stats Application Demo0");


    Player p1 = new Player("Ricky1", "Bobby1", 1);
    Player p2 = new Player("Ricky2", "Bobby2", 2);
    Player p3 = new Player("Ricky3", "Bobby3", 3);
    Player p4 = new Player("Ricky4", "Bobby4", 4);
    Goalie p5 = new Goalie("Ricky5", "Bobby5", 5);
    Goalie p6 = new Goalie("Ricky6", "Bobby6", 6);

    System.out.println(p1.toString());
    System.out.println(p2.toString());
    System.out.println(p3.toString());
    System.out.println(p4.toString());
    System.out.println(p5.toString());


    Team t1 = new Team("Habs");

    System.out.println(t1.addPlayer(p1));
    System.out.println(t1.addPlayer(p2));
    System.out.println(t1.addPlayer(p3));
    System.out.println(t1.addPlayer(p4));
    System.out.println(t1.addPlayer(p5));

    System.out.println(t1.addPlayer(p1));
    System.out.println(t1.addPlayer(p2));
    System.out.println(t1.addPlayer(p3));
    System.out.println(t1.addPlayer(p4));
    System.out.println(t1.addPlayer(p5));

    System.out.println(t1.toString());

    System.out.println(t1.getPlayers().toString());

    Team t2 = new Team("Habs2");
    t2.addPlayer(p1);
    t2.addPlayer(p2);
    t2.addPlayer(p5);

    Team t3 = new Team("Habs3");
    t3.addPlayer(p3);
    t3.addPlayer(p4);
    t3.addPlayer(p6);



    League l = new League("BigLeagues");

    System.out.println(l.addTeam(t1));
    System.out.println(l.addTeam(t2));
    System.out.println(l.addTeam(t3));

    System.out.println(l.addTeam(t1));
    System.out.println(l.addTeam(t2));
    System.out.println(l.addTeam(t3));

    System.out.println(l.toString());


    System.out.println(l.getTeams().toString());

    ShotEvent se1 = new ShotEvent();
    System.out.println(se1.toString());
    se1.setSubscribedPlayer(p5);
    se1.setScored(true);
    se1.setSubscribedGoalie(p6);
    System.out.println(se1.toString());

    InfractionEvent ie1 = new InfractionEvent();
    System.out.println(ie1.toString());
    ie1.setSubscribedPlayer(p5);
    ie1.setYellowCard(true);
    ie1.setRedCard(true);
    ie1.setPenaltyKick(true);
    System.out.println(ie1.toString());



    System.out.println("\nupdate:");

    System.out.println("\n" + se1.publishMatchEvent());
   	System.out.println(p5.toString());
   	System.out.println(p6.toString());

    System.out.println("\n" + ie1.publishMatchEvent());
    System.out.println(p5.toString());

    System.out.println("\nrevert update:");

	System.out.println("\n" + se1.unpublishMatchEvent());
	System.out.println("\n" + ie1.unpublishMatchEvent());
   	System.out.println(p5.toString());
   	System.out.println(p6.toString());



   	Match m1 = new Match();
   	System.out.println(m1.toString());
   	m1.setSubscribedHomeTeam(t2);
   	m1.setSubscribedAwayTeam(t3);
   	System.out.println(m1.toString());

   	System.out.println("\n" + m1.addMatchEvent(se1));
   	System.out.println(m1.toString());

   	System.out.println("\n" + m1.addMatchEvent(ie1));
   	System.out.println(m1.toString());

   	// System.out.println("\n" + m1.removeMatchEvent(se1));
   	// System.out.println(m1.toString());

   	// System.out.println("\n" + m1.removeMatchEvent(ie1));
   	// System.out.println(m1.toString());

    System.out.println("\n" + m1.endMatch());

    System.out.println(t2.toString());

    System.out.println(t3.toString());







    System.out.println("\n\n\n\nend of Demo");
  }
}
