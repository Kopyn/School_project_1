import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Generator {
	
	public static int ilRealTime=0;
	public static double szansaNaZgloszenie;
	public static double szansaNaRealTime;
	public static int ilZgloszen;
	
	public static ArrayList<Zgloszenie> generujZgloszenia(){
		ArrayList<Zgloszenie> lista=new ArrayList<>();
		int czas=0;
		while(lista.size()<ilZgloszen) {
			if(Math.random()>1-szansaNaZgloszenie)//czestotliwosc pojawiania sie zgloszen-wazny czynnik!
				if(Math.random()>1-szansaNaRealTime) {
					lista.add(new ZgloszenieRealTime(czas));
					ilRealTime++;
				}else
					lista.add(new Zgloszenie(czas));
			czas++;
		}
		
		return lista;
	}
	
	public static void zapiszZgloszenia() throws IOException {//tworzenie zaplanowanej listy procesów
		ArrayList<Zgloszenie> lista=new ArrayList<>();
		//PrintWriter zapis = new PrintWriter("NieoptymalnySCAN.ser");
		int czas=0;
		
			while(lista.size()<10000) {
				if(Math.random()>0.95)
					if(Math.random()>0.7) {
						lista.add(new ZgloszenieRealTime(czas));
						ilRealTime++;
					}else
						lista.add(new Zgloszenie(czas));
				czas++;
			}
			
			try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("NieoptymalnySCAN.ser"))){
				oos.writeObject(lista);
			}

	}
	
	public static ArrayList<Zgloszenie> wczytajListe() throws IOException, ClassNotFoundException{
		ArrayList<Zgloszenie> lista = new ArrayList<>();
		
		try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream("NieoptymalnySCAN.ser"))){//tu zmieniamy plik
			try {
				lista=(ArrayList<Zgloszenie>)ois.readObject();
			}catch(EOFException ex){
				
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return lista;
	}

}
