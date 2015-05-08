package table;


public class TableModelEvent extends java.util.EventObject {

	
    /** Identifies the addtion of new rows or columns. */
    public static final int INSERT =  1;
    /** Identifies a change to existing data. */
    public static final int UPDATE =  0;
    /** Identifies the removal of rows or columns. */
    public static final int DELETE = -1;

    /** Identifies the header row. */
    public static final int HEADER_ROW = -1;

    /** Specifies all columns in a row or rows. */
    public static final int ALL_COLUMNS = -1;
	
    
    protected int       type;
    protected int       firstRow;
    protected int       lastRow;
    protected int       column;
    
    
    public TableModelEvent(TableModel source) {
        // Use Integer.MAX_VALUE instead of getRowCount() in case rows were deleted.
        this(source, 0, Integer.MAX_VALUE, ALL_COLUMNS, UPDATE);
    }
    
    public TableModelEvent(TableModel tableModel, int row) {
        this(tableModel, row, row, ALL_COLUMNS, UPDATE);
    }
    
    public TableModelEvent(TableModel source, int firstRow, int lastRow) {
        this(source, firstRow, lastRow, ALL_COLUMNS, UPDATE);
    }
    
    public TableModelEvent(TableModel source, int firstRow, int lastRow, int column) {
        this(source, firstRow, lastRow, column, UPDATE);
    }
    
    public TableModelEvent(TableModel source, int firstRow, int lastRow, int column, int type) {
        super(source);
        this.firstRow = firstRow;
        this.lastRow = lastRow;
        this.column = column;
        this.type = type;
    }
    
    public int getFirstRow() { return firstRow; };

    /** Returns the last row that changed. */
    public int getLastRow() { return lastRow; };

    /**
     *  Returns the column for the event.  If the return
     *  value is ALL_COLUMNS; it means every column in the specified
     *  rows changed.
     */
    public int getColumn() { return column; };
    
    /**
     *  Returns the type of event - one of: INSERT, UPDATE and DELETE.
     */
    public int getType() { return type; }
    
}
