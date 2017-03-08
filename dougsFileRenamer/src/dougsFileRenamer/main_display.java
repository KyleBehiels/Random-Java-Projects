package dougsFileRenamer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class main_display {

	private JFrame frame;
	private JTextField filePathField;
	private JTextField textField;
	private JTextField textField_1;
	private String origionalExtension = "", newExtension = "", filePath = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_display window = new main_display();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public main_display() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 888, 527);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDougsFileRenamer = new JLabel("Dougs File Renamer 1.0");
		lblDougsFileRenamer.setFont(new Font("Tahoma", Font.ITALIC, 25));
		lblDougsFileRenamer.setBounds(12, 13, 338, 78);
		frame.getContentPane().add(lblDougsFileRenamer);
		
		JLabel lblPathToFiles = new JLabel("Path To Files");
		lblPathToFiles.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPathToFiles.setBounds(12, 104, 202, 52);
		frame.getContentPane().add(lblPathToFiles);
		
		filePathField = new JTextField();
		filePathField.setToolTipText("Enter the exact path to the folder you wish to rename.");
		filePathField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		filePathField.setBounds(226, 118, 270, 38);
		frame.getContentPane().add(filePathField);
		filePathField.setColumns(10);
		
		JLabel lblOrigionalFileExtension = new JLabel("Origional File Extension");
		lblOrigionalFileExtension.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblOrigionalFileExtension.setBounds(12, 179, 314, 52);
		frame.getContentPane().add(lblOrigionalFileExtension);
		
		textField = new JTextField();
		textField.setToolTipText("Enter the extension you want to change.");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(338, 189, 270, 38);
		frame.getContentPane().add(textField);
		
		JLabel lblNewFileExtension = new JLabel("New File Extension");
		lblNewFileExtension.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewFileExtension.setBounds(12, 248, 314, 52);
		frame.getContentPane().add(lblNewFileExtension);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Enter the extension you wish to replace the old one with.");
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(284, 258, 270, 38);
		frame.getContentPane().add(textField_1);
		
		JButton btnNewButton = new JButton("GO!");
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				newExtension = textField_1.getText();
				origionalExtension = textField.getText();
				filePath = filePathField.getText();
				main_logic fileChanger = new main_logic();
				//System.out.println(fileChanger.addEscapeChar(filePath));
				try {
					fileChanger.changeFiles(filePath, origionalExtension, newExtension);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.setBounds(255, 330, 302, 87);
		frame.getContentPane().add(btnNewButton);
		
		JButton helpButton = new JButton("Help");
		helpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Help help = new Help();
					help.setVisible(true);
					
			}
		});
		helpButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		helpButton.setBounds(739, 415, 119, 52);
		frame.getContentPane().add(helpButton);
	}
}
