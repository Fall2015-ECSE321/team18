package soccer;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import net.miginfocom.swing.MigLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.Font;

public class AdministratorLoginPanel extends JPanel {

	ApplicationWindow parentFrame;
	private JTextField usernameField;
	private JPasswordField passwordField;
	/**
	 * Create the panel.
	 */
	public AdministratorLoginPanel(ApplicationWindow parentFrame) {
		this.parentFrame = parentFrame;
		setOpaque(false);
		setLayout(new MigLayout("", "[100.00px,grow,left][278.00,grow,center][100.00,grow,right]", "[35.00][82.00px,grow][34][34][][39.00][97.00,grow]"));
		
		JButton button0 = new JButton("Return to Home Screen");
		button0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeMenuPanel newPanel = new HomeMenuPanel(parentFrame);
				parentFrame.changePanel(newPanel);
			}
		});
		add(button0, "cell 1 0,grow");
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsername.setForeground(SystemColor.text);
		lblUsername.setPreferredSize(new Dimension(60, 14));
		add(lblUsername, "flowx,cell 1 2,alignx left");
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setPreferredSize(new Dimension(60, 14));
		add(lblNewLabel, "flowx,cell 1 3");
		
		JButton button3 = new JButton("Login as Administrator");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usernameField.getText().equals("admin") && String.valueOf(passwordField.getPassword()).equals("admin") ) {
					AdministratorCreatePanel newPanel = new AdministratorCreatePanel(parentFrame);
					parentFrame.changePanel(newPanel);
				}
				else {
					JOptionPane.showMessageDialog(parentFrame, "Username or Passoword are incorrect!", "ERROR!", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		add(button3, "cell 1 5,grow");
		
		usernameField = new JTextField();
		usernameField.setColumns(10);
		add(usernameField, "cell 1 2,grow");
		
		passwordField = new JPasswordField();
		add(passwordField, "cell 1 3,grow");

	}

	@Override
	  protected void paintComponent(Graphics g) {

	    super.paintComponent(g);
	        ImageIcon img = new ImageIcon(JPanel.class.getResource("/images/soccer-stadium-11840.jpg"));
	        Image bgImage = img.getImage();
			g.drawImage(bgImage, 0, 0, null);
	}
}
