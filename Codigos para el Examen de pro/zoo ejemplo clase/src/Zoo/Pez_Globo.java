package Zoo;

// Haendel González

import java.util.Random;

public class Pez_Globo extends Pez {
    protected Boolean Puas;

    public Pez_Globo(String nombre, int edad, float peso, String tamaño, String colorescamas, String tipoAgua) {
        super(nombre, edad, peso, tamaño, colorescamas, tipoAgua);
        this.Puas = random.nextBoolean();
    }

    public void inflarse() {
        System.out.println(nombre + " va a reventar pa' la ver--.");
        System.out.println(nombre + " esto es un mecanismo de defensa conta los depredadores" +
        "que se basa en el uso de su elástico estómago y su capacidad de ingerir rápidamente" +
        "grande cantidades de agua, para así doblar varias veces su tamaño");
    }

    @Override
    public void verAnimal() {
        Runnable[] acciones = {
            this::comer,
            this::dormir,
            this::moverse,
            this::nadar,
            this::respirarBajoAgua,
            this::ponerHuevos,
            this::inflarse
        };

        try {
            for (int i = 0; i < 7; i++) {
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

