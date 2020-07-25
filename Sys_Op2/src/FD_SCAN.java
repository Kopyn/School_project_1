import java.util.Collections;

public class FD_SCAN extends Algorithm{
	
	public int ilOdbic;
	
	public FD_SCAN() {
		super();
		ilOdbic=0;
	}

	@Override
	public void krok(int czas) {
		for(int i=0; i<zgloszenia.size(); i++) {
			if(zgloszenia.get(i) instanceof ZgloszenieRealTime) {
				ZgloszenieRealTime z =(ZgloszenieRealTime)zgloszenia.get(i);
				if(z.deadline<Math.abs(glowica.pozycja-z.miejscePojawienia)) {
					zgloszenia.remove(i);
					s.ilOdrzuconych++;
					ilZgloszenObsluzonych++;
			}
		}
	}
		if(zgloszenia.size()!=0) {
		if(aktualneZgloszenie() instanceof ZgloszenieRealTime) {
			glowica.poruszGlowice(aktualneZgloszenie());
			s.droga++;
			if(glowica.pozycja==aktualneZgloszenie().miejscePojawienia) {
				zgloszenia.get(0).czyObsluzony=true;
				s.lista.add(zgloszenia.get(0));
				zgloszenia.remove(0);
				ilZgloszenObsluzonych++;
			}else
				if(zgloszenia.size()!=0)
					if(aktualneZgloszenie().miejscePojawienia<glowica.pozycja)
						ilOdbic=1;
					else
						ilOdbic=2;
		}else 
		if(ilOdbic%2==0) {
			glowica.poruszGlowice(Dysk.rozmiar);
			s.droga++;
			if(zgloszenia.size()!=0) {
				if(glowica.pozycja==aktualneZgloszenie().miejscePojawienia) {
					zgloszenia.get(0).czyObsluzony=true;
					s.lista.add(zgloszenia.get(0));
					zgloszenia.remove(0);
					ilZgloszenObsluzonych++;
				}
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
		}else {
			glowica.poruszGlowice(0);
			s.droga++;
			if(zgloszenia.size()!=0) {
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
		}
		if(glowica.pozycja>=Dysk.rozmiar && !(aktualneZgloszenie() instanceof ZgloszenieRealTime)) {
			ilOdbic++;
			Collections.sort(zgloszenia);
			Collections.reverse(zgloszenia);
		}
		if(glowica.pozycja<=0 && !(aktualneZgloszenie() instanceof ZgloszenieRealTime)) {
			Collections.sort(zgloszenia);
			ilOdbic++;
		}
//		for(int i=0; i<zgloszenia.size(); i++) {
//			if(zgloszenia.get(i) instanceof ZgloszenieRealTime) {
//				ZgloszenieRealTime z =(ZgloszenieRealTime)zgloszenia.get(i);
//				if(czas>z.czasPojawienia+z.deadline) {
//					s.ilNieobsluzonychRealTime++;
//					zgloszenia.remove(i);
//					ilZgloszenObsluzonych++;
//				}
//			}
//		}
		}
	}

	@Override
	public Zgloszenie aktualneZgloszenie() {
		if(zgloszenia.size()!=0) {
			return zgloszenia.get(0);
		}else
			return null;
	}

	@Override
	public void dodajZgloszenie(Zgloszenie z) {
		int o=0;//potrzebne do wstawiania na odpowiednie miejsce zgloszenia real-time
		if(zgloszenia.size()==0) {
			zgloszenia.add(z);
		}else {
			if(z instanceof ZgloszenieRealTime) {
				ZgloszenieRealTime zgloszeniePrzychodzace = (ZgloszenieRealTime)z;
				if(zgloszeniePrzychodzace.deadline<Math.abs(glowica.pozycja-z.miejscePojawienia)) {
					s.ilOdrzuconych++;
					ilZgloszenObsluzonych++;
				}else {
					if(zgloszenia.get(o) instanceof ZgloszenieRealTime) {
						ZgloszenieRealTime zg=(ZgloszenieRealTime)zgloszenia.get(o);
						while(o<zgloszenia.size() && zgloszenia.get(o) instanceof ZgloszenieRealTime &&
								zg.deadline<zgloszeniePrzychodzace.deadline) {
							zg=(ZgloszenieRealTime)zgloszenia.get(o);
							o++;
						}
				zgloszenia.add(o, z);
			}else
				zgloszenia.add(o, z);
			}
		}else
			zgloszenia.add(z);
		}
	}

}
