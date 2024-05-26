package Zoo;

import java.util.Random;

public class Leon extends Mamifero {
    private static final String[] TAMANO_MELENA = {"largo", "corto", "punk"};
    private static final String[] TAMANO_MANADA = {"grande", "pequeño"};
    private String tamañoMelena;
    private String tamañoManada;

    public Leon() {
        super();
        Random random = new Random();
        this.tamañoMelena = TAMANO_MELENA[random.nextInt(TAMANO_MELENA.length)];
        this.tamañoManada = TAMANO_MANADA[random.nextInt(TAMANO_MANADA.length)];
    }

    public void rugir() {
        System.out.println(nombre + " el león ruge");
    }

    public void cazar() {
        System.out.println(nombre + " el león está cazando");
    }

    @Override
    public void verAnimal() {
        Random random = new Random();
        Runnable[] acciones = {
                this::comer,
                this::dormir,
                this::moverse,
                this::amamantar,
                this::emitir_sonido,
                this::rugir,
                this::cazar
        };

        try {
            for (int i = 0; i < 4; i++) {
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