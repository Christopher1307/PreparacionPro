public class suma {
  private static final int NUM_MAX = 100;
  private static final int NUM_MIN = 1;
  // Por lo que busque las variables en java se declaran con final
  public static int sumatorio(int numero, int sumatorio) {
    if (numero <= NUM_MAX) {
      return sumatorio;
    } else {
      sumatorio += numero;
      sumatorio(numero + 1, sumatorio);
    }
  }
  public static void main(String[] args) {
    int numero = NUM_MIN;
    int sumatorio = 0;
    sumatorio(numero, sumatorio);
    System.out.print(sumatorio(numero, sumatorio));
  }
}
