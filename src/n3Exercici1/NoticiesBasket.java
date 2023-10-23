package n3Exercici1;

public class NoticiesBasket extends Noticies {

	static final String TIPO_NOTICIA = "basket";
	static final int PREU_INIT = 250;
	final int PREU_COMPETICIO = 75;
	final int PREU_EQUIP = 75;
	static final int PT_INIT = 4;
	final int PT_COMPETICIO = 3;
	final int PT_COMPETICIO_ACB = 2;
	final int PT_EQUIP = 1;
	private String competicio;
	private String equips;

	// constructor
	protected NoticiesBasket(Redactors redactor, String titular, String competicio, String equips) {
		super(redactor, titular);
		this.competicio = competicio;
		this.equips = equips;

	}

	// metodos de clase
	static NoticiesBasket crearNoticiesBasket(Redactors redactor, String titular, String competicio, String equips) {

		return new NoticiesBasket(redactor, titular, competicio, equips);

	}

	public int calcularPunts() {

		puntuacio = 0;
		puntuacio = super.calcularPunts() + PT_INIT;

		if (competicio.equalsIgnoreCase("Eurolliga")) {

			puntuacio += PT_COMPETICIO;

		} else if (competicio.equalsIgnoreCase("ACB")) {

			puntuacio += PT_COMPETICIO_ACB;
		}

		if (equips.equalsIgnoreCase("Barça") || equips.equalsIgnoreCase("Madrid")) {

			puntuacio += PT_EQUIP;
		}

		return puntuacio;
	}

	public int calcularPreu() {

		preu = 0;
		preu = super.calcularPreu() + PREU_INIT;

		if (competicio.equalsIgnoreCase("Eurolliga")) {

			preu += PREU_COMPETICIO;
		}

		if (equips.equalsIgnoreCase("Barça") || equips.equalsIgnoreCase("Madrid")) {

			preu += PREU_EQUIP;
		}

		return preu;
	}

	// sobrescritos
	@Override
	public String toString() {
		return "NoticiesBasket [redactor dni=" + redactor.getDni() + ", titular=" + titular + ", competicio="
				+ competicio + ", equips=" + equips + "]";
	}

}