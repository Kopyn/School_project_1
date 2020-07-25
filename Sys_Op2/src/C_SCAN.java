import java.util.ArrayList;
import java.util.Collections;

public class C_SCAN extends Algorithm{
	

	public C_SCAN(ArrayList<Zgloszenie> lista) {
		super(lista);
	}
	
	public C_SCAN() {
		super();
	}
	@Override
	public void krok(int czas) {
		if(glowica.pozycja<=Dysk.rozmiar) {
			glowica.poruszGlowice(Dysk.rozmiar);
			s.droga++;
			if(zgloszenia.size()!=0) {
				checkRealTime(czas);//wyjasnienie w klasie Algorithm
				if(zgloszenia.size()!=0) {//podwojnie sprawdzam czy lista jest niepusta, poniewaz przy usuwaniu real-time moglem oproznic liste
					checkAll();//wyjasnienie w klasie Algorithm
				}
			}
		}else {
			glowica.pozycja=0;
			s.ilPrzelaczen++;//powrot na poczatek dysku
			Collections.sort(zgloszenia);//przesortowanie zgloszen wedlug miejsca pojawienia
			//fragment zakomentowany, poniewaz od razu po przeskoczeniu glowicy wykonywala ona ruch(nie wiedzialem czy ma byc tak czy nie)
//			glowica.poruszGlowice(Dysk.rozmiar);
//			if(glowica.pozycja==aktualneZgloszenie().miejscePojawienia) {
//				zgloszenia.get(0).czyObsluzony=true;
//				zgloszenia.remove(0);
//				ilZgloszenObsluzonych++;
//			}
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
		}
	}
	

}
