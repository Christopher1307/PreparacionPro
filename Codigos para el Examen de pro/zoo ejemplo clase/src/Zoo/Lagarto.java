package Zoo;

import java.util.Random;

public class Lagarto extends Reptil {
    protected String colorPiel;
    protected String tamaño;

    private static final String[] coloresPosibles = {"Verde", "Marrón", "Gris"};
    private static final String[] tamañosPosibles = {"Pequeño", "Mediano", "Grande"};

    // Constructor sin parámetros
    public Lagarto() {
        super();
        Random random = new Random();
        this.colorPiel = coloresPosibles[random.nextInt(coloresPosibles.length)];
        this.tamaño = tamañosPosibles[random.nextInt(tamañosPosibles.length)];
    }

    // Constructor con parámetros
    public Lagarto(String nombre, int edad, float peso, String tipoPiel, boolean esVeneno, String habitat, String colorPiel, String tamaño) {
        super(nombre, edad, peso, tipoPiel, esVeneno, habitat);
        this.colorPiel = colorPiel;
        this.tamaño = tamaño;
    }

    // Método específico del lagarto para regenerar su cola
    public void regenerarCola() {
        System.out.println(nombre + " regenera su cola.");
    }

    @Override
    public void verAnimal() {
        Random random = new Random();
        Runnable[] acciones = {
                this::comer,
                this::dormir,
                this::moverse,
                this::tomarSol,
                this::mudarPiel,
                this::regenerarCola
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
