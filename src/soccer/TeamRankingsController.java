package soccer;


import java.util.Arrays;

import persistence.PersistenceXStream;

public class TeamRankingsController {


	public static String[][] generateTeamDataRows(Season season) {
		season.getLeague().publishRankings();
		String[][] teamDataRows = season.getLeague().getSubscribedTeamRankings().getTeamData();
		//System.out.println(Arrays.deepToString(teamDataRows));
		return teamDataRows;
	}
			
	
	public static String[] getTeamDataHeaders() {
		String teamDataHeaders[] = { "Team Name",
									 "GP",
									 "Pts",
									 "W",
									 "L",
									 "D",
									 "Sh",
									 "ShA",
									 "G",
									 "GA",
									 "RCrd",
									 "YCrd",
									 "PK",
									 "Players" };
		return teamDataHeaders;
	}
}