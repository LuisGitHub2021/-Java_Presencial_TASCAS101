package n1exercici2;

public class Cotxe {

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
		this.model = model;

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
