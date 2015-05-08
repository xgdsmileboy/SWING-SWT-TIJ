import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


public class WelcomeDemo {
    public WelcomeDemo() {
    }

    private void initShell(Shell shell) {
       // Ϊshell���ñ���
       shell.setText("WelcomeDemo");
       // Ϊshell���ò��ֶ���
       GridLayout sLayout = new GridLayout();
       shell.setLayout(sLayout);
       // ����һ��Composite�����Ϊ�ı���Ͱ�ť������
       Composite panel = new Composite(shell, SWT.NONE);
       // Ϊpanel���ò��ֽṹ����
       // ��panel�����ܵ�ռ��shell
       GridData pLayoutData = new
           GridData(GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL
              | GridData.FILL_BOTH);
       panel.setLayoutData(pLayoutData);
       // Ϊpanel���ò��ֶ���
       // �ı���Ͱ�ť����������ֶ�����ʾ
       GridLayout pLayout = new GridLayout();
       panel.setLayout(pLayout);

       // Ϊpanel���ñ���ɫ
       final Color pColor = new Color(Display.getCurrent(), 0, 0, 255);
       panel.setBackground(pColor);
       // �����ı���
       final Text text = new Text(panel, SWT.MULTI | SWT.WRAP);
       // Ϊ�ı������ò��ֽṹ����
       // ���ı��򾡿��ܵ�ռ��panel
       GridData tLayoutData = new
           GridData(SWT.FILL, SWT.FILL, true, true);
       text.setLayoutData(tLayoutData);

       // ���찴ť
       Button button = new Button(panel, SWT.PUSH);
       button.setText("ȷ��");
       // Ϊ��ť�������¼�
       button.addMouseListener(new MouseAdapter() {
           public void mouseDown(MouseEvent e) {
              // ���û������ťʱ��ʾ��Ϣ
              text.setText("��ӭ");
           }

       });

       // �������ڹر�ʱ����DisposeListener
       shell.addDisposeListener(new DisposeListener() {
           public void widgetDisposed(DisposeEvent e) {
              // �ͷ�panel����ɫ��Դ
              pColor.dispose();
           }
       });

    }


    public static void main(String args[]) {

       WelcomeDemo demo = new WelcomeDemo();
       Display display = new Display();
       Shell shell = new Shell(display);
       demo.initShell(shell);
       shell.open();
       while (!shell.isDisposed()) {
           if (!display.readAndDispatch()) {
              display.sleep();
           }
       }
       display.dispose();  
    }

}