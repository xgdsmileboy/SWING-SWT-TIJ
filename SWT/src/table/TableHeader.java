package table;

public class TableHeader {

	private Object[] header = null;
	
	public TableHeader() {
	}
	
	public TableHeader(Object[] tableHeader){
		this.header = tableHeader;
	}
	
	public void setHeaders(Object[] tableHeader){
		this.header = tableHeader;
	}
	
	public Object[] getHeaders(){
		return header;
	}
}
