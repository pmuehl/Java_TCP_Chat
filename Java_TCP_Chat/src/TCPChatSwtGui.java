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
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.wb.swt.SWTResourceManager;

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
		text_1.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		text_1.setForeground(SWTResourceManager.getColor(0, 0, 0));
		text_1.setBounds(10, 348, 312, 58);
		text_1.addListener(SWT.DefaultSelection,  new Listener (){
			public void handleEvent (Event e) {
				t=t+uname+": "+text_1.getText()+"\n";
				text_3.setText(t);
				text_1.setText("");
			}
		});

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

		text_2 = new Text(xp, SWT.BORDER );
		text_2.setBounds(216, 12, 118, 25);

		final Text text_3 = new Text(xp,SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		text_3.setEditable(false);
		text_3.setBounds(10, 59, 312, 282);
		
		Button btnLogOUT = new Button(xp, SWT.NONE);
		btnLogOUT.setEnabled(true);
		btnLogOUT.setBounds(10, 10, 75, 25);
		btnLogOUT.setText("LogOUt");
		
		Menu menu = new Menu(xp, SWT.BAR);
		xp.setMenuBar(menu);
		
		MenuItem mntmConnect = new MenuItem(menu, SWT.CASCADE);
		mntmConnect.setText("Connect as");
		
		Menu menu_1 = new Menu(mntmConnect);
		mntmConnect.setMenu(menu_1);
		
		MenuItem mntmHost = new MenuItem(menu_1, SWT.NONE);
		mntmHost.setText("Host");
		
		MenuItem mntmUser = new MenuItem(menu_1, SWT.NONE);
		mntmUser.setText("User");
		
		MenuItem mntmFarbe = new MenuItem(menu, SWT.CASCADE);
		mntmFarbe.setText("Chat colour");
		
		Menu menu_2 = new Menu(mntmFarbe);
		mntmFarbe.setMenu(menu_2);
		
		MenuItem mntmBlack = new MenuItem(menu_2, SWT.RADIO);
		mntmBlack.setText("Black");
		mntmBlack.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub	
			}
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				text_1.setForeground(SWTResourceManager.getColor(0, 0, 0));
				//text_3.setForeground(SWTResourceManager.getColor(0, 0, 0));         dass is f�r die ausgabe, geht aber nich, schaus dir an was da passiert

			}


		});
		
		MenuItem mntmBlue = new MenuItem(menu_2, SWT.RADIO);
		mntmBlue.setText("Blue");
		mntmBlue.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub	
			}
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				text_1.setForeground(SWTResourceManager.getColor(0, 0, 255));
				//text_3.setForeground(SWTResourceManager.getColor(0, 0, 255));         dass is f�r die ausgabe, geht aber nich, schaus dir an was da passiert

			}


		});
		MenuItem mntmPurple = new MenuItem(menu_2, SWT.RADIO);
		mntmPurple.setText("Purple");
		mntmPurple.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub	
			}
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				text_1.setForeground(SWTResourceManager.getColor(191, 0, 255));
				//text_3.setForeground(SWTResourceManager.getColor(191, 0, 255));         dass is f�r die ausgabe, geht aber nich, schaus dir an was da passiert

			}


		});
		
		MenuItem mntmRed = new MenuItem(menu_2, SWT.RADIO);
		mntmRed.setText("Red");
		mntmRed.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub	
			}
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				text_1.setForeground(SWTResourceManager.getColor(255, 0, 0));
				//text_3.setForeground(SWTResourceManager.getColor(255, 0, 0));         dass is f�r die ausgabe, geht aber nich, schaus dir an was da passiert

			}


		});
		
		MenuItem mntmYellow = new MenuItem(menu_2, SWT.RADIO);
		mntmYellow.setText("Yellow");
		mntmYellow.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub	
			}
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				text_1.setForeground(SWTResourceManager.getColor(255, 255, 0));
				//text_3.setForeground(SWTResourceManager.getColor(255 , 255, 0));         dass is f�r die ausgabe, geht aber nich, schaus dir an was da passiert

			}


		});
		
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
				
				//if(pruefe==true){							damit kann ich den buton disablen nachdem er einmal ausgelogt hat, aber daf�r nichmehr availablen
					uname= list.getItem(0);
					list.remove(uname);
					//pruefe=false;							und der button muss final gemacht werden damit er hier aufgerufen werden kann

				//}else{
				//	System.out.println("Sie sind bereits ausgelogt!");
				//	btnLogOUT.setEnabled(false);
				//}
			}


		});
		
		    
		xp.open();
		while (!xp.isDisposed()) {
			if (!dis.readAndDispatch()) {
				dis.sleep();		}
		}
		dis.dispose();
	}
	private void xt(String string) {
		// TODO Auto-generated method stub

	}
}