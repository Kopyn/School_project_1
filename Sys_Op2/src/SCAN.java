import java.util.ArrayList;
import java.util.Collections;

public class SCAN extends Algorithm{
	
	public int ilOdbic;//zmienna pomocnicza sluzaca do sterowania, do ktorego konca ma sie poruszac glowica
	
	public SCAN() {
		super();
		ilOdbic=0;
	}
	
	public SCAN(ArrayList<Zgloszenie> lista) {
		super(lista);
		ilOdbic=0;
	}

	@Override
	public void krok(int czas) {
		if(ilOdbic%2==0) {
			glowica.poruszGlowice(Dysk.rozmiar);
			s.droga++;
			if(zgloszenia.size()!=0) {
				checkAll();//wyjasnienie w klasie Algorithm
				checkRealTime(czas);//wyjasnienie w klasie Algorithm
			}
		}else {
			glowica.poruszGlowice(0);
			s.droga++;
			if(zgloszenia.size()!=0) {
				checkAll();//wyjasnienie w klasie Algorithm
				checkRealTime(czas);//wyjasnienie w klasie Algorithm
			}
		}
		if(glowica.pozycja==Dysk.rozmiar) {
			ilOdbic++;
			Collections.sort(zgloszenia);
			Collections.reverse(zgloszenia);
		}
		if(glowica.pozycja==0) {
			Collections.sort(zgloszenia);
			ilOdbic++;
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
	public void dodajZgloszenie(Zgloszenie z) {
		int o=0;
		if(z.miejscePojawienia==glowica.pozycja) {
			ilZgloszenObsluzonych++;
			s.lista.add(z);
			return;
		}
		if(zgloszenia.size()==0) {
			zgloszenia.add(z);
		}else {
			if(ilOdbic%2==0) {
			if(z.miejscePojawienia>glowica.pozycja) {
				  while(o<zgloszenia.size() && z.miejscePojawienia>zgloszenia.get(o).miejscePojawienia) {
					  o++;
				  }
				  if(o>=zgloszenia.size())
				  zgloszenia.add(z);
				  else {
					  zgloszenia.add(o, z);
				  }
			}else{
				zgloszenia.add(z);
				
			}
			}else {
				if(z.miejscePojawienia<glowica.pozycja) {
					o=0;
					while(o<zgloszenia.size() && z.miejscePojawienia<=zgloszenia.get(o).miejscePojawienia) {
						o++;	
					}
					if(o>=zgloszenia.size())
						  zgloszenia.add(z);
						  else {
							  zgloszenia.add(o, z);
						  
				}
				
			}else
				zgloszenia.add(z);
		}
	}
	}
}
