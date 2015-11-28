package soccer;
public class Demo {

  public static void main(String argv[]) {


    System.out.println("This is the Soccer Stats Application Demo");


    Player p1 = new Player("Ricky1", "Bobby1", 1);
    Player p2 = new Player("Ricky2", "Bobby2", 2);
    Player p3 = new Player("Ricky3", "Bobby3", 3);
    Player p4 = new Player("Ricky4", "Bobby4", 4);
    Goalie p5 = new Goalie("Ricky5", "Bobby5", 5);

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
    t2.addPlayer(p3);

    Team t3 = new Team("Habs3");
    t3.addPlayer(p2);
    t3.addPlayer(p3);
    t3.addPlayer(p4);



    League l = new League("BigLeagues");

    System.out.println(l.addTeam(t1));
    System.out.println(l.addTeam(t2));
    System.out.println(l.addTeam(t3));

    System.out.println(l.addTeam(t1));
    System.out.println(l.addTeam(t2));
    System.out.println(l.addTeam(t3));

    System.out.println(l.toString());


    System.out.println(l.getTeams().toString());

  }
}
