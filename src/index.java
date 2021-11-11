import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

public class index {
	public static admindashboard dashboard;
	public static login Login;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		

	    UIManager.setLookAndFeel( new FlatDarkLaf() );
		Login = new login();
		dashboard = new admindashboard();
	}
}
