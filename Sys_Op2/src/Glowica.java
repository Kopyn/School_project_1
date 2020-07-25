
public class Glowica {
	
	public int pozycja;
	public int sumaPrzemieszczen;
	
	public Glowica() {
		pozycja=0;
		sumaPrzemieszczen=0;
	}
	
	public void poruszGlowice(Zgloszenie z) {//metoda jesli glowica idzie do zgloszenia
		if(z==null)
			return;
		else {
		if(pozycja>z.miejscePojawienia) {
			pozycja--;
			sumaPrzemieszczen++;
		}
		if(pozycja<z.miejscePojawienia) {
			pozycja++;
			sumaPrzemieszczen++;
		}
		}
	}
	
	public void poruszGlowice(int poz) {//metoda do SCAN'ow
		if(poz==0) {
			pozycja--;
		}if(poz==Dysk.rozmiar) {
			pozycja++;
		}
		sumaPrzemieszczen++;
	}
	

}
