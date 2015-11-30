package soccer;

import persistence.PersistenceXStream;

public class Demo1 {

  public static void main(String argv[]) {


    System.out.println("This is the Soccer Stats Application Demo1");


   League l = (soccer.League) PersistenceXStream.loadFromXMLwithXStream();

   System.out.println(l.toString());
   System.out.println(l.getTeams().toString());

    System.out.println("\n\n\n\nend of Demo");
  }
}
