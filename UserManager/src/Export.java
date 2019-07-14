import javax.swing.*;



import java.awt.event.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.*;
import java.util.*;

public class Export extends JPanel implements ActionListener {
	private JButton browser;

	private JFileChooser chooser;
	private String choosertitle;
	private JTextField iras;
	private JTextField fname;
	private String a = "mappa";

	public Export() {
		setBackground(new Color(230, 230, 250));
		setLayout(null);
		
		JButton button_1 = new JButton("Bez\u00E1r\u00E1s");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JComponent comp = (JComponent) e.getSource();
				  Window win = SwingUtilities.getWindowAncestor(comp);
				  win.dispose();
				
			}
		});
		button_1.setFont(new Font("Arial", Font.PLAIN, 12));
		button_1.setBounds(324, 145, 100, 27);
		add(button_1);
		
		JLabel lblVlasszaKiA = new JLabel("V\u00E1lassza ki a mapp\u00E1t ahova menteni szeretn\u00E9 a f\u00E1jlt.");
		lblVlasszaKiA.setFont(new Font("Arial", Font.PLAIN, 14));
		lblVlasszaKiA.setBounds(20, 27, 378, 17);
		add(lblVlasszaKiA);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(10, 19, 422, 63);
		add(panel);
		panel.setLayout(null);
		
		iras = new JTextField();
		iras.setBounds(9, 31, 295, 27);
		panel.add(iras);
		iras.setEnabled(false);
		iras.setColumns(10);
		
				browser = new JButton("V\u00E1laszt\u00E1s");
				browser.setBounds(314, 31, 100, 26);
				panel.add(browser);
				browser.setFont(new Font("Arial", Font.PLAIN, 12));
				browser.addActionListener(this);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(176, 196, 222));
		panel_1.setBounds(10, 92, 422, 42);
		add(panel_1);
		panel_1.setLayout(null);
		
		fname = new JTextField();
		fname.setBounds(145, 11, 141, 24);
		panel_1.add(fname);
		fname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fname.setColumns(10);
		
		JLabel lblrjaBeA = new JLabel("\u00CDrja be a f\u00E1jl nev\u00E9t.");
		lblrjaBeA.setBounds(10, 15, 295, 16);
		panel_1.add(lblrjaBeA);
		lblrjaBeA.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton kiir = new JButton("Ki\u00EDr\u00E1s");
		kiir.setBounds(312, 9, 100, 26);
		panel_1.add(kiir);
		kiir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(kiir)) {
					FileExport();
				}
			}
		});
		kiir.setFont(new Font("Arial", Font.PLAIN, 12));
	}

	public void actionPerformed(ActionEvent e) {
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle(choosertitle);
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		//
		// disable the "All files" option.
		//
		chooser.setAcceptAllFileFilterUsed(false);
		//
		if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
			System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
			iras.setText(chooser.getSelectedFile().getPath());
			a = chooser.getSelectedFile().getPath();
		} else {
			System.out.println("No Selection ");
		}
		
		
	}

	public Dimension getPreferredSize() {
		return new Dimension(460, 225);
	}
	
	
	

	public void FileExport() {
		String f = fname.getText();
		Connection connect = null;
		Statement s = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "root");
			s = connect.createStatement();
			String sql = "SELECT * FROM  users ORDER BY username ASC";
			ResultSet rec = s.executeQuery(sql);
			
			String path =  a + "\\" + f + ".csv";
			FileWriter writer;

			try {
				File file = new File(path);
				writer = new FileWriter(file, true); // True = Append to file, false = Overwrite
				while ((rec != null) && (rec.next())) {
					writer.write(rec.getString("username"));
					writer.write(",");
					writer.write(rec.getString("passw"));
					writer.write(",");
					writer.write(rec.getString("type"));
					writer.write(",");
					writer.write(rec.getString("name"));
					writer.write(",");
					writer.write(rec.getString("email"));
					writer.write(",");
					writer.write(rec.getString("sex"));
					writer.write(",");
					writer.write(rec.getString("dateofbirth"));
					writer.write(",");
					writer.write(rec.getString("country"));
					writer.write("\r\n");
				}
				writer.close();
				JOptionPane.showMessageDialog(null, "Adatok kiírva a " + f + ".csv fájlba", path, 1);
			} catch (IOException e) {
				Control.showMD("Adatok kiírása sikertelen.", 2);
				e.printStackTrace();
			}
		} catch (Exception e) {
			Control.showMD("Adatok kiírása sikertelen.", 2);
			e.printStackTrace();
		}
		// Close
		try {
			if (connect != null) {
				s.close();
				connect.close();
			}
		} catch (SQLException e) {
			Control.showMD("Sikertelen lekapcsolódás az adatbázisról.", 2);
			e.printStackTrace();
		}

	}

}