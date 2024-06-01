import java.io.*;

public class ExecutionCounter {
    private static final String FILE_NAME = "execution_count.txt";

    public static void main(String[] args) {
        int count = readExecutionCount();
        count++;
        System.out.println("Este programa se ha ejecutado " + count + " veces");
        writeExecutionCount(count);
    }

    private static int readExecutionCount() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line = reader.readLine();
            if (line != null) {
                return Integer.parseInt(line);
            }
        } catch (FileNotFoundException e) {
            // Archivo no encontrado, primera ejecución
            return 0;
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return 0;
    }

    private static void writeExecutionCount(int count) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write(Integer.toString(count));
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
}
