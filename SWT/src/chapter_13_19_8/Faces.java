package chapter_13_19_8;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import chapter_13_19_3.Show;

public class Faces extends Composite{

	Image[] faces = {
		new Image(Display.getCurrent(), "picture/faces/Face0.gif"),
		new Image(Display.getCurrent(), "picture/faces/Face1.gif"),
		new Image(Display.getCurrent(), "picture/faces/Face2.gif"),
		new Image(Display.getCurrent(), "picture/faces/Face3.gif"),
		new Image(Display.getCurrent(), "picture/faces/Face4.gif")
	};
	Image background = faces[3];

	Button jb ;
	Button jb2 ;
	boolean mad ;
	
	public Faces(Composite parent, int style) {
		super(parent, style);
		
		jb = new Button(this, SWT.PUSH);
		jb2 = new Button(this, SWT.PUSH);
		mad = false;
		
		RowLayout layout = new RowLayout();
		layout.justify = true;
		setLayout(layout);
		
		jb.setText("Button");
		jb.setImage(background);
		jb.setToolTipText("Yow!");
		
		jb2.setText("Disable");
		
		jb.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(mad){
					background = faces[3];
					jb.setImage(background);
					mad = false;
				}else{
					background = faces[0];
					jb.setImage(background);
					mad = true;
				}
				jb.setAlignment(SWT.TOP | SWT.LEFT);
			}
		});
		
		jb.addMouseTrackListener(new MouseTrackListener() {
			
			@Override
			public void mouseHover(MouseEvent e) {
				jb.setImage(faces[1]);
			}
			
			@Override
			public void mouseExit(MouseEvent e) {
				jb.setImage(background);
			}
			
			@Override
			public void mouseEnter(MouseEvent e) {
				jb.setImage(faces[1]);
			}
		});
		
		
		jb.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseUp(MouseEvent e) {
				
			}
			
			@Override
			public void mouseDown(MouseEvent e) {
				jb.setImage(faces[2]);
			}
			
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				
			}
		});
		
		jb2.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(jb.isEnabled()){
					jb.setEnabled(false);
					jb.setImage(faces[4]);
					jb2.setText("Enable");
				}else{
					jb.setEnabled(true);
					jb.setImage(background);
					jb2.setText("Disable");
				}
			}
		});
		
	}
	
	public static void main(String[] args) {
		Show.inFrame(new Faces(Show.shell, SWT.NONE), 300, 200);
	}
	
}