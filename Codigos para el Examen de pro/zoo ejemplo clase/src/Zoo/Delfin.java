package Zoo;

import java.util.Random;

public class Delfin extends Mamifero {
    private boolean capacidadAcrobatica;
    private float longuitud;

    public Delfin(String colorpelo, String tipoAlimentacion, boolean esDomestico, boolean capacidadAcrobatica, float longuitud) {
        super(colorpelo, tipoAlimentacion, esDomestico);
        this.capacidadAcrobatica = capacidadAcrobatica;
        this.longuitud = longuitud;
    }

    public Delfin(){
        super();
        Random random = new Random();
        this.capacidadAcrobatica= random.nextBoolean();
        this.longuitud= random.nextFloat();
    }

    public void nadar(){
        System.out.println(this.nombre + " Está nadando");

    }

    public  void usarEcolocalizacion(){
        System.out.println(this.nombre + " Usando ecolocalizacion");
    }

    @Override
    public void verAnimal() {
        super.verAnimal(); //
        try {
            nadar();
            usarEcolocalizacion();
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
