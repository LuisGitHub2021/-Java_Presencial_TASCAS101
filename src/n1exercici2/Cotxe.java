package n1exercici2;

public class Cotxe {

	public static void main(String[] args) {

		Cotxe.frenar();
		Cotxe car1 = new Cotxe("Peugeot", "Alhambra", "180cv");
		car1.accelerar();
		System.out.println("Tanto static como final pueden inicializarse en el constructor pero static final NO"
				+ "\nEn el caso de final prevaldrá la asignacion de la inicializacion en declaración. Es final. No puede cambiar."
				+ "\nEn el caso de static prevaldrá la asignación realizada en el constructor vs la asignacion realizada en la inicializadion en la declaración");
		System.out.println(Cotxe.MARCA + " " + Cotxe.model + " " + car1.POTENCIA);

	}

	static final String MARCA = "SEAT";
	static String model = "807";
	final String POTENCIA;

	public Cotxe(String MARCA, String model, String POTENCIA) {

		// STATIC FINAL no se puede inicializar en el constructor
		// Se inicializa una vez al ser static y no se puede modificar al ser final
		// Cualquier otra inicialización que permita compilar no aplicará
		MARCA = "FIAT";

		// STATIC
		// Se puede inicializar en el constructor
		// Prevaldrá la asignacion de valor del constructor sobre la declaración
		Cotxe.model = model;

		// FINAL
		// Se puede inicializar en el constructor
		// Prevaldrá la inicializacion en la declaración

		this.POTENCIA = "136cv";

	}
	
	static void frenar () {
		System.out.println("El vehicle està frenant");
		
	}
	
	public void accelerar () {
		System.out.println("El vehicle està accelerant");
	}

	@Override
	public String toString() {
		return "Cotxe [MARCA=" + MARCA + "][MODEL=" + Cotxe.model +"][POTENCIA=" + POTENCIA + "] ";
	}


	

	
	
	
}
