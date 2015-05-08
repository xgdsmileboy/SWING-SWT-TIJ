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
        	
           	 //��һ�����ã�����TableEditor����  
                final TableEditor editor = new TableEditor (table);  
                //����һ���ı���������������  
                final Text text = new Text (table, SWT.NONE);  
                //���ı���ǰֵ������Ϊ����е�ֵ  
                text.setText(items[i].getText(j));  
                //���ñ༭��Ԫ��ˮƽ���  
                editor.grabHorizontal = true;  
                //�ؼ����������༭��Ԫ�����ı���󶨵����ĵ�һ��  
                editor.setEditor(text, items[i], j);  
                //���ı���ı�ֵʱ��ע���ı���ı��¼������¼��ı����е����ݡ�  
                //����ʹ�ı���ı����ֵ���Ա���е�����Ҳ����Ӱ��  
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