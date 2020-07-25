import java.util.Random;

public class ZgloszenieRealTime extends Zgloszenie{
	
	public int deadline;
	public static int zakresDeadline;
	public static int deadlineOd;
	
	public ZgloszenieRealTime(int czas) {
		super(czas);
		Random random=new Random();
		deadline=random.nextInt(zakresDeadline)+deadlineOd;
	}
	
	public ZgloszenieRealTime(int czas, int miejsce, int dl) {
		super(czas, miejsce);
		deadline=dl;
	}

	@Override
	public String toString() {
		return "ZgloszenieRealTime [deadline=" + deadline + ", czasPojawienia=" + czasPojawienia + ", czasObslugi="
				+ czasObslugi + ", miejscePojawienia=" + miejscePojawienia + ", czyObsluzony=" + czyObsluzony + "]";
	}
	
	

}
