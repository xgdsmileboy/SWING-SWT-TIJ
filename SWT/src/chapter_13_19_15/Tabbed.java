package chapter_13_19_15;

import java.lang.reflect.Constructor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

import borderLayout.BorderData;
import chapter_13_19_3.Show;
import chapter_13_19_5.Borders;
import chapter_13_19_6.Buttons;
import chapter_13_19_7.ButtonGroups;
import chapter_13_19_8.Faces;
import chapter_13_19_9.Menus;
import chapter_13_19_10.Popup;
import chapter_13_19_11.ListCombo;
import chapter_13_19_12.Progress;
import chapter_13_19_13.Trees;
import chapter_13_19_14.Tables;

public class Tabbed extends Composite {

	static Object[][] q = { 
		    { "Felix", Borders.class },
			{ "The Professor", Buttons.class },
			{ "Rock Bottom", ButtonGroups.class }, 
			{ "Theodore", Faces.class },
			{ "Simon", Menus.class }, 
			{ "Alvin", Popup.class },
			{ "Tom", ListCombo.class },
			{ "Jerry", Progress.class },
			{ "Bugs", Trees.class },
			{ "Daffy", Tables.class } };

	static Composite makePanel(Composite parent, Class c) {
		String title = c.getName();
		title = title.substring(title.lastIndexOf('.') + 1);
		
		Group group = new Group(parent, SWT.NONE);
		group.setText(title);
		group.setLayout(new FillLayout());
		
		Constructor ctor = null;
		//Create a new Object
		Composite panel = null;
		try {
			ctor = c.getConstructors()[0];
			panel = (Composite) ctor.newInstance(group, SWT.NONE);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return group;
	}

	public Tabbed(Composite parent, int style) {
		super(parent, style);
		this.setLayout(new borderLayout.BorderLayout());
		TabFolder tabbed = new TabFolder(this, SWT.NONE);
		tabbed.setLayoutData(BorderData.CENTER);
		for (int i = 0; i < q.length; i++) {
			TabItem tabItem = new TabItem(tabbed, SWT.NONE);
			tabItem.setText((String)q[i][0]);
			Composite child = makePanel(tabbed, (Class) q[i][1]);
			tabItem.setControl(child);
		}
		tabbed.setSelection(q.length / 2);
	}

	public static void main(String[] args) {
		Show.inFrame(new Tabbed(Show.shell, SWT.NONE), 460, 350);
	}
}
