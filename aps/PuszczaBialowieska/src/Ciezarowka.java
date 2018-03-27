
public class Ciezarowka extends Thread {
	
	static int pojemnoscCiezarowki = 10;
	static int liczbaKursów = 0; //liczba podejsc leniwego kierowcy
	
	public static int getPojemnoscCiezarowki() {
		return pojemnoscCiezarowki;
	}
	
	public void run() {
		while(true) {
			int stan = Magazyn.stanMagazynu();
				if (stan >= pojemnoscCiezarowki) {
					System.out.println("ciêzarowka zabiera " +pojemnoscCiezarowki+ " drzewa z Magazynu");
					Magazyn.czysc();
					liczbaKursów ++;
					System.out.println("W magazynie zosta³o "+Magazyn.stanMagazynu());
					try {												//czas drogi ciezarowki do tartaku
						sleep((long)(Math.random()*10));
					}catch(InterruptedException e) {e.printStackTrace();}
					
				}else {System.out.println("Ciê¿arówka czeka a¿ magazyn bêdzie pe³ny, kierowca idzie spaæ,"
					+ " w magazynie jest: "+ stan);
					try {
						sleep(10);
					}catch(InterruptedException e) {e.printStackTrace();}
				if (liczbaKursów == 4) {
					System.out.println("ciê¿arówka ju¿ nie przyjedzie");
					System.exit(0);
				}
			}
		}
	}
}
