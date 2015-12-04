# team18

Soccer Status Application 
Project for ECSE 321 at McGill

Authors:
Demetrios Koziris,
Mitch Dumont
Matthew Burdick
Emma Tang Yuk

##Deployment Process for SoccerStats Java App:


###Clean Build:

This describes the deployment process for a clean build of the application. The application will contain no players or teams so you will not be allowed to enter the Match Input modes until players and teams are added to the league from the administrator mode.

  Note: The default login for administrator and scorekeeper are username: admin, password: admin

 1.	Clone from Github stable branch to local repository
 2.	Navigate to the git repository (team18 directory) from a terminal and run `ant linkApp` The ant command as specified in build.xml will compile the source code and generate a runnable Java jar application in the build/jar directory.

  Note: Must have Apache Ant installed to run command and a java JDK to compile
 3.	Navigate to the build/jar directory and double click SoccerStatsApp.jar to run

  Note: Must have a JRE installed to run jar application


###Demo Build:

This describes the deployment process for a build of the application that already has teams, players, and a single live match added to the league. This is useful for demo purposes or for testing without having to create players and teams as would be required with a clean build.

  Note: The default login for administrator and scorekeeper are username: admin, password: admin

1.	Follow steps 1 and 2 above to build the Java jar application
2.	Before navigating to the build/jar directory to access the generated jar application run 
`ant runDemo2` from the terminal while in the team18 directory

  Note: Must have Apache Ant installed to run command, a java JDK to compile the Demo, and a JRE installed to run the Demo.
3.	A data.xml file will be generated in the team18 directory. Copy this xml file to the build/jar directory and double click the SoccerStatsApp.jar to run with the demo data.

  Note: Must have a JRE installed to run jar application

