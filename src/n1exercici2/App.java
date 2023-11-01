package n1exercici2;

public class App {
	public static void main(String[] args) {

		Cotxe.frenar();
		Cotxe car1 = new Cotxe("Peugeot", "Alhambra", "180cv");
		car1.accelerar();
		System.out.println("Tanto static como final pueden inicializarse en el constructor pero static final NO"
				+ "\nEn el caso de final prevaldrá la asignacion de la inicializacion en declaración. Es final. No puede cambiar."
				+ "\nEn el caso de static prevaldrá la asignación realizada en el constructor vs la asignacion realizada en la inicializadion en la declaración");
		System.out.println(Cotxe.MARCA + " " + Cotxe.model + " " + car1.POTENCIA);

	}

}
