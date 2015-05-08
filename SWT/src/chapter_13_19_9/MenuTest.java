package chapter_13_19_9;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import borderLayout.BorderData;
import chapter_13_19_3.Show;

public class MenuTest extends Composite{


	Image[] faces = {
		new Image(Display.getCurrent(), "picture/faces/Face0.gif"),
		new Image(Display.getCurrent(), "picture/faces/Face1.gif"),
		new Image(Display.getCurrent(), "picture/faces/Face2.gif"),
		new Image(Display.getCurrent(), "picture/faces/Face3.gif"),
		new Image(Display.getCurrent(), "picture/faces/Face4.gif")
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
	
	Text t;
	CLabel l;
	
	SelectionListener sl1 = new SelectionAdapter() {
		
		@Override
		public void widgetSelected(SelectionEvent e) {
			t.setText(((MenuItem)e.getSource()).getText());
		}
	};
	
	SelectionListener sl2 = new SelectionAdapter() {
		
		@Override
		public void widgetSelected(SelectionEvent e) {
			MenuItem menuItem = (MenuItem)e.getSource();
			l.setText(menuItem.getText());
			l.setImage(menuItem.getImage());
		}
	};
	
	// Store menu data as "resources":
	public Object[][] fileMenu = {
		//Menu name and accelerator:
		{"File", new Character('F')},
		//Name type accel listener enabled
		{"New", mi, new Character('N'), sl1, bT},
		{"Open", mi, new Character('O'), sl1, bT},
		{"Save", mi, new Character('S'), sl1, bF},
		{"Save As", mi, new Character('A'), sl1, bF},
		{null},//Separator
		{"Exit", mi, new Character('X'), sl1, bT}
	};
	
	public Object[][] editMenu = {
		//Menu name
		{"Edit", new Character('E')},
		//Name type accel listener enabled
		{"Cut", mi, new Character('t'), sl1, bT},
		{"Copy", mi, new Character('C'), sl1, bT},
		{"Paste", mi, new Character('P'), sl1, bT},
		{null}, //Separator
		{"Select All", mi, new Character('l'), sl1, bT}
	};
	
	
	public Object[][] faceMenu = {
		// Menu name:
		{ "Faces", new Character('a') },
		// Optinal last element is icon 
		{ "Face 0", rb, new Character('0'), sl2, bT, faces[0] },
		{ "Face 1", rb, new Character('1'), sl2, bT, faces[1] },
		{ "Face 2", rb, new Character('2'), sl2, bT, faces[2] },
		{ "Face 3", rb, new Character('3'), sl2, bT, faces[3] },
		{ "Face 4", rb, new Character('4'), sl2, bT, faces[4] }
	};
	
	public Object[] menuBar1 = {
		fileMenu, editMenu, faceMenu
	};
	


	public Object[][] helpMenu = {
		// Menu name:     
		{ "Help", new Character('H') },
		// Name type accel listener enabled
		{ "Index", mi, new Character('I'), sl1, bT },
		{ "Using help", mi,new Character('U'),sl1,bT},
		{ null }, // Separator
		{ "About", mi, new Character('t'), sl1, bT }
	};
	
	public Object[][] optionMenu = {
		// Menu name:
		{ "Options", new Character('O') },
		// Name type accel listener enabled
		{ "Option 1", cb, new Character('1'), sl1,bT},
		{ "Option 2", cb, new Character('2'), sl1,bT}
	}; 
	
	public Object[] menuBar2 = {
			optionMenu, helpMenu
		};

	
	static public Menu createMenuBar(Composite parent, Object[] menuBarData){
		Menu menuBar = new Menu(parent.getShell(), SWT.BAR);
		for(int i = 0; i < menuBarData.length; i++){
			Menu menu = createMenu(menuBar, (Object[][])menuBarData[i]);
		}
		return menuBar;
	}
	
	
	static public Menu createMenu(Menu parent, Object[][] menuData){
		MenuItem menuCascade = new MenuItem(parent, SWT.CASCADE);
		menuCascade.setText((String)menuData[0][0]);
		Menu menu = new Menu(menuCascade);
		menuCascade.setMenu(menu);

//		menuCascade.setAccelerator(SWT.CTRL+((Character)menuData[0][1]).charValue());
		
//		menu.setMnemonic(((Character)menuData[0][1]).charValue());
		//create redundantly, in case there are any radio buttons:
		
		for(int i = 1; i < menuData.length; i++){
			if(menuData[i][0] == null){
				MenuItem separator = new MenuItem(menu, SWT.SEPARATOR);
			}else{
				MenuItem menuItem = createMenuItem(menu, menuData[i]);
			}
		}
		return menu;
	}
	
	static public MenuItem createMenuItem(Menu parent, Object[] data){
		MenuItem m = null;
		MType type = (MType)data[1];
		if(type == mi){
			m = new MenuItem(parent, SWT.PUSH);
		}else if(type == cb){
			m = new MenuItem(parent, SWT.CHECK);
		}else if(type == rb){
			m = new MenuItem(parent, SWT.RADIO);
		}
		m.setText((String)data[0]);
//		m.setMnemonic(((Character)data[2]).charValue());
//		m.setAccelerator(((Character)data[2]).charValue());
		
		m.addSelectionListener((SelectionListener)data[3]);
		m.setEnabled(((Boolean)data[4]).booleanValue());
		
		if(data.length == 6){
			m.setImage((Image) data[5]);
		}
		return m;
	}
	
	public MenuTest(Composite parent, int type){
		super(parent, type);
		this.setLayout(new borderLayout.BorderLayout());
		
		Menu mainMenu = createMenuBar(parent, menuBar1);
		((Shell)parent.getShell()).setMenuBar(mainMenu);
		
		Menu mainMenu2 = createMenuBar(parent, menuBar2);
		((Shell)parent.getShell()).setMenuBar(mainMenu2);
		
		Composite composite = new Composite(this, SWT.BORDER);
		composite.setLayout(new borderLayout.BorderLayout());
		composite.setLayoutData(BorderData.CENTER);
		
		t = new Text(composite, SWT.SINGLE | SWT.BORDER);
		t.setLayoutData(BorderData.NORTH);
		
		l = new CLabel(composite, SWT.NONE | SWT.BORDER);
		l.setImage(faces[0]);
		l.setAlignment(SWT.CENTER);
		l.setLayoutData(BorderData.CENTER);
		
	}
	
	public static void main(String[] args) {
		Show.inFrame(new MenuTest(Show.shell, SWT.NONE), 300, 200);
	}
	
}
