
public class Ciezarowka extends Thread {
	
	static int pojemnoscCiezarowki = 10;
	static int liczbaKurs�w = 0; //liczba podejsc leniwego kierowcy
	
	public static int getPojemnoscCiezarowki() {
		return pojemnoscCiezarowki;
	}
	
	public void run() {
		while(true) {
			int stan = Magazyn.stanMagazynu();
				if (stan >= pojemnoscCiezarowki) {
					System.out.println("ci�zarowka zabiera " +pojemnoscCiezarowki+ " drzewa z Magazynu");
					Magazyn.czysc();
					liczbaKurs�w ++;
					System.out.println("W magazynie zosta�o "+Magazyn.stanMagazynu());
					try {												//czas drogi ciezarowki do tartaku
						sleep((long)(Math.random()*10));
					}catch(InterruptedException e) {e.printStackTrace();}
					
				}else {System.out.println("Ci�ar�wka czeka a� magazyn b�dzie pe�ny, kierowca idzie spa�,"
					+ " w magazynie jest: "+ stan);
					try {
						sleep(10);
					}catch(InterruptedException e) {e.printStackTrace();}
				if (liczbaKurs�w == 4) {
					System.out.println("ci�ar�wka ju� nie przyjedzie");
					System.exit(0);
				}
			}
		}
	}
}
