import javax.swing.*;
public class ClientTest {
	
	public static void main(String[] args) {
		Client charlie;
		charlie = new Client("127.0.0.1", 6789);
		charlie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		charlie.startRunning();
	}

}
