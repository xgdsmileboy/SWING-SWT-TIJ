package chapter_13_19_10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import chapter_13_19_3.Show;

public class Popup extends JPanel{		//*1	y1

	JPopupMenu popup ;	//*1	y1
	JTextField t ;		//*1	y1
	
	public Popup(){		//*1	m1
		popup = new JPopupMenu();	//*1	m1
		t = new JTextField(10);		//*1	m1	L1-2
		this.add(t);				//*1
		ActionListener a1 = new ActionListener() {	//*2	y2
			
			@Override
			public void actionPerformed(ActionEvent e) {	//*2	y2
				t.setText(((JMenuItem)e.getSource()).getText());	//*1	y1
			}
		};
		JMenuItem m = new JMenuItem("Hither");	//*2	y1	m1	L1-2
		m.addActionListener(a1);	//*1	y1
		popup.add(m);				//*1
		m = new JMenuItem("Yon");	//*1	m1	L1-2
		m.addActionListener(a1);	//*1	y1
		popup.add(m);				//*1
		m = new JMenuItem("Afar");	//*1	m1	L1-2
		m.addActionListener(a1);	//*1	y1
		popup.add(m);				//*1
		popup.addSeparator();		//*1	y1
		m = new JMenuItem("Stay Here");	//*1	m1	L1-2
		m.addActionListener(a1);	//*1	y1
		popup.add(m);				//*1
		
		PopupListener pl = new PopupListener();	//n1	SWING中通过为控件添加监听实现POP_UP菜单，与SWT不同，认为不能转换
		this.addMouseListener(pl);	//*2	y2	SWT通过setMenu()实现，同时pl类型不同
		t.addMouseListener(pl);		//*2	y2
	}
	
	class PopupListener extends MouseAdapter{	//根据上述，不予统计
		@Override
		public void mousePressed(MouseEvent e) {
			maybeShowPopup(e);
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			maybeShowPopup(e);
		}
		
		private void maybeShowPopup(MouseEvent e){
			if(e.isPopupTrigger()){
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		}
	}
	
	public static void main(String[] args) {
		Show.inFrame(new Popup(), 200, 150);	//*1	y1
	}
	
}
