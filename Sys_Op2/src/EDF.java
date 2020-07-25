import java.util.ArrayList;

public class EDF extends Algorithm{
	
	
	public EDF() {
		super();
	}

	@Override
	public void krok(int czas) {
		if(zgloszenia.size()!=0) {
			glowica.poruszGlowice(aktualneZgloszenie());
			s.droga++;
			checkOne();//wyjasnienie w klasie Algorithm
//				for(int i=0; i<zgloszenia.size(); i++) {
//					if(zgloszenia.get(i).miejscePojawienia==glowica.pozycja) {
//						zgloszenia.get(i).czyObsluzony=true;
//						s.lista.add(zgloszenia.get(i));
//						zgloszenia.remove(i);
//						i--;
//						ilZgloszenObsluzonych++;
//					}
//				}
			//}
		}
		checkRealTime(czas);//wyjasnienie w klasie Algorithm
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
//		if(z.miejscePojawienia==glowica.pozycja) {
//			ilZgloszenObsluzonych++;
//			s.lista.add(z);
//			return;
//		}
		int o=0;
		if(zgloszenia.size()==0) {
			zgloszenia.add(z);
		}else {
			if(z instanceof ZgloszenieRealTime) {
			if(zgloszenia.get(o) instanceof ZgloszenieRealTime) {
				ZgloszenieRealTime zgloszeniePrzychodzace = (ZgloszenieRealTime)z;
				ZgloszenieRealTime zg=(ZgloszenieRealTime)zgloszenia.get(o);
				while(o<zgloszenia.size() && zgloszenia.get(o) instanceof ZgloszenieRealTime &&
						zg.deadline<zgloszeniePrzychodzace.deadline) {
					zg=(ZgloszenieRealTime)zgloszenia.get(o);
					o++;
				}
				zgloszenia.add(o, z);
			}else
				zgloszenia.add(o, z);
		}else
			zgloszenia.add(z);
		}
}
}
