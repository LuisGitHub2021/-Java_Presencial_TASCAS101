package n2exercici1;

public class Telefon implements Camera, Rellotge {

	protected String marca;
	protected String model;

	protected Telefon(String marca, String model) {
		this.marca = marca;
		this.model = model;

	}

	static void trucar(String numPhone) {

		System.out.println("S'està trucant al numero " + numPhone);

	}

}