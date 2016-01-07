
#Soccer Score Keeping Application 
##Project for Intro to Software Engineering (ECSE 321)  at McGill

Team 18:
Demetrios Koziris,
Mitch Dumont,
Matthew Burdick, and
Emma Tang Yuk
___
##Unique Features
The following are unique features we were able to implement into our soccer score keeping application:

####Administrator Mode:
* Administorator mode for adding new players and goalies to teams or creating new teams.
* All input fields are validated (names consisting of only letters without spaces and numbers being >0 and <100) when creating players, goalies, or teams in the administrator mode.

####Season Display Mode and Rankings Modes
* Season display mode (in addition to team and player rankings) that displays all matches in the season with their current results, stats as well as whether they are ongoing or completed.
* Team and player statistics are generated from, and therefore remain consistent with, the season (matches and match events). When a match event is added to a match, the Season Display is updated immediately and once the Match is ended, the statistics results are published to all players of both teams that participated in the match. These statistics are then viewable from the rankings modes.
* All display modes (Season Display, Team Rankings, and Player Rankings) support ascending and descending sorting of any of their field columns with integer value columns sorted as integers and string value columnds sorted as strings.

####Live Input Mode:
* The ability to enter live input mode of any ongoing match. This means that a scorekeeper can enter a previously opened match then leave it and come back to it as he wishes. Once the match is ended it will no longer be available for live input mode.
* In the Live Input mode, the user is shown the current shots and goals for each team as well as a table with all match events already added to the match and these update every time a new event is added to the match.

####Robustness
* In addition to validating input fields, the user is prevented from performing dangerous tasks (trying to create a match with the home and away teams set as the same team, trying to enter live input mode before at leat two teams have been created in the League, trying to add an infraction even with no card or penalty kick selected, etc).

___
##Deployment Process for SoccerStats Java App:
#####WARNING: Must use the latest JDK (v1.8.0) to compile. [The latest JDK can be found here](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
#####WARNING: This application will not compile with previous version of the JDK (v1.7.0)!

###Clean Build:

This describes the deployment process for a clean build of the application. The application will contain no players or teams so you will not be allowed to enter the Match Input modes until players and teams are added to the league from the administrator mode.

  Note: The default login for administrator and scorekeeper are username: admin, password: admin

 1.	Clone from Github stable branch to local repository
 2.	Navigate to the git repository (team18 directory) from a terminal and run `ant linkApp` The ant command as specified in build.xml will compile the source code and generate a runnable Java jar application in the build/jar directory.

  Note: Must have [Apache Ant](https://ant.apache.org/bindownload.cgi) installed to run ant command and a java JDK to compile
 3.	Navigate to the build/jar directory and double click SoccerStatsApp.jar to run or navigate to the build/jar directory in a terminal and run `java -jar SoccerStatsApp.jar`

  Note: Must have a JRE installed to run jar application


###Demo Build:

This describes the deployment process for a build of the application that already has teams, players, and a single live match added to the league. This is useful for demo purposes or for testing without having to create players and teams as would be required with a clean build.

  Note: The default login for administrator and scorekeeper are username: admin, password: admin

1.	Clone from Github stable branch to local repository
2.  Navigate to the git repository (team18 directory) from a terminal and run `ant runDemo2` then `ant linkApp` from the terminal while in the team18 directory.

  Note: Must have [Apache Ant](https://ant.apache.org/bindownload.cgi) installed to run ant command, a java JDK to compile the Demo, and a JRE installed to run the Demo.
3.	In addition to generating a runnable Java jar application in the build/jar directory a data.xml file will be generated in the team18 directory. Copy this xml file with the demo data to the build/jar directory and double click the SoccerStatsApp.jar to run or navigate to the build/jar directory in a terminal and run `java -jar SoccerStatsApp.jar`.

  Note: Must have a JRE installed to run jar application

___

