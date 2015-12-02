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

public class ScorekeeperLiveMatchMenuPanel extends JPanel {

	ApplicationWindow parentFrame;
	/**
	 * Create the panel.
	 */
	public ScorekeeperLiveMatchMenuPanel(ApplicationWindow parentFrame) {
		this.parentFrame = parentFrame;
		setOpaque(false);
		setLayout(new MigLayout("", "[100.00px,grow,left][278.00,grow,center][100.00,grow,right]", "[35.00][82.00px,grow][][][60][60][][65.00][60][60][60][97.00,grow]"));
		
		JButton button0 = new JButton("Return to Scorekeeper Menu");
		button0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScorekeeperModeMenuPanel newPanel = new ScorekeeperModeMenuPanel(parentFrame);
				parentFrame.changePanel(newPanel);
			}
		});
		add(button0, "cell 1 0,grow");
		
		JLabel lblNewLabel = new JLabel("Select Home Team");
		lblNewLabel.setForeground(SystemColor.text);
		add(lblNewLabel, "flowx,cell 1 2");
		
		JComboBox comboBox1 = new JComboBox(new DefaultComboBoxModel(LiveInputController.getTeamsArray()));
		comboBox1.setRenderer(new DefaultListCellRenderer() {
		    @Override
		    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		        Team team = (Team)value;
		        value = team.getName();
		        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		    }
		});
		add(comboBox1, "cell 1 2,growx");
		
		JLabel lblNewLabel_1 = new JLabel("Select Away Team");
		lblNewLabel_1.setForeground(SystemColor.text);
		add(lblNewLabel_1, "flowx,cell 1 3");
		
		JComboBox comboBox2 = new JComboBox(new DefaultComboBoxModel(LiveInputController.getTeamsArray()));
		comboBox2.setRenderer(new DefaultListCellRenderer() {
		    @Override
		    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		        Team team = (Team)value;
		        value = team.getName();
		        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		    }
		});
		add(comboBox2, "cell 1 3,growx");
		
		JButton btnLiveScorekeeping = new JButton("Create new match!");
		btnLiveScorekeeping.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Team homeTeam = (Team)comboBox1.getSelectedItem();
				Team awayTeam = (Team)comboBox2.getSelectedItem();
				if (homeTeam.getUniqueID() == awayTeam.getUniqueID()) {
					JOptionPane.showMessageDialog(parentFrame, "Error: Home and Away Teams must be different!");
				}
				else {
					Match newMatch = LiveInputController.newMatch(homeTeam, awayTeam);
					LiveInputPanel newPanel = new LiveInputPanel(parentFrame, newMatch);
					parentFrame.changePanel(newPanel);
				}
			}
		});
		
		
		
		add(btnLiveScorekeeping, "cell 1 4,grow");
		
		JLabel lblSelectMatch = new JLabel("Select Live Match");
		lblSelectMatch.setForeground(SystemColor.text);
		add(lblSelectMatch, "flowx,cell 1 6");
		Match[] liveMatchesArray = LiveInputController.getLiveMatchesArray();
		System.out.println(liveMatchesArray);
		JComboBox comboBox3 = new JComboBox(new DefaultComboBoxModel(liveMatchesArray));
		if (liveMatchesArray.length > 0) {
			
			comboBox3.setRenderer(new DefaultListCellRenderer() {
			    @Override
			    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
			        Match match = (Match)value;
			        value = match.getSummary();
			        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
			    }
			});
			add(comboBox3, "cell 1 6,growx");
		}
		
		
		JButton btnLoadLiveMatch = new JButton("Load live match!");
		btnLoadLiveMatch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (liveMatchesArray.length > 0) {
					Match liveMatch = (Match)comboBox3.getSelectedItem();
					LiveInputPanel newPanel = new LiveInputPanel(parentFrame, liveMatch);
					parentFrame.changePanel(newPanel);
				}
				else {
					JOptionPane.showMessageDialog(parentFrame, "Error: There are no current Live Matches!");
				}
			}
		});
		add(btnLoadLiveMatch, "cell 1 7,grow");

		
	}

	

	@Override
	  protected void paintComponent(Graphics g) {

	    super.paintComponent(g);
	        ImageIcon img = new ImageIcon(JPanel.class.getResource("/images/soccer-stadium-11840.jpg"));
	        Image bgImage = img.getImage();
			g.drawImage(bgImage, 0, 0, null);
	}
}
