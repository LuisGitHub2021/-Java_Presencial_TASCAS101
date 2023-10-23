package n3Exercici1;

public class NoticiesTenis extends Noticies {

	static final int PREU_INIT = 150;
	final int PREU_JUGADORS = 100;
	static final int PT_INIT = 4;
	final int PT_JUGADORS = 3;
	private String jugadors;

	// constructor
	protected NoticiesTenis(Redactors redactor, String titular, String jugadors) {
		super(redactor, titular);
		this.jugadors = jugadors;
	}

	// metodos de clase
	static NoticiesTenis crearNoticiesTenis(Redactors redactor, String titular, String jugadors) {

		return new NoticiesTenis(redactor, titular, jugadors);

	}

	public int calcularPunts() {

		puntuacio = 0;
		puntuacio = super.calcularPunts() + PT_INIT;

		if (jugadors.equalsIgnoreCase("Federer") || jugadors.equalsIgnoreCase("Nadal")
				|| jugadors.equalsIgnoreCase("Djokovic")) {

			puntuacio += PT_JUGADORS;
		}

		return puntuacio;
	}

	public int calcularPreu() {

		preu = 0;
		preu = super.calcularPreu() + PREU_INIT;

		if (jugadors.equalsIgnoreCase("Federer") || jugadors.equalsIgnoreCase("Nadal")
				|| jugadors.equalsIgnoreCase("Djokovic")) {

			preu += PREU_JUGADORS;
		}

		return preu;
	}

	// sobrescritos
	@Override
	public String toString() {
		return "NoticiesTenis [redactor dni=" + redactor.getDni() + ", titular=" + titular + ", jugadors=" + jugadors
				+ "]";
	}
}