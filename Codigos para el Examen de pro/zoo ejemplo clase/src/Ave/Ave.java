//Hecho por Joan, Damián e Ismael.

package Ave;

import java.util.Random;

import Zoo.Animal;

public class Ave extends Animal{
	protected String colorPiel;
	protected boolean puedeVolar;
	protected String tamaño;
	
	private static final String[] coloresPlumasPosibles={"marron","azul","negro","blanco","gris","verde"};
	
	private static final String[] tamañoPosible={"pequeño","mediano","grande"};
	
	// Constructor sin parámetros
	public Ave() {
		super();
		Random random=new Random();
		this.puedeVolar=random.nextBoolean();
		this.colorPiel=coloresPlumasPosibles[random.nextInt(coloresPlumasPosibles.length)];
		this.tamaño=tamañoPosible[random.nextInt(tamañoPosible.length)];
	}
	
	public void volar() {
		System.out.println(nombre+" está volando.");
	}
	
	public void ponerHuevos() {
		System.out.println(nombre+" está poniendo un huevo.");
	}
	
	public void emitirSonido() {
		System.out.println(nombre+" está emitiendo sonidos.");
	}
	
	@Override
	public void verAnimal() {
        Random random = new Random();
        Runnable[] acciones = {
            this::comer,
            this::dormir,
            this::moverse,
            this::volar,
            this::ponerHuevos,
            this::emitirSonido

        };

        try {
            for (int i = 0; i < 5; i++) {
                int indiceAccion = random.nextInt(acciones.length);
                acciones[indiceAccion].run();

                int tiempoEspera = random.nextInt(2000) + 1000;
                Thread.sleep(tiempoEspera);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
