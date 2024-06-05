
package Empresas;

import java.util.regex.Pattern;

public abstract class Empleado {
	    private String nombre;
	    public int edad;
	    private double salario;
	    protected static final double EXTRA = 300.0;

	    public Empleado(String nombre, int edad, double salario) {
	        if (!validarNombre(nombre)) {
	            throw new IllegalArgumentException("Nombre no válido");
	        }
	        this.setNombre(nombre);
	        this.edad = edad;
	        this.salario = salario;
	    }

	    public abstract double plus();

	    public double calcularSalario() {
	        return salario + plus();
	    }

	    public static boolean validarNombre(String nombre) {
	        return Pattern.matches("^[A-Z][a-z]{1,49}$", nombre);
	    }

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
	}


