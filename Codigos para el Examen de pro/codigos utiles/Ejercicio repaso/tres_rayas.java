
public class tres_rayas {
  
  static class Tablero {
    private char[][] tablero = new char[3][3];

    public Tablero() {
      for(int i = 0; i < 3; i++) {
        for(int j = 0; j < 3; j++) {
          this.tablero[i][j] = ' ';
        }
      }
    }

    public char[][] GetTablero() {
      return this.tablero;
    }

    public void SetValor(int fila, int columna, char valor) {
      this.tablero[fila][columna] = valor;
    }

    public void ImprimirTablero() {
      char[][] mi_tablero = this.GetTablero();
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
          System.out.print( "|" + mi_tablero[i][j] + "|");
        }
        System.out.print("\n---------\n");  
      }
    }
    
  }
  public static void main(String[] args) {
    Tablero prueba = new Tablero();
    prueba.ImprimirTablero();
  }
}
