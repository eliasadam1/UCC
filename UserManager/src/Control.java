
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Control {
	
	private static Connection conn = null;
	private Statement s = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String user = "root"; // User megadása
	private String pswd = ""; // Jelszó megadása
	private TM tm;
	private TM kertm;
	private String ker = "kod";

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
	private static String mes = "Program üzenet";

	public static String RF(JTextField a) {
		return a.getText().toString();
	}

	public static boolean filled(JTextField a) {
		String s = RF(a);
		if (s.length() > 0)
			return true;
		else
			return false;
	}
	
	public static void DF(JTextField a) {
		a.setText("");
	}

	public static boolean goodDate(JTextField a) {
		String s = RF(a);
		Date testDate = null;
		try {
			testDate = sdf.parse(s);
		} catch (ParseException e) {
			return false;
		}
		if (sdf.format(testDate).equals(s))
			return true;
		else
			return false;
	}

	public static boolean goodInt(JTextField a) {
		String s = RF(a);
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static void showMD(String s, int i) {
		JOptionPane.showMessageDialog(null, s, mes, i);
		//EmailSender.EmailSend();
	}

	public static Date StoD(String s) {
		Date testDate = null, vid = null;
		try {
			testDate = sdf.parse(s);
		} catch (ParseException e) {
			return vid;
		}
		if (!sdf.format(testDate).equals(s)) {
			return vid;
		}
		return testDate;
	}

	public static int StoI(String s) {
		int x = -55;
		x = Integer.parseInt(s);
		return x;
	}

	public static boolean filledF(JTextField a) {
		String s = RF(a);
		return s.length() > 0;
	}

	public static String SDtoS(String date) {
		String ddd = sdf.format(date);
		return ddd;
	}
	
	public static void Kapcs(String user, String pswd) { // ----------------------------------Kapcsolódás
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/users";
			conn = DriverManager.getConnection(url, user, pswd);
			System.out.print("Kapcsolódva az adatbázishoz!");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Kapcsolódási hiba: " + ex.getMessage(), mes, 2);
		}
	}

	public static void Lekapcs() { // ----------------------------------Lekapcsolódás
		try {
			conn.close();
			System.out.println("Sikeres lekapcsolodas");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Kapcsolat lezárási hiba: " + ex.getMessage(), mes, 2);
		}
	}
	

}
