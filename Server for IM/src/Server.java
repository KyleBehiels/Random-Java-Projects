import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Server extends JFrame{

	private JTextField messageField;
	private JTextArea chatWindow;
	private ObjectOutputStream outputStream;
	private ObjectInputStream inputStream;
	private ServerSocket server;
	private Socket connection;
	private int portNumber;
	

	public Server(int inPortNumber){
		super("Instant Messenger");
		portNumber = inPortNumber;
		messageField = new JTextField();
		messageField.setEditable(false);
		messageField.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						sendMessage(event.getActionCommand());
						messageField.setText("");
					}
					}
				);
	add(messageField, BorderLayout.NORTH);
	chatWindow = new JTextArea();
	add(new JScrollPane(chatWindow));
	setSize(300,150);
	setVisible(true);
	}
	
	public void startRunning(){
		try{
			server = new ServerSocket(portNumber, 100);
			while(true){
				try{
					waitForConnection();
					setupStreams();
					whileChatting();
				}
				catch(EOFException eofException){
					showMessage("\n Server ended the connection");
				}
				finally{
					closeAll();
				}
			}
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
	
	private void waitForConnection() throws IOException{
		showMessage("\n Waiting for someone to connect... \n");
		connection = server.accept();
		showMessage("Now connected to " + connection.getInetAddress().getHostName());
	}
	
	private void setupStreams() throws IOException{
		outputStream = new ObjectOutputStream(connection.getOutputStream());
		outputStream.flush();
		inputStream = new ObjectInputStream(connection.getInputStream());
		showMessage("\n Streams have been set up");
	}
	
	private void whileChatting() throws IOException{
		String message = " You are now connected!";
		sendMessage(message);
		ableToType(true);
		do{
			try{
				message = (String) inputStream.readObject();
				showMessage("\n "+message);
			}
			catch(ClassNotFoundException classNotFoundException){
				showMessage("\n User sent invalid object.");
			}
		}while(!message.equals("CLIENT - END"));
	}
	
	private void closeAll(){
		showMessage("\n Closing all connections... \n");
		ableToType(false);
		try{
			outputStream.close();
			inputStream.close();
			connection.close();
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
		
	}
	
	private void sendMessage(String message){
		try{
			outputStream.writeObject("SERVER - "+message);
			outputStream.flush();
			showMessage("\nSERVER - "+message);
		}
		catch(IOException ioException){
			chatWindow.append("\n ERROR: Message cannot be sent");
		}
	}
	
	private void showMessage(final String text){
		SwingUtilities.invokeLater(
				
				new Runnable(){
					public void run(){
						chatWindow.append(text);
					}
				}
				);
	}
	
	private void ableToType(final boolean tof){
		SwingUtilities.invokeLater(
				new Runnable(){
					public void run(){
						messageField.setEditable(tof);
					}
				}
				);
	}
	
}









