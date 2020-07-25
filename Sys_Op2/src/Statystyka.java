import java.util.ArrayList;

public class Statystyka {
	
	public int ilNieobsluzonychRealTime;
	public ArrayList<Zgloszenie> lista;
	public int droga;
	public int ilOdrzuconych;
	public int ilPrzelaczen;
	
	public Statystyka() {
		ilNieobsluzonychRealTime=0;
		droga=0;
		ilOdrzuconych=0;
		ilPrzelaczen=0;
		lista=new ArrayList<>();
	}

	public void statystyka() {
		System.out.println("STATYSTYKA");
		System.out.println("Iloœæ Obs³u¿onych procesów -"+ lista.size() + "\nIloœæ nieobs³u¿onych zg³oszeñ real-time - " 
	+ ilNieobsluzonychRealTime + "\nPrzebyta droga - "+droga+"\nIloœæ odrzuconych zg³oszeñ real-time - "
				+ilOdrzuconych + "\nIloœæ 'przeskoków' g³owicy - " + ilPrzelaczen);
	}
}
