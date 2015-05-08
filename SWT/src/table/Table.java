package table;

import java.util.HashMap;
import java.util.Map;


import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import chapter_13_19_14.Tables;

public class Table extends Composite implements TableModelListener{

	private org.eclipse.swt.widgets.Table table = null;
	
	private TableHeader tableHeader = null;
	private TableEditor tableEditor = null;
	private Map<Integer, Integer> rowHeight = new HashMap<Integer, Integer>();
	private int rowMargin = -1;
	private boolean cellSelectionEnabled = false;
	
	private boolean columnSelectionAllowed = false;
	
	private TableModel tableModel = null;
	
	private Color selectionForeground = null;
	private Color selectionBackground = null;
	
	
	public Table(Composite parent, int style) {
		super(parent, SWT.NONE);
		setLayout(new FillLayout());
		table = new org.eclipse.swt.widgets.Table(this, style);
	}
	
	public org.eclipse.swt.widgets.Table getTable(){
		return table;
	}
	
	public void addSelectionListener (SelectionListener listener) {
		table.addSelectionListener(listener);
	}
	
	public void clear (int index) {
		table.clear(index);
	}
	
	public void clear (int start, int end) {
		table.clear(start, end);
	}
	
	public void clear (int [] indices) {
		table.clear(indices);
	}
	
	public void clearAll () {
		table.clearAll();
	}
	
	public Point computeSize (int wHint, int hHint, boolean changed) {
//		this.computeSize(wHint, hHint, changed);
		return table.computeSize(wHint, hHint, changed);
	}
	
	public void deselect (int [] indices) {
		table.deselect(indices);
	}
	
	public void deselect (int index) {
		table.deselect(index);
	}
	
	public void deselect (int start, int end) {
		table.deselect(start, end);
	}
	
	public void deselectAll () {
		table.deselectAll();
	}
	
	public TableColumn getColumn (int index) {
		return table.getColumn(index);
	}
	
	public int getColumnCount () {
		return table.getColumnCount();
	}
	
	public int[] getColumnOrder () {
		return table.getColumnOrder();
	}
	
	public TableColumn [] getColumns () {
		return table.getColumns();
	}
	
	public int getGridLineWidth () {
		return table.getGridLineWidth();
	}
	
	public int getHeaderHeight () {
		return table.getHeaderHeight();
	}
	
	public boolean getHeaderVisible () {
		return table.getHeaderVisible();
	}
	
	public TableItem getItem (int index) {
		return table.getItem(index);
	}
	
	public TableItem getItem (Point point) {
		return table.getItem(point);
	}
	
	public int getItemCount () {
		return table.getItemCount();
	}
	
	public int getItemHeight () {
		return table.getItemHeight();
	}
	
	public TableItem [] getItems () {
		return table.getItems();
	}
	
	public boolean getLinesVisible () {
		return table.getLinesVisible();
	}
	
	public TableItem [] getSelection () {
		return table.getSelection();
	}
	
	public int getSelectionCount () {
		return table.getSelectionCount();
	}
	
	public int getSelectionIndex () {
		return table.getSelectionIndex();
	}
	
	public int [] getSelectionIndices () {
		return table.getSelectionIndices();
	}
	
	public TableColumn getSortColumn () {
		return table.getSortColumn();
	}
	
	public int getSortDirection () {
		return table.getSortDirection();
	}
	
	public int getTopIndex () {
		return table.getTopIndex();
	}
	
	public int indexOf (TableColumn column) {
		return table.indexOf(column);
	}
	
	public int indexOf (TableItem item) {
		return table.indexOf(item);
	}
	
	public boolean isSelected (int index) {
		return table.isSelected(index);
	}
	
	public void remove (int [] indices) {
		table.remove(indices);
	}
	
	public void remove (int index) {
		table.remove(index);
	}
	
	public void remove (int start, int end) {
		table.remove(start, end);
	}
	
	public void removeAll () {
		table.removeAll();
	}
	
	public void removeSelectionListener(SelectionListener listener) {
		table.removeSelectionListener(listener);
	}
	
	public void select (int [] indices) {
		table.select(indices);
	}
	
	public void select (int index) {
		table.select(index);
	}
	
	public void select (int start, int end) {
		table.select(start, end);
	}
	
	public void selectAll () {
		table.selectAll();
	}
	
	public void setColumnOrder (int [] order) {
		table.setColumnOrder(order);
	}
	
	public void setFont (Font font) {
		table.setFont(font);
	}
	
	public void setHeaderVisible (boolean show) {
		table.setHeaderVisible(show);
	}
	
	public void setItemCount (int count) {
		table.setItemCount(count);
	}
	
	public void setLinesVisible (boolean show) {
		table.setLinesVisible(show);
	}
	
	public void setRedraw (boolean redraw) {
		table.setRedraw(redraw);
	}
	
	public void setSelection (int [] indices) {
		table.setSelection(indices);
	}
	
	public void setSelection (TableItem  item) {
		table.setSelection(item);
	}
	
	public void setSelection (TableItem [] items) {
		 table.setSelection(items);
	}
	
	public void setSelection (int index) {
		table.setSelection(index);
	}
	
	public void setSelection (int start, int end) {
		table.setSelection(start, end);
	}
	
	public void setSortColumn (TableColumn column) {
		table.setSortColumn(column);
	}
	
	public void setSortDirection (int direction) {
		table.setSortDirection(direction);
	}
	
	public void setTopIndex (int index) {
		table.setTopIndex(index);
	}
	
	public void showColumn (TableColumn column) {
		table.showColumn(column);
	}
	
	public void showItem (TableItem item) {
		table.showItem(item);
	}
	
	public void showSelection () {
		table.showSelection();
	}
	
	/**
	 * some function fix to the JTable
	 * add header for the table, but it is not equal to that 
	 * of JTable, JTable the param is another class "JTableHeader"
	 */
	
	public void setTableModel(TableModel tableModel){
		if (tableModel == null) {
            throw new IllegalArgumentException("Cannot set a null TableModel");
        }
        if (this.tableModel != tableModel) {
            TableModel old = this.tableModel;
            if (old != null) {
                old.removeTableModelListener(this);
            }
            this.tableModel = tableModel;
            tableModel.addTableModelListener(this);

            tableChanged(new TableModelEvent(tableModel, TableModelEvent.HEADER_ROW));

//            firePropertyChange("model", old, tableModel);

//            if (getAutoCreateRowSorter()) {
//                setRowSorter(new TableRowSorter<TableModel>(dataModel));
//            }
        }
	}
	
	public void setTableHeader(TableHeader tableHeader){
		this.tableHeader = tableHeader;
		for(int i = 0; i < tableHeader.getHeaders().length; i++){
			TableColumn tableColumn = new TableColumn(table, SWT.NONE);
			tableColumn.setText(tableHeader.getHeaders()[i].toString());
		}
	}
	
	public TableHeader getTableHeader(){
		return this.tableHeader;
	}
	
	public void setRowHeight(int row, int height){
		if(rowHeight.containsKey(row)){
			rowHeight.remove(row);
			rowHeight.put(Integer.valueOf(row), Integer.valueOf(height));
		}else{
			rowHeight.put(Integer.valueOf(row), Integer.valueOf(height));
		}
	}
	
	public int getRowHeight(int row){
		if(rowHeight.containsKey(row)){
			return rowHeight.get(Integer.valueOf(row));
		}
		return -1;
	}
	
	public void setRowMargin(int margin){
		rowMargin = margin;		
	}
	
	public int getRowMargin(){
		return rowMargin;
	}
	
	public void setColumnSelectionAllowed(boolean allowed){
		columnSelectionAllowed = allowed;
	}
	
	public boolean getColumnSelectionAllowed(){
		return columnSelectionAllowed;
	}
	
	public void setCellSelectionEnabled(boolean enabled){
		cellSelectionEnabled = enabled;
	}
	
	public boolean getCellSelectionEnabled(){
		return cellSelectionEnabled;
	}
	
	public int getSelectedRow(){
		return -1;
	}
	
	public int[] getSelectedRows(){
		return null;
	}
	
	public int getSelectedColumn(){
		return -1;
	}
	
	public int[] getSelectedColumns(){
		return null;
	}
	
	public int getSelectedRowCount(){
		return -1;
	}
	
	public int getSelectedColumnCount(){
		return -1;
	}
	
	public boolean isRowSelected(int row){
		return false;
	}
	
	public boolean isColumnSelected(int col){
		return false;
	}

	public boolean isCellSelected(int row, int col){
		return false;
	}
	
	public void changeSelection(int row, int col, boolean oldState, boolean newState){
		
	}
	
	public Color getSelectionForeground(){
		return selectionForeground;
	}
	
	public void setSelectionForeground(Color foreground){
		this.selectionForeground = foreground;
	}
	
	public Color getSelectionBackground(){
		return selectionBackground;
	}
	
	public void setSelectionBackground(Color background){
		this.selectionBackground = background;
	}
	
	public int getColumn(Object object){
		return -1;
	}
	
	public int getRowCount(){
		return -1;
	}
	
	public String getColumnName(int col){
		return "";
	}
	
	public Class getColumnClass(int col){
		return String.class;
	}
	
	public Object getValueAt(int row, int col){
		Point point = new Point(row, col);		
		return table.getItem(point);
	}
	
	public void setValueAt(Object val, int row, int col){
		
	}
	
	public boolean isCellEditable(int row, int col){
		return false;
	}
	
	public void addColumn(TableColumn tableColumn){
		
	}
	
	public void removeColumn(TableColumn tableColumn){
		
	}
	
	public void moveColumn(int column, int targetColumn){
		
	}
	
	Rectangle getCellRect(int row, int col, boolean inludeSpacing){
		return null;
	}
	
	public boolean editCellAt(int row, int col){
		return false;
	}
	
	public TableEditor getTableEditor(){
		return tableEditor;
	}
	
	public void setTableEditor(TableEditor tableEditor){
		this.tableEditor = tableEditor;
	}
	
	public void removeTableEditor(){
		
	}
	
	/**
	 * some functions that serves  for the JTable functions
	 */
	void setEditable(int row, int column){
		
		TableItem[] items = table.getItems();
		for(int i = 0; i < items.length; i++){
			for(int j = 0; j < table.getColumnCount(); j++){
				if(i != row || j != column) continue;
				final TableEditor editor = new TableEditor(table);
				final Text text = new Text(table, SWT.NONE);
				text.setText(items[i].getText(j));
				editor.grabHorizontal = true;
				editor.setEditor(text, items[i], j);
				final int col = j;
				text.addModifyListener(new ModifyListener() {
					@Override
					public void modifyText(ModifyEvent e) {
						editor.getItem().setText(col, text.getText());
					}
				});
			}
		}           
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		System.out.println("*******************");
//		 if (e == null || e.getFirstRow() == TableModelEvent.HEADER_ROW) {
//	            // The whole thing changed
////	            clearSelectionAndLeadAnchor();
//
////	            rowModel = null;
//
////	            if (sortManager != null) {
////	                try {
////	                    ignoreSortChange = true;
////	                    sortManager.sorter.modelStructureChanged();
////	                } finally {
////	                    ignoreSortChange = false;
////	                }
////	                sortManager.allChanged();
////	            }
//
////	            if (getAutoCreateColumnsFromModel()) {
////	                // This will effect invalidation of the JTable and JTableHeader.
////	                createDefaultColumnsFromModel();
////	                return;
////	            }
//
////	            resizeAndRepaint();
//			 	layout();
//	            return;
//	        }
//
////	        if (sortManager != null) {
////	            sortedTableChanged(null, e);
////	            return;
////	        }
//
//	        // The totalRowHeight calculated below will be incorrect if
//	        // there are variable height rows. Repaint the visible region,
//	        // but don't return as a revalidate may be necessary as well.
////	        if (rowModel != null) {
////	            repaint();
////	        }
////
////	        if (e.getType() == TableModelEvent.INSERT) {
////	            tableRowsInserted(e);
////	            return;
////	        }
////
////	        if (e.getType() == TableModelEvent.DELETE) {
////	            tableRowsDeleted(e);
////	            return;
////	        }
//
//	        int modelColumn = e.getColumn();
//	        int start = e.getFirstRow();
//	        int end = e.getLastRow();
//
//	        Rectangle dirtyRegion;
//	        if (modelColumn == TableModelEvent.ALL_COLUMNS) {
//	            // 1 or more rows changed
//	            dirtyRegion = new Rectangle(0, start * getRowHeight(),
//	                                        getColumnModel().getTotalColumnWidth(), 0);
//	        }
//	        else {
//	            // A cell or column of cells has changed.
//	            // Unlike the rest of the methods in the JTable, the TableModelEvent
//	            // uses the coordinate system of the model instead of the view.
//	            // This is the only place in the JTable where this "reverse mapping"
//	            // is used.
//	            int column = convertColumnIndexToView(modelColumn);
//	            dirtyRegion = getCellRect(start, column, false);
//	        }
//
//	        // Now adjust the height of the dirty region according to the value of "end".
//	        // Check for Integer.MAX_VALUE as this will cause an overflow.
//	        if (end != Integer.MAX_VALUE) {
//	            dirtyRegion.height = (end-start+1)*getRowHeight();
//	            repaint(dirtyRegion.x, dirtyRegion.y, dirtyRegion.width, dirtyRegion.height);
//	        }
//	        // In fact, if the end is Integer.MAX_VALUE we need to revalidate anyway
//	        // because the scrollbar may need repainting.
//	        else {
//	            clearSelectionAndLeadAnchor();
//	            resizeAndRepaint();
//	            rowModel = null;
//	        }
	}
	
	
	
}
