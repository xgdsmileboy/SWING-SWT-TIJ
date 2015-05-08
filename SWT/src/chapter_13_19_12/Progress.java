package chapter_13_19_12;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Slider;

import chapter_13_19_3.Show;

public class Progress extends Composite {
	
	ProgressBar pb;
	Slider sd;
	Scale scale;
	
	public Progress(Composite parent, int style) {
		super(parent, style);
		
		GridLayout gridLayout = new GridLayout(1, true);
		this.setLayout(gridLayout);
		
		pb = new ProgressBar(this, SWT.H_SCROLL);
		
		Group group = new Group(this, SWT.BORDER);
		group.setText("Slide Me");
		group.setLayout(new FillLayout());
		
		scale = new Scale(group, SWT.H_SCROLL);
		scale.setMinimum(0);
		scale.setMaximum(100);
		scale.setSelection(60);
//		scale.setIncrement(1);
		
//		sd = new Slider(this, SWT.H_SCROLL);
//		sd.setLayoutData(BorderData.SOUTH);
//		sd.setMinimum(0);
//		sd.setMaximum(20+10);
//		sd.setSelection(0);
		
		scale.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				pb.setSelection(scale.getSelection());
//				sd.setSelection(num+sd.getMinimum());
			}
		});
		pb.setMinimum(0);
		pb.setMaximum(100);
		pb.setSelection(60);
		
	}   
	public static void main(String args[]) {   
		Show.inFrame(new Progress(Show.shell, SWT.NONE),200,150);   
	} 
}