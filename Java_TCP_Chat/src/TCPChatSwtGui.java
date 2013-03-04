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
import org.eclipse.swt.events.SelectionAdapter;

/**
 * Klasse welche die GUI implementiert
 * @author Stefan Pitirut, Patrick Muehl
 *
 */

import org.eclipse.swt.events.SelectionAdapter;


public class TCPChatSwtGui {
	private Shell xp;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
<<<<<<< HEAD

	private String t="";



=======
	private String t=""+"\n";
>>>>>>> 579be463d061d326c3fc6855da0e9a027735a767
	private String uname="";
	public TCPChatSwtGui() {
		Display dis = new Display();
		xp = new Shell(dis);		
		xp.setSize(458, 505);
		
		
		final List list = new List(xp, SWT.BORDER);
		list.setBounds(340, 59, 94, 282);
		
		text_1 = new Text(xp, SWT.BORDER);
		text_1.setBounds(10, 348, 312, 58);
		
<<<<<<< HEAD
		Button btnSenden = new Button(xp, SWT.NONE);
=======
		final Button btnSenden = new Button(xp, SWT.NONE);
>>>>>>> 579be463d061d326c3fc6855da0e9a027735a767
		btnSenden.setBounds(340, 347, 75, 25);
		btnSenden.setText("Senden");
		btnSenden.addSelectionListener(new SelectionListener() {
			
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		    public void widgetSelected(SelectionEvent e) {
		    	
		        //System.out.println("Button pushed.");
		    	t=t+text_1.getText()+"\n";
<<<<<<< HEAD
		    	text_3.setText(t);
=======
		    	text_3.setText(uname + ": " +t);
>>>>>>> 579be463d061d326c3fc6855da0e9a027735a767
		    	text_1.setText("");
		      }
		   });
		
		Button btnLogin = new Button(xp, SWT.NONE);
		btnLogin.setBounds(357, 10, 75, 25);
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
<<<<<<< HEAD
				
				
=======
						
>>>>>>> 579be463d061d326c3fc6855da0e9a027735a767
			}
			
			
		});
		
		text_2 = new Text(xp, SWT.BORDER);
		text_2.setBounds(216, 12, 118, 25);
		
		text_3 = new Text(xp, SWT.BORDER);
		text_3.setEditable(false);
		text_3.setBounds(10, 59, 312, 282);
		
		Button btnLogOUT = new Button(xp, SWT.NONE);
		btnLogOUT.setBounds(10, 10, 75, 25);
		btnLogOUT.setText("LogOUt");
		btnLogOUT.addSelectionListener(new SelectionListener(){
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub	
			}
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				uname= text_2.getText();
				list.remove(uname);
				
				
			}
			
			
		});
		
		xp.open();
		while (!xp.isDisposed()) {
			   if (!dis.readAndDispatch()) {
			    dis.sleep();
			}
		}
	}
	
}