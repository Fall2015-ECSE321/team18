package soccer;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import net.miginfocom.swing.MigLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewModeMenuPanel extends JPanel {

	ApplicationWindow parentFrame;
	/**
	 * Create the panel.
	 */
	public ViewModeMenuPanel(ApplicationWindow parentFrame) {
		this.parentFrame = parentFrame;
		setOpaque(false);
		setLayout(new MigLayout("", "[100.00px,grow,left][278.00,grow 60,center][100.00,grow,right]", "[35.00][82.00px,grow][60][60][60][97.00,grow]"));
		
		JButton button0 = new JButton("Return to Home Screen");
		button0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeMenuPanel newPanel = new HomeMenuPanel(parentFrame);
				parentFrame.changePanel(newPanel);
			}
		});
		add(button0, "cell 1 0,grow");
		
		JButton button1 = new JButton("Season Display");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeasonDisplayPanel newPanel = new SeasonDisplayPanel(parentFrame);
				parentFrame.changePanel(newPanel);
			}
		});
		add(button1, "cell 1 2,grow");
		
		JButton button2 = new JButton("Team Rankings");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeamRankingsPanel newPanel = new TeamRankingsPanel(parentFrame);
				parentFrame.changePanel(newPanel);
			}
		});
		add(button2, "cell 1 3,grow");
		
		JButton button3 = new JButton("Player Rankings");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayerRankingsPanel newPanel = new PlayerRankingsPanel(parentFrame);
				parentFrame.changePanel(newPanel);
			}
		});
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
