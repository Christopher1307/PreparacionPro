package Ave;

import java.util.Random;

public class Loro extends Ave {
	private static final String[] color = {"rojo", "azul", "verde", "amarillo", "naranja", "morado"};
    private boolean habilidadParaHablar;
    protected String colores;
    
    public Loro() {
        super();
        Random random = new Random();
        this.colores = color[random.nextInt(color.length)];
        this.habilidadParaHablar = random.nextBoolean();
    }

    public Loro(String color, boolean habilidadParaHablar) {
        super();
        this.habilidadParaHablar = habilidadParaHablar;
    }

    
    @Override
    public void volar() {
        System.out.println(nombre + " está volando haciendo piruetas en el aire.");
    }

    public void imitarSonidos() {
        if (habilidadParaHablar) {
            System.out.println(nombre + " puede imitar una variedad de sonidos y palabras humanas.");
        } else {
            System.out.println(nombre + " no tiene habilidad para imitar sonidos humanos.");
        }
    }
    @Override
    public void verAnimal() {
        super.verAnimal(); // Llama al método verAnimal de Ave
        try {
            imitarSonidos();
            Thread.sleep(500); // Espera medio segundo después de imitar sonidos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}