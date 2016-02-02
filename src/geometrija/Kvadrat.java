package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public class Kvadrat extends PovrsinskiOblik {
	protected Tacka goreLevo;
	protected int stranica;


	public Kvadrat(){

	}

	public Kvadrat(Tacka goreLevo, int stranica){
		this.goreLevo = goreLevo;
		this.stranica = stranica;
	}

	public Kvadrat(Tacka goreLevo, int stranica, Color boja){
		setBoja(boja);
		this.goreLevo = goreLevo;
		this.stranica = stranica;

	}



	public boolean sadrzi(int x, int y) {
		if(goreLevo.getX()<=x && goreLevo.getX()+stranica>=x &&
				goreLevo.getY()<=y && goreLevo.getY()+stranica>=y)
			return true;
		else
			return false;
	}


	public void popuni(Graphics g) {
		g.setColor(getBojaUnutrasnjosti());
		g.fillRect(goreLevo.getX()+1, goreLevo.getY()+1, stranica-1, stranica-1);


	}

	public void selektovan (Graphics g){
		g.setColor(Color.BLUE);
		new Linija(goreLevo, new Tacka(goreLevo.getX()+stranica, goreLevo.getY())).selektovan(g);
		new Linija(goreLevo, new Tacka(goreLevo.getX(), goreLevo.getY()+stranica)).selektovan(g);
		new Linija(new Tacka(goreLevo.getX(), goreLevo.getY()+stranica),
				new Tacka(goreLevo.getX()+stranica, goreLevo.getY()+stranica)).selektovan(g);
		new Linija(new Tacka(goreLevo.getX()+stranica, goreLevo.getY()+stranica),
				new Tacka(goreLevo.getX()+stranica, goreLevo.getY())).selektovan(g);
	}

	public void crtajSe(Graphics g) {
		g.setColor(getBoja());
		g.drawRect(goreLevo.getX(), goreLevo.getY(), stranica, stranica);
		if(isSelektovan())
			selektovan(g);
	}

	public boolean equals(Object obj){
		if(obj instanceof Kvadrat){
			Kvadrat pomocni = (Kvadrat) obj;
			if(pomocni.getGoreLevo().equals(this.goreLevo) && 
					pomocni.stranica == this.stranica)
				return true;
		}
		return false;
	}

	public String toString(){
		// Gornji levi ugao = (x,y), Stranica = stranica
		return "Gornji levi ugao = "+goreLevo+", Stranica = "+stranica;
	}

	public Linija dijagonala() {
		int xDoleDesno = goreLevo.getX() + stranica;
		int yDoleDesno = goreLevo.getY() + stranica;
		Linija dijagonala = new Linija(goreLevo, new Tacka(xDoleDesno, yDoleDesno));
		return dijagonala;
	}

	public Tacka centar(){
		return this.dijagonala().sredinaLinije();
	}


	public void pomeriNa(int x, int y){
		goreLevo.pomeriNa(x, y);
	}

	public void pomeriZa(int x, int y){
		goreLevo.pomeriZa(x, y);
	}

	public double obim(){
		return 4 * stranica;
	}

	public double povrsina(){
		return stranica * stranica;
	}

	public Tacka getGoreLevo() {
		return goreLevo;
	}
	public void setGoreLevo(Tacka goreLevo) {
		this.goreLevo = goreLevo;
	}
	public int getStranica() {
		return stranica;
	}
	public void setStranica(int stranica) {
		this.stranica = stranica;
	}

}
