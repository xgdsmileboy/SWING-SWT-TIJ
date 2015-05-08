package chapter_13_19_11;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;

import chapter_13_19_3.Show;


public class ListCombo extends Composite {
	
	static String[] ids = {"June", "Ward", "Beaver", "Wally", "Eddie", "Lumpy"};
	
	public ListCombo(Composite parent, int style) {
		super(parent, style);
		
		// 添加布局之后竖直滚动条失效
//		GridLayout gridLayout = new GridLayout();
//		gridLayout.numColumns = 1;
//		setLayout(gridLayout);
		
		List list = new List(this, SWT.V_SCROLL | SWT.H_SCROLL | SWT.SINGLE | SWT.BORDER);
		list.setBounds(10, 10, 200, 100);
		list.setItems(ids);
//		list.setToolTipText("scrallable list");

		Combo combo = new Combo(this, SWT.DROP_DOWN | SWT.READ_ONLY);
		combo.setBounds(10, 120, 200, 20);
		for(int i = 0; i < 100; i++){
			combo.add(String.valueOf(i));
		}
//		combo.setItems(ids);
		combo.select(0);
//		combo.setToolTipText("read only combo");
	}
	
	public static void main(String args[]) {
		Show.inFrame(new ListCombo(Show.shell, SWT.NONE), 200, 200);
	}
} 