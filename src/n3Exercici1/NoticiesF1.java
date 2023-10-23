package n3Exercici1;

public class NoticiesF1 extends Noticies {

	static final String TIPO_NOTICIA = "F1";
	static final int PREU_INIT = 100;
	final int PREU_EQUIP = 50;
	static final int PT_INIT = 4;
	final int PT_EQUIP = 2;
	private String equips;

	// constructor
	protected NoticiesF1(Redactors redactor, String titular, String equips) {
		super(redactor, titular);
		this.equips = equips;

	}

	// metodos de clase
	static NoticiesF1 crearNoticiesF1(Redactors redactor, String titular, String equips) {

		return new NoticiesF1(redactor, titular, equips);

	}

	public int calcularPunts() {

		puntuacio = 0;
		puntuacio = super.calcularPunts() + PT_INIT;

		if (equips.equalsIgnoreCase("Ferrari") || equips.equalsIgnoreCase("Mercedes")) {

			puntuacio += PT_EQUIP;
		}

		return puntuacio;
	}

	public int calcularPreu() {

		preu = 0;
		preu = super.calcularPreu() + PREU_INIT;

		if (equips.equalsIgnoreCase("Ferrari") || equips.equalsIgnoreCase("Mercedes")) {

			preu += PREU_EQUIP;
		}

		return preu;
	}

	// sobrescritos
	@Override
	public String toString() {
		return "NoticiesF1 [redactor dni=" + redactor.getDni() + ", titular=" + titular + ", equips=" + equips + "]";
	}
}