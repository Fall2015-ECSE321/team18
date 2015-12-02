package soccer;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import persistence.PersistenceXStream;

public class TeamRankingsController {


	public JTable generateRankingsDataTable() {
		Season season = (soccer.Season) PersistenceXStream.loadFromXMLwithXStream();
		List<Team> teams = season.getLeague().getTeams();
		String[][] teamDataRows = new String[teams.size()][14];
		int count = 0;
		for (Team team : teams) {
			teamDataRows[count] = team.getTeamStats();
			count++;
		}
//		String teamDataHeaders[] = { "name",
//									 "gamesPlayed",
//									 "points",
//									 "wins",
//									 "losses",
//									 "draws",
//									 "shotsFor",
//									 "shotsAgainst",
//									 "goalsFor",
//									 "goalsAgainst",
//									 "redCards",
//									 "yellowCards",
//									 "penaltyKicks",
//									 "players" };
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
		JTable teamDataTable = new JTable(teamDataRows, teamDataHeaders);
		return teamDataTable;
	}
}


