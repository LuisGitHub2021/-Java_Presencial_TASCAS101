package n3Exercici1;

import java.util.ArrayList;

public class NoticiesF1 extends Noticies {

	private String equips;
	private ValoresFinales vf = new ValoresFinales();

	protected NoticiesF1(Redactors redactor, String titular, String equips) {
		super(redactor, titular);
		this.equips = equips;

	}

	static void crearNoticiesF1(Redactors redactor, ArrayList<Redactors> listaRedactors,
			ArrayList<Noticies> listaNoticies) {
		String titular = Gestor.pideString("Titular");
		if (NoticiesF1.coincideTitular(titular, listaNoticies)) {
			String equips = Gestor.pideString("Equips");
			NoticiesF1 noticiaF1 = new NoticiesF1(redactor, titular, equips);
			NoticiesF1.añadirNoticiasF1(noticiaF1, redactor, listaNoticies);
		}
	}

	public int calcularPunts() {

		puntuacio = 0;
		puntuacio = ValoresFinales.PT_INIT;

		if (equips.equalsIgnoreCase("Ferrari") || equips.equalsIgnoreCase("Mercedes")) {

			puntuacio += vf.PT_EQUIP;
		}

		return puntuacio;
	}

	public int calcularPreu() {

		preu = 0;
		preu = ValoresFinales.PREU_INIT;

		if (equips.equalsIgnoreCase("Ferrari") || equips.equalsIgnoreCase("Mercedes")) {

			preu += vf.PREU_EQUIP;
		}

		return preu;
	}

	private static void añadirNoticiasF1(NoticiesF1 noticiaF1, Redactors redactor, ArrayList<Noticies> listaNoticies) {
		redactor.getListaNoticies().add(noticiaF1);
		listaNoticies.add(noticiaF1);
		System.out.println("Perfecto. Noticia creada correctamente. Gracias!");

	}

	@Override
	public String toString() {
		return "NoticiesF1 [redactor dni=" + redactor.getDni() + ", titular=" + titular + ", equips=" + equips + "]";
	}

	private class ValoresFinales {
		static final int PREU_INIT = 100;
		final int PREU_EQUIP = 50;
		static final int PT_INIT = 4;
		final int PT_EQUIP = 2;

	}
}