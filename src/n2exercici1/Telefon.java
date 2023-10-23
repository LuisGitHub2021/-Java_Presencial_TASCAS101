package n2exercici1;

public class Telefon implements Camera, Rellotge {

	protected String marca;
	protected String model;

	// constructor
	protected Telefon(String marca, String model) {
		this.marca = marca;
		this.model = model;

	}

	// metodo clase
	protected void trucar(String numPhone) {

		System.out.println("S'està trucant al numero " + numPhone);

	}

}