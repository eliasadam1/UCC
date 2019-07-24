import javax.swing.border.EmptyBorder;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;
	private static Connection conn = null;
	private Statement s = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String user = "eliasadam60"; // User megadása
	private String pswd = "Almafa2a"; // Jelszó megadása
	private TM tm;

	private static String mes = "Program üzenete:";

	public Login() {
		setTitle("Felhaszn\u00E1l\u00F3 kezel\u0151 program");

		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\\u00C1d\u00E1m\\Desktop\\ucc\\regicon.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 287);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Object Mezonevekt[] = { "Jel", "Felh", "Jelszó", "Típus", "Név", "E-mail", "Neme", "Szül.datum", "Ország" };
		tm = new TM(Mezonevekt, 0);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(10, 11, 278, 145);
		contentPane.add(panel);
		panel.setLayout(null);

		password = new JPasswordField();
		password.setBounds(124, 92, 137, 20);
		panel.add(password);
		password.setFont(new Font("Arial", Font.BOLD, 16));
		password.setColumns(10);
		((JPasswordField) password).setEchoChar('*');

		username = new JTextField();
		username.setBounds(124, 61, 137, 20);
		panel.add(username);
		username.setFont(new Font("Arial", Font.PLAIN, 12));
		username.setColumns(10);

		JLabel lblFelhasznlnv = new JLabel("Felhaszn\u00E1l\u00F3n\u00E9v:");
		lblFelhasznlnv.setBounds(6, 61, 108, 20);
		panel.add(lblFelhasznlnv);
		lblFelhasznlnv.setFont(new Font("Yu Gothic", Font.BOLD, 13));

		JLabel lblJelsz = new JLabel("Jelsz\u00F3:");
		lblJelsz.setBounds(66, 92, 90, 20);
		panel.add(lblJelsz);
		lblJelsz.setFont(new Font("Yu Gothic", Font.BOLD, 13));

		JLabel lblrjaBeA = new JLabel("\u00CDrja be a felhaszn\u00E1l\u00F3nev\u00E9t \u00E9s jelszav\u00E1t.");
		lblrjaBeA.setFont(new Font("Arial", Font.PLAIN, 14));
		lblrjaBeA.setBounds(10, 28, 259, 14);
		panel.add(lblrjaBeA);

		JLabel lblLps = new JLabel("1. l\u00E9p\u00E9s");
		lblLps.setFont(new Font("Arial", Font.PLAIN, 14));
		lblLps.setBounds(6, 11, 259, 14);
		panel.add(lblLps);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(176, 196, 222));
		panel_1.setBounds(294, 11, 151, 226);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblLps_1 = new JLabel("2. l\u00E9p\u00E9s");
		lblLps_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblLps_1.setBounds(10, 11, 259, 14);
		panel_1.add(lblLps_1);

		JLabel lblVlasszonAMenbl = new JLabel("V\u00E1lasszon a men\u00FCb\u0151l.");
		lblVlasszonAMenbl.setFont(new Font("Arial", Font.PLAIN, 14));
		lblVlasszonAMenbl.setBounds(8, 31, 259, 14);
		panel_1.add(lblVlasszonAMenbl);

		JButton btLogin = new JButton("Lista");
		btLogin.setBackground(UIManager.getColor("Button.background"));
		btLogin.setBounds(10, 61, 114, 23);
		panel_1.add(btLogin);
		btLogin.setFont(new Font("Arial", Font.PLAIN, 12));

		JButton btKerFelh = new JButton("Keres\u00E9s");
		btKerFelh.setBackground(UIManager.getColor("Button.background"));
		btKerFelh.setBounds(10, 95, 114, 23);
		panel_1.add(btKerFelh);
		btKerFelh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(btKerFelh)) {
					String sql = "select * from users where username=? and passw=?";
					try {
						Kapcs(user, pswd);
						ps = conn.prepareStatement(sql);
						ps.setString(1, username.getText());
						ps.setString(2, password.getText());
						rs = ps.executeQuery();
						if (rs.next()) {
							new Kereses().setVisible(true);
						} else {
							Control.showMD("Felhasználónév/jelszó nem egyezik vagy üres a mezõ!", 2);
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
					Lekapcs();
				}
			}
		});
		btKerFelh.setFont(new Font("Arial", Font.PLAIN, 12));

		JButton btMod = new JButton("M\u00F3dos\u00EDt\u00E1s");
		btMod.setBackground(UIManager.getColor("Button.background"));
		btMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (e.getSource().equals(btMod)) {
					String sql = "select * from users where username=? and passw=? and type='admin'";
					try {
						Kapcs(user, pswd);
						ps = conn.prepareStatement(sql);
						ps.setString(1, username.getText());
						ps.setString(2, password.getText());
						rs = ps.executeQuery();
						if (rs.next()) {
							Mod fr = new Mod();
							fr.connection();
							JDialog frm = new JDialog();
							frm.setContentPane(fr);
							frm.setSize(480, 480);
							frm.setVisible(true);
							frm.setResizable(false);
							frm.setTitle("Felhasználók módosítása");
							frm.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\\u00C1d\u00E1m\\Desktop\\ucc\\regicon.png"));
						} else {
							Control.showMD("Felhasználónév/jelszó nem egyezik vagy nem Admin fiók lép be!", 2);
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
						EmailSender.EmailSend();
					}
					Lekapcs();
				}
			}
		});
		btMod.setFont(new Font("Arial", Font.PLAIN, 12));
		btMod.setBounds(10, 129, 114, 23);
		panel_1.add(btMod);

		JButton btExport = new JButton("Export\u00E1l\u00E1s");
		btExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(btExport)) {
					String sql = "select * from users where username=? and passw=? and type='admin'";
					try {
						Kapcs(user, pswd);
						ps = conn.prepareStatement(sql);
						ps.setString(1, username.getText());
						ps.setString(2, password.getText());
						rs = ps.executeQuery();
						if (rs.next()) {
							JDialog frame = new JDialog();
							Export panel = new Export();
							frame.getContentPane().add(panel, "Center");
							frame.setSize(panel.getPreferredSize());
							frame.setVisible(true);
							frame.setTitle("Felhasználók exportálása");
							frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\\u00C1d\u00E1m\\Desktop\\ucc\\regicon.png"));
							
						} else {
							Control.showMD("Felhasználónév/jelszó nem egyezik vagy nem Admin fiók lép be!", 2);
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
						EmailSender.EmailSend();
					}
					Lekapcs();
				}
			}
		});
		btExport.setFont(new Font("Arial", Font.PLAIN, 12));
		btExport.setBackground(SystemColor.menu);
		btExport.setBounds(10, 163, 114, 23);
		panel_1.add(btExport);

		JButton btnKilps = new JButton("Kil\u00E9p\u00E9s");
		btnKilps.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnKilps.setFont(new Font("Arial", Font.PLAIN, 12));
		btnKilps.setBackground(SystemColor.menu);
		btnKilps.setBounds(10, 197, 114, 23);
		panel_1.add(btnKilps);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(176, 196, 222));
		panel_2.setBounds(10, 167, 278, 70);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JButton btReg = new JButton("Regisztr\u00E1ci\u00F3");
		btReg.setBackground(UIManager.getColor("Button.background"));
		btReg.setBounds(10, 36, 114, 23);
		panel_2.add(btReg);
		btReg.setFont(new Font("Arial", Font.PLAIN, 12));

		JLabel lblHaNincsMg = new JLabel("Ha nincs m\u00E9g fi\u00F3kja regiszt\u00E1ljon.");
		lblHaNincsMg.setBounds(10, 11, 259, 23);
		panel_2.add(lblHaNincsMg);
		lblHaNincsMg.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton btnSg = new JButton("S\u00FAg\u00F3");
		btnSg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sugo ks = new Sugo(Login.this);
				ks.setVisible(true);
			}
		});
		btnSg.setBounds(179, 36, 90, 23);
		panel_2.add(btnSg);
		btnSg.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSg.setBackground(SystemColor.menu);
		btReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(btReg)) {
					Beszur();
				}
			}
		});
		btLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "select * from users where username=? and passw=?";
				try {
					Kapcs(user, pswd);
					ps = conn.prepareStatement(sql);
					ps.setString(1, username.getText());
					ps.setString(2, password.getText());
					rs = ps.executeQuery();
					if (rs.next()) {
						Lista();
					} else {
						Control.showMD("Felhasználónév/jelszó nem egyezik vagy üres a mezõ!", 2);
					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
					EmailSender.EmailSend();
				}
				Lekapcs();
			}
		});
		Object[] emptmn = { "Felh.", "Jelszó", "Típus", "Név", "E-mail", "Neme", "Szül.idõ", "Ország" };
		tm = new TM(emptmn, 0);
	}

	public static void main(String[] args) {
		Login frame = new Login();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Kereses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Kereses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Kereses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Kereses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
	}

	public void Beszur() {
		Point bs = getLocation();
		int bsx = (int) bs.getX();
		int bsy = (int) bs.getY();
		Reg us = new Reg(null, bsx, bsy);
		us.setVisible(true);
		if (us.kiLep() == 2) {
			try {
				String sqlp = "insert into users (username, passw, type, name, email, sex, dateofbirth, country) values (?, ?, ?, ?, ?, ?, ?, ?)";
				Kapcs(user, pswd);
				ps = conn.prepareStatement(sqlp);
				ps.setString(1, us.getUsername());
				ps.setString(2, us.getPassword());
				ps.setString(3, us.getTipus());
				ps.setString(4, us.getName());
				ps.setString(5, us.getEmail());
				ps.setString(6, us.getSex());
				
				ps.setString(7, us.getDateofbirth());
				ps.setString(8, us.getCountry());
				ps.executeUpdate();
				ps.close();
				Lekapcs();
				JOptionPane.showMessageDialog(null, "Regisztráció sikeres!", mes, 2);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "SQL hiba: " + ex.getMessage(), mes, 2);
			}
		}
	}
	
	public void Kapcs(String user, String pswd) { // ----------------------------------Kapcsolódás
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://db4free.net/uccusers";
			conn = DriverManager.getConnection(url, user, pswd);
			System.out.print("Kapcsolódva az adatbázishoz!");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Kapcsolódási hiba: " + ex.getMessage(), mes, 2);
		}
	}

	public  void Lekapcs() { // ----------------------------------Lekapcsolódás
		try {
			conn.close();
			System.out.println("Sikeres lekapcsolodas");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Kapcsolat lezárási hiba: " + ex.getMessage(), mes, 2);
		}
	}

	public void Lista() {
		Object Mezonevekp[] = { "Felh.", "Jelszó", "Típus", "Név", "E-mail", "Neme", "Szül.idõ", "Ország" };
		tm = new TM(Mezonevekp, 0);
		Kapcs(user, pswd);
		if (tm.getRowCount() > 0)
			for (int i = 0; i < tm.getRowCount(); i++) {
				tm.removeRow(i);
				i--;
			}
		FelhLista();
		Lekapcs();
		Point bs = getLocation();
		int bsx = (int) bs.getX();
		int bsy = (int) bs.getY();
		Kiir ak = new Kiir(null, tm, bsx, bsy);
		ak.setVisible(true);
	}

	public void FelhLista() { // ----------------------------------User adatainak beolvasása
		String felh = "", pw = "", tip = "", nev = "", mail = "", nem = "", szuldat = "", orszag = "";
		String sqlp = "select * from users";
		try {
			s = conn.createStatement();
			s.executeQuery(sqlp);
			rs = s.getResultSet();
			while (rs.next()) {
				felh = rs.getString("username").trim();
				pw = rs.getString("passw").trim();
				tip = rs.getString("type").trim();
				nev = rs.getString("name").trim();
				mail = rs.getString("email").trim();
				nem = rs.getString("sex").trim();
				szuldat = rs.getString("dateofbirth").trim();
				orszag = rs.getString("country").trim();
				tm.addRow(new Object[] { felh, pw, tip, nev, mail, nem, szuldat, orszag });
			}
			rs.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Nem sikerült betölteni az adatokat!" + e.getMessage(), mes, 2);
		}
	}
}
