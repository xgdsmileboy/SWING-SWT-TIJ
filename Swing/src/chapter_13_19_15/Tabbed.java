package chapter_13_19_15;

import java.awt.BorderLayout;
import java.lang.reflect.Constructor;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;

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

public class Tabbed extends JPanel {	//*1	y1

	static Object[][] q = { { "Felix", Borders.class },
							{ "The Professor", Buttons.class },
							{ "Rock Bottom", ButtonGroups.class }, 
							{ "Theodore", Faces.class },
							{ "Simon", Menus.class }, 
							{ "Alvin", Popup.class },
							{ "Tom", ListCombo.class }, 
							{ "Jerry", Progress.class },
							{ "Bugs", Trees.class }, 
							{ "Daffy", Tables.class } };

	static JPanel makePanel(Class c) {	//*1	m1
		String title = c.getName();
		title = title.substring(title.lastIndexOf('.') + 1);
		Constructor ctor = null;	//*1	y1
		JPanel sp = null;	//*1	y1
		try {
			ctor = c.getConstructor();	//*1	y1
			sp = (JPanel) ctor.newInstance();	//*2	y2
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		sp.setBorder(new TitledBorder(title));	//*1	m1
		return sp;
	}

	public Tabbed() {	//*1	m1
		this.setLayout(new BorderLayout());	//*1	m1
		JTabbedPane tabbed = new JTabbedPane();	//*2	y1	m1	L1-2
		for (int i = 0; i < q.length; i++) {
			tabbed.addTab((String) q[i][0], makePanel((Class) q[i][1]));	//*2	y1	m1

		}
		this.add(tabbed, BorderLayout.CENTER);	//*1
		tabbed.setSelectedIndex(q.length / 2);	//*1	y1
	}

	public static void main(String[] args) {
		Show.inFrame(new Tabbed(), 460, 350);	//*1	y1
	}
}
