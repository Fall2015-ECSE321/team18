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

public class PlayerRankingsController {


	public static String[][] generatePlayerDataRows(Season season) {
//		List<Team> teams = season.getLeague().getTeams();
//		List<Player> players = new ArrayList<Player>();
//		for (Team team : teams) {
//			List<Player> teamPlayers = team.getPlayers();
//			for (Player player : teamPlayers) {
//				players.add(player);
//			}
//		}
//		String[][] playerDataRows = new String[players.size()][8];
//		int count = 0;
//		for (Player player : players) {
//			playerDataRows[count] = player.getPlayerStats();
//			count++;
//		}
		season.getLeague().publishRankings();
		String[][] playerDataRows = season.getLeague().getSubscribedPlayerRankings().getPlayerData();
		System.out.println(Arrays.deepToString(playerDataRows));
		return playerDataRows;
	}
			
	
	public static String[] getPlayerDataHeaders() {
		String playerDataHeaders[] = { "FirstName",
									   "LastName",
									   "Number",
									   "GP",
									   "Sh",
									   "G",
									   "RCrd",
									   "YCrd",
									   "PK"};
		return playerDataHeaders;
	}
}
			
