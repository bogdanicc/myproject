package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Oblik {
	private Color boja;
	private boolean selektovan;

	public Oblik() {

	}

	public Oblik(Color boja) {
		this.boja = boja;
	}

	public abstract void crtajSe(Graphics g);

	public abstract boolean sadrzi(int x, int y);

	public abstract void pomeriZa(int x, int y);

	public Color getBoja() {
		return boja;
	}

	public void setBoja(Color boja2) {
		this.boja = boja2;
	}

	public boolean isSelektovan() {
		return selektovan;
	}

	public void setSelektovan(boolean selektovan) {
		this.selektovan = selektovan;
	}
}
