package chapter_13_19_12;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;

import chapter_13_19_3.Show;

public class Progress extends JPanel {		//*1	y1
	
	JProgressBar pb;	//*1	y1
	JSlider sd;			//*1	y1
	
	public Progress() {		//*1	m1
		this.setLayout(new GridLayout(2,1));	//*1	m1
		pb = new JProgressBar();	//*1	m1	L1-2

		sd = new JSlider(JSlider.HORIZONTAL, 0, 100, 60);	//*1	m1	L1-4
		this.add(pb);	//*1
//		sd.setValue(0);
		
		sd.setPaintTicks(true);		//n1
		sd.setMajorTickSpacing(20);	//n1
		sd.setMinorTickSpacing(5);	//n1
		TitledBorder tborder = new TitledBorder("Slide Me");	//*2	y1	m1
		sd.setBorder(tborder);		//*1
		pb.setModel(sd.getModel());	//*2	y1	m1
		// Share model
		this.add(sd); 	//*1
	}   
	public static void main(String args[]) {   
		Show.inFrame(new Progress(),200,150);	//*1   y1
	} 
}