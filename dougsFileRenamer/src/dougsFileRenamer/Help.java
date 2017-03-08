package dougsFileRenamer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;

public class Help extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Help frame = new Help();
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
	public Help() {
		setFont(new Font("Dialog", Font.PLAIN, 25));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 998, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtHelpBox = new JTextArea();
		txtHelpBox.setFont(new Font("Monospaced", Font.PLAIN, 14));
		txtHelpBox.setText("What is an extension?\r\n\r\n-The extension is the last three letters of any file. For a word document for example the extension is .doc.\r\nif you wish to change all files of type .doc to .txt for example, simply enter \"doc\" without the quotations\r\nin the \"Origional file extension\" text box and enter \"txt\" without quotations in the \"New file extension\" box.\r\n\r\nWhat is a file path?\r\n\r\n-The file path is a way for the program to find where on your hard drive the files are stored. To find the file path\r\nopen the folder containing the files you want to edit and look for a line near the top of the file explorer that looks\r\nsomething like this --> C:\\Users\\john\\Desktop\\examplefolder \r\ncopy that path and paste it using ctrl + V into the \"Path to files\" text box\r\n\r\n*IMPORTANT* Do NOT use the file path for the file itself. If you paste a file path and it looks something \r\nlike this --> C:\\Users\\john\\Desktop\\examplefolder\\aFile.ext \r\nThen you have done it wrong. Notice the .ext extension- ^^^  If the file path has a \"dot anything\" (.txt, .doc, .mov)\r\nsimply delete the file with the extension attatched so;\r\n\r\nC:\\Users\\john\\Desktop\\examplefolder\\aFile.ext  |BECOMES -->|  C:\\Users\\john\\Desktop\\examplefolder");
		txtHelpBox.setBounds(12, 13, 956, 398);
		contentPane.add(txtHelpBox);
	}
}
