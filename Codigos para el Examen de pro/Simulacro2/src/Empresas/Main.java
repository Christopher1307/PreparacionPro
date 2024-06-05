package Empresas;

	public class Main {
	    public static void main(String[] args) {
	        try {
	            Comercial comercial1 = new Comercial("Pedro", 35, 1000.0, 250.0);
	            System.out.println("Salario Comercial 1: " + comercial1.calcularSalario());

	            Repartidor repartidor1 = new Repartidor("Juan", 30, 1200.0, "zona 3");
	            System.out.println("Salario Repartidor 1: " + repartidor1.calcularSalario());

	            Repartidor repartidor2 = new Repartidor("Luis", 22, 1100.0, "zona 3");
	            System.out.println("Salario Repartidor 2: " + repartidor2.calcularSalario());
	        } catch (IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
	    }
	}

	


