package soccer;

import persistence.PersistenceXStream;

public class Demo1 {

  public static void main(String argv[]) {


    System.out.println("This is the Soccer Stats Application Demo1");


	Season s1 = (soccer.Season) PersistenceXStream.loadFromXMLwithXStream();
	League l = s1.getLeague();
	System.out.println(s1.toString());
	System.out.println(s1.getMatches().toString());
	System.out.println(l.toString());
	System.out.println(l.getTeams().toString());

    System.out.println("\n\n\n\nend of Demo");
  }
}
