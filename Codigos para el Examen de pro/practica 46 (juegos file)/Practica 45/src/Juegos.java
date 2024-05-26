import java.io.*;
import java.util.Scanner;



public class Juegos {
    public static void busquedaVideojuego(String rutaVideojuego , String juegoBuscado) {
        try {
            Scanner scanner = new Scanner(new File(rutaVideojuego));
            while (scanner.hasNextLine()) {
                String Linea = scanner.nextLine();
                if (Linea.contains(juegoBuscado)) {
                    System.out.println("juego encontrado" + Linea);
                    scanner.close();
                    return;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void InsertarVideojuego(String rutaVideojuego , String juegoInsertado) {
        try {
            FileWriter write = new FileWriter(rutaVideojuego , true);
            write.write(juegoInsertado + "\n");
            write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void borrarVideojuegos ( String rutaVideojuego , String juegoBorrados) {
        try {
            Scanner scanner = new Scanner(new File(rutaVideojuego));
            StringBuilder datoVideojuego = new StringBuilder();
            while (scanner.hasNextLine()) {
                String linea =  scanner.nextLine();
                if (!linea.contains(juegoBorrados)) {
                    datoVideojuego.append(linea).append("\n");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void mostrarLista ( String rutaVideojuego){
        try {
            FileReader fileReader = new  FileReader(rutaVideojuego);
            BufferedReader BufferedReader = new BufferedReader(fileReader);

            String linea;
            System.out.println("lista de juegos disponibles");
            while ((linea = BufferedReader.readLine()) != null) {
                System.out.println(linea);
            }
            fileReader.close();
            BufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
