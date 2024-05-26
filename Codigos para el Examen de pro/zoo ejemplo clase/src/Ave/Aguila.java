package Ave;

import java.util.Random;


public class Aguila extends Ave {
	private static final String[] tipo = {"aguila real" , "aguila calva" , "aguila imperial"};
	protected String tipoAguila;
	
	// Constructor sin parámetros
	public Aguila() {
		super();
		Random random = new Random();
		this.tipoAguila = tipo[random.nextInt(tipo.length)];
	}
	
	@Override
	public void volar() {
		System.out.println(nombre+" está volando.");
	}
	
	@Override
	public void ponerHuevos() {
		System.out.println(nombre+" está poniendo un huevo.");
	}
	@Override
	public void emitirSonido() {
		System.out.println(nombre+" está emitiendo sonidos.");
	}
	
	// Metodo unico de Aguila
	public void cazar() {
		System.out.println(nombre+" el "+tipoAguila+" esta cazando a su presa");
	}
	
	@Override
    public void verAnimal() {
        super.verAnimal(); // Llama al método verAnimal de Anfibio y agrega el comportamiento de croar
        try {
            cazar();
            Thread.sleep(500); // Espera medio segundo después de croar
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
