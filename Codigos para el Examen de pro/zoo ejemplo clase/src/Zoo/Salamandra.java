package Zoo;

public class Salamandra extends Anfibio {
    // Atributos específicos de Salamandra podrían añadirse aquí

    // Constructor sin parámetros
    public Salamandra() {
        super();
        // La salamandra podría tener configuraciones predeterminadas o valores aleatorios específicos
    }

    // Constructor con parámetros
    public Salamandra(String nombre, int edad, float peso, boolean puedeRespirarBajoAgua, String colorPiel) {
        super(nombre, edad, peso, puedeRespirarBajoAgua, colorPiel);
    }

    @Override
    public void moverse() {
        System.out.println(nombre + " la salamandra está reptando lentamente.");
    }

    // Método único de Salamandra
    public void regenerar() {
        System.out.println(nombre + " está regenerando su cola.");
    }

    @Override
    public void verAnimal() {
        super.verAnimal(); // Llama al método verAnimal de Anfibio y agrega el comportamiento de regenerar
        try {
            regenerar();
            Thread.sleep(500); // Espera medio segundo después de regenerar
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}