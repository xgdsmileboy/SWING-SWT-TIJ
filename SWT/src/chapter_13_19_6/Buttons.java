package chapter_13_19_6;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import chapter_13_19_3.Show;

public class Buttons extends Composite{
	
	public Buttons(Composite parent, int style) {
		super(parent, style);
		
		RowLayout rowLayout = new RowLayout();
		rowLayout.center = true;
		setLayout(rowLayout);
//		this.pack();
		
		Button jb = new Button(this, SWT.PUSH);
		jb.setText("Button");
		Button toggle = new Button(this, SWT.TOGGLE);
		toggle.setText("ToggleButton");
		Button check = new Button(this, SWT.CHECK);
		check.setText("CheckButton");
		Button radio = new Button(this, SWT.RADIO);
		radio.setText("RadioButton");
		
		Group group = new Group(this, SWT.NONE);
		group.setText("Directions");
		GridLayout gridLayout = new GridLayout();
		gridLayout.makeColumnsEqualWidth = true;
		gridLayout.numColumns = 4;
		group.setLayout(gridLayout);
		
		Button up = new Button(group, SWT.ARROW | SWT.UP | SWT.BORDER);
		Button down = new Button(group, SWT.ARROW | SWT.DOWN | SWT.BORDER);
		Button right = new Button(group, SWT.ARROW | SWT.RIGHT | SWT.BORDER);
		Button left = new Button(group, SWT.ARROW | SWT.LEFT | SWT.BORDER);
		
	}
	
	public static void main(String[] args) {
		Show.inFrame(new Buttons(Show.shell, SWT.CENTER), 300, 200);
	}

}
