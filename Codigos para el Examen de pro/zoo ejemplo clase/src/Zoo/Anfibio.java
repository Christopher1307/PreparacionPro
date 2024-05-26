package Zoo;

import java.util.Random;

public class Anfibio extends Animal {
    protected boolean puedeRespirarBajoAgua;
    protected String colorPiel;

    private static final String[] coloresPielPosibles = {"verde", "marrón", "amarillo"};

    // Constructor sin parámetros
    public Anfibio() {
        super();
        Random random = new Random();
        this.puedeRespirarBajoAgua = random.nextBoolean();
        this.colorPiel = coloresPielPosibles[random.nextInt(coloresPielPosibles.length)];
    }

    // Constructor con parámetros
    public Anfibio(String nombre, int edad, float peso, boolean puedeRespirarBajoAgua, String colorPiel) {
        super(nombre, edad, peso);
        this.puedeRespirarBajoAgua = puedeRespirarBajoAgua;
        this.colorPiel = colorPiel;
    }

    public void nadar() {
        System.out.println(nombre + " está nadando.");
    }

    public void metamorfosis() {
        System.out.println(nombre + " está pasando por una metamorfosis.");
    }

    @Override
    public void verAnimal() {
        Random random = new Random();
        Runnable[] acciones = {
            this::comer,
            this::dormir,
            this::moverse,
            this::nadar,
            this::metamorfosis
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
