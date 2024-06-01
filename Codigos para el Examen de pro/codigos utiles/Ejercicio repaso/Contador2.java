public class Contador2 {
  
  private static final int NUM_MAX = 100;
  private static final int NUM_MIN = 1;
  // Por lo que busque las variables en java se declaran con final
  public static void ImprimirNumeros(final int NUM_MIN) {
    if (NUM_MIN <= NUM_MAX) {
      // Tendremos que llamar la funcion primero para que llegue NUM_MIN hasta NUM_MAX, y ya teniendo
      // ese valor imprimirá hacia abajo disminuyendo hasta volver a ser el valor inicial de NUM_MIN
      ImprimirNumeros(NUM_MIN + 1); 
      System.out.print(NUM_MIN + " ");
    }
  }
  public static void main(String[] args) {
    ImprimirNumeros(NUM_MIN);
  }
}
