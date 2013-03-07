import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;


/*
public class ChatController {

	private ChatLogic logic;
	private TCPChatSwtGui gui;
	private Shell xp;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private String t="";
	private String uname="";
	private boolean pruefe= false;
	private List list;
	
	public ChatController(){
		this.logic = new ChatLogic(null);
		this.gui = new TCPChatSwtGui();
		
		addListener();
	}
	
	public void showView() {
		// TODO Auto-generated method stub
		//ChatLogic c = new ChatLogic("Patrick");
		TCPChatSwtGui b = new TCPChatSwtGui();
	}
	
	private void addListener() {
		// TODO Auto-generated method stub
		this.gui.setSendButtonListener(new SendButtonListener());
		this.gui.setLogoutButtonListener(new LogoutButtonListener());
		this.gui.setLoginButtonListener(new LoginButtonListener());
		this.gui.setText_1EnterListener(new Text_1EnterListener());
		this.gui.setBlackRadioListener(new BlackRadioListener());
		this.gui.setBlueRadioListener(new BlueRadioListener());
		this.gui.setPurpleRadioListener(new PurpleRadioListener());
		this.gui.setRedRadioListener(new RedRadioListener());
		this.gui.setYellowRadioListener(new YellowRadioListener());
		
	}


	class LoginButtonListener implements SelectionListener{
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
	};
	
	class LogoutButtonListener implements SelectionListener{
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
	};
	
	class SendButtonListener implements SelectionListener{
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
	};
	
	class Text_1EnterListener implements Listener{
		public void handleEvent (Event e) {
			t=t+uname+": "+text_1.getText()+"\n";
			text_3.setText(t);
			text_1.setText("");

		}
	};		
	
	class BlackRadioListener implements SelectionListener{
		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			// TODO Auto-generated method stub	
		}
		@Override
		public void widgetSelected(SelectionEvent e) {
			// TODO Auto-generated method stub
			text_1.setForeground(SWTResourceManager.getColor(0, 0, 0));
			//text_3.setForeground(SWTResourceManager.getColor(0, 0, 0));         dass is für die ausgabe, geht aber nich, schaus dir an was da passiert

		}


	};
	
	class BlueRadioListener implements SelectionListener{
		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			// TODO Auto-generated method stub	
		}
		@Override
		public void widgetSelected(SelectionEvent e) {
			// TODO Auto-generated method stub
			text_1.setForeground(SWTResourceManager.getColor(0, 0, 255));
			//text_3.setForeground(SWTResourceManager.getColor(0, 0, 255));         dass is für die ausgabe, geht aber nich, schaus dir an was da passiert

		}


	};
	
	class PurpleRadioListener implements SelectionListener{
		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			// TODO Auto-generated method stub	
		}
		@Override
		public void widgetSelected(SelectionEvent e) {
			// TODO Auto-generated method stub
			text_1.setForeground(SWTResourceManager.getColor(191, 0, 255));
			//text_3.setForeground(SWTResourceManager.getColor(191, 0, 255));         dass is für die ausgabe, geht aber nich, schaus dir an was da passiert

		}


	};
	
	class RedRadioListener implements SelectionListener{
		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			// TODO Auto-generated method stub	
		}
		@Override
		public void widgetSelected(SelectionEvent e) {
			// TODO Auto-generated method stub
			text_1.setForeground(SWTResourceManager.getColor(255, 0, 0));
			//text_3.setForeground(SWTResourceManager.getColor(255, 0, 0));         dass is für die ausgabe, geht aber nich, schaus dir an was da passiert

		}


	};
	
	class YellowRadioListener implements SelectionListener{
		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			// TODO Auto-generated method stub	
		}
		@Override
		public void widgetSelected(SelectionEvent e) {
			// TODO Auto-generated method stub
			text_1.setForeground(SWTResourceManager.getColor(255, 255, 0));
			//text_3.setForeground(SWTResourceManager.getColor(255, 255, 0));         dass is für die ausgabe, geht aber nich, schaus dir an was da passiert

		}


	};


}
*/
