import java.util.ArrayList;

public abstract class Algorithm {
	
	protected Glowica glowica=new Glowica();
	protected ArrayList<Zgloszenie> zgloszenia;
	public Statystyka s=new Statystyka();
	public int ilZgloszenObsluzonych;
	public Zgloszenie aktualneZgloszenie;
	public Zgloszenie nastZgloszenie;
	
	public Algorithm() {
		zgloszenia=new ArrayList<>();
		ilZgloszenObsluzonych=0;
		
	}
	
	public Algorithm(ArrayList<Zgloszenie> lista) {
		zgloszenia=lista;
		ilZgloszenObsluzonych=0;
	}
	
	public void checkOne() {//jezeli glowica jest w pozycji co aktualne zgloszenie, to jest ono oblusiwane
		if(glowica.pozycja==aktualneZgloszenie().miejscePojawienia) {
			zgloszenia.get(0).czyObsluzony=true;
			s.lista.add(zgloszenia.get(0));
			zgloszenia.remove(0);
			ilZgloszenObsluzonych++;
		}
	}
	
	public void checkAll() {//to co wyzej do SCAN'ow-przy SCANACH kilka zgloszen w jedno miejsce jest obslugiwane jednoczesnie
		for(int i=0; i<zgloszenia.size(); i++) {
			if(glowica.pozycja==zgloszenia.get(i).miejscePojawienia) {
				zgloszenia.get(i).czyObsluzony=true;
				s.lista.add(zgloszenia.get(i));
				zgloszenia.remove(i);
				i--;
				ilZgloszenObsluzonych++;
				}
		}
	}
	
	public void checkRealTime(int czas) {
		for(int i=0; i<zgloszenia.size(); i++) {//metoda sprawdzajaca czy zgloszenia real-time sie nie przedawnily
			if(zgloszenia.get(i) instanceof ZgloszenieRealTime) {
				ZgloszenieRealTime z =(ZgloszenieRealTime)zgloszenia.get(i);
				if(czas>z.czasPojawienia+z.deadline) {
					s.ilNieobsluzonychRealTime++;
					zgloszenia.remove(i);
					ilZgloszenObsluzonych++;
				}
			}
		}
	}
	
	public void checkOneThenAll() {//nieuzywana metoda
		if(glowica.pozycja==aktualneZgloszenie().miejscePojawienia) {
			zgloszenia.get(0).czyObsluzony=true;
			s.lista.add(zgloszenia.get(0));
			zgloszenia.remove(0);
			ilZgloszenObsluzonych++;
			for(int i=0; i<zgloszenia.size(); i++) {
				if(zgloszenia.get(i).miejscePojawienia==glowica.pozycja) {
					zgloszenia.get(i).czyObsluzony=true;
					s.lista.add(zgloszenia.get(i));
					zgloszenia.remove(i);
					i--;
					ilZgloszenObsluzonych++;
				}
			}
			
		}
	}
	
	public abstract void krok(int czas);
	
	public ArrayList<Zgloszenie> getZgloszenia(){
		return zgloszenia;
	}
	
	public abstract Zgloszenie aktualneZgloszenie();
	public abstract void dodajZgloszenie(Zgloszenie z);//do klasy algorytm sa dodawane zgloszenia dynamicznie, a nie w sposob wczytania calej listy od razu

}
