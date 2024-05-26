// Codigo hecho por: Jorge Herrero, Ruben Chedas y Alejandro Ares

package Zoo;

import java.util.Random;

public class Reptil extends Animal {
    // Variables de instancia específicas de los reptiles
    protected String tipoPiel;
    protected boolean esVeneno; 
    protected String habitat; 

    // Array de tipos de piel posibles
    private static final String[] tiposPielPosibles = {"escamosa", "coriácea", "rugosa"};

    // Constructor sin parámetros
    public Reptil() {
        super(); // Llama al constructor de la clase padre (Animal)
        Random random = new Random();
        // Asigna un tipo de piel aleatorio al reptil
        this.tipoPiel = tiposPielPosibles[random.nextInt(tiposPielPosibles.length)];
       
        this.esVeneno = random.nextBoolean();
        // Genera un hábitat aleatorio para el reptil
        this.habitat = generarHabitatAleatorio();
    }

    // Constructor con parámetros
    public Reptil(String nombre, int edad, float peso, String tipoPiel, boolean esVeneno, String habitat) {
        super(nombre, edad, peso); // Llama al constructor de la clase padre (Animal) con los parámetros correspondientes
        this.tipoPiel = tipoPiel; 
        this.esVeneno = esVeneno; 
        this.habitat = habitat; 
    }

    // Métodos específicos de los reptiles
    public void tomarSol() {
        System.out.println(nombre + " está tomando el sol para termorregularse.");
    }

    public void mudarPiel() {
        System.out.println(nombre + " está mudando de piel.");
    }

    public void reptar() {
        System.out.println(nombre + " está reptando.");
    }

    // Genera un hábitat aleatorio para el reptil
    private String generarHabitatAleatorio() {
        String[] habitatsPosibles = {"desierto", "selva", "pantano", "montaña"};
        Random random = new Random();
        return habitatsPosibles[random.nextInt(habitatsPosibles.length)];
    }

    @Override
    public void verAnimal() {
        Random random = new Random();
        Runnable[] acciones = {
                this::comer,
                this::dormir,
                this::tomarSol,
                this::mudarPiel,
                this::reptar
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
