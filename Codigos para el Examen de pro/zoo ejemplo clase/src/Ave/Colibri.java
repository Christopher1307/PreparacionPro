package Ave;

import java.util.Random;

public class Colibri extends Ave{
	private int velocidadAleteo;
    private String tipoAlimentacion;

    // Constructor sin parámetros
    public Colibri() {
        super();
        Random random = new Random();
        this.velocidadAleteo = random.nextInt(101); // Asigna una velocidad aleatoria entre 0 y 100
        this.tipoAlimentacion = "nectar";
    }

    // Métodos específicos de Colibri
    public void volarEstacionario() {
        System.out.println(nombre + " el colibrí está volando estacionario, batiendo sus alas a una velocidad de " + velocidadAleteo + " veces por segundo.");
    }

    public void buscarNectar() {
        System.out.println(nombre + " el colibrí está buscando flores para alimentarse de nectar.");
    }

    @Override
    public void volar() {
        System.out.println(nombre + " el colibrí está volando con rapidez.");
    }

    @Override
    public void emitirSonido() {
        System.out.println(nombre + " el colibrí está emitiendo sonidos melodiosos.");
    }
    
    @Override
    public void ponerHuevos() {
		System.out.println(nombre+" está poniendo un huevo.");
	}

    @Override
    public void verAnimal() {
        super.verAnimal(); // Llama al método verAnimal de Ave
        try {
            volarEstacionario();
            Thread.sleep(500); // Espera medio segundo después de volar estacionario
            buscarNectar();
            Thread.sleep(500); // Espera medio segundo después de buscar nectar
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
