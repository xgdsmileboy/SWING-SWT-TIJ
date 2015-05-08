package chapter_13_19_7;

import java.lang.reflect.Constructor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;

import chapter_13_19_3.Show;

public class ButtonGroups extends Composite{

	static String[] ids = {"June", "Ward", "Beaver", "Wally", "Eddie", "Lumpy"};
	
	static void makeBPanel(Composite parent, int style, Class bClass, String[] ids){
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new FillLayout());
		Group group = new Group(composite, SWT.NONE);
		String title = bClass.getName();
		title = title.substring(title.lastIndexOf('.') + 1);
		group.setText(title +"-"+ style);
		group.setLayout(new FillLayout());
		
		for(int i = 0; i < ids.length; i++){
			Button ab = null;
			try{
				//Get the dynamic constructor method
				//that takes a String argument
//				Constructor[] ctor = bClass.getConstructors();
//				//Create a new Object
//				ab = (Button)ctor[0].newInstance(group, style);
				
				Constructor ctor = bClass.getConstructor(new Class[]{Composite.class, int.class});
				ab = (Button)ctor.newInstance(group, style);
				
				ab.setText(ids[i]);
				
				// add selection listener to implements only one button 
				// can be selected at one time in a group
				ab.addSelectionListener(new SelectionAdapter() {
					
					@Override
					public void widgetSelected(SelectionEvent e) {
						Button btn = (Button)e.getSource();
						Control[] controls = (Control[])btn.getParent().getChildren();
						for(Control b : controls){
							((Button)b).setSelection(false);
						}
						btn.setSelection(true);
					}
					
//					@Override
//					public void widgetSelected(SelectionEvent e) {
//						Control btn = (Control)e.getSource();
//						Control[] controls = (Control[])btn.getParent().getChildren();
//						for(Control b : controls){
//							((Button)b).setSelection(false);
//						}
//						((Button) btn).setSelection(true);
//					}
				});
				
				
			}catch(Exception ex){
				System.out.println("can't create "+bClass);
				ex.printStackTrace();
			}
		}

	}
	
	public ButtonGroups(Composite parent, int style){
		super(parent, style);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		this.setLayout(gridLayout);
//		this.setLayout(new RowLayout());
		makeBPanel(this, SWT.PUSH, Button.class, ids);
		makeBPanel(this, SWT.TOGGLE, Button.class, ids);
		makeBPanel(this, SWT.CHECK, Button.class, ids);
		makeBPanel(this, SWT.RADIO, Button.class, ids);
	}
	
	public static void main(String[] args) {
		Show.inFrame(new ButtonGroups(Show.shell, SWT.NONE), 500, 500);
	}
}