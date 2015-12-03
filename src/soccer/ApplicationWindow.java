package soccer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import persistence.PersistenceXStream;

import java.awt.GridLayout;
import java.io.IOException;

public class ApplicationWindow extends JFrame {

	private JPanel contentPane;
	private Season season;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationWindow frame = new ApplicationWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void changePanel() {
	    contentPane.removeAll();
	    //update(getGraphics());
	    revalidate();
	}
	
	public void changePanel(ViewModeMenuPanel newPanel) {
	    contentPane.removeAll();
	    contentPane.add(newPanel);
	    revalidate();
	}
	
	public void changePanel(HomeMenuPanel newPanel) {
	    contentPane.removeAll();
	    contentPane.add(newPanel);
	    revalidate();
	}
	
	public void changePanel(AdministratorLoginPanel newPanel) {
	    contentPane.removeAll();
	    contentPane.add(newPanel);
	    revalidate();
	}
	
	public void changePanel(ScorekeeperLoginPanel newPanel) {
	    contentPane.removeAll();
	    contentPane.add(newPanel);
	    revalidate();
	}
	
	public void changePanel(TeamRankingsPanel newPanel) {
	    contentPane.removeAll();
	    contentPane.add(newPanel);
	    revalidate();
	}
	
	public void changePanel(PlayerRankingsPanel newPanel) {
	    contentPane.removeAll();
	    contentPane.add(newPanel);
	    revalidate();
	}
	
	public void changePanel(SeasonDisplayPanel newPanel) {
	    contentPane.removeAll();
	    contentPane.add(newPanel);
	    revalidate();
	}
	
	public void changePanel(ScorekeeperModeMenuPanel newPanel) {
	    contentPane.removeAll();
	    contentPane.add(newPanel);
	    revalidate();
	}
	
	public void changePanel(ScorekeeperLiveMatchMenuPanel newPanel) {
	    contentPane.removeAll();
	    contentPane.add(newPanel);
	    revalidate();
	}
	
	public void changePanel(LiveInputPanel newPanel) {
	    contentPane.removeAll();
	    contentPane.add(newPanel);
	    revalidate();
	}
	
	public void changePanel(AdministratorCreatePanel newPanel) {
	    contentPane.removeAll();
	    contentPane.add(newPanel);
	    revalidate();
	}

	public Season getSeason() {
		return season;
	}

	/**
	 * Create the frame.
	 */
	public ApplicationWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		try {
			season = (soccer.Season) PersistenceXStream.loadFromXMLwithXStream();
		}
		catch (com.thoughtworks.xstream.io.StreamException e) {
			System.out.println("test");
			League league = new League("league");
		    season = new Season("W_2015-2016", league);
		    PersistenceXStream.saveToXMLwithXStream(season);  
		}
		
		//debugging purpose
//		System.out.println(season.toString());
//		System.out.println(season.getMatches().toString());
//		System.out.println(league.toString());
//		System.out.println(league.getTeams().toString());
		
		
		HomeMenuPanel homeMenuPanel = new HomeMenuPanel(this);
		changePanel(homeMenuPanel);
	}

}
