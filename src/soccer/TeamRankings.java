package soccer;

import java.util.UUID;
import java.util.List;

public class TeamRankings {

	private String uniqueID;
	private String teamData[][];

	public TeamRankings() {
		uniqueID = UUID.randomUUID().toString();
		teamData = new String[0][0];
	}
	
	public void update(List<Team> teams) {
		teamData = new String[teams.size()][];
		int count = 0;
		for (Team team : teams) {
			teamData[count] = team.getTeamStats();
			count++;
		}
		//System.out.println(Arrays.deepToString(teamDataRows));
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public String[][] getTeamData() {
		return teamData;
	}

	public String toString() {
		String returnString = "TeamRankings";
		return returnString;
	}

}
