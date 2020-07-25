import java.util.ArrayList;

public class SSTF extends Algorithm{
	
	public SSTF(ArrayList<Zgloszenie> lista) {
		super(lista);
	}
	
	public SSTF() {
		super();
	}

	@Override
	public void krok(int czas) {
		if(zgloszenia.size()!=0) {
			checkRealTime(czas);
			if(zgloszenia.size()!=0) {
				glowica.poruszGlowice(aktualneZgloszenie());
				s.droga++;
			checkOne();
//				for(int i=0; i<zgloszenia.size(); i++) {
//					if(zgloszenia.get(i).miejscePojawienia==glowica.pozycja) {
//						zgloszenia.get(i).czyObsluzony=true;
//						s.lista.add(zgloszenia.get(i));
//						zgloszenia.remove(i);
//						i--;
//						ilZgloszenObsluzonych++;
//					}
//				}
			}
		}
	}

	@Override
	public Zgloszenie aktualneZgloszenie() {
		if(zgloszenia.size()!=0)
			return zgloszenia.get(0);
		else
			return null;
	}

	@Override
	public void dodajZgloszenie(Zgloszenie z) {//dodawanie zgloszenia na odpowiednie miejsce w liscie, w zaleznosci od miejsca pojawienia zglsozenia i pozycji glowicy
		  int o=1;//zaczynamy od pierwszego miejsca, poniewaz, gdy glowica wybierze juz proces to na pewno do niego dotrze
//			if(z.miejscePojawienia==glowica.pozycja) {
//				ilZgloszenObsluzonych++;
//				s.lista.add(z);
//				return;
//			}
		  if(zgloszenia.size()==0) {
			  zgloszenia.add(z);
		  }else {
		  while(o<zgloszenia.size() && Math.abs(z.miejscePojawienia-glowica.pozycja)>Math.abs(zgloszenia.get(o).miejscePojawienia-glowica.pozycja)) {
			  o++;
		  }
		  if(o>=zgloszenia.size())
		  zgloszenia.add(z);
		  else {
			  zgloszenia.add(o, z);
		  }
		  }
		  
	}

}
