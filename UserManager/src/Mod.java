import java.awt.*;

import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.border.*;
import java.util.Calendar;

import org.apache.commons.lang3.RandomStringUtils;
import com.toedter.calendar.JDateChooser;

public class Mod extends JPanel implements ActionListener, FocusListener {
	Connection conn;
	Statement stmt, stmtdel;
	ResultSet rs;
	String url;
	int nrows, reply, response, stmtval, flag;

	Border border;

	Color c1 = new Color(255, 146, 34);
	Color c2 = new Color(251, 254, 120);// yellow
	Color c5 = new Color(190, 190, 240);

	Font f4 = new Font("Arial", Font.BOLD, 12);

	JLabel lblinsrcds, clas, reg, sname, fname, category, studob, sex, city, lblhobby;
	JTextField txtFelh, txtName, txtTip, txtEmail, txtSzulido, txtCountry, txtPw, txtSex;
	JButton btn_search, btn_cancel, btn_exit;

	String strfelh, strpw, strtip, strnev, strmail, strsex, strbirth, strcountry;
	private JButton btnJelszGenerls;
	private JButton btn_update;
	private JButton btnDel;

	public Mod() {

		setBackground(new Color(230, 230, 250));
		setLayout(null);
		border = new BevelBorder(BevelBorder.LOWERED);

		// JLabel Reg.No.
		reg = new JLabel("Felhaszn\u00E1l\u00F3n\u00E9v:");
		reg.setBounds(30, 60, 100, 30);
		reg.setFont(new Font("Arial", Font.BOLD, 12));
		add(reg);

		// JTextField Reg.No.
		txtFelh = new JTextField(10);
		txtFelh.setBounds(140, 65, 170, 23);
		txtFelh.setBorder(border);
		txtFelh.setBackground(new Color(255, 255, 255));
		txtFelh.setFont(f4);
		txtFelh.addFocusListener(this);
		add(txtFelh);

		// JButton Search
		btn_search = new JButton("Keres\u00E9s");
		btn_search.setFont(new Font("Arial", Font.PLAIN, 12));
		btn_search.setBounds(344, 64, 100, 23);
		btn_search.setBackground(UIManager.getColor("Button.background"));
		btn_search.setMnemonic(KeyEvent.VK_S);
		btn_search.setMnemonic('s');
		btn_search.addActionListener(this);
		add(btn_search);

		// JLabel Class
		clas = new JLabel("Jelsz\u00F3:");
		clas.setBounds(30, 101, 100, 30);
		clas.setFont(new Font("Arial", Font.BOLD, 12));
		add(clas);

		// JTextField Class
		txtPw = new JTextField(10);
		txtPw.setBounds(140, 106, 100, 23);
		txtPw.setBorder(border);
		txtPw.setBackground(new Color(255, 255, 255));
		txtPw.setFont(f4);
		txtPw.addFocusListener(this);
		add(txtPw);

		// JLabel Student's Name
		sname = new JLabel("N\u00E9v:");
		sname.setBounds(30, 183, 100, 30);
		sname.setFont(new Font("Arial", Font.BOLD, 12));
		add(sname);

		// JTextField Student's Name
		txtName = new JTextField(10);
		txtName.setBounds(140, 188, 170, 23);
		txtName.setBorder(border);
		txtName.setBackground(new Color(255, 255, 255));
		txtName.setFont(f4);
		txtName.addFocusListener(this);
		add(txtName);

		// JLabel Father's Name
		fname = new JLabel("E-mail:");
		fname.setBounds(30, 224, 100, 30);
		fname.setFont(new Font("Arial", Font.BOLD, 12));
		add(fname);

		// JTextField Father's Name
		txtTip = new JTextField(10);
		txtTip.setBounds(140, 147, 100, 23);
		txtTip.setBorder(border);
		txtTip.setBackground(new Color(255, 255, 255));
		txtTip.setFont(f4);
		txtTip.addFocusListener(this);
		add(txtTip);

		// JTextField Mother's Name
		txtEmail = new JTextField(10);
		txtEmail.setBounds(140, 229, 206, 23);
		txtEmail.setBorder(border);
		txtEmail.setBackground(new Color(255, 255, 255));
		txtEmail.setFont(f4);
		txtEmail.addFocusListener(this);
		add(txtEmail);

		// JLabel Category
		category = new JLabel("Tipus:");
		category.setBounds(30, 142, 170, 30);
		category.setFont(new Font("Arial", Font.BOLD, 12));
		add(category);

		// JLabel Date of Birth
		studob = new JLabel("Sz\u00FClet\u00E9si id\u0151:");
		studob.setBounds(30, 305, 170, 30);
		studob.setFont(new Font("Arial", Font.BOLD, 12));
		add(studob);

		// JTextFields Date of Birth
		txtSzulido = new JTextField(2);
		txtSzulido.setBounds(140, 310, 170, 23);
		txtSzulido.setBorder(border);
		txtSzulido.setBackground(new Color(255, 255, 255));
		txtSzulido.setFont(f4);
		txtSzulido.addFocusListener(this);
		add(txtSzulido);

		// JLabel Sex
		sex = new JLabel("Nem:");
		sex.setBounds(30, 265, 100, 30);
		sex.setFont(new Font("Arial", Font.BOLD, 12));
		add(sex);

		// JTextField Sex
		txtSex = new JTextField(10);
		txtSex.setBounds(140, 270, 89, 23);
		txtSex.setBorder(border);
		txtSex.setBackground(new Color(255, 255, 255));
		txtSex.setFont(f4);
		txtSex.addFocusListener(this);
		add(txtSex);

		// JLabel City
		city = new JLabel("Orsz\u00E1g:");
		city.setBounds(30, 346, 100, 30);
		city.setFont(new Font("Arial", Font.BOLD, 12));
		add(city);

		// JTextField City
		txtCountry = new JTextField(10);
		txtCountry.setBounds(140, 351, 170, 23);
		txtCountry.setBorder(border);
		txtCountry.setBackground(new Color(255, 255, 255));
		txtCountry.setFont(f4);
		txtCountry.addFocusListener(this);
		add(txtCountry);

		// JButton Cancel
		btn_cancel = new JButton("Vissza\u00E1ll\u00EDt");
		btn_cancel.setFont(new Font("Arial", Font.PLAIN, 12));
		btn_cancel.setBackground(UIManager.getColor("Button.background"));
		btn_cancel.setBounds(120, 391, 100, 23);
		btn_cancel.setMnemonic(KeyEvent.VK_C);
		btn_cancel.setToolTipText("Cancel");
		btn_cancel.setMnemonic('c');
		btn_cancel.addActionListener(this);
		add(btn_cancel);

		// JButton Exit
		btn_exit = new JButton("Kil\u00E9p\u00E9s");
		btn_exit.setFont(new Font("Arial", Font.PLAIN, 12));
		btn_exit.setBackground(UIManager.getColor("Button.background"));
		btn_exit.setBounds(344, 391, 100, 23);
		btn_exit.setMnemonic(KeyEvent.VK_X);
		btn_exit.setToolTipText("Exit");
		btn_exit.setMnemonic('x');
		btn_exit.addActionListener(this);
		add(btn_exit);

		btnJelszGenerls = new JButton("Jelsz\u00F3 gener\u00E1l\u00E1s");
		btnJelszGenerls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PwGen();
			}
		});
		btnJelszGenerls.setMnemonic('s');
		btnJelszGenerls.setMnemonic(KeyEvent.VK_S);
		btnJelszGenerls.setFont(new Font("Arial", Font.PLAIN, 12));
		btnJelszGenerls.setBackground(UIManager.getColor("Button.background"));
		btnJelszGenerls.setBounds(317, 105, 127, 23);
		add(btnJelszGenerls);

		btn_update = new JButton("M\u00F3dos\u00EDt\u00E1s");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource() == btn_update) {
					Update_Record();
					flag = 2;
				}
			}
		});
		btn_update.setToolTipText("Cancel");
		btn_update.setMnemonic('c');
		btn_update.setMnemonic(KeyEvent.VK_C);
		btn_update.setFont(new Font("Arial", Font.PLAIN, 12));
		btn_update.setBackground(UIManager.getColor("Button.background"));
		btn_update.setBounds(10, 391, 100, 23);
		add(btn_update);

		btnDel = new JButton("T\u00F6rl\u00E9s");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "delete from users where username=?";

				try (PreparedStatement stmt = conn.prepareStatement(sql)) {
					
					reply=JOptionPane.showConfirmDialog(null,"Biztos törli a felhasználót?");
                    if(reply==JOptionPane.YES_OPTION)
                    {                                       
                    	stmt.setString(1, txtFelh.getText());
    					stmt.executeUpdate();     
    					Control.showMD("Rekord törölve", 1);
                    }                                       
                    if(reply==JOptionPane.NO_OPTION)
                    {                                               
                            return;
                    }   
					
					
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnDel.setToolTipText("Mégse");
		btnDel.setMnemonic('c');
		btnDel.setMnemonic(KeyEvent.VK_C);
		btnDel.setFont(new Font("Arial", Font.PLAIN, 12));
		btnDel.setBackground(UIManager.getColor("Button.background"));
		btnDel.setBounds(230, 391, 100, 23);
		add(btnDel);

	}

	public void focusGained(FocusEvent fe) {
		fe.getComponent().setBackground(Color.yellow);
	}

	public void focusLost(FocusEvent fe) {
		fe.getComponent().setBackground(Color.white);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btn_search) {
			Search_Record();
		}
		
		if (ae.getSource() == btn_cancel) {
			clsAllFlds();
		}
		if (ae.getSource() == btn_exit) {
			JComponent comp = (JComponent) ae.getSource();
			Window win = SwingUtilities.getWindowAncestor(comp);
			win.dispose();
		}

	}

	public void Search_Record() {
		String regval_search = txtFelh.getText();
		try {

			String sql_search = "SELECT * FROM `users` WHERE CONCAT(`username`, `name`, `country`) LIKE '%"
					+ regval_search + "%'";

			rs = stmt.executeQuery(sql_search);
			if (rs.next() == false) {
				JOptionPane.showMessageDialog(null, "Felhasználó: " + regval_search + " nem létezik.");
				clsAllFlds();
			} else {
				String stfelh = rs.getString("username");
				String stpw = rs.getString("passw");
				String sttype = rs.getString("type");
				String stname = rs.getString("name");
				String stmail = rs.getString("email");
				String stsex = rs.getString("sex");
				String stbirth = rs.getString("dateofbirth");
				String stcountry = rs.getString("country");

				txtFelh.setText(stfelh);
				txtPw.setText(stpw);
				txtTip.setText(sttype);
				txtName.setText(stname);
				txtEmail.setText(stmail);
				txtSex.setText(stsex);
				txtSzulido.setText(stbirth);
				txtCountry.setText(stcountry);

				getValueForUpdate();
			}
		} catch (SQLException se) {
			Control.showMD("Valami hiba történt az adatbázissal! Hiba: " + se.getMessage(), 2);

			System.out.println(se.getMessage());
		}
	}

	public void getValueForUpdate() {
		strfelh = txtFelh.getText();
		strpw = txtPw.getText();
		strnev = txtName.getText();
		strtip = txtTip.getText();
		strmail = txtEmail.getText();
		strbirth = txtSzulido.getText();
		strsex = txtSex.getText();
		strcountry = txtCountry.getText();

	}

	public void clsAllFlds() {

		txtPw.setText("");
		txtName.setText("");
		txtTip.setText("");
		txtEmail.setText("");
		txtSzulido.setText("");
		txtSex.setText("");
		txtCountry.setText("");

	}

	public void setBackgroundColor() {
		txtFelh.setBackground(c1);

		txtPw.setBackground(c1);
		txtName.setBackground(c1);
		txtTip.setBackground(c1);
		txtEmail.setBackground(c1);
		txtSzulido.setBackground(c1);

		txtSex.setBackground(c1);

		txtCountry.setBackground(c1);

	}

	public void Update_Record() {
		try {
			if (flag == 2) {
				reply = JOptionPane.showConfirmDialog(null, "Biztos módosítani szeretné a fiókot?");
				if (reply == JOptionPane.YES_OPTION) {
					getValueForUpdate();
					PreparedStatement pre_update;

					pre_update = conn.prepareStatement("UPDATE users SET username='" + strfelh + "',passw='" + strpw
							+ "',type='" + strtip + "',name='" + strnev + "',email='" + strmail + "',sex='" + strsex
							+ "',dateofbirth='" + strbirth + "',country='" + strcountry + "'WHERE username='" + strfelh
							+ "'");
					pre_update.executeUpdate();

					JOptionPane.showMessageDialog(null, "Fiók sikeresen módosítva!", "Note", 2);
					setBackgroundColor();
					Search_Record();
				}
			}
			if (reply == JOptionPane.NO_OPTION) {
				return;
			}
		} catch (SQLException e) {
			Control.showMD("Valami hiba történt az adatbázissal! Hiba: " + e.getMessage(), 2);
		}
	}

	public void connection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "root");
			stmt = conn.createStatement();
			System.out.println("Sikeres kapcsolódás");
		} catch (SQLException se) {
			System.out.println("ERROR:" + se);
		} catch (ClassNotFoundException cnf) {
			System.out.println("ERROR:" + cnf);
		}

	}

	public void PwGen() {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		String pwd = RandomStringUtils.random(8, characters);
		txtPw.setText(pwd);
	}
}