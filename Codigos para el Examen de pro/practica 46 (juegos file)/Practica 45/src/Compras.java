import java.io.*;

public class Compras {
    public static void registrarCompra(String rutaCompras, String dniUsuario, String serialJuego) {
        try (FileWriter writer = new FileWriter(rutaCompras, true);
             BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write(dniUsuario + "," + serialJuego);
            bw.newLine();
            System.out.println("Compra registrada correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mostrarCompras(String rutaCompras) {
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaCompras))) {
            System.out.println("Lista de compras:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
