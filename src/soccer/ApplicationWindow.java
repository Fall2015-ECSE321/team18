package soccer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import persistence.PersistenceXStream;

import java.awt.GridLayout;

public class ApplicationWindow extends JFrame {

	private JPanel contentPane;

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
	

	
//	public void changePanel(LoginPanel newPanel) {
//	    contentPane.removeAll();
//	    contentPane.add(newPanel);
//	    update(getGraphics());
//	}
//	
//	public void changePanel(ViewModeMenuPanel newPanel) {
//	    contentPane.removeAll();
//	    contentPane.add(newPanel);
//	    update(getGraphics());
//	}

	/**
	 * Create the frame.
	 */
	public ApplicationWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		HomeMenuPanel homeMenuPanel = new HomeMenuPanel(this);
		contentPane.add(homeMenuPanel);
		
		
		Season s1 = (soccer.Season) PersistenceXStream.loadFromXMLwithXStream();
		League l = s1.getLeague();
		System.out.println(s1.toString());
		System.out.println(s1.getMatches().toString());
		System.out.println(l.toString());
		System.out.println(l.getTeams().toString());
	}

}
