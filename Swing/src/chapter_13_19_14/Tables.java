package chapter_13_19_14;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import chapter_13_19_3.Show;


class DataModel extends AbstractTableModel{	//n1
	Object[][] data = {
			{"one", "two", "three", "four"},
			{"five", "six", "seven", "eight"},
			{"nine", "ten", "eleven", "twelve"}
	};
	//Prints data when table changes:
	class TML implements TableModelListener{	//n1
		public void tableChanged(TableModelEvent e){	//n2
			for(int i = 0; i < data.length; i++){
				for(int j = 0; j < data[i].length; j++){
					System.out.print(data[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
	
	public DataModel(){
		addTableModelListener((TableModelListener) new TML());	//n1
	}
	
	public int getColumnCount(){	//*1	m1
		return data[0].length;
	}
	
	public int getRowCount(){	//*1	m1
		return data.length;
	}
	
	public Object getValueAt(int row, int col){	//*1	m1
		return data[row][col];
	}
	
	public void setValueAt(Object val, int row, int col){	//*1	m1
		data[row][col] = val;
		//Indicate the change has happened:
		fireTableDataChanged();
	}
	
	public boolean isCellEditable(int row, int col){	//*1	m1
		return true;
	}
	
}


public class Tables extends JPanel{	//*1	y1

	public Tables(){	//*1	m1
		setLayout(new BorderLayout());	//*1	y1
		JTable table = new JTable();	//*2	y1	m1	L1-4
		table.setModel(new DataModel());	//*2	y1	m1
//		JTable table = new JTable(new DataModel());
		JScrollPane scrollPane = JTable.createScrollPaneForTable(table);	//*2
		add(scrollPane, BorderLayout.CENTER);	//*1
		
	}
	
	public static void main(String[] args) {
		Show.inFrame(new Tables(), 200, 200);	//*1	y1
	}
}
