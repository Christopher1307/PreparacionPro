// Nuhacet  |  Diego  |  Ancor  |  Daniel

package Zoo;

import java.util.Random;

public class Mamifero extends Animal {
    protected String colorpelo;
    protected String tipoAlimentacion;
    protected boolean esDomestico;

    private static final String[] alimentacionPosible = {"herbívoro", "carnívoro", "omnívoro"};
    private static final String[] coloresposibles = {"marrón", "negro", "blanco"};

    // Constructor sin parámetros
    public Mamifero() {
        super();
        Random random = new Random();
        this.esDomestico = random.nextBoolean();
        this.tipoAlimentacion = alimentacionPosible[random.nextInt(alimentacionPosible.length)];
        this.colorpelo = coloresposibles[random.nextInt(coloresposibles.length)];
    }

    public Mamifero(String colorpelo, String tipoAlimentacion, boolean esDomestico) {
        this.colorpelo = colorpelo;
        this.tipoAlimentacion = tipoAlimentacion;
        this.esDomestico = esDomestico;
    }

    public void amamantar() {
        System.out.println(nombre + "está amamantando");
    }

    public void emitir_sonido() {
        System.out.println(nombre + " está emitiendo sonidos");
    }

    @Override
    public void verAnimal() {
        Random random = new Random();
        Runnable[] acciones = {
                this::comer,
                this::dormir,
                this::moverse,
                this::amamantar,
                this::emitir_sonido
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