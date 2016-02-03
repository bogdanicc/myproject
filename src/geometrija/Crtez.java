package geometrija;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class Crtez extends JPanel {
	ArrayList<Oblik> lista = new ArrayList<Oblik>();
	ArrayList<Oblik> listaSel = new ArrayList<Oblik>();
	ArrayList<Oblik> listaSelKon = new ArrayList<Oblik>();
	private int dugme, click = 1, X, Y;
	private Color boja;

	public Crtez() {

		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				switch (dugme) {
				case 1: {
					Tacka t1 = new Tacka(e.getX(), e.getY(), boja);
					lista.add(t1);
					break;
				}
				case 2: {
					if (click == 1) {
						click = 2;
						X = e.getX();
						Y = e.getY();
					} else {
						click = 1;
						Tacka t2 = new Tacka(e.getX(), e.getY());
						Linija l1 = new Linija(new Tacka(X, Y), t2, boja);
						lista.add(l1);
					}
					break;
				}
				case 3: {
					Tacka t1 = new Tacka(e.getX(), e.getY());
					DlgKrug dlgk = new DlgKrug();
					dlgk.setVisible(true);
					if (dlgk.getPoluprecnik() > 0) {
						Krug k1 = new Krug(t1, dlgk.getPoluprecnik(), dlgk.getOkvir());
						k1.setBojaUnutrasnjosti(dlgk.getUnutrasnjost());
						lista.add(k1);
					}
					break;
				}
				case 4: {
					X = e.getX();
					Y = e.getY();
					DlgKvadrat dlgkv = new DlgKvadrat();
					dlgkv.setVisible(true);
					if (dlgkv.getStranica() > 0) {
						Kvadrat kv1 = new Kvadrat(new Tacka(X, Y), dlgkv.getStranica(), dlgkv.getOkvir());
						kv1.setBojaUnutrasnjosti(dlgkv.getUnutrasnjost());
						lista.add(kv1);
						dlgkv.setVisible(false);
					}
					break;

				}
				case 5: {
					Tacka t1 = new Tacka(e.getX(), e.getY());
					DlgPravougaonik dlgp = new DlgPravougaonik();
					dlgp.setVisible(true);
					if (dlgp.getStranica() > 0 && dlgp.getVisina() > 0) {
						Pravougaonik p1 = new Pravougaonik(t1, dlgp.getVisina(), dlgp.getStranica(), dlgp.getOkvir());
						p1.setBojaUnutrasnjosti(dlgp.getUnutrasnjost());
						lista.add(p1);
					}
					break;
				}
				case 6: {
					selectObject(e.getX(), e.getY());
					DlgPomeri dlgp = new DlgPomeri();
					dlgp.setVisible(true);
					if (dlgp.isStanje())
						listaSelKon.get(0).pomeriZa(dlgp.getPomeriX(), dlgp.getPomeriY());
					else if (dlgp.getX() > 0 && dlgp.getY() > 0 && !(dlgp.isStanje()))
						listaSelKon.get(0).pomeriNa(dlgp.getX(), dlgp.getY());
					break;
				}
				case 7: {
					selectObject(e.getX(), e.getY());
					if (listaSelKon.get(0) instanceof Krug) {
						DlgKrug dlgk = new DlgKrug();
						dlgk.setVisible(true);
						if (dlgk.getPoluprecnik() > 0) {
							((Krug) listaSelKon.get(0)).setBojaUnutrasnjosti(dlgk.getUnutrasnjost());
							((Krug) listaSelKon.get(0)).setRadius(dlgk.getPoluprecnik());
							((Krug) listaSelKon.get(0)).setBoja(dlgk.getOkvir());
						}
					} else if (listaSelKon.get(0) instanceof Pravougaonik) {
						DlgPravougaonik dlgp = new DlgPravougaonik();
						dlgp.setVisible(true);
						if (dlgp.getStranica() > 0 && dlgp.getVisina() > 0) {
							((Pravougaonik) listaSelKon.get(0)).setBojaUnutrasnjosti(dlgp.getUnutrasnjost());
							((Pravougaonik) listaSelKon.get(0)).setBoja(dlgp.getOkvir());
							((Pravougaonik) listaSelKon.get(0)).setStranica(dlgp.getVisina());
							((Pravougaonik) listaSelKon.get(0)).setSirina(dlgp.getStranica());
						}
					} else if (listaSelKon.get(0) instanceof Kvadrat) {
						DlgKvadrat dlgkv = new DlgKvadrat();
						dlgkv.setVisible(true);
						if (dlgkv.getStranica() > 0) {
							((Kvadrat) listaSelKon.get(0)).setBojaUnutrasnjosti(dlgkv.getUnutrasnjost());
							((Kvadrat) listaSelKon.get(0)).setBoja(dlgkv.getOkvir());
							((Kvadrat) listaSelKon.get(0)).setStranica(dlgkv.getStranica());
						}
					} else if (listaSelKon.get(0) instanceof Linija) {
						DlgLinija dlgl = new DlgLinija();
						dlgl.setVisible(true);
						if (new Linija(new Tacka(dlgl.getXTpocetno(), dlgl.getYTpocetno()),
								new Tacka(dlgl.getXTkrajnje(), dlgl.getYTkrajnje())).duzina() > 0) {
							((Linija) listaSelKon.get(0)).setBoja(dlgl.getBoja());
							((Linija) listaSelKon.get(0))
									.settPocetna(new Tacka(dlgl.getXTpocetno(), dlgl.getYTpocetno()));
							((Linija) listaSelKon.get(0))
									.settKrajnja(new Tacka(dlgl.getXTkrajnje(), dlgl.getYTkrajnje()));
						}
					} else if (listaSelKon.get(0) instanceof Tacka) {
						((Tacka) listaSelKon.get(0))
								.setBoja(JColorChooser.showDialog(null, "Izaberite boju tacke", Color.white));
					}
					break;
				}
				case 8: {
					selectObject(e.getX(), e.getY());
					DlgObrisi dlgo = new DlgObrisi();
					dlgo.setVisible(true);
					if (dlgo.isOdg()) {
						lista.removeAll(listaSelKon);
					}
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
		// c.setBackground(Color.BLACK);
	}

	public void selectObject(int x, int y) {
		Iterator it = lista.iterator();
		listaSelKon.clear();
		listaSel.clear();
		while (it.hasNext()) {
			Oblik o = (Oblik) it.next();
			o.setSelektovan(false);
			if (o instanceof Tacka) {
				if (o.sadrzi(x, y)) {
					listaSel.add(o);
				}
			} else if (o instanceof Linija) {
				if (o.sadrzi(x, y)) {
					listaSel.add(o);
				}
			} else if (o instanceof Krug) {
				if (o.sadrzi(x, y)) {
					listaSel.add(o);
				}
			} else if (o instanceof Kvadrat) {
				if (o.sadrzi(x, y)) {
					listaSel.add(o);
				}
			} else if (o instanceof Pravougaonik) {
				if (o.sadrzi(x, y)) {
					listaSel.add(o);
				}
			}
		}
		if (listaSel.size() > 1) {
			listaSel.get(listaSel.size() - 1).setSelektovan(true);
			listaSelKon.add(listaSel.get(listaSel.size() - 1));
		} else if (listaSel.size() == 1) {
			listaSel.get(0).setSelektovan(true);
			listaSelKon.add(listaSel.get(0));
		}
	}

	public void paint(Graphics g) {
		super.paintComponent(g);

		Iterator it = lista.iterator();

		while (it.hasNext()) {
			Oblik o = (Oblik) it.next();
			if (o instanceof Krug) {
				((Krug) o).popuni(g);
			}
			if (o instanceof Kvadrat) {
				((Kvadrat) o).popuni(g);
			}
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

	public Color getBoja() {
		return boja;
	}

	public void setBoja(Color boja) {
		this.boja = boja;
	}

}
