package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public class Tacka extends Oblik implements Comparable{
	private int x;
	private int y;


	public Tacka(){

	}

	public Tacka(int x, int y){
		this.x = x;
		this.y = y;
	}

	public Tacka(int x, int y, Color boja){
		super(boja);
		this.x = x;
		this.y = y;

	}
	
	
	public int compareTo(Object o) {
		Tacka nula = new Tacka(0, 0);
		Tacka nova = (Tacka) o;
		return (int) (this.udaljenost(nula) - nova.udaljenost(nula));
	}
	
	public void selektovan(Graphics g){
		g.setColor(Color.BLUE);
		g.drawRect(x-2, y-2, 4, 4);
		
	}

	public boolean sadrzi(int x,int y){
		if(x>=this.x-6 && x<=this.x+6 && y>=this.y-6 && y<=this.y+6)
			return true;
		else
			return false;
	}

	public void crtajSe(Graphics g) {
		g.setColor(getBoja());
		g.drawLine(x-2, y, x+2, y); 
		g.drawLine(x, y-2, x, y+2);
		
		if(isSelektovan())
			selektovan(g);
	}

	public boolean equals(Object obj){
		if (obj instanceof Tacka){
			Tacka pomocna = (Tacka) obj;
			if(pomocna.getX() == this.x &&
					pomocna.getY() == this.y)
				return true;
		}

		return false;
	}

	public String toString(){
		// (x,y)
		return "("+x+","+this.y+")";
	}

	public void pomeriNa(int novoX, int y) {
		x = novoX;
		this.y = y;
	}
	public void pomeriZa(int poX, int poY) {
		x += poX;
		y = y + poY;
	}

	public double udaljenost(Tacka t) {
		int dx = this.x - t.x;
		int dy = this.getY() - t.getY();
		double d = Math.sqrt(dx * dx + dy * dy);
		return d;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	



}
