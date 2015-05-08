package table;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


class DataModel extends AbstractTableModel{
	Object[][] data = {
			{"one", "two", "three", "four"},
			{"five", "six", "seven", "eight"},
			{"nine", "ten", "eleven", "twelve"}
	};
	//Prints data when table changes:
	class TML implements TableModelListener{
		public void tableChanged(TableModelEvent e){
			for(int i = 0; i < data.length; i++){
				for(int j = 0; j < data[i].length; j++){
					System.out.print(data[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
	
	public DataModel(){
		addTableModelListener((TableModelListener) new TML());
	}
	
	public int getColumnCount(){
		return data[0].length;
	}
	
	public int getRowCount(){
		return data.length;
	}
	
	public Object getValueAt(int row, int col){
		return data[row][col];
	}
	
	public void setValueAt(Object val, int row, int col){
		data[row][col] = val;
		//Indicate the change has happened:
		fireTableDataChanged();
	}
	
	public boolean isCellEditable(int row, int col){
		return true;
	}
	
}

public class Test extends Composite{
	
	public Test(Composite parent, int style){
		super(parent, style);
		setLayout(new FillLayout());
		
		Table table = new Table(this, style);
		DataModel dataModel = new DataModel();
		dataModel.setValueAt("1", 1, 1);
		table.setTableModel(dataModel);
		
//		JTable table = new JTable(new DataModel());
//		add(scrollPane, BorderLayout.CENTER);
		
	}
	
	public static void main(String[] args) {
		
		Display display = new Display();
		Shell shell = new Shell(display);
		
		shell.setLayout(new FillLayout());
		
		Test test = new Test(shell, SWT.BORDER | SWT.FULL_SELECTION | SWT.V_SCROLL);
		
		shell.pack();
		shell.open();
		
		while(!shell.isDisposed()){
			if(!display.readAndDispatch()){
				display.sleep();
			}
		}
		display.dispose();
		
	}
	
	
	
//
//	public static void main(String[] args) {
//		Display display = new Display();
//		Shell shell = new Shell(display);
//		shell.setLayout(new FillLayout());
//		
//		Table table = new Table(shell, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
//		table.getTable().setHeaderVisible(true);
//		table.getTable().setLinesVisible(true);
//		
//		final String[] tableHeader = {"A", "B", "C", "D"};
//		
//		for(int i = 0; i < tableHeader.length; i++){
//			TableColumn tableColumn = new TableColumn(table.getTable(), SWT.NONE);
//			tableColumn.setText(tableHeader[i]);
//		}
//		
//		for (int i = 0; i < table.getTable().getColumnCount(); i++){  
//            table.getTable().getColumn(i).pack();
//        }
//		
//		
//		shell.pack();
//		shell.open();
//		while(!shell.isDisposed()){
//			if(!display.readAndDispatch()){
//				display.sleep();
//			}
//		}
//		display.dispose();
//		
//		
//	}
}
