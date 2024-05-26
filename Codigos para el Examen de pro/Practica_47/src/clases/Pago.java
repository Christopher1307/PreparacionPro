package clases;

/**
 * Clase que almacena los datos de un pago realizado por un proveedor
 * @author Jonathan Gutiérrez Riego
 */
public class Pago {
	
	/** Identificador del pago  */
	protected String id_pago;
	/** Identificador de la carta de nulidad */
	protected String id_nulidad;
	/** Importe del pago que  */
	protected double importe;
	/** Fecha en la que se realizo el pago */
	protected String fecha_pago;
	/** ID representativa del producto que se compro */
	protected String id_producto;
	
	
	/**
	 * Constructor de un pago relizado a un proveedor.
	 */
	public Pago(String _id_pago, String _importe, String _fecha_pago, String _id_producto, String _id_nulidad) {
		this.id_pago = _id_pago;
		this.importe = this.StringToInt(_importe);
		this.fecha_pago = _fecha_pago;
		this.id_producto = _id_producto;
		this.id_nulidad = _id_nulidad;
	}
	
	/**
	 * Función que convierte el importe, que es una string, en un double que podremos manipular
	 * @param importe_string Valor del importe en formato String del txt
	 * @return valor del importe convertido en un double
	 */
	public double StringToInt(String importe_string) {
		String sin_formato = importe_string.replaceAll("\\.", "").replace(",", "."); // Cambiamos el formato para quitar los puntos y para cambiar las comas de los decimales por un punto
		double importe = Double.parseDouble(sin_formato); //Convertimos ya el double con el formato correcto.
		return importe;
	}
	
  /**
   * Getter del atributo id_pago.
   * @return El valor del atributo id_pago.
   */
  public String GetId_pago() {
    return this.id_pago;
  }

  /**
   * Getter del atributo importe.
   * @return El valor del atributo importe.
   */
  public double GetImporte() {
    return this.importe;
  }

  /**
   * Getter del atributo fecha_pago.
   * @return El valor del atributo fecha_pago.
   */
  public String GetFecha_pago() {
    return this.fecha_pago;
  }

  /**
   * Getter del atributo id_producto.
   * @return El valor del atributo id_producto.
   */
  public String GetId_producto() {
    return this.id_producto;
  }
  
  /**
   * Getter del atributo id de la nulidad.
   * @return El valor del id de la nulidad.
   */
  public String GetIdNulidad() {
    return this.id_nulidad;
  }
  
	
}
