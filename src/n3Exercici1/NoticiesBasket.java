package n3Exercici1;

import java.util.ArrayList;

public class NoticiesBasket extends Noticies {

	private String competicio;
	private String equips;
	private ValoresFinales vf = new ValoresFinales();

	protected NoticiesBasket(Redactors redactor, String titular, String competicio, String equips) {
		super(redactor, titular);
		this.competicio = competicio;
		this.equips = equips;

	}

	static void crearNoticiesBasket(Redactors redactor, ArrayList<Redactors> listaRedactors,
			ArrayList<Noticies> listaNoticies) {
		String titular = Gestor.pideString("Titular");
		if (NoticiesBasket.coincideTitular(titular, listaNoticies)) {
			String competicio = Gestor.pideString("Competicio");
			String equips = Gestor.pideString("Equips");
			NoticiesBasket noticiaBasket = new NoticiesBasket(redactor, titular, competicio, equips);
			NoticiesBasket.añadirNoticiasBasket(noticiaBasket, redactor, listaNoticies);

		}
	}

	public int calcularPunts() {

		puntuacio = 0;
		puntuacio = ValoresFinales.PT_INIT;

		if (competicio.equalsIgnoreCase("Eurolliga")) {

			puntuacio += vf.PT_COMPETICIO;

		} else if (competicio.equalsIgnoreCase("ACB")) {

			puntuacio += vf.PT_COMPETICIO_ACB;
		}

		if (equips.equalsIgnoreCase("Barça") || equips.equalsIgnoreCase("Madrid")) {

			puntuacio += vf.PT_EQUIP;
		}

		return puntuacio;
	}

	public int calcularPreu() {

		preu = 0;
		preu = ValoresFinales.PREU_INIT;

		if (competicio.equalsIgnoreCase("Eurolliga")) {

			preu += vf.PREU_COMPETICIO;
		}

		if (equips.equalsIgnoreCase("Barça") || equips.equalsIgnoreCase("Madrid")) {

			preu += vf.PREU_EQUIP;
		}

		return preu;
	}

	private static void añadirNoticiasBasket(NoticiesBasket noticiaBasket, Redactors redactor,
			ArrayList<Noticies> listaNoticies) {
		redactor.getListaNoticies().add(noticiaBasket);
		listaNoticies.add(noticiaBasket);
		System.out.println("Perfecto. Noticia creada correctamente. Gracias!");

	}

	@Override
	public String toString() {
		return "NoticiesBasket [redactor dni=" + redactor.getDni() + ", titular=" + titular + ", competicio="
				+ competicio + ", equips=" + equips + "]";
	}

	private class ValoresFinales {
		static final int PREU_INIT = 250;
		final int PREU_COMPETICIO = 75;
		final int PREU_EQUIP = 75;
		static final int PT_INIT = 4;
		final int PT_COMPETICIO = 3;
		final int PT_COMPETICIO_ACB = 2;
		final int PT_EQUIP = 1;

	}

}