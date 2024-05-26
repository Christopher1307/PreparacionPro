import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Usuarios {
    public static void busquedaDni (String rutaArchivo , String dniBuscado) {
        try {
            Scanner scanner = new Scanner(new File(rutaArchivo));
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                if (linea.contains(dniBuscado)) {
                    System.out.println("Dni encontrado" + linea);
                    scanner.close();
                    return;
                }

            }
            scanner.close();
            System.out.println("dni no encontrado");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void agregarUsuario (String rutaArchivo , String usuario  ) {
        try {
            FileWriter writer = new FileWriter(rutaArchivo , true);
            writer.write(usuario + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void eliminarUsuario (String rutaArchivo, String borrarUsuario) {
        try {
            Scanner scanner = new Scanner(new File(rutaArchivo));
            StringBuilder nuevosDatos = new StringBuilder();
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                if (!linea.contains(borrarUsuario)) {
                    nuevosDatos.append(linea).append("\n");
                }
            }
            scanner.close();

            FileWriter writer = new FileWriter(rutaArchivo);
            writer.write(nuevosDatos.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
