package n3Exercici1;

import java.util.ArrayList;

abstract class Noticies {

	protected String titular;
	protected String text;
	protected Redactors redactor;
	protected int preu;
	protected int puntuacio;

	protected Noticies(Redactors redactor, String titular) {
		this.titular = titular;
		this.redactor = redactor;

	}

	abstract int calcularPunts();

	abstract int calcularPreu();

	@Override
	public String toString() {
		return "Noticies [redactor=" + redactor.getDni() + ", titular=" + titular + ", text=" + text + "]";
	}

	static boolean coincideTitular(String titular, ArrayList<Noticies> listaNoticies) {

		boolean buscar = true;

		if (titular.equals("0")) {
			buscar = false;
			System.out.println("Has salido");
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
			System.out.println("Has salido");
		} else if (!(listaNoticies.size() > 0)) {
			buscar = false;
			System.out.println("No hay noticias, tendrás que crear una primero");
		} else if (listaNoticies.stream().noneMatch(e -> e.titular.equalsIgnoreCase(titular))) {
			buscar = false;
			System.out.println("No hay ninguna coincidencia con ese titular, vuelve a intentarlo");
		}

		return buscar;

	}

	static void calcularNoticia(int opcion, ArrayList<Noticies> listaNoticies) {
		String titular = Gestor.pideString("Introduzca el titular, pulse 0 para salir");
		if (Noticies.buscarTitular(titular, listaNoticies)) {
			for (int i = 0; i < listaNoticies.size(); i++) {
				if (listaNoticies.get(i).titular.equalsIgnoreCase(titular) && opcion == 6) {
					System.out.println("Los puntos de la noticia con titular : " + listaNoticies.get(i).titular
							+ " son de: " + listaNoticies.get(i).calcularPunts() + " pt");
				} else if (listaNoticies.get(i).titular.equalsIgnoreCase(titular) && opcion == 7){
					System.out.println("Los puntos de la noticia con titular : " + listaNoticies.get(i).titular
							+ " son de: " + listaNoticies.get(i).calcularPreu() + " euros");

				}

			}
		}
	}

	static void calcularNoticiaPreu(ArrayList<Noticies> listaNoticies) {
		String titular = Gestor.pideString("Introduzca el titular, pulse 0 para salir");
		if (Noticies.buscarTitular(titular, listaNoticies)) {
			for (int i = 0; i < listaNoticies.size(); i++) {
				if (listaNoticies.get(i).titular.equalsIgnoreCase(titular)) {
					System.out.println("Los puntos de la noticia con titular : " + listaNoticies.get(i).titular
							+ " son de: " + listaNoticies.get(i).calcularPunts() + " pt");
				}

			}
		}
	}
}