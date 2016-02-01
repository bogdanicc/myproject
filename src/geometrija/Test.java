package geometrija;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Tacka t1 = new Tacka();
		Tacka t2 = new Tacka();
		t1.setX(10);
		t1.setY(15);
		t2.setX(50);
		t2.setY(100);
		System.out.println("X koordinata t1 je: "+t1.getX());
		System.out.println("Y koordinata t1 je: "+t1.getY());
		
		t1.pomeriNa(20, 30);
		t1.pomeriZa(10, 5);
		t1.udaljenost(t2);
		System.out.println("Udaljenost je: "+t1.udaljenost(t2));
		System.out.println("Udaljenost je: "+t2.udaljenost(t1));
		
		
		System.out.println("X koordinata t1 je: "+t1.getX());
		System.out.println("Y koordinata t1 je: "+t1.getY());
		
		System.out.println("X koordinata t2 je: "+t2.getX());
		System.out.println("Y koordinata t2 je: "+t2.getY());
		
		// postaviti X koordinatu tacke t1 na vrednost Y koordinate tacke t2
		t1.setX(t2.getY());
		System.out.println("\nX koordinata t1 je: "+t1.getX());
		
		//Pomeriti tacku t1 na sledeci nacin:
				// Xt1 --> Yt1
				// Yt1 --> Xt1 + Xt2
		System.out.println("\nXt1 je: "+t1.getX());
		System.out.println("Yt1 je: "+t1.getY());
		
		System.out.println("\nXt2 je: "+t2.getX());
		System.out.println("Yt2 je: "+t2.getY());
		
		t1.pomeriNa(t1.getY(), t1.getX()+t2.getX());
		
		System.out.println("\nX koordinata t1 nakon pomeriNa je: "+t1.getX());
		System.out.println("Y koordinata t1 nakon pomeriNa je: "+t1.getY());
		
		Linija l1 = new Linija();
		l1.settPocetna(t1);
		l1.settKrajnja(t2);
		System.out.println("X koordinata pocetne tacke linije je:  "+l1.gettPocetna().getX());
		
		l1.pomeriZa(10, 15);
		System.out.println("Y koordinata pocetne tacke linije je: " +l1.gettPocetna().getY());
		
		Pravougaonik p1= new Pravougaonik();
		System.out.println("visina pravougaonika je: "+p1.getVisina());
		System.out.println("sirina pravougaonika je: "+p1.getSirina());
		
		p1.setGoreLevo(t2);
		p1.pomeriNa(10, 15);
		
		System.out.println("X koordinata tacke gore levo pravougaonika je: "+p1.getGoreLevo().getX());
		System.out.println("Y koordinata tacke gore levo pravougaonika je: "+p1.getGoreLevo().getY());
		
		//Postaviti vrednost Y koordinate tacke GoreLevo pravougaonika na vrednost
		//zbira x koord. tacke t2 i y koord. pocetne tacke linije l1
		p1.getGoreLevo().setY(t2.getX()+l1.gettPocetna().getY());
		
		System.out.println("Y koordinata tacke gore levo je: "+p1.getGoreLevo().getY());
		p1.setSirina(12);
		p1.setVisina(15);
		
		p1.getGoreLevo().setX(p1.povrsina());
		
		System.out.println("X koordinata tacke gore levo je: "+p1.getGoreLevo().getX());
		
		System.out.println("Obim pravougaonika je: " + p1.obim());
		
		p1.pomeriNa(20, 30);
		
		System.out.println("X koordinata tacke gore levo pravougaonika je: "+p1.getGoreLevo().getX());
		System.out.println("Y koordinata tacke gore levo pravougaonika je: "+p1.getGoreLevo().getY());
		
		p1.pomeriZa(100, 200);
		
		System.out.println("X koordinata tacke gore levo pravougaonika je: "+p1.getGoreLevo().getX());
		System.out.println("Y koordinata tacke gore levo pravougaonika je: "+p1.getGoreLevo().getY());
		
		Kvadrat kv1= new Kvadrat();
		
		kv1.setGoreLevo(t1);
		kv1.pomeriNa(200, 300);
		kv1.setStranica(234);
		
		System.out.println("X koordinata tacke gore levo kvadrata je: "+kv1.getGoreLevo().getX());
		System.out.println("Y koordinata tacke gore levo kvadrata je: "+kv1.getGoreLevo().getY());
		System.out.println("Stranica kvadrata je: "+kv1.getStranica());
		
		System.out.println("Obim kvadrata je: "+kv1.obim());
		System.out.println("Povrsina kvadrata je: "+kv1.povrsina());
		
		// Pomeriti tacku goreLevo kvadrata ZA vrednost obima kvadrata po x i 
		// za vrdnost polovine povrsine kvadrata po y
		kv1.pomeriZa(kv1.obim(), kv1.povrsina()/2);
		System.out.println("X koordinata tacke gore levo kvadrata je: "+kv1.getGoreLevo().getX());
		System.out.println("Y koordinata tacke gore levo kvadrata je: "+kv1.getGoreLevo().getY());
		
		Krug k1=new Krug();
		
		k1.setCentar(t2);
		k1.setRadius(66);
		double O =k1.obim();
		double P= k1.povrsina();
	
		System.out.println("Obim kruga je: "+O+"\nPovrsina kruga je: "+P);
		
		//pomeriti centar kruga na vrednost polovine obima kvadrata po x,i trecine povrsine pravouganika po y
		
		k1.pomeriNa(kv1.obim()/2,p1.povrsina()/3);
		System.out.println("X koordinata centra kruga je: "+k1.getCentar().getX());
		System.out.println("Y koordinata centra kruga je: "+k1.getCentar().getY());
		
		// postaviti X koordinatu tacke gore levo pravougaonika na vrednost 
		// zbira: 
		// cetvrtine povrsine kruga,
		// trecine obima kruga,
		// kolicnika 
		//		vrednosti X koordinate pocetne tacke linije
		// 		i Y koordinate krajnje tacke linije
		
		p1.getGoreLevo().setX( ((int)(k1.povrsina()/4 + k1.obim()/3) + (l1.gettPocetna().getX() / l1.gettKrajnja().getY()) ) );
		System.out.println("Vrednost izraza je: "+(k1.povrsina()/4 + k1.obim()/3) + (l1.gettPocetna().getX() / l1.gettKrajnja().getY()));
		System.out.println("X koo. tacke goreLevo je: "+p1.getGoreLevo().getX());
		
		Tacka t1 = new Tacka(10, 15);
		System.out.println("X koordinata t1: "+t1.getX());
		
		Tacka t2 = new Tacka(13,12,"PLAVA");
		System.out.println("Boja tacke t2 je: "+t2.getBoja());
		
		Linija l1 = new Linija(t1, t2, "ZUTA");
		System.out.println("X koordinatu pocetne tacke linije: "+
		l1.gettPocetna().getX());
		
		// postaviti boju linije l1 na boju krajnje tacke linje l1
		
		l1.setBoja(l1.gettKrajnja().getBoja());
		
		
		System.out.println("Boja pocetne tacke linije l1: "+
		l1.gettPocetna().getBoja());
		
		System.out.println("Boja linije l1: "+l1.getBoja());
		
		Pravougaonik p1 = new Pravougaonik(t1, 50, 25, "CRVENA");
		//System.out.println("Visina p1 je: "+p1.getVisina()+"\nSirina p1 je: "+p1.getSirina());
		
		// Kreirati kvadrat kv1:
		//		X gore levo = 10
		//		Y gore levo = 15
		//		stranica = 50
		// 		boja = ZELENA
		
		Kvadrat kv1 = new Kvadrat(new Tacka(10, 15), 50, "ZELENA");
		System.out.println("X koordinata tacke gore levo: "+kv1.getGoreLevo().getX());
		kv1.getGoreLevo().setX(50);
		System.out.println("X koordinata tacke gore levo: "+kv1.getGoreLevo().getX());
		
		//Kreirati pravougaonik p5:
		//	tacka goreLevo: Xt1 + Xt2, Yt1 - Yt2, boja linije l1
		//	sirina: duzina linije l1
		//	visina: vrednost udaljenosti tacaka t1 i t2
		//	boja: Boja krajnje tacke linije l1
		
		Pravougaonik p5 = new Pravougaonik(new Tacka(t1.getX()+t2.getX(), t1.getY()-t2.getY(), l1.getBoja()),
				(int)l1.duzina(), (int)t1.udaljenost(t2), l1.gettKrajnja().getBoja());
		System.out.println("Y koordinata tacke goreLevo od p5: "+p5.getGoreLevo().getY());
		
		System.out.println("X koordinata sredisnje tacke linije je: "+
		l1.sredinaLinije().getX());
		
		
		System.out.println("x koordinata krajnje tacke dijagonale pravougaonika je: "+
		p5.dijagonala().gettKrajnja().getX());
		
		System.out.println("Y koordinata centra pravougaonika je: "+
		p5.centar().getY());
		
		System.out.println(t1);
		System.out.println(l1);
		System.out.println(kv1);
		System.out.println(new Pravougaonik(t1, 100, 50));
		System.out.println(new Krug(t2, 65));
		
		Pravougaonik p6 = new Pravougaonik(t1, 75, 65, "PLAVA");
		System.out.println("Boja p6: "+p6.getBoja());
		
		Kvadrat kv2 = new Kvadrat(t2, 55,"ZELENA");
		System.out.println("Boja kv2: "+kv2.getBoja());
		
		System.out.println("Pravougaonik: "+p6);
		System.out.println("Kvadrat: "+kv2);
		
		p6.pomeriNa(30, 30);
		kv2.pomeriNa(40, 40);
		
		System.out.println("Pravougaonik nakon pomeranja: "+p6);
		System.out.println("Kvadrat nakon pomeranja: "+kv2);
		
		System.out.println("X koordinata tacke doleDesno pravougaonika p6 je: "+p6.dijagonala().gettKrajnja().getX()+
				"\nY koordinata tacke doleDesno pravougaonika p6 je: "+p6.dijagonala().gettKrajnja().getY());
		
		Krug k3 = new Krug(t1, 20,"ZUTA");
		
		System.out.println("Boja kruga k3 je: "+k3.getBoja());
		
		Kvadrat kv3 = new Kvadrat(t1, 50, "ZELENA");
		System.out.println(kv3);
		kv3.pomeriZa(3, 3);
		System.out.println(kv3);
		
		Pravougaonik p7 = new Pravougaonik(t1,30, 50, "PLAVA");
		Pravougaonik p8 = new Pravougaonik(t2,40, 60);
		System.out.println(p7 + "\n"+p8);
		System.out.println("Boja pravougaonika p7 je: "+p7.getBoja());
		System.out.println("Boja pravougaonika p8 je: "+p8.getBoja());
		
		
		Tacka t10 = new Tacka(11, 15);
		Tacka t11 = new Tacka(10, 15);
		System.out.println(t11.equals(t10));
		
		Linija l10 = new Linija(t10, t11, "ZUTA");
		Linija l11 = new Linija(t10, t11, "ZUTA");
		
		System.out.println("Linije su jednake! "+l10.equals(l11));
		
		Pravougaonik p10 = new Pravougaonik(t10, 50, 100);
		Pravougaonik p11 = new Pravougaonik(t10, 50, 75);
		System.out.println("Pravougaonici su jednaki! "+ p10.equals(p11));
		
		Kvadrat kv10 = new Kvadrat(t10, 50);
		Kvadrat kv11 = new Kvadrat(t10, 25);
		
		System.out.println("Kvadrati su jednaki:" +kv10.equals(kv11));
		
		Krug kr10 = new Krug(t10, 10);
		Krug kr11 = new Krug(t10, 11);
		
		System.out.println("Krugovi su jednaki: "+kr10.equals(kr11));
		*/
		
		Tacka t5 = new Tacka(50, 50);
		Tacka t6 = new Tacka(100, 100);
		Tacka t7 = new Tacka(200, 200);
		
		Tacka nizTacaka[] = new Tacka[3];
		nizTacaka[0] = t7;
		nizTacaka[1] = t5;
		nizTacaka[2] = t6;
		
		System.out.println("Nesortiran niz");
		for (int i=0; i<nizTacaka.length; i++){
			
			System.out.println(nizTacaka[i]);
		}
		
		Arrays.sort(nizTacaka);
		
		System.out.println("Sortiran niz");
		for (int i=0; i<nizTacaka.length; i++){
			
			System.out.println(nizTacaka[i]);
		}
		
		Linija l6 = new Linija(t6, t5, "ZUTA");
		
		Linija l7 = new Linija(new Tacka(50, 100), t5, "CRVENA");
		
		Linija l8 = new Linija(new Tacka(75, 85), new Tacka(t5.getX(), t6.getY()), t6.getBoja());
		
		
		
		Linija nizLinija[] = new Linija[3];
		nizLinija[0] = l6;
		nizLinija[1] = l8;
		nizLinija[2] = l7;
		
		System.out.println("Nesortiran niz");
		for (int i=0; i<nizLinija.length; i++){
			
			System.out.println(nizLinija[i]);
		}
		
		Arrays.sort(nizLinija);
		
		System.out.println("Sortiran niz");
		for (int i=0; i<nizLinija.length; i++){
			
			System.out.println(nizLinija[i]);
		}
	}

}
