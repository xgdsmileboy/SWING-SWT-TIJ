package chapter_13_19_3;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class Show {

	public static Display display;
	public static Shell shell;
	static{
		Show.display = new Display();
		Show.shell = new Shell(display);
		
	}
	
	public static void inFrame(Composite composite, int width, int height){
		String title = composite.getClass().toString();
		//Remove the word "class"
		if(title.indexOf("class") != -1){
			title = title.substring(6);
		}
		shell.addListener(SWT.Dispose, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		Show.shell.setLayout(new FillLayout());
		
//		composite.setParent(shell);
		Show.shell.setSize(width, height);
		Show.shell.setText(title);
		Show.shell.pack();
		Show.shell.open();
		
		while(!Show.shell.isDisposed()){
			if(!Show.display.readAndDispatch()){
				Show.display.sleep();
			}
		}
		Show.display.dispose();
	}
	
	public static void main(String[] args) {
		Show.inFrame(new Composite(Show.shell, SWT.NONE), 500, 300);
	}
}
