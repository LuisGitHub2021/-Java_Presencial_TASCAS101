package n3Exercici1;

public class NoticiesFutbol extends Noticies {

	static final int PREU_INIT = 300;
	final int PREU_COMPETICIO = 100;
	final int PREU_EQUIP = 100;
	final int PREU_JUGADORS = 50;
	static final int PT_INIT = 5;
	final int PT_COMPETICIO_CHAMPIONS = 3;
	final int PT_COMPETICIO_LLIGA = 2;
	final int PT_EQUIP = 1;
	final int PT_JUGADORS = 1;
	private String competicio;
	private String equips;
	private String jugadors;

	// constructor
	protected NoticiesFutbol(Redactors redactor, String titular, String competicio, String equips, String jugadors) {
		super(redactor, titular);
		this.competicio = competicio;
		this.equips = equips;
		this.jugadors = jugadors;

	}

	// metodos de clase
	static NoticiesFutbol crearNoticiesFutbol(Redactors redactor, String titular, String competicio, String equips,
			String jugadors) {

		return new NoticiesFutbol(redactor, titular, competicio, equips, jugadors);

	}

	public int calcularPunts() {

		puntuacio = 0;
		puntuacio = super.calcularPunts() + PT_INIT;

		if (competicio.equalsIgnoreCase("LLiga de Campions")) {

			puntuacio += PT_COMPETICIO_CHAMPIONS;

		} else if (competicio.equalsIgnoreCase("Lliga")) {
			puntuacio += PT_COMPETICIO_LLIGA;

		}

		if (equips.equalsIgnoreCase("Barça") || equips.equalsIgnoreCase("Madrid")) {

			puntuacio += PT_EQUIP;
		}

		if (jugadors.equalsIgnoreCase("Ferran Torres") || jugadors.equalsIgnoreCase("Benzema")) {

			puntuacio += PT_JUGADORS;
		}

		return puntuacio;
	}

	public int calcularPreu() {

		preu = 0;
		preu = super.calcularPreu() + PREU_INIT;

		if (competicio.equalsIgnoreCase("Lliga de Campions")) {

			preu += PREU_COMPETICIO;
		}

		if (equips.equalsIgnoreCase("Barça") || equips.equalsIgnoreCase("Madrid")) {

			preu += PREU_EQUIP;
		}

		if (jugadors.equalsIgnoreCase("Ferran Torres") || jugadors.equalsIgnoreCase("Benzema")) {

			preu += PREU_JUGADORS;
		}

		return preu;
	}

	// sobrescritos
	@Override
	public String toString() {
		return "NoticiesFutbol [redactor dni=" + redactor.getDni() + ", titular=" + titular + ", competicio="
				+ competicio + ", equips=" + equips + ", jugadors=" + jugadors + "]";
	}

}