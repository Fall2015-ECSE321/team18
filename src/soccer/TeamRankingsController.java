package soccer;

import java.util.UUID;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import persistence.PersistenceXStream;

public class TeamRankingsController {


	public static String[][] generateTeamDataRows(Season season) {
//		List<Team> teams = season.getLeague().getTeams();
//		String[][] teamDataRows = new String[teams.size()][14];
//		int count = 0;
//		for (Team team : teams) {
//			teamDataRows[count] = team.getTeamStats();
//			count++;
//		}
		season.getLeague().publishRankings();
		String[][] teamDataRows = season.getLeague().getSubscribedTeamRankings().getTeamData();
		System.out.println(Arrays.deepToString(teamDataRows));
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