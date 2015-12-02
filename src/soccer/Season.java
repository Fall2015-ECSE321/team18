package soccer;

import java.util.UUID;

import persistence.PersistenceXStream;

import java.util.ArrayList;
import java.util.List;

/** This class contains all information regarding a soccer season.
 * 
 * @author Team 18
 *
 */
public class Season {

	private String uniqueID;
	private String name;
	private League league;
	private SeasonDisplay subscribedSeasonDisplay;
	private List<Match> matches;

	/** Constructor method. Initializes fields and assigns a unique ID.
	 * 
	 * @param name		The Season's name.
	 * @param league	The League participating in this season.
	 */
	public Season(String name, League league) {
		this.name = name;
		this.league = league;
		matches = new ArrayList<Match>();
		subscribedSeasonDisplay = new SeasonDisplay();
		uniqueID = UUID.randomUUID().toString();
	}
	
	// getters
	public String getUniqueID() {
		return uniqueID;
	}

	public String getName() {
		return name;
	}

	public League getLeague() {
		return league;
	}

	public SeasonDisplay getSubscribedSeasonDisplay() {
		return subscribedSeasonDisplay;
	}

	public List<Match> getMatches() {
		return matches;
	}
	
	/** This method adds a Match object to the matches list.
	 * 
	 * @param match		Match object that is intended to be entered in Season.
	 * @return			Returns String indicating whether the match was added to 
	 * 					the season or not.
	 */
	public String addMatch(Match match) {
		System.out.println("testa");
		if (matches.contains(match)) {
			return "this match has already been added to the season";
		}
		else {
			matches.add(match);
			publishSeason();
			return "this match was succesfully added to the season";
		}
	}
	
	public void publishSeason() {
		subscribedSeasonDisplay.update(matches);
		PersistenceXStream.saveToXMLwithXStream(this);
	}

	/** This method lists the Season's fields and their values.
	 * 
	 * @see java.lang.Object#toString()
	 * @return		Returns a String listing the Season's fields and their values.
	 */
	public String toString() {
		String returnString = "Season";
		returnString += "\nuniqueID:\t" + uniqueID;
		returnString += "\nname:    \t" + name;
		returnString += "\nleague:  \t" + league;
		returnString += "\nmatches: \t" + matches.size();
		return returnString;
	}

}
