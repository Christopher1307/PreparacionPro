package Zoo;

// Gonzalo Afonso.

import java.util.Random;

public class Pez_Tiburon extends Pez {
    protected String[] Especie = {"Tiburón Blanco", "Tiburón Martillo", "Tiburón Tigre", "Tiburón Ballena", "Tiburón Zorro"};
    protected String Longitud; 

    public Pez_Tiburon(String nombre, int edad, float peso, String tamaño, String colorescamas, String tipoAgua, String Especie, String Longitud) {
        super(nombre, edad, peso, tamaño, colorescamas, tipoAgua);
        this.Especie[0] = Especie;
        this.Longitud = (Longitud + "m");

        if (Especie.equals("Tiburón Blanco")) {
            this.Longitud = "4.5-6.4";
        }
        else {
            if (Especie.equals("Tiburón Martillo")) {
                this.Longitud = "2.0-5.0";
            }
            else {
                if (Especie.equals("Tiburón Tigre")) {
                    this.Longitud = "3.25-4.25";
                }
                else {
                    if (Especie.equals("Tiburón Ballena")) {
                        this.Longitud = "12";
                    }
                    else {
                        this.Longitud = "3.2-4.5";
                    }
                }
            }
        }
    }

    public void cazar() {
        System.out.print("Abren la boca");
        System.out.print("Muerden o engullen a sus presas");
        System.out.print("Tragan");
        System.out.print("Repiten");
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
            this::cazar
        };

        try {
            for (int i = 0; i < 8; i++) {
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