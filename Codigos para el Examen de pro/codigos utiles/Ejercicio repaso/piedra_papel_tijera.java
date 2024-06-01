import java.util.Random;
import java.util.Scanner;

public class piedra_papel_tijera {
  
  static class Jugador {
    private String eleccion;
    private int victorias = 0;

    // No necesitaremos un constructor como tal ya que los metodos trabajaran con los atributos
    public Jugador(){
    }
    
    // Generaremos una eleccion aleatoria y la asignaremos a su correspondiente
    public void SetEleccion() {
      Random random = new Random();
      int eleccion = random.nextInt(3) + 1;
      // Piedra = 1, Papel = 2, Tijera = 3
      if (eleccion == 1) {
        this.eleccion = "Piedra";
      }
      if (eleccion == 2) {
        this.eleccion = "Papel";
      }
      if (eleccion == 3) {
        this.eleccion = "Tijera";
      }
    }

    public String GetEleccion() {
      return this.eleccion;
    }

    public void IncrementVictoria() {
      this.victorias++;
    }

    public int GetVictorias() {
      return this.victorias;
    }
  }

  public static void Lucha(Jugador jugador1, Jugador jugador2) {
    jugador1.SetEleccion();
    jugador2.SetEleccion();
    System.out.print("Jugador 1:" + jugador1.GetEleccion() + "\n");
    System.out.print("Jugador 2:" + jugador2.GetEleccion() + "\n");

    // Miramos la opcion del jugador 1 y la comparamos con todas las posibilidades del jugador 23 condiciones
    switch (jugador1.GetEleccion()) {
      case "Piedra":
      if (jugador2.GetEleccion() == "Piedra") {
        System.out.print("Empate, nadie gana ;(\n");
      }
      if (jugador2.GetEleccion() == "Papel") {
        System.out.print("Jugador 2 gana\n");
        jugador2.IncrementVictoria();
      }
      if (jugador2.GetEleccion() == "Tijera") {
        System.out.print("Jugador 1 gana\n");
        jugador1.IncrementVictoria();
      }
      break;

      case "Papel":
      if (jugador2.GetEleccion() == "Piedra") {
        System.out.print("Jugador 1 gana\n");
        jugador1.IncrementVictoria();
      }
      if (jugador2.GetEleccion() == "Papel") {
        System.out.print("Empate, nadie gana ;(\n");
      }
      if (jugador2.GetEleccion() == "Tijera") {
        System.out.print("Jugador 2 gana\n");
        jugador2.IncrementVictoria();
      }
      break;

      case "Tijera":
      if (jugador2.GetEleccion() == "Piedra") {
        System.out.print("Jugador 2 gana\n");
        jugador2.IncrementVictoria();
      }
      if (jugador2.GetEleccion() == "Papel") {
        System.out.print("Jugador 1 gana\n");
        jugador1.IncrementVictoria();
      }
      if (jugador2.GetEleccion() == "Tijera") {
        System.out.print("Empate, nadie gana ;(\n");
      }
      break;
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // Creamos las variables necesarias para empezar el juego, como la opcion de salir y los dos jugadores
    int salida = 0;
    Jugador jugador1 = new Jugador();
    Jugador jugador2 = new Jugador();
    while (salida != 3) {
      // Mostramos el menu
      System.out.println();
      System.out.print("1. Luchar\n");
      System.out.print("2. Mostrar victorias\n");
      System.out.print("3. Salir\n");
      int opcion = scanner.nextInt();
      // switch para comprobar la opcion elegida y hacer lo correcto
      switch (opcion) {
        case 1:
          Lucha(jugador1, jugador2);
          break;

        case 2:
          System.out.print("Jugador 1: " + jugador1.GetVictorias() + "\n");
          System.out.print("Jugador 2: " + jugador2.GetVictorias() + "\n");
          break;

        case 3:
          salida = 3;
          break;
        
        default:
          System.out.print("Opcion fuera de rango\n");
      }
    }
    System.out.print("ADIOOOOOOS");
    scanner.close();
  }
}
