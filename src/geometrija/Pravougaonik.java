package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public class Pravougaonik extends Kvadrat {
	private int sirina;


	public Pravougaonik(){

	}

	public Pravougaonik(Tacka goreLevo, int visina, int sirina){
		super(goreLevo,visina);
		this.sirina = sirina;
	}

	public Pravougaonik(Tacka goreLevo, int visina, int sirina,Color boja){
		this(goreLevo,visina,sirina);
		setBoja(boja);
	}
	
	public void popuni(Graphics g) {
		g.setColor(getBojaUnutrasnjosti());
		g.fillRect(goreLevo.getX()+1, goreLevo.getY()+1, stranica-1, sirina-1);


	}
	
	public boolean sadrzi(int x, int y) {
		if(goreLevo.getX()<=x && goreLevo.getX()+stranica>=x &&
				goreLevo.getY()<=y && goreLevo.getY()+sirina>=y)
			return true;
		else
			return false;
	}
	
	public void selektovan(Graphics g){
		g.setColor(Color.BLUE);
		new Linija(goreLevo, new Tacka(goreLevo.getX()+stranica, goreLevo.getY())).selektovan(g);
		new Linija(goreLevo, new Tacka(goreLevo.getX(), goreLevo.getY()+sirina)).selektovan(g);
		new Linija(new Tacka(goreLevo.getX(), goreLevo.getY()+sirina),
					new Tacka(goreLevo.getX()+stranica, goreLevo.getY()+sirina)).selektovan(g);
		new Linija(new Tacka(goreLevo.getX()+stranica, goreLevo.getY()+sirina),
				new Tacka(goreLevo.getX()+stranica, goreLevo.getY())).selektovan(g);
	
		
		
	}
	
	
	public void crtajSe(Graphics g) {
		g.setColor(getBoja());
		g.drawRect(goreLevo.getX(), goreLevo.getY(), stranica, sirina);
		if(isSelektovan())
			selektovan(g);
	}

	public Linija dijagonala(){
		int xDoleDesno = goreLevo.getX()+stranica;
		int yDoleDesno = goreLevo.getY()+sirina;
		Linija dijagonala = new Linija(goreLevo, new Tacka(xDoleDesno, yDoleDesno));
		return dijagonala;
	}

	public String toString(){
		// Gornji levi ugao = (x,y), Visina = visina, Sirina = sirina
		return "Gornji levi ugao = "+goreLevo+", Visina = "+stranica+", Sirina = "+sirina;
	}

    public boolean equals(Object obj){
    	if(obj instanceof Pravougaonik){
    		Pravougaonik pomocni = (Pravougaonik) obj;
    		if (pomocni.goreLevo.equals(goreLevo) && 
    				pomocni.sirina == sirina && 
    				pomocni.stranica == stranica)
    			return true;
    		
    	}
    	
    	return false;
    }

	public double obim(){
		return 2 * stranica + 2 * sirina;
	}

	public double povrsina(){
		return stranica * sirina;
	}


	public int getSirina() {
		return sirina;
	}
	public void setSirina(int sirina) {
		this.sirina = sirina;
	}




}
