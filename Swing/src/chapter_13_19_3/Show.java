package chapter_13_19_3;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Show {

	public static void inFrame(JPanel jp, int width, int height){		//*1	y1
		String title = jp.getClass().toString();
		//remove the words "class"
		if(title.indexOf("class") != -1){
			title = title.substring(6);
		}
		JFrame frame = new JFrame(title);	//*1	m1
		frame.addWindowListener(new WindowAdapter() {	//*2	y2
			@Override
			public void windowClosing(WindowEvent e) {	//*2	y2
				// TODO Auto-generated method stub
				System.exit(0);;
			}
		});
		
		frame.getContentPane().add(jp, BorderLayout.CENTER);	//*1	m1
		frame.setSize(width, height);	//*1	y1
		frame.setVisible(true);		//*1	m1
	}
	
	public static void main(String[] args) {
		Show.inFrame(new JPanel(), 500, 300);	//*1	y1
	}
}
