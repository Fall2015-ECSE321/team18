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

import javax.swing.ComboBoxModel;

import java.awt.Color;

import javax.swing.JTextField;

public class AdministratorCreatePanel extends JPanel {

	ApplicationWindow parentFrame;
	private JTextField textFieldP2;
	private JTextField textFieldP1;
	private JTextField textField_2;
	private JTextField textFieldT2;
	private JTextField comboBoxT1;
	private JTextField textFieldT3;
	private JTextField textFieldT4;
	/**
	 * Create the panel.
	 */
	public AdministratorCreatePanel(ApplicationWindow parentFrame) {
		this.parentFrame = parentFrame;
		setOpaque(false);
		setLayout(new MigLayout("", "[100.00px,grow,left][][278.00,grow,center][100.00,grow,right]", "[35.00][82.00px,grow][][][][][][60][60][][][][][65.00][60][60][60][97.00,grow]"));
		
		JButton button0 = new JButton("Return to Home Screen");
		button0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeMenuPanel newPanel = new HomeMenuPanel(parentFrame);
				parentFrame.changePanel(newPanel);
			}
		});
		add(button0, "cell 2 0,grow");
		
		
		JLabel labelP1 = new JLabel("First Name");
		labelP1.setForeground(SystemColor.text);
		add(labelP1, "flowx,cell 2 2");
		textFieldP1 = new JTextField();
		textFieldP1.setColumns(10);
		add(textFieldP1, "cell 2 2,growx");
		
		
		JLabel labelP2 = new JLabel("Last Name");
		labelP2.setForeground(Color.WHITE);
		add(labelP2, "flowx,cell 2 3");
		textFieldP2 = new JTextField();
		add(textFieldP2, "cell 2 3,growx");
		textFieldP2.setColumns(10);
		
		
		JLabel labelP3 = new JLabel("Number");
		labelP3.setForeground(Color.WHITE);
		add(labelP3, "flowx,cell 2 4");
		JComboBox comboBoxP3 = new JComboBox();
		add(comboBoxP3, "cell 2 4,growx");
		
		
		JLabel labelP4 = new JLabel("Type");
		labelP4.setForeground(Color.WHITE);
		add(labelP4, "flowx,cell 2 5,alignx right,aligny bottom");
		JComboBox comboBoxP4 = new JComboBox();
		add(comboBoxP4, "cell 2 5,growx");
		
		
		JLabel labelP5 = new JLabel("Team");
		labelP5.setForeground(SystemColor.text);
		add(labelP5, "flowx,cell 2 6");
		JComboBox comboBoxP5 = new JComboBox();
		add(comboBoxP5, "cell 2 6,growx");
		
		
		JButton buttonP = new JButton("Add new Player/Goalie to Team");
		add(buttonP, "cell 2 7,grow");
		
		
		
		
		JLabel labelT1 = new JLabel("Team Name");
		labelT1.setForeground(Color.WHITE);
		add(labelT1, "flowx,cell 2 9");
		comboBoxT1 = new JTextField();
		comboBoxT1.setColumns(10);
		add(comboBoxT1, "cell 2 9,growx");

		
		JLabel labelT2 = new JLabel("Goalie First Name");
		labelT2.setForeground(Color.WHITE);
		add(labelT2, "flowx,cell 2 10");
		textFieldT2 = new JTextField();
		textFieldT2.setColumns(10);
		add(textFieldT2, "cell 2 10,growx");
		
		
		JLabel labelT3 = new JLabel("Goalie Last Name");
		labelT3.setForeground(Color.WHITE);
		add(labelT3, "flowx,cell 2 11");
		textFieldT3 = new JTextField();
		textFieldT3.setColumns(10);
		add(textFieldT3, "cell 2 11,growx");
		

		JLabel labelT4 = new JLabel("Goalie Number");
		labelT4.setForeground(Color.WHITE);
		add(labelT4, "flowx,cell 2 12");

		textFieldT4 = new JTextField();
		textFieldT4.setColumns(10);
		add(textFieldT4, "cell 2 12,growx");
		
		
		JButton buttonT = new JButton("Create Team with new Goalie");
		buttonT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Goalie newGoalie = new Goalie()
			}
		});
		add(buttonT, "cell 2 13,grow");
		
		

		
	}

	

	@Override
	  protected void paintComponent(Graphics g) {

	    super.paintComponent(g);
	        ImageIcon img = new ImageIcon(JPanel.class.getResource("/images/soccer-stadium-11840.jpg"));
	        Image bgImage = img.getImage();
			g.drawImage(bgImage, 0, 0, null);
	}
}
