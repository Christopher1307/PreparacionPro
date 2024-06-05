package Empresas;

import java.util.regex.Pattern;

public class Repartidor extends Empleado {
    private String zona;

    public Repartidor(String nombre, int edad, double salario, String zona) {
        super(nombre, edad, salario);
        if (!validarZona(zona)) {
            throw new IllegalArgumentException("Zona no válida");
        }
        this.zona = zona;
    }

    @Override
    public double plus() {
        if (edad < 25 && zona.equals("zona 3")) {
            return EXTRA;
        }
        return 0;
    }

    public static boolean validarZona(String zona) {
        return Pattern.matches("zona [1-9]|zona 10", zona);
    }
}
