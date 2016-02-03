package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public abstract class PovrsinskiOblik extends Oblik {
	private Color bojaUnutrasnjosti = Color.white;

	public PovrsinskiOblik() {

	}

	public PovrsinskiOblik(Color bojaUnutrasnjosti) {
		this.bojaUnutrasnjosti = bojaUnutrasnjosti;
	}

	public abstract void popuni(Graphics g);

	public abstract double obim();

	public abstract double povrsina();

	public abstract boolean sadrzi(int x, int y);

	public Color getBojaUnutrasnjosti() {
		return bojaUnutrasnjosti;
	}

	public void setBojaUnutrasnjosti(Color bojaUnutrasnjosti) {
		this.bojaUnutrasnjosti = bojaUnutrasnjosti;
	}

}
