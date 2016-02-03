package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public class Krug extends PovrsinskiOblik {
	private Tacka centar;
	private int radius;

	public Krug() {

	}

	public Krug(Tacka centar, int radius) {
		this.centar = centar;
		this.radius = radius;

	}

	public Krug(Tacka centar, int radius, Color boja) {
		setBoja(boja);
		this.centar = centar;
		this.radius = radius;

	}

	public boolean sadrzi(int x, int y) {
		Tacka nova = new Tacka(x, y);
		if (nova.udaljenost(centar) <= radius)
			return true;
		else
			return false;
	}

	public void popuni(Graphics g) {
		g.setColor(getBojaUnutrasnjosti());
		g.fillOval(centar.getX() - radius + 1, centar.getY() - radius + 1, 2 * radius - 2, 2 * radius - 2);

	}

	public void selektovan(Graphics g) {
		g.setColor(Color.BLUE);
		centar.selektovan(g);
		new Tacka(centar.getX() + radius, centar.getY()).selektovan(g);
		new Tacka(centar.getX() - radius, centar.getY()).selektovan(g);
		new Tacka(centar.getX(), centar.getY() + radius).selektovan(g);
		new Tacka(centar.getX(), centar.getY() - radius).selektovan(g);
	}

	public void crtajSe(Graphics g) {
		g.setColor(getBoja());
		g.drawOval(centar.getX() - radius, centar.getY() - radius, 2 * radius, 2 * radius);

		if (isSelektovan())
			selektovan(g);
	}

	public boolean equals(Object obj) {
		if (obj instanceof Krug) {
			Krug pomocni = (Krug) obj;
			if (this.getCentar().equals(pomocni.getCentar()) && this.getRadius() == pomocni.getRadius())
				return true;

		}
		return false;
	}

	public String toString() {
		// Centar = (x,y), Radius = radius
		return "Centar = " + centar + ", Radius = " + radius;
	}

	public void pomeriNa(int x, int y) {
		centar.pomeriNa(x, y);
	}

	public void pomeriZa(int x, int y) {
		centar.pomeriZa(x, y);
	}

	public double obim() {
		return 2 * radius * Math.PI;
	}

	public double povrsina() {
		return radius * radius * Math.PI;
	}

	public Tacka getCentar() {
		return centar;
	}

	public void setCentar(Tacka centar) {
		this.centar = centar;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

}
