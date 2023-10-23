package n3Exercici1;

import java.util.ArrayList;

public class Noticies {

	protected String titular;
	protected String text;
	protected Redactors redactor;
	protected int preu;
	protected int puntuacio;

	// constructor
	protected Noticies(Redactors redactor, String titular) {
		this.titular = titular;
		this.redactor = redactor;

	}

	// metodos de clase
	public int calcularPunts() {

		return puntuacio;
	}

	public int calcularPreu() {

		return preu;
	}

	// sobrescritos
	@Override
	public String toString() {
		return "Noticies [redactor=" + redactor.getDni() + ", titular=" + titular + ", text=" + text + "]";
	}

	// herramientas anexas
	static boolean coincideTitular(String titular, ArrayList<Noticies> listaNoticies) {

		boolean buscar = true;

		if (titular.equals("0")) {
			buscar = false;
			System.out.println("Has salido crear noticia");
		} else if (listaNoticies.stream().anyMatch(e -> e.titular.equalsIgnoreCase(titular))) {
			buscar = false;
			System.out.println("Titular no válido, coincide con otro titular, vuelve a intentarlo");
		}

		return buscar;

	}

	static boolean buscarTitular(String titular, ArrayList<Noticies> listaNoticies) {

		boolean buscar = true;

		if (titular.equals("0")) {
			buscar = false;
			System.out.println("Has salido de eliminar noticia");
		} else if (!(listaNoticies.size() > 0)) {
			buscar = false;
			System.out.println("No hay noticias, tendrás que crear una primero");
		} else if (listaNoticies.stream().noneMatch(e -> e.titular.equalsIgnoreCase(titular))) {
			buscar = false;
			System.out.println("No hay ninguna coincidencia con ese titular, vuelve a intentarlo");
		}

		return buscar;

	}
}