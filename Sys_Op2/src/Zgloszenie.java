import java.io.Serializable;
import java.util.Random;

public class Zgloszenie implements Comparable<Zgloszenie>, Serializable{

	
	public int czasPojawienia;
	public int czasObslugi;//moment, w którym zgloszenie jest obs³u¿one
	public int miejscePojawienia;
	public boolean czyObsluzony;
	public static int rozmiarDysku;//potrzebne do parametryzacji symulacji
	
	public Zgloszenie(int czas) {
		rozmiarDysku=Dysk.rozmiar;
		Random random=new Random();
		czasPojawienia=czas;
		miejscePojawienia=random.nextInt(rozmiarDysku)+1;
		}
	
	public Zgloszenie(int czas, int miejsce) {
		czasPojawienia=czas;
		miejscePojawienia=miejsce;
		czyObsluzony=false;
	}
	
	@Override
	public String toString() {
		return "Zgloszenie [czasPojawienia=" + czasPojawienia + ", czasObslugi=" + czasObslugi + ", miejscePojawienia="
				+ miejscePojawienia + ", czyObsluzony=" + czyObsluzony + "]";
	}

	@Override
	public int compareTo(Zgloszenie o) {//potrzebne do przesortowywania przy algorytmach typu SCAN
		Integer i1=new Integer(miejscePojawienia);
		Integer i2=new Integer(o.miejscePojawienia);
		return i1.compareTo(i2);
	}
}
