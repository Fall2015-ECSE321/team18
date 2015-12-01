package soccer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
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
	
	public void changePanel(LoginPanel newPanel) {
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
		setBounds(100, 100, 509, 1127);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		LoginPanel loginPanel = new LoginPanel(this);
		contentPane.add(loginPanel);
//		contentPane.remove(loginPanel);
//		ViewModeMenuPanel newPanel = new ViewModeMenuPanel(this);
//		contentPane.add(newPanel);
		//changePanel();
	}

}
