import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main_Frame extends JFrame {

	private JPanel contentPane;
	public JLabel label, label_1, label_2, label_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Frame frame = new Main_Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private class DirectionListener implements KeyListener{
	public void keyPressed(KeyEvent event){
		System.out.println("A key was pressed");
		switch(event.getKeyCode()){
			case KeyEvent.VK_DOWN:
				label.setVisible(true);
				label_1.setVisible(false);
				label_2.setVisible(false);
				label_3.setVisible(false);
				break;
			case KeyEvent.VK_S:
				label.setVisible(true);
				label_1.setVisible(false);
				label_2.setVisible(false);
				label_3.setVisible(false);
				break;
			case KeyEvent.VK_A:
				label_1.setVisible(true);
				label.setVisible(false);
				label_2.setVisible(false);
				label_3.setVisible(false);
				
				break;
			case KeyEvent.VK_LEFT:
				label_1.setVisible(true);
				label.setVisible(false);
				label_2.setVisible(false);
				label_3.setVisible(false);
				break;
			case KeyEvent.VK_UP:
				label_2.setVisible(true);
				label_1.setVisible(false);
				label.setVisible(false);
				label_3.setVisible(false);
				break;
			case KeyEvent.VK_W:
				label_2.setVisible(true);
				label_1.setVisible(false);
				label.setVisible(false);
				label_3.setVisible(false);
				break;
			case KeyEvent.VK_D:
				label_3.setVisible(true);
				label_1.setVisible(false);
				label_2.setVisible(false);
				label.setVisible(false);
				break;
			case KeyEvent.VK_RIGHT:
				label_3.setVisible(true);
				label_1.setVisible(false);
				label_2.setVisible(false);
				label.setVisible(false);
				break;
				
			}
		repaint();
			
		}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	}


	/**
	 * Create the frame.
	 */
	public Main_Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 303, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("\\/");
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setForeground(new Color(0, 0, 0));
		label.setBounds(130, 219, 34, 45);
		contentPane.add(label);
		
		label_1 = new JLabel("<");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(33, 119, 51, 45);
		contentPane.add(label_1);
		
		label_2 = new JLabel("^");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_2.setBounds(130, 44, 34, 25);
		contentPane.add(label_2);
		
		label_3 = new JLabel(">");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_3.setBounds(205, 136, 56, 16);
		contentPane.add(label_3);
		
		addKeyListener (new DirectionListener());
		
	}

}
