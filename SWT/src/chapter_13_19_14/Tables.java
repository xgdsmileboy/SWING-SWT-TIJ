package chapter_13_19_14;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import borderLayout.BorderData;
import borderLayout.BorderLayout;
import chapter_13_19_3.Show;



public class Tables extends Composite{

	static String[][] data = {
		{"one", "two", "three", "four"},
		{"five", "six", "seven", "eight"},
		{"nine", "ten", "eleven", "twelve"}
	};
	
	Table table;
	
	public Tables(Composite parent, int style){
		super(parent, style);
		setLayout(new BorderLayout());

		table = new Table(this, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		table.setLayoutData(BorderData.CENTER);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		setHeaders();
		setDatas();
		
		update();
		addListener();
		
	}
	
	public void setHeaders(){
		final String[] tableHeader = {"A", "B", "C", "D"};
		
		for(int i = 0; i < tableHeader.length; i++){
			TableColumn tableColumn = new TableColumn(table, SWT.NONE);
			tableColumn.setText(tableHeader[i]);
		}
	}
	
	public void setDatas(){
		TableItem tableItem;
		for(int i = 0; i < data.length; i++){
			tableItem = new TableItem(table, SWT.NONE);
			tableItem.setText(data[i]);
//			for(int j = 0; j < data[i].length; j++){
//				tableItem.setText(j, data[i][j]);
//			}
		}
	}
	
	public void update(){
        for (int i = 0; i < table.getColumnCount(); i++){  
            table.getColumn(i).pack();
        }
	}
	
	public void addListener(){
        TableItem[] items = table.getItems();
        for(int i = 0; i < items.length; i++){
        	for(int j = 0; j < table.getColumnCount(); j++){
        	
           	 //第一列设置，创建TableEditor对象  
                final TableEditor editor = new TableEditor (table);  
                //创建一个文本框，用于输入文字  
                final Text text = new Text (table, SWT.NONE);  
                //将文本框当前值，设置为表格中的值  
                text.setText(items[i].getText(j));  
                //设置编辑单元格水平填充  
                editor.grabHorizontal = true;  
                //关键方法，将编辑单元格与文本框绑定到表格的第一列  
                editor.setEditor(text, items[i], j);  
                //当文本框改变值时，注册文本框改变事件，该事件改变表格中的数据。  
                //否则即使改变的文本框的值，对表格中的数据也不会影响  
                final int col = j;
                text.addModifyListener( new ModifyListener(){  
	                public void modifyText(ModifyEvent e) {  
		                editor.getItem().setText(col, text.getText());
		                Tables.showData(table);
	                }  
                }); 
                
        	}
        }
	}
	
	public static void showData(Table table){
		TableItem[] items = table.getItems();
		for(int i = 0; i < items.length; i++){
			for(int j = 0; j < table.getColumnCount(); j++){
				System.out.print(items[i].getText(j) + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Show.inFrame(new Tables(Show.shell, SWT.NONE), 200, 200);
	}
}