package n1exercici1;

public class InstrumentVent extends Instruments {

	static String modelo = "Està sonant un instrument de vent";

	public InstrumentVent(String nom, double preu) {
		super(nom, preu);
		tocar();
	}

	public void tocar() {
		System.out.println("Està sonant un instrument de vent");
	}

}