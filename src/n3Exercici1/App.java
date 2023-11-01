package n3Exercici1;

import java.util.ArrayList;

public class App {

	public static void main(String[] args) {

		ArrayList<Redactors> listaRedactors = new ArrayList<Redactors>();
		ArrayList<Noticies> listaNoticies = new ArrayList<Noticies>();
		pideMenuPrincipal(listaNoticies, listaRedactors);
	}

	static void pideMenuPrincipal(ArrayList<Noticies> listaNoticies, ArrayList<Redactors> listaRedactors) {

		System.out.println("GESTION NOTICIAS & REDACTORES\n1. INTRODUCIR REDACTOR\n2. ELIMINAR REDACTOR"
				+ "\n3. INTRODUCIR NOTICIA AL REDACTOR\n4. ELIMINAR NOTICIA\n5. MOSTRAR NOTICIAS DEL REDACTOR"
				+ "\n6. CALCULAR PUNTOS DE LA NOTICIA\n7. CALCULAR PRECIO DE LA NOTICIA");
		int opcion = Gestor.pideInt("Numero de la OPCION que desea realizar, pulse 0 para salir");
		while (opcion > 0) {

			switch (opcion) {

			case 1:
				// INTRODUCIR REDACTOR
				System.out.println("INTRODUCIR REDACTOR");
				Redactors.crearRedactor(listaRedactors);
				break;
			case 2:
				// ELIMINAR REDACTOR
				System.out.println("ELIMINAR REDACTOR");
				Redactors.eliminarRedactor(listaRedactors);
				break;
			case 3:
				// INTRODUCIR NOTICIA
				System.out.println("INTRODUCIR NOTICIA AL REDACTOR");
				Redactors.introducirNoticiaRedactor(listaRedactors, listaNoticies);
				break;
			case 4:
				// ELIMINAR NOTICIA (SOLICITAR REDACTOR Y TITULAR)
				System.out.println("ELIMINAR NOTICIA");
				Redactors.eliminarNoticiaRedactor(listaRedactors, listaNoticies);
				break;
			case 5:
				// MOSTRAR NOTICIAS POR REDACTOR
				System.out.println("MOSTRAR NOTICIAS DEL REDACTOR");
				Redactors.mostrarNoticiasRedactor(listaRedactors);

				break;
			case 6:
				// CALCULAR NOTICIA PUNTS
				System.out.println("CALCULAR PUNTOS DE LA NOTICIA");
				Noticies.calcularNoticia(opcion, listaNoticies);
				break;
			case 7:
				// CALCULAR NOTICIA PREU
				System.out.println("CALCULAR PRECIO DE LA NOTICIA");
				Noticies.calcularNoticia(opcion, listaNoticies);
				break;
			default:
				System.out.println("Opción no válida, vuelve a intentarlo\nGESTION NOTICIAS & REDACTORES");
				opcion = Gestor.pideInt("Introduzca el número de la OPCION que desea realizar");

			}
			System.out.println("GESTION NOTICIAS & REDACTORES\n1. INTRODUCIR REDACTOR\n2. ELIMINAR REDACTOR"
					+ "\n3. INTRODUCIR NOTICIA AL REDACTOR\n4. ELIMINAR NOTICIA\n5. MOSTRAR NOTICIAS DEL REDACTOR"
					+ "\n6. CALCULAR PUNTOS DE LA NOTICIA\n7. CALCULAR PRECIO DE LA NOTICIA");
			opcion = Gestor.pideInt("Numero de la OPCION que desea realizar, pulse 0 para salir");
		}
		System.out.println("Apagamos el programa. Gracias!");

	}

}