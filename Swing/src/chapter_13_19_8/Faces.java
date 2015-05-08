package chapter_13_19_8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import chapter_13_19_3.Show;

public class Faces extends JPanel{		//*1	y1

	static Icon[] faces = {	//*1	y1
		new ImageIcon("picture/faces/Face0.gif"),	//*1	y1
		new ImageIcon("picture/faces/Face1.gif"),	//*1	y1
		new ImageIcon("picture/faces/Face2.gif"),	//*1	y1
		new ImageIcon("picture/faces/Face3.gif"),	//*1	y1
		new ImageIcon("picture/faces/Face4.gif")	//*1	y1
	};
	JButton jb ;	//*1	y1
	JButton jb2 ;	//*1	y1
	
	boolean mad ;
	public Faces(){
		
		jb = new JButton("JButton", faces[3]);	//*1	m1	L1-2
		jb2 = new JButton("Disable");	//*1	m1	L1-2
		mad = false;
		
		jb.addActionListener(new ActionListener() {	//*2	y2
			
			@Override
			public void actionPerformed(ActionEvent e) {	//*2	y2
				if(mad){
					jb.setIcon(faces[3]);	//*1	y1
					mad = false;
				}else{
					jb.setIcon(faces[0]);	//*1	y1
					mad = true;
				}
				jb.setVerticalAlignment(JButton.TOP);	//*1	y1
				jb.setHorizontalAlignment(JButton.LEFT);	//*1	y1
			}
		});
		
		jb.setRolloverEnabled(true);	//n1
		jb.setRolloverIcon(faces[1]);	//n1
		jb.setPressedIcon(faces[2]);	//n1
		jb.setDisabledIcon(faces[4]);	//n1
		jb.setToolTipText("Yow!");
		this.add(jb);	//*1
		jb2.addActionListener(new ActionListener() {	//*2	y2
			
			@Override
			public void actionPerformed(ActionEvent e) {	//*2	y2
				if(jb.isEnabled()){
					jb.setEnabled(false);
					jb2.setText("Enable");
				}else{
					jb.setEnabled(true);
					jb2.setText("Disable");
				}
				
			}
		});
		this.add(jb2);	//*1
	}
	
	public static void main(String[] args) {
		Show.inFrame(new Faces(), 300, 200);	//*1	y1
	}
	
}