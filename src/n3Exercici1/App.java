package n3Exercici1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {

	public static void main(String[] args) {

		ArrayList<Redactors> listaRedactors = new ArrayList<Redactors>();
		ArrayList<Noticies> listaNoticies = new ArrayList<Noticies>();

		pideMenuPrincipal(listaNoticies, listaRedactors);

	}

	static void pideMenuPrincipal(ArrayList<Noticies> listaNoticies, ArrayList<Redactors> listaRedactors) {

		PideDatos.pideMensaje(
				"GESTION NOTICIAS & REDACTORES\n1. INTRODUCIR REDACTOR\n2. ELIMINAR REDACTOR\n3. INTRODUCIR NOTICIA AL REDACTOR\n4. ELIMINAR NOTICIA\n5. MOSTRAR NOTICIAS DEL REDACTOR\n6. CALCULAR PUNTOS DE LA NOTICIA\n7. CALCULAR PRECIO DE LA NOTICIA");
		int opcion = PideDatos.pideInt("Numero de la OPCION que desea realizar, pulse 0 para salir");
		while (opcion > 0) {

			switch (opcion) {

			case 1:
				// INTRODUCIR REDACTOR
				PideDatos.pideMensaje("INTRODUCIR REDACTOR");
				String candidato1 = PideDatos.pideString("Introduzca el DNI del redactor, pulse 0 para salir");
				if (Redactors.coincideCandidato(candidato1, listaRedactors)) {
					Redactors.añadirRedactor(
							Redactors.crearRedactor(PideDatos.pideString("Nombre del redactor?"), candidato1),
							listaRedactors);
				}
				break;
			case 2:
				// ELIMINAR REDACTOR
				PideDatos.pideMensaje("ELIMINAR REDACTOR");
				String candidato2 = PideDatos.pideString("Introduzca el DNI del redactor, pulse 0 para salir");
				if (Redactors.buscarCandidato(candidato2, listaRedactors)) {
					Redactors.eliminarRedactor(candidato2, listaRedactors);
				}
				break;
			case 3:
				// INTRODUCIR NOTICIA
				PideDatos.pideMensaje("INTRODUCIR NOTICIA AL REDACTOR");
				String candidato3 = PideDatos.pideString("Introduzca el DNI del redactor, pulse 0 para salir");
				if (Redactors.buscarCandidato(candidato3, listaRedactors)) {
					Redactors.introducirNoticiaRedactor(candidato3, listaRedactors, listaNoticies);
				}
				break;
			case 4:
				// ELIMINAR NOTICIA (SOLICITAR REDACTOR Y TITULAR)
				PideDatos.pideMensaje("ELIMINAR NOTICIA");
				String candidato4 = PideDatos.pideString("Introduzca el DNI del redactor, pulse 0 para salir");
				if (Redactors.buscarCandidato(candidato4, listaRedactors)) {
					String titular4 = PideDatos.pideString("Introduzca el titular, pulse 0 para salir");
					if (Noticies.buscarTitular(titular4, listaNoticies)) {
						Redactors.eliminarNoticiaRedactor(candidato4, titular4, listaRedactors, listaNoticies);
					}
				}
				break;
			case 5:
				// MOSTRAR NOTICIAS POR REDACTOR
				PideDatos.pideMensaje("MOSTRAR NOTICIAS DEL REDACTOR");
				String candidato5 = PideDatos.pideString("Introduzca el DNI del redactor, pulse 0 para salir");
				if (Redactors.buscarCandidato(candidato5, listaRedactors)) {
					Redactors.mostrarNoticiasRedactor(candidato5, listaRedactors);
				}
				break;
			case 6:
				// CALCULAR NOTICIA PUNTS
				PideDatos.pideMensaje("CALCULAR PUNTOS DE LA NOTICIA");
				String titular6 = PideDatos.pideString("Introduzca el titular, pulse 0 para salir");
				if (Noticies.buscarTitular(titular6, listaNoticies)) {
					List<Noticies> lista = listaNoticies.stream().filter(e -> e.titular.equalsIgnoreCase(titular6))
							.collect(Collectors.toList());
					System.out.println("Los puntos de la noticia con titular : " + lista.get(0).titular + " son de: "
							+ lista.get(0).calcularPunts() + " pt");

				}
				break;
			case 7:
				// CALCULAR NOTICIA PREU
				PideDatos.pideMensaje("CALCULAR PRECIO DE LA NOTICIA");
				String titular7 = PideDatos.pideString("Introduzca el titular, pulse 0 para salir");
				if (Noticies.buscarTitular(titular7, listaNoticies)) {
					List<Noticies> lista = listaNoticies.stream().filter(e -> e.titular.equalsIgnoreCase(titular7))
							.collect(Collectors.toList());
					System.out.println("El precio de la noticia con titular : " + lista.get(0).titular + " es de: "
							+ lista.get(0).calcularPreu() + " €");

				}
				break;
			default:
				System.out.println("Opción no válida, vuelve a intentarlo");
				PideDatos.pideMensaje("GESTION NOTICIAS & REDACTORES");
				opcion = PideDatos.pideInt("Introduzca el número de la OPCION que desea realizar");

			}
			PideDatos.pideMensaje(
					"GESTION NOTICIAS & REDACTORES\n1. INTRODUCIR REDACTOR\n2. ELIMINAR REDACTOR\n3. INTRODUCIR NOTICIA AL REDACTOR\n4. ELIMINAR NOTICIA\n5. MOSTRAR NOTICIAS DEL REDACTOR\n6. CALCULAR PUNTOS DE LA NOTICIA\n7. CALCULAR PRECIO DE LA NOTICIA");
			opcion = PideDatos.pideInt("Numero de la OPCION que desea realizar, pulse 0 para salir");
		}
		PideDatos.pideMensaje("Apagamos el programa. Gracias!");

	}

}