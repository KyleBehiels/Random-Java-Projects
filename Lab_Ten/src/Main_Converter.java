/**
 * @author Kyle Behiels T00548219
 * @version 1.0
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout.Group;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main_Converter extends JFrame {

	private JPanel contentPane;
	private JTextField kilometersTextBox;
	private JRadioButton milesRadio;
	private JRadioButton feetRadio;
	private JRadioButton inchesRadio;
	private JLabel convertedValueLabel;
	int buttonSelected = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Converter frame = new Main_Converter();
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
	public Main_Converter() {
		setTitle("Metric Imperial Converter");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 194);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel enterDistanceLabel = new JLabel("Enter a Distance in Kilometers");
		enterDistanceLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		enterDistanceLabel.setBounds(30, 32, 215, 34);
		contentPane.add(enterDistanceLabel);
		converter metricImperial = new converter();
		kilometersTextBox = new JTextField();
		kilometersTextBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch(buttonSelected){
				case 0:
					convertedValueLabel.setText(""+(metricImperial.kilometersToFeet(Integer.parseInt(kilometersTextBox.getText()))));
					break;
				case 1:
					convertedValueLabel.setText(""+(metricImperial.kilometersToMiles(Integer.parseInt(kilometersTextBox.getText()))));
					break;
				case 2:
					convertedValueLabel.setText(""+(metricImperial.kilometersToInches(Integer.parseInt(kilometersTextBox.getText()))));
					break;
					
					
				}
			}
		});
		kilometersTextBox.setBounds(257, 39, 164, 22);
		contentPane.add(kilometersTextBox);
		kilometersTextBox.setColumns(10);
		ActionListener radioListener = new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				
				if(arg0.getSource().equals(feetRadio)){
					buttonSelected = 0;
					convertedValueLabel.setText(""+(metricImperial.kilometersToFeet(Integer.parseInt(kilometersTextBox.getText()))));
				}
				if(arg0.getSource().equals(milesRadio)){
					buttonSelected = 1;
					convertedValueLabel.setText(""+(metricImperial.kilometersToMiles(Integer.parseInt(kilometersTextBox.getText()))));
				}
				if(arg0.getSource().equals(inchesRadio)){
					buttonSelected = 2;
					convertedValueLabel.setText(""+(metricImperial.kilometersToInches(Integer.parseInt(kilometersTextBox.getText()))));
				}
			}
		};
		milesRadio = new JRadioButton("Convert to Miles");
		milesRadio.addActionListener(radioListener);
		
		milesRadio.setSelected(true);
		milesRadio.setBounds(30, 75, 127, 25);
		contentPane.add(milesRadio);
		
		feetRadio = new JRadioButton("Convert to Feet");
		feetRadio.setBounds(161, 75, 127, 25);
		contentPane.add(feetRadio);
		feetRadio.addActionListener(radioListener);
		
		inchesRadio = new JRadioButton("Convert to Inches");
		inchesRadio.setBounds(287, 75, 134, 25);
		contentPane.add(inchesRadio);
		inchesRadio.addActionListener(radioListener);
		
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(feetRadio);
		btnGroup.add(inchesRadio);
		btnGroup.add(milesRadio);
		
		convertedValueLabel = new JLabel("0");
		convertedValueLabel.setBounds(199, 118, 222, 16);
		contentPane.add(convertedValueLabel);
	}
}
