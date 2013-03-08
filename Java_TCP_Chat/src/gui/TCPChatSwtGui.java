package gui;

import logic.ChatLogic;

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
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.TextLayout;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.wb.swt.SWTResourceManager;
//import org.eclipse.wb.swt.SWTResourceManager;

public class TCPChatSwtGui {
	private Shell xp;
	private Display dis;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private String t="";
	private String uname="";
	private List list;
	private boolean pruefe= false;
	private Button btnSenden;
	private ChatLogic cl;

	public void setText_3(String msg){
		this.text_3.append(msg);
	}
	public TCPChatSwtGui(ChatLogic e) {
		dis = new Display();
		xp = new Shell(dis);		
		this.cl=e;
	}
	public void openGui(){
		createComponents();
		xp.pack();
		xp.open();
		xp.layout();
		while (!xp.isDisposed()) {
			if (!dis.readAndDispatch()) {
				dis.sleep();		}
		}
		//dis.dispose();
	}
	
	protected void createComponents(){
		xp= new Shell();
		xp.setSize(458, 505);
		xp.setText("Multicast Chat");
		
		list = new List(xp, SWT.BORDER);
		list.setBounds(340, 59, 94, 282);

		text_1 = new Text(xp, SWT.BORDER);
		text_1.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.NORMAL));
		text_1.setForeground(SWTResourceManager.getColor(0, 0, 0));
		text_1.setBounds(10, 348, 312, 58);
		text_1.addListener(SWT.DefaultSelection,  new Listener (){
			public void handleEvent (Event e) {
				String message= text_1.getText();
				
				text_3.append(cl.sendMessage(message));
				text_1.setText("");

			}
		});



		btnSenden = new Button(xp, SWT.NONE);
		btnSenden.setBounds(340, 347, 75, 25);
		btnSenden.setText("Senden");
		btnSenden.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
			@Override
			public void widgetSelected(SelectionEvent e) {
				String message= text_1.getText();
				text_3.append(cl.sendMessage(message));
				//System.out.println("Button pushed.");
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
					cl.setUsername(uname);
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
		btnLogOUT.setEnabled(true);
		btnLogOUT.setBounds(10, 10, 75, 25);
		btnLogOUT.setText("LogOUt");
		try{
			btnLogOUT.addSelectionListener(new SelectionListener(){
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					// TODO Auto-generated method stub	
				}
				@Override
				public void widgetSelected(SelectionEvent e) {
					// TODO Auto-generated method stub
					//uname= text_2.getText();

					//if(pruefe==true){							damit kann ich den buton disablen nachdem er einmal ausgelogt hat, aber dafür nichmehr availablen
					uname= list.getItem(0);
					list.remove(uname);
					//pruefe=false;							und der button muss final gemacht werden damit er hier aufgerufen werden kann

					//}else{
					//	System.out.println("Sie sind bereits ausgelogt!");
					//	btnLogOUT.setEnabled(false);
					//}
				}


			});

		}catch(Exception g){
			text_2.setText("Abmelden nicht Möglich");
		}
		xt("LogOUt");

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
				text_3.setForeground(SWTResourceManager.getColor(0, 0, 0));        // dass is für die ausgabe, geht aber nich, schaus dir an was da passiert

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
				text_3.setForeground(SWTResourceManager.getColor(0, 0, 255));        // dass is für die ausgabe, geht aber nich, schaus dir an was da passiert

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
				text_3.setForeground(SWTResourceManager.getColor(191, 0, 255));         //dass is für die ausgabe, geht aber nich, schaus dir an was da passiert

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
				text_3.setForeground(SWTResourceManager.getColor(255, 0, 0));        // dass is für die ausgabe, geht aber nich, schaus dir an was da passiert

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
				text_3.setForeground(SWTResourceManager.getColor(255 , 255, 0));      //   dass is für die ausgabe, geht aber nich, schaus dir an was da passiert

			}


		});


		xt("LogOUt");
	}
	public Button getBtnSenden() {
		return btnSenden;
	}
	private void xt(String string) {
		// TODO Auto-generated method stub

	}
	public void update(final String message){
		dis.asyncExec(new Runnable() {
			@Override
			public void run() {
				if (!text_3.isDisposed()) {
					text_3.append(message+"\n");


				}
			}
		});
	}


}