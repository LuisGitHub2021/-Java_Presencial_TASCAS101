package n1exercici1;

public class InstrumentVent extends Instruments {

	static String modelo = "Està sonant un instrument de vent";

	// constructor
	public InstrumentVent(String nom, double preu) {
		super(nom, preu);
		tocar();
	}

	// metodo de clase
	public void tocar() {
		System.out.println("Està sonant un instrument de vent");
	}

}