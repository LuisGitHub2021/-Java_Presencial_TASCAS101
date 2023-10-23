package n2exercici1;

public interface Camera {

	default public void fotografiar() {
		
		System.out.println("S'està fent una foto");
	}

}