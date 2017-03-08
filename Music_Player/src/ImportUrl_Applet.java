import java.applet.AudioClip;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ImportUrl_Applet extends JFrame {

	public static String usableUrl, songName, genre;
	private JPanel contentPane;
	private JTextField urlTextField;
	private JTextField songNameTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImportUrl_Applet frame = new ImportUrl_Applet();
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
	public ImportUrl_Applet() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 312, 170);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUrl = new JLabel("URL:");
		lblUrl.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUrl.setBounds(55, 11, 36, 14);
		contentPane.add(lblUrl);
		
		JLabel lblSongName = new JLabel("Song Name:");
		lblSongName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSongName.setBounds(10, 36, 81, 14);
		contentPane.add(lblSongName);
		
		JLabel lblGenre = new JLabel("Genre:");
		lblGenre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGenre.setBounds(45, 61, 46, 14);
		contentPane.add(lblGenre);
		
		urlTextField = new JTextField();
		urlTextField.setBounds(101, 9, 185, 20);
		contentPane.add(urlTextField);
		urlTextField.setColumns(10);
		
		songNameTextField = new JTextField();
		songNameTextField.setBounds(101, 34, 185, 20);
		contentPane.add(songNameTextField);
		songNameTextField.setColumns(10);
		
		final JComboBox genreSelectBox = new JComboBox();
		genreSelectBox.setModel(new DefaultComboBoxModel(new String[] {"Rock", "Rap/R&B", "Pop", "Country", "Blues", "Electronic"}));
		genreSelectBox.setBounds(101, 65, 185, 20);
		contentPane.add(genreSelectBox);
		
		JButton btnImport = new JButton("Import");
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				usableUrl = urlTextField.getText();
				songName = songNameTextField.getText();
				genre = genreSelectBox.getSelectedItem().toString();
				
				AudioClip tempClip = Import_Handler.importFromUrl(usableUrl);
				
				Import_Handler.allSongs[Import_Handler.allIndex] = tempClip;
				Import_Handler.allNames[Import_Handler.allIndex] = songName;
				Import_Handler.allIndex++;
				
				switch(genre){
				case "Rock":
					Import_Handler.rockSongs[Import_Handler.rockIndex] = tempClip;
					Import_Handler.rockNames[Import_Handler.rockIndex] = songName;
					Import_Handler.rockIndex++;
					break;
				case "Rap/R&B":
					Import_Handler.rapSongs[Import_Handler.rapIndex] = tempClip;
					Import_Handler.rapNames[Import_Handler.rapIndex] = songName;
					Import_Handler.rapIndex++;
					break;
				case "Pop":
					Import_Handler.popSongs[Import_Handler.popIndex] = tempClip;
					Import_Handler.popNames[Import_Handler.popIndex] = songName;
					Import_Handler.popIndex++;
					break;
				case "Country":
					Import_Handler.countrySongs[Import_Handler.countryIndex] = tempClip;
					Import_Handler.countryNames[Import_Handler.countryIndex] = songName;
					Import_Handler.countryIndex++;
					break;
				case "Blues":
					Import_Handler.bluesSongs[Import_Handler.bluesIndex] = tempClip;
					Import_Handler.bluesNames[Import_Handler.bluesIndex] = songName;
					Import_Handler.bluesIndex++;
					break;
				case "Electronic":
					Import_Handler.electronicSongs[Import_Handler.electronicIndex] = tempClip;
					Import_Handler.electronicNames[Import_Handler.electronicIndex] = songName;
					Import_Handler.electronicIndex++;
					break;
			}
				dispose();		
		}
		});
		btnImport.setBounds(101, 96, 89, 23);
		contentPane.add(btnImport);
	}
}
