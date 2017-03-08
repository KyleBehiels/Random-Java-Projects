import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class startMenu {

	private JFrame frame;
	private JTextField txtTeamname;
	private JTextField fullNameField;
	private JTextField txtJerseynumber;
	int playerIndex = 0;
	static player[] players = new player[14];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					startMenu window = new startMenu();
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
	public startMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1054, 647);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTeamName = new JLabel("Team Name -");
		lblTeamName.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblTeamName.setBounds(55, 25, 223, 73);
		frame.getContentPane().add(lblTeamName);
		
		txtTeamname = new JTextField();
		txtTeamname.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtTeamname.setBounds(266, 48, 485, 45);
		frame.getContentPane().add(txtTeamname);
		txtTeamname.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Add A Player");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(55, 103, 206, 47);
		frame.getContentPane().add(lblNewLabel);
		
		fullNameField = new JTextField();
		fullNameField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		fullNameField.setColumns(10);
		fullNameField.setBounds(55, 163, 485, 45);
		frame.getContentPane().add(fullNameField);
		
		JLabel fullNameLabel = new JLabel("-Name");
		fullNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		fullNameLabel.setBounds(552, 163, 119, 47);
		frame.getContentPane().add(fullNameLabel);
		
		txtJerseynumber = new JTextField();
		txtJerseynumber.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtJerseynumber.setBounds(55, 221, 109, 45);
		frame.getContentPane().add(txtJerseynumber);
		txtJerseynumber.setColumns(10);
		
		JLabel numberLabel = new JLabel("-Jersey Number");
		numberLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		numberLabel.setBounds(176, 221, 258, 47);
		frame.getContentPane().add(numberLabel);
		
		JList positionsList = new JList();
		positionsList.setFont(new Font("Tahoma", Font.PLAIN, 30));
		positionsList.setValueIsAdjusting(true);
		positionsList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		positionsList.setModel(new AbstractListModel() {
			String[] values = new String[] {"Middle", "Left Side", "Right Side", "Setter", "Libero"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		positionsList.setSelectedIndex(0);
		positionsList.setVisibleRowCount(5);
		positionsList.setBounds(55, 279, 171, 199);
		frame.getContentPane().add(positionsList);
		
		JComboBox addedPlayersDropDown = new JComboBox();
		addedPlayersDropDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtTeamname.setText(players[addedPlayersDropDown.getSelectedIndex()].playerTeam);
				fullNameField.setText(players[addedPlayersDropDown.getSelectedIndex()].playerName);
				txtJerseynumber.setText(""+players[addedPlayersDropDown.getSelectedIndex()].playerJerseyNumber);
				switch (players[addedPlayersDropDown.getSelectedIndex()].playerPosition){
				case "Middle":
					positionsList.setSelectedIndex(0);
					break;
				case "Left Side":
					positionsList.setSelectedIndex(1);
					break;
				case "Right Side":
					positionsList.setSelectedIndex(2);
					break;
				case "Setter":
					positionsList.setSelectedIndex(3);
					break;
				case "Libero":
					positionsList.setSelectedIndex(4);
					break;
				}
			}
		});
		String [] playerArrayList = new String[20];
		addedPlayersDropDown.setModel(new DefaultComboBoxModel(playerArrayList));
		addedPlayersDropDown.setFont(new Font("Tahoma", Font.PLAIN, 30));
		addedPlayersDropDown.setBounds(509, 279, 351, 73);
		frame.getContentPane().add(addedPlayersDropDown);
		
		JButton addPlayerButton = new JButton("Add Player");
		addPlayerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] positions = {"Middle","Left Side","Right Side","Setter","Libero"};
				players[playerIndex] = new player(fullNameField.getText(), txtTeamname.getText(), positions[positionsList.getSelectedIndex()], Integer.parseInt(txtJerseynumber.getText()));
				players[playerIndex].printAllVals();
				playerArrayList[playerIndex] = fullNameField.getText();
				playerIndex++;
				addedPlayersDropDown.setModel(new DefaultComboBoxModel(playerArrayList));
				fullNameField.setText("");
				txtJerseynumber.setText("");
			}
		});
		addPlayerButton.setFont(new Font("Tahoma", Font.PLAIN, 35));
		addPlayerButton.setBounds(238, 281, 214, 73);
		frame.getContentPane().add(addPlayerButton);
		
		JButton startScoutingButton = new JButton("Start\r\n");
		startScoutingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scout_running newSWindow = new scout_running();
				newSWindow.setVisible(true);
				newSWindow.rdoOne.setText(players[0].playerName);
				newSWindow.rdoTwo.setText(players[1].playerName);
				newSWindow.rdoThree.setText(players[2].playerName);
				newSWindow.rdoFour.setText(players[3].playerName);
				newSWindow.rdoFive.setText(players[4].playerName);
				newSWindow.rdoSix.setText(players[5].playerName);
				newSWindow.rdoSeven.setText(players[6].playerName);
			}
		});
		startScoutingButton.setFont(new Font("Tahoma", Font.PLAIN, 35));
		startScoutingButton.setBounds(344, 405, 327, 73);
		frame.getContentPane().add(startScoutingButton);
	}
}
