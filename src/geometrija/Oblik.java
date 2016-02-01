package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Oblik {
	private String boja;
	private boolean selektovan;
	
	public Oblik(){

	}

	public Oblik(String boja){
		this.boja = boja;
	}
	
	public static Color pronadjiBoju(String boja){
		if(boja != null){
			if(boja.equalsIgnoreCase("CRNA"))
				return Color.BLACK;
			if(boja.equalsIgnoreCase("bela"))
				return Color.WHITE;
			if(boja.equalsIgnoreCase("ZeLeNa"))
				return Color.GREEN;
			if(boja.equalsIgnoreCase("plava"))
				return Color.BLUE;
			if(boja.equalsIgnoreCase("zuta"))
				return Color.YELLOW;
			if(boja.equalsIgnoreCase("crvena"))
				return Color.RED;
		}
		return Color.BLACK;
	}
	
	public abstract void crtajSe(Graphics g);

	public String getBoja() {
		return boja;
	}

	public void setBoja(String boja) {
		this.boja = boja;
	}

	public boolean isSelektovan() {
		return selektovan;
	}

	public void setSelektovan(boolean selektovan) {
		this.selektovan = selektovan;
	}
}
