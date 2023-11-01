package n1exercici1;

abstract class Instruments {

	protected String nom;
	protected double preu;

	protected Instruments(String nom, double preu) {
		this.nom = nom;
		this.preu = preu;
	}

	
	abstract  void tocar();
	
}