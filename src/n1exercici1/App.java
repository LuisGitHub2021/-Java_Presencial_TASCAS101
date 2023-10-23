package n1exercici1;

public class App {

	public static void main(String[] args) {

		System.out.println(InstrumentVent.modelo);
		InstrumentVent trompeta = new InstrumentVent("Artisan", 5199.00);
		System.out.println(InstrumentCorda.estilo);
		InstrumentCorda arpa = new InstrumentCorda("Salher", 4555.00);
		System.out.println(InstrumentPercussio.tipos);
		InstrumentPercussio bateria = new InstrumentPercussio("Yamaha", 845.00);

	}

}