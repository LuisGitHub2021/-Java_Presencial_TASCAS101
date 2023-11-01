package n1exercici1;

public class InstrumentPercussio extends Instruments {

	static String tipos = "Està sonant un instrument de percussió";

	public InstrumentPercussio(String nom, double preu) {
		super(nom, preu);
		tocar();
	}

	public void tocar() {
		System.out.println("Està sonant un instrument de percussió");
	}

}