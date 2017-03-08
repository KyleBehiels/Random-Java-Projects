import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.MouseInfo;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.Panel;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class scout_running extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					scout_running frame = new scout_running();
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
	JRadioButton rdoOne = new JRadioButton("");
	JRadioButton rdoTwo = new JRadioButton("");
	JRadioButton rdoThree = new JRadioButton("");
	JRadioButton rdoFour = new JRadioButton("");
	JRadioButton rdoFive = new JRadioButton("");
	JRadioButton rdoSix = new JRadioButton("");
	JRadioButton rdoSeven = new JRadioButton("");
	lineManager[] lines = new lineManager[0];
	boolean mouseClicked = false;
	int lineOriginX = 0, lineOriginY = 0;
	int lineEndX = 0, lineEndY = 0;
	Color lineColor = Color.RED;
	int currentPosNum = 0;
	int lineLabel = 0;
	public String getPosition(){
		if(rdoOne.isSelected()){
			currentPosNum = 0;
			return startMenu.players[0].playerPosition;
		}
		if(rdoTwo.isSelected()){
			currentPosNum = 1;
			return startMenu.players[1].playerPosition;
		}
		if(rdoThree.isSelected()){
			currentPosNum = 2;
			return startMenu.players[2].playerPosition;
		}
		if(rdoFour.isSelected()){
			currentPosNum = 3;
			return startMenu.players[3].playerPosition;
		}
		if(rdoFive.isSelected()){
			currentPosNum = 4;
			return startMenu.players[4].playerPosition;
		}
		if(rdoSix.isSelected()){
			currentPosNum = 5;
			return startMenu.players[5].playerPosition;
		}
		if(rdoSeven.isSelected()){
			currentPosNum = 6;
			return startMenu.players[6].playerPosition;
		}
		else
			return "Nuttin";
	}
	int[][] arrayPositionsHits = new int[7][100];
	int test = 0;
	int lineIndex = lines.length-1;
	public void addLine(int x1, int y1, int x2, int y2){
		lineManager[] tempLines = new lineManager[lines.length];
		for(int i = 0; i<lines.length;i++){
			tempLines[i] = lines[i];
		}
		lines = new lineManager[lines.length+1];
		lineManager lineToAdd = new lineManager(x1,y1,x2,y2);
		for(int i = 0; i<lines.length-1;i++){
			lines[i] = tempLines[i];
		}
		lines[lines.length-1] = lineToAdd;
		arrayPositionsHits[currentPosNum][lineLabel] = 1;
		lineLabel++;
		lineIndex++;
		contentPane.repaint();
	}
	
	public scout_running() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1049, 686);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rdoOne.setSize(new Dimension(50, 50));
		rdoOne.setFont(new Font("Tahoma", Font.PLAIN, 30));
		rdoOne.setBounds(741, 59, 257, 52);
		contentPane.add(rdoOne);
		
		rdoTwo.setSize(new Dimension(50, 50));
		rdoTwo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		rdoTwo.setBounds(741, 116, 257, 52);
		contentPane.add(rdoTwo);
		
		rdoThree.setSize(new Dimension(50, 50));
		rdoThree.setFont(new Font("Tahoma", Font.PLAIN, 30));
		rdoThree.setBounds(741, 173, 257, 52);
		contentPane.add(rdoThree);
		
		rdoFour.setSize(new Dimension(50, 50));
		rdoFour.setFont(new Font("Tahoma", Font.PLAIN, 30));
		rdoFour.setBounds(741, 230, 257, 52);
		contentPane.add(rdoFour);
		
		rdoFive.setSize(new Dimension(50, 50));
		rdoFive.setFont(new Font("Tahoma", Font.PLAIN, 30));
		rdoFive.setBounds(741, 287, 257, 52);
		contentPane.add(rdoFive);
		
		rdoSix.setSize(new Dimension(50, 50));
		rdoSix.setFont(new Font("Tahoma", Font.PLAIN, 30));
		rdoSix.setBounds(741, 344, 257, 52);
		contentPane.add(rdoSix);
		
		rdoSeven.setSize(new Dimension(50, 50));
		rdoSeven.setFont(new Font("Tahoma", Font.PLAIN, 30));
		rdoSeven.setBounds(741, 401, 257, 52);
		contentPane.add(rdoSeven);
		
		
		Label Position = new Label("");
		Position.setFont(new Font("Tahoma", Font.PLAIN, 30));
		Position.setBounds(39, 463, 155, 52);
		contentPane.add(Position);
		
		Label jerseyNumberLabel = new Label("");
		jerseyNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		jerseyNumberLabel.setBounds(200, 463, 155, 52);
		contentPane.add(jerseyNumberLabel);
		
		Label teamNameLabel = new Label("");
		teamNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		teamNameLabel.setBounds(361, 463, 345, 52);
		contentPane.add(teamNameLabel);
		JPanel panel = new JPanel(){
			@Override
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				g.setColor(Color.black);
				System.out.println(lines.length + " = length of lines array");	
				for(int i = 0; i< lines.length; i++){
					if(arrayPositionsHits[currentPosNum][i] == 1)
						g.drawLine(lines[i].x1, lines[i].y1, lines[i].x2, lines[i].y2);
					
				}
			}
		};
		
		Button crossKillButton = new Button("Cross Kill");
		crossKillButton.setFont(new Font("Dialog", Font.BOLD, 20));
		crossKillButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				lineColor = Color.RED;
				if(getPosition().equals("Right Side")){
					lineOriginX = 20; 
					lineOriginY = 0;
				}
				if((getPosition().equals("Middle"))||(getPosition().equals("Libero"))||getPosition().equals("Setter")){
					lineOriginX = 345;
					lineOriginY = 0;
				}
				if(getPosition().equals("Left Side")){
					lineOriginX = 669;
					lineOriginY = 0;
				}
				
				
			}
		});
		crossKillButton.setBounds(39, 521, 155, 52);
		contentPane.add(crossKillButton);
		
		Button button_1 = new Button("Line Kill");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lineColor = Color.BLUE;
				if(getPosition().equals("Right Side")){
					lineOriginX = 20; 
					lineOriginY = 0;
				}
				if((getPosition().equals("Middle"))||(getPosition().equals("Libero"))||getPosition().equals("Setter")){
					lineOriginX = 345;
					lineOriginY = 0;
				}
				if(getPosition().equals("Left Side")){
					lineOriginX = 669;
					lineOriginY = 0;
				}
			}
		});
		button_1.setFont(new Font("Dialog", Font.BOLD, 20));
		button_1.setBounds(200, 579, 155, 52);
		contentPane.add(button_1);
		
		Button button_2 = new Button("Tip");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lineColor = Color.GREEN;
				if(getPosition().equals("Right Side")){
					lineOriginX = 20; 
					lineOriginY = 0;
				}
				if((getPosition().equals("Middle"))||(getPosition().equals("Libero"))||getPosition().equals("Setter")){
					lineOriginX = 345;
					lineOriginY = 0;
				}
				if(getPosition().equals("Left Side")){
					lineOriginX = 669;
					lineOriginY = 0;
				}
				
			}
		});
		button_2.setFont(new Font("Dialog", Font.BOLD, 20));
		button_2.setBounds(361, 579, 155, 52);
		contentPane.add(button_2);
		
		Button button_3 = new Button("Roll");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lineColor = Color.ORANGE;
				if(getPosition().equals("Right Side")){
					lineOriginX = 20; 
					lineOriginY = 0;
				}
				if((getPosition().equals("Middle"))||(getPosition().equals("Libero"))||getPosition().equals("Setter")){
					lineOriginX = 345;
					lineOriginY = 0;
				}
				if(getPosition().equals("Left Side")){
					lineOriginX = 669;
					lineOriginY = 0;
				}
			}
		});
		button_3.setFont(new Font("Dialog", Font.BOLD, 20));
		button_3.setBounds(39, 579, 155, 52);
		contentPane.add(button_3);
		
		Button button_4 = new Button("Tool");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lineColor = Color.BLACK;
				if(getPosition().equals("Right Side")){
					lineOriginX = 20; 
					lineOriginY = 0;
				}
				if((getPosition().equals("Middle"))||(getPosition().equals("Libero"))||getPosition().equals("Setter")){
					lineOriginX = 345;
					lineOriginY = 0;
				}
				if(getPosition().equals("Left Side")){
					lineOriginX = 669;
					lineOriginY = 0;
				}
			}
		});
		button_4.setFont(new Font("Dialog", Font.BOLD, 20));
		button_4.setBounds(200, 521, 155, 52);
		contentPane.add(button_4);
		
		Button button = new Button("Finish & Export");
		button.setFont(new Font("Dialog", Font.BOLD, 20));
		button.setBounds(708, 521, 173, 110);
		contentPane.add(button);
		
		Button button_5 = new Button("High Hands");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lineColor = Color.YELLOW;
				if(getPosition().equals("Right Side")){
					lineOriginX = 20; 
					lineOriginY = 0;
				}
				if((getPosition().equals("Middle"))||(getPosition().equals("Libero"))||getPosition().equals("Setter")){
					lineOriginX = 345;
					lineOriginY = 0;
				}
				if(getPosition().equals("Left Side")){
					lineOriginX = 669;
					lineOriginY = 0;
				}
			}
		});
		button_5.setFont(new Font("Dialog", Font.BOLD, 20));
		button_5.setBounds(361, 521, 155, 52);
		contentPane.add(button_5);
		
		
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PointerInfo a = MouseInfo.getPointerInfo();
				Point b = a.getLocation();
				lineEndX = (int) b.getX();
				lineEndY = (int) b.getY();
				addLine(lineOriginX, lineOriginY, lineEndX-150, lineEndY-200);
			}
		});
		addLine(0, 125, 700, 125);
		lineLabel--;
		System.out.println("hit this code");
		panel.setBackground(new Color(255, 140, 0));
		panel.setBounds(39, 59, 689, 393);
		panel.setVisible(true);
		contentPane.add(panel);
		contentPane.repaint();

		rdoOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdoOne.isSelected()){
					Position.setText(startMenu.players[0].playerPosition);
					jerseyNumberLabel.setText(""+startMenu.players[0].playerJerseyNumber);
					teamNameLabel.setText(startMenu.players[0].playerTeam);
					rdoTwo.setSelected(false);
					rdoThree.setSelected(false);
					rdoFour.setSelected(false);
					rdoFive.setSelected(false);
					rdoSix.setSelected(false);
					rdoSeven.setSelected(false);
				}
			}
		});
		rdoTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdoTwo.isSelected()){
					Position.setText(startMenu.players[1].playerPosition);
					jerseyNumberLabel.setText(""+startMenu.players[1].playerJerseyNumber);
					teamNameLabel.setText(startMenu.players[1].playerTeam);
					rdoOne.setSelected(false);
					rdoThree.setSelected(false);
					rdoFour.setSelected(false);
					rdoFive.setSelected(false);
					rdoSix.setSelected(false);
					rdoSeven.setSelected(false);
				}
			}
		});
		rdoThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdoThree.isSelected()){
					Position.setText(startMenu.players[2].playerPosition);
					jerseyNumberLabel.setText(""+startMenu.players[2].playerJerseyNumber);
					teamNameLabel.setText(startMenu.players[2].playerTeam);
					rdoTwo.setSelected(false);
					rdoOne.setSelected(false);
					rdoFour.setSelected(false);
					rdoFive.setSelected(false);
					rdoSix.setSelected(false);
					rdoSeven.setSelected(false);
				}
			}
		});
		rdoFour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdoFour.isSelected()){
					Position.setText(startMenu.players[3].playerPosition);
					jerseyNumberLabel.setText(""+startMenu.players[3].playerJerseyNumber);
					teamNameLabel.setText(startMenu.players[3].playerTeam);
					rdoTwo.setSelected(false);
					rdoThree.setSelected(false);
					rdoOne.setSelected(false);
					rdoFive.setSelected(false);
					rdoSix.setSelected(false);
					rdoSeven.setSelected(false);
				}
			}
		});
		rdoFive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdoFive.isSelected()){
					Position.setText(startMenu.players[4].playerPosition);
					jerseyNumberLabel.setText(""+startMenu.players[4].playerJerseyNumber);
					teamNameLabel.setText(startMenu.players[4].playerTeam);
					rdoTwo.setSelected(false);
					rdoThree.setSelected(false);
					rdoFour.setSelected(false);
					rdoOne.setSelected(false);
					rdoSix.setSelected(false);
					rdoSeven.setSelected(false);
				}
			}
		});
		rdoSix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdoSix.isSelected()){
					Position.setText(startMenu.players[5].playerPosition);
					jerseyNumberLabel.setText(""+startMenu.players[5].playerJerseyNumber);
					teamNameLabel.setText(startMenu.players[5].playerTeam);
					rdoTwo.setSelected(false);
					rdoThree.setSelected(false);
					rdoFour.setSelected(false);
					rdoFive.setSelected(false);
					rdoOne.setSelected(false);
					rdoSeven.setSelected(false);
				}
			}
		});
		rdoSeven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdoSeven.isSelected()){
					Position.setText(startMenu.players[6].playerPosition);
					jerseyNumberLabel.setText(""+startMenu.players[6].playerJerseyNumber);
					teamNameLabel.setText(startMenu.players[6].playerTeam);
					rdoTwo.setSelected(false);
					rdoThree.setSelected(false);
					rdoFour.setSelected(false);
					rdoFive.setSelected(false);
					rdoSix.setSelected(false);
					rdoOne.setSelected(false);
				}
			}
		});

	}
	
	
}
