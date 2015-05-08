package chapter_13_19_10;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Text;

import borderLayout.BorderData;
import borderLayout.BorderLayout;
import chapter_13_19_3.Show;

public class Popup extends Composite {
	Menu popup;
	Text t;
	
	public Popup(Composite parent, int style){
		super(parent, style);
		
		SelectionListener a1 = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				t.setText(((MenuItem)e.getSource()).getText());
			}
		};
		
		this.setLayout(new BorderLayout());
		
		popup = new Menu(getShell(), SWT.POP_UP);
		t = new Text(this, SWT.SINGLE | SWT.BORDER);
		
		t.setLayoutData(BorderData.NORTH);
		
		
		MenuItem m = new MenuItem(popup, SWT.PUSH);
		m.setText("Hither");
		m.addSelectionListener(a1);

		m = new MenuItem(popup, SWT.PUSH);
		m.setText("Yon");
		m.addSelectionListener(a1);
		
		m = new MenuItem(popup, SWT.PUSH);
		m.setText("Afar");
		m.addSelectionListener(a1);
		
		m = new MenuItem(popup, SWT.SEPARATOR);
		
		m = new MenuItem(popup, SWT.PUSH);
		m.setText("Stay Here");
		m.addSelectionListener(a1);

		t.setMenu(popup);
		this.setMenu(popup); 

	}
	
	public static void main(String[] args) {
		Show.inFrame(new Popup(Show.shell, SWT.NONE), 200, 150);
	}
	
}
