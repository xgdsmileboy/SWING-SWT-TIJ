package chapter_13_19_5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

import chapter_13_19_3.Show;

public class Borders extends JPanel{	//*1	y1

	static JPanel showBorder(Border b){		//*1	y1
		JPanel jp = new JPanel();		//*1
		jp.setLayout(new BorderLayout());	//*1	y1
		String name = b.getClass().toString();
		name = name.substring(name.lastIndexOf('.') + 1);
		jp.add(new JLabel(name, JLabel.CENTER), BorderLayout.CENTER);	//*1	m1
		jp.setBorder(b);	//*1
		return jp;
	}
	
	public Borders(){	//*1	m1
		setLayout(new GridLayout(2, 4));	//*1	m1
		add(showBorder(new TitledBorder("title")));		//*2	L1-4
		add(showBorder(new EtchedBorder()));			//n1	不能转换，不算做变化
		add(showBorder(new LineBorder(Color.green)));	//*1	m1
		add(showBorder(new MatteBorder(5, 5, 30, 30, Color.green)));	//n1
		add(showBorder(new BevelBorder(BevelBorder.RAISED)));			//n1
		add(showBorder(new SoftBevelBorder(BevelBorder.LOWERED)));		//n1
		add(showBorder(new CompoundBorder(new EtchedBorder(), new LineBorder(Color.red))));		//n3
	}
	
	public static void main(String[] args) {
		Show.inFrame(new Borders(), 500, 300);	//*1	y1
	}
	
}
