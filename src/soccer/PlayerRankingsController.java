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
			
