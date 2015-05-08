package chapter_13_19_9;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import chapter_13_19_3.Show;

public class Menus extends JPanel{		//*1	y1

	static Icon[] faces = {	//*1	y1
		new ImageIcon("picture/faces/Face0.gif"),	//*1	y1
		new ImageIcon("picture/faces/Face1.gif"),	//*1	y1
		new ImageIcon("picture/faces/Face2.gif"),	//*1	y1
		new ImageIcon("picture/faces/Face3.gif"),	//*1	y1
		new ImageIcon("picture/faces/Face4.gif")	//*1	y1
	};
	
	static final Boolean bT = new Boolean(true);
	static final Boolean bF = new Boolean(false);
	
	//Dummy class to create type identifiers
	static class MType{
		MType(int i){
			
		}
	};
	
	static final MType mi = new MType(1);
	static final MType cb = new MType(2);
	static final MType rb = new MType(3);
	
	JTextField t ;	//*1	y1
	
	JLabel l ;	//*1	y1
	
	ActionListener a1 = new ActionListener() {	//*2	y2
		
		@Override
		public void actionPerformed(ActionEvent e) {	//*2	y2
			t.setText(((JMenuItem)e.getSource()).getText());	//*1	y1
		}
	};
	
	ActionListener a2 = new ActionListener() {	//*2	y2
		
		@Override
		public void actionPerformed(ActionEvent e) {	//*2	y2
			JMenuItem mi = (JMenuItem)e.getSource();	//*2	y2
			l.setText(mi.getText());
			l.setIcon(mi.getIcon());	//*2	y2
		}
	};
	
	// Store menu data as "resources":
	public Object[][] fileMenu = {
		//Menu name and accelerator:
		{"File", new Character('F')},
		//Name type accel listener enabled
		{"New", mi, new Character('N'), a1, bT},
		{"Open", mi, new Character('O'), a1, bT},
		{"Save", mi, new Character('S'), a1, bF},
		{"Save As", mi, new Character('A'), a1, bF},
		{null},//Separator
		{"Exit", mi, new Character('X'), a1, bT}
	};
	
	public Object[][] editMenu = {
		//Menu name
		{"Edit", new Character('E')},
		//Name type accel listener enabled
		{"Cut", mi, new Character('t'), a1, bT},
		{"Copy", mi, new Character('C'), a1, bT},
		{"Paste", mi, new Character('P'), a1, bT},
		{null}, //Separator
		{"Select All", mi, new Character('l'), a1, bT}
	};
	
	public Object[][] helpMenu = {
		// Menu name:     
		{ "Help", new Character('H') },
		// Name type accel listener enabled
		{ "Index", mi, new Character('I'), a1, bT },
		{ "Using help", mi,new Character('U'),a1,bT},
		{ null }, // Separator
		{ "About", mi, new Character('t'), a1, bT }
	};
	public Object[][] optionMenu = {
		// Menu name:
		{ "Options", new Character('O') },
		// Name type accel listener enabled
		{ "Option 1", cb, new Character('1'), a1,bT},
		{ "Option 2", cb, new Character('2'), a1,bT}
	}; 
	public Object[][] faceMenu = {
		// Menu name:
		{ "Faces", new Character('a') },
		// Optinal last element is icon 
		{ "Face 0", rb, new Character('0'), a2, bT, faces[0] },
		{ "Face 1", rb, new Character('1'), a2, bT, faces[1] },
		{ "Face 2", rb, new Character('2'), a2, bT, faces[2] },
		{ "Face 3", rb, new Character('3'), a2, bT, faces[3] },
		{ "Face 4", rb, new Character('4'), a2, bT, faces[4] }
	};
	
	public Object[] menuBar = {
		fileMenu, editMenu, faceMenu,
		optionMenu, helpMenu
	};
	
	static public JMenuBar createMenuBar(Object[] menuBarData){	//*2	y2
		JMenuBar menuBar = new JMenuBar();	//*2	y1	m1
		for(int i = 0; i < menuBarData.length; i++){
			JMenu menu = createMenu((Object[][])menuBarData[i]);	//*2	y1	L1-2
			menuBar.add(menu);	//*1
		}
		return menuBar;
	}
	
	static ButtonGroup bgroup;	//*1	m1
	static public JMenu createMenu(Object[][] menuData){	//*2	y2
		JMenu menu = new JMenu();	//*2	y1	m1
		menu.setText((String)menuData[0][0]);
//		menu.setMnemonic(((Character)menuData[0][1]).charValue());
		//create redundantly, in case there are any radio buttons:
		bgroup = new ButtonGroup();	//*1	d1
		for(int i = 1; i < menuData.length; i++){
			if(menuData[i][0] == null){
				JSeparator separator = new JSeparator();	//*2	y1	L1-2
				menu.add(separator);	//*1
			}else{
				JMenuItem menuItem = createMenuItem(menuData[i]);	//*2	y1	L1-2
				menu.add(menuItem);	//*1
			}
		}
		return menu;
	}
	
	static public JMenuItem createMenuItem(Object[] data){	//*2	y2
		JMenuItem m = null;	//*1	y1
		MType type = (MType)data[1];
		if(type == mi){
			m = new JMenuItem();	//*1	y1
		}else if(type == cb){
			m = new JCheckBoxMenuItem();	//*1	y1
		}else if(type == rb){
			m = new JRadioButtonMenuItem();	//*1	L1-2
			bgroup.add(m);	//*1
		}
		m.setText((String)data[0]);	//*1	y1
//		m.setMnemonic(((Character)data[2]).charValue());
		m.addActionListener((ActionListener)data[3]);	//*1	y1
		m.setEnabled(((Boolean)data[4]).booleanValue());	//*1	y1
		
		if(data.length == 6){
			m.setIcon((Icon)data[5]);	//*2	y2
		}
		return m;
	}
	
	public Menus(){	//*1	m1
		this.setLayout(new BorderLayout());		//*1	y1
		JMenuBar menu = createMenuBar(menuBar);	//*2	y1	L1-2
		this.add(menu, BorderLayout.NORTH);		//*1
		JPanel p = new JPanel();	//*2	y1	L1-2
		t = new JTextField(10);		//*1	m1	L1-2
		l = new JLabel("Icon Selected", faces[0], JLabel.CENTER);	//*1	m1	L1-2
		p.setLayout(new BorderLayout());	//*1	y1
		p.add(t, BorderLayout.NORTH);		//*1
		p.add(l, BorderLayout.CENTER);		//*1
		this.add(p, BorderLayout.CENTER);	//*1
	}
	
	public static void main(String[] args) {
		Show.inFrame(new Menus(), 300, 200);	//*1	y1
	}
	
}
