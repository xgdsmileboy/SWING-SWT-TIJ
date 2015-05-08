import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class hello {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JButton btn = new JButton("hello");
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		
		p1.add(btn);
		p2.add(btn);
		
		frame.add(p1);
		frame.add(p2);
		
		frame.setVisible(true);
	}
}
