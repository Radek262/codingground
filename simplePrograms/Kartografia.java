/* Nazwa: Kartografia.java
   
Autor: Radosław Dunin-Wąsowicz  (c) 2016
   
Album: 192663
   Grupa: KrDZIs2012
   
Opis: 
    Program wylicza odleglosci pomiedzy Krakowem, Kocmierzowem i Koscieliskiem. W tym celu wykorzystano metody
    z klasy Math, obiekty, oraz algorytm do wyliczania odleglosci (ortodromy)
     zaczerpniety z strony: https://pl.wikipedia.org/wiki/Ortodroma.
   
 Kompilacja: javac Kartografia.java
    
Uruchomienie: java Kartografia
*/


/*
import java.lang.Math;
class GeographicalCoordinates
{
	private double coordinate;
	private double minute;
	private double sec;
	
	public GeographicalCoordinates(double coordinate,double minute, double sec)
	{
		this.coordinate= coordinate;
		this.minute = minute;
		this.sec = sec;
	}
	public double getCoordinate()
	{
		return coordinate;
	}
	public double getMinute()
	{
		return minute;
	}
	public double getSec()
	{
		return sec;
	}
	public double change(GeographicalCoordinates A)
	{
		
		//zamiana na stopnie 
		minute= A.getMinute()/60;
		sec= A.getSec()/3600;
		coordinate= A.getCoordinate() + sec+minute;
		// zamiana wartosci na radiany
				coordinate= Math.toRadians(A.getCoordinate());
		return coordinate;
	}

	
}
public class Kartografia {
	
	//metoda obliczajaca odleglosc
	public static void differences(GeographicalCoordinates langtitudeA,GeographicalCoordinates langtitudeB,
			GeographicalCoordinates longtitudeA,GeographicalCoordinates longtitudeB)
	{
		double laA=langtitudeA.change(langtitudeA);
		double loA=longtitudeA.change(longtitudeA);
		double laB=langtitudeB.change(langtitudeB);
		double loB=longtitudeB.change(longtitudeB);
		
		double distance = Math.acos((Math.sin(laA)* Math.sin(laB))
				+ (Math.cos(laA)*Math.cos(laB)*Math.cos(loA-loB)));
		//zamiana radianow na stopnie
		double degreeDistance= Math.toDegrees(distance);
		

		System.out.println(degreeDistance);

	}
	public static void main (String [] args)
	{
		//deklaracja obiektow, miejscowosci
		GeographicalCoordinates kocmierzowLo = new GeographicalCoordinates(21,42,56);
		GeographicalCoordinates kocmierzowLa = new GeographicalCoordinates(50,39,25);
		GeographicalCoordinates krakowLo = new GeographicalCoordinates(19,56,41);
		GeographicalCoordinates krakowLa = new GeographicalCoordinates(50,3,52);
		GeographicalCoordinates koscieliskoLo = new GeographicalCoordinates(19,53,22);
		GeographicalCoordinates koscieliskoLa = new GeographicalCoordinates(49,17,25);
		//wyswietlenie odleglosci w stopniach
		System.out.print("odległosc miedzy Kocmierzowem, a Kraków: ");
		differences(kocmierzowLa,krakowLa,kocmierzowLo,krakowLo);
		System.out.print("odległosc miedzy Kocmierzowem, a Koscieliskiem: ");
		differences(kocmierzowLa,koscieliskoLa,kocmierzowLo,koscieliskoLo);
		System.out.print("odległosc miedzy Koscieliskiem, a Krakowem: ");
		differences(koscieliskoLa,krakowLa,koscieliskoLo,krakowLo);


	}


}*/