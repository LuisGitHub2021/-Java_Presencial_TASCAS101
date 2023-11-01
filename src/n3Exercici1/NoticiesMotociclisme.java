package n3Exercici1;

import java.util.ArrayList;

public class NoticiesMotociclisme extends Noticies {

	private String equips;
	private ValoresFinales vf = new ValoresFinales();

	protected NoticiesMotociclisme(Redactors redactor, String titular, String equips) {
		super(redactor, titular);
		this.equips = equips;

	}

	static void crearNoticiesMotociclisme(Redactors redactor, ArrayList<Redactors> listaRedactors,
			ArrayList<Noticies> listaNoticies) {
		String titular = Gestor.pideString("Titular");
		if (NoticiesMotociclisme.coincideTitular(titular, listaNoticies)) {
			String equips = Gestor.pideString("Equips");
			NoticiesMotociclisme noticiaMotociclisme = new NoticiesMotociclisme(redactor, titular, equips);
			NoticiesMotociclisme.añadirNoticiasMotociclisme(noticiaMotociclisme, redactor, listaNoticies);
		}
	}

	public int calcularPunts() {

		puntuacio = 0;
		puntuacio = ValoresFinales.PT_INIT;

		if (equips.equalsIgnoreCase("Honda") || equips.equalsIgnoreCase("Yamaha")) {

			puntuacio += vf.PT_EQUIP;
		}

		return puntuacio;
	}

	public int calcularPreu() {

		preu = 0;
		preu = ValoresFinales.PREU_INIT;

		if (equips.equalsIgnoreCase("Honda") || equips.equalsIgnoreCase("Yamaha")) {

			preu += vf.PREU_EQUIP;
		}

		return preu;
	}

	private static void añadirNoticiasMotociclisme(NoticiesMotociclisme noticiaMotociclisme, Redactors redactor,
			ArrayList<Noticies> listaNoticies) {
		redactor.getListaNoticies().add(noticiaMotociclisme);
		listaNoticies.add(noticiaMotociclisme);
		System.out.println("Perfecto. Noticia creada correctamente. Gracias!");

	}

	@Override
	public String toString() {
		return "NoticiesMotociclisme [redactor dni=" + redactor.getDni() + ", titular=" + titular + ", equips=" + equips
				+ "]";
	}

	private class ValoresFinales {
		static final int PREU_INIT = 100;
		final int PREU_EQUIP = 50;
		static final int PT_INIT = 3;
		final int PT_EQUIP = 3;

	}

}