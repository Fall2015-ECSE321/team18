package soccer;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginPanel extends JPanel {

	ApplicationWindow parentFrame;
	/**
	 * Create the panel.
	 */
	public LoginPanel(ApplicationWindow parentFrame) {
		this.parentFrame = parentFrame;
		setOpaque(false);
		setLayout(new MigLayout("", "[100.00px,grow,left][278.00,grow 60,center][100.00,grow,right]", "[346.00px,grow][46.00][61.00][46.00][46.00][97.00]"));
		
		JButton button1 = new JButton("Open SoccerStats");
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ViewModeMenuPanel newPanel = new ViewModeMenuPanel(parentFrame);
				parentFrame.changePanel(newPanel);
			}
		});
		add(button1, "cell 1 1,grow");
		
		JButton button2 = new JButton("Administrator Login");
		add(button2, "cell 1 3,grow");
		
		JButton button3 = new JButton("Scorekeeper Login");
		button3.setDisabledIcon(null);
		add(button3, "cell 1 4,grow");

	}
	

	@Override
	  protected void paintComponent(Graphics g) {

	    super.paintComponent(g);
	        ImageIcon img = new ImageIcon(JPanel.class.getResource("/images/soccer-stadium-11840.jpg"));
	        Image bgImage = img.getImage();
			g.drawImage(bgImage, 0, 0, null);
	}
}
