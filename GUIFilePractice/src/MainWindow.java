import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frame;
	private JTextField txtInputpath;
	private JTextField txtOutputpath;
	private JTextField txtInputpathfordesktop;
	private JTextField txtName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws IOException{
		frame = new JFrame();
		frame.setBounds(100, 100, 620, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Mark Reorganiser 1.0");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitle.setBounds(12, 13, 179, 46);
		frame.getContentPane().add(lblTitle);
		
		txtInputpath = new JTextField();
		txtInputpath.setText("Input Path");
		txtInputpath.setBounds(12, 72, 578, 22);
		frame.getContentPane().add(txtInputpath);
		txtInputpath.setColumns(10);
		
		txtOutputpath = new JTextField();
		txtOutputpath.setText("Output Path");
		txtOutputpath.setBounds(12, 107, 578, 22);
		frame.getContentPane().add(txtOutputpath);
		txtOutputpath.setColumns(10);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FileReader newFileReader = new FileReader();
				try {
					newFileReader.readSortWrite(txtInputpath.getText(), txtOutputpath.getText());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnConfirm.setBounds(242, 142, 97, 25);
		frame.getContentPane().add(btnConfirm);
		
		JLabel lblOr = new JLabel("OR");
		lblOr.setBounds(277, 180, 26, 16);
		frame.getContentPane().add(lblOr);
		
		txtInputpathfordesktop = new JTextField();
		txtInputpathfordesktop.setText("Input Path");
		txtInputpathfordesktop.setBounds(12, 203, 578, 22);
		frame.getContentPane().add(txtInputpathfordesktop);
		txtInputpathfordesktop.setColumns(10);
		
		txtName = new JTextField();
		txtName.setText("File Name");
		txtName.setBounds(12, 238, 578, 22);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JButton btnSavetodesktop = new JButton("Save To Desktop");
		btnSavetodesktop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileReader newFileReader = new FileReader();
				try {
					newFileReader.readSortWrite(txtInputpathfordesktop.getText(), System.getProperty("user.home")+"/Desktop"+txtName.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSavetodesktop.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSavetodesktop.setBounds(225, 273, 141, 25);
		frame.getContentPane().add(btnSavetodesktop);
	}
}
