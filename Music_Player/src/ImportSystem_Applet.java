import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class ImportSystem_Applet extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImportSystem_Applet frame = new ImportSystem_Applet();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ImportSystem_Applet() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSongName = new JLabel("Song Name");
		lblSongName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSongName.setBounds(12, 13, 85, 29);
		contentPane.add(lblSongName);
		
		textField = new JTextField();
		textField.setBounds(109, 17, 128, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblFilePath = new JLabel("File Path");
		lblFilePath.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFilePath.setBounds(12, 55, 85, 29);
		contentPane.add(lblFilePath);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(109, 59, 128, 22);
		contentPane.add(textField_1);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGenre.setBounds(12, 97, 85, 29);
		contentPane.add(lblGenre);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Rock", "Rap/R&B", "Pop", "Country", "Blues", "Electronic"}));
		comboBox.setBounds(109, 101, 128, 22);
		contentPane.add(comboBox);
		
		JButton btnImport = new JButton("Import");
		btnImport.setBounds(109, 136, 97, 25);
		contentPane.add(btnImport);
	}
}
