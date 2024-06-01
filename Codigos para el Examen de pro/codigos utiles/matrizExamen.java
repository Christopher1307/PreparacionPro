import java.io.*;
import java.util.Scanner;

public class MatrixHandler {
    private static final String FILE_NAME = "matrix.txt";
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elija el modo de ejecución (1 o 2): ");
        int mode = scanner.nextInt();

        if (mode == 1) {
            firstTime(scanner);
        } else if (mode == 2) {
            secondTime(scanner);
        } else {
            System.out.println("Modo no válido.");
        }
        
        scanner.close();
    }

    private static void firstTime(Scanner scanner) {
        System.out.println("Ingrese la dimensión de la matriz cuadrada: ");
        int dimension = scanner.nextInt();
        int[][] matrix = new int[dimension][dimension];

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (int i = 0; i < dimension; i++) {
                for (int j = 0; j < dimension; j++) {
                    matrix[i][j] = 0;
                    writer.write(matrix[i][j] + " ");
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }

        System.out.println("Matriz creada y guardada en " + FILE_NAME);
    }

    private static void secondTime(Scanner scanner) {
        System.out.println("Ingrese el número de iteración actual: ");
        int iteration = scanner.nextInt();
        int[][] matrix = readMatrixFromFile();

        if (matrix == null) {
            System.out.println("Error al leer la matriz del archivo.");
            return;
        }

        int dimension = matrix.length;

        if (iteration % 2 == 1) { // Iteración impar
            for (int i = 0; i < dimension; i++) {
                for (int j = i + 1; j < dimension; j++) { // Matriz superior
                    matrix[i][j] = iteration;
                }
            }
        } else { // Iteración par
            for (int i = 0; i < dimension; i++) {
                for (int j = 0; j < i; j++) { // Matriz inferior
                    matrix[i][j] = iteration;
                }
            }
        }

        for (int i = 0; i < dimension; i++) {
            matrix[i][i] += iteration; // Diagonal principal
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (int i = 0; i < dimension; i++) {
                for (int j = 0; j < dimension; j++) {
                    writer.write(matrix[i][j] + " ");
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }

        System.out.println("Matriz actualizada y guardada en " + FILE_NAME);
    }

    private static int[][] readMatrixFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line = reader.readLine();
            if (line == null) {
                return null;
            }
            String[] tokens = line.trim().split("\\s+");
            int dimension = tokens.length;
            int[][] matrix = new int[dimension][dimension];

            int row = 0;
            while (line != null) {
                tokens = line.trim().split("\\s+");
                for (int col = 0; col < dimension; col++) {
                    matrix[row][col] = Integer.parseInt(tokens[col]);
                }
                row++;
                line = reader.readLine();
            }

            return matrix;
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return null;
        }
    }
}
