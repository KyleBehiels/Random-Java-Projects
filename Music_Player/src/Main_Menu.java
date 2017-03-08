/*
 * List is not showing in the GUI even though it is successfully adding values. -- Left here
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTree;
import javax.swing.ListModel;
import javax.swing.tree.DefaultTreeModel;

import org.omg.CORBA.INITIALIZE;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JToolBar;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class Main_Menu {
	//================================================================================================================
	static DefaultListModel listModel = new DefaultListModel();
	private JFrame frmMusicPlayer;
	private JTextField txtSearch;
	final static JTree musicTree = new JTree();
	public static String[] values = new String[] {""};
	public static JList list = new JList();
	//================================================================================================================
	/**
	 * Launch the application.
	 */
	//================================================================================================================
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Menu window = new Main_Menu();
					window.frmMusicPlayer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//================================================================================================================
	/**
	 * Create the application.
	 */
	public Main_Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	//================================================================================================================
	private void initialize() {
		frmMusicPlayer = new JFrame();
		frmMusicPlayer.setTitle("Music Player");
		frmMusicPlayer.setBounds(100, 100, 514, 373);
		frmMusicPlayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMusicPlayer.getContentPane().setLayout(new BorderLayout(0, 0));
		
		//================================================================================================================
		//musicTree represents the file tree on the left had side of the GUI interface
		
		musicTree.setBorder(new MatteBorder(3, 3, 3, 0, (Color) Color.BLUE));
		musicTree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Music") {
				{
					DefaultMutableTreeNode node_1;
					add(new DefaultMutableTreeNode("Songs"));
					node_1 = new DefaultMutableTreeNode("Playlists");
						node_1.add(new DefaultMutableTreeNode("Playlist_1"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Genres");
						node_1.add(new DefaultMutableTreeNode("Rock"));
						node_1.add(new DefaultMutableTreeNode("Rap/R&B"));
						node_1.add(new DefaultMutableTreeNode("Pop"));
						node_1.add(new DefaultMutableTreeNode("Country"));
						node_1.add(new DefaultMutableTreeNode("Blues"));
						node_1.add(new DefaultMutableTreeNode("Electronic"));
					add(node_1);
				}
			}
		));
		frmMusicPlayer.getContentPane().add(musicTree, BorderLayout.WEST);
		
		//================================================================================================================
		//toolBar represents the area that contains the progress bar, play and pause buttons and timer label
		
		JToolBar toolBar = new JToolBar();
		frmMusicPlayer.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Import_Handler.allSongs[list.getSelectedIndex()].play();
			}
		});
		
		
		toolBar.add(btnPlay);
		
		JButton btnPause = new JButton("Pause");
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Import_Handler.allSongs[list.getSelectedIndex()].stop();
			}
		});
		toolBar.add(btnPause);
		
		JProgressBar progressBar = new JProgressBar();
		toolBar.add(progressBar);
		
		JSeparator separator_1 = new JSeparator();
		toolBar.add(separator_1);
		
		JLabel label = new JLabel("0:00");
		toolBar.add(label);
		
		JSeparator separator = new JSeparator();
		toolBar.add(separator);
		
		//================================================================================================================
		
		list.setModel(new AbstractListModel() {
			
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.BLUE));
		frmMusicPlayer.getContentPane().add(list, BorderLayout.CENTER);
		
		//================================================================================================================
		
		JMenuBar menuBar = new JMenuBar();
		frmMusicPlayer.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmImportFromSystem = new JMenuItem("Import From System");
		mnFile.add(mntmImportFromSystem);
		
		JMenuItem mntmImportFromUrl = new JMenuItem("Import From URL");
		mntmImportFromUrl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame importWindow = new ImportUrl_Applet();
				importWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				importWindow.setVisible(true);
				
			}
		});
		mnFile.add(mntmImportFromUrl);
		
		JMenuItem mntmCreateNewPlaylist = new JMenuItem("Create New Playlist");
		mnFile.add(mntmCreateNewPlaylist);
		
		txtSearch = new JTextField();
		txtSearch.setText("search...");
		menuBar.add(txtSearch);
		txtSearch.setColumns(10);
		
		JMenuItem[] songs = new JMenuItem[100];
		int songsIndex = 0;
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				values = Import_Handler.allNames;
				list.setModel(new AbstractListModel() {				
					public int getSize() {
						return values.length;
					}
					public Object getElementAt(int index) {
						return values[index];
					}
				});
			}
		});
		menuBar.add(btnRefresh);
		
		JButton btnSearch = new JButton("Search");
		menuBar.add(btnSearch);
		//================================================================================================================
	}
	

}
