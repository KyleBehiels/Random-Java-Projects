import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CheckboxGroup;
import java.awt.SystemColor;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class main_GUI {
	
	/*
	 * Variable Declarations
	 * ===================================
	 */
	private static JFrame frame;
	private JTextField txt_fileExtension;
	private JTextField txt_copyDestination;
	public JTextField txt_startDestination;
	static String toDisplay = "";
	static main_logic mainLogic = new main_logic();
	JRadioButton rdbtnFileExtension = new JRadioButton("File Extension");
	JRadioButton rdbtnExactName = new JRadioButton("Exact Name");
	static boolean valuesToDisplay = false;
	private JTextField txtDepthVal;
	/**
	 * ===================================
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_GUI window = new main_GUI();
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
	public main_GUI() {
		initialize();
	}
	
	/*
	 * Method for determining what to display based on the value of the scrollWheel
	 * =========================================================
	 */
	public static String displayScrollable(int scrollBarValue){
		String displayString = "";
		for (int i = scrollBarValue; i < main_logic.display_Array.displayArray.length; i++) {
			displayString = displayString+"\n"+main_logic.display_Array.displayArray[i];
		}
		return displayString;
	}
	//=======================================
	
	//=======================================--------Method that returns a prefix corresponding to file depth *Not critical but broken*
	/*public static String indicateDepth(int depth){
		String output = "";
		
		for(int i = 0; i<depth;i++){
			output = output+"|-|";
			System.out.println(output);
		}
		
		return output;
	}
	
	*/
	//=======================================
	
	 // Initialize the contents of the frame.
	 
	private void initialize() {
		
		//Frame construction
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(70, 130, 180));
		frame.setBounds(100, 100, 727, 496);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//=======================================--------Begin JPanels
		
		JPanel depthDisplay = new JPanel();
		depthDisplay.setBackground(SystemColor.activeCaption);
		depthDisplay.setBounds(275, 70, 150, 37);
		frame.getContentPane().add(depthDisplay);
		depthDisplay.setLayout(null);
		
		JPanel actionButtonPanel = new JPanel();
		actionButtonPanel.setBackground(SystemColor.activeCaption);
		actionButtonPanel.setBounds(275, 20, 150, 51);
		frame.getContentPane().add(actionButtonPanel);
		actionButtonPanel.setLayout(null);
		
		JPanel locationsPanel = new JPanel();
		locationsPanel.setBackground(SystemColor.activeCaption);
		locationsPanel.setBounds(10, 20, 253, 122);
		frame.getContentPane().add(locationsPanel);
		locationsPanel.setLayout(null);
		
		//=======================================--------End JPanels
		
		//JTextPane for displaying mapped directories
		JTextPane txtDisplay = new JTextPane();
		txtDisplay.setEditable(false);
		txtDisplay.setBounds(12, 166, 393, 254);
		frame.getContentPane().add(txtDisplay);
		
		//=======================================--------Creates the scrollBar associated with txtDisplay
		JScrollBar scrollBarDisplay = new JScrollBar();
		scrollBarDisplay.addAdjustmentListener(new AdjustmentListener() {		//Listens for changes in scrollBarDisplay value
			public void adjustmentValueChanged(AdjustmentEvent arg0) {
				if(valuesToDisplay){
					txtDisplay.setText(displayScrollable(scrollBarDisplay.getValue()));		//Sets txtDisplay to the value determined by displayScollable							//when given the value of the scrollBarDisplay scroll bar
				}
			}
		});
		scrollBarDisplay.setMaximum(10);
		scrollBarDisplay.setBounds(417, 166, 21, 261);
		frame.getContentPane().add(scrollBarDisplay);
		
		//=======================================--------end of scrollBarDisplay
		//=======================================--------Begin Labels
		JLabel lblDirectories = new JLabel("Directories");
		lblDirectories.setBackground(SystemColor.text);
		lblDirectories.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblDirectories.setBounds(12, 137, 91, 26);
		frame.getContentPane().add(lblDirectories);
		
		JLabel lblDirectoriesRequiringHigher = new JLabel("Directories requiring higher access");
		lblDirectoriesRequiringHigher.setBackground(Color.GRAY);
		lblDirectoriesRequiringHigher.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblDirectoriesRequiringHigher.setBounds(440, 142, 220, 16);
		frame.getContentPane().add(lblDirectoriesRequiringHigher);
		
		JLabel lblDirectoryDepth = new JLabel("\t\tDirectory Depth");
		lblDirectoryDepth.setBounds(25, 0, 100, 15);
		depthDisplay.add(lblDirectoryDepth);
		lblDirectoryDepth.setVerticalAlignment(SwingConstants.TOP);
		lblDirectoryDepth.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblCopyDestination = new JLabel("Copy Destination");
		lblCopyDestination.setEnabled(false);
		lblCopyDestination.setBounds(0, 40, 118, 20);
		locationsPanel.add(lblCopyDestination);
		lblCopyDestination.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblStartSearchDestination = new JLabel("Start Search Destination");
		lblStartSearchDestination.setBounds(0, 80, 162, 20);
		locationsPanel.add(lblStartSearchDestination);
		lblStartSearchDestination.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		//=======================================--------End Labels
		
		//=======================================--------Couple of Separators for the Two Displays
		JSeparator directoryUnderline = new JSeparator();
		directoryUnderline.setForeground(Color.BLACK);
		directoryUnderline.setBackground(Color.BLACK);
		directoryUnderline.setBounds(12, 160, 691, 22);
		frame.getContentPane().add(directoryUnderline);
		
		JSeparator displaySeparator = new JSeparator();
		displaySeparator.setBackground(Color.BLACK);
		displaySeparator.setOrientation(SwingConstants.VERTICAL);
		displaySeparator.setForeground(Color.BLACK);
		displaySeparator.setBounds(440, 160, 11, 260);
		frame.getContentPane().add(displaySeparator);
		//=======================================--------End Separators

		//=======================================--------Displays the value of the slider 
		txtDepthVal = new JTextField();
		txtDepthVal.setBounds(57, 13, 35, 22);
		depthDisplay.add(txtDepthVal);
		txtDepthVal.setText("0");
		txtDepthVal.setColumns(10);
		//=======================================--------End
		
		//=======================================--------Slider that determines how deep the program maps in relation to start directory
		JSlider sliderFileDepth = new JSlider();
		sliderFileDepth.setBackground(SystemColor.activeCaption);
		sliderFileDepth.setBounds(275, 110, 150, 28);
		frame.getContentPane().add(sliderFileDepth);
		sliderFileDepth.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				txtDepthVal.setText(sliderFileDepth.getValue()+"");
			}
		});
		sliderFileDepth.setValue(10);
		sliderFileDepth.setMaximum(20);
		sliderFileDepth.setMajorTickSpacing(5);
		sliderFileDepth.setMinorTickSpacing(1);
		sliderFileDepth.setPaintTicks(true);
		//=======================================--------End Slider

		//=======================================--------Main run button ("Search and Copy")
		JButton btn_Search = new JButton("Search");
		btn_Search.setBounds(0, 0, 150, 25);
		actionButtonPanel.add(btn_Search);
		btn_Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String startLocation = txt_startDestination.getText();
				System.out.println(txt_startDestination.getText());
				String copyLocation = txt_copyDestination.getText();
				mainLogic.getSubDirectories(startLocation);
				txtDisplay.setText(displayScrollable(scrollBarDisplay.getValue()));
				scrollBarDisplay.setMaximum(main_logic.getDirectoriesFound());
				valuesToDisplay = true;
				frame.repaint();
				
			}
		});
		btn_Search.setFont(new Font("Tahoma", Font.BOLD, 12));
		//=======================================--------End Button
		
		
		//=======================================--------Cancel Button
		JButton buttonCancel = new JButton("Cancel");
		buttonCancel.setBounds(0, 25, 150, 25);
		actionButtonPanel.add(buttonCancel);
		buttonCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		//=======================================--------End Button
		
		//=======================================--------Field for determining what type of file to search for
		txt_fileExtension = new JTextField();
		txt_fileExtension.setBounds(0, 20, 146, 20);
		locationsPanel.add(txt_fileExtension);
		txt_fileExtension.setColumns(10);
		//=======================================--------End Field

		//=======================================--------Field for determining where to copy specific files to
		txt_copyDestination = new JTextField();
		txt_copyDestination.setEnabled(false);
		txt_copyDestination.setBounds(0, 60, 146, 20);
		locationsPanel.add(txt_copyDestination);
		txt_copyDestination.setColumns(10);
		//=======================================--------Field end
		
		//=======================================--------Field for determining where to start mapping
		txt_startDestination = new JTextField();
		txt_startDestination.setBounds(0, 100, 146, 20);
		locationsPanel.add(txt_startDestination);
		txt_startDestination.setColumns(10);
		
		//=======================================--------Gives user choice to copy specified file types to a destination
		JCheckBox chckbxCopyToDestination = new JCheckBox("");
		chckbxCopyToDestination.setBounds(110, 40, 25, 20);
		locationsPanel.add(chckbxCopyToDestination);
		chckbxCopyToDestination.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxCopyToDestination.isSelected()){
					lblCopyDestination.setEnabled(true);
					txt_copyDestination.setEnabled(true);
				}
				else{
					lblCopyDestination.setEnabled(false);
					txt_copyDestination.setEnabled(false);
				}
			}
		});
		chckbxCopyToDestination.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxCopyToDestination.setBackground(SystemColor.activeCaption);
		
		
		rdbtnFileExtension.setBackground(SystemColor.activeCaption);
		rdbtnFileExtension.setBounds(0, 0, 110, 20);
		locationsPanel.add(rdbtnFileExtension);
		
		ButtonGroup extensionOrName = new ButtonGroup();
		extensionOrName.add(rdbtnFileExtension);
		extensionOrName.add(rdbtnExactName);
		
		rdbtnExactName.setBackground(SystemColor.activeCaption);
		rdbtnExactName.setBounds(110, 0, 127, 20);
		locationsPanel.add(rdbtnExactName);
		
		//=======================================--------Main display pane and corresponding scrollBar
		JTextPane textPane = new JTextPane();
		textPane.setBounds(450, 166, 220, 254);
		frame.getContentPane().add(textPane);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setMaximum(10);
		scrollBar.setBounds(682, 166, 21, 261);
		frame.getContentPane().add(scrollBar);
		
		JCheckBox chckbxVerbose = new JCheckBox("Verbose");
		chckbxVerbose.setBackground(SystemColor.activeCaption);
		chckbxVerbose.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxVerbose.setBounds(433, 20, 160, 25);
		frame.getContentPane().add(chckbxVerbose);
		//=======================================
		
		//=======================================--------Display End
		
		//=======================================--------Begin Menu
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.activeCaption);
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		//=======================================--------End Menu
		
	}
}

