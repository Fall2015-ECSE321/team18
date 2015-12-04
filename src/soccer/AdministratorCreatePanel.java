package soccer;

import javax.swing.JPanel;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import net.miginfocom.swing.MigLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.SystemColor;

import javax.swing.ComboBoxModel;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class AdministratorCreatePanel extends JPanel {

	ApplicationWindow parentFrame;
	private JTextField textFieldP2;
	private JTextField textFieldP1;
	private JTextField textFieldT2;
	private JTextField textFieldT3;
	private JTextField textFieldT1;
	/**
	 * Create the panel.
	 */
	public AdministratorCreatePanel(ApplicationWindow parentFrame) {
		this.parentFrame = parentFrame;
		setOpaque(false);
		setLayout(new MigLayout("", "[100.00px,grow,left][][278.00,grow,center][100.00,grow,right]", "[35.00][82.00px,grow][][][][][60][60][60][][][][][65.00][60][60][60][97.00,grow]"));
		
		JButton button0 = new JButton("Return to Home Screen");
		button0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeMenuPanel newPanel = new HomeMenuPanel(parentFrame);
				parentFrame.changePanel(newPanel);
			}
		});
		add(button0, "cell 2 0,grow");
		
		if (AdministratorCreateController.getTeamsArray(parentFrame.getSeason()).length > 0) {
			
			
			JLabel labelP1 = new JLabel("First Name");
			labelP1.setForeground(SystemColor.text);
			add(labelP1, "flowx,cell 2 2");
			textFieldP1 = new JTextField();
			textFieldP1.setColumns(10);
			add(textFieldP1, "cell 2 2,growx");
			
			
			JLabel labelP2 = new JLabel("Last Name");
			labelP2.setForeground(Color.WHITE);
			add(labelP2, "flowx,cell 2 3");
			textFieldP2 = new JTextField();
			add(textFieldP2, "cell 2 3,growx");
			textFieldP2.setColumns(10);
			
			
			JLabel labelP3 = new JLabel("Number");
			labelP3.setForeground(Color.WHITE);
			add(labelP3, "flowx,cell 2 4");
			JSpinner spinnerP3 = new JSpinner();
			add(spinnerP3, "cell 2 4,growx");
			
			
			JLabel labelP5 = new JLabel("Team");
			labelP5.setForeground(SystemColor.text);
			add(labelP5, "flowx,cell 2 5");
			JComboBox comboBoxP5 = new JComboBox(new DefaultComboBoxModel(AdministratorCreateController.getTeamsArray(parentFrame.getSeason())));
			comboBoxP5.setRenderer(new DefaultListCellRenderer() {
			    @Override
			    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
			        Team team = (Team)value;
			        value = team.getName();
			        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
			    }
			});
			add(comboBoxP5, "cell 2 5,growx");
			
			
			JButton buttonB = new JButton("Add new Player to Team");
			buttonB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String playerFirstName = textFieldP1.getText();
					String playerLastName = textFieldP2.getText();
					int playerNumber = (Integer) spinnerP3.getValue();
					Team team = (Team)comboBoxP5.getSelectedItem();
					if (!playerFirstName.matches("[A-Za-z]+")) {
						JOptionPane.showMessageDialog(parentFrame, "Error: Player First Name must contain only letters without spaces or special characters!");
					}
					else if (!playerLastName.matches("[A-Za-z]+")) {
						JOptionPane.showMessageDialog(parentFrame, "Error: Player Last Name must contain only letters without spaces or special characters!");
					}
					else if (playerNumber<0 || playerNumber>99) {
						JOptionPane.showMessageDialog(parentFrame, "Error: Player Number must be between 0 and 99!");
					}
					else {
						AdministratorCreateController.createPlayer(parentFrame.getSeason(), playerFirstName, playerLastName, playerNumber, team);
						JOptionPane.showMessageDialog(parentFrame, "Success: Player " + playerFirstName + " " + playerFirstName + " created and added to team " + team.getName() + "!");
						AdministratorCreatePanel newPanel = new AdministratorCreatePanel(parentFrame);
						parentFrame.changePanel(newPanel);
					}
				}
			});
			add(buttonB, "cell 2 6,grow");
	
			
			JButton buttonP = new JButton("Add new Goalie to Team");
			buttonP.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String goalieFirstName = textFieldP1.getText();
					String goalieLastName = textFieldP2.getText();
					int goalieNumber = (Integer) spinnerP3.getValue();
					Team team = (Team)comboBoxP5.getSelectedItem();
					if (!goalieFirstName.matches("[A-Za-z]+")) {
						JOptionPane.showMessageDialog(parentFrame, "Error: Goalie First Name must contain only letters without spaces or special characters!");
					}
					else if (!goalieLastName.matches("[A-Za-z]+")) {
						JOptionPane.showMessageDialog(parentFrame, "Error: Goalie Last Name must contain only letters without spaces or special characters!");
					}
					else if (goalieNumber<0 || goalieNumber>99) {
						JOptionPane.showMessageDialog(parentFrame, "Error: Goalie Number must be between 0 and 99!");
					}
					else {
						AdministratorCreateController.createGoalie(parentFrame.getSeason(), goalieFirstName, goalieLastName, goalieNumber, team);
						JOptionPane.showMessageDialog(parentFrame, "Success:  Goalie " + goalieFirstName + " " + goalieLastName + " created and added to team " + team.getName() + "!");
						AdministratorCreatePanel newPanel = new AdministratorCreatePanel(parentFrame);
						parentFrame.changePanel(newPanel);
					}
				}
			});
			add(buttonP, "cell 2 7,grow");
		}
		
		
		
		JLabel labelT1 = new JLabel("Team Name");
		labelT1.setForeground(Color.WHITE);
		add(labelT1, "flowx,cell 2 9");
		textFieldT1 = new JTextField();
		textFieldT1.setColumns(10);
		add(textFieldT1, "cell 2 9,growx");

		
		JLabel labelT2 = new JLabel("Goalie First Name");
		labelT2.setForeground(Color.WHITE);
		add(labelT2, "flowx,cell 2 10");
		textFieldT2 = new JTextField();
		textFieldT2.setColumns(10);
		add(textFieldT2, "cell 2 10,growx");
		
		
		JLabel labelT3 = new JLabel("Goalie Last Name");
		labelT3.setForeground(Color.WHITE);
		add(labelT3, "flowx,cell 2 11");
		textFieldT3 = new JTextField();
		textFieldT3.setColumns(10);
		add(textFieldT3, "cell 2 11,growx");
		

		JLabel labelT4 = new JLabel("Goalie Number");
		labelT4.setForeground(Color.WHITE);
		add(labelT4, "flowx,cell 2 12");
		JSpinner spinnerT4 = new JSpinner();
		spinnerT4.setModel(new SpinnerNumberModel(0, 0, 99, 1));
		add(spinnerT4, "cell 2 12,growx");
		
		
		JButton buttonT = new JButton("Create Team with new Goalie");
		buttonT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String teamName = textFieldT1.getText();
				String goalieFirstName = textFieldT2.getText();
				String goalieLastName = textFieldT3.getText();
				int goalieNumber = (Integer) spinnerT4.getValue();
				if (!teamName.matches("[A-Za-z]+( )?([A-Za-z]+)?")) {
					JOptionPane.showMessageDialog(parentFrame, "Error: Team Name must be a maximum of two words containing only letters without special characters!");
				}
				else if (!goalieFirstName.matches("[A-Za-z]+")) {
					JOptionPane.showMessageDialog(parentFrame, "Error: Goalie First Name must contain only letters without spaces or special characters!");
				}
				else if (!goalieLastName.matches("[A-Za-z]+")) {
					JOptionPane.showMessageDialog(parentFrame, "Error: Goalie Last Name must contain only letters without spaces or special characters!");
				}
				else if (goalieNumber<0 || goalieNumber>99) {
					JOptionPane.showMessageDialog(parentFrame, "Error: Goalie Number must be between 0 and 99!");
				}
				else {
					Goalie newGoalie = new Goalie(goalieFirstName, goalieLastName, goalieNumber);
					Team newTeam = new Team(teamName);
					AdministratorCreateController.createTeam(parentFrame.getSeason(), newGoalie, newTeam);
					JOptionPane.showMessageDialog(parentFrame, "Success:  Goalie " + goalieFirstName + " " + goalieLastName + " created and added to newly created team " + newTeam.getName() + "!");
	
					AdministratorCreatePanel newPanel = new AdministratorCreatePanel(parentFrame);
					parentFrame.changePanel(newPanel);
				}
			}
		});
		add(buttonT, "cell 2 13,grow");
		
		
		
		
		
		
		
		

		
	}

	

	@Override
	  protected void paintComponent(Graphics g) {

	    super.paintComponent(g);
	        ImageIcon img = new ImageIcon(JPanel.class.getResource("/images/soccer-stadium-11840.jpg"));
	        Image bgImage = img.getImage();
			g.drawImage(bgImage, 0, 0, null);
	}
}
