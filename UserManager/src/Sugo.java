

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Sugo extends JDialog {
	private JLabel GeneralAltTitle1;

	public Sugo(JFrame f) {
		super(f, "Súgó");
		getContentPane().setBackground(new Color(230, 230, 250));
		setBounds(100, 100, 772, 421);
		getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 740, 329);
		getContentPane().add(tabbedPane);

		JPanel GeneralPanel = new JPanel();
		GeneralPanel.setBackground(new Color(176, 196, 222));
		tabbedPane.addTab("Általános", null, GeneralPanel, null);
		GeneralPanel.setLayout(null);

		JLabel General = new JLabel("\u00DCdv\u00F6z\u00F6llek! Itt mindent megtal\u00E1lsz amire sz\u00FCks\u00E9ged van a program haszn\u00E1lat\u00E1hoz!");
		General.setFont(new Font("Yu Gothic", Font.PLAIN, 17));
		General.setBounds(10, 11, 715, 28);
		GeneralPanel.add(General);

		GeneralAltTitle1 = new JLabel("Miel\u0151tt kiv\u00E1lasztan\u00E1l egy men\u00FCpontot!");
		GeneralAltTitle1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		GeneralAltTitle1.setBounds(10, 50, 715, 18);
		GeneralPanel.add(GeneralAltTitle1);

		JLabel GeneralAltTitle2 = new JLabel("1. Ha nincs fi\u00F3kod regisztr\u00E1lj.");
		GeneralAltTitle2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		GeneralAltTitle2.setBounds(10, 75, 715, 18);
		GeneralPanel.add(GeneralAltTitle2);

		JLabel GeneralAltTitle3 = new JLabel("2. Ha van fi\u00F3kod, \u00EDrd be a helyes felhaszn\u00E1l\u00F3nevet \u00E9s jelsz\u00F3t, majd v\u00E1lassz a men\u00FCpontok k\u00F6z\u00FCl.");
		GeneralAltTitle3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		GeneralAltTitle3.setBounds(10, 100, 715, 18);
		GeneralPanel.add(GeneralAltTitle3);

		JLabel GeneralAltTitle4 = new JLabel("3. Egyes men\u00FCpontok csakis Admin fi\u00F3kkal/hozz\u00E1f\u00E9r\u00E9ssel nyithat\u00F3ak meg.");
		GeneralAltTitle4.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		GeneralAltTitle4.setBounds(10, 125, 715, 18);
		GeneralPanel.add(GeneralAltTitle4);
		
		JLabel lblARendszerMinden = new JLabel("A rendszer minden tev\u00E9kenys\u00E9g sor\u00E1n \u00FCzenetet k\u00FCld a helyes vagy helytelen m\u0171k\u00F6d\u00E9sr\u0151l.");
		lblARendszerMinden.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblARendszerMinden.setBounds(10, 272, 715, 18);
		GeneralPanel.add(lblARendszerMinden);

		JPanel betolt = new JPanel();
		betolt.setBackground(new Color(176, 196, 222));
		tabbedPane.addTab("Regisztráció", null, betolt, null);
		betolt.setLayout(null);

		JLabel betoltTitle = new JLabel("Regisztr\u00E1ci\u00F3");
		betoltTitle.setFont(new Font("Yu Gothic", Font.PLAIN, 17));
		betoltTitle.setBounds(10, 11, 715, 18);
		betolt.add(betoltTitle);

		JLabel betoltAltTitle = new JLabel("1. T\u00F6ltse ki a *-al jel\u00F6lt adatok hely\u00E9t, ha szeretn\u00E9 a t\u00F6bbit is kit\u00F6ltheti de nem k\u00F6telez\u0151.");
		betoltAltTitle.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		betoltAltTitle.setBounds(10, 53, 715, 18);
		betolt.add(betoltAltTitle);

		JLabel betoltAltTitle5 = new JLabel(
				"2. Jelsz\u00F3 gener\u00E1l\u00E1shoz kattintson a \"Jelsz\u00F3 gener\u00E1l\u00E1s\" gombra.");
		betoltAltTitle5.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		betoltAltTitle5.setBounds(10, 79, 715, 18);
		betolt.add(betoltAltTitle5);

		JLabel betoltAltTitle6 = new JLabel(
				"3. Sz\u00FClet\u00E9si d\u00E1tum\u00E1t v\u00E1lassza ki a napt\u00E1rb\u00F3l majd kattintson a \"D\u00E1tum hozz\u00E1ad\u00E1sa\" gombra.");
		betoltAltTitle6.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		betoltAltTitle6.setBounds(10, 104, 715, 18);
		betolt.add(betoltAltTitle6);

		JLabel betoltAltTitle7 = new JLabel(
				"4. Ellen\u0151rizze az adatait.");
		betoltAltTitle7.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		betoltAltTitle7.setBounds(10, 129, 715, 18);
		betolt.add(betoltAltTitle7);
		
		JLabel lblRendelsBetltse = new JLabel("5. Regisztr\u00E1ci\u00F3hoz kattintson a \"Regisztr\u00E1ci\u00F3\" gombra.");
		lblRendelsBetltse.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblRendelsBetltse.setBounds(10, 152, 715, 18);
		betolt.add(lblRendelsBetltse);
		
		JLabel label_4 = new JLabel("A rendszer minden tev\u00E9kenys\u00E9g sor\u00E1n \u00FCzenetet k\u00FCld a helyes vagy helytelen m\u0171k\u00F6d\u00E9sr\u0151l.");
		label_4.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		label_4.setBounds(10, 272, 715, 18);
		betolt.add(label_4);
		
				JPanel kiir = new JPanel();
				kiir.setBackground(new Color(176, 196, 222));
				tabbedPane.addTab("Lista", null, kiir, null);
				kiir.setLayout(null);
				
						JLabel kiirTitle = new JLabel("Lista");
						kiirTitle.setFont(new Font("Yu Gothic", Font.PLAIN, 17));
						kiirTitle.setBounds(10, 11, 715, 18);
						kiir.add(kiirTitle);
						
								JLabel kiirAltTitle = new JLabel(
										"1. \u00CDrja be a helyes felhaszn\u00E1l\u00F3nev\u00E9t \u00E9s jelszav\u00E1t.");
								kiirAltTitle.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
								kiirAltTitle.setBounds(10, 50, 715, 18);
								kiir.add(kiirAltTitle);
										
												JLabel kiirAltTitle4 = new JLabel("2. List\u00E1ra kattintva megjelenik az \u00F6sszes adat a felhaszn\u00E1l\u00F3kr\u00F3l.");
												kiirAltTitle4.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
												kiirAltTitle4.setBounds(10, 79, 715, 18);
												kiir.add(kiirAltTitle4);
												
												JLabel label = new JLabel("A rendszer minden tev\u00E9kenys\u00E9g sor\u00E1n \u00FCzenetet k\u00FCld a helyes vagy helytelen m\u0171k\u00F6d\u00E9sr\u0151l.");
												label.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
												label.setBounds(10, 272, 715, 18);
												kiir.add(label);

		JPanel ujPanel = new JPanel();
		ujPanel.setBackground(new Color(176, 196, 222));
		tabbedPane.addTab("Keresés", null, ujPanel, null);
		ujPanel.setLayout(null);

		JLabel ujTitle = new JLabel("Keres\u00E9s");
		ujTitle.setFont(new Font("Yu Gothic", Font.PLAIN, 17));
		ujTitle.setBounds(10, 11, 715, 18);
		ujPanel.add(ujTitle);

		JLabel ujAltTitle = new JLabel(
				"1. \u00CDrja be a helyes felhaszn\u00E1l\u00F3nev\u00E9t \u00E9s jelszav\u00E1t.");
		ujAltTitle.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		ujAltTitle.setBounds(10, 50, 715, 18);
		ujPanel.add(ujAltTitle);

		JLabel ujAltTitle2 = new JLabel(
				"2. A keres\u00E9si mez\u0151be \u00EDrja be a k\u00EDv\u00E1nt adatot, keres\u00E9st fog ind\u00EDtani a Felhaszn\u00E1l\u00F3n\u00E9v, N\u00E9v, Orsz\u00E1g mez\u0151kre.");
		ujAltTitle2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		ujAltTitle2.setBounds(10, 72, 715, 18);
		ujPanel.add(ujAltTitle2);
		
		JLabel label_1 = new JLabel("A rendszer minden tev\u00E9kenys\u00E9g sor\u00E1n \u00FCzenetet k\u00FCld a helyes vagy helytelen m\u0171k\u00F6d\u00E9sr\u0151l.");
		label_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		label_1.setBounds(10, 272, 715, 18);
		ujPanel.add(label_1);
		
		JLabel lblKeresshezKattintson = new JLabel("3. Keres\u00E9shez kattintson a \"Keres\u00E9s\" gombra.");
		lblKeresshezKattintson.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblKeresshezKattintson.setBounds(10, 101, 715, 18);
		ujPanel.add(lblKeresshezKattintson);

		JPanel modPanel = new JPanel();
		modPanel.setBackground(new Color(176, 196, 222));
		tabbedPane.addTab("Módosítás", null, modPanel, null);
		modPanel.setLayout(null);

		JLabel modTitle = new JLabel("M\u00F3dos\u00EDt\u00E1s");
		modTitle.setFont(new Font("Yu Gothic", Font.PLAIN, 17));
		modTitle.setBounds(10, 11, 715, 18);
		modPanel.add(modTitle);

		JLabel modAltTitle = new JLabel("1. Admin hozz\u00E1f\u00E9r\u00E9s\u0171 men\u00FCpont, csak admin fi\u00F3k l\u00E9phet be.");
		modAltTitle.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		modAltTitle.setBounds(10, 40, 715, 18);
		modPanel.add(modAltTitle);

		JLabel modAltTitle2 = new JLabel("2. Keres\u00E9shez \u00EDrjon be adatot a Felhaszn\u00E1l\u00F3n\u00E9v, N\u00E9v vagy Orsz\u00E1g mez\u0151be, majd kattintson a \"Keres\u00E9s\" gombra.");
		modAltTitle2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		modAltTitle2.setBounds(10, 69, 715, 18);
		modPanel.add(modAltTitle2);

		JLabel modAltTitle4 = new JLabel(
				"3. A keresett felhaszn\u00E1l\u00F3 megjelenik, ha nem a k\u00EDv\u00E1nt eredm\u00E9nyt kapta vissza kattintson a \"Vissza\u00E1ll\u00EDt\" gombra.");
		modAltTitle4.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		modAltTitle4.setBounds(10, 98, 715, 18);
		modPanel.add(modAltTitle4);

		JLabel modAltTitle5 = new JLabel("4. Ha nem a vissza\u00E1ll\u00EDt gombot haszn\u00E1lja csak \u00EDrjon be egy adatot az \u00FAj keres\u00E9shez.");
		modAltTitle5.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		modAltTitle5.setBounds(10, 127, 715, 18);
		modPanel.add(modAltTitle5);
		
		JLabel label_2 = new JLabel("A rendszer minden tev\u00E9kenys\u00E9g sor\u00E1n \u00FCzenetet k\u00FCld a helyes vagy helytelen m\u0171k\u00F6d\u00E9sr\u0151l.");
		label_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		label_2.setBounds(10, 272, 715, 18);
		modPanel.add(label_2);
		
		JLabel lblMdostshozVltoztassa = new JLabel("5. M\u00F3dos\u00EDt\u00E1shoz v\u00E1ltoztassa meg az adatot majd kattintson a \"M\u00F3dos\u00EDt\u00E1s\" gombra k\u00E9tszer.");
		lblMdostshozVltoztassa.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		lblMdostshozVltoztassa.setBounds(10, 156, 715, 18);
		modPanel.add(lblMdostshozVltoztassa);

		JPanel torolPanel = new JPanel();
		torolPanel.setBackground(new Color(176, 196, 222));
		tabbedPane.addTab("Exportálás", null, torolPanel, null);
		torolPanel.setLayout(null);

		JLabel torolTitle = new JLabel("Export\u00E1l\u00E1s");
		torolTitle.setFont(new Font("Yu Gothic", Font.PLAIN, 17));
		torolTitle.setBounds(10, 11, 715, 18);
		torolPanel.add(torolTitle);

		JLabel torolAltTitle2 = new JLabel(
				"2. \"V\u00E1laszt\u00E1s\" gombra kattintva v\u00E1lassza ki a mapp\u00E1t ahova k\u00EDv\u00E1nja ki\u00EDrni a felhaszn\u00E1l\u00F3i adatokat .csv f\u00E1jlba.");
		torolAltTitle2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		torolAltTitle2.setBounds(10, 70, 715, 18);
		torolPanel.add(torolAltTitle2);

		JLabel torolAltTitle3 = new JLabel("3. Adja meg a f\u00E1jl nev\u00E9t .csv kiterjeszt\u00E9s n\u00E9lk\u00FCl.");
		torolAltTitle3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		torolAltTitle3.setBounds(10, 95, 715, 18);
		torolPanel.add(torolAltTitle3);

		JLabel torolAltTitle4 = new JLabel(
				"4. Kattintson a \"Ki\u00EDr\u00E1s\" gombra a f\u00E1jl l\u00E9trehoz\u00E1s\u00E1hoz.\r\n");
		torolAltTitle4.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		torolAltTitle4.setBounds(10, 120, 715, 18);
		torolPanel.add(torolAltTitle4);
		
		JLabel label_3 = new JLabel("A rendszer minden tev\u00E9kenys\u00E9g sor\u00E1n \u00FCzenetet k\u00FCld a helyes vagy helytelen m\u0171k\u00F6d\u00E9sr\u0151l.");
		label_3.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		label_3.setBounds(10, 272, 715, 18);
		torolPanel.add(label_3);
		
		JLabel label_5 = new JLabel("1. Admin hozz\u00E1f\u00E9r\u00E9s\u0171 men\u00FCpont, csak admin fi\u00F3k l\u00E9phet be.");
		label_5.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		label_5.setBounds(10, 46, 715, 18);
		torolPanel.add(label_5);

		JButton bezar = new JButton("Bez\u00E1r\u00E1s");
		bezar.setFont(new Font("Arial", Font.PLAIN, 12));
		bezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		bezar.setBounds(312, 351, 89, 23);
		getContentPane().add(bezar);

	}
}
