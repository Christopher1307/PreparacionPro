import java.io.IOException;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String rutaUsuario = ":\\Users\\Usuario\\trabajo-46-pro\\Practica 45\\src\\juegos.txt";
        // ruta de clase   String  rutaUsuario = "E:/Programacion ciclo superior/carpeta codigos python/usuarios.txt";
        String rutaVideojuego = "C:\\Users\\Usuario\\trabajo-46-pro\\Practica 45\\src\\juegos.txt";
       // ruta de clase String  rutaVideojuego = "E:/Programacion ciclo superior/carpeta codigos java/videojuego.txt";
        String rutaCompras = "C:\\Users\\Usuario\\trabajo-46-pro\\Practica 45\\src\\compras.txt";
        // ruta clase  String rutaCompras = "";
        String  opcion = "";

        while (!opcion.equals("10")) {
            System.out.println("\n//////// Venta de Juegos Online ////////\n");
            System.out.println("Elige la opción que desees:");
            System.out.println("1) Buscar un usuario (ingresa el DNI)");
            System.out.println("2) Agregar un nuevo usuario");
            System.out.println("3) Eliminar un usuario");
            System.out.println("4) Buscar un juego (ingresa el número serial)");
            System.out.println("5) Agregar un nuevo juego");
            System.out.println("6) Eliminar un juego");
            System.out.println("7) Mostrar carrito de compras");
            System.out.println("8) Realizar compra");
            System.out.println("9) Mostrar lista de juegos disponibles");
            System.out.println("10) Mostrar las compras realizadasd" );
            System.out.println("11) Salir");

            System.out.println("\nElige la opción que necesites:");
            opcion = scanner.nextLine();


            switch (opcion) {
                case "1":
                    System.out.println("Ingrese el Dni para buscar al usuario correspondiente");
                    String busquedaDni = scanner.nextLine();
                    Usuarios.busquedaDni (rutaUsuario , busquedaDni);
                    break;
                case "2":
                    System.out.println("Ingrese los datos del usuario que Quiere agregar (dni , nombre , apellido):");
                    String usuario = scanner.nextLine();
                    Usuarios.agregarUsuario(rutaUsuario , usuario);
                    System.out.println("usuario agregado correctamente");
                    break;
                case "3":
                    System.out.println("Ingrese el dni del usuario que deseas eliminar:");
                    String borraUsuario = scanner.nextLine();
                    Usuarios.eliminarUsuario(rutaUsuario , borraUsuario);
                    System.out.println("usuario eliminado correctamente");
                    break;
                case "4":
                    System.out.println("ingrese aqui el videojuego que quiere buscar:");
                    String juegoBuscado  = scanner.nextLine();
                    Juegos.busquedaVideojuego(rutaVideojuego , juegoBuscado);
                    break;
                case "5":
                    System.out.println("ingrese el nuevo Videojuego que quieres agregar:");
                    String juegoInsertado = scanner.nextLine();
                    Juegos.InsertarVideojuego(rutaVideojuego , juegoInsertado);
                    break;
                case "6":
                    System.out.println("ingrese aqui el videojuego que quieres eliminar:");
                    String juegoBorrados = scanner.nextLine();
                    Juegos.borrarVideojuegos(rutaVideojuego , juegoBorrados);
                    break;
                case "7":
                    Juegos.mostrarLista(rutaVideojuego);
                    break;
                case "8":
                    System.out.println("Ingrese el DNI del usuario:");
                    String dniUsuario = scanner.nextLine();
                    System.out.println("Ingrese el serial del juego:");
                    String serialJuego = scanner.nextLine();
                    Compras.registrarCompra(rutaCompras, dniUsuario, serialJuego);
                    break;

                case "9":
                    Juegos.mostrarLista(rutaVideojuego);
                    break;
                case "10":
                    Compras.mostrarCompras(rutaCompras);
                    break;
                case "11":
                    System.out.println("¡Gracias por usar el menú!");
                    break;
                default:
                    System.out.println("Opción incorrecta, por favor elige otra.");
                    break;
            }
        }
        scanner.close();
    }
}
