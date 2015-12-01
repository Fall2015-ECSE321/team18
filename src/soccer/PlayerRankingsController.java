package soccer;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

public class PlayerRankingsController {


	public JTable generateRankingsDataTable(Season season) {
		List<Team> teams = season.getLeague().getTeams();
		List<Player> players = new ArrayList<Player>();
		for (Team team : teams) {
			List<Player> teamPlayers = team.getPlayers();
			for (Player player : teamPlayers) {
				players.add(player);
			}
		}
		String[][] playerDataRows = new String[players.size()][8];
		int count = 0;
		for (Player player : players) {
			playerDataRows[count] = player.getPlayerStats();
			count++;
		}

		String playerDataHeaders[] = { "FirstName",
									 "LastName",
									 "Number",
									 "GP",
									 "Sh",
									 "G",
									 "RCrd",
									 "YCrd",
									 "PK"};
		JTable playerDataTable = new JTable(playerDataRows, playerDataHeaders);
		return playerDataTable;
	}
}


