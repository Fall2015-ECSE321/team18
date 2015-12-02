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

public class SeasonDisplayPanel extends JPanel {

	ApplicationWindow parentFrame;
	private Season season;
	private JTable table;
	private int returnLocation;
	/**
	 * Create the panel.
	 */
	public SeasonDisplayPanel(ApplicationWindow parentFrame, int returnLocation) {
		this.parentFrame = parentFrame;
		setLayout(new MigLayout("", "[100.00px,grow][278.00,grow,center][100.00,grow]", "[35px:n][220.00][335.00px:n][-268.00,grow][420.00]"));
		
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
		
		
		
		

		table = SeasonDisplayController.generateSeasonDataTable();
		table.setEnabled(false);
		table.setShowGrid(false);
		 DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		 rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
		 DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		 leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		 DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		 centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		 
		 for (int i = 0; i < 15; i++)
		 {
			if (i < 6) {
				table.getColumnModel().getColumn(i).setCellRenderer(rightRenderer);
			 	table.getColumnModel().getColumn(i).setHeaderRenderer(rightRenderer);
			}
			if (i > 6) {
			 	table.getColumnModel().getColumn(i).setCellRenderer(leftRenderer);
			 	table.getColumnModel().getColumn(i).setHeaderRenderer(leftRenderer);
			}
		 }
		 table.getColumnModel().getColumn(0).setPreferredWidth(100);
		 table.getColumnModel().getColumn(0).setCellRenderer(leftRenderer);
		 table.getColumnModel().getColumn(0).setHeaderRenderer(leftRenderer);
		 table.getColumnModel().getColumn(12).setPreferredWidth(100);
		 table.getColumnModel().getColumn(12).setCellRenderer(rightRenderer);
		 table.getColumnModel().getColumn(12).setHeaderRenderer(rightRenderer);
		 table.getColumnModel().getColumn(6).setCellRenderer(centerRenderer);
		 table.getColumnModel().getColumn(6).setHeaderRenderer(rightRenderer);
		 table.getColumnModel().getColumn(13).setPreferredWidth(200);
		 table.getColumnModel().getColumn(13).setCellRenderer(rightRenderer);
		 table.getColumnModel().getColumn(13).setHeaderRenderer(rightRenderer);
		 table.getColumnModel().getColumn(14).setCellRenderer(rightRenderer);
		 table.getColumnModel().getColumn(14).setHeaderRenderer(rightRenderer);

		
		
		

		JScrollPane scrollPane = new JScrollPane(table,
		        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
		        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    add(scrollPane, "cell 0 2 3 1,grow");


	}
	

	@Override
	  protected void paintComponent(Graphics g) {

	    super.paintComponent(g);
	        ImageIcon img = new ImageIcon(JPanel.class.getResource("/images/soccer-stadium-11840.jpg"));
	        Image bgImage = img.getImage();
			g.drawImage(bgImage, 0, 0, null);
	}
}