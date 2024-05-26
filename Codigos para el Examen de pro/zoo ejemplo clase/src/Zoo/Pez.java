package Zoo;

// Haendel, Cristian1, Cristian2, Gonzalo Afonso.

import java.util.Random;

public class Pez extends Animal{
    protected String tamaño;
    protected String colorEscamas;
    protected String tipoAgua;

    private String[] tamaños = {"diminuto", "pequeño", "mediano", "grande", "enorme"};
    private String[] colores = {"azul", "rojo", "verde"};
    private String[] agua = {"dulce", "salada"};
    
    Random random = new Random();

    public Pez() {
        super();
        
        this.tamaño = tamaños[random.nextInt(tamaños.length)];
        this.colorEscamas = colores[random.nextInt(colores.length)];
        this.tipoAgua = agua[random.nextInt(agua.length)];
    }

    public Pez(String nombre, int edad, float peso, String tamaño, String colorescamas, String tipoAgua) {
        super(nombre, edad, peso);
        this.tamaño = tamaño;
        this.colorEscamas = colorescamas;
        this.tipoAgua = tipoAgua;
    }

    public void nadar() {
        System.out.println(nombre + " está nadando, placidamente.");
    }

    public void respirarBajoAgua() {
        System.out.println(nombre + " está respirando bajo agua.");
        System.out.println(nombre + " está abriendo y cerrando la boca para así poder hacer que el agua pase por la branqueas para asi conseguir el oxígeno");
    }

    public void ponerHuevos()  {
        boolean cuidadoParental = random.nextBoolean();
        if (cuidadoParental){
            System.out.println("Se queda cuidando los huevos, que acaba de poner");
        }else {
            System.out.println("Se va a por cigarros");
        }
    }

    @Override
    public void verAnimal() {
        Runnable[] acciones = {
            this::comer,
            this::dormir,
            this::moverse,
            this::nadar,
            this::respirarBajoAgua,
            this::ponerHuevos
        };

        try {
            for (int i = 0; i < 6; i++) {
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
