package List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
public class ListDemo extends Shell {
	private List to;
	private List from;
	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			ListDemo shell = new ListDemo(display, SWT.SHELL_TRIM);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the shell
	 * @param display
	 * @param style
	 */
	public ListDemo(Display display, int style) {
		super(display, style);
		createContents();
	}
	/**
	 * Create contents of the window
	 */
	protected void createContents() {
		setText("List Demo");
		setSize(500, 375);
		String[] form_ = new String[20];
		String[] to_ = new String[0];
		for (int i = 0; i < form_.length; i++) {
			form_[i] = "item_" + i ;
		}
		
		from = new List(this, SWT.V_SCROLL | SWT.MULTI | SWT.BORDER);
		from.setBounds(24, 10, 176, 204);
		from.setItems(form_);
		from.setToolTipText("From");
		to = new List(this, SWT.BORDER | SWT.MULTI | SWT.BORDER);
		to.setBounds(284, 10, 176, 204);
		to.setItems(to_ );
		to.setToolTipText("To");
		
		//
		SelectionAdapter listener = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e){
				Button selected = (Button) e.widget;
				//通过widget上的text进行匹配。
				if(selected.getText().equalsIgnoreCase("<")){
					move(to.getSelection(), to, from);
				}else if(selected.getText().equalsIgnoreCase("<<")){
					move(to.getItems(), to, from);
				}else if(selected.getText().equalsIgnoreCase(">")){
					move(from.getSelection(), from, to);
				}else if(selected.getText().equalsIgnoreCase(">>")){
					move(from.getItems(), from, to);
				}else if(selected.getText().equalsIgnoreCase("^")){
					int index = to.getSelectionIndex();
					if(index <= 0){
						return;
					}else{
						String currentValue = to.getItem(index);
						to.setItem(index, to.getItem(index - 1));
						to.setItem(index-1, currentValue);
						to.setSelection(index-1);
					}
				}else if(selected.getText().equalsIgnoreCase("v")){
					int index = to.getSelectionIndex();
					if(index >= to.getItemCount()-1){
						return;
					}else{
						String currentValue = to.getItem(index);
						to.setItem(index, to.getItem(index + 1));
						to.setItem(index+1, currentValue);
						to.setSelection(index+1);
					}
				}
			}
			
			public void move(String[] items, List from , List to ){
				for (int i = 0; i < items.length; i++) {
					from.remove(items[i]);
					to.add(items[i]);
				}
			}
		};
		final Button lb = new Button(this, SWT.NONE);
		lb.setText("<");
		lb.setBounds(215, 15, 50, 27);
		lb.addSelectionListener(listener);
		final Button llb = new Button(this, SWT.NONE);
		llb.setBounds(215, 67, 50, 27);
		llb.setText("<<");
		llb.addSelectionListener(listener);
		final Button rb = new Button(this, SWT.NONE);
		rb.setBounds(215, 119, 50, 27);
		rb.setText(">");
		rb.addSelectionListener(listener);
		final Button rrb = new Button(this, SWT.NONE);
		rrb.setBounds(215, 171, 50, 27);
		rrb.setText(">>");
		rrb.addSelectionListener(listener);
		final Button button = new Button(this, SWT.NONE);
		button.setText("^");
		button.setBounds(394, 220, 30, 27);
		button.addSelectionListener(listener);
		final Button vButton = new Button(this, SWT.DOWN);
		vButton.setBounds(430, 220, 30, 27);
		vButton.setText("v");
		vButton.addSelectionListener(listener);
		//
	}
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
