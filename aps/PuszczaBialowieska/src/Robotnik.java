import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.Semaphore;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Robotnik extends Thread{
	/*definicja sektorow pracy*/
	private static final Semaphore sektorA = new Semaphore(4,true);
	private static final Semaphore sektorB = new Semaphore(4,true);
	private static final Semaphore sektorC = new Semaphore(4,true);
	private static final Semaphore sektorD = new Semaphore(4,true);
	
	
	private String nazwa;
	private int norma = 0;
	private boolean koniec = false;

	public Robotnik(String nazwa, int norma) {
		super();
		this.norma = norma;
		this.nazwa = nazwa;
	}
	
	//metoda odpowiadajaca za zajmowenie poszczegolnych sektorow
	public void run() {
		while(koniec == false) {
			if(sektorA.tryAcquire()) {
				praca(sektorA,"sektor A");
			}if(sektorB.tryAcquire()) {
				praca(sektorB,"sektor B");
			}if(sektorC.tryAcquire()) {
				praca(sektorC,"sektor C");
			}if(sektorD.tryAcquire()) {
				praca(sektorD,"sektor D");
			}else {
				System.out.println(nazwa+" czeka na wolny sektor");
				try {
				sleep((long)(Math.random()*1000));
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}}
		}
	}
	void praca(Semaphore sektor,String nazwaSektora) {
		while(norma > 0) {
			try{	 
		System.out.println(nazwa+" zajmuje "+nazwaSektora);
		System.out.println(nazwa+" wycina drzewo");
		System.out.println(nazwa+" zanosi drzewo do magazynu");
		Magazyn.wloz();
		norma --;
		System.out.println("Robotnikowi "+nazwa+" zosta³o jeszcze "+norma+" do normy");
		if(norma == 0) {System.out.println(nazwa+" Wyrobi³ normê i poszed³ do domu");
		sektor.release();
		koniec = true;
		join();
		}		
		System.out.println("W "+nazwaSektora +" s¹: "+sektor.availablePermits()+" wolne miejsca");
	
		sleep((long)(Math.random()*1000));
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}