package n3Exercici1;

public class NoticiesMotociclisme extends Noticies {

	static final String TIPO_NOTICIA = "motociclisme";
	static final int PREU_INIT = 100;
	final int PREU_EQUIP = 50;
	static final int PT_INIT = 3;
	final int PT_EQUIP = 3;
	private String equips;

	// constructor
	protected NoticiesMotociclisme(Redactors redactor, String titular, String equips) {
		super(redactor, titular);
		this.equips = equips;

	}

	// metodos de clase
	static NoticiesMotociclisme crearNoticiesMotociclisme(Redactors redactor, String titular, String equips) {

		return new NoticiesMotociclisme(redactor, titular, equips);

	}

	public int calcularPunts() {

		puntuacio = 0;
		puntuacio = super.calcularPunts() + PT_INIT;

		if (equips.equalsIgnoreCase("Honda") || equips.equalsIgnoreCase("Yamaha")) {

			puntuacio += PT_EQUIP;
		}

		return puntuacio;
	}

	public int calcularPreu() {

		preu = 0;
		preu = super.calcularPreu() + PREU_INIT;

		if (equips.equalsIgnoreCase("Honda") || equips.equalsIgnoreCase("Yamaha")) {

			preu += PREU_EQUIP;
		}

		return preu;
	}

	// sobrescritos
	@Override
	public String toString() {
		return "NoticiesMotociclisme [redactor dni=" + redactor.getDni() + ", titular=" + titular + ", equips=" + equips
				+ "]";
	}

}