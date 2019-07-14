import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;

public class Kiir extends JDialog implements ActionListener {
	private JPanel dp;
	private JButton bo, bs;
	private TM dtmp1;
	private int kilep = 0;
	private Control cc;
	private String ker = "kod";
	private String kerkif = "kod";
	private TM kertm;
	private TM etm;
	private int ehx = 0;

	private String mes = "Program üzenete:";

	public Kiir(JFrame f, TM dtmp, int bsx, int bsy) {
		super(f, "Felhasználók listázása", true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\\u00C1d\u00E1m\\Desktop\\ucc\\regicon.png"));

		dtmp1 = dtmp;
		setBounds(bsx - 30, bsy + 30, 800, 278);
		dp = new JPanel();
		dp.setBackground(new Color(230, 230, 250));
		this.getContentPane().add(dp);

		JTable table = new JTable(dtmp1);
		TableColumn column = null;
		for (int i = 0; i < 8; i++) {
			column = table.getColumnModel().getColumn(i);
			if (i == 0) {
				column.setPreferredWidth(80);
			} else if (i == 1) {
				column.setPreferredWidth(50);
			} else if (i == 2) {
				column.setPreferredWidth(50);
			} else if (i == 3) {
				column.setPreferredWidth(150);
			} else if (i == 4) {
				column.setPreferredWidth(120);
			} else if (i == 5) {
				column.setPreferredWidth(40);
			} else if (i == 6) {
				column.setPreferredWidth(70);
			} else if (i == 7) {
				column.setPreferredWidth(100);
			}

		}

		table.setAutoCreateRowSorter(true);
		TableRowSorter<TM> sorter = (TableRowSorter<TM>) table.getRowSorter();

		JScrollPane sp;
		dp.setLayout(null);
		sp = new JScrollPane(table);
		sp.setBounds(10, 10, 764, 182);
		dp.add(sp);

		bo = new JButton();
		bo.setFont(new Font("Arial", Font.PLAIN, 12));
		bo.setBounds(342, 205, 97, 23);
		bo.setText("Bez\u00E1r\u00E1s");
		dp.add(bo);
		bo.addActionListener(this);
		
		
		Object[] emptmn = {  "Felh.", "Jelszó", "Típus", "Név", "E-mail", "Neme", "Szül.idõ", "Ország" };
		etm = new TM(emptmn, 0);
		
	
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.bo) {
			kilep = 2;
			this.dispose();
			setVisible(false);
		}
	}

	public int kiLep() {
		return kilep;
	}

	public int bsX() {
		java.awt.Point bs = getLocation();
		int bsx = (int) bs.getX();
		return bsx;
	}

	public int bsY() {
		java.awt.Point bs = getLocation();
		int bsy = (int) bs.getY();
		return bsy;
	}

}