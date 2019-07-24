import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import javax.swing.event.*;

import org.apache.commons.lang3.RandomStringUtils;
import com.toedter.calendar.JDateChooser;

public class Reg extends JDialog implements ActionListener {
	private JPanel ContentPanel;
	private JButton btMentes;
	private JTextField felh;
	private JTextField jelszo;
	private JTextField tipus;
	private JTextField nev;
	private JTextField mail;
	private JTextField nem;
	private JTextField szulido;
	private JTextField orszag;
	private JDateChooser date;
	

	private int kilep = 0;
	

	public Reg(JDialog f, int bsx, int bsy) {
		super(f, "Regisztráció", true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\\u00C1d\u00E1m\\Desktop\\ucc\\regicon.png"));
		setTitle("Regisztr\u00E1ci\u00F3");
		setBounds(bsx + 25, bsy + 30, 528, 440);
		ContentPanel = new JPanel();
		ContentPanel.setBackground(new Color(230, 230, 250));
		this.getContentPane().add(ContentPanel);
		ContentPanel.setLayout(null);
		felh = new JTextField("", 10);
		felh.setBounds(144, 31, 200, 27);
		felh.setFont(new Font("Arial", Font.PLAIN, 12));
		ContentPanel.add(felh);
		jelszo = new JTextField("", 10);
		jelszo.setBounds(144, 61, 150, 27);
		jelszo.setFont(new Font("Arial", Font.PLAIN, 12));
		ContentPanel.add(jelszo);
		nev = new JTextField("", 10);
		nev.setBounds(144, 126, 200, 27);
		nev.setFont(new Font("Arial", Font.PLAIN, 12));
		ContentPanel.add(nev);

		btMentes = new JButton();
		btMentes.setBounds(252, 369, 120, 23);
		btMentes.setFont(new Font("Arial", Font.PLAIN, 12));
		btMentes.setText("Regisztr\u00E1l\u00E1s");
		ContentPanel.add(btMentes);

		mail = new JTextField("", 10);
		mail.setBounds(144, 157, 200, 27);
		mail.setFont(new Font("Arial", Font.PLAIN, 12));
		ContentPanel.add(mail);

		nem = new JTextField("", 10);
		nem.setBounds(144, 189, 100, 27);
		nem.setFont(new Font("Arial", Font.PLAIN, 12));
		ContentPanel.add(nem);

		szulido = new JTextField("1970.01.01.", 10);
		szulido.setBounds(144, 260, 120, 22);
		szulido.setEnabled(false);
		szulido.setFont(new Font("Arial", Font.PLAIN, 12));
		ContentPanel.add(szulido);

		orszag = new JTextField("Nem adok meg", 10);
		orszag.setBounds(144, 293, 176, 27);
		orszag.setFont(new Font("Arial", Font.PLAIN, 12));
		ContentPanel.add(orszag);

		JLabel label = new JLabel("Felhaszn\u00E1l\u00F3n\u00E9v:*");
		label.setBounds(36, 33, 167, 14);
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("Arial", Font.BOLD, 12));
		ContentPanel.add(label);

		JLabel label_1 = new JLabel("Jelsz\u00F3:*");
		label_1.setBounds(86, 69, 167, 14);
		label_1.setForeground(new Color(0, 0, 0));
		label_1.setFont(new Font("Arial", Font.BOLD, 12));
		ContentPanel.add(label_1);

		JLabel label_2 = new JLabel("Tipus:");
		label_2.setBounds(91, 100, 86, 14);
		label_2.setForeground(new Color(0, 0, 0));
		label_2.setFont(new Font("Arial", Font.BOLD, 12));
		ContentPanel.add(label_2);

		JLabel label_3 = new JLabel("N\u00E9v:*");
		label_3.setBounds(102, 133, 167, 14);
		label_3.setForeground(new Color(0, 0, 0));
		label_3.setFont(new Font("Arial", Font.BOLD, 12));
		ContentPanel.add(label_3);

		JLabel lblEmailCm = new JLabel("E-mail c\u00EDm:*");
		lblEmailCm.setBounds(63, 162, 167, 14);
		lblEmailCm.setForeground(new Color(0, 0, 0));
		lblEmailCm.setFont(new Font("Arial", Font.BOLD, 12));
		ContentPanel.add(lblEmailCm);

		JLabel label_5 = new JLabel("Neme:*");
		label_5.setBounds(88, 195, 105, 14);
		label_5.setForeground(new Color(0, 0, 0));
		label_5.setFont(new Font("Arial", Font.BOLD, 12));
		ContentPanel.add(label_5);

		JLabel label_6 = new JLabel("Sz\u00FClet\u00E9si ideje:");
		label_6.setBounds(42, 265, 167, 14);
		label_6.setForeground(new Color(0, 0, 0));
		label_6.setFont(new Font("Arial", Font.BOLD, 12));
		ContentPanel.add(label_6);

		JLabel label_7 = new JLabel("Orsz\u00E1g:");
		label_7.setBounds(86, 299, 167, 14);
		label_7.setForeground(new Color(0, 0, 0));
		label_7.setFont(new Font("Arial", Font.BOLD, 12));
		ContentPanel.add(label_7);

		JLabel label_8 = new JLabel("A *-al jel\u00F6lt r\u00E9szek k\u00F6t\u00F6lt\u00E9se k\u00F6telez\u0151!");
		label_8.setBounds(8, 365, 241, 22);
		label_8.setFont(new Font("Arial", Font.PLAIN, 14));
		ContentPanel.add(label_8);

		JButton btnMgse = new JButton();
		btnMgse.setBounds(382, 369, 120, 23);
		btnMgse.setFont(new Font("Arial", Font.PLAIN, 12));
		btnMgse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnMgse.setText("M\u00E9gse");
		ContentPanel.add(btnMgse);

		JLabel lblHaFelhasznlHagyja = new JLabel("Ha felhaszn\u00E1l\u00F3 ugorja \u00E1t ezt a mez\u0151t.");
		lblHaFelhasznlHagyja.setBounds(257, 99, 245, 19);
		lblHaFelhasznlHagyja.setFont(new Font("Arial", Font.PLAIN, 14));
		ContentPanel.add(lblHaFelhasznlHagyja);

		JButton dateadd = new JButton();
		dateadd.setBounds(341, 229, 150, 27);
		dateadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DateFormat df = new SimpleDateFormat("yyyy.MM.dd.");
				szulido.setText(df.format(date.getDate()));	
			}
		});
		dateadd.setText("D\u00E1tum \r\nhozz\u00E1ad\u00E1sa");
		dateadd.setFont(new Font("Arial", Font.PLAIN, 12));
		ContentPanel.add(dateadd);
		
		JButton btgen = new JButton();
		btgen.setBounds(352, 61, 139, 25);
		btgen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(btgen)) {
				PwGen();
				}
			}
		});
		btgen.setText("Jelsz\u00F3 gener\u00E1l\u00E1s");
		btgen.setFont(new Font("Arial", Font.PLAIN, 12));
		ContentPanel.add(btgen);
		
		JPanel panel = new JPanel();
		panel.setBounds(8, 91, 494, 33);
		panel.setBackground(new Color(176, 196, 222));
		ContentPanel.add(panel);
		panel.setLayout(null);
		tipus = new JTextField("Felhaszn\u00E1l\u00F3", 10);
		tipus.setBounds(136, 4, 100, 27);
		panel.add(tipus);
		tipus.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(8, 221, 494, 69);
		panel_1.setBackground(new Color(176, 196, 222));
		ContentPanel.add(panel_1);
		panel_1.setLayout(null);
		
				date = new JDateChooser();
				date.setBounds(136, 4, 145, 27);
				panel_1.add(date);
				date.setFont(new Font("Arial", Font.PLAIN, 13));
		btMentes.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) {
		
		if (!Control.filled(felh)) {	
			Control.showMD("Üres a felhasználónév mezõ", 2);
		
		} else if (!Control.filled(jelszo)) {
			Control.showMD("Üres a jelszó mezõ", 2);
		
		} else if (!Control.filled(nev)) {
			Control.showMD("Üres a név mezõ", 2); 
			
		} else if (!Control.filled(mail)) {
			Control.showMD("Üres az e-mail mezõ", 2);
			
		} else if (!Control.filled(nem)) {
			Control.showMD("Üres a nem mezõ", 2);
		}
		

		else {
			kilep = 2;
			dispose();
			setVisible(false);
		}
	}

	public String getUsername() {
		return felh.getText();
	}

	public String getPassword() {
		return jelszo.getText();
	}

	public String getTipus() {
		return tipus.getText();
	}

	public String getName() {
		return nev.getText();
	}

	public String getEmail() {
		return mail.getText();
	}

	public String getSex() {
		return nem.getText();
	}

	public String getDateofbirth() {
		return szulido.getText();
	}

	public String getCountry() {
		return orszag.getText();
	}

	public int kiLep() {
		return kilep;
	}
	
	public void PwGen () {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		String pwd = RandomStringUtils.random( 8, characters );
		jelszo.setText(pwd);
	}

}