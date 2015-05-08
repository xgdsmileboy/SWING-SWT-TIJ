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
       // 为shell设置标题
       shell.setText("WelcomeDemo");
       // 为shell设置布局对象
       GridLayout sLayout = new GridLayout();
       shell.setLayout(sLayout);
       // 构造一个Composite组件作为文本框和按钮的容器
       Composite panel = new Composite(shell, SWT.NONE);
       // 为panel设置布局结构对象
       // 让panel尽可能地占满shell
       GridData pLayoutData = new
           GridData(GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL
              | GridData.FILL_BOTH);
       panel.setLayoutData(pLayoutData);
       // 为panel设置布局对象
       // 文本框和按钮将按这个布局对象显示
       GridLayout pLayout = new GridLayout();
       panel.setLayout(pLayout);

       // 为panel设置背景色
       final Color pColor = new Color(Display.getCurrent(), 0, 0, 255);
       panel.setBackground(pColor);
       // 构造文本框
       final Text text = new Text(panel, SWT.MULTI | SWT.WRAP);
       // 为文本框设置布局结构对象
       // 让文本框尽可能地占满panel
       GridData tLayoutData = new
           GridData(SWT.FILL, SWT.FILL, true, true);
       text.setLayoutData(tLayoutData);

       // 构造按钮
       Button button = new Button(panel, SWT.PUSH);
       button.setText("确定");
       // 为按钮添加鼠标事件
       button.addMouseListener(new MouseAdapter() {
           public void mouseDown(MouseEvent e) {
              // 当用户点击按钮时显示信息
              text.setText("欢迎");
           }

       });

       // 当主窗口关闭时触发DisposeListener
       shell.addDisposeListener(new DisposeListener() {
           public void widgetDisposed(DisposeEvent e) {
              // 释放panel背景色资源
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