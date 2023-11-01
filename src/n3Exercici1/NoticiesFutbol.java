package n3Exercici1;

import java.util.ArrayList;

public class NoticiesFutbol extends Noticies {

	private String competicio;
	private String equips;
	private String jugadors;
	private ValoresFinales vf = new ValoresFinales();

	protected NoticiesFutbol(Redactors redactor, String titular, String competicio, String equips, String jugadors) {
		super(redactor, titular);
		this.competicio = competicio;
		this.equips = equips;
		this.jugadors = jugadors;

	}

	static void crearNoticiesFutbol(Redactors redactor, ArrayList<Redactors> listaRedactors,
			ArrayList<Noticies> listaNoticies) {
		String titular = Gestor.pideString("Titular");
		if (NoticiesFutbol.coincideTitular(titular, listaNoticies)) {
			String competicio = Gestor.pideString("Competicio");
			String equips = Gestor.pideString("Equips");
			String jugadors = Gestor.pideString("Jugadors");
			NoticiesFutbol noticiaFutbol = new NoticiesFutbol(redactor, titular, competicio, equips, jugadors);
			NoticiesFutbol.añadirNoticiasFutbol(noticiaFutbol, redactor, listaNoticies);
		}

	}

	public int calcularPunts() {

		puntuacio = 0;
		puntuacio = ValoresFinales.PT_INIT;

		if (competicio.equalsIgnoreCase("LLiga de Campions")) {

			puntuacio += vf.PT_COMPETICIO_CHAMPIONS;

		} else if (competicio.equalsIgnoreCase("Lliga")) {
			puntuacio += vf.PT_COMPETICIO_LLIGA;

		}

		if (equips.equalsIgnoreCase("Barça") || equips.equalsIgnoreCase("Madrid")) {

			puntuacio += vf.PT_EQUIP;
		}

		if (jugadors.equalsIgnoreCase("Ferran Torres") || jugadors.equalsIgnoreCase("Benzema")) {

			puntuacio += vf.PT_JUGADORS;
		}

		return puntuacio;
	}

	public int calcularPreu() {

		preu = 0;
		preu = ValoresFinales.PREU_INIT;

		if (competicio.equalsIgnoreCase("Lliga de Campions")) {

			preu += vf.PREU_COMPETICIO;
		}

		if (equips.equalsIgnoreCase("Barça") || equips.equalsIgnoreCase("Madrid")) {

			preu += vf.PREU_EQUIP;
		}

		if (jugadors.equalsIgnoreCase("Ferran Torres") || jugadors.equalsIgnoreCase("Benzema")) {

			preu += vf.PREU_JUGADORS;
		}

		return preu;
	}

	private static void añadirNoticiasFutbol(NoticiesFutbol noticiaFutbol, Redactors redactor,
			ArrayList<Noticies> listaNoticies) {
		redactor.getListaNoticies().add(noticiaFutbol);
		listaNoticies.add(noticiaFutbol);
		System.out.println("Perfecto. Noticia creada correctamente. Gracias!");

	}

	@Override
	public String toString() {
		return "NoticiesFutbol [redactor dni=" + redactor.getDni() + ", titular=" + titular + ", competicio="
				+ competicio + ", equips=" + equips + ", jugadors=" + jugadors + "]";
	}

	private class ValoresFinales {
		static final int PREU_INIT = 300;
		final int PREU_COMPETICIO = 100;
		final int PREU_EQUIP = 100;
		final int PREU_JUGADORS = 50;
		static final int PT_INIT = 5;
		final int PT_COMPETICIO_CHAMPIONS = 3;
		final int PT_COMPETICIO_LLIGA = 2;
		final int PT_EQUIP = 1;
		final int PT_JUGADORS = 1;

	}

}