package Zoo;

import java.util.Random;

public class Rana extends Anfibio {
    private static final String[] coloresPielPosibles = {"verde", "rojo", "azul"};

    // Constructor sin parámetros
    public Rana() {
        super();
        Random random = new Random();
        this.colorPiel = coloresPielPosibles[random.nextInt(coloresPielPosibles.length)];
    }

    // Constructor con parámetros
    public Rana(String nombre, int edad, float peso, boolean puedeRespirarBajoAgua, String colorPiel) {
        super(nombre, edad, peso, puedeRespirarBajoAgua, colorPiel);
    }

    @Override
    public void nadar() {
        System.out.println(nombre + " la rana está dando saltos en el agua.");
    }

    @Override
    public void moverse() {
        System.out.println(nombre + " la rana está saltando por la tierra.");
    }

    // Método único de Rana
    public void croar() {
        System.out.println(nombre + " está croando.");
    }

    @Override
    public void verAnimal() {
        super.verAnimal(); // Llama al método verAnimal de Anfibio y agrega el comportamiento de croar
        try {
            croar();
            Thread.sleep(500); // Espera medio segundo después de croar
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

