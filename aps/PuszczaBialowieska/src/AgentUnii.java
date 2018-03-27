
public class AgentUnii extends Thread{
	public AgentUnii() {
		setDaemon(true);
	}
	public void run() {
		while (true) {
			System.out.println("Agent Unii wpada z wizyt�");
			System.out.println("Agent Unii dokonuje ogl�dzi�");
			int stanMagazynu = Magazyn.bilans();
			try {
				sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			if(stanMagazynu >= 100) { //metoda sprawdza czy norma wycinki zostala przekroczona
				System.out.println("Agent Unii: Wykryto przekroczenie norm, wycinka zostaje zamkni�ta");
				System.exit(0);
			}else {
				System.out.println("Agent Unii: Nie stwierdzono wykrocze�, stan ewidencji: "+stanMagazynu);
				try {
					sleep((long)Math.random()*100); //losowa warto�� ponownego zjawienia si� agenta
		
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
