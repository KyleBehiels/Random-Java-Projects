import java.awt.Desktop.Action;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class kingQueenGUI {

	private JFrame frame;
	private JTextField catNameField;
	private JTextField imgurLinkField;
	private JTextField descriptionField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kingQueenGUI window = new kingQueenGUI();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public kingQueenGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 683, 312);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCatName = new JLabel("Cat Name");
		lblCatName.setBounds(12, 13, 56, 16);
		frame.getContentPane().add(lblCatName);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(12, 42, 56, 16);
		frame.getContentPane().add(lblGender);
		
		JLabel lblPictureimgurLink = new JLabel("Picture (Imgur link)");
		lblPictureimgurLink.setBounds(12, 70, 118, 16);
		frame.getContentPane().add(lblPictureimgurLink);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(12, 99, 68, 16);
		frame.getContentPane().add(lblDescription);
		
		catNameField = new JTextField();
		catNameField.setBounds(80, 10, 258, 22);
		frame.getContentPane().add(catNameField);
		catNameField.setColumns(10);
		
		imgurLinkField = new JTextField();
		imgurLinkField.setBounds(140, 67, 198, 22);
		frame.getContentPane().add(imgurLinkField);
		imgurLinkField.setColumns(10);
		
		descriptionField = new JTextField();
		descriptionField.setBounds(92, 96, 246, 105);
		frame.getContentPane().add(descriptionField);
		descriptionField.setColumns(10);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setBounds(279, 227, 97, 25);
		frame.getContentPane().add(btnGenerate);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(76, 38, 68, 25);
		frame.getContentPane().add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(153, 38, 81, 25);
		frame.getContentPane().add(rdbtnFemale);
		
		JTextArea outputField = new JTextArea();
		outputField.setBounds(350, 10, 303, 191);
		frame.getContentPane().add(outputField);
		
		rdbtnMale.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				rdbtnFemale.setSelected(false);
			}
			
		});
		rdbtnFemale.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				rdbtnMale.setSelected(false);
			}
			
		});
		
		
		btnGenerate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String name, gender, link, description;
				
				name = catNameField.getText();
				if(rdbtnMale.isSelected()){
					gender = "Male";
				}
				else{
					gender = "Female";
				}
				link = imgurLinkField.getText();
				description = descriptionField.getText();
				
				outputField.setText("<div class=\"queenBox\">\n\t<u></u><h2 class=\"queenName\"><u>"+name+"</h2>\n\t<img src=\""+link+"\" class=\"queenPicture\" width=\"300px\" height=\"300px\">\n\t<div class=\"propertiesBox\">\n\t\t<p class=\"queenDescription\"><b>Gender:</b>"+gender+"<br><br> <b>Description:</b>"+description+"</p>\n\t</div>\n</div>");
				
			}
		});
		
		
	}
}
