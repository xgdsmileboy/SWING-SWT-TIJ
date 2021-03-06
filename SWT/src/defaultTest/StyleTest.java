package defaultTest;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;




public class StyleTest {
	
	//测试按钮的样式
	static class Buttons extends Composite{

		public Buttons(Composite parent, int style) {
			super(parent, style);
			this.setLayout(new FillLayout());
			
			Group group = new Group(this, SWT.BORDER);
			group.setText("buttons");
			group.setLayout(new RowLayout());
			
			Button btn;
			btn = new Button(group, SWT.NONE);
			btn.setText("NONE");
			
			btn = new Button(group, SWT.PUSH);
			btn.setText("PUSH");
			
			btn = new Button(group, SWT.CHECK);
			btn.setText("CHECK");
			
			btn = new Button(group, SWT.RADIO);
			btn.setText("RADIO");
			
			btn = new Button(group, SWT.ARROW);
			btn.setText("ARROW");
			
			btn = new Button(group, SWT.CENTER);
			btn.setText("CENTER");
			
			btn = new Button(group, SWT.LEFT);
			btn.setText("LEFT");
			
			btn = new Button(group, SWT.RIGHT);
			btn.setText("RIGHT");
			
			btn = new Button(group, SWT.BORDER);
			btn.setText("BORDER");
			
			btn = new Button(group, SWT.FLAT);
			btn.setText("FLAT");
		}
		
	}
	
	//测试标签组件的样式
	class Labels extends Composite{

		public Labels(Composite parent, int style) {
			super(parent, style);
			
			this.setLayout(new FillLayout());
			
			Group group = new Group(this, SWT.NONE);
			group.setText("Labels");
			group.setLayout(new RowLayout());
			
			Label lb;
			
			lb = new Label(group, SWT.NONE);
			lb.setText("NONE");
			
			lb = new Label(group, SWT.CENTER);
			lb.setText("CENTER");
			
			lb = new Label(group, SWT.RIGHT);
			lb.setText("RIGHT");
			
			lb = new Label(group, SWT.LEFT);
			lb.setText("LEFT");
			
			lb = new Label(group, SWT.NONE);
			lb.setText("NONE");
			
			lb = new Label(group, SWT.WRAP);
			lb.setText("WRAP");
			
			lb = new Label(group, SWT.BORDER);
			lb.setText("BORDER");
			
			lb = new Label(group, SWT.SEPARATOR);
			lb.setText("SEPARATOR");
			
			lb = new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL);
			lb.setText("SWT.SEPARATOR | SWT.HORIZONTAL");
			
		}
		
	}
	
	//测试文本框组件的样式
	class Texts extends Composite{

		public Texts(Composite parent, int style) {
			super(parent, style);
			this.setLayout(new FillLayout());
			
			Group group = new Group(this, SWT.NONE);
			group.setText("Texts");
			group.setLayout(new RowLayout());
			
			Text text;
			text = new Text(group, SWT.NONE);
			text.setText("NONE");
			
			text = new Text(group, SWT.CENTER);
			text.setText("CENTER");
			
			text = new Text(group, SWT.RIGHT);
			text.setText("RIGHT");
			
			text = new Text(group, SWT.LEFT);
			text.setText("LEFT");
			
			text = new Text(group, SWT.MULTI);
			text.setText("MULTI");
			
			text = new Text(group, SWT.WRAP);
			text.setText("WRAP");
			
			text = new Text(group, SWT.PASSWORD);
			text.setText("PASSWORD");
			
			text = new Text(group, SWT.BORDER);
			text.setText("BORDER");
			
			text = new Text(group, SWT.V_SCROLL);
			text.setText("V_SCROLL");
			
			text = new Text(group, SWT.H_SCROLL);
			text.setText("H_SCROLL");
			
		}
		
	}
	
	//测试下拉框的样式
	class Combos extends Composite{

		public Combos(Composite parent, int style) {
			super(parent, style);
			this.setLayout(new FillLayout());
			
			Group group = new Group(this, SWT.NONE);
			group.setText("Combos");
			group.setLayout(new RowLayout());
			
			String[] items = {"item1", "item2", "item3", "item4", "item5"};
			
			Combo combo;
			combo = new Combo(group, SWT.NONE);
			combo.setItems(items);
			
			combo = new Combo(group, SWT.READ_ONLY);
			combo.setItems(items);
			
			combo = new Combo(group, SWT.SIMPLE);
			combo.setItems(items);
			
		}
		
	}
	
	//测试列表组件的样式
	class Lists extends Composite{

		public Lists(Composite parent, int style) {
			super(parent, style);
			this.setLayout(new FillLayout());
			
			Group group = new Group(this, SWT.NONE);
			group.setText("Lists");
			group.setLayout(new RowLayout());
			
			String[] items = new String[]{"item1","item2","item3","item4","item5","item6","item7","item8","item9"};
			
			List list;
			list = new List(group, SWT.NONE);
			list.setItems(items);
			
			list = new List(group, SWT.V_SCROLL);
			list.setItems(items);
			
			list = new List(group, SWT.MULTI);
			list.setItems(items);
			
			list = new List(group, SWT.SINGLE);
			list.setItems(items);
			
		}
		
	}
	

	public StyleTest(Composite parent, int style){
//		new Buttons(parent, style);
//		new Labels(parent, style);
//		new Texts(parent, style);
//		new Combos(parent, style);
		new Lists(parent, style);
	}
	
	
	
	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());
		Composite composite = new Composite(shell, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		composite.setLayout(new RowLayout());
		new StyleTest(composite, SWT.NONE);
		
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

