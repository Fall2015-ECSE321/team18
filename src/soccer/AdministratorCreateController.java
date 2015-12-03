package soccer;

public class AdministratorCreateController {

		public static void createTeam(Season season, Goalie newGoalie, Team newTeam) {
			newTeam.addPlayer(newGoalie);
			season.getLeague().addTeam(newTeam);
		}
}
