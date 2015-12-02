package soccer;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import persistence.PersistenceXStream;

public class SeasonDisplayController {


	public static JTable generateSeasonDataTable() {
		Season season = (soccer.Season) PersistenceXStream.loadFromXMLwithXStream();
		season.publishSeason();
		PersistenceXStream.saveToXMLwithXStream(season);
		String[][] seasonDataRows = season.getSubscribedSeasonDisplay().getSeasonData();

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
		JTable seasonDataTable = new JTable(seasonDataRows, seasonDataHeaders);
		return seasonDataTable;
	}
}


