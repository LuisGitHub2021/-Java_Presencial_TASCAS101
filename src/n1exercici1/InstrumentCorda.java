package n1exercici1;

public class InstrumentCorda extends Instruments {

	static String estilo = "Està sonant un instrument de corda";

	public InstrumentCorda(String nom, double preu) {
		super(nom, preu);
		tocar();
	}

	public void tocar() {
		System.out.println("Està sonant un instrument de corda");
	}

}