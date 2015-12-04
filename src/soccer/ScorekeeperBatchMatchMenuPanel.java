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

public class ScorekeeperBatchMatchMenuPanel extends JPanel {

	ApplicationWindow parentFrame;
	/**
	 * Create the panel.
	 */
	public ScorekeeperBatchMatchMenuPanel(ApplicationWindow parentFrame) {
		this.parentFrame = parentFrame;
		setOpaque(false);
		setLayout(new MigLayout("", "[100.00px,grow,left][278.00,grow,center][100.00,grow,right]", "[35.00][82.00px,grow][][][60][23.00][65.00][60][60][60][97.00,grow]"));
		
		
		
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
		
		JComboBox comboBox1 = new JComboBox(new DefaultComboBoxModel(InputModesController.getTeamsArray(parentFrame.getSeason())));
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
		
		JComboBox comboBox2 = new JComboBox(new DefaultComboBoxModel(InputModesController.getTeamsArray(parentFrame.getSeason())));
		comboBox2.setRenderer(new DefaultListCellRenderer() {
		    @Override
		    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		        Team team = (Team)value;
		        value = team.getName();
		        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		    }
		});
		add(comboBox2, "cell 1 3,growx");
		
		JButton btnLiveScorekeeping = new JButton("Create new Batch Match!");
		btnLiveScorekeeping.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Team homeTeam = (Team)comboBox1.getSelectedItem();
				//homeTeam = LiveInputController.getTeam(homeTeam, parentFrame.getSeason());
				Team awayTeam = (Team)comboBox2.getSelectedItem();
				//awayTeam = LiveInputController.getTeam(awayTeam, parentFrame.getSeason());
				if (homeTeam == awayTeam) {
					JOptionPane.showMessageDialog(parentFrame, "Home and Away Teams must be different!", "ERROR!", JOptionPane.ERROR_MESSAGE);
				}
				else {
					Match newMatch = InputModesController.newBatchMatch(homeTeam, awayTeam);
					BatchInputPanel newPanel = new BatchInputPanel(parentFrame, newMatch);
					parentFrame.changePanel(newPanel);
				}
			}
		});
		
		
		
		add(btnLiveScorekeeping, "cell 1 4,grow");
		
		JButton btnWhatIsA = new JButton("What is a Batch Match?");
		btnWhatIsA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(parentFrame, 
					    "<html><body><p style='width: 300px;'>"
					    + "The interface to a Batch Match is similar to that of a Live Match but the Batch"
						+ " Match will only be saved once the entire created Match is submitted."
						+ " This means that unlike a Live Match, Match Events added to the Batch Match"
						+ " will not be viewable in Season Display until the Batch Match is submitted"
						+ " and if the Batch Match mode is exited without submitting, it will not be saved."
						+ "</p></body></html>", 
						"What is a Batch Match?",  JOptionPane.INFORMATION_MESSAGE) ;
			}
		});
		add(btnWhatIsA, "cell 1 6,grow");

		
	}

	

	@Override
	  protected void paintComponent(Graphics g) {

	    super.paintComponent(g);
	        ImageIcon img = new ImageIcon(JPanel.class.getResource("/images/soccer-stadium-11840.jpg"));
	        Image bgImage = img.getImage();
			g.drawImage(bgImage, 0, 0, null);
	}
}
