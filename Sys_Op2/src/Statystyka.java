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
		System.out.println("Ilo�� Obs�u�onych proces�w -"+ lista.size() + "\nIlo�� nieobs�u�onych zg�osze� real-time - " 
	+ ilNieobsluzonychRealTime + "\nPrzebyta droga - "+droga+"\nIlo�� odrzuconych zg�osze� real-time - "
				+ilOdrzuconych + "\nIlo�� 'przeskok�w' g�owicy - " + ilPrzelaczen);
	}
}
