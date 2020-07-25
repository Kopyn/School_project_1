import java.util.ArrayList;

public class FCFS extends Algorithm{
	
	public FCFS(ArrayList<Zgloszenie> lista) {
		super(lista);
	}
	
	public FCFS() {
		super();
	}
	
	@Override
	public void krok(int czas) {
		if(zgloszenia.size()!=0) {
			checkRealTime(czas);//wyjasnienie w klasie Algorithm
			if(zgloszenia.size()!=0) {
				glowica.poruszGlowice(aktualneZgloszenie());
				s.droga++;
		checkOne();//wyjasnienie w klasie Algorithm
//			for(int i=0; i<zgloszenia.size(); i++) {
//				if(zgloszenia.get(i).miejscePojawienia==glowica.pozycja) {
//					zgloszenia.get(i).czyObsluzony=true;
//					s.lista.add(zgloszenia.get(i));
//					zgloszenia.remove(i);
//					i--;
//					ilZgloszenObsluzonych++;
//				}
//			}
		
			}
		}
	}
	
	@Override
	public void dodajZgloszenie(Zgloszenie z) {
//		if(z.miejscePojawienia==glowica.pozycja) {
//			ilZgloszenObsluzonych++;
//			s.lista.add(z);
//			return;
//		}
		zgloszenia.add(z);
	}

	@Override
	public Zgloszenie aktualneZgloszenie() {
		if(zgloszenia.size()!=0)
		return zgloszenia.get(0);
		else
			return null;
	}

}
