
public class AgentUnii extends Thread{
	public AgentUnii() {
		setDaemon(true);
	}
	public void run() {
		while (true) {
			System.out.println("Agent Unii wpada z wizyt¹");
			System.out.println("Agent Unii dokonuje oglêdziñ");
			int stanMagazynu = Magazyn.bilans();
			try {
				sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			if(stanMagazynu >= 100) { //metoda sprawdza czy norma wycinki zostala przekroczona
				System.out.println("Agent Unii: Wykryto przekroczenie norm, wycinka zostaje zamkniêta");
				System.exit(0);
			}else {
				System.out.println("Agent Unii: Nie stwierdzono wykroczeñ, stan ewidencji: "+stanMagazynu);
				try {
					sleep((long)Math.random()*100); //losowa wartoœæ ponownego zjawienia siê agenta
		
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
