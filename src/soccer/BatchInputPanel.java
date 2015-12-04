package soccer;

import javax.swing.JPanel;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;

import javax.swing.JTable;
import javax.swing.table.TableColumn;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.JLabel;

import java.awt.SystemColor;
import java.awt.Font;

import javax.swing.JComboBox;

public class BatchInputPanel extends JPanel {

	ApplicationWindow parentFrame;
	private JTable table;
	private Team homeTeam;
	private Team awayTeam;
	/**
	 * Create the panel.
	 */
	public BatchInputPanel(ApplicationWindow parentFrame, Match match) {
		homeTeam = match.getSubscribedHomeTeam();
		awayTeam = match.getSubscribedAwayTeam();
		
		String[] shotValue = {"shot scored on", "shot saved by"};
		String[] redCardValue = {"no Red Card", "Red Card"};
		String[] yellowCardValue = {"no Yellow Card", "Yellow Card"};
		String[] penaltyKickValue = {"no Penalty Kick", "Penalty Kick"};
		
		Player[] homePlayersArray = InputModesController.getPlayersArray(homeTeam);
	    Player[] awayPlayersArray = InputModesController.getPlayersArray(awayTeam);
	    
	    Player[] homeGoaliesArray = InputModesController.getGoaliesArray(homeTeam);
	    Player[] awayGoaliesArray = InputModesController.getGoaliesArray(awayTeam);
		
		parentFrame.setTitle(match.getSummary());
		setLayout(new MigLayout("", "[100.00px][100.00px,grow][150,grow][][150,grow,center][100.00,grow][100.00]", "[35px:n][38.00][grow][-46.00][grow,fill][50px:n][][][][][][50px:n][][][][][][60px:50][73.00][56.00]"));
		
		JButton ReturnButton = new JButton("Return to Scorekeeper Menu");
		ReturnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScorekeeperModeMenuPanel newPanel = new ScorekeeperModeMenuPanel(parentFrame);
				parentFrame.changePanel(newPanel);
			}
		});
		add(ReturnButton, "cell 2 0 3 1,grow");
		
		
		table = InputModesController.generateBatchMatchEventsTable(match);
		TableColumn col = table.getColumnModel().getColumn(0);
		table.removeColumn(col);
		table.setEnabled(false);
		table.setShowGrid(false);
		table.setAutoCreateRowSorter(true);
		
		JLabel lblNewLabel_1 = new JLabel("BATCH INPUT MODE");
	    lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 34));
	    lblNewLabel_1.setForeground(SystemColor.text);
	    add(lblNewLabel_1, "cell 2 2 3 1,alignx center");
		
		
		

		JScrollPane scrollPane = new JScrollPane(table, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
		        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    add(scrollPane, "cell 0 4 7 1,growx,aligny bottom");
	    
	    
	    
	    
	    JComboBox comboBox_SE_HOME_1 = new JComboBox(new DefaultComboBoxModel(homePlayersArray));
	    comboBox_SE_HOME_1.setRenderer(new DefaultListCellRenderer() {
		    @Override
		    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		        Player player = (Player)value;
		        value = "Home: " + player.getFullName();
		        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		    }
		});
	    add(comboBox_SE_HOME_1, "cell 1 7 2 1,growx");
	    
	    JComboBox comboBox_SE_HOME_2 = new JComboBox(shotValue);
	    add(comboBox_SE_HOME_2, "cell 1 8 2 1,growx");
	    
	    JComboBox comboBox_SE_HOME_3 = new JComboBox(new DefaultComboBoxModel(awayGoaliesArray));
	    comboBox_SE_HOME_3.setRenderer(new DefaultListCellRenderer() {
		    @Override
		    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		        Player player = (Player)value;
		        value = "Away: " + player.getFullName();
		        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		    }
		});
	    add(comboBox_SE_HOME_3, "cell 1 9 2 1,growx");
	    
	    JButton btnHomeTeamShot = new JButton("ADD HOME TEAM SHOT");
	    btnHomeTeamShot.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		boolean scored;
	    		if (comboBox_SE_HOME_2.getSelectedItem().toString().equals("shot scored on")) {
	    			scored = true;
	    		}
	    		else {
	    			scored = false;
	    		}
	    		//System.out.println(scored);
    			ShotEvent shot = new ShotEvent();
    			Player selectedPlayer = (Player)comboBox_SE_HOME_1.getSelectedItem();
    			Goalie selectedGoalie = (Goalie)comboBox_SE_HOME_3.getSelectedItem();
    			shot.setSubscribedPlayer(selectedPlayer);
    			shot.setSubscribedGoalie(selectedGoalie);
    			shot.setScored(scored);
    			//System.out.println(shot.toString());
    			match.addMatchEvent(shot);
    			BatchInputPanel newPanel = new BatchInputPanel(parentFrame, match);
				parentFrame.changePanel(newPanel);
	    		
	    	}
	    });
	    add(btnHomeTeamShot, "cell 1 10 2 1,grow");
	    
	    

	    JComboBox comboBox_SE_AWAY_1 = new JComboBox(new DefaultComboBoxModel(awayPlayersArray));
	    comboBox_SE_AWAY_1.setRenderer(new DefaultListCellRenderer() {
		    @Override
		    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		        Player player = (Player)value;
		        value = "Away: " + player.getFullName();
		        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		    }
		});
	    add(comboBox_SE_AWAY_1, "cell 4 7 2 1,growx");
	    
	    JComboBox comboBox_SE_AWAY_2 = new JComboBox(shotValue);
	    add(comboBox_SE_AWAY_2, "cell 4 8 2 1,growx");
	    
	    JComboBox comboBox_SE_AWAY_3 = new JComboBox(new DefaultComboBoxModel(homeGoaliesArray));
	    comboBox_SE_AWAY_3.setRenderer(new DefaultListCellRenderer() {
		    @Override
		    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		        Player player = (Player)value;
		        value = "Home: " + player.getFullName();
		        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		    }
		});
	    add(comboBox_SE_AWAY_3, "cell 4 9 2 1,growx");
	    
	    JButton btnAwayTeamShot = new JButton("ADD AWAY TEAM SHOT");
	    btnAwayTeamShot.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		boolean scored;
	    		if (comboBox_SE_AWAY_2.getSelectedItem().toString().equals("shot scored on")) {
	    			scored = true;
	    		}
	    		else {
	    			scored = false;
	    		}
	    		////System.out.println(scored);
    			ShotEvent shot = new ShotEvent();
    			Player selectedPlayer = (Player)comboBox_SE_AWAY_1.getSelectedItem();
    			Goalie selectedGoalie = (Goalie)comboBox_SE_AWAY_3.getSelectedItem();
    			shot.setSubscribedPlayer(selectedPlayer);
    			shot.setSubscribedGoalie(selectedGoalie);
    			shot.setScored(scored);
    			////System.out.println(shot.toString());
    			match.addMatchEvent(shot);
    			BatchInputPanel newPanel = new BatchInputPanel(parentFrame, match);
				parentFrame.changePanel(newPanel);
	    		
	    	}
	    });
	    add(btnAwayTeamShot, "cell 4 10 2 1,grow");
	    
	    
	    
	    JComboBox comboBox_IF_HOME_1 = new JComboBox(new DefaultComboBoxModel(homePlayersArray));
	    comboBox_IF_HOME_1.setRenderer(new DefaultListCellRenderer() {
		    @Override
		    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		        Player player = (Player)value;
		        value = "Home: " + player.getFullName();
		        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		    }
		});
	    add(comboBox_IF_HOME_1, "cell 1 12 2 1,growx");
	    
	    JComboBox comboBox_IF_HOME_2 = new JComboBox(redCardValue);
	    add(comboBox_IF_HOME_2, "cell 1 13 2 1,growx");
	    
	    JComboBox comboBox_IF_HOME_3 = new JComboBox(yellowCardValue);
	    add(comboBox_IF_HOME_3, "cell 1 14 2 1,growx");
	    
	    JComboBox comboBox_IF_HOME_4 = new JComboBox(penaltyKickValue);
	    add(comboBox_IF_HOME_4, "cell 1 15 2 1,growx");
	    
	    JButton btnHomeTeamInfraction = new JButton("ADD HOME TEAM INFRACTION");
	    btnHomeTeamInfraction.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		boolean redCard;
	    		boolean yellowCard;
	    		boolean penaltyKick;
	    		if (comboBox_IF_HOME_2.getSelectedItem().toString().equals("no Red Card")) {
	    			redCard = false;
	    		}
	    		else {
	    			redCard = true;
	    		}
	    		if (comboBox_IF_HOME_3.getSelectedItem().toString().equals("no Yellow Card")) {
	    			yellowCard = false;
	    		}
	    		else {
	    			yellowCard = true;
	    		}
	    		if (comboBox_IF_HOME_4.getSelectedItem().toString().equals("no Penalty Kick")) {
	    			penaltyKick = false;
	    		}
	    		else {
	    			penaltyKick = true;
	    		}
	    		//////System.out.println(redCard + " " + yellowCard + " " + penaltyKick);
	    		if (!redCard && !yellowCard && !penaltyKick) {
					JOptionPane.showMessageDialog(parentFrame, "Need to set a Card or a Penalty Kick!", "ERROR!", JOptionPane.ERROR_MESSAGE);
	    		}
	    		else {
	    			InfractionEvent infraction = new InfractionEvent();
	    			Player selectedPlayer = (Player)comboBox_IF_HOME_1.getSelectedItem();
	    			infraction.setSubscribedPlayer(selectedPlayer);
	    			infraction.setRedCard(redCard);
	    			infraction.setYellowCard(yellowCard);
	    			infraction.setPenaltyKick(penaltyKick);
	    			////System.out.println(infraction.toString());
	    			match.addMatchEvent(infraction);
	    			BatchInputPanel newPanel = new BatchInputPanel(parentFrame, match);
					parentFrame.changePanel(newPanel);
	    		}
	    	}
	    });
	    add(btnHomeTeamInfraction, "cell 1 16 2 1,grow");
	    
	    
	    
	    JComboBox comboBox_IF_AWAY_1 = new JComboBox(new DefaultComboBoxModel(awayPlayersArray));
	    comboBox_IF_AWAY_1.setRenderer(new DefaultListCellRenderer() {
		    @Override
		    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		        Player player = (Player)value;
		        value = "Away: " + player.getFullName();
		        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		    }
		});
	    add(comboBox_IF_AWAY_1, "cell 4 12 2 1,growx");
	    
	    JComboBox comboBox_IF_AWAY_2 = new JComboBox(redCardValue);
	    add(comboBox_IF_AWAY_2, "cell 4 13 2 1,growx");
	    
	    JComboBox comboBox_IF_AWAY_3 = new JComboBox(yellowCardValue);
	    add(comboBox_IF_AWAY_3, "cell 4 14 2 1,growx");
	    
	    JComboBox comboBox_IF_AWAY_4 = new JComboBox(penaltyKickValue);
	    add(comboBox_IF_AWAY_4, "cell 4 15 2 1,growx");
	    
	    JButton btnAwayTeamInfraction = new JButton("ADD AWAY TEAM INFRACTION");
	    btnAwayTeamInfraction.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		boolean redCard;
	    		boolean yellowCard;
	    		boolean penaltyKick;
	    		if (comboBox_IF_AWAY_2.getSelectedItem().toString().equals("no Red Card")) {
	    			redCard = false;
	    		}
	    		else {
	    			redCard = true;
	    		}
	    		if (comboBox_IF_AWAY_3.getSelectedItem().toString().equals("no Yellow Card")) {
	    			yellowCard = false;
	    		}
	    		else {
	    			yellowCard = true;
	    		}
	    		if (comboBox_IF_AWAY_4.getSelectedItem().toString().equals("no Penalty Kick")) {
	    			penaltyKick = false;
	    		}
	    		else {
	    			penaltyKick = true;
	    		}
	    		////System.out.println(redCard + " " + yellowCard + " " + penaltyKick);
	    		if (!redCard && !yellowCard && !penaltyKick) {
					JOptionPane.showMessageDialog(parentFrame, "Need to set a Card or a Penalty Kick!", "ERROR!", JOptionPane.ERROR_MESSAGE);

	    		}
	    		else {
	    			InfractionEvent infraction = new InfractionEvent();
	    			Player selectedPlayer = (Player)comboBox_IF_AWAY_1.getSelectedItem();
	    			infraction.setSubscribedPlayer(selectedPlayer);
	    			infraction.setRedCard(redCard);
	    			infraction.setYellowCard(yellowCard);
	    			infraction.setPenaltyKick(penaltyKick);
	    			////System.out.println(infraction.toString());
	    			match.addMatchEvent(infraction);
	    			BatchInputPanel newPanel = new BatchInputPanel(parentFrame, match);
					parentFrame.changePanel(newPanel);
	    		}
	    	}
	    });
	    add(btnAwayTeamInfraction, "cell 4 16 2 1,grow");
	    
	    
	    
	    
	    JButton btnEndMatch = new JButton("SUBMIT BATCH (CREATE AND END MATCH)");
	    btnEndMatch.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		InputModesController.submitBatchMatch(parentFrame.getSeason(), match);
	    		InputModesController.endMatch(match);
	    		ScorekeeperModeMenuPanel newPanel = new ScorekeeperModeMenuPanel(parentFrame);
				parentFrame.changePanel(newPanel);
	    	}
	    });
	    add(btnEndMatch, "cell 2 18 3 1,grow");
	    
	    


	}
	

	@Override
	  protected void paintComponent(Graphics g) {

	    super.paintComponent(g);
	        ImageIcon img = new ImageIcon(JPanel.class.getResource("/images/soccer-stadium-11840.jpg"));
	        Image bgImage = img.getImage();
			g.drawImage(bgImage, 0, 0, null);
	}
}
