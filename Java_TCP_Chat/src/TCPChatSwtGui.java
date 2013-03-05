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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.CCombo;

public class TCPChatSwtGui {
	private Shell xp;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private String t="";
	private String uname="";
	private boolean pruefe= false;
	public TCPChatSwtGui() {
		Display dis = new Display();
		xp = new Shell(dis);		
		xp.setSize(458, 505);


		final List list = new List(xp, SWT.BORDER);
		list.setBounds(340, 59, 94, 282);

		text_1 = new Text(xp, SWT.BORDER);
		text_1.setBounds(10, 348, 312, 58);

		Button btnSenden = new Button(xp, SWT.NONE);
		btnSenden.setBounds(340, 347, 75, 25);
		btnSenden.setText("Senden");
		btnSenden.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
			}
			public void widgetSelected(SelectionEvent e) {

				//System.out.println("Button pushed.");
				t=t+uname+": "+text_1.getText()+"\n";
				text_3.setText(t);
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
				if(pruefe== false){
					uname= text_2.getText();
					list.add(uname);
					
					pruefe=true;
				}else{
					text_2.setText("Bereits angemeldet");
					text_2.setEditable(false);
				}

			}


		});

		text_2 = new Text(xp, SWT.BORDER);
		text_2.setBounds(216, 12, 118, 25);

		text_3 = new Text(xp, SWT.V_SCROLL);
		text_3.setEditable(false);
		text_3.setBounds(10, 59, 312, 282);

		Button btnLogOUT = new Button(xp, SWT.NONE);
		btnLogOUT.setBounds(10, 10, 75, 25);
		btnLogOUT.setText("LogOUt");

		CCombo combo = new CCombo(xp, SWT.BORDER);
		combo.setTouchEnabled(true);
		combo.setToolTipText("Blau\r\nGr\u00FCn\r\nRot");
		combo.setText("Schwarz");
		combo.setBounds(340, 378, 75, 21);
		xt("LogOUt");

		btnLogOUT.addSelectionListener(new SelectionListener(){
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub	
			}
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				//uname= text_2.getText();
				uname= list.getItem(0);
				list.remove(uname);


			}


		});

		xp.open();
		while (!xp.isDisposed()) {
			if (!dis.readAndDispatch()) {
				dis.sleep();		}
		}
	}
	private void xt(String string) {
		// TODO Auto-generated method stub

	}

}