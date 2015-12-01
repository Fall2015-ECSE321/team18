package soccer;

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

/** This class contains all private fields related to a Match object.
 * It also includes methods that add/remove match events to a MatchEvent list,
 * and that publish/unpublish all MatchEvents that have taken place in the Match.
 * 
 * @author Team 18
 *
 */
public class Match {

	private String uniqueID;
	private Team subscribedHomeTeam;
	private Team subscribedAwayTeam;
	private List<MatchEvent> matchEvents;
	private MatchResult matchResult;
	private boolean complete;

	/** Constructor method. Sets unique ID, and initializes fields.
	 * 
	 */
	public 	Match() {
		uniqueID = UUID.randomUUID().toString(); 
		matchEvents = new ArrayList<MatchEvent>();
		matchResult = new MatchResult();
		complete = false;
	}

	// Getters and setters
	
	public Team getSubscribedHomeTeam() {
		return subscribedHomeTeam;
	}

	public Team getSubscribedAwayTeam() {
		return subscribedAwayTeam;
	}

	public List<MatchEvent> getMatchEvents() {
		return matchEvents;
	}

	public String setSubscribedHomeTeam(Team homeTeam) {
		subscribedHomeTeam = homeTeam;
		return "HomeTeam " + subscribedHomeTeam.getName() + " succesfully subscribed to Match.";
	}

	public String setSubscribedAwayTeam(Team awayTeam) {
		subscribedAwayTeam = awayTeam;
		return "AwayTeam " + subscribedAwayTeam.getName() + " succesfully subscribed to Match.";
	}

	public MatchResult getMatchResult() {
		return matchResult;
	}

	/**	This method adds a ShotEvent to the MatchEvent list. Does not let
	 * duplicate MatchEvent objects to be entered.
	 * 
	 * @param event		The ShotEvent that is intended to be added
	 * @return			Returns a string to indicate whether the event was successfully added or not
	 */
	public String addMatchEvent(ShotEvent event) {
		if (matchEvents.contains(event)) {
			return "MatchEvent already added to Match";
		}
		else {
			matchEvents.add(event);
			if (subscribedHomeTeam.getPlayers().contains(event.getSubscribedPlayer()) && subscribedAwayTeam.getPlayers().contains(event.getSubscribedGoalie())) {
				matchResult.applyEvent(0, event);
				return "added MatchEvent";
			}
			else if (subscribedAwayTeam.getPlayers().contains(event.getSubscribedPlayer()) && subscribedHomeTeam.getPlayers().contains(event.getSubscribedGoalie())) {
				matchResult.applyEvent(1, event);
				return "added MatchEvent";
			}
			else {
				return "MatchEvent player is not on home or away team";
			}
		}
	}

	/** This method adds an InfractionEvent to the MatchEvent list. Does not let
	 * duplicate MatchEvent objects to be entered.
	 * 
	 * @param event		The intended InfractionEvent to be added to the MatchEvent list.
	 * @return			Returns a string to indicate whether the event was successfully added or not
	 */
	public String addMatchEvent(InfractionEvent event) {
		if (matchEvents.contains(event)) {
			return "InfractionEvent already added to Match";
		}
		else {
			matchEvents.add(event);
			if (subscribedHomeTeam.getPlayers().contains(event.getSubscribedPlayer())) {
				matchResult.applyEvent(0, event);
				return "added InfractionEvent";
			}
			else if (subscribedAwayTeam.getPlayers().contains(event.getSubscribedPlayer())) {
				matchResult.applyEvent(1, event);
				return "added InfractionEvent";
			}
			else {
				return "InfractionEvent player is not on home or away team";
			}
		}
	}

	/** This method removes a ShotEvent from the MatchEvent list.
	 * 
	 * @param event		The intended ShotEvent to be removed from the MatchEvent list.
	 * @return			Returns a string indicating whether the event was removed or not.
	 */
	public String removeMatchEvent(ShotEvent event) {
		if (matchEvents.contains(event)) {
			matchEvents.remove(event);
			if (subscribedHomeTeam.getPlayers().contains(event.getSubscribedPlayer()) && subscribedAwayTeam.getPlayers().contains(event.getSubscribedGoalie())) {
				matchResult.unapplyEvent(0, event);
				return "removed ShotEvent";
			}
			else if (subscribedAwayTeam.getPlayers().contains(event.getSubscribedPlayer()) && subscribedHomeTeam.getPlayers().contains(event.getSubscribedGoalie())) {
				matchResult.unapplyEvent(1, event);
				return "removed ShotEvent";
			}
			else {
				return "MatchEvent player is not on home or away team";
			}
		}
		else {
			return "MatchEvent does not exist in Match";
		}
	}

	/**	This method removes an InfractionEvent from the MatchEvent list.
	 * 
	 * @param event		The intended InfractionEvent to be removed from the MatchEvent list.
	 * @return			Returns a string indicating whether the even was removed or not.
	 */
	public String removeMatchEvent(InfractionEvent event) {
		if (matchEvents.contains(event)) {
			matchEvents.remove(event);
			if (subscribedHomeTeam.getPlayers().contains(event.getSubscribedPlayer())) {
				matchResult.unapplyEvent(0, event);
				return "removed InfractionEvent";
			}
			else if (subscribedAwayTeam.getPlayers().contains(event.getSubscribedPlayer())) {
				matchResult.unapplyEvent(1, event);
				return "removed InfractionEvent";
			}
			else {
				return "MatchEvent player is not on home or away team";
			}
		}
		else {
			return "MatchEvent does not exist in Match";
		}
	}

	/**	This method ends the Match and then calls methods to publish team and player
	 * 	statistics.
	 * 
	 * @return		Returns a string indicating whether or not the match was properly ended.
	 */
	public String endMatch() {
		if (!complete) {
			complete = true;
			publishTeamStats();
			publishPlayerStats();
			//season.publishSeason();
			//season.getLeague().publishToRankings()
			return "Match was succesfully ended";
		}
		else {
			return "Match is already ended";
		}
	}

	/**	This method changes the Match status from ended to unended. At the same time,
	 * it calls methods to unpublish team and player statistics that were updated due
	 * to the ending of the Match.
	 * 
	 * @return		Returns a string indicating whether or not the match was properly unended.
	 */
	public String unendMatch() {
		if (complete) {
			complete = false;
			unpublishTeamStats();
			unpublishPlayerStats();
			//season.publishSeason();
			//season.getLeague().publishToRankings()
			return "Match was succesfully unended";
		}
		else {
			return "Match is not ended";
		}
	}

	/** This method publishes all MatchEvent objects in the matchEvents list. It
	 * uses the publishMatchEvent() method from the MatchEvent class on each event
	 * found in the list, which updates player statistics.
	 * 
	 * @see soccer.MatchEvent#publishMatchEvent()
	 * @return		Returns a string indicating that the Match was published to every player
	 * 				on HomeTeam and AwayTeam.
	 */
	public String publishPlayerStats() {
		for (MatchEvent event : matchEvents) {
			event.publishMatchEvent();
		}
		return "Match was published to every player on HomeTeam and AwayTeam";
	}

	/**	This method unpublishes all MatchEvent objects in the matchEvents list. It 
	 * uses the unpublishMatchEvent() method from the MatchEvent class on each event
	 * found in the list, which undoes all updates on player statistics due to the
	 * publishPlayerStats() method.
	 * 
	 * @see soccer.MatchEvent#unpublishMatchEvent()
	 * @see soccer.Match#publishPlayerStats()
	 * 
	 * @return		Returns a string indicating that the Match was properly unpublished
	 * 				from every player on the HomeTeam and AwayTeam.
	 */
	public String unpublishPlayerStats() {
		for (MatchEvent event : matchEvents) {
			event.unpublishMatchEvent();
		}
		return "Match was unpublished from every player on HomeTeam and AwayTeam";
	}

	/** This method calls the applyMatchResult() method from the Team class in order
	 * to update the team statistics based on the outcome of the Match.
	 * 
	 * @see soccer.Team#applyMatchResult(boolean, MatchResult)
	 * 
	 * @return		Returns a string indicating that the Match was properly published to
	 * 				the HomeTeam and AwayTeam.
	 */
	public String publishTeamStats() {
		subscribedHomeTeam.applyMatchResult(true, matchResult);
		subscribedAwayTeam.applyMatchResult(false, matchResult);
		return "Match was published to HomeTeam and AwayTeam";
	}

	/**	This method undoes the updates caused by publishTeamStats().
	 * 
	 * @see soccer.Match#publishTeamStats()
	 * @return		Returns a string indicating that the Match was properly unpublished
	 * 				from the HomeTeam and AwayTeam.
	 */
	public String unpublishTeamStats() {
		subscribedHomeTeam.unapplyMatchResult(true, matchResult);
		subscribedAwayTeam.unapplyMatchResult(false, matchResult);
		return "Match was unpublished from HomeTeam and AwayTeam";
	}

	/** This method lists all the Match fields and their values.
	 * 
	 * @see java.lang.Object#toString()
	 * @return		Returns a string listing all the Match fields and their values.
	 */
	public String toString() {
		String returnString = "\nMatch:";
		returnString += "\nuniqueID:   \t" + uniqueID ;
		returnString += "\ncomplete:   \t" + complete ;
		if (subscribedHomeTeam != null) {
			returnString += "\nHomeTeam:   \t" + subscribedHomeTeam.getName();
		}
		else {
			returnString += "\nHomeTeam:   \tNot set";
		}
		if (subscribedAwayTeam != null) {
			returnString += "\nAwayTeam:   \t" + subscribedAwayTeam.getName();
		}
		else {
			returnString += "\nAwayTeam:   \tNot set";
		}
		returnString += "\nmatchEvents:\t" + matchEvents.size();
		returnString += matchResult.toString();
		return returnString;
	}

}
