public class Inversion {
  
  public static void NumeroInvertido(int num) {
    // La condición de parada especifica que será el último dígito del número, en cuyo caso simplemente lo imprimiremos y habremos acabado
    if (num / 10 == 0) {
      System.out.print(num);
    } else {
    // Imprimimos el siguiente dígito ya que la solución del resto de la división entre 10 será el siguiente dígito por recortar
      System.out.print(num % 10);
    // Recortamos el número dividiéndolo entre 10 para eliminar uno de los dígitos y llamamos recursivamente
      NumeroInvertido(num / 10);
    }
  } 

  public static void main(String[] args) {
    // Le pasaremos la variable num a la función y esta nos imprimira dicho numero al revés
    int num = 123;
    NumeroInvertido(num);
  }
}
