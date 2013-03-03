import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Text;
import swing2swt.layout.BorderLayout;
import swing2swt.layout.FlowLayout;
import swing2swt.layout.BoxLayout;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Spinner;

public class TCPChatSwtGui {
	private Shell xp;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private String t=""+"\n";
	private String uname="";
	public TCPChatSwtGui() {
		Display dis = new Display();
		xp = new Shell(dis);		
		
		
		final List list = new List(xp, SWT.BORDER);
		list.setBounds(340, 59, 94, 282);
		
		text_1 = new Text(xp, SWT.BORDER);
		text_1.setBounds(10, 348, 312, 58);
		
		Button btnSenden = new Button(xp, SWT.NONE);
		btnSenden.setBounds(359, 381, 75, 25);
		btnSenden.setText("Senden");
		btnSenden.addSelectionListener(new SelectionListener() {
			
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		    public void widgetSelected(SelectionEvent e) {
		    	
		        //System.out.println("Button pushed.");
		    	t=t+text_1.getText()+"\n";
		    	text_3.setText(t);
		    	text_1.setText("");
		      }
		   });
		
		Button btnLogin = new Button(xp, SWT.NONE);
		btnLogin.setBounds(10, 10, 75, 25);
		btnLogin.setText("LogIN");
		btnLogin.addSelectionListener(new SelectionListener(){
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub	
			}
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				uname= text_2.getText();
				list.add(uname);
				
				
			}
			
			
		});
		
		text_2 = new Text(xp, SWT.BORDER);
		text_2.setBounds(103, 10, 118, 25);
		
		text_3 = new Text(xp, SWT.BORDER);
		text_3.setEditable(false);
		text_3.setBounds(10, 59, 312, 282);
		
		xp.open();
		while (!xp.isDisposed()) {
			   if (!dis.readAndDispatch()) {
			    dis.sleep();
			   }
		}
	}
	
}