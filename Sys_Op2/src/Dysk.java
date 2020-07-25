import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dysk {
	
	static int rozmiar;
	
	public static int getRozmiar() {
		return rozmiar;
	}
	
	public static void wyswietlZgloszenia(ArrayList<Zgloszenie> list) {
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public static ArrayList<Zgloszenie> wczytajZgloszenia() {//
		ArrayList<Zgloszenie> listZgloszen;
		try {
			listZgloszen = Generator.wczytajListe();
			return listZgloszen;
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		Algorithm a;
		int liczba=0;
		int alg=1;
		
		System.out.println("Rozmiar dysku: ");
		alg=input.nextInt();
		rozmiar=alg;
		Zgloszenie.rozmiarDysku=rozmiar;
		
		System.out.println("Iloœæ zg³oszeñ: ");
		alg=input.nextInt();
		Generator.ilZgloszen=alg;
		
		System.out.println("Szansa na zg³oszenie w jednej iteracji pêtli generuj¹cej zg³oszeñ(0,?): ");
		Generator.szansaNaZgloszenie=input.nextDouble();
		
		System.out.println("Szansa na zg³oszenie real-time(0,?): ");
		Generator.szansaNaRealTime=input.nextDouble();
		
		System.out.println("Minimalny deadline: ");
		ZgloszenieRealTime.deadlineOd=input.nextInt();
		
		System.out.println("Maksymalny deadline: ");
		ZgloszenieRealTime.zakresDeadline=input.nextInt()-ZgloszenieRealTime.deadlineOd;
		
		ArrayList<Zgloszenie> listaZgloszen=Generator.generujZgloszenia();//losowe zgloszenia
		//ArrayList<Zgloszenie> listaZgloszen=wczytajZgloszenia();
		//w celu odczytania bez problemow nalezy wprowadzic rozmiar dysku=100, 
		//ilZgloszen-10000, szanse na zgloszenie=0,05 
		//szanse na real-time=0,3
		//minimalny deadline=20 oraz maksymalny deadline=8=
		
		int czasPracy=0;
		

			System.out.println("Wybierz algorytm: \n[1]-FCFS\n[2]-SSTF\n[3]-C_SCAN\n[4]-SCAN\n[5]-EDF\n[6]-FD_SCAN\n[0]-Wyjdz");
		alg=input.nextInt();
		//wybor algorytmu
		switch(alg) {
		case 1:
			a=new FCFS();
			break;
		case 2:
			a=new SSTF();
			break;
		case 3:
			a=new C_SCAN();
			break;
		case 4:
			a=new SCAN();
			break;
		case 5:
			a=new EDF();
			break;
		case 6:
			a=new FD_SCAN();
			break;
		default:
			return;
		}
		
		
		
		System.out.println("Wygenerowane procesy:");
		wyswietlZgloszenia(listaZgloszen);
		

		System.out.println("Rozpoczecie pracy:");
		while(a.ilZgloszenObsluzonych<listaZgloszen.size()) {
			if(liczba<listaZgloszen.size())
			if(listaZgloszen.get(liczba).czasPojawienia==czasPracy) {
				a.dodajZgloszenie(listaZgloszen.get(liczba));
				System.out.println("Pojawi³o siê nowe zgloszenie: " + listaZgloszen.get(liczba));
				liczba++;
			}
			
			a.krok(czasPracy);
			czasPracy++;
			System.out.println("Aktualne zgloszenie:" + a.aktualneZgloszenie());
			System.out.println("Pozycja glowicy: "+a.glowica.pozycja);
			System.out.println("Iloœæ zg³oszeñ: "+a.zgloszenia.size());//wyswietlenie ilosci zgloszen oczekujacych na obsluge
			System.out.println("Czas pracy: "+ (czasPracy-1));//czas pracy zwieksza sie po wykonaniu ruchu przez glowice, wiec zmniejszam czas o 1
			System.out.println(a.ilZgloszenObsluzonych);//wyswietlenie ilosci obluzonych juz zgloszen
		}
		System.out.println("----------------------------------------------");
		a.s.statystyka();
		System.out.println("----------------------------------------------");

		
		}
}
