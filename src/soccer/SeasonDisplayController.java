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

public class SeasonDisplayController {

	public static String[][] getSeasonDataRows(Season season) {
		String[][] seasonDataRows = season.getSubscribedSeasonDisplay().getSeasonData();
		System.out.println(Arrays.deepToString(seasonDataRows));
		return seasonDataRows;
	}
			
	
	public static String[] getSeasonDataHeaders() {
		String seasonDataHeaders[] = { "HomeTeam",
									   "RCrd",
									   "YCrd",
									   "PK",
									   "Sh",
									   "Pts",
									   "",
									   "Pts",
									   "Sh",
									   "PK",
									   "YCrd",
									   "RCrd",
									   "AwayTeam",
									   "Date",
									   "Time"};
		return seasonDataHeaders;
	}
}