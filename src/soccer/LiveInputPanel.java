package soccer;

import javax.swing.JPanel;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.JProgressBar;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class LiveInputPanel extends JPanel {

	ApplicationWindow parentFrame;
	private Season season;
	private JTable table;
	private Match match;
	/**
	 * Create the panel.
	 */
	public LiveInputPanel(ApplicationWindow parentFrame, Match match) {
		this.parentFrame = parentFrame;
		this.match = match;
		parentFrame.setTitle(match.getSummary());
		setLayout(new MigLayout("", "[100.00px,grow][100.00px,grow][150,grow][][150,grow,center][100.00,grow][100.00,grow]", "[35px:n][59.00][][][59.00][72.00][-46.00][::150,fill][50px:n][][][][][50px:n][][][][][60px:50][73.00][56.00]"));
		
		JButton ReturnButton = new JButton("Return to Scorekeeper Menu");
		ReturnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScorekeeperModeMenuPanel newPanel = new ScorekeeperModeMenuPanel(parentFrame);
				parentFrame.changePanel(newPanel);
			}
		});
		add(ReturnButton, "cell 2 0 3 1,grow");
		
		
		

		table = new TeamRankingsController().generateRankingsDataTable(parentFrame.getSeason());
		//table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.setEnabled(false);
		table.setShowGrid(false);
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		for (int i = 1; i < 14; i++)
		{
			table.getColumnModel().getColumn(i).setCellRenderer(rightRenderer);
			table.getColumnModel().getColumn(i).setHeaderRenderer(rightRenderer);
		}
		table.getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
		table.getColumnModel().getColumn(0).setHeaderRenderer(leftRenderer);
		
		JLabel lblHomeTeam = new JLabel("HOME TEAM");
		lblHomeTeam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHomeTeam.setForeground(SystemColor.text);
		add(lblHomeTeam, "cell 2 2,alignx center");
		
		JLabel lblNewLabel_1 = new JLabel("AWAY TEAM");
	    lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    lblNewLabel_1.setForeground(SystemColor.text);
	    add(lblNewLabel_1, "cell 4 2,alignx center");
		
		JLabel lblHomeTeamN = new JLabel(match.getSubscribedHomeTeam().getName());
		lblHomeTeamN.setForeground(Color.WHITE);
		lblHomeTeamN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblHomeTeamN, "cell 2 3,alignx center");
		
		JLabel lblAwayTeamN = new JLabel(match.getSubscribedAwayTeam().getName());
		lblAwayTeamN.setForeground(Color.WHITE);
		lblAwayTeamN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblAwayTeamN, "cell 4 3,alignx center");
		
		JLabel lblVs = new JLabel("VS");
		lblVs.setForeground(Color.WHITE);
		lblVs.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(lblVs, "cell 3 4");
		
		
		
		JLabel label_3 = new JLabel("" + match.getMatchResult().getShots(true));
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(label_3, "cell 5 4 2 1,alignx left");
		
		JLabel label_2 = new JLabel("" + match.getMatchResult().getShots(false));
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		add(label_2, "cell 0 4 2 1,alignx right");
		
		
		JLabel label_1 = new JLabel("" + match.getMatchResult().getPoints(true));
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 50));
		add(label_1, "cell 2 4,alignx center");
		
		JLabel label = new JLabel("" + match.getMatchResult().getPoints(false));
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 50));
		add(label, "cell 4 4");
		
		
		
		JLabel lblShots = new JLabel("SHOTS");
		lblShots.setForeground(Color.WHITE);
		lblShots.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblShots, "cell 0 5 2 1,alignx right,aligny top");
		
		JLabel lblGoals = new JLabel("GOALS");
		lblGoals.setForeground(Color.WHITE);
		lblGoals.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblGoals, "cell 2 5,alignx center,aligny top");
		
		JLabel lblGoals_1 = new JLabel("GOALS");
		lblGoals_1.setForeground(Color.WHITE);
		lblGoals_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblGoals_1, "cell 4 5,alignx center,aligny top");
		
		JLabel lblShots_1 = new JLabel("SHOTS");
		lblShots_1.setForeground(Color.WHITE);
		lblShots_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblShots_1, "cell 5 5 2 1,alignx left,aligny top");
		
		
		

		JScrollPane scrollPane = new JScrollPane(table, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
		        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    add(scrollPane, "cell 1 7 5 1,growx,aligny bottom");
	    
	    JComboBox comboBox_SE_HOME_1 = new JComboBox();
	    add(comboBox_SE_HOME_1, "cell 2 9,growx");
	    
	    JComboBox comboBox_SE_AWAY_1 = new JComboBox();
	    add(comboBox_SE_AWAY_1, "cell 4 9,growx");
	    
	    JComboBox comboBox_SE_HOME_2 = new JComboBox();
	    add(comboBox_SE_HOME_2, "cell 2 10,growx");
	    
	    JComboBox comboBox_SE_AWAY_2 = new JComboBox();
	    add(comboBox_SE_AWAY_2, "cell 4 10,growx");
	    
	    JComboBox comboBox_SE_HOME_3 = new JComboBox();
	    add(comboBox_SE_HOME_3, "cell 2 11,growx");
	    
	    JComboBox comboBox_SE_AWAY_3 = new JComboBox();
	    add(comboBox_SE_AWAY_3, "cell 4 11,growx");
	    
	    JButton btnHomeTeamShot = new JButton("HOME TEAM SHOT");
	    add(btnHomeTeamShot, "cell 2 12,grow");
	    
	    JButton btnAwayTeamShot = new JButton("AWAY TEAM SHOT");
	    add(btnAwayTeamShot, "cell 4 12,grow");
	    
	    JComboBox comboBox_IF_HOME_1 = new JComboBox();
	    add(comboBox_IF_HOME_1, "cell 2 14,growx");
	    
	    JComboBox comboBox_IF_AWAY_1 = new JComboBox();
	    add(comboBox_IF_AWAY_1, "cell 4 14,growx");
	    
	    JComboBox comboBox_IF_HOME_2 = new JComboBox();
	    add(comboBox_IF_HOME_2, "cell 2 15,growx");
	    
	    JComboBox comboBox_IF_AWAY_2 = new JComboBox();
	    add(comboBox_IF_AWAY_2, "cell 4 15,growx");
	    
	    JComboBox comboBox_IF_HOME_3 = new JComboBox();
	    add(comboBox_IF_HOME_3, "cell 2 16,growx");
	    
	    JComboBox comboBox_IF_AWAY_3 = new JComboBox();
	    add(comboBox_IF_AWAY_3, "cell 4 16,growx");
	    
	    JButton btnHomeTeamInfraction = new JButton("HOME TEAM INFRACTION");
	    add(btnHomeTeamInfraction, "cell 2 17,grow");
	    
	    JButton btnAwayTeamInfraction = new JButton("AWAY TEAM INFRACTION");
	    add(btnAwayTeamInfraction, "cell 4 17,grow");
	    
	    JButton btnEndMatch = new JButton("END MATCH");
	    add(btnEndMatch, "cell 2 19 3 1,grow");
	    
	    


	}
	

	@Override
	  protected void paintComponent(Graphics g) {

	    super.paintComponent(g);
	        ImageIcon img = new ImageIcon(JPanel.class.getResource("/images/soccer-stadium-11840.jpg"));
	        Image bgImage = img.getImage();
			g.drawImage(bgImage, 0, 0, null);
	}
}
