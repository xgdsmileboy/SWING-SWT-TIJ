package chapter_13_19_13;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import borderLayout.BorderData;
import borderLayout.BorderLayout;
import chapter_13_19_3.Show;

//Takes an array of Strings and makes the first
//element a node and the rest leaves
class Branch {
	TreeItem treeItem;

	public Branch(TreeItem parent, String[] data) {
		treeItem = new TreeItem(parent, SWT.NONE);
		treeItem.setText(data.toString());
		for (int i = 0; i < data.length; i++) {
			TreeItem temp = new TreeItem(treeItem, SWT.NONE);
			temp.setText(data[i]);
		}
	}

	public TreeItem node() {
		return treeItem;
	}
}

public class Trees extends Composite {

	String[][] data = { { "Colors", "Red", "Blue", "Green" },
			{ "Flavors", "Tart", "Sweet", "Bland" },
			{ "Length", "Short", "Medium", "Long" },
			{ "Volume", "High", "Medium", "Low" },
			{ "Temperature", "High", "Medium", "Low" },
			{ "Intensity", "High", "Medium", "Low" } };
	static int i = 0;

	TreeItem root, child, chosen;
	Tree tree;

	public Trees(Composite parent, int style) {
		super(parent, style);
		this.setLayout(new BorderLayout());

		tree = new Tree(this, SWT.SINGLE | SWT.V_SCROLL);
		tree.setLayoutData(BorderData.CENTER);
		root = new TreeItem(tree, SWT.NONE);
		root.setText("root");

		Composite comp = new Composite(this, SWT.NONE);
		comp.setLayout(new FillLayout());
		comp.setLayoutData(BorderData.SOUTH);
		
		Button test = new Button(comp, SWT.PUSH);
		test.setText("Press Me");

		test.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (i < data.length) {

					chosen = tree.getSelection()[0];
					if (chosen == null) {
						chosen = root;
					}
					child = new Branch(chosen, data[i++]).node();
				}
			}
		});

		// change the button's colors:
//		Color foreColor = getDisplay().getSystemColor(SWT.COLOR_WHITE);
		Color backColor = getDisplay().getSystemColor(SWT.COLOR_BLUE);
		
//		test.setForeground(foreColor);
		test.setBackground(backColor);

		
	}

	public static void main(String[] args) {
		 Show.inFrame(new Trees(Show.shell, SWT.NONE), 200, 500);

//		Display display = new Display();
//		Shell shell = new Shell(display);
//		shell.setLayout(new FillLayout());
//
//		// Construct a Tree object.
//		final Tree tree = new Tree(shell, SWT.BORDER);
//
//		File rootFile = new File("C:/");
//
//		// Add root file to the tree.
//		TreeItem root = new TreeItem(tree, SWT.NONE);
//
//		// Set the text displayed on the tree node.
//		root.setText(rootFile.getName());
//
//		// Set the data type of the tree node.
//		root.setData(rootFile);
//
//		// Add a empty sub-node to make the node can be expanded.
//		new TreeItem(root, SWT.NONE);
//
//		tree.addListener(SWT.Expand, new Listener() {
//			@Override
//			public void handleEvent(Event event) {
//				// Get the event-source
//				TreeItem root = (TreeItem) event.item;
//
//				// Dispose the empty node
//				TreeItem[] items = root.getItems();
//				for (TreeItem item : items) {
//					if (item.getData() == null) {
//						item.dispose();
//					}
//				}
//
//				File rootFile = (File) root.getData();
//				File[] files = rootFile.listFiles();
//
//				for (File file : files) {
//					if (file.getName().startsWith(".")) {
//						continue;
//					}
//
//					TreeItem item = new TreeItem(root, SWT.NONE);
//					item.setText(file.getName());
//					item.setData(file);
//
//					if (file.isDirectory()) {
//						// Add a empty sub-node to make the node can be
//						// expanded.
//						System.out.println(file.getAbsolutePath());
//						new TreeItem(item, SWT.NONE);
//					}
//				}
//			}
//
//		});
//
//		shell.pack();
//		shell.open();
//		while (!shell.isDisposed()) {
//			if (!display.readAndDispatch())
//				display.sleep();
//		}
//		display.dispose();
	}
}