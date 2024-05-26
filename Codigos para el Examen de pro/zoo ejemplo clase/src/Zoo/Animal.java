package Zoo;

import java.util.Random;

public class Animal {
	// Variables de instancia
    protected String nombre;
    protected int edad;
    protected float peso;
    private static final String[] nombresPosibles = {
    	    "Leo", "Max", "Luna", "Bella", "Rocky", "Charlie", "Molly", "Buddy", "Daisy", "Maggie",
    	    "Oscar", "Rex", "Toby", "Coco", "Ruby", "Sammy", "Sasha", "Teddy", "Willow", "Zoe",
    	    "Archie", "Bailey", "Bandit", "Bruno", "Cleo", "Ellie", "Finn", "George", "Gizmo", "Harley",
    	    "Jasper", "Koda", "Lola", "Lucky", "Milo", "Nala", "Oliver", "Penny", "Pepper", "Rosie",
    	    "Simba", "Sophie", "Stella", "Tucker", "Winston", "Messi", "Ziggy", "Amber", "Apollo", "Blu", "Boomer",
    	    "Chase", "Chester", "Chico", "Duke", "Felix", "Freddie", "Ginger", "Hunter", "Ivy", "Jack",
    	    "Juno", "Kai", "King", "Leia", "Vinicius Jr", "Louie", "Mia", "Murphy", "Nova", "Otis", "Piper",
    	    "Ranger", "Romeo", "Rusty", "Scout", "Shadow", "Sky", "Spike", "Storm", "Tiger", "Zeus"
    	};


    // Constructor
    public Animal(String nombre, int edad, float peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
    }
    public Animal() {
        Random random = new Random();
        this.nombre = nombresPosibles[random.nextInt(nombresPosibles.length)];
        this.edad = random.nextInt(15) + 1; // Edad entre 1 y 15
        this.peso = 0.5f + (10 - 0.5f) * random.nextFloat(); // Peso entre 0.5 y 10.0
    }

    // Métodos
    public void comer() {
        System.out.println(nombre + " está comiendo.");
    }

    public void dormir() {
        System.out.println(nombre + " está durmiendo.");
    }

    public void moverse() {
        System.out.println(nombre + " se está moviendo.");
    }
    
    public void verAnimal() {
        Random random = new Random();
        // Lista de acciones posibles
        Runnable[] acciones = {
            this::comer,
            this::dormir,
            this::moverse
        };

        try {
            for (int i = 0; i < 3; i++) { // Ejecuta 3 acciones aleatorias
                int indiceAccion = random.nextInt(acciones.length);
                acciones[indiceAccion].run(); // Ejecuta la acción seleccionada

                int tiempoEspera = random.nextInt(2000) + 1000; // Espera entre 1 y 2 segundos
                Thread.sleep(tiempoEspera);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
