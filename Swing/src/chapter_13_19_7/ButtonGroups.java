package chapter_13_19_7;

import java.lang.reflect.Constructor;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;

import chapter_13_19_3.Show;

public class ButtonGroups extends JPanel{	//*1	y1

	static String[] ids = {"June", "Ward", "Beaver", "Wally", "Eddie", "Lumpy"};
	
	static JPanel makeBPanel(Class bClass, String[] ids){	//*1	y1
		
		JPanel jp = new JPanel();	//*2	y1	L1-4
		ButtonGroup bg = new ButtonGroup();	//*2	y1	m1
		String title = bClass.getName();
		title = title.substring(title.lastIndexOf('.') + 1);
		jp.setBorder(new TitledBorder(title));	//*2	m1
		for(int i = 0; i < ids.length; i++){
			AbstractButton ab = null;	//*1	y1
			try{
				//Get the dynamic constructor method
				//that takes a String argument
				Constructor ctor = bClass.getConstructor(new Class[]{String.class});	//*1	L1-3
				//Create a new Object
				ab = (AbstractButton)ctor.newInstance(new Object[]{ids[i]});	//*1
				
			}catch(Exception ex){
				System.out.println("can't create "+bClass);
			}
			bg.add(ab);		//*1
			jp.add(ab);		//*1
		}
		return jp;
	}
	
	public ButtonGroups(){	//*1	m1	Ìí¼Ósuper()
		add(makeBPanel(JButton.class, ids));		//*2	L1-2
		add(makeBPanel(JToggleButton.class, ids));	//*2	L1-2
		add(makeBPanel(JCheckBox.class, ids));		//*2	L1-2
		add(makeBPanel(JRadioButton.class, ids));	//*2	L1-2
	}
	
	public static void main(String[] args) {
		Show.inFrame(new ButtonGroups(), 500, 500);	//*1	y1
	}
}
