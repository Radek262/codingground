
public class Magazyn {
	public static int stanMagazynu = 0;//maks 120
	public static int ewidencja = 0; //liczba wycietych drzew
	public static void wloz(){ //metoda odpowiadajaca z skladowanie drzewa przez robotnikow w magazynie
		
		if(stanMagazynu < 120) {
			ewidencja ++;
			stanMagazynu++;
			System.out.println("W magazynie jest: "+stanMagazynu);
		}else {System.out.println("Magazyn jest pe³ny");}
	}
	
	public static int bilans() {
		return ewidencja;
	}
	
	public static int stanMagazynu() {
		return stanMagazynu;
	}
	
	public static void czysc() {
		stanMagazynu = stanMagazynu - Ciezarowka.getPojemnoscCiezarowki(); //stanMagazynu ciezarowki
	}
}
