package clases;
import java.util.Vector;

/**
 * Declaración de la clase proveedor que almacena los datos que serán recogidos del txt de cada empresa
 * @author Jonathan Gutiérrez Riego
 */
public class Proveedor {
  
	/** Identificador del proveedor que nos vende el material */
	protected String id_proveedor; //La cogeremos cuando estemos haciendo la nulidad
	/** Apellido del contacto. */
	protected String apellido_contacto;
	/** Nombre del contacto. */
	protected String nombre_contacto;
	/** Nombre del proveedor */
	protected String nombre_proveedor;
	/** Emails del contacto. */
	protected String emails;
	/** Conjunto de pagos de un proveedor. */
	protected Vector<Pago> pagos;
	/** Valor que define si el total de pagos está dentro del rango legal o no. */
	protected boolean legal;
	/** Total de todos los pagos que se han realizado */
	protected double total;
	
	/**
	 * Constructor predeterminado del objeto con los atributos vacíos.
	 */
	public Proveedor() {
		this.pagos = new Vector<>();
	}
  
	/**
   * Constructor con todos los parámetros que definen una proveedor. Estos proveedores vienen definidos en la carta de nulidad de cada empresa
   */
  public Proveedor(String _id_proveedor, String _apellido_contacto, String _nombre_contacto, String _nombre_proveedor, String _emails, Vector<Pago> _pagos) {
    this.id_proveedor = _id_proveedor;
  	this.apellido_contacto = _apellido_contacto;
    this.nombre_contacto = _nombre_contacto;
    this.nombre_proveedor = _nombre_proveedor;
    this.pagos = new Vector<>();
    this.emails = _emails;
    this.pagos = _pagos;
  }

  /**
   * Getter de apellido_contacto
   * @return El atributo apellido_contacto del proveedor
   */
  protected String GetApellidoContacto() {
    return this.apellido_contacto;
  }

  /**
   * Getter de nombre_contacto
   * @return El atributo nombre_contacto del proveedor
   */
  protected String GetNombreContacto() {
    return this.nombre_contacto;
  }

  /**
   * Getter de nombre_proveedor
   * @return El atributo nombre_proveedor del proveedor
   */
  public String GetNombreProveedor() {
    return this.nombre_proveedor;
  }

  /**
   * Getter de los emails
   * @return El atributo emails del proveedor
   */
  public String GetEmail() {
    return this.emails;
  }
  
  /**
   * Getter del vector de pagos
   * @return Vector que contiene todos los pagos de un proveedor en una nulidad
   */
  protected Vector<Pago> GetPagos() {
  	return this.pagos;
  }
  
  /**
   * Total de las compras que se han realizado a este proveedor
   * @return double con todo el dinero que se la ha dado al proveedor
   */
  protected double GetTotal() {
  	return this.total;
  }
  
  /**
   * Setter del apellido del contacto.
   * @param apellido_contacto El nuevo valor del apellido del contacto.
   */
  protected void SetApellidoContacto(String apellido_contacto) {
    this.apellido_contacto = apellido_contacto;
  }

  /**
   * Setter del nombre del contacto.
   * @param nombre_contacto El nuevo valor del nombre del contacto.
   */
  protected void SetNombreContacto(String nombre_contacto) {
    this.nombre_contacto = nombre_contacto;
  }

  /**
   * Setter del nombre del proveedor.
   * @param nombre_proveedor El nuevo valor del nombre del proveedor.
   */
  public void SetNombreProveedor(String nombre_proveedor) {
    this.nombre_proveedor = nombre_proveedor;
  }

  /**
   * Setter de los emails.
   * @param emails El nuevo valor de los emails.
   */
  protected void SetEmail(String emails) {
    this.emails = emails;
  }
  
  /**
   * Setter del id del proveedor.
   * @param id_proveedor El nuevo valor del id del proveedor.
   */
  protected void SetId(String id_proveedor) {
    this.id_proveedor = id_proveedor;
  }
  
  /**
   * Setter del vector de pagos de un proveedor
   * @param pagos Vector de todos los pagos que se le van a realizar a un proveedor
   */
  protected void SetPagos(Vector<Pago> pagos) {
  	this.pagos = pagos;
  }
 
  
  /**
   * Analiza el total de todos los pagos que se han realizado para estimar si la nulidad debe ser aceptada o no
   */
  protected void SetLegal() {
  	double total = 0;
  	for (Pago pagos : this.pagos) {
  		total += pagos.importe;
  	}
  	if (total < 75000) {
  		this.legal = true;
  	} else {
  		this.legal = false;
  	}
  	this.total = total;
  }
  


}
