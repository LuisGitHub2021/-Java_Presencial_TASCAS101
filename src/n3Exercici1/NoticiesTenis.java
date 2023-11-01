package n3Exercici1;

import java.util.ArrayList;

public class NoticiesTenis extends Noticies {

	private String jugadors;
	private ValoresFinales vf = new ValoresFinales();

	protected NoticiesTenis(Redactors redactor, String titular, String jugadors) {
		super(redactor, titular);
		this.jugadors = jugadors;
	}

	static void crearNoticiesTenis(Redactors redactor, ArrayList<Redactors> listaRedactors,
			ArrayList<Noticies> listaNoticies) {
		String titular = Gestor.pideString("Titular");
		if (NoticiesTenis.coincideTitular(titular, listaNoticies)) {
			String jugadors = Gestor.pideString("Jugadors");
			NoticiesTenis noticiaTenis = new NoticiesTenis(redactor, titular, jugadors);
			NoticiesTenis.añadirNoticiasTenis(noticiaTenis, redactor, listaNoticies);
		}
	}

	public int calcularPunts() {

		puntuacio = 0;
		puntuacio = ValoresFinales.PT_INIT;

		if (jugadors.equalsIgnoreCase("Federer") || jugadors.equalsIgnoreCase("Nadal")
				|| jugadors.equalsIgnoreCase("Djokovic")) {

			puntuacio += vf.PT_JUGADORS;
		}

		return puntuacio;
	}

	public int calcularPreu() {

		preu = 0;
		preu = ValoresFinales.PREU_INIT;

		if (jugadors.equalsIgnoreCase("Federer") || jugadors.equalsIgnoreCase("Nadal")
				|| jugadors.equalsIgnoreCase("Djokovic")) {

			preu += vf.PREU_JUGADORS;
		}

		return preu;
	}

	private static void añadirNoticiasTenis(NoticiesTenis noticiaTenis, Redactors redactor,
			ArrayList<Noticies> listaNoticies) {
		redactor.getListaNoticies().add(noticiaTenis);
		listaNoticies.add(noticiaTenis);
		System.out.println("Perfecto. Noticia creada correctamente. Gracias!");

	}

	@Override
	public String toString() {
		return "NoticiesTenis [redactor dni=" + redactor.getDni() + ", titular=" + titular + ", jugadors=" + jugadors
				+ "]";
	}

	private class ValoresFinales {
		static final int PREU_INIT = 150;
		final int PREU_JUGADORS = 100;
		static final int PT_INIT = 4;
		final int PT_JUGADORS = 3;

	}
}