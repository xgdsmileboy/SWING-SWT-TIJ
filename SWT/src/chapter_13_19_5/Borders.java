package chapter_13_19_5;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;

import chapter_13_19_3.Show;

public class Borders extends Composite{

	static void showBorder(Composite parent, int style){
		Composite comp = new Composite(parent, style);
		comp.setLayout(new FillLayout());
//		String name = String.valueOf(style);
//		Label label = new Label(comp, SWT.FILL);
//		label.setText(name);
	}
	
	public Borders(Composite parent, int style) {
		super(parent, style);
		
		GridLayout sGridLayout = new GridLayout();
		sGridLayout.numColumns = 4;
		sGridLayout.makeColumnsEqualWidth = true;
		setLayout(sGridLayout);
		
//		Borders.showBorder(this, SWT.BORDER);
//		showBorder(this, SWT.BORDER);
//		showBorder(this, SWT.BORDER | SWT.LINE_CUSTOM);
		

		Composite panel1_1 = new Composite(this, SWT.NONE);
		GridLayout pGridLayout = new GridLayout();
		panel1_1.setLayout(pGridLayout);
		GridData pGridData = new GridData(GridData.FILL_BOTH);
		panel1_1.setLayoutData(pGridData);
		
		panel1_1.setLayout(new FillLayout());
		Group group = new Group(panel1_1, SWT.WRAP);
		group.setText("title");
		
		Composite panel1_2 = new Composite(this, SWT.BORDER | SWT.BORDER_SOLID);
		panel1_2.setLayout(pGridLayout);
		panel1_2.setLayoutData(pGridData);

		Composite panel1_3 = new Composite(this, SWT.NONE);
		panel1_3.setLayout(pGridLayout);
		panel1_3.setLayoutData(pGridData);
		panel1_3.addPaintListener(new PaintListener() {
			
			@Override
			public void paintControl(PaintEvent e) {
				// TODO Auto-generated method stub
				GC gc = e.gc;
				gc.setForeground(new Color(Display.getCurrent(), 0, 0, 255));
				gc.drawRectangle(e.x, e.y, e.width - 1, e.height - 1);
				gc = null;
			}
		});
		
		Composite panel1_4 = new Composite(this, SWT.BORDER);
		panel1_4.setLayout(pGridLayout);
		panel1_4.setLayoutData(pGridData);
		
		Composite panel2_1 = new Composite(this, SWT.LOW | SWT.BORDER);
		panel2_1.setLayout(pGridLayout);
		panel2_1.setLayoutData(pGridData);
		
		final Color pColor = new Color(getDisplay(), 0, 0, 255);
		panel2_1.setBackground(pColor);
		
		
		getShell().addListener(SWT.Dispose, new Listener() {

			@Override
			public void handleEvent(Event event) {
				// TODO Auto-generated method stub
				pColor.dispose();
			}
		});
		
		
	}
	
	public static void main(String[] args) {		
		
		Show.inFrame(new Borders(Show.shell, SWT.NONE), 500, 300);
		
//		Display display = new Display();
//		Shell shell = new Shell(display);
//		
//		GridLayout sGridLayout = new GridLayout();
//		sGridLayout.numColumns = 4;
//		sGridLayout.makeColumnsEqualWidth = true;
//		shell.setLayout(sGridLayout);
//		shell.setSize(500, 300);
//	
//		
//		Composite panel1_1 = new Composite(shell, SWT.NONE);
//		GridLayout pGridLayout = new GridLayout();
//		panel1_1.setLayout(pGridLayout);
//		GridData pGridData = new GridData(GridData.FILL_BOTH);
//		panel1_1.setLayoutData(pGridData);
//		
//		panel1_1.setLayout(new FillLayout());
//		Group group = new Group(panel1_1, SWT.WRAP);
//		group.setText("title");
//		
//		Composite panel1_2 = new Composite(shell, SWT.BORDER | SWT.BORDER_SOLID);
//		panel1_2.setLayout(pGridLayout);
//		panel1_2.setLayoutData(pGridData);
//
//		Composite panel1_3 = new Composite(shell, SWT.NONE);
//		panel1_3.setLayout(pGridLayout);
//		panel1_3.setLayoutData(pGridData);
//		panel1_3.addPaintListener(new PaintListener() {
//			
//			@Override
//			public void paintControl(PaintEvent e) {
//				// TODO Auto-generated method stub
//				GC gc = e.gc;
//				gc.setForeground(new Color(Display.getCurrent(), 0, 0, 255));
//				gc.drawRectangle(e.x, e.y, e.width - 1, e.height - 1);
//				gc = null;
//			}
//		});
//		
//		Composite panel1_4 = new Composite(shell, SWT.BORDER);
//		panel1_4.setLayout(pGridLayout);
//		panel1_4.setLayoutData(pGridData);
//		
//		Composite panel2_1 = new Composite(shell, SWT.LOW | SWT.BORDER);
//		panel2_1.setLayout(pGridLayout);
//		panel2_1.setLayoutData(pGridData);
//		
//		final Color pColor = new Color(display, 0, 0, 255);
//		panel2_1.setBackground(pColor);
//		
//		
//		shell.addListener(SWT.Dispose, new Listener() {
//
//			@Override
//			public void handleEvent(Event event) {
//				// TODO Auto-generated method stub
//				pColor.dispose();
//			}
//		});
//		
//		shell.open();
//		while(!shell.isDisposed()){
//			if(display.readAndDispatch()){
//				display.sleep();
//			}
//		}
	}
	
}
