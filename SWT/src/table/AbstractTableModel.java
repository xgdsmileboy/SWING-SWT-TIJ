package table;


public abstract class AbstractTableModel implements TableModel {

	protected EventListenerList listenerList = new EventListenerList();
	
	public String getColumnName(int column) {
        String result = "";
        for (; column >= 0; column = column / 26 - 1) {
            result = (char)((char)(column%26)+'A') + result;
        }
        return result;
    }
	
	public int findColumn(String columnName) {
        for (int i = 0; i < getColumnCount(); i++) {
            if (columnName.equals(getColumnName(i))) {
                return i;
            }
        }
        return -1;
    }
	
	public Class<?> getColumnClass(int columnIndex) {
        return Object.class;
    }
	
    public boolean isCellEditable(int rowIndex, int columnIndex){
    	return false;
    }

    public Object getValueAt(int rowIndex, int columnIndex){
    	return null;
    }
    
    public void setValueAt(Object val, int row, int col){
    }
    
    public void addTableModelListener(TableModelListener l) {
    	listenerList.add(TableModelListener.class, l);
    }
    
    public void removeTableModelListener(TableModelListener l) {
        listenerList.remove(TableModelListener.class, l);
    }
    
    public TableModelListener[] getTableModelListeners() {
        return listenerList.getListeners(TableModelListener.class);
    }
    
    public void fireTableDataChanged() {
        fireTableChanged(new TableModelEvent(this));
    }
    
    public void fireTableChanged(TableModelEvent e) {
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length-2; i>=0; i-=2) {
            if (listeners[i]==TableModelListener.class) {
                ((TableModelListener)listeners[i+1]).tableChanged(e);
            }
        }
    }
    
}
