package geometrija;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JToggleButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JColorChooser;

public class GlavniProzor extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniProzor frame = new GlavniProzor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GlavniProzor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlZaglavlje = new JPanel();
		pnlZaglavlje.setBackground(Color.LIGHT_GRAY);
		pnlZaglavlje.setBounds(0, 0, 884, 45);
		contentPane.add(pnlZaglavlje);
		pnlZaglavlje.setLayout(null);
		
		Crtez pnlCrtez = new Crtez();
		pnlCrtez.setBounds(0, 47, 884, 515);
		contentPane.add(pnlCrtez);
		
		JToggleButton tglTacka = new JToggleButton("Tacka");
		tglTacka.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
		});
		buttonGroup.add(tglTacka);
		tglTacka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlCrtez.setDugme(1);			        
			}
		});
		tglTacka.setBounds(10, 11, 73, 23);
		pnlZaglavlje.add(tglTacka);
		
		JToggleButton tglLinija = new JToggleButton("Linija");
		tglLinija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlCrtez.setDugme(2);
			}
		});
		buttonGroup.add(tglLinija);
		tglLinija.setBounds(93, 11, 72, 23);
		pnlZaglavlje.add(tglLinija);
		
		JToggleButton tglKrug = new JToggleButton("Krug");
		tglKrug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlCrtez.setDugme(3);
			}
		});
		buttonGroup.add(tglKrug);
		tglKrug.setBounds(175, 11, 81, 23);
		pnlZaglavlje.add(tglKrug);
		
		JToggleButton tglKvadrat = new JToggleButton("Kvadrat");
		tglKvadrat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlCrtez.setDugme(4);
			}
		});
		buttonGroup.add(tglKvadrat);
		tglKvadrat.setBounds(266, 11, 81, 23);
		pnlZaglavlje.add(tglKvadrat);
		
		JToggleButton tglPravougaonik = new JToggleButton("Pravougaonik");
		tglPravougaonik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlCrtez.setDugme(5);
			}
		});
		buttonGroup.add(tglPravougaonik);
		tglPravougaonik.setBounds(357, 11, 113, 23);
		pnlZaglavlje.add(tglPravougaonik);
		
		JToggleButton tglBoja = new JToggleButton("Boja");
		tglBoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	          	pnlCrtez.setBoja(JColorChooser.showDialog(null,"Izaberite boju", Color.white));	

			}
		});
		buttonGroup.add(tglBoja);
		tglBoja.setBounds(480, 11, 72, 23);
		pnlZaglavlje.add(tglBoja);
		
		JToggleButton tglPomeri = new JToggleButton("Pomeri");
		buttonGroup.add(tglPomeri);
		tglPomeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlCrtez.setDugme(6);
			}
		});
		tglPomeri.setBounds(562, 11, 88, 23);
		pnlZaglavlje.add(tglPomeri);
		
		JToggleButton tglModifikuj = new JToggleButton("Modifikuj");
		tglModifikuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlCrtez.setDugme(7);
			}
		});
		buttonGroup.add(tglModifikuj);
		tglModifikuj.setBounds(660, 11, 99, 23);
		pnlZaglavlje.add(tglModifikuj);
		
		JToggleButton tglObrisi = new JToggleButton("Obrisi");
		tglObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlCrtez.setDugme(8);
			}
		});
		buttonGroup.add(tglObrisi);
		tglObrisi.setBounds(769, 11, 99, 23);
		pnlZaglavlje.add(tglObrisi);
		
		
		
		
		
		
	}
}
