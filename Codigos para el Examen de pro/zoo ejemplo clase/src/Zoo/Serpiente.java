package Zoo;

import java.util.Random;

public class Serpiente extends Reptil {
    protected String longitud;
    protected String tipo;

    private static final String[] longitudesPosibles = {"Corta", "Mediana", "Larga"};
    private static final String[] tiposPosibles = {"Constrictora", "Venenosa", "No venenosa"};

    // Constructor sin parámetros
    public Serpiente() {
        super();
        Random random = new Random();
        this.longitud = longitudesPosibles[random.nextInt(longitudesPosibles.length)];
        this.tipo = tiposPosibles[random.nextInt(tiposPosibles.length)];
    }

    // Constructor con parámetros
    public Serpiente(String nombre, int edad, float peso, String tipoPiel, boolean esVeneno, String habitat, String longitud, String tipo) {
        super(nombre, edad, peso, tipoPiel, esVeneno, habitat);
        this.longitud = longitud;
        this.tipo = tipo;
    }

    // Método específico de la serpiente para deslizarse
    public void deslizarse() {
        System.out.println(nombre + " se desliza suavemente por el suelo.");
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
                this::deslizarse
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
