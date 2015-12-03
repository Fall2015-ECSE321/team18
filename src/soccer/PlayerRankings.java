package soccer;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

public class PlayerRankings {

	private String uniqueID;
	private String playerData[][];

	public PlayerRankings() {
		uniqueID = UUID.randomUUID().toString();
		playerData = new String[0][0];
	}
	
	public void update(List<Team> teams) {
		List<Player> players = new ArrayList<Player>();
		for (Team team : teams) {
			List<Player> teamPlayers = team.getPlayers();
			for (Player player : teamPlayers) {
				players.add(player);
			}
		}
		playerData = new String[players.size()][];
		int count = 0;
		for (Player player : players) {
			playerData[count] = player.getPlayerStats();
			count++;
		}
		//System.out.println(Arrays.deepToString(playerDataRows));
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public String[][] getPlayerData() {
		return playerData;
	}

	public String toString() {
		String returnString = "PlayerRankings";
		return returnString;
	}

}
