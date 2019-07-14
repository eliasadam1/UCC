
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JDialog;

public class Kereses extends javax.swing.JDialog {

	private javax.swing.JButton jButton_Search;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable_Users;
	private javax.swing.JTextField txtSearch;
	private JLabel lblKeresendAdat;
	private JButton btnBezrs;

	public Kereses() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\\u00C1d\u00E1m\\Desktop\\ucc\\regicon.png"));
		setTitle("Felhaszn\u00E1l\u00F3k keres\u00E9se");
		initComponents();

		// call findUsers function
		findUsers();

	}

	// function to connect to mysql database
	public Connection getConnection() {
		Connection con = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "root");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return con;
	}

	// function to return users arraylist with particular data
	public ArrayList<Users> ListUsers(String ValToSearch) {
		ArrayList<Users> usersList = new ArrayList<Users>();

		Statement st;
		ResultSet rs;

		try {
			Connection con = getConnection();
			st = con.createStatement();
			String searchQuery = "SELECT * FROM `users` WHERE CONCAT(`username`, `name`, `country`) LIKE '%"+ ValToSearch + "%'";
			rs = st.executeQuery(searchQuery);

			Users user;

			while (rs.next()) {
				user = new Users(rs.getString("username"), rs.getString("passw"), rs.getString("type"),
						rs.getString("name"), rs.getString("email"), rs.getString("sex"), rs.getDate("dateofbirth"),
						rs.getString("country")

				);
				usersList.add(user);
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return usersList;
	}

	// function to display data in jtable
	public void findUsers() {
		ArrayList<Users> users = ListUsers(txtSearch.getText());
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(
				new Object[] { "Felh.", "Jelszó", "Típus", "Név", "E-mail", "Neme", "Szül.idõ", "Ország" });
		Object[] row = new Object[8];

		for (int i = 0; i < users.size(); i++) {
			row[0] = users.get(i).getUsername();
			row[1] = users.get(i).getPassword();
			row[2] = users.get(i).getTipus();
			row[3] = users.get(i).getName();
			row[4] = users.get(i).getEmail();
			row[5] = users.get(i).getSex();
			row[6] = users.get(i).getDateofbirth();
			row[7] = users.get(i).getCountry();
			model.addRow(row);
		}
		jTable_Users.setModel(model);

	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		jPanel2 = new javax.swing.JPanel();
		jPanel2.setBackground(new Color(230, 230, 250));
		jButton_Search = new javax.swing.JButton();
		jButton_Search.setFont(new Font("Arial", Font.PLAIN, 12));
		txtSearch = new javax.swing.JTextField();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable_Users = new javax.swing.JTable();

		jButton_Search.setText("Keres\u00E9s");
		jButton_Search.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton_SearchActionPerformed(evt);
			}
		});

		txtSearch.setFont(new Font("Arial", Font.PLAIN, 12));

		jTable_Users.setFont(new java.awt.Font("Arial", 1, 12));
		jTable_Users.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null } },
				new String[] { "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7",
						"Title 8" }));
		jScrollPane1.setViewportView(jTable_Users);

		lblKeresendAdat = new JLabel("Keresend\u0151 adat:");
		lblKeresendAdat.setFont(new Font("Arial", Font.PLAIN, 12));

		btnBezrs = new JButton();
		btnBezrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBezrs.setText("Bez\u00E1r\u00E1s");
		btnBezrs.setFont(new Font("Arial", Font.PLAIN, 12));

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2Layout.setHorizontalGroup(
			jPanel2Layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(jPanel2Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
						.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
							.addComponent(lblKeresendAdat, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(jButton_Search, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 302, Short.MAX_VALUE)
							.addComponent(btnBezrs, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		jPanel2Layout.setVerticalGroup(
			jPanel2Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
					.addGap(35)
					.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBezrs)
						.addComponent(lblKeresendAdat)
						.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jButton_Search))
					.addGap(29)
					.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
					.addContainerGap())
		);
		jPanel2.setLayout(jPanel2Layout);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(jPanel2,
				GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(jPanel2,
				GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE));
		getContentPane().setLayout(layout);

		pack();
	}

	private void jButton_SearchActionPerformed(java.awt.event.ActionEvent evt) {
		if (!Control.filled(txtSearch)) {
			Control.showMD("Üres a keresés mezõ", 2);
			
		}
		findUsers();

	}

}