package matrices;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author javi
 */
public class matris {

    public static void identidad(int dimension) {
        int ident[][] = new int[dimension][dimension];
        for (int i = 0; i < ident.length; i++) {
            for (int j = 0; j < ident[i].length; j++) {
                if (i == j) {
                    ident[i][j] = 1;
                } else {
                    ident[i][j] = 0;
                }
                System.out.print(ident[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public static int[][] multiplicar(int mat1[][], int mat2[][], int dimension) {
        int multi[][] = new int[dimension][dimension];
        System.out.println("Se va a proceder a multiplicar las matrices");
        int suma = 0;
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[i].length; j++) {
                suma = 0;
                for (int k = 0; k < dimension; k++) {
                    suma = suma + mat1[i][k] * mat2[k][j];
                }
                multi[i][j] = suma;
                System.out.print(multi[i][j] + " ");
            }
            System.out.println(" ");
        }
        return multi;
    }

    public static int[][] restar(int mat1[][], int mat2[][], int dimension) {
        int resta[][] = new int[dimension][dimension];
        System.out.println("Se va a proceder a restar las matrices");
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[i].length; j++) {
                resta[i][j] = mat1[i][j] - mat2[i][j];
                System.out.print(resta[i][j] + " ");
            }
            System.out.println(" ");
        }
        return resta;
    }

    public static int[][] sumar(int mat1[][], int mat2[][], int dimension) {
        int suma[][] = new int[dimension][dimension];
        System.out.println("Se va a proceder a sumar las matrices");
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[i].length; j++) {
                suma[i][j] = mat1[i][j] + mat2[i][j];
                System.out.print(suma[i][j] + " ");
            }
            System.out.println(" ");
        }
        return suma;
    }

    public static void mostrar(int mat[][], int matriz) {
        System.out.println("Mostrando la matriz " + matriz);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public static void rellenar(int mat[][], int matriz) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                // System.out.println("Dime un valor para la matriz "+matriz+" en la posicion(i "+i+", j "+j+")");
                // mat[i][j]=miteclado.nextInt();
                mat[i][j] = (int) (Math.random() * 9);
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner miteclado = new Scanner(System.in)) {
			boolean salir = false;
			int num = 0;
			while (!salir) {
			    try {
			        System.out.println("Cuántas filas y columnas quieres que tenga la matriz:");
			        num = miteclado.nextInt();
			        salir = true;
			    } catch (InputMismatchException e) {
			        System.out.println("No puedes introducir otra cosa que no sea un número.");
			        miteclado.nextLine();
			    }
			}

			salir = false;
			int op = 0;
			while (!salir) {
			    try {
			        System.out.println("1 - Sumar matrices\n2 - Restar matrices\n3 - Multiplicar matrices\n4 - Matriz identidad\n5 - Salir");
			        op = miteclado.nextInt();
			        salir = true;
			    } catch (InputMismatchException e) {
			        System.out.println("No puedes introducir otra cosa que no sea un número.");
			        miteclado.nextLine();
			    }
			}

			int matriz1[][] = new int[num][num];
			int matriz2[][] = new int[num][num];

			switch (op) {
			    case 1:
			        rellenar(matriz1, 1);
			        rellenar(matriz2, 2);
			        mostrar(matriz1, 1);
			        mostrar(matriz2, 2);
			        sumar(matriz1, matriz2, num);
			        break;
			    case 2:
			        rellenar(matriz1, 1);
			        rellenar(matriz2, 2);
			        mostrar(matriz1, 1);
			        mostrar(matriz2, 2);
			        restar(matriz1, matriz2, num);
			        break;
			    case 3:
			        rellenar(matriz1, 1);
			        rellenar(matriz2, 2);
			        mostrar(matriz1, 1);
			        mostrar(matriz2, 2);
			        multiplicar(matriz1, matriz2, num);
			        break;
			    case 4:
			        identidad(num);
			        break;
			    case 5:
			        break;
			}
		}
    }
}
