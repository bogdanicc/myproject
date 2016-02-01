package geometrija;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class Crtez extends JPanel {
	ArrayList lista = new ArrayList();
	private int dugme,click=1,X,Y;
	public Crtez() {
		addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent e) {
				switch(dugme){
				case 1:
				{
					Tacka t1 = new Tacka(e.getX(), e.getY());
					lista.add(t1);
					break;
				}
				case 2:
				{
					if(click==1){
						click=2;
						X=e.getX();
						Y=e.getY();
					}
					else
					{
						click=1;
						Tacka t2=new Tacka(e.getX(), e.getY());
						Linija l1=new Linija(new Tacka(X, Y), t2);
						lista.add(l1);
					}
					break;
				}
				case 3:
				{
					Tacka t1= new Tacka(e.getX(), e.getY());
					DlgKrug dlgk= new DlgKrug();
					dlgk.setVisible(true);
					System.out.println(dlgk.getPoluprecnik());
					Krug k1= new Krug(t1, dlgk.getPoluprecnik(), "PLAVA");
;					lista.add(k1);
					
					break;
				}
				case 4:
				{
					X=e.getX();
					Y=e.getY();
					DlgKvadrat dlgkv= new DlgKvadrat();
					dlgkv.setVisible(true);
					if(dlgkv.getStranica() > 0){
					Kvadrat kv1= new Kvadrat(new Tacka(X, Y), dlgkv.getStranica(),"PLAVA");
					lista.add(kv1);
					}
					break;
				}
				case 5:
				{
					Tacka t1= new Tacka(e.getX(), e.getY());
					DlgPravougaonik dlgp = new DlgPravougaonik();
					dlgp.setVisible(true);
					Pravougaonik p1 = new Pravougaonik(t1, dlgp.getVisina(), dlgp.getStranica());
					lista.add(p1);
					break;
				}
				}
				
			}
		});
	}

	public static void main(String[] args) {
		JFrame prozor = new JFrame();
		prozor.setVisible(true);
		prozor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		prozor.setSize(800, 600);

		Crtez c = new Crtez();
		prozor.getContentPane().add(c);
		//c.setBackground(Color.BLACK);
	}

	public void paint (Graphics g){
		super.paintComponent(g);
		
		Iterator it = lista.iterator();
		
		while(it.hasNext()){
			Oblik o = (Oblik) it.next();
			o.crtajSe(g);
		}
		
		repaint();
		
	}

	public int getDugme() {
		return dugme;
	}

	public void setDugme(int dugme) {
		this.dugme = dugme;
	}

}
