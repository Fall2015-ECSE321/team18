package soccer;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import javax.swing.table.TableRowSorter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Comparator;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

public class TeamRankingsPanel extends JPanel {

	ApplicationWindow parentFrame;
	/**
	 * Create the panel.
	 */
	public TeamRankingsPanel(ApplicationWindow parentFrame, int returnLocation) {
		this.parentFrame = parentFrame;
		parentFrame.updateSeason();
		setLayout(new MigLayout("", "[100.00px,grow][278.00,grow,center][100.00,grow]", "[35px:n][68.00,grow][500.00px:n][39.00][63.00]"));
		
		if (returnLocation == 0) {
			JButton ReturnButton = new JButton("Return to Menu");
			ReturnButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ViewModeMenuPanel newPanel = new ViewModeMenuPanel(parentFrame);
					parentFrame.changePanel(newPanel);
				}
			});
			add(ReturnButton, "cell 1 0,grow");
		}
		else if (returnLocation == 1) {
			JButton ReturnButton = new JButton("Return to Scorekeeper Menu");
			ReturnButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ScorekeeperModeMenuPanel newPanel = new ScorekeeperModeMenuPanel(parentFrame);
					parentFrame.changePanel(newPanel);
				}
			});
			add(ReturnButton, "cell 1 0,grow");
		}
		
		
		
		JLabel TitleLabel = new JLabel("Team Rankings");
		TitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 34));
		TitleLabel.setForeground(SystemColor.text);
		add(TitleLabel, "cell 1 1,alignx center");
		
		
		
		String[][] teamDataRows = TeamRankingsController.generateTeamDataRows(parentFrame.getSeason());
		String[] teamDataHeaders = TeamRankingsController.getTeamDataHeaders();
		
		JTable teamDataTable = new JTable(teamDataRows, teamDataHeaders);
		teamDataTable.setEnabled(false);
		teamDataTable.setShowGrid(false);
		teamDataTable.setAutoCreateRowSorter(true);
		TableRowSorter<DefaultTableModel> rowSorter = (TableRowSorter<DefaultTableModel>)teamDataTable.getRowSorter();
		Comparator<String> intComparator = new Comparator<String>() {
	        @Override
	        public int compare(String o1, String o2)
	        {
	            return Integer.parseInt(o1) - Integer.parseInt(o2);
	        }
		};
		
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		teamDataTable.getColumnModel().getColumn(0).setPreferredWidth(200);
		for (int i = 1; i < 14; i++)
		{
			rowSorter.setComparator(i, intComparator);
			teamDataTable.getColumnModel().getColumn(i).setCellRenderer(rightRenderer);
			//teamDataTable.getColumnModel().getColumn(i).setHeaderRenderer(rightRenderer);
		}
		teamDataTable.getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
		//teamDataTable.getColumnModel().getColumn(0).setHeaderRenderer(leftRenderer);
		
		
		if (teamDataRows.length == 0) {
			TitleLabel.setText("No teams in the league");
		}
		
		JScrollPane scrollPane = new JScrollPane(teamDataTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scrollPane, "cell 0 2 3 1,grow");
		
		JLabel lblClickOnTable = new JLabel("Click on table headers to sort columns!");
		lblClickOnTable.setForeground(Color.WHITE);
		lblClickOnTable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblClickOnTable, "cell 1 3");
		


	}
	

	@Override
	  protected void paintComponent(Graphics g) {

	    super.paintComponent(g);
	        ImageIcon img = new ImageIcon(JPanel.class.getResource("/images/soccer-stadium-11840.jpg"));
	        Image bgImage = img.getImage();
			g.drawImage(bgImage, 0, 0, null);
	}
}
