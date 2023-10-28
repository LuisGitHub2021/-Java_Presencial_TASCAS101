package n3Exercici1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Redactors {

	private String nom;
	private String dni;
	private static final int SOU = 1500;
	private ArrayList<Noticies> listaNoticies;

	// constructor
	public Redactors(String nom, String dni) {
		this.nom = nom;
		this.dni = dni;
		this.listaNoticies = new ArrayList<Noticies>();

	}

	public String getDni() {
		return dni;
	}

	// metodos de clase
	static Redactors crearRedactor(String nom, String dni) {

		return new Redactors(nom, dni);

	}

	static ArrayList<Redactors> añadirRedactor(Redactors redactor, ArrayList<Redactors> listaRedactors) {

		listaRedactors.add(redactor);

		return listaRedactors;

	}

	static void eliminarRedactor(String dni, ArrayList<Redactors> listaRedactors) {

		List<Redactors> lista = listaRedactors.stream().filter(e -> e.dni.equalsIgnoreCase(dni))
				.collect(Collectors.toList());

		listaRedactors.removeAll(lista);
		lista.removeAll(lista);

		System.out.println("El redactor con DNI: " + dni + " ha sido borrado de la lista");

	}

	static void introducirNoticiaRedactor(String candidato, ArrayList<Redactors> listaRedactors,
			ArrayList<Noticies> listaNoticies) {

		List<Redactors> lista = listaRedactors.stream().filter(e -> e.dni.equalsIgnoreCase(candidato))
				.collect(Collectors.toList());

		PideDatos.pideMensaje("REDACTAR NOTICIA");
		int opcion = PideDatos.pideInt("1. FUTBOL\n2. BASKET\n3. TENIS\n4. F1\n5. MOTOCICLISME"
				+ "\nNumero de la OPCION que desea realizar, pulse 0 para salir");

		switch (opcion) {

		case 0:
			// SALIR
			System.out.println("Has salido de introducir noticia al redactor. Adios!");
			break;
		case 1:
			// CREAR Y AÑADIR NOTICIA FUTBOL
			String titular1 = PideDatos.pideString("Titular");
			if (NoticiesFutbol.coincideTitular(titular1, listaNoticies)) {
				NoticiesFutbol noticiaFutbol = NoticiesFutbol.crearNoticiesFutbol(lista.get(0), titular1,
						PideDatos.pideString("Competicio"), PideDatos.pideString("Equips"),
						PideDatos.pideString("Jugadors"));
				lista.get(0).listaNoticies.add(noticiaFutbol);
				listaNoticies.add(noticiaFutbol);
				lista.removeAll(lista);
				System.out.println("Perfecto. Noticia creada correctamente. Gracias!");
			}
			break;
		case 2:
			// CREAR Y AÑADIR NOTICIA BASKET
			String titular2 = PideDatos.pideString("Titular");
			if (NoticiesBasket.coincideTitular(titular2, listaNoticies)) {
				NoticiesBasket noticiaBasket = NoticiesBasket.crearNoticiesBasket(lista.get(0), titular2,
						PideDatos.pideString("Competicio"), PideDatos.pideString("Equips"));
				lista.get(0).listaNoticies.add(noticiaBasket);
				listaNoticies.add(noticiaBasket);
				lista.removeAll(lista);
				System.out.println("Perfecto. Noticia creada correctamente. Gracias!");
			}
			break;
		case 3:
			// CREAR Y AÑADIR NOTICIA TENIS
			String titular3 = PideDatos.pideString("Titular");
			if (NoticiesTenis.coincideTitular(titular3, listaNoticies)) {
				NoticiesTenis noticiaTenis = NoticiesTenis.crearNoticiesTenis(lista.get(0), titular3,
						PideDatos.pideString("Jugadors"));
				lista.get(0).listaNoticies.add(noticiaTenis);
				listaNoticies.add(noticiaTenis);
				lista.removeAll(lista);
				System.out.println("Perfecto. Noticia creada correctamente. Gracias!");
			}
			break;
		case 4:
			// CREAR Y AÑADIR NOTICIA F1
			String titular4 = PideDatos.pideString("Titular");
			if (NoticiesF1.coincideTitular(titular4, listaNoticies)) {
				NoticiesF1 noticiaF1 = NoticiesF1.crearNoticiesF1(lista.get(0), titular4,
						PideDatos.pideString("Equips"));
				lista.get(0).listaNoticies.add(noticiaF1);
				listaNoticies.add(noticiaF1);
				lista.removeAll(lista);
				System.out.println("Perfecto. Noticia creada correctamente. Gracias!");
			}
			break;
		case 5:
			// CREAR Y AÑADIR NOTICIA MOTOCICLISME
			String titular5 = PideDatos.pideString("Titular");
			if (NoticiesMotociclisme.coincideTitular(titular5, listaNoticies)) {
				NoticiesMotociclisme noticiaMotociclisme = NoticiesMotociclisme.crearNoticiesMotociclisme(lista.get(0),
						titular5, PideDatos.pideString("Equips"));
				lista.get(0).listaNoticies.add(noticiaMotociclisme);
				listaNoticies.add(noticiaMotociclisme);
				lista.removeAll(lista);
				System.out.println("Perfecto. Noticia creada correctamente. Gracias!");
			}
			break;
		default:
			System.out.println("Opción no válida, vuelve a intentarlo");
			PideDatos.pideMensaje("REDACTAR NOTICIA");
			opcion = PideDatos.pideInt("1. FUTBOL\n2. BASKET\n3. TENIS\n4. F1\n5. MOTOCICLISME"
					+ "\nNumero de la OPCION que desea realizar, pulse 0 para salir");

		}

	}

	static void eliminarNoticiaRedactor(String candidato, String titular, ArrayList<Redactors> listaRedactors,
			ArrayList<Noticies> listaNoticies) {

		List<Redactors> lista = listaRedactors.stream().filter(e -> e.dni.equalsIgnoreCase(candidato))
				.collect(Collectors.toList());

		if (lista.get(0).listaNoticies.stream().noneMatch(e -> e.titular.equalsIgnoreCase(titular))) {
			System.out.println("Este titular es de otro redactor");

		} else {
			List<Noticies> listaTitularEliminar = lista.get(0).listaNoticies.stream()
					.filter(e -> e.titular.equalsIgnoreCase(titular)).collect(Collectors.toList());

			lista.get(0).listaNoticies.removeAll(listaTitularEliminar);
			listaNoticies.removeAll(listaTitularEliminar);
			System.out.println("La noticia del redactor con DNI: " + lista.get(0).dni + " y Titular: "
					+ listaTitularEliminar.get(0).titular + " ha sido borrada de la lista de noticies del redactor");
			listaTitularEliminar.removeAll(listaTitularEliminar);
		}
	}

	static void mostrarNoticiasRedactor(String candidato, ArrayList<Redactors> listaRedactors) {

		List<Redactors> lista = listaRedactors.stream().filter(e -> e.dni.equalsIgnoreCase(candidato))
				.collect(Collectors.toList());

		for (Noticies noticia : lista.get(0).listaNoticies) {
			System.out.println(noticia);
		}
	}

	// sobrescritos
	@Override
	public String toString() {
		return "Redactors [nom=" + nom + ", DNI=" + dni + ", noticies=" + listaNoticies + "]";
	}

	// herramientas anexas
	static boolean coincideCandidato(String candidato, ArrayList<Redactors> listaRedactors) {

		boolean buscar = true;

		if (candidato.equals("0")) {
			buscar = false;
			System.out.println("Has salido de introducir dni");
		} else if (listaRedactors.stream().anyMatch(e -> e.dni.equalsIgnoreCase(candidato))) {
			buscar = false;
			System.out.println("DNI no válido, coincide con otro, vuelve a intentarlo");
		}

		return buscar;

	}

	static boolean buscarCandidato(String candidato, ArrayList<Redactors> listaRedactors) {

		boolean buscar = true;

		if (candidato.equals("0")) {
			buscar = false;
			System.out.println("Has salido de introducir dni");
		} else if (!(listaRedactors.size() > 0)) {
			buscar = false;
			System.out.println("No hay redactores, tendrás que crear uno primero");
		} else if (listaRedactors.stream().noneMatch(e -> e.dni.equalsIgnoreCase(candidato))) {
			buscar = false;
			System.out.println("DNI no válido, no coincide, vuelve a intentarlo");
		}

		return buscar;

	}

}