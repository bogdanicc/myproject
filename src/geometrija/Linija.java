package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public class Linija extends Oblik implements Comparable{
	private Tacka tPocetna;
	private Tacka tKrajnja;
	
	
	public Linija(){
		
	}
	
	public Linija(Tacka tPocetna, Tacka tKrajnja){
		this.tPocetna = tPocetna;
		this.tKrajnja = tKrajnja;
	}
	
	public Linija(Tacka tPocetna, Tacka tKrajnja, String boja){
		super(boja);
		this.tPocetna = tPocetna;
		this.tKrajnja = tKrajnja;
		
	}
	
	public int compareTo(Object o) {
		Linija nova = (Linija) o;
		return (int) (this.duzina()- nova.duzina());
	}
	
	public void selektovan (Graphics g){
		g.setColor(Color.BLUE);
		tPocetna.selektovan(g);
		tKrajnja.selektovan(g);
		sredinaLinije().selektovan(g);
		
		
	}
	
	
	public Tacka sredinaLinije(){
		int xCentar = (tPocetna.getX()+tKrajnja.getX())/2;
		int yCentar = (tPocetna.getY()+tKrajnja.getY())/2;
		Tacka centar = new Tacka(xCentar,yCentar);
		return centar;
	}
	
	
	public void crtajSe(Graphics g) {
		g.setColor(pronadjiBoju(getBoja()));
		g.drawLine(tPocetna.getX(), tPocetna.getY(), 
				tKrajnja.getX(), tKrajnja.getY());
		if(isSelektovan())
			selektovan(g);
	}
	
	public boolean equals (Object obj){
		if(obj instanceof Linija){
			Linija pomocna = (Linija)obj;
			if(this.gettPocetna().equals(pomocna.gettPocetna())&&
					this.gettKrajnja().equals(pomocna.gettKrajnja()))
				return true;
			else 
				return false;
		
		}else 
			return false;
	}
	
	
	
	public String toString(){
		// (xp,yp)-->(xk,yk)
		return tPocetna+"-->"+tKrajnja;
	}
	
	
	public void pomeriZa(int x, int y){
		tPocetna.pomeriZa(x, y);
		tKrajnja.pomeriZa(x, y);
	}
	
	public double duzina(){
		return tPocetna.udaljenost(tKrajnja);
	}

	public Tacka gettPocetna() {
		return tPocetna;
	}
	public void settPocetna(Tacka tPocetna) {
		this.tPocetna = tPocetna;
	}
	public Tacka gettKrajnja() {
		return tKrajnja;
	}
	public void settKrajnja(Tacka tKrajnja) {
		this.tKrajnja = tKrajnja;
	}

	

	



}
