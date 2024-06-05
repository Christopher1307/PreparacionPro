package Empresas;

public class Comercial extends Empleado {
    private double comision;

    public Comercial(String nombre, int edad, double salario, double comision) {
        super(nombre, edad, salario);
        this.comision = comision;
    }

    @Override
    public double plus() {
        if (edad > 30 && comision > 200) {
            return EXTRA;
        }
        return 0;
    }
}
