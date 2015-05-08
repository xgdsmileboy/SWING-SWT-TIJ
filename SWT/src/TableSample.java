
import java.util.Hashtable;  
 
import org.eclipse.swt.SWT;  
import org.eclipse.swt.custom.CCombo;  
import org.eclipse.swt.custom.ControlEditor;  
import org.eclipse.swt.custom.TableCursor;  
import org.eclipse.swt.custom.TableEditor;  
import org.eclipse.swt.custom.ViewForm;  
import org.eclipse.swt.events.FocusAdapter;  
import org.eclipse.swt.events.FocusEvent;  
import org.eclipse.swt.events.KeyAdapter;  
import org.eclipse.swt.events.KeyEvent;  
import org.eclipse.swt.events.ModifyEvent;  
import org.eclipse.swt.events.ModifyListener;  
import org.eclipse.swt.events.MouseEvent;  
import org.eclipse.swt.events.MouseListener;  
import org.eclipse.swt.events.SelectionAdapter;  
import org.eclipse.swt.events.SelectionEvent;  
import org.eclipse.swt.layout.FillLayout;  
import org.eclipse.swt.layout.GridData;  
import org.eclipse.swt.layout.GridLayout;  
import org.eclipse.swt.widgets.Composite;  
import org.eclipse.swt.widgets.Display;  
import org.eclipse.swt.widgets.Event;  
import org.eclipse.swt.widgets.Listener;  
import org.eclipse.swt.widgets.Menu;  
import org.eclipse.swt.widgets.MenuItem;  
import org.eclipse.swt.widgets.Shell;  
import org.eclipse.swt.widgets.Table;  
import org.eclipse.swt.widgets.TableColumn;  
import org.eclipse.swt.widgets.TableItem;  
import org.eclipse.swt.widgets.Text;  
import org.eclipse.swt.widgets.ToolBar;  
import org.eclipse.swt.widgets.ToolItem;  
 
public class TableSample {  
    public class TableItemControls{  
 
     Text text;  
       CCombo combo;  
       TableEditor tableeditor;  
       TableEditor tableeditor1;  
        
       public TableItemControls(Text text, CCombo combo, TableEditor tableeditor, TableEditor tableeditor1) {  
//      super();  
        this.text = text;  
        this.combo = combo;  
        this.tableeditor = tableeditor;  
        this.tableeditor1 = tableeditor1;  
       }  
       public void dispose()  
       {  
        text.dispose();  
        combo.dispose();  
        tableeditor.dispose();  
        tableeditor1.dispose();  
       }  
    };  
    private Shell sShell = null; // @jve:decl-index=0:visual-constraint="10,10"  
    private ViewForm viewForm = null;  
    private ToolBar toolBar = null;  
    private Composite composite = null;  
    private Table table = null;  
    private Menu menu = null;  
    private Hashtable<TableItem, TableItemControls> tablecontrols = new Hashtable<TableItem, TableItemControls>();  
 
    //����ViewForm�����ù������ͱ��  
    private void createViewForm() {  
       viewForm = new ViewForm(sShell, SWT.NONE);  
       viewForm.setTopCenterSeparate(true);  
       createToolBar();  
       viewForm.setTopLeft(toolBar);  
       createComposite();  
       viewForm.setContent(composite);  
    }  
 
    //����������  
    private void createToolBar() {  
       toolBar = new ToolBar(viewForm, SWT.FLAT);  
       final ToolItem add = new ToolItem(toolBar, SWT.PUSH);  
       add.setText("���");  
//     add.setImage( ImageFactory.loadImage( toolBar.getDisplay() , ImageFactory.ADD_OBJ));  
       final ToolItem del = new ToolItem(toolBar, SWT.PUSH);  
       del.setText("ɾ��");  
//     del.setImage( ImageFactory.loadImage( toolBar.getDisplay() , ImageFactory.DELETE_OBJ));  
       final ToolItem back = new ToolItem(toolBar, SWT.PUSH);  
       back.setText("����");  
//     back.setImage( ImageFactory.loadImage( toolBar.getDisplay() , ImageFactory.BACKWARD_NAV));  
       final ToolItem forward = new ToolItem(toolBar, SWT.PUSH);  
       forward.setText("����");  
//     forward.setImage( ImageFactory.loadImage( toolBar.getDisplay() , ImageFactory.FORWARD_NAV));  
       final ToolItem save = new ToolItem(toolBar, SWT.PUSH);  
       save.setText("����");  
//     save.setImage( ImageFactory.loadImage( toolBar.getDisplay() , ImageFactory.SAVE_EDIT));  
       //��������ť�¼�����  
       Listener listener = new Listener(){  
        public void handleEvent(Event event) {  
         //���������Ӱ�ť�����һ�У���ʵ�ʵ���Ŀʵ����ͨ���ǽ�������Ĳ������������  
         //����Ϊ�˼��������ӹ̶���һ����¼  
         if ( event.widget == add )  
         {  
          TableItem item = new TableItem(table, SWT.NONE);  
          item.setText(new String[] {"֣��", "Ů","568","zhengliu@sina.com"});  
         }  
         //�������ɾ����ť  
         else if ( event.widget == del)  
         {  
          //���Ȼ�ñ�������е���  
          TableItem[] items = table.getItems();  
          //ѭ��������  
          for ( int i=items.length-1;i>=0;i-- ){  
           //�������û�б�ѡ�У�����ѭ��  
           if ( !items[i].getChecked())  
            continue;  
           //����ѡ�У����Ҹñ�����Ƿ��и���  
           int index = table.indexOf( items[i]);  
           //���û�и��У�����ѭ��  
           if (index<0)  
            continue;  
           //ɾ���󶨵Ŀؼ�  
           TableItemControls cons = tablecontrols.get(items[index]);  
           if (cons != null) {  
            cons.dispose();  
            tablecontrols.remove(items[index]);  
            System.out.println("dispose " + index);  
           }  
           //����и��У�ɾ������  
//         items[index].dispose();  
           table.remove( index );  
           System.out.println("i="+i+", index="+index);  
           System.out.println("����:" + table.getItemCount());  
//         table.pack();  
          }  
         }  
         //����������ư�ť  
         else if ( event.widget == back)  
         {  
          int selectedRow = table.getSelectionIndex();  
          if ( selectedRow > 0 )  
           table.setSelection( selectedRow-1 );//����ѡ�е�����  
         }  
         //����������ư�ť  
         else if ( event.widget == forward)  
         {  
          int selectedRow = table.getSelectionIndex();  
          if ( selectedRow > -1&& selectedRow<table.getItemCount()-1)  
           table.setSelection( selectedRow+1 );//����ѡ�е�����  
         }  
         //����������水ť  
         else if ( event.widget == save)  
         {  
          TableItem [] items = table.getItems();  
          //���浽�ļ������ݿ��У����ݳ־û�������ʡ��  
          for ( int i=0;i<items.length;i++)  
           for (int j=0;j<table.getColumnCount();j++)  
            System.out.println(items[i].getText(j));  
         }  
        }  
         
       };  
       //Ϊ�������İ�ťע���¼�  
       add.addListener( SWT.Selection , listener );  
       del.addListener( SWT.Selection, listener );  
       back.addListener( SWT.Selection , listener );  
       forward.addListener( SWT.Selection, listener );  
       save.addListener( SWT.Selection, listener );  
    }  
    //�������ñ������  
    private void createComposite() {  
       GridLayout gridLayout = new GridLayout();  
       gridLayout.numColumns = 1;  
       composite = new Composite(viewForm, SWT.NONE);  
       composite.setLayout(gridLayout);  
       createTable();  
    }  
    //�������  
    private void createTable() {  
       //��񲼾�  
       GridData gridData = new org.eclipse.swt.layout.GridData();  
       gridData.horizontalAlignment = SWT.FILL;  
       gridData.grabExcessHorizontalSpace = true;  
       gridData.grabExcessVerticalSpace = true;  
       gridData.verticalAlignment = SWT.FILL;  
        
       //�������ʹ��SWT.FULL_SELECTION��ʽ����ͬʱѡ��һ��  
       table = new Table(composite, SWT.MULTI|SWT.FULL_SELECTION|SWT.CHECK);  
       table.setHeaderVisible(true);//������ʾ��ͷ  
       table.setLayoutData(gridData);//���ñ�񲼾�  
       table.setLinesVisible(true);//������ʾ�����/*  
       //������ͷ���ַ�������  
       String[] tableHeader = {"����","�Ա�","�绰","�����ʼ�"};  
       for (int i=0;i<tableHeader.length;i++){  
        TableColumn tableColumn = new TableColumn(table, SWT.NONE);  
        tableColumn.setText( tableHeader[i]);  
        //���ñ�ͷ���ƶ���Ĭ��Ϊfalse  
        tableColumn.setMoveable(true);  
       }  
       //�����������  
       TableItem item = new TableItem(table, SWT.NONE);  
       item.setText(new String[] {"����", "��","123","zhangsan@sina.com"});  
       //����ͼ��  
       //item.setImage( ImageFactory.loadImage( table.getDisplay(),ImageFactory.ICON_BOY));  
        
       for (int i = 0; i < 5; i++) {  
        item = new TableItem(table, SWT.NONE);  
        item.setText(new String[] {"����", "��","4582","lisi@sina.com"});  
       }  
       //����ͼ��  
       //item.setImage( ImageFactory.loadImage( table.getDisplay(),ImageFactory.ICON_BOY));  
        
       item = new TableItem(table, SWT.NONE);  
       item.setText(new String[] {"����", "Ů","567","zhouwu@sina.com"});  
       //����ͼ��  
       //item.setImage( ImageFactory.loadImage( table.getDisplay(),ImageFactory.ICON_GIRL));  
 
       //��ӿɱ༭�ĵ�Ԫ��  
       // /******************************************************  
       TableItem [] items = table.getItems ();  
       for (int i=0; i<items.length; i++) {  
        //��һ�����ã�����TableEditor����  
        final TableEditor editor = new TableEditor (table);  
        //����һ���ı���������������  
        final Text text = new Text (table, SWT.NONE);  
        //���ı���ǰֵ������Ϊ����е�ֵ  
        text.setText(items[i].getText(0));  
        //���ñ༭��Ԫ��ˮƽ���  
        editor.grabHorizontal = true;  
        //�ؼ����������༭��Ԫ�����ı���󶨵����ĵ�һ��  
        editor.setEditor(text, items[i], 0);  
        //���ı���ı�ֵʱ��ע���ı���ı��¼������¼��ı����е����ݡ�  
        //����ʹ�ı���ı����ֵ���Ա���е�����Ҳ����Ӱ��  
        text.addModifyListener( new ModifyListener(){  
         public void modifyText(ModifyEvent e) {  
          editor.getItem().setText(1,text.getText());  
         }  
          
        });  
        //ͬ��Ϊ�ڶ��а�������CCombo  
        final TableEditor editor1 = new TableEditor (table);  
        final CCombo combo = new CCombo (table, SWT.NONE);  
        combo.add("��");  
        combo.add("Ů");  
        combo.setText(items[i].getText(1));  
        editor1.grabHorizontal = true;  
        editor1.setEditor(combo, items[i], 1);  
        combo.addModifyListener( new ModifyListener(){  
         public void modifyText(ModifyEvent e) {  
          editor1.getItem().setText(1,combo.getText());  
         }  
          
        });  
         
        // ����TableItem���Control�Ķ�Ӧ��ϵ��ɾ��TableItemʱʹ��  
        TableItemControls cons = new TableItemControls(text, combo, editor, editor1);  
        tablecontrols.put(items[i], cons);  
         
       }    
       // *****************************************************/  
            // /***************************************************  
       //����TableCursor����ʹ���������Ҽ����Կ��Ʊ��  
       final TableCursor cursor = new TableCursor(table, SWT.NONE);  
       //�����ɱ༭�Ŀؼ�  
       final ControlEditor editor = new ControlEditor(cursor);  
       editor.grabHorizontal = true;  
       editor.grabVertical = true;  
       //ΪTableCursor����ע���¼�  
       cursor.addSelectionListener( new SelectionAdapter() {  
        //���ƶ���꣬�ڵ�Ԫ���ϵ����س����������¼�  
        public void widgetDefaultSelected(SelectionEvent e) {  
         //����һ���ı���ؼ�  
         final Text text = new Text(cursor, SWT.NONE);  
         //��õ�ǰ������ڵ���TableItem����  
         TableItem row = cursor.getRow();  
         //��õ�ǰ������ڵ�����  
         int column = cursor.getColumn();  
         //��ǰ������ڵ�Ԫ���ֵ�����ı���  
         text.setText(row.getText(column));  
         //Ϊ�ı���ע������¼�  
         text.addKeyListener(new KeyAdapter() {  
          public void keyPressed(KeyEvent e) {  
           //��ʱ���ı����ϵ����س������Ǳ���е�����Ϊ�޸ĺ��ı����е�����  
           //Ȼ���ͷ��ı�����Դ  
           if (e.character == SWT.CR) {  
            TableItem row = cursor.getRow();  
            int column = cursor.getColumn();  
            row.setText(column, text.getText());  
            text.dispose();  
           }  
           //������ı����е�����ESC�����򲢲��Ա���е����ݽ����޸�  
           if (e.character == SWT.ESC) {  
            text.dispose();  
           }  
          }  
         });  
         //ע�ό���¼�  
         text.addFocusListener(new FocusAdapter() {  
          //�����ı���ʧȥ����ʱ���ͷ��ı�����Դ  
          public void focusLost(FocusEvent e) {  
           text.dispose();  
          }  
         });  
         //�����ı���󶨵��ɱ༭�Ŀؼ���  
         editor.setEditor(text);  
         //�����ı���Ľ���  
         text.setFocus();  
        }  
        //�ƶ���굽һ����Ԫ�������������¼�  
        public void widgetSelected(SelectionEvent e) {  
         table.setSelection(new TableItem[] { cursor.getRow()});  
        }  
       });  
       cursor.addMouseListener(new MouseListener() {  
 
        @Override 
        public void mouseDoubleClick(MouseEvent e) {  
         // TODO Auto-generated method stub  
          
        }  
 
        @Override 
        public void mouseDown(MouseEvent e) {  
         if (e.button==3) { // �Ҽ����£���ʾ�Ҽ��˵�  
          menu.setVisible(true);  
         }  
        }  
 
        @Override 
        public void mouseUp(MouseEvent e) {  
         // TODO Auto-generated method stub  
          
        }  
         
       });  
       // ******************************************************/  
       //���²��ֱ��  
       for (int i=0; i<tableHeader.length; i++) {  
        table.getColumn (i).pack ();  
       }  
       // /****************************************************  
       //Ϊ��Ԫ��ע��ѡ���¼�  
       table.addSelectionListener( new SelectionAdapter(){  
        public void widgetSelected(SelectionEvent e) {  
         //������е�����  
         int total = table.getItemCount();  
         //ѭ��������  
         for ( int i=0;i<total;i++){  
          TableItem item = table.getItem(i);  
          //�������Ϊѡ��״̬���ı䱳��ɫ��ǰ��ɫ��������ɫ����  
          if (table.isSelected( i )){   
           item.setBackground( sShell.getDisplay().getSystemColor( SWT.COLOR_RED));  
           item.setForeground( sShell.getDisplay().getSystemColor( SWT.COLOR_WHITE));  
          }else {  
           item.setBackground( null );  
           item.setForeground( null );  
          }  
         }  
        }  
         
       });  
       // ******************************************************/  
    }  
 
    public static void main(String[] args) {  
       //����������  
       Display display = Display.getDefault();  
       TableSample thisClass = new TableSample();  
       thisClass.createSShell();  
       thisClass.sShell.open();  
       while (!thisClass.sShell.isDisposed()) {  
        if (!display.readAndDispatch())  
         display.sleep();  
       }  
//     ImageFactory.dispose();  
       display.dispose();  
    }  
 
    //����������  
    private void createSShell() {  
       sShell = new Shell();  
       sShell.setText("��񴰿�");  
       sShell.setLayout(new FillLayout());  
       createViewForm();  
       createMenu();  
//     sShell.setImage( ImageFactory.loadImage( sShell.getDisplay(), ImageFactory.SAMPLES));  
       sShell.setSize(new org.eclipse.swt.graphics.Point(307,218));  
       sShell.pack();  
    }  
    //���������Ĳ˵�  
    private void createMenu() {  
       //��������ʽ�˵�  
       menu = new Menu (sShell, SWT.POP_UP);  
       //���øò˵�Ϊ���˵�  
       table.setMenu (menu);  
       //����ɾ���˵���  
       MenuItem del = new MenuItem (menu, SWT.PUSH);  
       del.setText ("ɾ��");  
//     del.setImage( ImageFactory.loadImage( sShell.getDisplay(), ImageFactory.DELETE_EDIT));  
       //Ϊɾ���˵�ע���¼���������ʱ��ɾ����ѡ�����  
       del.addListener (SWT.Selection, new Listener () {  
        public void handleEvent (Event event) {  
         // �˴������ɾ����Control�Ĵ���  
         table.remove (table.getSelectionIndices ());  
        }  
       });  
       //�����鿴�˵���  
       MenuItem view = new MenuItem (menu, SWT.PUSH);  
       view.setText ("�鿴");  
//     view.setImage( ImageFactory.loadImage( sShell.getDisplay(), ImageFactory.SCOPY_EDIT));  
       //Ϊ�鿴�˵���ע���¼���������ʱ��ӡ����ѡ������  
       view.addListener (SWT.Selection, new Listener () {  
        public void handleEvent (Event event) {  
         TableItem[] items = table.getSelection();  
         for (int i=0;i<items.length;i++)  
          System.out.print(items[i].getText());  
        }  
       });  
        
       table.setMenu(menu);  
    }  
 
    }  