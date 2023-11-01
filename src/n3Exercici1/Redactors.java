package n3Exercici1;

import java.util.ArrayList;

public class Redactors {

	private String nom;
	private String dni;
	private static final int SOU = 1500;
	private ArrayList<Noticies> listaNoticies;

	private Redactors(String nom, String dni) {
		this.nom = nom;
		this.dni = dni;
		this.listaNoticies = new ArrayList<Noticies>();

	}

	public String getDni() {
		return dni;
	}

	public ArrayList<Noticies> getListaNoticies() {
		return listaNoticies;
	}

	static void crearRedactor(ArrayList<Redactors> listaRedactors) {
		String dni = Gestor.pideString("DNI del redactor o pulse 0 para salir");
		if (Redactors.coincideCandidato(dni, listaRedactors)) {
			String nom = Gestor.pideString("Nombre del redactor?");
			Redactors redactor = new Redactors(nom, dni);
			Redactors.añadirRedactor(redactor, listaRedactors);
			System.out.println("Creado y añadido correctamente!");
		}
	}

	private static void añadirRedactor(Redactors redactor, ArrayList<Redactors> listaRedactors) {

		listaRedactors.add(redactor);

	}

	static void eliminarRedactor(ArrayList<Redactors> listaRedactors) {

		String dni = Gestor.pideString("DNI del redactor o pulse 0 para salir");
		if (Redactors.buscarCandidato(dni, listaRedactors)) {

			for (int i = 0; i < listaRedactors.size(); i++) {
				if (listaRedactors.get(i).dni.equalsIgnoreCase(dni)) {
					listaRedactors.remove(i);
					System.out.println("El redactor con DNI: " + dni + " ha sido borrado de la lista");
				}
			}
		}
	}

	static void introducirNoticiaRedactor(ArrayList<Redactors> listaRedactors, ArrayList<Noticies> listaNoticies) {

		String dni = Gestor.pideString("DNI del redactor o pulse 0 para salir");
		if (Redactors.buscarCandidato(dni, listaRedactors)) {
			for (int i = 0; i < listaRedactors.size(); i++) {
				if (listaRedactors.get(i).dni.equalsIgnoreCase(dni)) {
					Redactors redactor = listaRedactors.get(i);

					System.out.println("REDACTAR NOTICIA");
					int opcion = Gestor.pideInt("1. FUTBOL\n2. BASKET\n3. TENIS\n4. F1\n5. MOTOCICLISME"
							+ "\nNumero de la OPCION que desea realizar, pulse 0 para salir");

					switch (opcion) {

					case 0:
						// SALIR
						System.out.println("Has salido");
						break;
					case 1:
						// CREAR Y AÑADIR NOTICIA FUTBOL
						NoticiesFutbol.crearNoticiesFutbol(redactor, listaRedactors, listaNoticies);
						break;
					case 2:
						// CREAR Y AÑADIR NOTICIA BASKET
						NoticiesBasket.crearNoticiesBasket(redactor, listaRedactors, listaNoticies);
						break;
					case 3:
						// CREAR Y AÑADIR NOTICIA TENIS
						NoticiesTenis.crearNoticiesTenis(redactor, listaRedactors, listaNoticies);
						break;
					case 4:
						// CREAR Y AÑADIR NOTICIA F1
						NoticiesF1.crearNoticiesF1(redactor, listaRedactors, listaNoticies);
						break;
					case 5:
						// CREAR Y AÑADIR NOTICIA MOTOCICLISME
						NoticiesMotociclisme.crearNoticiesMotociclisme(redactor, listaRedactors, listaNoticies);
						break;
					default:
						System.out.println("Opción no válida, vuelve a intentarlo");
						Gestor.pideMensaje("REDACTAR NOTICIA");
						opcion = Gestor.pideInt("1. FUTBOL\n2. BASKET\n3. TENIS\n4. F1\n5. MOTOCICLISME"
								+ "\nNumero de la OPCION que desea realizar, pulse 0 para salir");

					}
				}
			}
		}
	}

	static void eliminarNoticiaRedactor(ArrayList<Redactors> listaRedactors, ArrayList<Noticies> listaNoticies) {

		String dni = Gestor.pideString("DNI del redactor o pulse 0 para salir");
		if (Redactors.buscarCandidato(dni, listaRedactors)) {
			for (int i = 0; i < listaRedactors.size(); i++) {
				if (listaRedactors.get(i).dni.equalsIgnoreCase(dni)) {
					String titular = Gestor.pideString("Introduzca el titular, pulse 0 para salir");
					if (Noticies.buscarTitular(titular, listaNoticies)) {
						int h = 0;
						for (int j = 0; j < listaRedactors.get(i).getListaNoticies().size(); j++) {
							if (listaRedactors.get(i).getListaNoticies().get(j).titular.equalsIgnoreCase(titular)) {
								System.out.println("La noticia del redactor con DNI: " + listaRedactors.get(i).dni
										+ " y Titular: " + listaRedactors.get(i).getListaNoticies().get(j).titular
										+ " ha sido borrada de la lista de noticies del redactor");
								listaRedactors.get(i).getListaNoticies().remove(j);
								h++;
							}
						}
						if (h == 0) {
							System.out.println("Este titular es de otro redactor");
						}
					} else {
						System.out.println("No hay noticias con ese titular");
					}
				}
			}
		}
	}

	static void mostrarNoticiasRedactor(ArrayList<Redactors> listaRedactors) {

		String dni = Gestor.pideString("DNI del redactor o pulse 0 para salir");
		if (Redactors.buscarCandidato(dni, listaRedactors)) {

			for (int i = 0; i < listaRedactors.size(); i++) {
				if (listaRedactors.get(i).dni.equalsIgnoreCase(dni)) {

					for (Noticies noticia : listaRedactors.get(i).getListaNoticies()) {
						System.out.println(noticia);
					}
				}
			}
		}
	}

	@Override
	public String toString() {
		return "Redactors [nom=" + nom + ", DNI=" + dni + ", noticies=" + listaNoticies + "]";
	}

	private static boolean coincideCandidato(String dni, ArrayList<Redactors> listaRedactors) {

		boolean buscar = true;

		if (dni.equals("0")) {
			buscar = false;
			System.out.println("Has salido");
		} else if (listaRedactors.stream().anyMatch(e -> e.dni.equalsIgnoreCase(dni))) {
			buscar = false;
			System.out.println("DNI no válido, coincide con otro, vuelve a intentarlo");
		}

		return buscar;

	}

	private static boolean buscarCandidato(String dni, ArrayList<Redactors> listaRedactors) {

		boolean buscar = true;

		if (dni.equals("0")) {
			buscar = false;
			System.out.println("Has salido");
		} else if (!(listaRedactors.size() > 0)) {
			buscar = false;
			System.out.println("No hay redactores, tendrás que crear uno primero");
		} else if (listaRedactors.stream().noneMatch(e -> e.dni.equalsIgnoreCase(dni))) {
			buscar = false;
			System.out.println("DNI no válido, no coincide, vuelve a intentarlo");
		}

		return buscar;

	}

}