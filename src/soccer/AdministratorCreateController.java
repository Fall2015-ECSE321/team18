package soccer;

import java.util.List;


public class AdministratorCreateController {

		public static void createTeam(Season season, Goalie newGoalie, Team newTeam) {
			newTeam.addPlayer(newGoalie);
			season.getLeague().addTeam(newTeam);
			season.publishSeason();
		}
		
		public static Team[] getTeamsArray(Season season) {
			List<Team> teamsList = season.getLeague().getTeams();
			return teamsList.toArray(new Team[teamsList.size()]);
		}

		public static void createGoalie(Season season, String goalieFirstName, String goalieLastName, int goalieNumber, Team team) {
			Goalie newGoalie = new Goalie(goalieFirstName, goalieLastName, goalieNumber);
			team.addPlayer(newGoalie);
			season.publishSeason();
		}
		
		public static void createPlayer(Season season, String playerFirstName, String playerLastName, int playerNumber, Team team) {
			Player newPlayer = new Player(playerFirstName, playerLastName, playerNumber);
			team.addPlayer(newPlayer);
			season.publishSeason();
		}
}
