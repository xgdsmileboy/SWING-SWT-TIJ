package chapter_13_19_2;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class PushButtonDemo extends Composite{

	Button btn1, btn2;
	Text text;
	
	public PushButtonDemo(Composite parent, int style){
		super(parent, style);
		this.setLayout(new RowLayout());
		btn1 = new Button(this, SWT.PUSH);
		btn2 = new Button(this, SWT.PUSH);
		btn1.setText("Button 1");
		btn2.setText("Button 2");
		text = new Text(this, SWT.SINGLE);
		text.setTextLimit(20);
	}
	
	public void init(){
		
		SelectionListener selectionListener = new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				String name = ((Button)arg0.getSource()).getText();
				text.setText(name + " Pressed");
			}
		};
		
		btn1.addSelectionListener(selectionListener);
		btn2.addSelectionListener(selectionListener);
	}
	
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		
		PushButtonDemo pb = new PushButtonDemo(shell, SWT.NONE);
		pb.init();
		
		shell.setSize(300, 100);
		RowLayout layout = new RowLayout();
		layout.center = true;
		shell.setLayout(layout);
		shell.setText("TextAreaNew");
		
//		FillLayout layout = new FillLayout();
//		layout.type = SWT.VERTICAL;
//		shell.setLayout(layout);
		
		
		shell.addListener(SWT.Dispose, new Listener() {
			
			@Override
			public void handleEvent(Event arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		shell.pack();
		shell.open();
		while(!shell.isDisposed()){
			if(!display.readAndDispatch()){
				display.sleep();
			}
		}
		display.dispose();

	}
	
}
